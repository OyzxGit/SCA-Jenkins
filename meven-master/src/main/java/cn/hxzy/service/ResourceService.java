package cn.hxzy.service;

import cn.hxzy.dao.ResourceDao;
import cn.hxzy.entity.Blog;
import cn.hxzy.entity.Resource;
import cn.hxzy.entity.vo.PageObj;

import java.util.Date;
import java.util.List;

public class ResourceService {
            private ResourceDao resourceDao =new ResourceDao();

    public void  add(Resource resource) throws Exception {
        resourceDao.add(resource);
    }

    public void update(Resource resource) throws Exception {
        resourceDao.update(resource);
    }
    public void deleteById(int id) throws Exception {
        resourceDao.delete(id);
    }

    public PageObj<Resource> findAll(PageObj<Resource> page, String name) throws Exception {
        if (name != null && name != "") {
            List<Resource> all = resourceDao.findByNameLike(page.getPage(), page.getSize(), name);
            page.setList(all);
            long count = resourceDao.countByNameLike(name);
            page.setCount(count);

            Integer size = page.getSize();
            long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
            page.setPageCount((int) pageCount);
            return page;
        }

        List<Resource> all = resourceDao.findAll(page.getPage(), page.getSize());
        page.setList(all);
        long count = resourceDao.countAll();
        page.setCount(count);

        Integer size = page.getSize();
        long pageCount = count % size == 0 ? (count / size) : (count / size + 1);
        page.setPageCount((int) pageCount);
        return page;
    }

    public Resource findById(Integer id) throws Exception {
        return resourceDao.findById(id);
    }

}
