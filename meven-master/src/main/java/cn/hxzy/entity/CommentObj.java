package cn.hxzy.entity;


import java.util.Date;
import java.util.List;
import java.util.Objects;

public class CommentObj {

  private Integer id;
  private Integer blogId;
  private Integer parentId;
  private String content;
  private User   user;
  private Date creteTime;
  private Integer status;
  private List<Comment> li;

  @Override
  public String toString() {
    return "CommentObj{" +
            "id=" + id +
            ", blogId=" + blogId +
            ", parentId=" + parentId +
            ", content='" + content + '\'' +
            ", user=" + user +
            ", creteTime=" + creteTime +
            ", status=" + status +
            ", li=" + li +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    CommentObj that = (CommentObj) o;
    return Objects.equals(id, that.id) &&
            Objects.equals(blogId, that.blogId) &&
            Objects.equals(parentId, that.parentId) &&
            Objects.equals(content, that.content) &&
            Objects.equals(user, that.user) &&
            Objects.equals(creteTime, that.creteTime) &&
            Objects.equals(status, that.status) &&
            Objects.equals(li, that.li);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, blogId, parentId, content, user, creteTime, status, li);
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBlogId() {
    return blogId;
  }

  public void setBlogId(Integer blogId) {
    this.blogId = blogId;
  }

  public Integer getParentId() {
    return parentId;
  }

  public void setParentId(Integer parentId) {
    this.parentId = parentId;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public Date getCreteTime() {
    return creteTime;
  }

  public void setCreteTime(Date creteTime) {
    this.creteTime = creteTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public List<Comment> getLi() {
    return li;
  }

  public void setLi(List<Comment> li) {
    this.li = li;
  }

  public CommentObj(Integer id, Integer blogId, Integer parentId, String content, User user, Date creteTime, Integer status, List<Comment> li) {
    this.id = id;
    this.blogId = blogId;
    this.parentId = parentId;
    this.content = content;
    this.user = user;
    this.creteTime = creteTime;
    this.status = status;
    this.li = li;
  }

  public CommentObj(Integer blogId, Integer parentId, String content, User user, Date creteTime, Integer status, List<Comment> li) {
    this.blogId = blogId;
    this.parentId = parentId;
    this.content = content;
    this.user = user;
    this.creteTime = creteTime;
    this.status = status;
    this.li = li;
  }

  public CommentObj() {
  }
}
