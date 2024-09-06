package com.nt.controller;

import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeServiceMgmt;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationController {
	@Autowired
private IEmployeeServiceMgmt empService;
	@GetMapping("/")
public String showHomePage()
{
	return "welcome";
}
	@GetMapping("/report")
	public String launchForm(Map<String,Object>map)
	{
		System.out.println("EmployeeOperationController.launchForm()");
		Iterable<Employee>it=empService.showAllEmployees();
		map.put("empList", it);
		return "show_report";
	}
	@GetMapping("/register")	 //register  employee --- form launching
	public String addEmployee(@ModelAttribute("emp")Employee emp)
	{
		//retiurn LVN (register form page)
		return "register_employee_report";
	}
	/*@PostMapping("/register")
	public String shaveEmployee(Map<String,Object>map,@ModelAttribute("emp")Employee emp)
	{
	System.out.println("EmployeeOperationController.shaveEmployee()");
		String res=empService.saveEmployee(emp);
		// keep the result model attribute (shared Memory)
		map.put("result", res);
		/*Iterable<Employee>it=empService.showAllEmployees();//because of duplication not use
		map.put("empList", it);
		//return lvn
		//return "show_report";
		return "redirect:report";//redirect the post to get mode handler method no duplication but confirm msg are not displayed
	}*/
/*	@PostMapping("/register")
	public String shaveEmployee(@ModelAttribute("emp")Employee emp,RedirectAttributes attr)
	{
	System.out.println("EmployeeOperationController.shaveEmployee()");
		String res=empService.saveEmployee(emp);
		// keep the result model attribute (shared Memory)
		attr.addFlashAttribute("result", res);
	
		return "redirect:report";//redirect the post to get mode handler method no duplication 
	}*/
	@PostMapping("/register")
	public String shaveEmployee(@ModelAttribute("emp")Employee emp,HttpSession ses)
	{
	System.out.println("EmployeeOperationController.shaveEmployee()");
		String res=empService.saveEmployee(emp);
		// keep the result model attribute (shared Memory)
		ses.setAttribute("result", res);
	
		return "redirect:report";//redirect the post to get mode handler method no duplication 
	}
	@GetMapping("/edit")
	public String edithomePage(@RequestParam Integer no,@ModelAttribute("emp")Employee emp)//by using requestparam we can see all employee record because it is appeneded to url withh edit
	{
		Employee emp1=empService.findEmployeeByNo(no);//by this method we can edit the form page of edit
		//how to transfer employee object model object by using copying
		BeanUtils.copyProperties(emp1, emp);//copies the one object data to another object if they have same properties
		return "edit_employee_report";
	}
	/*@PostMapping("/edit")//submission of form page
	public String updatedEmp(@ModelAttribute("emp")Employee emp,Map<String,Object>map)//due to map share memory it does not show updated msg
	{
	    String res=empService.updateEmployee(emp);
	    map.put("result", res);
	    return "redirect:report";//i want to report page is result page
	}*/
	@PostMapping("/edit")
	public String updatedEmp(@ModelAttribute("emp")Employee emp,RedirectAttributes attrs)//it is a special type of share memory that comes source to destination method
	{
	    String res=empService.updateEmployee(emp);
	   attrs.addFlashAttribute("result", res);
	    return "redirect:report";//i want to report page is result page
	}
	@GetMapping("/delete")
	public String deleteEmp(@RequestParam Integer no,RedirectAttributes atrs)
	{
		String res=empService.deleteById(no);
		atrs.addFlashAttribute("result", res);
		return "redirect:report";//due to double posting problem we use redirect instead of lvn of report page is result page
	}
}
