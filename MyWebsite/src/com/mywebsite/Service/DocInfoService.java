package com.mywebsite.Service;

import java.util.List;

import com.mywebsite.Dao.DisposeDoctorInfoDao;
import com.mywebsite.bean.DocInfo;

public class DocInfoService {
	
	/*
     * ����Ա��ѯҽ����Ϣ
     */
    public List<DocInfo>queryDocInfo(String dusername,String drelname){
    	DisposeDoctorInfoDao queryDocInfoDao=new DisposeDoctorInfoDao();
   	    List<DocInfo> DocInfolist=queryDocInfoDao.docinfoQuery(dusername,drelname);
   	    return DocInfolist;
    }
    /*
     * ����Աɾ��ҽ����Ϣ
     */
    public void deleteDocInfo(String dusername){
    	//ҽ��ְ���ŵĺϷ���
    	if(dusername!=null&&!"".equals(dusername)){
    	DisposeDoctorInfoDao deleteDoctorInfoDao=new DisposeDoctorInfoDao();
    	//���������߼��㴦��ɾ������
    	deleteDoctorInfoDao.deleteDoctorinfo(dusername);
    	}
    }
    /*
     * ����Ա�޸�ҽ����Ϣ
     */
    public void alterDocInfo(String dusername,String dmobile,String major){
    	//ҽ��ְ���ŵĺϷ���
    	if(dusername!=null&&!"".equals(dusername)){
    	DisposeDoctorInfoDao deleteDoctorInfoDao=new DisposeDoctorInfoDao();
    	//���������߼��㴦��ɾ������
    	deleteDoctorInfoDao.alterDoctorinfo(dusername,dmobile,major);
    	}
    }
}   
