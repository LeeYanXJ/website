package com.mywebsite.Dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.ChildAppointInfo;
import com.mywebsite.bean.DocAppointView;
import com.mywebsite.bean.VaccinateProdedure;
import com.sun.istack.internal.logging.Logger;
import com.mywebsite.bean.UserAppointView;
public class ChildAppointInfoDao {
	/*
	 * ��ѯ�û��Ƿ�ԤԼ����ǰҽ��
	 */
	 public ChildAppointInfo Queryappointinfo(String dusername,String username,String idnum){
		   DBAccess dbAccess=new DBAccess();
		   ChildAppointInfo childAppointInfo=new ChildAppointInfo();
			SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();//���sqlSession����
				//ͨ��sqlSessionִ��SQL���
				childAppointInfo.setDusername(dusername);
				childAppointInfo.setUsername(username);
				childAppointInfo.setIdnum(idnum);
				childAppointInfo=sqlSession.selectOne("ChildAppoint.Queryappointinfo",childAppointInfo);
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				if(sqlSession!=null){
					sqlSession.close();
				}
				
			  }return childAppointInfo;
	   }
	 /*
      * ����û���ԤԼ��Ϣ
      */
     public void appointinfo(String vaccine,Date appointtime,String dusername,String drelname,String childname,String idnum,String username){
    	 DBAccess dbAccess=new DBAccess();
    	 ChildAppointInfo childappointinfo=new  ChildAppointInfo();
    	 SqlSession sqlSession=null;
    	 try{
    		 //��ȡsqlSession����
    		 sqlSession=dbAccess.getSqlSession(); 
    		 //����Ϣ��ӵ�childappointinfo�����б���
    		 childappointinfo.setVaccine(vaccine);
    		 childappointinfo.setAppointtime(appointtime);
    		 childappointinfo.setDrelname(drelname);
    		 childappointinfo.setDusername(dusername);
    		 childappointinfo.setChildname(childname);
    		 childappointinfo.setIdnum(idnum);
    		 childappointinfo.setUsername(username);
    		 //��childappointinfo������Ϣ������ر���
    		 sqlSession.insert("ChildAppoint.addAppointinfo", childappointinfo);
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
      * ��ȡ�û���ԤԼ��Ϣ
      */
     public List<UserAppointView> QueryAppointinfo(String username){
		   DBAccess dbAccess=new DBAccess();
		   List<UserAppointView> AppointInfolist=new ArrayList<UserAppointView>();
			SqlSession sqlSession=null;
			try {
				sqlSession=dbAccess.getSqlSession();//���sqlSession����
				//ͨ��sqlSessionִ��SQL���
				AppointInfolist=sqlSession.selectList("ChildAppoint.QueryAppointinfo",username);
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				if(sqlSession!=null){
					sqlSession.close();
				}
				
			  }return AppointInfolist;
	   }
     /*
      * ��ȡĿ��ҽ�����µ��û�ԤԼ��Ϣ
      */
     public List<DocAppointView> QuerydocAppointinfo(String Dname){
		 //��ȡ���ݿ�Ự����  
    	   DBAccess dbAccess=new DBAccess(); 
		   List<DocAppointView> DocAppointInfolist=new ArrayList<DocAppointView>();
		   SqlSession sqlSession=null;
			try {
		 //��һ�����ݿ�Ự		
				sqlSession=dbAccess.getSqlSession();
		 //ִ��SQL��䷵��ҽ���б���
				DocAppointInfolist=sqlSession.selectList("ChildAppoint.QueryDocAppointinfo",Dname);
			} catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}finally{
				if(sqlSession!=null){
					sqlSession.close();
				}
				
			  }return DocAppointInfolist;
	   }
     /*
      * ɾ���û���ԤԼ��Ϣ
      */
     public void Deleteappointinfo(String idnum){
    	 DBAccess dbAccess=new DBAccess();
    	 SqlSession sqlSession=null;
    	 try{
    		 sqlSession=dbAccess.getSqlSession();
    		 sqlSession.delete("ChildAppoint.deleteAppointinfo", idnum);
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
      * ��ѯ��ǰ������׶�Ӧ�ý��ֵ���������
      */
     public List<VaccinateProdedure> queryVaccineDao(int age){
    	 DBAccess dbAccess=new DBAccess();
    	 List<VaccinateProdedure> vaccineinfolist=new ArrayList<VaccinateProdedure>();
    	 SqlSession sqlSession=null;
    	 try{
    		 sqlSession=dbAccess.getSqlSession();
    		 vaccineinfolist=sqlSession.selectList("ChildAppoint.queryVaccine", age);
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
    	 return vaccineinfolist;
     }
	 Logger log;
}
