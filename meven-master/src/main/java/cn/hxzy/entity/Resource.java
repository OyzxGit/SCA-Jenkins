package cn.hxzy.entity;


import java.util.Date;

public class Resource {

  private Integer id;
  private Integer pid;
  private String name;
  private String title;
  private String url;
  private String info;
  private Integer orderNumber;
  private Date createTime;
  private Date updateTime;

  @Override
  public String toString() {
    return "Resource{" +
            "id=" + id +
            ", pid=" + pid +
            ", name='" + name + '\'' +
            ", title='" + title + '\'' +
            ", url='" + url + '\'' +
            ", info='" + info + '\'' +
            ", orderNumber=" + orderNumber +
            ", createTime=" + createTime +
            ", updateTime=" + updateTime +
            '}';
  }

  public Resource() {
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getPid() {
    return pid;
  }

  public void setPid(Integer pid) {
    this.pid = pid;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Integer getOrderNumber() {
    return orderNumber;
  }

  public void setOrderNumber(Integer orderNumber) {
    this.orderNumber = orderNumber;
  }

  public Date getCreateTime() {
    return createTime;
  }

  public void setCreateTime(Date createTime) {
    this.createTime = createTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Resource(Integer id, Integer pid, String name, String title, String url, String info, Integer orderNumber, Date createTime, Date updateTime) {
    this.id = id;
    this.pid = pid;
    this.name = name;
    this.title = title;
    this.url = url;
    this.info = info;
    this.orderNumber = orderNumber;
    this.createTime = createTime;
    this.updateTime = updateTime;
  }
}
