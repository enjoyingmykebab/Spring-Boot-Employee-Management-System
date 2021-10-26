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

package com.bondopangaji.emsapp.unittests;

import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.bondopangaji.emsapp.models.Employee;
import com.bondopangaji.emsapp.repositories.EmployeeRepository;
import com.bondopangaji.emsapp.services.EmployeeService;

/**
 * @author bondopangaji
 *
 */

@DisplayName("Test case for Login")
@ExtendWith(MockitoExtension.class)
@Transactional(rollbackFor = Exception.class)
public class AuthenticationTests {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeService employeeService;

	Throwable e = null;
	String expectedMessage = null;

	Employee expectedAdmin = new Employee();
	Employee expectedEmployee = new Employee();

	@BeforeEach
	void setUpAdmin() throws Exception {
		expectedAdmin.setEmployeeId(101);
		expectedAdmin.setRoleId(1);
		expectedAdmin.setFullName("Dummy Admin");
		expectedAdmin.setBirthDate("05-11-2001");
		expectedAdmin.setHomeAddress("Indonesia");
		expectedAdmin.setDomicileAddress("Indonesia");
		expectedAdmin.setPhoneNumber("62");
		expectedAdmin.setEmail("dummy.admin@bondopangji.com");
		expectedAdmin.setPassword("password");
		employeeService.storeData(expectedAdmin);
	}

	@BeforeEach
	void setUpEmployee() throws Exception {
		expectedEmployee.setEmployeeId(101);
		expectedEmployee.setRoleId(2);
		expectedEmployee.setFullName("Dummy Employee");
		expectedEmployee.setBirthDate("05-11-2001");
		expectedEmployee.setHomeAddress("Indonesia");
		expectedEmployee.setDomicileAddress("Indonesia");
		expectedEmployee.setPhoneNumber("62");
		expectedEmployee.setEmail("dummy.employee@bondopangji.com");
		expectedEmployee.setPassword("password");
		employeeService.storeData(expectedEmployee);
	}

	@Test
	@Order(1)
	@Rollback(value = false)
	void testAdminLogin() throws Exception {
		String email = "dummy.admin@bondopangji.com";
		String password = "password";
		when(employeeService.authEmail(email, password)).thenReturn(expectedAdmin);
		Employee actualAdmin = employeeService.authEmail(email, password);
		Assertions.assertEquals(expectedAdmin, actualAdmin);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	void testAdminLoginWithEmptyEmail() {	
		Assertions.assertThrows(NullPointerException.class, () -> {
			String password = "password";
			Employee actualAdmin = employeeService.authEmail(null, password);
			Assertions.assertEquals(expectedAdmin.getEmail(), actualAdmin.getEmail());
		});
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	void testAdminWithEmptyPassword() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			String email = "dummy.admin@bondopangji.com";
			Employee actualAdmin = employeeService.authEmail(email, null);
			Assertions.assertEquals(expectedAdmin.getPassword(), actualAdmin.getPassword());
		});
	}

	@Test
	@Order(4)
	@Rollback(value = false)
	void testAdminWithEmptyCredentials() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Employee actualAdmin = employeeService.authEmail(null, null);
			Assertions.assertEquals(expectedAdmin.getEmail(), actualAdmin.getEmail());
			Assertions.assertEquals(expectedAdmin.getPassword(), actualAdmin.getPassword());
		});
	}

	@Test
	@Order(5)
	@Rollback(value = false)
	void testEmployeeLogin() throws Exception {
		String email = "dummy.employee@bondopangji.com";
		String password = "password";
		when(employeeService.authEmail(email, password)).thenReturn(expectedEmployee);
		Employee actualEmployee = employeeService.authEmail(email, password);
		Assertions.assertEquals(expectedEmployee, actualEmployee);
	}

	@Test
	@Order(6)
	@Rollback(value = false)
	void testEmployeeLoginWithEmptyEmail() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			String password = "password";
			Employee actualEmployee = employeeService.authEmail(null, password);
			Assertions.assertEquals(expectedEmployee.getEmail(), actualEmployee.getEmail());
		});
	}

	@Test
	@Order(7)
	@Rollback(value = false)
	void testEmployeeWithEmptyPassword() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			String email = "dummy.employee@bondopangji.com";
			Employee actualEmployee = employeeService.authEmail(email, null);
			Assertions.assertEquals(expectedEmployee.getPassword(), actualEmployee.getPassword());
		});
	}

	@Test
	@Order(8)
	@Rollback(value = false)
	void testEmptyWithEmptyCredentials() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Employee actualEmployee = employeeService.authEmail(null, null);
			Assertions.assertEquals(expectedEmployee.getEmail(), actualEmployee.getEmail());
			Assertions.assertEquals(expectedEmployee.getPassword(), actualEmployee.getPassword());
		});
	}

}
