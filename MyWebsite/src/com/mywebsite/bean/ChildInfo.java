package com.mywebsite.bean;

import java.util.Date;


/*
 * ���ڷ�װ�û��׶���Ϣ
 */
public class ChildInfo {
	//�׶�������
   private String childname;
   //�׶����Ա�
   private String childgender;
   //�׶��ĳ�������
   private Date childbirth;
   //�׶������֤��
   private String idnum;
   //�û����û���
   private String username;
   private int age;
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getChildname() {
	return childname;
}
public void setChildname(String childname) {
	this.childname = childname;
}
public String getChildgender() {
	return childgender;
}
public void setChildgender(String childgender) {
	this.childgender = childgender;
}
public Date getChildbirth() {
	return childbirth;
}
public void setChildbirth(Date childbirth) {
	this.childbirth = childbirth;
}
public String getIdnum() {
	return idnum;
}
public void setIdnum(String idnum) {
	this.idnum = idnum;
}
   
   
}
