package com.mywebsite.Servlet;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.WebServlet;

import com.mywebsite.Dao.LoginDao;
import com.mywebsite.ValidationCode.CheckValidationCode;
import com.mywebsite.ValidationCode.Encrypter;
import com.mywebsite.bean.UserInfo;

import java.io.IOException;
@WebServlet("/UserLogin")
/**
 * 
 * �û���¼����
 *
 */
public class UserLogin extends HttpServlet
{

	private static final long serialVersionUID = 1L;
	
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//  �������register����������ض���register.jspҳ��
		//���ñ���       
        request.setCharacterEncoding("UTF-8");
		HttpSession session=request.getSession();
		session.setMaxInactiveInterval(1800);//����session�ĻỰ��Чʱ��
		//String JSESSIONID=session.getId();
		//Cookie cookie = new Cookie("JSESSIONID",JSESSIONID);
		//cookie.setMaxAge(-1);
		String page = "login_U.jsp";
		String userName = "";
		try
		{	
			userName = request.getParameter("username");		
			String password = request.getParameter("password");
			String validationCode = request.getParameter("validation_code");
			if (userName == null || password == null || validationCode == null)
				return;
			if (userName.equals("") || password.equals("") || validationCode.equals(""))
				return;
			CheckValidationCode check=new CheckValidationCode();
			// �˶���֤��
			if(!check.checkValidationCode(request, validationCode))
			{
				return;
			}	 	
			//���ݿ��ѯ����
			LoginDao userLoginDao=new LoginDao();
			UserInfo UserName=userLoginDao.Queryuserinfo(userName);
			// ��ѯ��¼�û��Ƿ����
			if (UserName==null)
			{
				//  ����������login_U.jsp����ʾ���û���������Ϣ
				request.setAttribute("userError", userName + "������");
			}
			else
			{
				//  �õ���¼�û���MD5�����ַ���
				String passwordMD5 = Encrypter.md5Encrypt(password);
				if(!UserName.getPassword().equals(passwordMD5))
				{
				//  ����������login_U.jsp����ʾ�����������Ϣ
					request.setAttribute("passwordError", "�������");
				}
				else
				{
					//  ��¼�ɹ�������Ҫת����ҳ��
					page = "/WEB-INF/front/PerCenter.jsp";
					session.setAttribute("username",userName );
				}
			}

		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		finally		
		{
			// ���û���������request��
			request.setAttribute("username", userName);			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response);//  ת����Ӧ��ҳ�棨Ĭ����login.jsp��
		}
	}
}
