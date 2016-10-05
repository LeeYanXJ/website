package com.mywebsite.Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.DocInfo;
import com.sun.istack.internal.logging.Logger;

public class DisposeDoctorInfoDao {
     /*
      * ���ҽ����Ϣ
      */
	 public void AddDoctorinfo(String dusername,String dpassword,String drelname,String dgender,String dmobile,String major){
		   DBAccess dbAccess=new DBAccess();
		   DocInfo docinfo=new DocInfo();
		   SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();//���sqlSession����
				//ͨ��sqlSessionִ��SQL���
				docinfo.setDusername(dusername);
				docinfo.setDpassword(dpassword);
				docinfo.setdrelname(drelname);
				docinfo.setDgender(dgender);
				docinfo.setDmobile(dmobile);
				docinfo.setMajor(major);
				sqlSession.insert("ManageInfo.AddDocinfo", docinfo);
				sqlSession.commit();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				if(sqlSession!=null){
					sqlSession.close();
				}
				
			  }
	   }
	 /*
	     * ����Ա��ѯҽ����Ϣ
	     */
	    public List<DocInfo> docinfoQuery(String dusername,String drelname){ 
	    	DBAccess dbAccess=new DBAccess();
	    	List<DocInfo> DocInfolist=new ArrayList<DocInfo>();
			SqlSession sqlSession=null;
	    	try{
	    		sqlSession=dbAccess.getSqlSession();
	    		DocInfo docInfo=new DocInfo();
	    		docInfo.setDusername(dusername);
	    		docInfo.setdrelname(drelname);
	    		DocInfolist=sqlSession.selectList("ManageInfo.QueryDocinfo",docInfo);
	    		
	    	} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
	    	finally{
	    		if(sqlSession!=null){
					sqlSession.close();
	    	}
	    }return DocInfolist;
	  }
	    /*
	     * ����Աɾ��ҽ����Ϣ
	     */
	 public void deleteDoctorinfo(String dusername){
		   DBAccess dbAccess=new DBAccess();
		   SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();//���sqlSession����
				//ͨ��sqlSessionִ��SQL���
				sqlSession.delete("ManageInfo.DeleteDocinfo", dusername);
				sqlSession.commit();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				if(sqlSession!=null){
					sqlSession.close();
				}
				
			  }
	   }
	 /*
	  * �޸�ҽ����Ϣ
	  */
	 public void alterDoctorinfo(String dusername,String dmobile,String major){
		   DBAccess dbAccess=new DBAccess();
		   DocInfo docinfo=new DocInfo();
		   SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();//���sqlSession����
				//ͨ��sqlSessionִ��SQL���
				docinfo.setDusername(dusername);
				docinfo.setDmobile(dmobile);
				docinfo.setMajor(major);
				sqlSession.update("ManageInfo.alterDocinfo", docinfo);
				sqlSession.commit();
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				if(sqlSession!=null){
					sqlSession.close();
				}
				
			  }
	   }
	 Logger log;
}
