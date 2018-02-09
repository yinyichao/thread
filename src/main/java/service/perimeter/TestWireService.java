package service.perimeter;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.TestWire;
import dao.TestWireMapper;

public class TestWireService {
		
	public void insert(TestWire testWire) throws IOException {
    	Reader reader = Resources.getResourceAsReader("config.xml");
    	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = factory.openSession();
    	TestWireMapper mapper = sqlSession.getMapper(TestWireMapper.class);
    	mapper.insert(testWire);
    }
}
