package com.mywebsite.Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mywebsite.Dao.LoginDao;
import com.mywebsite.Service.QueryInfoService;
import com.mywebsite.bean.ChildVaccinateInfo;
/*
 * ҽ�����׶���������ִ���
 */
@WebServlet("/VaccinateDispose")
public class VaccinateDispose extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public VaccinateDispose() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		 //���ñ���       
	       request.setCharacterEncoding("UTF-8");
	       HttpSession session=request.getSession();
	       String idnum=request.getParameter("idnum");//�׶����֤��
	       String dusername=(String)session.getAttribute("dusername");//ҽ��ְ����
	       Date appointtime=(Date)session.getAttribute("appointtime");//ԤԼʱ��
	      //�����׶����֤�Ų�ѯ�û��˺�
	       LoginDao loginDao=new LoginDao();
	       String username=loginDao.Queryusername(idnum);
	       if(username!=null){
	       //�����׶����֤�Ų�ѯ�׶���������
	       QueryInfoService queryInfo=new QueryInfoService();
	       Date Age=queryInfo.queryChildBirth(idnum);
	       //�����׶�Ŀǰ�꣨�£���
	        Date date=new Date(System.currentTimeMillis());
	      int age=(int) (date.getTime()/86400000-Age.getTime()/86400000);
            //��ȡ�������Ϊ�׶�����
      	    age=age/30;
	      //�������Ϣ������������ַ�װ����
	       ChildVaccinateInfo childVaccinateInfo=new ChildVaccinateInfo();
	       childVaccinateInfo.setIdnum(idnum);
	       childVaccinateInfo.setDusername(dusername);
	       childVaccinateInfo.setUsername(username);
	       childVaccinateInfo.setAppointtime(appointtime);
	       childVaccinateInfo.setAge(age);
	       //����Ϣ�洢��session��
	       session.setAttribute("childVaccinateInfo", childVaccinateInfo);
	       session.setAttribute("age", age);
	     //ҳ����ת
	       RequestDispatcher rd = request.getRequestDispatcher("vaccine.jsp");
		   rd.forward(request, response);
	      }
	      else{
	    	  request.setAttribute("info", "���ݿ����޴��׶���Ϣ����˶Ժ��ѯ��");
	    	  request.setAttribute("page", "vaccinedispose.jsp");
	    	  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/result.jsp");
			  rd.forward(request, response);
	      }
	       
	}
	      
	

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}
