package pojo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import util.JsonUtil;

public class test {
	public static void main(String[] args) {
		String jsonO = "[{"
		+"\"orgName\": \"机构1\","
		+"\"orgCode\": \"ztwltech_test\","
		+"\"parentOrgCode\": null}, {"
		+"\"orgName\": \"机构2\","
		+"\"orgCode\": \"JG02\","
		+"\"parentOrgCode\": \"ztwltech_test\"}, {"
		+"\"orgName\": \"机构3\","
		+"\"orgCode\": \"JG03\","
		+"\"parentOrgCode\": \"ztwltech_test\"}, {"
		+"\"orgName\": \"机构4\","
		+"\"orgCode\": \"JG04\","
		+"\"parentOrgCode\": \"JG02\"}, {"
		+"\"orgName\": \"机构6\","
		+"\"orgCode\": \"JG06\","
		+"\"parentOrgCode\": \"JG02\"}, {"
		+"\"orgName\": \"机构7\","
		+"\"orgCode\": \"JG07\","
		+"\"parentOrgCode\": \"JG03\"}, {"
		+"\"orgName\": \"机构8\","
		+"\"orgCode\": \"JG08\","
		+"\"parentOrgCode\": \"JG03\"}, {"
		+"\"orgName\": \"机构9\","
		+"\"orgCode\": \"JG09\","
		+"\"parentOrgCode\": \"JG03\"}, {"
		+"\"orgName\": \"机构5\","
		+"\"orgCode\": \"JG05\","
		+"\"parentOrgCode\": \"JG04\"}]";
		List<OrgO> orgOs= JsonUtil.jsonArrToList(jsonO, OrgO.class);
		for (OrgO orgO : orgOs) {
			System.out.println(orgO.getParentOrgCode());
		}
		test t = new test();
		String json = t.constructTaskDTOToTree(orgOs);
		System.out.println(json);
	}
	/** 
     * 将List重组为数 
     * @param taskDTOList DTO集合 
     * @return List<XMGLTaskDTO> 
     */  
    public String constructTaskDTOToTree(List<OrgO> taskDTOList){  
        Map<String,List<OrgO>> taskDTOMap = new HashMap<>();  
  
        for (OrgO orgO : taskDTOList) {
        	 List<OrgO> tempTaskDTOList = taskDTOMap.get(orgO.getParentOrgCode());  
             if (tempTaskDTOList == null){  
                 tempTaskDTOList = new ArrayList<OrgO>();  
                 taskDTOMap.put(orgO.getParentOrgCode(),tempTaskDTOList);  
             }  
             tempTaskDTOList.add(orgO);
		}
  
        //顶级节点集合  
        List<OrgO> resultTaskDTOList = taskDTOMap.get(null);  
        List<OrgParent> rls = recurTaskDTOList(resultTaskDTOList,taskDTOMap);  
        return JsonUtil.toJson(rls);  
    }  
    /** 
     * 将重组好的Map进行树形结构处理 
     * @param taskDTOList 父节点集合(不一定是顶级节点 因为会递归调用) 
     * @param sourceMap 组装好的Map集合 
     */  
    public List<OrgParent> recurTaskDTOList(List<OrgO> orgs,Map<String,List<OrgO>> sourceMap){ 
    	List<OrgParent> rls = new ArrayList<OrgParent>();
    	OrgList rl;
    	List<OrgParent> ls;
    	OrgN o;
    	for (OrgO org : orgs) {
    		List<OrgO> result = sourceMap.get(org.getOrgCode());
    		if(result!=null){
    			rl = new OrgList();
    			rl.setOrgName(org.getOrgName());
        		o = new OrgN();
        		o.setOrgCode(org.getOrgCode());
        		o.setOrgName(org.getOrgName());
        		ls = new ArrayList<OrgParent>();
        		ls.add(o);
        		ls.addAll(recurTaskDTOList(result,sourceMap));
        		rl.setOrgChildrenList(ls);
        		rls.add(rl);
    		}else{
    			o = new OrgN();
        		o.setOrgCode(org.getOrgCode());
        		o.setOrgName(org.getOrgName());
        		rls.add(o);
    		}
		}
    	return rls;
    }
}
