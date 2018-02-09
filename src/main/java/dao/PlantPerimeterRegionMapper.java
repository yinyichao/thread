package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import pojo.PlantPerimeterRegion;

public interface PlantPerimeterRegionMapper {
	@Insert("insert into plant_perimeter_region(id,name,remarks,parent_id,region_level,source,code) values(#{id},#{name},#{remarks},#{parentId},#{regionLevel},#{source},#{code})")
	@SelectKey(statement = "select nvl(max(TO_NUMBER(id)),0)+1 from plant_perimeter_region", keyProperty = "id", before = true, resultType = String.class)
	void insertPlantPerimeterRegion(PlantPerimeterRegion plantPerimeterRegion);
	@Select("select id from plant_perimeter_region where remarks=#{code}")
	String findIdByCode(String code);
	@Select("select remarks,id from plant_perimeter_region where code = '02' ")
	List<PlantPerimeterRegion> findCodeList();
}
