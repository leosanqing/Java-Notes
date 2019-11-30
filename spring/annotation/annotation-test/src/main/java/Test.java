import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.*;

/**
 * @Author: leosanqing
 * @Date: 2019-11-22 22:17
 */
public class Test {

    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/guns";
    static final String USER = "root";
    static final String PASS = "root";

    public static void main(String[] args) {
        User user1 = new User();
        user1.setId(1);

        User user2 = new User();
        user2.setAge(22);

        User user3 = new User();
        user3.setEmail("leosanqing@qq.com,pipi@gmail.com,zs@qq.com");


        query(user1);
        query(user2);
        query(user3);

    }

    /**
     * 根据给的值，查询节点
     *
     * @param user
     * @return
     */
    private static String convert2Sql(User user) {
        StringBuilder buffer = new StringBuilder();

        // 获取 User的字节码，便于之后反射获取想要的值
        Class<? extends User> clazz = user.getClass();

        //判断是否存在这个注解
        boolean isExist = clazz.isAnnotationPresent(Table.class);
        if (!isExist) {
            return null;
        }

        // 获得表名
        Table table = clazz.getAnnotation(Table.class);
        String tableName = table.value();

        // where 1 = 1 防止查询语句崩溃
        buffer.append("select * from ").append(tableName).append(" where 1 = 1");

        // 遍历所有的字段，判断是否有值
        // 注意这个 getDeclaredFields 和 getFields的区别。前者不包括继承来的字段
        Field[] fields = clazz.getDeclaredFields();
//        Field[] fields1 = clazz.getFields();

        for (Field field : fields) {
            // 判断是否是数据库中的字段
            boolean fieldExist = field.isAnnotationPresent(Column.class);
            if (!fieldExist) {
                continue;
            }

            Object value = null;
            // 获取字段的get方法，因为get方法都是get+首字母大写的字段名
            String getMethodName = "get" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            try {
                Method method = clazz.getMethod(getMethodName);
                value = method.invoke(user);
            } catch (Exception e) {
                e.printStackTrace();
            }

            // 获取到字段的注解的名字
            Column fieldAnnotation = field.getAnnotation(Column.class);
            String fieldAnnotationName = fieldAnnotation.value();


            // 拼接sql
            // 如果没有获取到值
            if (value == null
                    || (value instanceof Integer && (Integer) value == 0)) {
                continue;
            } else if (value instanceof String) {
                if (((String) value).contains(",")) {
                    String[] strs = ((String) value).split(",");
                    buffer.append(" and ").append(fieldAnnotationName).append(" in (");
                    for (String str : strs) {
                        buffer.append("'").append(str).append("'").append(",");
                    }
                    // 删除最后一个 逗号
                    if (',' == buffer.charAt(buffer.length() - 1)) {
                        buffer.deleteCharAt(buffer.length() - 1);
                    }
                    buffer.append(")");
                } else {
                    buffer.append(" and ").append(fieldAnnotationName).append(" = '").append(value).append(" '");

                }
            } else if (value instanceof Integer) {
                buffer.append(" and ").append(fieldAnnotationName).append(" = ").append(value);

            }

        }
        return buffer.toString();
    }


    private static void query(User user) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // 注册 JDBC 驱动
            Class.forName(JDBC_DRIVER);

            // 打开链接
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // 执行查询
            System.out.println(" 实例化Statement对象...");
            stmt = conn.createStatement();
            String sql = convert2Sql(user);

            ResultSet rs = stmt.executeQuery(sql);

            // 展开结果集数据库
            while (rs.next()) {
                // 通过字段检索
                int id = rs.getInt("id");
                String userName = rs.getString("user_name");
                String nickName = rs.getString("nick_name");
                String age = rs.getString("age");
                String phone = rs.getString("phone");
                String email = rs.getString("email");

                // 输出数据
                System.out.print("ID: " + id);
                System.out.print(", username: " + userName);
                System.out.print(", age: " + age);
                System.out.print(", nickName: " + nickName);
                System.out.print(", phone: " + phone);
                System.out.print(", email: " + email);
                System.out.print("\n");
            }
            // 完成后关闭
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // 处理 JDBC 错误
            se.printStackTrace();
        } catch (Exception e) {
            // 处理 Class.forName 错误
            e.printStackTrace();
        } finally {
            // 关闭资源
            try {
                if (stmt != null) {
                    stmt.close();
                }
            } catch (SQLException ignored) {
            }// 什么都不做
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }

    }
}

