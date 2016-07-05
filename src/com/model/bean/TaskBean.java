package com.model.bean;

public class TaskBean {
	String id;
	String name;
	String status;
	String createdBy;
	String endDate;
	String explain;
	String lastEditedBy;
	String confirmedBy;
	String demand_id;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getExplain() {
		return explain;
	}
	public void setExplain(String explain) {
		this.explain = explain;
	}
	public String getLastEditedBy() {
		return lastEditedBy;
	}
	public void setLastEditedBy(String lastEditedBy) {
		this.lastEditedBy = lastEditedBy;
	}
	public String getConfirmedBy() {
		return confirmedBy;
	}
	public void setConfirmedBy(String confirmedBy) {
		this.confirmedBy = confirmedBy;
	}
	public String getDemand_id() {
		return demand_id;
	}
	public void setDemand_id(String demand_id) {
		this.demand_id = demand_id;
	}
	@Override
	public String toString() {
		return "TaskBean [id=" + id + ", name=" + name + ", status=" + status + ", createdBy=" + createdBy
				+ ", endDate=" + endDate + ", explain=" + explain + ", lastEditedBy=" + lastEditedBy + ", confirmedBy="
				+ confirmedBy + ", demand_id=" + demand_id + "]";
	}
	
}
