package cn.hxzy.entity;


public class BlogHtml {

  private Integer id;
  private Integer blog_id;
  private String html;

  public BlogHtml() {
  }

  @Override
  public String toString() {
    return "BlogHtml{" +
            "id=" + id +
            ", blog_id=" + blog_id +
            ", html='" + html + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Integer getBlog_id() {
    return blog_id;
  }

  public void setBlog_id(Integer blog_id) {
    this.blog_id = blog_id;
  }

  public String getHtml() {
    return html;
  }

  public void setHtml(String html) {
    this.html = html;
  }

  public BlogHtml(Integer id, Integer blog_id, String html) {
    this.id = id;
    this.blog_id = blog_id;
    this.html = html;
  }
}
