package com.mywebsite.bean;

import java.sql.Date;
/*
 * ҽ��ԤԼ��ͼ��Ϣ��װ
 */
public class DocAppointView {
 
	//�׶�����
	private String childname;
	//�׶���������
	private Date childbirth;
	//�׶����֤��
	private String idnum;
	//��������
	private String vaccine;
	//ԤԼʱ��
	private Date appointtime;
	//�ҳ�����
	private String name;
	//��ϵ�绰
	private String mobile;
	//ҽ��ְ����
	private String dusername;
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
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
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
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getDusername() {
		return dusername;
	}
	public void setDusername(String dusername) {
		this.dusername = dusername;
	}
	
}
