package com.mywebsite.Service;

import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
public class MessageService {

	public void MessageInform(String mobile) throws Exception{
		
		 HttpClient client = new HttpClient();  
	     PostMethod post = new PostMethod("http://utf8.sms.webchinese.cn");  
	     // ��httpͷ�ļ�������ת��  
	     post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=utf8");          
	     // ע����û��� 
	     NameValuePair[] data = { new NameValuePair("Uid", "����_childname"), 
	     // ע��ɹ���,��¼��վʹ�õ���Կ 
	     new NameValuePair("Key", "2ae64c240cae4943b5bc"),  
	     // �ֻ����� 
	     new NameValuePair("smsMob", mobile),  
	     //���ö�������
	     new NameValuePair("smsText", "���ĺ��ӽ���ʱ����δ���ֵ����磬��ǰ���ͽ�����ҽԺ����������֣�") }; 
	     post.setRequestBody(data);  
	     client.executeMethod(post);  
	     Header[] headers = post.getResponseHeaders();  
	     int statusCode = post.getStatusCode();  
	     System.out.println("statusCode:" + statusCode);  
	     for (Header h : headers) {  
	         System.out.println(h.toString());  
	     }  
	     String result = new String(post.getResponseBodyAsString().getBytes("utf8")); 
	               
	     System.out.println(result);  //��ӡ������Ϣ״̬
	     post.releaseConnection();  
	}
}
