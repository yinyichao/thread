package service.perimeter.hk;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import pojo.PlantPerimeterIp;
import util.MybatisUtil;
import dao.PlantPerimeterIpMapper;
import dao.PlantPerimeterMapper;

public class PlantPerimeterIpService {
	public static void main(String[] args){
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		try {
			PlantPerimeterIpMapper plantPerimeterIpMapper = sqlSession.getMapper(PlantPerimeterIpMapper.class);
			PlantPerimeterMapper plantPerimeterMapper = sqlSession.getMapper(PlantPerimeterMapper.class);
			List<PlantPerimeterIp> ll = plantPerimeterIpMapper.findAll();
			for(PlantPerimeterIp p:ll){
				PlantPerimeterIp plantPerimeterIp = new PlantPerimeterIp();
				plantPerimeterIp.setCode(p.getCode());
				plantPerimeterIp.setIp(p.getIp());
				plantPerimeterMapper.updateCode(plantPerimeterIp);
			}
			sqlSession.commit();
		} finally {
			sqlSession.rollback();
		}
	}
}
