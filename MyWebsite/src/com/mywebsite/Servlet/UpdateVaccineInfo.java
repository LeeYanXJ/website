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

import com.mywebsite.Dao.ChildVaccinateInfoDao;
import com.mywebsite.bean.ChildVaccinateInfo;
@WebServlet("/UpdateVaccineInfo")
/*
 * ���������Ϣ���
 */
public class UpdateVaccineInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	/**
	 * Constructor of the object.
	 */
	public UpdateVaccineInfo() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//���ñ���       
	    request.setCharacterEncoding("UTF-8");
	    HttpSession session=request.getSession();
	    //����ҳ�����
		String vaccine=request.getParameter("vaccine");//��������
		String vaccinetimes=request.getParameter("vaccinetimes");//���ִ���
		String vaccineTime=request.getParameter("vaccinetime");//����ʱ��
	    //���ڸ�ʽת��
	    Date vaccinetime=Date.valueOf(vaccineTime);
	    String vaccinenum=request.getParameter("vaccinenum");//��������
	    ChildVaccinateInfo childVaccinateInfo=new ChildVaccinateInfo();
	    childVaccinateInfo=(ChildVaccinateInfo)session.getAttribute("childVaccinateInfo");
	    
	    String username=childVaccinateInfo.getUsername();//�û��˺�
	    String dusername=childVaccinateInfo.getDusername();//ҽ��ְ����
	    String idnum=childVaccinateInfo.getIdnum();//�׶����֤��
	    int age=childVaccinateInfo.getAge();
	    Date appointtime=childVaccinateInfo.getAppointtime();//ԤԼʱ��
	    //�����ݿ��в������������Ϣ
	     ChildVaccinateInfoDao childVaccinateInfoDao=new ChildVaccinateInfoDao();
	     childVaccinateInfoDao.InsertVaccineInfo(vaccine,vaccinetimes,appointtime,vaccinetime,vaccinenum,idnum,username,dusername,age);
	    //��Ϣ��ʾ��ҳ����ת
	    request.setAttribute("page", "vaccineinfo.jsp");
        request.setAttribute("info", "��ӳɹ�!");
        RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/result.jsp");
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
