package dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import pojo.PlantTel;

public interface PlantTelMapper {
	
	@Insert("insert into plant_tel(id,name,sn,position,type,ip,mac,org_fid,super_fid,model,deleted,pid,fid,location,region_id,status,code,in_time) values(#{id},#{name},#{sn},#{position},#{type},#{ip},#{mac},#{orgFid},#{superFid},#{model},#{deleted},#{pid},#{fid},#{location},#{regionId},#{status},#{code},#{inTime})")
	void insertPlantTel(PlantTel plantTel);
	
	@Select("select nvl(max(TO_NUMBER(id)),0)+1 from plant_tel")
	String findId();
}
