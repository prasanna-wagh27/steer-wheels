package com.mycar.steerwheels.bo;

public class Response {
	
	private String message;
	
	private String status;
	
	private Object data;
	
	private Long listCount;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Long getListCount() {
		return listCount;
	}

	public void setListCount(Long listCount) {
		this.listCount = listCount;
	}
}
