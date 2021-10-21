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
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.bondopangaji.emsapp.models.Employee;
import com.bondopangaji.emsapp.repositories.EmployeeRepository;
import com.bondopangaji.emsapp.services.EmployeeService;

/**
 * @author bondopangaji
 *
 */

@DisplayName("Test case for Employee object")
@ExtendWith(MockitoExtension.class)
public class EmployeeTests {
	
	@Mock
    private EmployeeRepository employeeRepository;
	
	@InjectMocks
	private EmployeeService employeeService;
	
	@Test
	@Order(1)
	@Rollback(value = false)
	void testNewAdmin() throws Exception {
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
		
		employeeService.storeData(expectedEmployee);

		when(employeeRepository.findByEmail("dummy.admin@bondo.com")).thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository.findByEmail("dummy.admin@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewAdminWithEmptyEmployeeId() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId((Long) null);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-2001");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
		});
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewAdminWithEmptyRoleId() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(1);
			expectedEmployee.setRoleId((Integer) null);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-2001");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
		});
	}
	
	@Test
	@Order(4)
	@Rollback(value = false)
	void testNewAdminWithEmptyFullName() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Full name cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(5)
	@Rollback(value = false)
	void testNewAdminWithEmptyBirthDate() throws Exception {
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
	@Order(6)
	@Rollback(value = false)
	void testNewAdminWithEmptyHomeAddress() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Home address cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(7)
	@Rollback(value = false)
	void testNewAdminWithEmptyDomicileAddress() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(101);
		expectedEmployee.setRoleId(1);
		expectedEmployee.setFullName("Dummy Admin");
		expectedEmployee.setBirthDate("05-11-2001");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondo.com");
		expectedEmployee.setPassword("password");
		
		employeeService.storeData(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.employee@bondo.com"))
			.thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository
					.findByEmail("dummy.employee@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(8)
	@Rollback(value = false)
	void testNewAdminWithEmptyPhoneNumber() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Phone number cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(9)
	@Rollback(value = false)
	void testNewAdminWithEmptyEmail() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Email cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(10)
	@Rollback(value = false)
	void testNewAdminWithEmptyPassword() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Password cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(101);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("Dummy Admin");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(11)
	@Rollback(value = false)
	void testNewEmployee() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(100);
		expectedEmployee.setRoleId(2);
		expectedEmployee.setFullName("Dummy Employee");
		expectedEmployee.setBirthDate("05-11-2001");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("Indonesia");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondo.com");
		expectedEmployee.setPassword("password");

		employeeService.storeData(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.employee@bondo.com"))
			.thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository
					.findByEmail("dummy.employee@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(12)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewEmployeeWithEmptyEmployeeId() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId((Long) null);
			expectedEmployee.setRoleId(1);
			expectedEmployee.setFullName("");
			expectedEmployee.setBirthDate("05-11-2001");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
		});
	}
	
	@Test
	@Order(13)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewEmployeeWithEmptyRoleId() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(2);
			expectedEmployee.setRoleId((Integer) null);
			expectedEmployee.setFullName("");
			expectedEmployee.setBirthDate("05-11-2001");
			expectedEmployee.setHomeAddress("Indonesia");
			expectedEmployee.setDomicileAddress("Indonesia");
			expectedEmployee.setPhoneNumber("62");
			expectedEmployee.setEmail("dummy.admin@bondo.com");
			expectedEmployee.setPassword("password");
		});
	}
	
	@Test
	@Order(14)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyFullName() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Full name cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(15)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyBirthDate() throws Exception {
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
	@Order(16)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyHomeAddress() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Home address cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(17)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyDomicileAddress() throws Exception {
		Employee expectedEmployee = new Employee();
		expectedEmployee.setEmployeeId(100);
		expectedEmployee.setRoleId(2);
		expectedEmployee.setFullName("Dummy Employee");
		expectedEmployee.setBirthDate("05-11-2001");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondo.com");
		expectedEmployee.setPassword("password");
		
		employeeService.storeData(expectedEmployee);
		
		when(employeeRepository.findByEmail("dummy.employee@bondo.com"))
			.thenReturn(expectedEmployee);
		Employee actualEmployee = this.employeeRepository
					.findByEmail("dummy.employee@bondo.com");
		
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}
	
	@Test
	@Order(18)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyPhoneNumber() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Phone number cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(19)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyEmail() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Email cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-2001");
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
	@Order(20)
	@Rollback(value = false)
	void testNewEmployeeWithEmptyPassword() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Password cannot be null!";
		try {
			Employee expectedEmployee = new Employee();
			expectedEmployee.setEmployeeId(100);
			expectedEmployee.setRoleId(2);
			expectedEmployee.setFullName("Dummy Employee");
			expectedEmployee.setBirthDate("05-11-2001");
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
