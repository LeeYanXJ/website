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
import com.mywebsite.bean.DocInfo;

@WebServlet("/DocPwdAlter")
public class DocPwdAlter extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DocPwdAlter() {
		super();
	}
	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		String oldpwd=request.getParameter("oldpwd");
		String newpwd=request.getParameter("newpwd");
		String againpwd=request.getParameter("againpwd");
		LoginDao userLoginDao=new LoginDao();
		String dusername=(String)session.getAttribute("dusername");
		DocInfo docinfo=userLoginDao.Querydocinfo(dusername);
		try {
		  if(againpwd.equals(newpwd)){
			String passwordMD5 = Encrypter.md5Encrypt(oldpwd);
			if(!docinfo.getDpassword().equals(passwordMD5))
				request.setAttribute("info", "ԭ�������");
			else {
				String newpwdMD5 = Encrypter.md5Encrypt(newpwd);//���������MD5����
				LoginDao loginDao=new LoginDao();
				loginDao.ChangeDocPwd(newpwdMD5,dusername);
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
