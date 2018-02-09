package pojo;

import java.util.List;


public class TelRegionDate {
	private List<TelRegion> data;
	private String error_code;
	
	public List<TelRegion> getData() {
		return data;
	}
	public void setData(List<TelRegion> data) {
		this.data = data;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	
}
