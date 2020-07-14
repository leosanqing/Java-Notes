package com.leosanqing.leetcode.medium.array;

import com.alibaba.fastjson.JSONObject;

import java.lang.reflect.Field;

/**
 * @Author: rtliu
 * @Date: 2020/7/14 下午4:15
 * @Package: com.leosanqing.leetcode.medium.array
 * @Description:
 * @Version:
 */
public class Test {

    /**
     * 数据处理 >> 暂目前只支持int + String两种类型
     * @param jsonObject
     * @param clazz
     * @param <T>
     * @return
     */
    private static <T> T dataHandle(JSONObject jsonObject, Class clazz, String data) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        if (jsonObject != null && jsonObject.containsKey("retCode") && 0 == jsonObject.getInteger("retCode")) {
            JSONObject dataJson = jsonObject.getJSONObject(data);
            Field[] fields = Class.forName(clazz.getClass().getName()).getDeclaredFields();
            T bean = (T) clazz.newInstance();
            for (int i = 0; i < fields.length; i++){
                fields[i].setAccessible(true);
                String fieldName = fields[i].getName();
                System.out.println(fieldName);
                if (fields[i].getGenericType() == String.class) {
                    fields[i].set(String.class,dataJson.getString(fieldName));
                }
                if (fields[i].getGenericType() == Integer.class) {
                    fields[i].set(int.class,dataJson.getIntValue(fieldName));
                }
            }
            return bean;
        }
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("retCode",0);
        JSONObject innerJson = new JSONObject();
        innerJson.put("status",1);
        innerJson.put("statusMsg","运行完成");
        innerJson.put("url","https://www.baidu.com");
        innerJson.put("hash","UUIDUtil.getUuid()");
        jsonObject.put("detail",innerJson);
        TaskEvData task = dataHandle(jsonObject,TaskEvData.class,"detail");
        System.out.println(task);
    }
}
