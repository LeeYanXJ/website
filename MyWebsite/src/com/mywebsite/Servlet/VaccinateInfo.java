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

import com.mywebsite.Dao.ChildAppointInfoDao;
import com.mywebsite.Dao.LoginDao;
import com.mywebsite.Service.QueryInfoService;
import com.mywebsite.bean.ChildVaccinateInfo;
@WebServlet("/VaccinateInfo")
/*
 * ���������Ϣ����
 */
public class VaccinateInfo extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public VaccinateInfo() {
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
	       String Appointtime=request.getParameter("appointtime");//ԤԼʱ��
	       //���ڸ�ʽת��
	       Date appointtime=Date.valueOf(Appointtime);
	      //�����׶����֤��ɾ���û�ԤԼ��Ϣ
	       ChildAppointInfoDao childAppointInfoDao=new ChildAppointInfoDao();
	       childAppointInfoDao.Deleteappointinfo(idnum);
	       //�����׶����֤�Ų�ѯ�û��˺�
	       LoginDao loginDao=new LoginDao();
	       String username=loginDao.Queryusername(idnum);
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
	       session.setAttribute("idnum", idnum);
	       //ҳ����ת
	       RequestDispatcher rd = request.getRequestDispatcher("vaccine.jsp");
		   rd.forward(request, response);
		
	}
	
	
	
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

}
