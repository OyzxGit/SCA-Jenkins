package cn.hxzy.dao;



import cn.hxzy.entity.Categories;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CategoriesDao extends BaseDao<Categories> {


    public List<Categories> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from categories u left join role r on u.role_id=r.id limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Categories> list = new ArrayList<>();
        while (resultSet.next()) {
            Categories categories = new Categories(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("info"),resultSet.getInt("status"));
            list.add(categories);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public Categories findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from categories u left join role r on r.id=u.role_id where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        Categories categories = null;
        if (resultSet.next()) {
            categories = new Categories(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("info"),resultSet.getInt("status"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return categories;
    }

    public List<Categories> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from categories u left join role r on r.id=u.role_id where  u.name like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<Categories> list = new ArrayList<>();
        while (resultSet.next()) {
            Categories categories = new Categories(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getString("info"),resultSet.getInt("status"));
            list.add(categories);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where name like ?", new Object[]{"%" + name + "%"}, Categories.class);
        DataSource.closeConnection(connection);
        return count;
    }
}
