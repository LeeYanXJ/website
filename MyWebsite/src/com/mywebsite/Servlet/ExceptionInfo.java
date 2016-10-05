package com.mywebsite.Servlet;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mywebsite.Dao.ChildVaccinateInfoDao;
@WebServlet("/ExceptionInfo")
public class ExceptionInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ExceptionInfo() {
		super();
	}

	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//  �������register����������ض���register.jspҳ��
		//���ñ���       
        request.setCharacterEncoding("UTF-8");
        String childname=request.getParameter("childname");//�׶�����
        String idnum=request.getParameter("idnum");//�׶����֤��
        String vaccine=request.getParameter("vaccine");//��������
        String factory=request.getParameter("factory");//��������
        String vaccinenum=request.getParameter("vaccinenum");//��������
        String Indate=request.getParameter("indate");//��Ч��
        String Vaccinatetime=request.getParameter("vaccinatetime");//��������
        String Reaction=request.getParameter("reaction");//��Ӧ����
        String symptom=request.getParameter("symptom");//��Ӧ֢״
        //���ڸ�ʽת��
        Date indate=Date.valueOf(Indate);
        Date vaccinatetime=Date.valueOf(Vaccinatetime);
        Date reaction=Date.valueOf(Reaction);
        ChildVaccinateInfoDao exceptioninfodao=new ChildVaccinateInfoDao();
        exceptioninfodao.insertExceptionInfo(childname, idnum, vaccine,factory,vaccinenum, indate, vaccinatetime, reaction, symptom);
        request.setAttribute("info", "��ӳɹ���");
        request.setAttribute("page", "exceptioninfo.jsp");
        RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/front/result.jsp");
		rd.forward(request, response);
	}

}
