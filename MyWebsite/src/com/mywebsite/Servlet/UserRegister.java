package com.mywebsite.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mywebsite.Dao.RegisterDao;
import com.mywebsite.ValidationCode.CheckValidationCode;
import com.mywebsite.ValidationCode.Encrypter;
@WebServlet("/UserRegister")
public class UserRegister extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UserRegister() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//���ñ���       
        request.setCharacterEncoding("UTF-8");
		String userName = null;	
		if(request.getParameter("login")!=null){
			response.sendRedirect("login_U.jsp");
			return;
		}
		//  ��������������try{...}ǰ�棬��������finally�е�forward,
		//  �ڵ���sendRedirect�����󣬲����ٵ���forward����
		try
		{
			userName = request.getParameter("username");//  ���username
			String password = request.getParameter("password");//  ���password
			String email = request.getParameter("email");//  ���email
			String name = request.getParameter("name");
			String gender = request.getParameter("gender");
			String mobile = request.getParameter("mobile");
			String homephone = request.getParameter("homephone");
			String birthplace = request.getParameter("birthplace");
			//  �����֤��
			String validationCode = request.getParameter("validation_code");
			// �û��������벻��Ϊnull
			if(userName == null || password == null || validationCode == null) return;
			// �û����������������
			if(userName.equals("") || password.equals("") || validationCode.equals("")) return;
			 //  ��result.jsp��Ҫ��ת��login_U.jspҳ
	        request.setAttribute("page", "login_U.jsp");
			//  �˶���֤��
			CheckValidationCode check=new CheckValidationCode();
			if(!check.checkValidationCode(request, validationCode))
			{
				request.setAttribute("page", "register.jsp");
				return;
			}				
			// ��MD5�㷨�������ַ�������
			String passwordMD5 = Encrypter.md5Encrypt(password);
	        RegisterDao registerDao=new RegisterDao();
	        registerDao.adduserinfo(userName, passwordMD5, email,name,gender,mobile,homephone,birthplace);
	      
			request.setAttribute("info", "�û�ע��ɹ�!");//  ����result.jsp��ʹ�õ���Ϣ
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			request.setAttribute("page", "register.jsp");
			request.setAttribute("info", userName + "�Ѿ���ʹ��!");
		}
		finally
		{
			//  ת����result.jsp
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/result.jsp");
			rd.forward(request, response);
		}
	}

}
