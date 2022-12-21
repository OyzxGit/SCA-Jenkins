package cn.hxzy.dao;



import cn.hxzy.entity.Blog;
import cn.hxzy.entity.BlogHtml;
import cn.hxzy.util.DBUtil;
import cn.hxzy.util.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BlogHtmlDao extends BaseDao<BlogHtml> {


  /*  public List<BlogHtml> findAll(int page, int size) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from blog b left join blog_html bh on b.id=bh.blog_id limit ?,?");
        statement.setObject(1, (page - 1) * size);
        statement.setObject(2, size);
        ResultSet resultSet = statement.executeQuery();
        List<BlogHtml> list = new ArrayList<>();
        while (resultSet.next()) {
            BlogHtml bloghtml = new BlogHtml(resultSet.getInt("id"), resultSet.getInt("blog_id"), resultSet.getString("html"));
            list.add(bloghtml);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }*/


   /* public BlogHtml findByLoginName(String loginName) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from bloghtml u left join role r on r.id=u.role_id where login_name =?");
        statement.setObject(1, loginName);
        ResultSet resultSet = statement.executeQuery();
        BlogHtml bloghtml = null;
        if (resultSet.next()) {
            bloghtml = new BlogHtml(resultSet.getInt("id"), resultSet.getInt("blog_id"), resultSet.getString("html"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return bloghtml;
    }*/

   /* public List<BlogHtml> findByNameLike(Integer page, Integer size, String name) throws Exception {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select u.*,r.name role_name from bloghtml u left join role r on r.id=u.role_id where  u.name like ? limit ?,?");
        statement.setObject(1, "%" + name + "%");
        statement.setObject(2, (page - 1) * size);
        statement.setObject(3, size);
        ResultSet resultSet = statement.executeQuery();
        List<BlogHtml> list = new ArrayList<>();
        while (resultSet.next()) {
            BlogHtml bloghtml = new BlogHtml(resultSet.getInt("id"), resultSet.getbl("blog_id"), resultSet.getString("html"));
            list.add(bloghtml);
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return list;
    }*/

   /* public long countByNameLike(String name) throws Exception {
        Connection connection = DataSource.getConnection();
        long count = DBUtil.count(connection, "where name like ?", new Object[]{"%" + name + "%"}, BlogHtml.class);
        DataSource.closeConnection(connection);
        return count;
    }*/

    public BlogHtml findHtmlById(Integer blogId) throws SQLException {
        Connection connection = DataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("select * from blog_html bh inner join  blog b on  bh.blog_id =b.id  where blog_id =?");
        statement.setObject(1, blogId);
        ResultSet resultSet = statement.executeQuery();
        BlogHtml bloghtml = null;
        if (resultSet.next()) {
            Blog blog = new Blog();
            blog.setId(blogId);
            blog.setTitle(resultSet.getString("title"));
            blog.setInfo(resultSet.getString("info"));
            blog.setCategoriesId(resultSet.getInt("categories_id"));
            blog.setImage(resultSet.getString("image"));
            blog.setUserId(resultSet.getInt("user_id"));

            bloghtml = new BlogHtml(resultSet.getInt("id"), blogId, resultSet.getString("html"));
        }
        resultSet.close();
        statement.close();
        DataSource.closeConnection(connection);
        return bloghtml;
    }
}
