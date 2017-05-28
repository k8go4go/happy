package kr.heartof.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BringSqlSession {
	private static SqlSession session = null; 
	static {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory;
		try {
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
			session = sqlSessionFactory.openSession();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static <T> T getMapper(Class<T> arg) {
		return session.getMapper(arg);
	}
	
	public static void sessionClose() {
		session.clearCache();
		session.close();
	}
}
