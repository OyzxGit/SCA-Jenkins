package cn.hxzy.entity;


import java.util.Date;
import java.util.Objects;

public class Comment {

  private Integer id;
  private Integer blogId;
  private Integer parentId;
  private String content;
 private  Integer userId;
  private Date creteTime;
  private Integer status;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", blogId=" + blogId +
                ", parentId=" + parentId +
                ", content='" + content + '\'' +
                ", userId=" + userId +
                ", creteTime=" + creteTime +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comment comment = (Comment) o;
        return Objects.equals(id, comment.id) &&
                Objects.equals(blogId, comment.blogId) &&
                Objects.equals(parentId, comment.parentId) &&
                Objects.equals(content, comment.content) &&
                Objects.equals(userId, comment.userId) &&
                Objects.equals(creteTime, comment.creteTime) &&
                Objects.equals(status, comment.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, blogId, parentId, content, userId, creteTime, status);
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

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    public Comment(Integer blogId, Integer parentId, String content, Integer userId, Date creteTime, Integer status) {
        this.blogId = blogId;
        this.parentId = parentId;
        this.content = content;
        this.userId = userId;
        this.creteTime = creteTime;
        this.status = status;
    }

    public Comment(Integer id, Integer blogId, Integer parentId, String content, Integer userId, Date creteTime, Integer status) {
        this.id = id;
        this.blogId = blogId;
        this.parentId = parentId;
        this.content = content;
        this.userId = userId;
        this.creteTime = creteTime;
        this.status = status;
    }

    public Comment() {
  }
}
