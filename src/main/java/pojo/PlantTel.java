package pojo;

import java.util.Date;
import java.util.List;
import org.apache.ibatis.session.SqlSession;
import util.HttpUtil;
import util.JsonUtil;
import util.MybatisUtil;
import dao.PlantTelMapper;
import dao.PlantTelRegionMapper;

public class PlantTel {

	private String id;
	private String number;
	private String name;
	private String sn;
	private String position;
	private Integer type;
	private Integer level;
	private String ip;
	private String mac;
	private String orgFid;
	private String superFid;
	private String model;
	private Integer deleted;
	private String pid;
	private String fid;
	private String location;
	private String regionId;
	private Integer status;
	private String code;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

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

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSn() {
		return sn;
	}

	public void setSn(String sn) {
		this.sn = sn;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getOrgFid() {
		return orgFid;
	}

	public void setOrgFid(String orgFid) {
		this.orgFid = orgFid;
	}

	public String getSuperFid() {
		return superFid;
	}

	public void setSuperFid(String superFid) {
		this.superFid = superFid;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
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

	public String getRegionId() {
		return regionId;
	}

	public void setRegionId(String regionId) {
		this.regionId = regionId;
	}

	public static void plantTelSet() {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PlantTelRegionMapper plantTelRegionMapper = sqlSession.getMapper(PlantTelRegionMapper.class);
		List<PlantTelRegion> plist = plantTelRegionMapper.findIdList();
		for (PlantTelRegion p : plist) {
			String result = HttpUtil.getJsonByInternet("http://10.26.61.113:80/api/getTerminalList?orgFID=" + p.getCode());
			TelDate source = JsonUtil.jsonObjToObject(result.toLowerCase(),TelDate.class);
			PlantTelMapper plantTelMapper = sqlSession.getMapper(PlantTelMapper.class);
			try {
				for (Tel pt : source.getData()) {
					String id = plantTelMapper.findId();
					PlantTel plantTel = new PlantTel();
					plantTel.setId(id);
					plantTel.setCode(pt.getFid());
					plantTel.setDeleted(pt.getDeleted());
					plantTel.setFid("2");
					plantTel.setInTime(new Date());
					plantTel.setIp(pt.getIp());
					plantTel.setName(pt.getName());
					plantTel.setLocation(pt.getName());
					plantTel.setMac(pt.getMac());
					plantTel.setModel(pt.getModel());
					plantTel.setOrgFid(pt.getOrg_fid());
					plantTel.setPosition(pt.getPositon());
					plantTel.setStatus(0);
					plantTel.setRegionId(p.getId());
					plantTel.setSuperFid(pt.getSuper_fid());
					plantTel.setType(pt.getType());
					plantTel.setSn(pt.getSn());
					plantTel.setPid("1");
					plantTelMapper.insertPlantTel(plantTel);
					sqlSession.commit();
				}
			} finally {
				sqlSession.rollback();
			}
		}
	}
}