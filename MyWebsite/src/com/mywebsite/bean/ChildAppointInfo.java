package com.mywebsite.bean;

import java.sql.Date;
/*
 * ���ڷ�װԤԼ��Ϣ
 */
public class ChildAppointInfo {
  //��������
	private String vaccine;
  //ԤԼʱ��
	private Date appointtime;
  //�û�ID
	private String username;
  //ҽ��ID
	private String dusername;
	//ҽ������
	private String drelname;
	//�׶�����
	private String childname;
	//�׶����֤��
    private String idnum;
    //�׶�Ŀǰ����
    private int age;
public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
public String getChildname() {
		return childname;
	}
	public void setChildname(String childname) {
		this.childname = childname;
	}
public String getDrelname() {
		return drelname;
	}
	public void setDrelname(String drelname) {
		this.drelname = drelname;
	}
public String getVaccine() {
	return vaccine;
}
public void setVaccine(String vaccine) {
	this.vaccine = vaccine;
}
public Date getAppointtime() {
	return appointtime;
}
public void setAppointtime(Date appointtime) {
	this.appointtime = appointtime;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getDusername() {
	return dusername;
}
public void setDusername(String dusername) {
	this.dusername = dusername;
}
  
}
