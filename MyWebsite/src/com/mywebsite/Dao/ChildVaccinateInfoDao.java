package com.mywebsite.Dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.ChildInfo;
import com.mywebsite.bean.ChildVaccinateInfo;
import com.mywebsite.bean.ExceptionInfo;
import com.mywebsite.bean.VaccineView;
import com.sun.istack.internal.logging.Logger;
/*
 * �׶�����������ݴ���
 */
public class ChildVaccinateInfoDao {
	  /*
	   * �����׶�������Ϣ
	   */
	public void InsertVaccineInfo(String vaccine,String vaccinetimes,Date appointtime,Date vaccinetime,String vaccinenum,String idnum,String username,String dusername,int age){
		DBAccess dbAccess=new DBAccess();
		ChildVaccinateInfo childVaccinateInfo=new ChildVaccinateInfo();
		 SqlSession sqlSession=null;
		 try{
			 sqlSession=dbAccess.getSqlSession(); 
			 childVaccinateInfo.setIdnum(idnum);
		     childVaccinateInfo.setDusername(dusername);
		     childVaccinateInfo.setUsername(username);
		     childVaccinateInfo.setAppointtime(appointtime);
		     childVaccinateInfo.setVaccine(vaccine);
		     childVaccinateInfo.setVaccinenum(vaccinenum);
		     childVaccinateInfo.setVaccinetimes(vaccinetimes);
		     childVaccinateInfo.setVaccinetime(vaccinetime);
		     childVaccinateInfo.setAge(age);
		     sqlSession.insert("ChildVaccinate.addVaccinateinfo", childVaccinateInfo);
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
	 * �����׶����֤�Ų�ѯ�׶����������Ϣ
	 */
	 public List<VaccineView> SelectVaccineInfo(String idnum){
		 DBAccess dbAccess=new DBAccess();
		 List<VaccineView> vaccineinfolist=new ArrayList<VaccineView>();
		 SqlSession sqlSession=null;
		 try{
			 sqlSession=dbAccess.getSqlSession();
			 vaccineinfolist=sqlSession.selectList("ChildVaccinate.selectVaccinateinfo", idnum);
		 } catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		 finally{
			 if(sqlSession!=null)
				 sqlSession.close();
		 }
		 return vaccineinfolist;
	 }
	 /*
		 * �����׶����֤�Ų�ѯ�׶���Ϣ
		 */
		 public ChildInfo SelectChildInfo(String idnum){
			 DBAccess dbAccess=new DBAccess();
			 ChildInfo childinfo=new ChildInfo();
			 SqlSession sqlSession=null;
			 try{
				 sqlSession=dbAccess.getSqlSession();
				 childinfo=sqlSession.selectOne("ChildVaccinate.selectChildinfo", idnum);
			 } catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			 finally{
				 if(sqlSession!=null)
					 sqlSession.close();
			 }
			 return childinfo;
		 }
		 /*
		  * ��¼�׶����ֺ���쳣��Ӧ
		  */
		 public void insertExceptionInfo(String childname,String idnum,String vaccine,String factory,String vaccinenum,Date indate,Date vaccinatetime,Date reaction,String symptom){
			 DBAccess dbAccess=new DBAccess();
			 ExceptionInfo exceptionInfo=new ExceptionInfo();
			 SqlSession sqlSession=null;
			 try{
				 sqlSession=dbAccess.getSqlSession();
				 exceptionInfo.setChildname(childname);
				 exceptionInfo.setIdnum(idnum);
				 exceptionInfo.setIndate(indate);
				 exceptionInfo.setVaccine(vaccine);
				 exceptionInfo.setVaccinenum(vaccinenum);
				 exceptionInfo.setReaction(reaction);
				 exceptionInfo.setVaccinatetime(vaccinatetime);
				 exceptionInfo.setSymptom(symptom);
				 exceptionInfo.setFactory(factory);
				 sqlSession.insert("ChildVaccinate.insertExceptioninfo",exceptionInfo);
				 sqlSession.commit();
			 } catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			 finally{
				 if(sqlSession!=null)
					 sqlSession.close();
			 }
		 }
		 /*
		  * ��ѯ�׶��쳣��Ӧ
		  */
		 public List<ExceptionInfo> SelectExceptionInfo(String idnum){
			 DBAccess dbAccess=new DBAccess();
			 List<ExceptionInfo> exceptionlist=new ArrayList<ExceptionInfo>();
			 SqlSession sqlSession=null;
			 try{
				 sqlSession=dbAccess.getSqlSession();
				 exceptionlist=sqlSession.selectList("ChildVaccinate.selectExceptioninfo", idnum);
			 } catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			 finally{
				 if(sqlSession!=null)
					 sqlSession.close();
			 }
			 return exceptionlist;
		 }
		 public List<VaccineView> SelectChildidnum(String dusername,String idnum){
			 DBAccess dbAccess=new DBAccess();
			 List<VaccineView> childidnumlist=new ArrayList<VaccineView>();
			 SqlSession sqlSession=null;
			 try{
				 sqlSession=dbAccess.getSqlSession();
				 if(idnum=="")
				   childidnumlist=sqlSession.selectList("ChildVaccinate.selectChildidnum", dusername);
				 if(dusername=="")
				    childidnumlist=sqlSession.selectList("ChildVaccinate.selectVaccinateInfo",idnum);
			 } catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			 finally{
				 if(sqlSession!=null)
					 sqlSession.close();
			 }
			 return childidnumlist;
		 }
		 /*
		  * ��ѯ�׶����һ���µĽ�����Ϣ
		  */
		 public List<VaccineView> selectVaccineinfo(String idnum,int age){
			 DBAccess dbAccess=new DBAccess();
			 List<VaccineView> childVaclist=new ArrayList<VaccineView>();
			 ChildInfo childinfo=new ChildInfo();
			 SqlSession sqlSession=null;
			 try{
				 childinfo.setAge(age);
				 childinfo.setIdnum(idnum);
				 sqlSession=dbAccess.getSqlSession();
				 childVaclist=sqlSession.selectList("ChildVaccinate.SelectVaccinateinfo",childinfo);
			 } catch (IOException e) {
				// TODO �Զ����ɵ� catch ��
				e.printStackTrace();
			}
			 finally{
				 if(sqlSession!=null)
					 sqlSession.close();
			 }
			 return childVaclist;
		 }
	Logger log;
}
