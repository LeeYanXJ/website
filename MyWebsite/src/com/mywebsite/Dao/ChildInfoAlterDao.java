package com.mywebsite.Dao;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.apache.ibatis.session.SqlSession;

import com.mywebsite.DB.DBAccess;
import com.mywebsite.bean.ChildInfo;

/*
 * �׶�������Ϣ��ԤԼ��Ϣ����
 */
public class ChildInfoAlterDao {
	/*
	 * �׶�������Ϣ���
	 */
     public void childinfoalter(String childname,String childgender,Date childbirth,String idnum,String username){
    	 DBAccess dbAccess=new DBAccess();
 		 ChildInfo childinfo=new ChildInfo();
 		 SqlSession sqlSession=null;
         try{
      	   sqlSession=dbAccess.getSqlSession();
      	   childinfo.setChildname(childname);
      	   childinfo.setChildgender(childgender);
      	   childinfo.setChildbirth(childbirth);
      	   childinfo.setIdnum(idnum);
      	   childinfo.setUsername(username);
      	   sqlSession.insert("UserInfo.addChildinfo",childinfo);
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
      * ��ѯ�û�����С������Ϣ
      */
    public List<ChildInfo>queryChildInfoDao(String username){
    	 DBAccess dbAccess=new DBAccess();
 		 List<ChildInfo>childinfolist=new ArrayList<ChildInfo>();
 		 SqlSession sqlSession=null;
         try{
      	   sqlSession=dbAccess.getSqlSession();
      	   childinfolist=sqlSession.selectList("ChildVaccinate.selectChildInfo",username);

         } catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
         finally{
        	 if(sqlSession!=null)
 				sqlSession.close();
        }
         return childinfolist;
    }
    /*
     * �����׶����֤�Ų�ѯ�׶���������
     */
    public Date queryChildBirthDao(String idnum){
   	     DBAccess dbAccess=new DBAccess();
		 SqlSession sqlSession=null;
		 Date age = null;
        try{
     	   sqlSession=dbAccess.getSqlSession();
     	   age=sqlSession.selectOne("ChildVaccinate.selectChildBirth",idnum);

        } catch (IOException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
        finally{
       	 if(sqlSession!=null)
				sqlSession.close();
       }
        return age;
   }
     Logger log;
}
