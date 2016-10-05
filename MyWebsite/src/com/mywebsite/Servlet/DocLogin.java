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
import com.mywebsite.Service.QueryInfoService;
import com.mywebsite.ValidationCode.Encrypter;
import com.mywebsite.bean.DocInfo;

/**
 * 
 * ����ҽ����¼����
 *
 */
@WebServlet("/DocLogin")
public class DocLogin extends HttpServlet {

	private static final long serialVersionUID = 1L;
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		    
        request.setCharacterEncoding("UTF-8");
        HttpSession session=request.getSession();
        session.setMaxInactiveInterval(1800);//����session�ĻỰ��Чʱ��
		String page = "login_D.jsp";
		String DName = "";
		try
		{			
			DName = request.getParameter("dusername");		
			String Dpassword = request.getParameter("dpassword");
			if (DName == null || Dpassword == null )
				return;
			if (DName.equals("") || Dpassword.equals(""))
				return;
			//���ݿ����
			LoginDao docLoginDao=new LoginDao();
			String DpasswordMD5=Encrypter.md5Encrypt(Dpassword);
			//���ز�ѯ��Ϣ��docinfo������
			DocInfo docinfo=docLoginDao.Querydocinfo(DName);
			if (docinfo==null)
			{
				//  ����������login_D.jsp����ʾ���û���������Ϣ
				request.setAttribute("userError",  DName+ "������");
			}
			else
			{
				if(!docinfo.getDpassword().equals(DpasswordMD5))
			      //  ����������login.jsp����ʾ�����������Ϣ
				  request.setAttribute("passwordError", "���벻��ȷ");
			    else
			    {
			     QueryInfoService  queryInfoService	= new QueryInfoService();
			     DocInfo docInfo=queryInfoService.querydocID(DName);
			     session.setAttribute("drelname", docInfo.getdrelname());
			     session.setAttribute("dusername", DName);
				 page = "/WEB-INF/front/DocCenter.jsp";
			    }
			}
		}
		catch (Exception e)
		{
			
		}
		finally		
		{
			// ���û���������request��
			request.setAttribute("dusername", DName);			
			RequestDispatcher rd = request.getRequestDispatcher(page);
			rd.forward(request, response); //ת����Ӧ��ҳ�棨Ĭ����login_D.jsp��
		}
	}
}
