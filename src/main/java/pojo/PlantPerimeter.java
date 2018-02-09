package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.dom4j.Element;

import util.MybatisUtil;
import dao.PlantPerimeterMapper;
import dao.PlantPerimeterRegionMapper;

public class PlantPerimeter {

	private String id;
	private String name;
	private String code;
	private String type;
	private String terrace;
	private String x;
	private String z;
	private String y;
	private String port;
	private String userName;
	private String password;
	private String addressUrl;
	private Integer status;
	private String remark;
	private String regionId;
	private String pid;
	private String fid;
	private String location;
	private Date inTime;

	public Date getInTime() {
		return inTime;
	}

	public void setInTime(Date inTime) {
		this.inTime = inTime;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTerrace() {
		return terrace;
	}

	public void setTerrace(String terrace) {
		this.terrace = terrace;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getZ() {
		return z;
	}

	public void setZ(String z) {
		this.z = z;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getAddressUrl() {
		return addressUrl;
	}

	public void setAddressUrl(String addressUrl) {
		this.addressUrl = addressUrl;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public String getPid() {
		return pid;
	}

	public void setPid(String pid) {
		this.pid = pid;
	}

	public String getFid() {
		return fid;
	}

	public void setFid(String fid) {
		this.fid = fid;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	public static void plantPerimeterSet(Element items,String id) throws ParseException{
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			PlantPerimeterRegionMapper perimeterRegionMapper = sqlSession.getMapper(PlantPerimeterRegionMapper.class);
			PlantPerimeterMapper plantPerimeterMapper = sqlSession.getMapper(PlantPerimeterMapper.class);
			@SuppressWarnings("unchecked")
			List<Element> elements = items.elements("row");
			int i = 17000;
			for (Element author : elements) {
				PlantPerimeter plantPerimeter = new PlantPerimeter();
//				plantPerimeter.setId("10"+author.attributeValue("i_id"));
				plantPerimeter.setCode(author.attributeValue("c_index_code"));
				plantPerimeter.setName(author.attributeValue("c_name"));
				plantPerimeter.setType(author.attributeValue("i_device_detail_type"));
				plantPerimeter.setAddressUrl(author.attributeValue("c_device_ip"));
				plantPerimeter.setPort(author.attributeValue("i_device_port"));
				plantPerimeter.setStatus(Integer.parseInt((author.attributeValue("i_status"))));
				plantPerimeter.setRegionId(id);
				plantPerimeter.setPid("1");
				plantPerimeter.setFid("1");
				plantPerimeter.setLocation(author.attributeValue("c_name"));
				plantPerimeter.setInTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(author.attributeValue("c_update_time")));
				plantPerimeter.setRemark("888800000000000"+i);
				plantPerimeterMapper.insertPlantPerimeterRegion(plantPerimeter);		
				i++;
			}
			sqlSession.commit();
			System.out.println("保存成功");
		} finally {
			sqlSession.rollback();
		}
	}
}