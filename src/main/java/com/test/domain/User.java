package com.test.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;


@Data
@Accessors(chain = true)
public class User {
	
  private Integer id;
  private String account;
  private String name;
  private String password;
  private Integer age;
  private String phoneNumber;
  private String registerDate;
  private String mail;
  private Integer sex;
  private Integer status;
  private Date creTime;
  private String creUser;
  private Date modTime;
  private String modUser;
  private Integer delFlag;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public String getAccount() {
	return account;
}
public void setAccount(String account) {
	this.account = account;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public Integer getAge() {
	return age;
}
public void setAge(Integer age) {
	this.age = age;
}
public String getPhoneNumber() {
	return phoneNumber;
}
public void setPhoneNumber(String phoneNumber) {
	this.phoneNumber = phoneNumber;
}
public String getRegisterDate() {
	return registerDate;
}
public void setRegisterDate(String registerDate) {
	this.registerDate = registerDate;
}
public String getMail() {
	return mail;
}
public void setMail(String mail) {
	this.mail = mail;
}
public Integer getSex() {
	return sex;
}
public void setSex(Integer sex) {
	this.sex = sex;
}
public Integer getStatus() {
	return status;
}
public void setStatus(Integer status) {
	this.status = status;
}
public Date getCreTime() {
	return creTime;
}
public void setCreTime(Date creTime) {
	this.creTime = creTime;
}
public String getCreUser() {
	return creUser;
}
public void setCreUser(String creUser) {
	this.creUser = creUser;
}
public Date getModTime() {
	return modTime;
}
public void setModTime(Date modTime) {
	this.modTime = modTime;
}
public String getModUser() {
	return modUser;
}
public void setModUser(String modUser) {
	this.modUser = modUser;
}
public Integer getDelFlag() {
	return delFlag;
}
public void setDelFlag(Integer delFlag) {
	this.delFlag = delFlag;
}
  
  
  
 }
