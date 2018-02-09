package util;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import pojo.PlantDict;
import dao.PlantDictMapper;

public class XmlUtil {
	public static String zuzhi() throws Exception {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PlantDictMapper plantDictMapper = sqlSession.getMapper(PlantDictMapper.class);
		PlantDict plantDict = new PlantDict();
		plantDict.setName("hk");
		plantDict.setVm("vmcc");
		plantDict.setType(4);
		
		String hkUrl=plantDictMapper.getPlantDictUrl(plantDict).get(1);
		String vmcc = plantDictMapper.getPlantDictUrl(plantDict).get(0);
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient(hkUrl);
		Object[] result = client.invoke("getAllResourceDetail",vmcc, 1000);
		return String.valueOf(result[0]);
	}
	
	public static String camera(String orgCode) throws Exception {
		SqlSession sqlSession = MybatisUtil.getSqlSession();
		PlantDictMapper plantDictMapper = sqlSession.getMapper(PlantDictMapper.class);
		PlantDict plantDict = new PlantDict();
		plantDict.setName("hk");
		plantDict.setType(4);
		plantDict.setVm("vmcc");
		String hkUrl=plantDictMapper.getPlantDictUrl(plantDict).get(1);
		String vmcc = plantDictMapper.getPlantDictUrl(plantDict).get(0);
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory.newInstance();
		Client client = clientFactory.createClient(hkUrl);
		Object[] result = client.invoke("getAllResourceDetailByOrg",vmcc, orgCode, 10000);
		return String.valueOf(result[0]);
	}
	
	public static Element xmlToBean(String code,String fnode) throws UnsupportedEncodingException, DocumentException, Exception{
		SAXReader reader = new SAXReader();
		Document document = reader.read(new ByteArrayInputStream(code.getBytes("UTF-8")));
		System.out.println(document);
		Element node = document.getRootElement();
		return node.element(fnode);
	}
	public static void main(String[] args) {
		try {
			System.out.println(camera("12345677005000000001"));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
