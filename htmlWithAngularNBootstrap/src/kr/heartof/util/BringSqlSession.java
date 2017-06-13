package kr.heartof.util;

import java.io.IOException;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class BringSqlSession {
	private static SqlSession session = null;
	private static String resource = "common/config/sqlMapConfig.xml";

	public static SqlSession getInstance() {
		if (session == null) {
			SqlSessionFactory sqlSessionFactory;
			try {
				sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
				session = sqlSessionFactory.openSession();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return session;
	}

	public static <T> T getMapper(Class<T> arg) {
		if(session == null) {
			session = getInstance();
		} else {
			session.clearCache();
		}
		return session.getMapper(arg);
	}

	public static void sessionClose() {
		if(session != null)
			session.close();
	}
}
