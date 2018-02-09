package dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pojo.PlantTelRegion;

public interface PlantTelRegionMapper {
	@Insert("insert into plant_tel_region(id,name,code,parent_id,region_level,source) values(#{id},#{name},#{code},#{parentId},#{regionLevel},#{source})")
	void insertPlantTelRegion(PlantTelRegion plantTelRegion);
	@Select("select nvl(max(TO_NUMBER(id)),0)+1 from plant_tel_region")
	String findId();
	@Select("select id from plant_tel_region where code=#{code}")
	String findIdByCode(String code);
	@Select("select * from plant_tel_region")
	List<PlantTelRegion> findIdList();
}
