package com.mywebsite.DB;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * �������ݿ�
 *
 */
public class DBAccess {

	public SqlSession getSqlSession() throws IOException {
		//ͨ�������ļ���ȡ���ݿ�������Ϣ
		Reader reader=Resources.getResourceAsReader("com/mywebsite/config/Configuration.xml");
		//ͨ������������Ϣ��ȡSqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		//ͨ��SqlSessionFactory��һ�����ݿ�Ự
		SqlSession sqlSession=sqlSessionFactory.openSession();
		return sqlSession;
	}

}
