package dao;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import pojo.PlantDict;

public interface PlantDictMapper {
	@Select("select code from plant_dict where name=#{name} or name=#{vm} and type=#{type}")
	List <String> getPlantDictUrl(PlantDict plantDict);
}
