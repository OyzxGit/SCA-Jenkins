package cn.hxzy.dao;



import cn.hxzy.entity.Blog;
import cn.hxzy.entity.Blog;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BlogDao extends BaseDao<Blog> {


    public List<Blog> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from blog  limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<Blog> list = new ArrayList<>();
        while (resultSet.next()) {
            Blog blog = new Blog(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("info"), resultSet.getInt("categories_id"), resultSet.getTime("crete_time"),resultSet.getInt("view_count"),resultSet.getInt("top_count"),resultSet.getString("image"),resultSet.getInt("user_id"),resultSet.getInt("status"));
            list.add(blog);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }


    public Blog findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from blog  where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        Blog blog = null;
        if (resultSet.next()) {
            blog = new Blog(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("info"), resultSet.getInt("categories_id"), resultSet.getTime("crete_time"),resultSet.getInt("view_count"),resultSet.getInt("top_count"),resultSet.getString("image"),resultSet.getInt("user_id"),resultSet.getInt("status"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return blog;
    }

    public List<Blog> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from blog  where title like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<Blog> list = new ArrayList<>();
        while (resultSet.next()) {
            Blog blog = new Blog(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("info"), resultSet.getInt("categories_id"), resultSet.getTime("crete_time"),resultSet.getInt("view_count"),resultSet.getInt("top_count"),resultSet.getString("image"),resultSet.getInt("user_id"),resultSet.getInt("status"));
            list.add(blog);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where title like ?", new Object[]{"%" + name + "%"}, Blog.class);
        DataSource.closeConnection(connection);
        return count;
    }

    public List<Blog> findByIdLike(Integer page, Integer size, Integer i) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from blog  where categories_id like ? limit ?,?");
        statement.setObject(1,  i );
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<Blog> list = new ArrayList<>();
        while (resultSet.next()) {
            Blog blog = new Blog(resultSet.getInt("id"), resultSet.getString("title"), resultSet.getString("info"), resultSet.getInt("categories_id"), resultSet.getTime("crete_time"),resultSet.getInt("view_count"),resultSet.getInt("top_count"),resultSet.getString("image"),resultSet.getInt("user_id"),resultSet.getInt("status"));
            list.add(blog);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }

    public long countByIdLike(Integer i) throws SQLException {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where categories_id = ?", new Object[]{ i }, Blog.class);

        return 0;
    }

    public Integer addId(Blog blog) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("insert into blog(title,info,categories_id,crete_time,image,user_id)values (?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
        statement.setString(1,blog.getTitle());
        statement.setString(2,blog.getInfo());
        statement.setInt(3,blog.getCategoriesId());
        statement.setObject(4,blog.getCreteTime());
        statement.setString(5,blog.getImage());
        statement.setInt(6,blog.getUserId());
        statement.executeUpdate();
        ResultSet generatedKeys = statement.getGeneratedKeys();
        Integer key = null;
        while (generatedKeys.next()) {
            key = (int)generatedKeys.getLong(1);
        }

        return key;
    }

    public List<Blog> findByUserBlog(Integer userId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from blog  where user_id = ?");
        statement.setObject(1,  userId );
        ResultSet resultSet = statement.executeQuery();
        List<Blog> li = new ArrayList<>();
        while (resultSet.next()) {
            Blog blog = new Blog();
            blog.setId(resultSet.getInt("id"));
            blog.setTitle(resultSet.getString("title"));
            blog.setInfo(resultSet.getString("info"));
            blog.setCategoriesId(resultSet.getInt("categories_id"));
            blog.setImage(resultSet.getString("image"));
            blog.setUserId(userId);
            blog.setStatus(resultSet.getInt("status"));
            li.add(blog);
        }
        return  li;
    }

    public void updateColl(int blogId,int topCount) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("update blog set top_count=?  where id = ?");
        statement.setObject(1,topCount);
        statement.setObject(2,blogId);
        statement.executeUpdate();
    }

    public List<String> findAllImg() throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select image from blog");
        List<String> li = new ArrayList<>();
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            li.add(resultSet.getString("image"));
        }
        return li;
    }

    public void updateStatus(Integer blogId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select status from blog where id=?");
        statement.setInt(1,blogId);
        ResultSet resultSet = statement.executeQuery();
        Integer status =null;
        if (resultSet.next()) {
             status = resultSet.getInt(1);
        }

        PreparedStatement statement1 = connection.prepareStatement("update blog set status=?  where id=?");
        if (status == 0){
            statement1.setInt(1,1);
            statement1.setInt(2,blogId);
        }else{
            statement1.setInt(1,0);
            statement1.setInt(2,blogId);
        }
        statement1.executeUpdate();


    }
}
