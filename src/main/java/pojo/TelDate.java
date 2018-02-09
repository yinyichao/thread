package pojo;

import java.util.List;

public class TelDate {
	private List<Tel> data;
	public List<Tel> getData() {
		return data;
	}
	public void setData(List<Tel> data) {
		this.data = data;
	}
	public String getError_code() {
		return error_code;
	}
	public void setError_code(String error_code) {
		this.error_code = error_code;
	}
	private String error_code;
}
