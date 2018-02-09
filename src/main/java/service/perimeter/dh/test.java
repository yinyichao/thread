package service.perimeter.dh;

import org.apache.cxf.endpoint.Client;
import org.apache.cxf.jaxws.endpoint.dynamic.JaxWsDynamicClientFactory;

public class test {

	public static String zuzhi() throws Exception {
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory
				.newInstance();
		Client client = clientFactory
				.createClient("http://10.26.35.253/cms/services/ICommonService?wsdl");
		Object[] result = client.invoke("getAllResourceDetail",
				"83438516002010000047", 1000);
		System.out.println(result[0]);
		return String.valueOf(result[0]);
	}

	public static String camera(String orgCode) throws Exception {
		JaxWsDynamicClientFactory clientFactory = JaxWsDynamicClientFactory
				.newInstance();
		Client client = clientFactory
				.createClient("http://10.26.35.253/cms/services/ICommonService?wsdl");
		Object[] result = client.invoke("getAllResourceDetailByOrg",
				"83438516002010000047", orgCode, 10000);
		System.out.println(result[0]);
		return String.valueOf(result[0]);
	}
	/*public static void main(String[] args) {
		try {
			System.out.println(camera("62242452005000000001"));
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
	public static void main(String[] args) {
		try {
			System.out.println(zuzhi());
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	/*
	 * public static String ss(String carema) throws Exception{
	 * JaxWsDynamicClientFactory clientFactory =
	 * JaxWsDynamicClientFactory.newInstance(); Client client =
	 * clientFactory.createClient
	 * ("http://10.1.1.42/vms/services/ServiceWebService?wsdl"); Object[] result
	 * = client.invoke("getStreamInfo",1,carema,
	 * "","",1L,14,"10.1.1.42","29085164002010000045");
	 * System.out.println(result[0]); return String.valueOf(result[0]); }
	 */
	/*public static void main(String[] args) throws Exception {

		List<Student> slist=new ArrayList<Student>();
	     
	    //得到 DocumentBuilderFactory 对象, 由该对象可以得到 DocumentBuilder 对象
	    DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	     
	    try {
	        //得到DocumentBuilder对象
	        DocumentBuilder builder=factory.newDocumentBuilder();
	        //得到代表整个xml的Document对象
	        InputStream stream = new ByteArrayInputStream(zuzhi().getBytes("UTF-8"));
	        Document document=builder.parse(stream);
	        //得到 "根节点"
	        Element root=document.getDocumentElement();
	        //获取根节点的所有items的节点
	        NodeList items=root.getElementsByTagName("rows");  
	        //遍历所有节点
	        for(int i=0;i<items.getLength();i++){
	        	Student stu = new Student();
	            Element item=(Element)items.item(i);
	            stu.setName(item.getAttribute("c_org_name"));
	            //再枚举子节点
	            slist.add(stu);
	        }
	         
	    } catch (ParserConfigurationException e) {
	        e.printStackTrace();
	    } catch (SAXException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    for(Student s:slist){
	    	System.out.println(s.getName());
	    }


		// System.err.println(ss("29085164001130000001"));
		// shouye-jcpz-fwgl-fwpz-vncc-bh
	}*/
	 /** 
     * 遍历当前节点元素下面的所有(元素的)子节点 
     *  
     * @param node 
     */  
/*    public static void listNodes(Element node) {  
        System.out.println("当前节点的名称：：" + node.getName());  
        // 获取当前节点的所有属性节点  
        List<Attribute> list = node.attributes();  
        // 遍历属性节点  
        for (Attribute attr : list) {  
            System.out.println(attr.getText() + "-----" + attr.getName()  
                    + "---" + attr.getValue());  
        }  
  
        if (!(node.getTextTrim().equals(""))) {  
            System.out.println("文本内容：：：：" + node.getText());  
        }  
  
        // 当前节点下面子节点迭代器  
        Iterator<Element> it = node.elementIterator();  
        // 遍历  
        while (it.hasNext()) {  
            // 获取某个子节点对象  
            Element e = it.next();  
            // 对子节点进行遍历  
            listNodes(e);  
        }  
    }  */
	
		/*List<Student> slist=new ArrayList<Student>();
		 // 创建saxReader对象  
        SAXReader reader = new SAXReader();  
        // 通过read方法读取一个文件 转换成Document对象  
        try {
			Document document = reader.read(new ByteArrayInputStream(zuzhi().getBytes("UTF-8")));
			//获取根节点元素对象  
	        Element node = document.getRootElement(); 
	        //遍历所有的元素节点  
	        listNodes(node);  
	        
	       
	        Element items=node.element("rows");  
	        System.out.println(items+"************************************");
	        Element author = items.element("row"); 
	        System.out.println(author+"************************************");
	        System.out.println(items.getName() + "----" + author.attributeValue("i_id"));
	        
	        @SuppressWarnings("unchecked")
			List<Element> elements = items.elements("row");  
	        
	        for (Element el : elements) {  
	            System.out.println(el.attributeValue("i_id"));  
	        }  
	        while(items.getPath() != null){
	        	Student stu = new Student(); 
	            stu.setName(items.valueOf("c_org_name"));
	            slist.add(stu);
	        }
	        for(Student s:slist){
		    	System.out.println(s.getName()+"********************************");
		    }
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} */
	}
}
