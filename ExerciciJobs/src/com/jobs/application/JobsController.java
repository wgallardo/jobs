package com.jobs.application;

import java.util.ArrayList;
import java.util.List;

import com.jobs.domain.AbsStaffMember;
import com.jobs.domain.Employee;
import com.jobs.domain.Volunteer;
import com.jobs.persistence.EmployeeRepository;

public class JobsController {

	private EmployeeRepository repository;
	
	public JobsController(){
		
		repository = new EmployeeRepository();
		
	}
	
	public void createBossEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee boss = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateBoss());
		repository.addMember(boss);
	}
	
	public void createEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{		
		Employee employee = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(employee);
	}

	public void createManagerEmployee(String name, String address, String phone, double salaryPerMonth) throws Exception{
		Employee manager = new Employee(name, address, phone,  salaryPerMonth, PaymentFactory.createPaymentRateEmployee());
		repository.addMember(manager);
		
	}
	
	public void createVolunteer(String name, String address, String phone, String description ) throws Exception {
		Volunteer volunteer = new Volunteer(name, address, phone, description);
		repository.addMember(volunteer);
		
	}	

	public void payAllEmployeers() {
		for(AbsStaffMember employeers : repository.getAllMembers())
			employeers.pay();	
	}
	
	public List<DtoMember> getAllEmployees() throws Exception {
		List<DtoMember> employeers = new ArrayList<>();
		for (AbsStaffMember employeersall : repository.getAllMembers()) {
			employeers.add(new DtoMember(employeersall)); 			
		}
		return employeers;
	}

	
	public String payAllEmployees() {
		String sou = new String("");
		List<AbsStaffMember> employeers = repository.getAllMembers();
		for (AbsStaffMember absStaffMember : employeers) {
			sou = sou + absStaffMember.getTotalPaid();
		}
		
		return sou;
	}
	
	

	
	
	
}
