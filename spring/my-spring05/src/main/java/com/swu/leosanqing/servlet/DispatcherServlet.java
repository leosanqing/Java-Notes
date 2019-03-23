package com.swu.leosanqing.servlet;

import com.swu.leosanqing.annotation.*;
import com.swu.leosanqing.controller.PersonController;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DispatcherServlet extends HttpServlet {
    List<String> classNames = new ArrayList<String>();

    //用来存放 实例的映射
    Map<String,Object> beans = new HashMap<String, Object>();

    // 存放路径映射
    Map<String,Object> handlerMap = new HashMap<String, Object>();

    /**
     * tomcat 启动的时候 实例化map，以及ioc
     * @throws ServletException
     */
    @Override
    public void init(ServletConfig config) throws ServletException {

        //1.扫描
        //  这里的路径写死了，本来是通过配置文件加载的，不过这个不重要
        basePackageScan("com.swu");

        //2.实例化
        doInstance();

        //3.注入
        doAutowired();
        
        //4.建立地址映射关系
        doUrlMapping();
    }

    /**
     * 先拿类上的路径，再拿方法的路径
     */
    private void doUrlMapping() {
        for (Map.Entry<String,Object> entry : beans.entrySet()){
            // 得到实例对象
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();
            if(clazz.isAnnotationPresent(MyController.class)){
                // 1.获取类的路径
                MyRequestMapping mapping1 = clazz.getAnnotation(MyRequestMapping.class);
                String classPath = mapping1.value();


                // 2.获取方法的路径
                Method[] methods = clazz.getMethods();
                for (Method method:
                     methods) {
                    if (method.isAnnotationPresent(MyRequestMapping.class)){
                        MyRequestMapping mapping2 = method.getAnnotation(MyRequestMapping.class);
                        String methodPath = mapping2.value();


                        String requestMapping = classPath + methodPath;
                        handlerMap.put(requestMapping,method);

                    }

                }
            }

        }
    }


    /**
     *  属性注入
     */

    private void doAutowired() {
         for (Map.Entry<String,Object> entry : beans.entrySet()){

            //得到实例对象
            Object instance = entry.getValue();
            Class<?> clazz = instance.getClass();

            // 找到控制类，因为只有控制类中有 Autowired
            if (clazz.isAnnotationPresent(MyController.class)){
                // 获取所有成员变量
                Field[] fields = clazz.getDeclaredFields();

                for (Field field :fields){
                    // 如果为真，说明 成员变量上标明了 MyAutowired 注解
                    if(field.isAnnotationPresent(MyAutowired.class)){
                        // 拿到注解
                        MyAutowired auto = field.getAnnotation(MyAutowired.class);
                        // 拿到注解的value
                        String key = auto.value();
                        // 由 注解的value 拿到 beans中的值
                        Object bean = beans.get(key);

                        // 更改权限，因为他是私有的属性
                        field.setAccessible(true);
                        
                        try {
                            // 注入属性
                            field.set(instance,bean);
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }

                    }
                }
            }
        }
    }

    /**
     * 实例化
     */
    private void doInstance() {

        for (String className : classNames){
            // 获取到类名
            String cn = className.replace(".class", "");

            try {
                //利用反射,搞到他的字节码

                Class<?> clazz = Class.forName(cn);
                // 说明是控制类
                if(clazz.isAnnotationPresent(MyController.class)){
                    // 创建实例对象
                    Object instance = clazz.newInstance();

                    //因为他要存放进 map中，value 就是上面的实例对象，
                    // key 在本次中是使用注解的 value（但是在spring中，他是用的是类名小写作为key）

                    // 获取到 MyRequestMapping 注解
                    MyRequestMapping mapping =  clazz.getAnnotation(MyRequestMapping.class);
                    // 把传入的 value 作为 key
                    String  key = mapping.value();

                    // 将 map 存入 ioc容器
                    beans.put(key,instance);

                    // 说明是服务类
                }else if(clazz.isAnnotationPresent(MyService.class)){
                    Object instance = clazz.newInstance();
                    MyService mapping = clazz.getAnnotation(MyService.class);
                    String key = mapping.value();

                    beans.put(key,instance);

                }
                else{
                    continue;
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private void basePackageScan(String basePackage) { // basePackage == "com.swu"


        // 拿到类路径
        URL url = this.getClass().getClassLoader().getResource("/" + basePackage.replaceAll("\\.", "/"));

        // 把路径对象转为字符串
        String fileStr = url.getFile();

        // 将文件路径名转为文件对象
        File  file=new File(fileStr);
        // 拿到文件对象 下的所有文件名
        String[] filesStr = file.list();

        for(String path : filesStr){
            // 文件全路径 fileStr+path 获取到文件
            File filePath = new File(fileStr+path);

            // 判断是否为文件夹
            if(filePath.isDirectory()){
                // 如果是文件夹，递归
                basePackageScan((basePackage +"."+ path));
            }else {

                // 得到的是类似于 com.swu.leosanqing.person.class 这种格式

                //将文件的绝对路径加入 list
                classNames.add(basePackage + "." + filePath.getName());
            }

        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uri = req.getRequestURI();
        String context = req.getContextPath();
        String  path = uri.replace(context,"");

        Method method = (Method) handlerMap.get(path);
        PersonController instance = (PersonController) beans.get("/" + path.split("/")[1]);


        Object[] args = hand(req,resp,method);
        try {
            method.invoke(instance,args);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }




    private  static Object[] hand(HttpServletRequest request,HttpServletResponse response,Method method){
        // 获取到当前执行方法有哪些参数
        Class<?>[] paramClazzs = method.getParameterTypes();
        // 根据参数的数组长度创建，将方法的所有参数f复制到该数组中
        Object args[] = new Object[paramClazzs.length];

        int args_i = 0;
        int index = 0;

        for (Class<?> paramClazz :
                paramClazzs) {
            if (ServletRequest.class.isAssignableFrom(paramClazz)){
                args[args_i ++] = request;
            }
            if(ServletResponse.class.isAssignableFrom(paramClazz)){
                args[args_i ++] = response;
            }

            Annotation[] paramAns = method.getParameterAnnotations()[index];
            if (paramAns.length > 0){
                for (Annotation paramAn :
                        paramAns ) {
                    if (MyRequestParam.class.isAssignableFrom(paramAn.getClass())){
                        MyRequestParam rm = (MyRequestParam) paramAn;
                        args[args_i++] = request.getParameter(rm.value());
                    }
                    
                }
            }
            index++;
        }


        return args;
    }


}
