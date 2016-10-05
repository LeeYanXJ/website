package com.mywebsite.Servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mywebsite.Dao.LoginDao;
import com.mywebsite.ValidationCode.Encrypter;
import com.mywebsite.bean.UserInfo;
@WebServlet("/UserPwdAlter")
public class UserPwdAlter extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public UserPwdAlter() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		String againpwd=request.getParameter("againpwd");
		LoginDao userLoginDao=new LoginDao();
		String username=(String)session.getAttribute("username");
		UserInfo UserName=userLoginDao.Queryuserinfo(username);
		try {
		  if(againpwd.equals(newpwd)){
			String passwordMD5 = Encrypter.md5Encrypt(oldpwd);
			if(!UserName.getPassword().equals(passwordMD5))
				request.setAttribute("info", "ԭ�������");
			else {
				String newpwdMD5 = Encrypter.md5Encrypt(newpwd);//���������MD5����
				LoginDao loginDao=new LoginDao();
				loginDao.ChangeUserPwd(newpwdMD5,username);
				request.setAttribute("info", "�����޸ĳɹ�!");//  ����result.jsp��ʹ�õ���Ϣ
			}
		  }
		  else
				request.setAttribute("info", "�����벻һ�£�");
			
		} catch (Exception e){ 
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
			finally		
			{		
				request.setAttribute("page","UserPwdAlter.jsp");
				 RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/front/result.jsp");
				rd.forward(request, response);
			}
		}

}
