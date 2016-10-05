package com.mywebsite.Servlet;


import java.io.IOException;
import java.sql.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mywebsite.Dao.ChildAppointInfoDao;
import com.mywebsite.Service.QueryInfoService;
import com.mywebsite.bean.ChildAppointInfo;
import com.mywebsite.bean.DocInfo;
import com.mywebsite.bean.VaccinateProdedure;
@WebServlet("/AppointInfo")
/*
 * �׶��������ԤԼ����
 */
public class AppointInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public AppointInfo() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
       //���ñ���       
       request.setCharacterEncoding("UTF-8");
       HttpSession session=request.getSession();      
      //��ȡҳ��Ĳ���
       String vaccine = request.getParameter("vaccine");//��������
       String Appointtime = request.getParameter("appointtime");//ԤԼʱ��
       String dusername = request.getParameter("dusername");//ҽ��ID
       String username=(String)session.getAttribute("username");//�û�ID
       String childname=request.getParameter("childname");//�׶�����
       String idnum=request.getParameter("idnum");//�׶����֤��
     //�жϽ��������Ƿ��ʺ��׶���ǰ����
       QueryInfoService queryInfo=new QueryInfoService();
       Date age=queryInfo.queryChildBirth(idnum);
     //����VaccinateProdedure���͵�List����
       List<VaccinateProdedure> vaccineinfolist=queryInfo.queryVaccine(age);
     //�ж�����Ĭ��Ϊfalse
       boolean flag=false;
     //ѭ���Ƚ�ҳ����յ��������ƺͲ�ѯ�����Ƿ�����ͬ��
       for(int i=0;i<vaccineinfolist.size();i++){
     		 if(vaccineinfolist.get(i).getVaccine().equals(vaccine))
     			 flag=true;
     	 }
     //����ԤԼ����ִ��ԤԼ��ز���   
     if(flag){                    
       //���ڸ�ʽת��
       java.sql.Date appointtime;
       appointtime=java.sql.Date.valueOf(Appointtime);
      //����ҽ��ID��ѯ��ҽ���Ƿ����
       DocInfo docinfo=queryInfo.querydocID(dusername);
       if(docinfo!=null){
    	   //�ж��û��Ƿ����ظ�ԤԼ
    	   ChildAppointInfo childAppointInfo=queryInfo.queryappointinfo(dusername, username,idnum);
    	   if(childAppointInfo==null){
             //����ChildInfoAlterDao����������ݴ���
    		   ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
    		   childAppointInfoDao.appointinfo(vaccine, appointtime,dusername,docinfo.getdrelname(),childname,idnum,username);
               request.setAttribute("page", "showappoint.jsp");
               request.setAttribute("info", "ԤԼ�ɹ�!");//  ����result.jsp��ʹ�õ���Ϣ
         }
    	   else{
    		 //��ʾԤԼ��Ϣ 
    		   request.setAttribute("page", "showappoint.jsp");
               request.setAttribute("info", "���Ѿ��й�ԤԼ�������ظ���");     
    	   }	   
       }
       //�������дҽ��ID������
       else{
    	   request.setAttribute("page", "appoint.jsp");
           request.setAttribute("info", "�����ڸ�ҽ����������ԤԼ"); 
       }	
       RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/result.jsp");
 	   rd.forward(request, response);
	}//�����if
	else{                      //������ԤԼ����ת����Ϣ����
		 request.setAttribute("page", "appoint.jsp");
		 request.setAttribute("vaccineinfolist", vaccineinfolist);
         RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/Noresult.jsp");
   	     rd.forward(request, response);
	}
  }
		
}
