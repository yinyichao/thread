package dao;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import pojo.PlantPerimeterIp;

public interface PlantPerimeterIpMapper {
	@Select("select * from plant_perimeter_ip")
	List<PlantPerimeterIp> findAll();	
}
