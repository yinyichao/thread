package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pojo.Student;

public interface StudentMapper {
	@Select("select * from student")
	List<Student> findAllStudent();
}
