/**

MIT License

Copyright (c) [2021] [bondopangaji]

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

**/

package com.bondopangaji.emsapp.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.bondopangaji.emsapp.interfaces.EmployeeInterface;
import com.bondopangaji.emsapp.interfaces.PayrollInterface;
import com.bondopangaji.emsapp.models.Employee;
import com.bondopangaji.emsapp.models.Payroll;

/**
 * @author bondopangaji
 *
 */

@Controller
@Component
public class AdminDashboardController {
	
	@Autowired
	private EmployeeInterface employeeInterface;
	
	@Autowired
	private PayrollInterface payrollInterface;
	
	@GetMapping
	("/admin-dashboard")
	public String adminDashboardView() {
		return "/admin-dashboard/dashboard";
	}
	
	/*
	 * Employeee
	 */
	
	@GetMapping
	("/admin-dashboard/employee-list")
	public String adminDashboardEmployeeList(Model model) {
        model.addAttribute("list", employeeInterface.getAll());
		return "/admin-dashboard/employee-list";
	}
	
	@GetMapping
	("/admin-dashboard/add-employee")
	public String adminDashboardAddEmployee(Model model) {
		Employee employee = new Employee();
        model.addAttribute("employee", employee);
		return "/admin-dashboard/add-employee";
	}

    @PostMapping
    ("/admin-dashboard/add-employe/saved")
    public String storeCreateEmployee(@ModelAttribute("employee") Employee employee) throws Exception {
    	employeeInterface.storeData(employee);
        return "redirect:/admin-dashboard/employee-list";
    }
	
	@GetMapping
	("/admin-dashboard/edit-employee/{employeeId}")
	public String adminDashboardEditEmployee(@PathVariable(value = "employeeId") long employeeId, Model model) {
        Employee employee = employeeInterface.getDataById(employeeId);
        model.addAttribute("employee", employee);
		return "/admin-dashboard/edit-employee";
	}
	
    @PostMapping
    ("/admin-dashboard/employee-list/edit-employee/edited")
    public String storeEditEmployee(@ModelAttribute("employee") Employee employee) throws Exception{       
        employeeInterface.storeEditData(employee);
        return "redirect:/admin-dashboard/employee-list";
    }
	
    @PostMapping
    ("/admin-dashboard/employee-list/{employeeId}/deleted")
    public String deleteEmployeeById(@PathVariable(value = "employeeId") long employeeId){
    	employeeInterface.deleteDataById(employeeId);
        return "redirect:/admin-dashboard/employee-list";
    }
	
	/*
	 * Payroll
	 */
    
	@GetMapping
	("/admin-dashboard/payroll-list")
	public String adminDashboardPayrollList(Model model) {
        model.addAttribute("list", payrollInterface.getAll());
		return "/admin-dashboard/payroll-list";
	}
	
	@GetMapping
	("/admin-dashboard/add-payroll")
	public String adminDashboardAddPayroll(Model model) {
		List<Employee> employee = employeeInterface.getAll();
		model.addAttribute("employee", employee);
		Payroll payroll = new Payroll();
		model.addAttribute("payroll", payroll);
		return "/admin-dashboard/add-payroll";
	}

    @PostMapping
    ("/admin-dashboard/add-payroll/saved")
    public String storeCreatePayroll(@ModelAttribute("payroll") Payroll payroll) throws Exception {
    	payrollInterface.storeData(payroll);
        return "redirect:/admin-dashboard/payroll-list";
    }
    
	@GetMapping
	("/admin-dashboard/edit-payroll/{payrollId}")
	public String adminDashboardEditPayroll(@PathVariable(value = "payrollId") long payrollId, Model model) {
		List<Employee> employee = employeeInterface.getAll();
		model.addAttribute("employee", employee);
		Payroll payroll = payrollInterface.getDataById(payrollId);
        model.addAttribute("payroll", payroll);
		return "/admin-dashboard/edit-payroll";
	}
    
    @PostMapping
    ("/admin-dashboard/payroll-list/edit-payroll/edited")
    public String storeEditPayroll(@ModelAttribute("payroll") Payroll payroll) throws Exception{       
    	payrollInterface.storeEditData(payroll);
        return "redirect:/admin-dashboard/payroll-list";
    }
    
}
