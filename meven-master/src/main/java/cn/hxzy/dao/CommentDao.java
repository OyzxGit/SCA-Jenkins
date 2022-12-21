package cn.hxzy.dao;



import cn.hxzy.entity.Comment;
import cn.hxzy.entity.CommentObj;
import cn.hxzy.entity.User;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommentDao extends BaseDao<Comment> {


    public List<Comment> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from comment u left join role r on u.role_id=r.id limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Comment> list = new ArrayList<>();
        while (resultSet.next()) {
            Comment comment = new Comment(resultSet.getInt("id"), resultSet.getInt("blog_id"), resultSet.getInt("parent_id"), resultSet.getString("content"),resultSet.getInt("user_id"),resultSet.getDate("crete_time"),resultSet.getInt("status"));
            list.add(comment);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public Comment findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from comment u left join role r on r.id=u.role_id where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        Comment comment = null;
        if (resultSet.next()) {
            comment = new Comment(resultSet.getInt("id"), resultSet.getInt("blog_id"), resultSet.getInt("parent_id"), resultSet.getString("content"),resultSet.getInt("user_id"),resultSet.getDate("crete_time"),resultSet.getInt("status"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return comment;
    }

    public List<Comment> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from comment u left join role r on r.id=u.role_id where  u.name like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<Comment> list = new ArrayList<>();
        User user = new User();
        int user_id = resultSet.getInt("user_id");
        user.setId(user_id);
        while (resultSet.next()) {
            Comment comment = new Comment(resultSet.getInt("id"), resultSet.getInt("blog_id"), resultSet.getInt("parent_id"), resultSet.getString("content"),resultSet.getInt("user_id"),resultSet.getDate("crete_time"),resultSet.getInt("status"));
            list.add(comment);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where name like ?", new Object[]{"%" + name + "%"}, Comment.class);
        DataSource.closeConnection(connection);
        return count;
    }

    public List<Comment> findCommentBlogById(Integer blogId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select  * from comment where blog_id = ?");    statement.setObject(1,blogId);
        ResultSet resultSet = statement.executeQuery();
        List<Comment> li = new ArrayList<>();

        while (resultSet.next()) {
            Comment comment = new Comment(resultSet.getInt("id"), resultSet.getInt("blog_id"), resultSet.getInt("parent_id"), resultSet.getString("content"),resultSet.getInt("user_id"),resultSet.getDate("crete_time"),resultSet.getInt("status"));
            li.add(comment);
        }
        return li;
    }

}
