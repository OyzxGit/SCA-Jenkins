package cn.hxzy.service;

import cn.hxzy.dao.BlogHtmlDao;
import cn.hxzy.entity.Blog;
import cn.hxzy.entity.BlogHtml;
import cn.hxzy.entity.vo.PageObj;

import java.sql.SQLException;
import java.util.Date;
import java.util.List;

public class BlogHtmlService {
            private BlogHtmlDao blogHtmlDao =new BlogHtmlDao();

    public void  add(BlogHtml blogHtml) throws Exception {

        blogHtmlDao.add(blogHtml);
    }

    public void update(BlogHtml blogHtml) throws Exception {
        blogHtmlDao.update(blogHtml);
    }
    public void deleteById(int id) throws Exception {
        blogHtmlDao.delete(id);
    }

/*    public PageObj<BlogHtml> findAll(PageObj<BlogHtml> page, String name) throws Exception {
        if (name != null && name != "") {
            List<BlogHtml> all = blogHtmlDao.findByNameLike(page.getPage(), page.getSize(), name);
            page.setList(all);
            long count = blogHtmlDao.countByNameLike(name);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
        }

        List<BlogHtml> all = blogHtmlDao.findAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = blogHtmlDao.countAll();
        page.setCount(count);

        Integer size = page.getSize();
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        page.setPageCount((int) pageCount);
        return page;
    }*/

    public BlogHtml findById(Integer id) throws Exception {
        return blogHtmlDao.findById(id);
    }

    public BlogHtml findHtmlById(Integer blogId) throws SQLException {
        return blogHtmlDao.findHtmlById(blogId);
    }


}
