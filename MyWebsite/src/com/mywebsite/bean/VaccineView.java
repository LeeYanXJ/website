package com.mywebsite.bean;

import java.sql.Date;

public class VaccineView {
 
	private String vaccine; //��������
	private String vaccinetimes;//���ִ���
	private String vaccinenum;//��������
	private Date vaccinetime;//����ʱ��
	private Date appointtime;//ԤԼʱ��
	private String childname;//�׶�����
	private String childbirth;//�׶���������
	private String drelname;//ҽ������
	private String idnum;//�׶����֤��
	int age;//�׶�Ŀǰ����
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
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
	}
	public String getVaccinetimes() {
		return vaccinetimes;
	}
	public void setVaccinetimes(String vaccinetimes) {
		this.vaccinetimes = vaccinetimes;
	}
	public String getVaccinenum() {
		return vaccinenum;
	}
	public void setVaccinenum(String vaccinenum) {
		this.vaccinenum = vaccinenum;
	}
	public Date getVaccinetime() {
		return vaccinetime;
	}
	public void setVaccinetime(Date vaccinetime) {
		this.vaccinetime = vaccinetime;
	}
	public Date getAppointtime() {
		return appointtime;
	}
	public void setAppointtime(Date appointtime) {
		this.appointtime = appointtime;
	}
	public String getChildname() {
		return childname;
	}
	public void setChildname(String childname) {
		this.childname = childname;
	}
	public String getChildbirth() {
		return childbirth;
	}
	public void setChildbirth(String childbirth) {
		this.childbirth = childbirth;
	}
	public String getDrelname() {
		return drelname;
	}
	public void setDrelname(String drelname) {
		this.drelname = drelname;
	}
	
}
