package service.tel.mdbe;

import org.apache.ibatis.session.SqlSession;

import pojo.PlantDict;
import pojo.PlantTelRegion;
import pojo.TelRegionDate;
import util.HttpUtil;
import util.JsonUtil;
import util.MybatisUtil;
import dao.PlantDictMapper;

public class PlantTelRegionService {

	public static void main(String[] args) {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PlantDictMapper plantDictMapper = sqlSession.getMapper(PlantDictMapper.class);
		PlantDict plantDict = new PlantDict();
		plantDict.setName("mdbe");		
		plantDict.setType(4);
		String mdbeUrl =plantDictMapper.getPlantDictUrl(plantDict).get(0); 
		System.out.println(mdbeUrl);
		
		String result = HttpUtil.getJsonByInternet(mdbeUrl+"/getOrgList");
		TelRegionDate source = JsonUtil.jsonObjToObject(result.toLowerCase(), TelRegionDate.class);
		PlantTelRegion.plantTelRegionSet(source);
		System.out.println("success");
	}
}
