package cn.hxzy.dao;



import cn.hxzy.entity.ContactUs;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactUsDao extends BaseDao<ContactUs> {


    public List<ContactUs> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from contactUs u left join role r on u.role_id=r.id limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<ContactUs> list = new ArrayList<>();
        while (resultSet.next()) {
            ContactUs contactUs = new ContactUs(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getInt("User_id"), resultSet.getString("true_name"), resultSet.getDate("crete_time"), resultSet.getString("context"), resultSet.getInt("tel"));
            list.add(contactUs);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public ContactUs findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from contactUs u left join role r on r.id=u.role_id where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        ContactUs contactUs = null;
        if (resultSet.next()) {
            contactUs = new ContactUs(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getInt("User_id"), resultSet.getString("true_name"), resultSet.getDate("crete_time"), resultSet.getString("context"), resultSet.getInt("tel"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return contactUs;
    }

    public List<ContactUs> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from contactUs u left join role r on r.id=u.role_id where  u.name like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<ContactUs> list = new ArrayList<>();
        while (resultSet.next()) {
            ContactUs contactUs = new ContactUs(resultSet.getInt("id"), resultSet.getString("email"), resultSet.getInt("User_id"), resultSet.getString("true_name"), resultSet.getDate("crete_time"), resultSet.getString("context"), resultSet.getInt("tel"));
            list.add(contactUs);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where name like ?", new Object[]{"%" + name + "%"}, ContactUs.class);
        DataSource.closeConnection(connection);
        return count;
    }
}
