package com.mywebsite.Service;

import java.sql.Date;
import java.util.List;

import com.mywebsite.Dao.ChildAppointInfoDao;
import com.mywebsite.Dao.ChildInfoAlterDao;
import com.mywebsite.Dao.ChildVaccinateInfoDao;
import com.mywebsite.Dao.LoginDao;
import com.mywebsite.Dao.UserInfoAlterDao;
import com.mywebsite.bean.ChildInfo;
import com.mywebsite.bean.DocAppointView;
import com.mywebsite.bean.ExceptionInfo;
import com.mywebsite.bean.UserAppointView;
import com.mywebsite.bean.ChildAppointInfo;
import com.mywebsite.bean.DocInfo;
import com.mywebsite.bean.VaccinateProdedure;
import com.mywebsite.bean.VaccineView;

/*
 * ��ѯ��Ϣ����
 */
public class QueryInfoService {
	/*
	 * ��ѯҽ���Ƿ����
	 */
     public DocInfo querydocID(String Dname){
    	 LoginDao logindao=new LoginDao();
    	 DocInfo docinfo=logindao.Querydocinfo(Dname);
    	return docinfo;
     }
     /*
      * ��ѯ�û��Ƿ��Ѿ����й�ԤԼ
      */
    public ChildAppointInfo queryappointinfo(String dusername,String username,String idnum){
    	 ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
    	 ChildAppointInfo childAppointInfo =childAppointInfoDao.Queryappointinfo(dusername,username,idnum);
         	return 	 childAppointInfo;
    }
    /*
     * ��ѯ�û���ԤԼ��Ϣ
     */
    public List<UserAppointView> queryAppointinfo(String username){
    	 ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
    	 List<UserAppointView> AppointInfolist =childAppointInfoDao.QueryAppointinfo(username);
         	return 	 AppointInfolist;
    }
    /*
     * ��ѯĿ��ҽ�����µ������û�ԤԼ��Ϣ
     */
    public List<DocAppointView> querydocAppointinfo(String Dname){
    	ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
    	List<DocAppointView> DocAppointInfolist=childAppointInfoDao.QuerydocAppointinfo(Dname);
    	return DocAppointInfolist;
    }
    /*
     * ��ѯҽ����Ϣ
     */
    public List<DocInfo> queryDocinfo(){
    	 UserInfoAlterDao userInfoAlterDao=new UserInfoAlterDao();
    	 List<DocInfo> DocInfolist=userInfoAlterDao.docinfoquery();
    	 return DocInfolist;
    }
    /*
     * �����׶����֤�Ų鿴���������Ϣ
     */
    public List<VaccineView>queryVaccineinfo(String idnum){
    	ChildVaccinateInfoDao childVaccinateInfoDao=new ChildVaccinateInfoDao();
    	List<VaccineView> vaccineinfolist=childVaccinateInfoDao.SelectVaccineInfo(idnum);
    	return vaccineinfolist;
    }
    /*
     * ��ѯ�û�������С����Ϣ
     */
    public List<ChildInfo>queryChildidInfo(String username){
    	ChildInfoAlterDao childInfoAlterDao=new ChildInfoAlterDao();
    	List<ChildInfo> childinfolist=childInfoAlterDao.queryChildInfoDao(username);
    	return childinfolist;
    }
    /*
     * �����׶����֤�Ų�ѯ�׶���Ϣ
     */
    public ChildInfo queryChildInfo(String idnum){
    	ChildVaccinateInfoDao childVaccinateInfoDao=new ChildVaccinateInfoDao();
    	ChildInfo childinfo=childVaccinateInfoDao.SelectChildInfo(idnum);
    	return childinfo;
    }
    /*
     * �����׶����֤�Ų�ѯ�׶���������
     */
    public Date queryChildBirth(String idnum){
    	ChildInfoAlterDao childInfoAlterDao=new ChildInfoAlterDao();
    	Date age=childInfoAlterDao.queryChildBirthDao(idnum);
    	return age;
    }
    /*
     * ���û���ԤԼ������������ж��Ƿ��ʺ�
     */
    public List<VaccinateProdedure> queryVaccine(Date Age){
      //��ȡ��ǰϵͳʱ�� 
    	Date date=new Date(System.currentTimeMillis());
      //��ȡ��������֮���������
  	    int age=(int) (date.getTime()/86400000-Age.getTime()/86400000);
  	  //��30��Ϊһ�¼����׶�����
  	    age=age/30;
  	    //��ѯ��ǰ�׶�������Ӧ�ý��ֵ�����
  	  ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
   	 List<VaccinateProdedure> vaccineinfolist=childAppointInfoDao.queryVaccineDao(age);
   	 return vaccineinfolist;
    }
    /*
     * ��ѯ�׶��쳣��Ӧ��¼
     */
    public List<ExceptionInfo>queryExceptionInfo(String idnum){
    	ChildVaccinateInfoDao childVaccinateInfoDao=new ChildVaccinateInfoDao();
    	List<ExceptionInfo> exceptionlist=childVaccinateInfoDao.SelectExceptionInfo(idnum);
    	return exceptionlist;
    }
    /*
     * ����ҽ��ְ���Ų�ѯ���ֱ��е��׶����֤��
     */
    public List<VaccineView> queryChildidnum(String dusername,String idnum){
    	ChildVaccinateInfoDao childVaccinateInfoDao=new ChildVaccinateInfoDao();
    	List<VaccineView> childidnumlist=childVaccinateInfoDao.SelectChildidnum(dusername,idnum);
    	return childidnumlist;
    }
    /*
     * ��ѯ�׶����һ���µĽ�����Ϣ
     */
    public List<VaccineView>QueryVaccineinfo(String idnum,int age){
    	ChildVaccinateInfoDao childVaccinateInfoDao=new ChildVaccinateInfoDao();
    	List<VaccineView> childVaclist=childVaccinateInfoDao.selectVaccineinfo(idnum,age);
    	return childVaclist;
    }
    public List<VaccinateProdedure> QueryVaccine(int age){
    	 ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
       	 List<VaccinateProdedure> vaccineinfolist=childAppointInfoDao.queryVaccineDao(age);
       	 return vaccineinfolist;
    }
}
