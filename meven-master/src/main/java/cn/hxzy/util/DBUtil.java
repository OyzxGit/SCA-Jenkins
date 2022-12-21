package cn.hxzy.util;


import java.io.Serializable;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
    /**
     * 查询数量
     *
     * @param connection 数据库连接
     * @param whereSql   sql 的 where 条件 如：where pid =？
     * @param values     sql中？ 填充的值
     * @param c          针对的实体类型
     * @param <T>
     * @return 数据库的数量
     * @throws SQLException
     */
    public static <T> long count(Connection connection, String whereSql, Object[] values, Class<T> c) throws SQLException {
        StringBuffer stringBuffer = new StringBuffer("select count(0) from " + StringUtil.underscoreName(c.getSimpleName()) + " " + whereSql);
        PreparedStatement statement = connection.prepareStatement(stringBuffer.toString());
        System.out.println(stringBuffer);
        if (values != null) for (int i = 0; i < values.length; i++) {
            System.out.println(i + ":" + values[i] + "; ");
            statement.setObject(i + 1, values[i]);
        }
        ResultSet resultSet = statement.executeQuery();
        if (resultSet.next()) {
            long count = resultSet.getLong(1);
            resultSet.close();
            statement.close();
            return count;
        }
        return 0;
    }


    /**
     * 查询集合
     *
     * @param connection 数据库连接
     * @param whereSql   sql 的 where 条件 如：where pid =？
     * @param values     sql中？ 填充的值
     * @param c          针对的实体类型
     * @param <T>
     * @return 对应的对象集合
     * @throws Exception
     */
    public static <T> List<T> select(Connection connection, String whereSql, Object[] values, Class<T> c) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("select ");
        Field[] fields = c.getDeclaredFields();
        //获取类的声明的属性
        for (Field field : fields) {
            stringBuffer.append(StringUtil.underscoreName(field.getName()) + ",");
        }

        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        //删除最后一字符 （，）

        stringBuffer.append(" from " + StringUtil.underscoreName(c.getSimpleName()) + " " + whereSql);


        PreparedStatement statement = connection.prepareStatement(stringBuffer.toString());
        System.out.println(stringBuffer);
        if (values != null) for (int i = 0; i < values.length; i++) {
            System.out.println(i + ":" + values[i] + "; ");
            statement.setObject(i + 1, values[i]);
        }
        //填充？
        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        //ResultSetMetaData 结果集的元数据，就是为了获取结果集里面更详细的信息
        List<T> list = new ArrayList();
        while (resultSet.next()) {
            T obj = c.newInstance();
            //new 一个对应类型的实例（对象） User user=new User()
            //注意：该方法会调用无参构造方法
            int colCount = metaData.getColumnCount();
            //获取到结果集的列数量
            for (int i = 0; i < colCount; i++) {
                String columnName = metaData.getColumnName(i + 1);
                //得到对应的数据库的列的名字
                Field[] fs = c.getDeclaredFields();
                //获取类声明的属性
                AccessibleObject.setAccessible(fs, true);
                //获取最高权限
                for (Field f : fs) {
                    if (StringUtil.underscoreName(f.getName()).equals(columnName.toLowerCase())) {
                        //System.out.println("正在对象"+obj+"的属性："+f.getName()+"的值为："+resultSet.getObject(columnName));
                        f.set(obj, resultSet.getObject(columnName));
                        //直接设置属性的值为数据库查出来的值
                    }
                }
            }
            list.add(obj);
        }
        resultSet.close();
        statement.close();
        return list;
    }


    /**
     * 根据id查询对象
     *
     * @param connection 数据库连接
     * @param id         id的值
     * @param c          类型
     * @param <T>
     * @return 查询到的结果
     * @throws Exception
     */
    public static <T> T selectOne(Connection connection, Serializable id, Class<T> c) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("select ");
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            stringBuffer.append(StringUtil.underscoreName(field.getName()) + ",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);

        stringBuffer.append(" from " + StringUtil.underscoreName(c.getSimpleName()) + " where id =" + id);
        PreparedStatement statement = connection.prepareStatement(stringBuffer.toString());
        System.out.println(stringBuffer);

        ResultSet resultSet = statement.executeQuery();
        ResultSetMetaData metaData = resultSet.getMetaData();
        T obj = null;
        if (resultSet.next()) {
            obj = c.newInstance();
            int colCount = metaData.getColumnCount();
            for (int i = 0; i < colCount; i++) {
                String columnName = metaData.getColumnName(i + 1);
                Field[] fs = c.getDeclaredFields();
                AccessibleObject.setAccessible(fs, true);
                for (Field f : fs) {
                    if (StringUtil.underscoreName(f.getName()).equals(columnName.toLowerCase())) {
                        f.set(obj, resultSet.getObject(columnName));
                    }
                }
            }
        }
        resultSet.close();
        statement.close();
        return obj;
    }


    /**
     * 插入数据库一条数据
     *
     * @param connection 连接
     * @param obj        插入的对象
     * @return 数据库影响行数
     * @throws Exception
     */
    public static int insert(Connection connection, Object obj) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("insert into ");
        Class clazz = obj.getClass();
        //insert into user (id,name,

        stringBuffer.append(StringUtil.underscoreName(clazz.getSimpleName()) + " (");

        Field[] fields = clazz.getDeclaredFields();
        AccessibleObject.setAccessible(fields, true);
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].get(obj) == null)//属性为空的就不插入数据库
                continue;
            String fieldName = fields[i].getName();
            stringBuffer.append(StringUtil.underscoreName(fieldName) + ",");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(") values(");
        List list = new ArrayList();
        //存？填充的值
        for (int i = 0; i < fields.length; i++) {
            if (fields[i].get(obj) == null) {
                continue;
            }
            Object o = fields[i].get(obj);
            //获取obj的当前属性的值
            list.add(o);
            stringBuffer.append(" ?,");
        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(")");
        System.out.println(stringBuffer);
        PreparedStatement statement = connection.prepareStatement(stringBuffer.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i) + "; ");
            statement.setObject(i + 1, list.get(i));
        }
        int count = statement.executeUpdate();
        statement.close();
        return count;
    }


    /**
     * 根据 id 删除对象
     *
     * @param connection 连接
     * @param id         id
     * @param c          类型
     * @param <T>
     * @return 数据库影响行数
     * @throws Exception
     */
    public static <T> int delete(Connection connection, Serializable id, Class<T> c) throws Exception {
        String name = c.getSimpleName();
        StringBuffer stringBuffer = new StringBuffer("delete from ");
        stringBuffer.append(StringUtil.underscoreName(name));
        stringBuffer.append(" where id = ?");
        System.out.println(stringBuffer);
        PreparedStatement statement = connection.prepareStatement(stringBuffer.toString());
        statement.setObject(1, id);
        int count = statement.executeUpdate();
        statement.close();
        return count;
    }


    /**
     * 根据id 修改对象不为空的属性
     *
     * @param connection 连接
     * @param obj        对象
     * @return 数据库影响行数
     * @throws Exception
     */
    public static int update(Connection connection, Object obj) throws Exception {
        StringBuffer stringBuffer = new StringBuffer("update ");
        Class clazz = obj.getClass();
        stringBuffer.append(StringUtil.underscoreName(clazz.getSimpleName()) + " set ");
        Field[] fields = clazz.getDeclaredFields();
        List list = new ArrayList();
        AccessibleObject.setAccessible(fields, true);
        Object id = 0;
        for (int i = 0; i < fields.length; i++) {
            String fieldName = fields[i].getName();
            if (fieldName.equals("id")) {
                id = fields[i].get(obj);
                continue;
            }
            if (fields[i].get(obj) == null) {
                continue;
            }
            list.add(fields[i].get(obj));
            stringBuffer.append(StringUtil.underscoreName(fieldName) + " = ?,");

        }
        stringBuffer.deleteCharAt(stringBuffer.length() - 1);
        stringBuffer.append(" where id = " + id);
        System.out.println(stringBuffer);
        PreparedStatement statement = connection.prepareStatement(stringBuffer.toString());
        for (int i = 0; i < list.size(); i++) {
            System.out.println(i + ":" + list.get(i) + "; ");
            statement.setObject(i + 1, list.get(i));
        }
        int count = statement.executeUpdate();
        statement.close();
        return count;
    }



}
