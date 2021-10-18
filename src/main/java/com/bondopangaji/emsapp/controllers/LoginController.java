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

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.bondopangaji.emsapp.interfaces.EmployeeInterface;
import com.bondopangaji.emsapp.models.Employee;

/**
 * @author bondopangaji
 *
 */

@Controller
public class LoginController {

	@Autowired
	private EmployeeInterface employeeInterface;

	@GetMapping("/login")
	public String loginView(Model model) {

		Employee employee = new Employee();
		model.addAttribute("employee", employee);

		return "login";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute("employee") Employee employee, RedirectAttributes rA, HttpServletRequest request) throws Exception {

		HttpSession sessionAuthEmail = request.getSession(true);
		Employee authEmail = employeeInterface.authEmail(employee.getEmail(), employee.getPassword());

		if (authEmail == null) {
			rA.addFlashAttribute("error", "Invalid Username or Password");
			return "redirect:/login";
		}	
		sessionAuthEmail.setAttribute("employeeId", authEmail.getEmployeeId());
		sessionAuthEmail.setAttribute("roleId", authEmail.getRoleId());
		sessionAuthEmail.setAttribute("loggedIn", true);
		
		if (authEmail.getRoleId() == 1) {
			return "redirect:/admin-dashboard/";
		}
		return "redirect:/employee-dashboard/";
	}
}