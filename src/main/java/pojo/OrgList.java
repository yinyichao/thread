package pojo;

import java.util.List;

public class OrgList extends OrgParent{
	private List<OrgParent> orgChildrenList;
	public List<OrgParent> getOrgChildrenList() {
		return orgChildrenList;
	}
	public void setOrgChildrenList(List<OrgParent> orgChildrenList) {
		this.orgChildrenList = orgChildrenList;
	}
}
