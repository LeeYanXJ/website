package com.mywebsite.Dao;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;



import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.UserInfo;

public class RegisterDao {
	/*
	 * ����û�������Ϣ
	 */
	public void adduserinfo(String userName,String passwordMD5,String email,String name,String gender,String mobile,String homephone,String birthplace){
		DBAccess dbAccess=new DBAccess();
		UserInfo userinfo=new UserInfo();
		SqlSession sqlSession=null;
		try {
			sqlSession=dbAccess.getSqlSession();//���sqlSession����
			//ͨ��sqlSessionִ��SQL���
			userinfo.setUsername(userName);
			userinfo.setPassword(passwordMD5);
			userinfo.setEmail(email);
			userinfo.setName(name);
			userinfo.setGender(gender);
			userinfo.setMobile(mobile);
			userinfo.setHomephone(homephone);
			userinfo.setBirthplace(birthplace);
		    sqlSession.insert("UserInfo.addUserinfo",userinfo);
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
}
