package service.perimeter.dh;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import pojo.Student;
import dao.StudentMapper;

public class StudentService {
    public static void main(String[] args) throws IOException {
    	Reader reader = Resources.getResourceAsReader("config.xml");
    	SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
    	SqlSession sqlSession = factory.openSession();
    	StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
//    	List<Student> student = sqlSession.selectList("dao.StudentMapper.findAllStudent");
    	List<Student> student = mapper.findAllStudent();
    	for (Student student2 : student) {
			System.out.println(student2.getName());
		}
    }
}
