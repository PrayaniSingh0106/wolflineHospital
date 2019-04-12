package com.dbms.wolfline;

public class Ward {

	/*
	 * Field | Type | Null | Key | Default | Extra |
	 * +-------------------+---------+------+-----+---------+-------+ | ward_no |
	 * int(11) | NO | PRI | NULL | | | capacity | int(11) | NO | | NULL | | | cost |
	 * int(11) | NO | | NULL | | | responsible_nurse | int(11) | YES | MUL | NULL |
	 * |
	 */

	private int wardNo;
	private int capacity;
	private int cost;
	private int responsible_nurse;

	public int getWardNo() {
		return wardNo;
	}

	public void setWardNo(int wardNo) {
		this.wardNo = wardNo;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getResponsible_nurse() {
		return responsible_nurse;
	}

	public void setResponsible_nurse(int responsible_nurse) {
		this.responsible_nurse = responsible_nurse;
	}

}
