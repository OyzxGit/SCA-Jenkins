package cn.hxzy.service;

import cn.hxzy.dao.CommentDao;
import cn.hxzy.dao.UserDao;
import cn.hxzy.entity.Comment;
import cn.hxzy.entity.CommentObj;
import cn.hxzy.entity.User;
import cn.hxzy.entity.vo.PageObj;

import java.sql.SQLException;
import java.util.*;

public class CommentService {
            private CommentDao commentDao =new CommentDao();
            private UserDao  userDao = new UserDao();

    public void  add(Comment comment) throws Exception {
        comment.setCreteTime(new Date());
        commentDao.add(comment);
    }

    public void update(Comment comment) throws Exception {
        commentDao.update(comment);
    }
    public void deleteById(int id) throws Exception {
        commentDao.delete(id);
    }

    public PageObj<Comment> findAll(PageObj<Comment> page, String name) throws Exception {
        if (name != null && name != "") {
            List<Comment> all = commentDao.findByNameLike(page.getPage(), page.getSize(), name);
            page.setList(all);
            long count = commentDao.countByNameLike(name);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
        }

        List<Comment> all = commentDao.findAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = commentDao.countAll();
        page.setCount(count);

        Integer size = page.getSize();
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        page.setPageCount((int) pageCount);
        return page;
    }

    public Comment findById(Integer id) throws Exception {
        return commentDao.findById(id);
    }

    public List<CommentObj> findCommentBlogById(Integer blogId) throws Exception {
        List<Comment> li = commentDao.findCommentBlogById(blogId);

        List<CommentObj> li2 = new ArrayList<>();

        for (Comment c : li) {
            if (c.getParentId() == 0){
                CommentObj commentObj = new CommentObj();
                commentObj.setBlogId(c.getBlogId());
                commentObj.setId(c.getId());
                commentObj.setParentId(0);
                commentObj.setContent(c.getContent());
                Integer userId = c.getUserId();
                User byId = userDao.findById(userId);
                commentObj.setUser(byId);
                commentObj.setCreteTime(c.getCreteTime());
                commentObj.setStatus(c.getStatus());
               List li1 = addList(li,c.getId());
               commentObj.setLi(li1);
                li2.add(commentObj);
            }
        }
        return li2;
    }

    private List addList(List<Comment> li, Integer id) throws Exception {
        List<CommentObj> li1 = new ArrayList<>();
        for (Comment c : li) {
                if (c.getParentId()== id){
                    CommentObj commentObj = new CommentObj();
                    commentObj.setBlogId(c.getBlogId());
                    commentObj.setId(c.getId());
                    commentObj.setParentId(c.getParentId());
                    commentObj.setContent(c.getContent());
                    Integer userId = c.getUserId();
                    User byId = userDao.findById(userId);
                    commentObj.setUser(byId);
                    commentObj.setCreteTime(c.getCreteTime());
                    commentObj.setStatus(c.getStatus());
                    List lis = addList(li,c.getId());
                    commentObj.setLi(lis);
                    li1.add(commentObj);
                }
        }



        return li1;
    }
}
