package com.test.domain;

import java.util.Date;

import lombok.Data;
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
  
 }
