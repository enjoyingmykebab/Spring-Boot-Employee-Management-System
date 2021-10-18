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

package com.bondopangaji.emsapp;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import com.bondopangaji.emsapp.models.Employee;
import com.bondopangaji.emsapp.repositories.EmployeeRepository;
import com.bondopangaji.emsapp.services.EmployeeService;

/**
 * @author bondopangaji
 *
 */

@SpringBootTest
public class EmployeeTests {
	
	@Mock
    private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	void NewAdmin() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(101);
		expectedEmployee.setRoleId(1);
		expectedEmployee.setFullName("Dummy Admin");
		expectedEmployee.setBirthDate("05-11-2001");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("Indonesia");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.admin@bondo.com");
		expectedEmployee.setPassword("password");
		
		when(employeeRepository.save(expectedEmployee)).thenReturn(expectedEmployee);
		employeeService.storeData(expectedEmployee);
		employeeRepository.save(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.admin@bondo.com")).thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository.findByEmail("dummy.admin@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	void NewAdminWithEmptyFullName() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Full name cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	void NewAdminWithEmptyBirthDate() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Birth date cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	void NewAdmineWithEmptyHomeAddress() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Birth date cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(5)
	@Rollback(value = false)
	void NewAdminWithEmptyDomicileAddress() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(101);
		expectedEmployee.setRoleId(1);
		expectedEmployee.setFullName("Dummy Employee");
		expectedEmployee.setBirthDate("05-11-00");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondo.com");
		expectedEmployee.setPassword("password");
		
		when(employeeRepository.save(expectedEmployee))
			.thenReturn(expectedEmployee);
		employeeService.storeData(expectedEmployee);
		employeeRepository.save(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.employee@bondo.com"))
			.thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository
					.findByEmail("dummy.employee@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(6)
	@Rollback(value = false)
	void NewAdminWithEmptyPhoneNumber() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Phone number cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(7)
	@Rollback(value = false)
	void NewAdminWithEmptyEmail() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Email cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(8)
	@Rollback(value = false)
	void NewAdminWithEmptyPassword() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Email cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(9)
	@Rollback(value = false)
	void NewEmployee() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(100);
		expectedEmployee.setRoleId(2);
		expectedEmployee.setFullName("Dummy Employee");
		expectedEmployee.setBirthDate("05-11-00");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("Indonesia");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondo.com");
		expectedEmployee.setPassword("password");
		
		when(employeeRepository.save(expectedEmployee))
			.thenReturn(expectedEmployee);
		employeeService.storeData(expectedEmployee);
		employeeRepository.save(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.employee@bondo.com"))
			.thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository
					.findByEmail("dummy.employee@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(10)
	@Rollback(value = false)
	void NewEmployeeWithEmptyFullName() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Full name cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(11)
	@Rollback(value = false)
	void NewEmployeeWithEmptyBirthDate() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Birth date cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(12)
	@Rollback(value = false)
	void NeEmployeeWithEmptyHomeAddress() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Birth date cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(13)
	@Rollback(value = false)
	void NewEmployeeWithEmptyDomicileAddress() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(100);
		expectedEmployee.setRoleId(2);
		expectedEmployee.setFullName("Dummy Employee");
		expectedEmployee.setBirthDate("05-11-00");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondo.com");
		expectedEmployee.setPassword("password");
		
		when(employeeRepository.save(expectedEmployee))
			.thenReturn(expectedEmployee);
		employeeService.storeData(expectedEmployee);
		employeeRepository.save(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.employee@bondo.com"))
			.thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository
					.findByEmail("dummy.employee@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(14)
	@Rollback(value = false)
	void NewEmployeeWithEmptyPhoneNumber() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Phone number cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(15)
	@Rollback(value = false)
	void NewEmployeeWithEmptyEmail() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Email cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("");
			expectedEmployee.setPassword("password");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
	
	@Test
	@Order(16)
	@Rollback(value = false)
	void NewEmployeeWithEmptyPassword() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Email cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-00");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.employee@bondo.com");
			expectedEmployee.setPassword("");
			
			when(employeeRepository.save(expectedEmployee))
				.thenThrow(new RuntimeException(actualMessage));
			employeeService.storeData(expectedEmployee);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
        Assertions.assertEquals(expectedMessage, actualMessage);
	}
}
