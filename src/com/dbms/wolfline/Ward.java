package com.dbms.wolfline;

public class Ward {

	/*
	 * Field | Type | Null | Key | Default | Extra |
	 * +-------------------+---------+------+-----+---------+-------+ | ward_no |
	 * int(11) | NO | PRI | NULL | | | capacity | int(11) | NO | | NULL | | | cost |
	 * int(11) | NO | | NULL | | | responsible_nurse | int(11) | YES | MUL | NULL |
	 * |
	 */
	
	 private String wardNo;
	 private String capacity;
	 private String cost;
	 private String responsible_nurse;
	 
	public String getWardNo() {
		return wardNo;
	}
	public void setWardNo(String wardNo) {
		this.wardNo = wardNo;
	}
	public String getCapacity() {
		return capacity;
	}
	public void setCapacity(String capacity) {
		this.capacity = capacity;
	}
	public String getCost() {
		return cost;
	}
	public void setCost(String cost) {
		this.cost = cost;
	}
	public String getResponsible_nurse() {
		return responsible_nurse;
	}
	public void setResponsible_nurse(String responsible_nurse) {
		this.responsible_nurse = responsible_nurse;
	}
	 
	 
	
	 
	 
}
