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

import com.mywebsite.Dao.ChildInfoAlterDao;
@WebServlet("/ChildInfoAlter")
/**
 * 
 * �׶�������Ϣ��ӿ���
 *
 */
public class ChildInfoAlter extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public ChildInfoAlter() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
			{
		      //���ñ���       
		        request.setCharacterEncoding("UTF-8");
	           	HttpSession session=request.getSession();      
		      //��ȡҳ��Ĳ���
	           String childname = request.getParameter("childname");
	           String childgender = request.getParameter("childgender");
	           String birth = request.getParameter("childbirth");
	           String idnum = request.getParameter("idnum");
	           String username=(String)session.getAttribute("username");
	           //���ڸ�ʽת��
			   Date childbirth=Date.valueOf(birth);
	           //����ChildInfoAlterDao����������ݴ���
	           ChildInfoAlterDao childinfoalterdao=new ChildInfoAlterDao();
			   childinfoalterdao.childinfoalter(childname, childgender,childbirth, idnum,username);
	           request.setAttribute("page", "ChildInfoAlter.jsp");
	           request.setAttribute("info", "�׶���Ϣ����ɹ�!");//  ����result.jsp��ʹ�õ���Ϣ
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
