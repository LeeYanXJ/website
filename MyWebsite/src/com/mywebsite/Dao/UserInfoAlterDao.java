package com.mywebsite.Dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.DocInfo;
import com.mywebsite.bean.UserInfo;
import com.sun.istack.internal.logging.Logger;
/**
 * �û���Ϣ�޸Ĳ���
 *
 */
public class UserInfoAlterDao {
	/*
	 * �û�������Ϣ�޸�
	 */
    public void userinfoalter(String username,String name,String gender,String mobile,String birthplace,String homephone,String email){
    	DBAccess dbAccess=new DBAccess();
		UserInfo userinfo=new UserInfo();
		SqlSession sqlSession=null;
    	try{
    		sqlSession=dbAccess.getSqlSession();
    		userinfo.setUsername(username);
    		userinfo.setName(name);
    		userinfo.setGender(gender);
    		userinfo.setMobile(mobile);
    		userinfo.setBirthplace(birthplace);
    		userinfo.setHomephone(homephone);
    		userinfo.setEmail(email);
    		sqlSession.update("UserInfo.alterUserinfo", userinfo);
    		 sqlSession.commit();
    	} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	finally{
    		if(sqlSession!=null){
				sqlSession.close();
    	}
    }
  }
    /*
     * ��ѯ����ҽ����Ϣ
     */
    public List<DocInfo> docinfoquery(){
    	DBAccess dbAccess=new DBAccess();
    	List<DocInfo> DocInfolist=new ArrayList<DocInfo>();
		SqlSession sqlSession=null;
    	try{
    		sqlSession=dbAccess.getSqlSession();
    		DocInfolist=sqlSession.selectList("UserInfo.QueryDocinfo");
    		
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
    * ҽ����Ϣ�޸�
    */
    public void docinfoalter(String dusername,String drelname,String dgender,String dmobile,String major){
    	DBAccess dbAccess=new DBAccess();
		DocInfo docinfo=new DocInfo();
		SqlSession sqlSession=null;
    	try{
    		sqlSession=dbAccess.getSqlSession();
    		docinfo.setDusername(dusername);
    		docinfo.setdrelname(drelname);
    		docinfo.setDgender(dgender);
    		docinfo.setDmobile(dmobile);
    		docinfo.setMajor(major);
    		sqlSession.update("UserInfo.alterDocinfo", docinfo);
    		sqlSession.commit();
    	} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
    	finally{
    		if(sqlSession!=null){
				sqlSession.close();
    	}
    }
  }
    Logger log;
}
