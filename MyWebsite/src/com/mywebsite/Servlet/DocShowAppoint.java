package com.mywebsite.Servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mywebsite.Dao.LoginDao;
import com.mywebsite.Service.QueryInfoService;

import com.mywebsite.bean.DocAppointView;
import com.mywebsite.bean.DocInfo;
@WebServlet("/DocShowAppoint")
/*
 * Ŀ��ҽ���������е��û�ԤԼ��Ϣ����
 */
public class DocShowAppoint extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * Constructor of the object.
	 */
	public DocShowAppoint() {
		super();
	}
	protected void service(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException
	{
		//��ȡsession����
		 HttpSession session=request.getSession();
		//��ȡҳ�����
	       String Dname=request.getParameter("dusername");
	       LoginDao docLoginDao=new LoginDao();
	       DocInfo docinfo=docLoginDao.Querydocinfo(Dname);
	    //����ѯҽ������
	    if(docinfo!=null){
	      //��ҽ������ʵ����������session��   
	        session.setAttribute("drelname", docinfo.getdrelname());
	      //����Dao�����ҽ��ԤԼ��¼���ݲ�ѯ
		     QueryInfoService queryInfoService= new QueryInfoService();
		     List<DocAppointView> DocAppointInfoList=queryInfoService.querydocAppointinfo(Dname);
	      //��ѯ���������request����
	       if(DocAppointInfoList!=null&&DocAppointInfoList.size()>0)
	       {
         	  request.setAttribute("DocAppointInfoList", DocAppointInfoList);	
         	//����ת��
   	       RequestDispatcher rd=request.getRequestDispatcher("showdocappoint.jsp");
   		   rd.forward(request, response);
	       }
	       else    
               request.setAttribute("info", docinfo.getdrelname()+"ҽ����û��ԤԼ��");      
	    }
	       request.setAttribute("page", "DoctorInfoQuery.jsp");
	       //����ת��
	       RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/front/result.jsp");
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
