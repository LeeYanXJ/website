package com.mywebsite.bean;

import java.sql.Date;
/*
 * �û�ԤԼ��ͼ��Ϣ��װ
 */
public class UserAppointView {
 
	//�׶�����
	private String childname;
	//�׶���������
	private Date childbirth;
	//ԤԼʱ��
	private Date appointtime;
	//ҽ������
	private String drelname;
	//ҽ��ְ����
	private String dusername;
	//��������
	private String vaccine;
	//�û��˺�
	private String username;
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
	public Date getChildbirth() {
		return childbirth;
	}
	public void setChildbirth(Date childbirth) {
		this.childbirth = childbirth;
	}
	public Date getAppointtime() {
		return appointtime;
	}
	public void setAppointtime(Date appointtime) {
		this.appointtime = appointtime;
	}
	public String getDrelname() {
		return drelname;
	}
	public void setDrelname(String drelname) {
		this.drelname = drelname;
	}
	public String getDusername() {
		return dusername;
	}
	public void setDusername(String dusername) {
		this.dusername = dusername;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	
}
