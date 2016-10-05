package com.mywebsite.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mywebsite.Service.MessageService;
@WebServlet("/MessageInfo")
public class MessageInfo extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public MessageInfo() {
		super();
	}
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		  request.setCharacterEncoding("UTF-8");
		  String mobile=request.getParameter("mobile");
		  MessageService messageService=new MessageService();
		  try {
			messageService.MessageInform(mobile);
			request.setAttribute("page", "InformVaccination.jsp");
			request.setAttribute("info","�����ѷ���");
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
			request.setAttribute("page", "InformVaccination.jsp");
			System.out.print("�����쳣");
		}
		  finally{
			  RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/result.jsp");
			  rd.forward(request, response);
		  }
	 	  
	}


}
