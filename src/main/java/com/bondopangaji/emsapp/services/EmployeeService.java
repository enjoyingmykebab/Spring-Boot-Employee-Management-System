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

package com.bondopangaji.emsapp.services;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bondopangaji.emsapp.interfaces.EmployeeInterface;
import com.bondopangaji.emsapp.models.Employee;
import com.bondopangaji.emsapp.repositories.EmployeeRepository;

/**
 *
 * @author bondopangaji
 */

@Service
public class EmployeeService implements EmployeeInterface {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee authEmail(String email, String password) throws Exception {
		Employee employee = employeeRepository.findByEmail(email);

		if (employee == null) {
			return null;
		}

		if (!this.match(employee.getPassword(), password)) {
			return null;
		}

		return employee;
	}

	private String hash(String password) throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");

		byte[] messageDiggest = md.digest(password.getBytes());

		BigInteger no = new BigInteger(1, messageDiggest);

		String hashText = no.toString(16);
		while (hashText.length() < 32) {
			hashText = "0" + hashText;
		}

		return hashText;
	}

	private boolean match(String password, String rawPassword) throws Exception {
		rawPassword = this.hash(rawPassword);
		return password.equals(rawPassword);
	}

	@Override
	public List<Employee> getAll() {
		return employeeRepository.findAll();
	}

	@Override
	public void storeData(Employee employee) throws Exception {		        
        String hashed = this.hash(employee.getPassword());
        employee.setPassword(hashed);
      
		this.employeeRepository.save(employee);
	}
	
	@Override
	public void storeEditData(Employee employee) throws Exception {
  		this.employeeRepository.save(employee);
	}

	@Override
	public Employee getDataById(long id) {
		Optional<Employee> optional = employeeRepository.findById(id);

		if (!optional.isPresent()) {
			throw new RuntimeException(" Employee not found for id :: " + id);
		}
		Employee employee = optional.get();
		
        String hashed = employee.getPassword();
		employee.setPassword(hashed);
		
		return employee;
	}
	
	@Override
	public void deleteDataById(long id) {
		this.employeeRepository.deleteById(id);
	}

}