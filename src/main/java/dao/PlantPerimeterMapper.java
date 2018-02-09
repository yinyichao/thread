package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import pojo.PlantPerimeter;
import pojo.PlantPerimeterIp;

public interface PlantPerimeterMapper {
	@Insert("insert into plant_perimeter(id,name,code,type,port,address_url,status,region_id,pid,fid,location,in_time,remark) values(#{id},#{name},#{code},#{type},#{port},#{addressUrl},#{status},#{regionId},#{pid},#{fid},#{location},#{inTime},#{remark})")
	@SelectKey(statement = "select nvl(max(TO_NUMBER(id)),0)+1 from plant_perimeter", keyProperty = "id", before = true, resultType = String.class)
	void insertPlantPerimeterRegion(PlantPerimeter plantPerimeter);
	@Update("update plant_perimeter set remark=#{code} where address_url=#{ip}")
	void updateCode(PlantPerimeterIp plantPerimeterIp);
}
