package com.mywebsite.bean;

import java.sql.Date;

public class ChildVaccinateInfo {
    
	private String vaccine;//������������
	private Date vaccinetime;//����ʱ��
	private Date appointtime;//ԤԼʱ��
	private String vaccinenum;//������������
	private String username;//�û��˺�
	private String dusername;//ҽ��ְ����
	private String idnum;//�׶����֤��
	private String vaccinetimes;//���ִ���
	private int age;//�׶��꣨�£���
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getVaccinetimes() {
		return vaccinetimes;
	}
	public void setVaccinetimes(String vaccinetimes) {
		this.vaccinetimes = vaccinetimes;
	}
	public String getVaccine() {
		return vaccine;
	}
	public void setVaccine(String vaccine) {
		this.vaccine = vaccine;
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
	public String getVaccinenum() {
		return vaccinenum;
	}
	public void setVaccinenum(String vaccinenum) {
		this.vaccinenum = vaccinenum;
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
	public String getIdnum() {
		return idnum;
	}
	public void setIdnum(String idnum) {
		this.idnum = idnum;
	}
	
}
