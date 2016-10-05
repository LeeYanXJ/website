package com.mywebsite.Dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;

import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.AlterPwd;
import com.mywebsite.bean.DocInfo;
import com.mywebsite.bean.UserInfo;
import com.sun.istack.internal.logging.Logger;

public class LoginDao {
	/**
	 * 
	 *�û���¼���ݲ���
	 */
	public UserInfo Queryuserinfo(String userName){
	DBAccess dbAccess=new DBAccess();
	UserInfo userinfo=new UserInfo();
	SqlSession sqlSession=null;
	try {
		sqlSession=dbAccess.getSqlSession();//���sqlSession����
		//ͨ��sqlSessionִ��SQL���
		userinfo=sqlSession.selectOne("UserInfo.queryUserinfo",userName);
	} catch (IOException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}finally{
		if(sqlSession!=null){
			sqlSession.close();
		}
		
	  }return userinfo;
  }
  
   /**
    * 
    * ����ҽ����¼�û�����
    */
   public DocInfo Querydocinfo(String DName){
	   DBAccess dbAccess=new DBAccess();
		DocInfo docinfo=new DocInfo();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();//���sqlSession����
			//ͨ��sqlSessionִ��SQL���
			docinfo=sqlSession.selectOne("UserInfo.queryDocinfo",DName);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
			
		  }return docinfo;
   }
   /*
    * ����Ա��¼���ݲ���
    */
    public String QueryPassword(String adname){
    	DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		String adpassword="";
		try {
			sqlSession=dbAccess.getSqlSession();//���sqlSession����
			//ͨ��sqlSessionִ��SQL���
            adpassword=sqlSession.selectOne("UserInfo.querypassword",adname);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(sqlSession!=null){
				sqlSession.close();
			}
			
		  }return adpassword;
    }
   /*
    * �����û��˺Ų�ѯ�׶����֤��
    */
   public String Queryusername(String idnum){
	   DBAccess dbAccess=new DBAccess();
	   SqlSession sqlSession=null;
	   String idNum=null;
	   try{
		   sqlSession=dbAccess.getSqlSession();
		   idNum=sqlSession.selectOne("UserInfo.queryUsername",idnum);
	   } catch (IOException e) {
		// TODO �Զ����ɵ� catch ��
		e.printStackTrace();
	}finally{
		   if(sqlSession!=null){
				sqlSession.close();
			 }
	   }
	   return idNum;
   }
   /*
    * �û������޸�
    */
   public void ChangeUserPwd(String newpwd,String username){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		AlterPwd alterPwd=new AlterPwd();
		try {
			alterPwd.setUserPwd(newpwd);
			alterPwd.setUsername(username);
			sqlSession=dbAccess.getSqlSession();//���sqlSession����
			//ͨ��sqlSessionִ��SQL���
            sqlSession.selectOne("UserInfo.alterUserPwd",alterPwd);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		  }
	  }
   /*
    * ҽ�������޸�
    */
   public void ChangeDocPwd(String newpwd,String dusername){
		DBAccess dbAccess=new DBAccess();
		SqlSession sqlSession=null;
		AlterPwd alterPwd=new AlterPwd();
		try {
			alterPwd.setDocPwd(newpwd);
			alterPwd.setDusername(dusername);
			sqlSession=dbAccess.getSqlSession();//���sqlSession����
			//ͨ��sqlSessionִ��SQL���
            sqlSession.selectOne("UserInfo.alterDocPwd",alterPwd);
		} catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}finally{
			if(sqlSession!=null)
				sqlSession.close();
		  }
	  }
   Logger log;
}
