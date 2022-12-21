package cn.hxzy.service;

import cn.hxzy.dao.ContactUsDao;
import cn.hxzy.entity.ContactUs;
import cn.hxzy.entity.vo.PageObj;

import java.util.Date;
import java.util.List;

public class ContactUsService {
            private ContactUsDao contactUsDao =new ContactUsDao();

    public void  add(ContactUs contactUs) throws Exception {
        contactUs.setCreteTime(new Date());
        contactUsDao.add(contactUs);
    }

    public void update(ContactUs contactUs) throws Exception {
        contactUsDao.update(contactUs);
    }
    public void deleteById(int id) throws Exception {
        contactUsDao.delete(id);
    }

    public PageObj<ContactUs> findAll(PageObj<ContactUs> page, String name) throws Exception {
        if (name != null && name != "") {
            List<ContactUs> all = contactUsDao.findByNameLike(page.getPage(), page.getSize(), name);
            page.setList(all);
            long count = contactUsDao.countByNameLike(name);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
        }

        List<ContactUs> all = contactUsDao.findAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = contactUsDao.countAll();
        page.setCount(count);

        Integer size = page.getSize();
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        page.setPageCount((int) pageCount);
        return page;
    }

    public ContactUs findById(Integer id) throws Exception {
        return contactUsDao.findById(id);
    }

}
