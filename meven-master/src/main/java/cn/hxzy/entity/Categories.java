package cn.hxzy.entity;


public class Categories {

  private Integer id;
  private String name;
  private String info;
  private Integer status;

  public Categories() {
  }

  public Categories(Integer id, String name, String info, Integer status) {
    this.id = id;
    this.name = name;
    this.info = info;
    this.status = status;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  @Override
  public String toString() {
    return "Categories{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", info='" + info + '\'' +
            ", status=" + status +
            '}';
  }
}
