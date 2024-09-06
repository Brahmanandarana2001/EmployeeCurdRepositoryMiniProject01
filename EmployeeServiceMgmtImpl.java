package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("em")
public class EmployeeServiceMgmtImpl implements IEmployeeServiceMgmt {
@Autowired
private IEmployeeRepository empRepo;

@Override
public Iterable showAllEmployees() {
	
	return empRepo.findAll();
}

@Override
public String saveEmployee(Employee emp) {
	int idVal=empRepo.save(emp).getEmpno();
	return "employee is saved with id::"+idVal;
}

@Override
public Employee findEmployeeByNo(int no) {//edit a perticular record with help of id as crieteria value

	return empRepo.findById(no).orElseThrow(()->new IllegalArgumentException("invalid id"));
}

@Override
public String updateEmployee(Employee emp) {
	Optional<Employee>opt=empRepo.findById(emp.getEmpno());
	if(opt.isPresent())
	{
		empRepo.save(emp);
		return "employee records are updated";
	}
	return "employee records are not updated";
}

@Override
public String deleteById(Integer id) {
	Optional<Employee>opt=empRepo.findById(id);
	if(opt.isPresent())
	{
		empRepo.deleteById(id);
		return "employee are deleted";
	}
	return "employee are not deleted";
}
}
