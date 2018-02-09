package service.perimeter.hk;

import java.io.UnsupportedEncodingException;

import org.dom4j.DocumentException;
import org.dom4j.Element;

import pojo.PlantPerimeterRegion;
import util.XmlUtil;

public class PlantPerimeterRegionService {
	public static void main(String[] args) throws UnsupportedEncodingException,DocumentException, Exception {
		String code = XmlUtil.zuzhi();
		System.out.println(code);
		Element items = XmlUtil.xmlToBean(code, "rows");
		PlantPerimeterRegion.plantPerimeterRegionSet(items);
		System.out.println("成功！");
	}
}
