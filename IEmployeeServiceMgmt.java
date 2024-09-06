package com.nt.service;

import com.nt.entity.Employee;

public interface IEmployeeServiceMgmt {
public Iterable showAllEmployees();
public String saveEmployee(Employee emp);
public Employee findEmployeeByNo(int no);
public String updateEmployee(Employee emp);
public String deleteById(Integer id);
}
