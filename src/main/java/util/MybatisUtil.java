package util;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisUtil {
	public static SqlSession getSqlSession(){
		SqlSession sqlSession = null;
		Reader reader;
		try {
			reader = Resources.getResourceAsReader("config.xml");
			SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
	    	sqlSession = factory.openSession();
		} catch (IOException e) {
			new RuntimeException();
		}
		return sqlSession;
	}
}
