package com.jobs.application;

import com.jobs.domain.AbsStaffMember;

public class DtoMember {
	
	protected int id;
	protected String name;
	protected String address;
	protected String phone;
	protected double totalPaid=0;

	private static int COUNTER_MEMBERS = 1;

	/**
	 * @param id
	 * @param name
	 * @param address
	 * @param phone
	 * @param totalPaid
	 */
	public DtoMember(AbsStaffMember member) throws Exception {
		if(member==null) {
			throw new Exception();
		}
		this.id = member.getId();
		this.name = member.getName();
		this.address = member.getAddress();
		this.phone = member.getPhone();
		this.totalPaid = member.getTotalPaid();
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @return the totalPaid
	 */
	public double getTotalPaid() {
		return totalPaid;
	}

	/**
	 * @return the cOUNTER_MEMBERS
	 */
	public static int getCOUNTER_MEMBERS() {
		return COUNTER_MEMBERS;
	}
	
	
	
	

}
