package com.mywebsite.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mywebsite.Dao.UserInfoAlterDao;
@WebServlet("/DocInfoAlter")
/*
 * ҽ��������Ϣ�޸Ŀ���
 */
public class DocInfoAlter extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DocInfoAlter() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
			{
		//���ñ���       
        request.setCharacterEncoding("UTF-8");
		       HttpSession session=request.getSession();
		       //��ҳ���ȡ�������
		       String drelname=request.getParameter("drelname");
		       String dgender=request.getParameter("gdender");
		       String dmobile=request.getParameter("dmobile");
		       String major=request.getParameter("major");
		       //��session�л�ȡ�û���
		       String dusername=(String)session.getAttribute("dusername");		       
		       request.setAttribute("page", "DocInfoAlter.jsp");
		       UserInfoAlterDao docInfoAlter=new UserInfoAlterDao();
		       docInfoAlter.docinfoalter(dusername, drelname, dgender,dmobile,major);
		       request.setAttribute("info", "������Ϣ����ɹ�!");//  ����result.jsp��ʹ�õ���Ϣ
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
