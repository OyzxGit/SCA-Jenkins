package cn.hxzy.entity;


import java.util.Date;

public class User {

  private Integer id;
  private String loginName;
  private String loginPassword;
  private String trueName;
  private Integer tel;
  private String card;
  private String email;
  private String info;
  private Date creteTime;
  private Date updateTime;
  private Integer status;
  private String Img;

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", loginName='" + loginName + '\'' +
            ", loginPassword='" + loginPassword + '\'' +
            ", trueName='" + trueName + '\'' +
            ", tel=" + tel +
            ", card='" + card + '\'' +
            ", email='" + email + '\'' +
            ", info='" + info + '\'' +
            ", creteTime=" + creteTime +
            ", updateTime=" + updateTime +
            ", status=" + status +
            ", Img='" + Img + '\'' +
            '}';
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }

  public String getTrueName() {
    return trueName;
  }

  public void setTrueName(String trueName) {
    this.trueName = trueName;
  }

  public Integer getTel() {
    return tel;
  }

  public void setTel(Integer tel) {
    this.tel = tel;
  }

  public String getCard() {
    return card;
  }

  public void setCard(String card) {
    this.card = card;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getInfo() {
    return info;
  }

  public void setInfo(String info) {
    this.info = info;
  }

  public Date getCreteTime() {
    return creteTime;
  }

  public void setCreteTime(Date creteTime) {
    this.creteTime = creteTime;
  }

  public Date getUpdateTime() {
    return updateTime;
  }

  public void setUpdateTime(Date updateTime) {
    this.updateTime = updateTime;
  }

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
  }

  public String getImg() {
    return Img;
  }

  public void setImg(String img) {
    Img = img;
  }

  public User(String loginName, String loginPassword, String trueName, Integer tel, String card, String email, String info, Date creteTime, Date updateTime, Integer status, String img) {
    this.loginName = loginName;
    this.loginPassword = loginPassword;
    this.trueName = trueName;
    this.tel = tel;
    this.card = card;
    this.email = email;
    this.info = info;
    this.creteTime = creteTime;
    this.updateTime = updateTime;
    this.status = status;
    Img = img;
  }

  public User(Integer id, String loginName, String loginPassword, String trueName, Integer tel, String card, String email, String info, Date creteTime, Date updateTime, Integer status, String img) {
    this.id = id;
    this.loginName = loginName;
    this.loginPassword = loginPassword;
    this.trueName = trueName;
    this.tel = tel;
    this.card = card;
    this.email = email;
    this.info = info;
    this.creteTime = creteTime;
    this.updateTime = updateTime;
    this.status = status;
    Img = img;
  }

  public User() {
  }
}
