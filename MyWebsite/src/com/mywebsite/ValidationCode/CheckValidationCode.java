package com.mywebsite.ValidationCode;

import javax.servlet.http.HttpServletRequest;

public class CheckValidationCode {
	public boolean checkValidationCode(HttpServletRequest request, String validationCode)
	{
		//  ��HttpSession�����л��ϵͳ������ɵ���֤��
		String validationCodeSession = (String)request.getSession().getAttribute("validation_code");
		
		//  �����õ���֤��Ϊnull��˵����֤����ڣ��û�����ˢ�¿ͻ���ҳ�棬�����»���µ���֤��
		if(validationCodeSession == null)
		{			
			request.setAttribute("info", "��֤�����");//  ����result.jsp��Ҫ�Ľ����Ϣ
			request.setAttribute("codeError", "��֤�����");//  ����login.jsp��Ҫ�Ҵ�����Ϣ	
			return false;
		}
		//  ���û��������֤���ϵͳ������ɵ���֤����бȽ�
		if(!validationCode.equalsIgnoreCase(validationCodeSession))
		{
			request.setAttribute("info", "��֤�벻��ȷ");//  ����result.jsp��Ҫ�Ľ����Ϣ
			request.setAttribute("codeError", "��֤�벻��ȷ");//  ����login.jsp��Ҫ�Ĵ�����Ϣ
			return false;
		}
		return true;
	}

}
