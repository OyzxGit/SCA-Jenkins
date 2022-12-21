package cn.hxzy.entity.vo;

import java.time.Instant;
import java.util.List;

public class PageObj<T> {
    private List<T> list;
    private Integer page = 1;
    private Integer  size = 10;
    private  Long   count;
    private  Integer  PageCount;

    public PageObj() {
    }

    public PageObj(List<T> list, Integer page, Integer size, Long count, Integer pageCount) {
        this.list = list;
        this.page = page;
        this.size = size;
        this.count = count;
        PageCount = pageCount;
    }

    @Override
    public String toString() {
        return "PageObj{" +
                "list=" + list +
                ", page=" + page +
                ", size=" + size +
                ", count=" + count +
                ", PageCount=" + PageCount +
                '}';
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Long getCount() {
        return count;
    }

    public void setCount(Long count) {
        this.count = count;
    }

    public Integer getPageCount() {
        return PageCount;
    }

    public void setPageCount(Integer pageCount) {
        PageCount = pageCount;
    }
}
