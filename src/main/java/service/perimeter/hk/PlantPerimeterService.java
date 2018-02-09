package service.perimeter.hk;


import java.io.UnsupportedEncodingException;
import java.util.List;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import pojo.PlantPerimeter;
import pojo.PlantPerimeterRegion;
import util.XmlUtil;


public class PlantPerimeterService {
	public static void main(String[] args) throws UnsupportedEncodingException,DocumentException, Exception {	
		List<PlantPerimeterRegion> plist = PlantPerimeterRegion.findCodeList();
		for(PlantPerimeterRegion p:plist){
			String resultXML = XmlUtil.camera(p.getRemarks());
			Element items = XmlUtil.xmlToBean(resultXML, "rows");
			PlantPerimeter.plantPerimeterSet(items,p.getId());
		}
		System.out.println(plist.size());
		System.out.println("成功！");
	}

}
