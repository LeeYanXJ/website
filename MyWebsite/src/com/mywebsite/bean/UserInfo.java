package com.mywebsite.bean;
/*
 * ���ڷ�װ�û���Ϣ��JavaBean
 */
public class UserInfo {
		//�û���¼���û���
		private String username;
		//�û���¼����
		private String password;
		//�û��ʼ���ַ
		private String email;
		//�û���ʵ����
		private String name;
		//�û��Ա�
		private String gender;
		//�û��ֻ���
		private String mobile;
		//�û�����
		private String birthplace;
		//�û���ͥ�绰
		private String homephone;
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getGender() {
			return gender;
		}
		public void setGender(String gender) {
			this.gender = gender;
		}
		public String getMobile() {
			return mobile;
		}
		public void setMobile(String mobile) {
			this.mobile = mobile;
		}
		public String getBirthplace() {
			return birthplace;
		}
		public void setBirthplace(String birthplace) {
			this.birthplace = birthplace;
		}
		public String getHomephone() {
			return homephone;
		}
		public void setHomephone(String homephone) {
			this.homephone = homephone;
		}
		
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		

	}
