package cn.hxzy.entity;


import java.util.Date;

public class Blog {

  private Integer id;
  private String title;
  private String info;
  private Integer categoriesId;
  private Date creteTime;
  private Integer viewCount =0;
  private Integer topCount =0;
  private String image;
  private Integer userId;
  private Integer status;

  @Override
  public String toString() {
    return "Blog{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", info='" + info + '\'' +
            ", categoriesId=" + categoriesId +
            ", creteTime=" + creteTime +
            ", viewCount=" + viewCount +
            ", topCount=" + topCount +
            ", image='" + image + '\'' +
            ", userId=" + userId +
            ", status=" + status +
            '}';
  }

  public Blog() {
  }

  public Blog(Integer id, String title, String info, Integer categoriesId, Date creteTime, Integer viewCount, Integer topCount, String image, Integer userId, Integer status) {
    this.id = id;
    this.title = title;
    this.info = info;
    this.categoriesId = categoriesId;
    this.creteTime = creteTime;
    this.viewCount = viewCount;
    this.topCount = topCount;
    this.image = image;
    this.userId = userId;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Integer getCategoriesId() {
    return categoriesId;
  }

  public void setCategoriesId(Integer categoriesId) {
    this.categoriesId = categoriesId;
  }

  public Date getCreteTime() {
    return creteTime;
  }

  public void setCreteTime(Date creteTime) {
    this.creteTime = creteTime;
  }

  public Integer getViewCount() {
    return viewCount;
  }

  public void setViewCount(Integer viewCount) {
    this.viewCount = viewCount;
  }

  public Integer getTopCount() {
    return topCount;
  }

  public void setTopCount(Integer topCount) {
    this.topCount = topCount;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }
}
