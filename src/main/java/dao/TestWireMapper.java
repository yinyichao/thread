package dao;

import org.apache.ibatis.annotations.Insert;

import pojo.TestWire;

public interface TestWireMapper {
		@Insert("insert into test_wire(id,status,highvalue1,highvalue2,lowvalue1,lowvalue2,in_time) values(#{id},#{status},#{highvalue1},#{highvalue2},#{lowvalue1},#{lowvalue2},#{in_time}) ")
		public void insert(TestWire testWire);
}
