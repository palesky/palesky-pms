package com.model.bean;

public class UsecaseBean {
	String id;
	String usecaseLibId;
	String usecaseLibType;
	String createdBy;
	String createdDate;
	String steps;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUsecaseLibId() {
		return usecaseLibId;
	}
	public void setUsecaseLibId(String usecaseLibId) {
		this.usecaseLibId = usecaseLibId;
	}
	public String getUsecaseLibType() {
		return usecaseLibType;
	}
	public void setUsecaseLibType(String usecaseLibType) {
		this.usecaseLibType = usecaseLibType;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getSteps() {
		return steps;
	}
	public void setSteps(String steps) {
		this.steps = steps;
	}
	@Override
	public String toString() {
		return "UsecaseBean [id=" + id + ", usecaseLibId=" + usecaseLibId + ", usecaseLibType=" + usecaseLibType
				+ ", createdBy=" + createdBy + ", createdDate=" + createdDate + ", steps=" + steps + "]";
	}
	
	
}
