package com.mywebsite.bean;

import java.sql.Date;
/*
 * ���ڷ�װ�׶��쳣��Ӧ��¼
 */
public class ExceptionInfo {
	
	String childname;//�׶�����
	String idnum;//���֤��
	String vaccine;//��������
	String factory;//��������
	String vaccinenum;//��������
	Date indate;//������Ч��
	Date vaccinatetime;//��������
	Date reaction;//��Ӧ����
	String symptom; //��Ӧ֢״
	public String getFactory() {
		return factory;
	}
	public void setFactory(String factory) {
		this.factory = factory;
	}
	public String getChildname() {
		return childname;
	}
	public void setChildname(String childname) {
		this.childname = childname;
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
	public String getVaccinenum() {
		return vaccinenum;
	}
	public void setVaccinenum(String vaccinenum) {
		this.vaccinenum = vaccinenum;
	}
	public Date getIndate() {
		return indate;
	}
	public void setIndate(Date indate) {
		this.indate = indate;
	}
	public Date getVaccinatetime() {
		return vaccinatetime;
	}
	public void setVaccinatetime(Date vaccinatetime) {
		this.vaccinatetime = vaccinatetime;
	}
	public Date getReaction() {
		return reaction;
	}
	public void setReaction(Date reaction) {
		this.reaction = reaction;
	}
	public String getSymptom() {
		return symptom;
	}
	public void setSymptom(String symptom) {
		this.symptom = symptom;
	}
}
