package cn.hxzy.dao;



import cn.hxzy.entity.Resource;
import cn.hxzy.entity.Resource;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ResourceDao extends BaseDao<Resource> {


    public List<Resource> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from resource u left join role r on u.role_id=r.id limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Resource> list = new ArrayList<>();
        while (resultSet.next()) {
            Resource resource = new Resource(resultSet.getInt("id"), resultSet.getInt("pid"), resultSet.getString("name"), resultSet.getString("title"),resultSet.getString("url"),resultSet.getString("info"),resultSet.getInt("order_number"), resultSet.getTime("create_time"),resultSet.getTime("update_time"));
            list.add(resource);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public Resource findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from resource u left join role r on r.id=u.role_id where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        Resource resource = null;
        if (resultSet.next()) {
            resource = new Resource(resultSet.getInt("id"), resultSet.getInt("pid"), resultSet.getString("name"), resultSet.getString("title"),resultSet.getString("url"),resultSet.getString("info"),resultSet.getInt("order_number"), resultSet.getTime("create_time"),resultSet.getTime("update_time"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return resource;
    }

    public List<Resource> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from resource u left join role r on r.id=u.role_id where  u.name like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<Resource> list = new ArrayList<>();
        while (resultSet.next()) {
            Resource resource = new Resource(resultSet.getInt("id"), resultSet.getInt("pid"), resultSet.getString("name"), resultSet.getString("title"),resultSet.getString("url"),resultSet.getString("info"),resultSet.getInt("order_number"), resultSet.getTime("create_time"),resultSet.getTime("update_time"));
            list.add(resource);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where name like ?", new Object[]{"%" + name + "%"}, Resource.class);
        DataSource.closeConnection(connection);
        return count;
    }
}
