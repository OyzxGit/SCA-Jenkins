package cn.hxzy.service;

import cn.hxzy.dao.UserDao;
import cn.hxzy.entity.User;
import cn.hxzy.entity.vo.PageObj;

import java.util.Date;
import java.util.List;

public class UserService {

    private UserDao userDao =new UserDao();

    public void  add(User user) throws Exception {
        user.setCreteTime(new Date());
        userDao.add(user);
    }

    public void update(User user) throws Exception {
        user.setUpdateTime(new Date());
        userDao.update(user);
    }
    public void deleteById(int id) throws Exception {
        userDao.delete(id);
    }

    public PageObj<User> findAll(PageObj<User> page, String name) throws Exception {
        if (name != null && name != "") {
            List<User> all = userDao.findByNameLike(page.getPage(), page.getSize(), name);
            page.setList(all);
            long count = userDao.countByNameLike(name);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
        }

        List<User> all = userDao.findAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = userDao.countAll();
        page.setCount(count);

        Integer size = page.getSize();
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        page.setPageCount((int) pageCount);
        return page;
    }

    public User findById(Integer id) throws Exception {
        return userDao.findById(id);
    }


    public User login(String loginName, String loginPassword) throws Exception {
        User user = userDao.findByLoginName(loginName);
        if (user != null && user.getLoginPassword().equals(loginPassword)) {
            return user;
        }
        return null;
    }

    public boolean findByLoginName(String name) throws Exception {
        User user = userDao.findByLoginName(name);
        return user == null ? false : true;
    }
}
