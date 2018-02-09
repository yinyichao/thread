package pojo;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.dom4j.Element;

import util.MybatisUtil;
import dao.PlantPerimeterRegionMapper;

public class PlantPerimeterRegion {

	private String id;
	private String name;
	private String remarks;
	private String parentId;
	private String code;
	private String regionLevel;
	private Integer source;

	public PlantPerimeterRegion(String remarks,String id){
		this.remarks = remarks;
		this.id = id;
	}
	public PlantPerimeterRegion(){
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRegionLevel() {
		return regionLevel;
	}

	public void setRegionLevel(String regionLevel) {
		this.regionLevel = regionLevel;
	}

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}
	
	public static void plantPerimeterRegionSet(Element items){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			PlantPerimeterRegionMapper plantPerimeterRegionMapper = sqlSession.getMapper(PlantPerimeterRegionMapper.class);
			@SuppressWarnings("unchecked")
			List<Element> elements = items.elements("row");
			for (Element author : elements) {
				PlantPerimeterRegion plantPerimeterRegion = new PlantPerimeterRegion();
//				plantPerimeterRegion.setId("10"+author.attributeValue("i_id"));
				plantPerimeterRegion.setRemarks(author.attributeValue("c_index_code"));
				plantPerimeterRegion.setName(author.attributeValue("c_org_name"));
				plantPerimeterRegion.setParentId(author.attributeValue("i_parent_id"));
				plantPerimeterRegion.setRegionLevel(author.attributeValue("i_level"));
				plantPerimeterRegion.setSource(1);
				plantPerimeterRegion.setCode("02");
				plantPerimeterRegionMapper.insertPlantPerimeterRegion(plantPerimeterRegion);
			}
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
		}
	}
	
	public static List<PlantPerimeterRegion> findCodeList(){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PlantPerimeterRegionMapper perimeterRegionMapper = sqlSession.getMapper(PlantPerimeterRegionMapper.class);
		return perimeterRegionMapper.findCodeList();
	}
}