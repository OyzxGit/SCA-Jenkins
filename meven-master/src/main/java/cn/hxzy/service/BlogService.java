package cn.hxzy.service;

import cn.hxzy.dao.BlogDao;
import cn.hxzy.entity.Blog;
import cn.hxzy.entity.vo.PageObj;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BlogService {
            private BlogDao blogDao =new BlogDao();

    public Integer add(Blog blog) throws Exception {
        blog.setCreteTime(new Date());

        if (blog.getId() != null){
            blogDao.update(blog);
            return null;
        }else {
            Integer blogId = blogDao.addId(blog);
            return blogId;
        }

    }

    public void update(Blog blog) throws Exception {
        blogDao.update(blog);
    }
    public void deleteById(int id) throws Exception {
        blogDao.delete(id);
    }

    public PageObj<Blog> findAll(PageObj<Blog> page, String name) throws Exception {
        if (name != null && name != "") {
            List<Blog> all = blogDao.findByNameLike(page.getPage(), page.getSize(), name);
            page.setList(all);
            long count = blogDao.countByNameLike(name);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
        }

        List<Blog> all = blogDao.findAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = blogDao.countAll();
        page.setCount(count);

        Integer size = page.getSize();
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        page.setPageCount((int) pageCount);
        return page;
    }

    public Blog findById(Integer id) throws Exception {
        return blogDao.findById(id);
    }

    public PageObj<Blog> findByIdAll(PageObj<Blog> page, Integer i) throws SQLException {
            List<Blog> all = blogDao.findByIdLike(page.getPage(), page.getSize(), i);
            page.setList(all);
            long count = blogDao.countByIdLike(i);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
    }

    public List<Blog> findByUserBlog(Integer userId) throws SQLException {
        List<Blog> li =blogDao.findByUserBlog(userId);
        return li;
    }

    public void  updateColl(int blogId,int topCount) throws SQLException {
        blogDao.updateColl(blogId,topCount);
    }

    public List<String> findAllImg() throws SQLException {
        List<String> li = blogDao.findAllImg();
        return li;
    }


    public void updateStatus(int blogId) throws SQLException {
        blogDao.updateStatus(blogId);
    }
}
