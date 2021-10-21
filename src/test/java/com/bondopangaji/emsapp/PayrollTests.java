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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.annotation.Rollback;

import com.bondopangaji.emsapp.models.Employee;
import com.bondopangaji.emsapp.models.Payroll;
import com.bondopangaji.emsapp.repositories.PayrollRepository;
import com.bondopangaji.emsapp.services.PayrollService;

/**
 * @author bondopangaji
 *
 */

@DisplayName("Test case for Payroll object")
@ExtendWith(MockitoExtension.class)
public class PayrollTests {

	@Mock
	private PayrollRepository payrollRepository;

	@InjectMocks
	private PayrollService payrollService;

	Employee employee = new Employee();
	
	@BeforeEach
	void setUpEmployeeObject() {
		employee.setEmployeeId(101);
		employee.setRoleId(2);
		employee.setFullName("Dummy Employee");
		employee.setBirthDate("05-11-2001");
		employee.setHomeAddress("Indonesia");
		employee.setDomicileAddress("Indonesia");
		employee.setPhoneNumber("62");
		employee.setEmail("dummy.admin@bondopangji.com");
		employee.setPassword("password");
	}
	
	@Test
	@Order(1)
	@Rollback(value = false)
	void testNewPayroll() throws Exception {
		Payroll expectedPayroll = new Payroll();
		expectedPayroll.setPayrollId(1);
		expectedPayroll.setEmployee(employee);
		expectedPayroll.setPayrollDate("19-10-2021");
		expectedPayroll.setHourlyRate(5);
		expectedPayroll.setAnnualSalary(1800);
		expectedPayroll.setTax(5);
		expectedPayroll.setNetSalary(1710);

		payrollService.storeData(expectedPayroll);
		
		when(payrollRepository.getById((long) 1))
			.thenReturn(expectedPayroll);
		Payroll actualPayroll = this.payrollRepository.getById((long) 1);
		
		Assertions.assertEquals(expectedPayroll, actualPayroll);
	}
	
	@Test
	@Order(2)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewPayrollWithEmptyPayrollId() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId((Long) null);
			expectedPayroll.setEmployee(employee);
			expectedPayroll.setPayrollDate("19-10-2021");
			expectedPayroll.setHourlyRate((Long) null);
			expectedPayroll.setAnnualSalary(1800);
			expectedPayroll.setTax(5);
			expectedPayroll.setNetSalary(1710);	    
		});
	}
	
	@Test
	@Order(3)
	@Rollback(value = false)
	void testNewPayrollWithEmptyEmployee() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Employee cannot be null!";
		
		try {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId(1);
			expectedPayroll.setEmployee(null);
			expectedPayroll.setPayrollDate("19-10-2021");
			expectedPayroll.setHourlyRate(5);
			expectedPayroll.setAnnualSalary(1800);
			expectedPayroll.setTax(5);
			expectedPayroll.setNetSalary(1710);
	
			when(payrollRepository.save(expectedPayroll))
				.thenThrow(new RuntimeException(actualMessage));
			payrollService.storeData(expectedPayroll);
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
	void testNewPayrollWithEmptyPayrollDate() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Payroll date cannot be null!";
		
		try {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId(1);
			expectedPayroll.setEmployee(employee);
			expectedPayroll.setPayrollDate("");
			expectedPayroll.setHourlyRate(5);
			expectedPayroll.setAnnualSalary(1800);
			expectedPayroll.setTax(5);
			expectedPayroll.setNetSalary(1710);
	
			when(payrollRepository.save(expectedPayroll))
				.thenThrow(new RuntimeException(actualMessage));
			payrollService.storeData(expectedPayroll);
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
	@SuppressWarnings("null")
	void testNewPayrollWithEmptyHourlyRate() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId(1);
			expectedPayroll.setEmployee(employee);
			expectedPayroll.setPayrollDate("19-10-2021");
			expectedPayroll.setHourlyRate((Long) null);
			expectedPayroll.setAnnualSalary(1800);
			expectedPayroll.setTax(5);
			expectedPayroll.setNetSalary(1710);	    
		});
	}
	
	@Test
	@Order(6)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewPayrollWithEmptyAnnualSalary() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId(1);
			expectedPayroll.setEmployee(employee);
			expectedPayroll.setPayrollDate("19-10-2021");
			expectedPayroll.setHourlyRate(5);
			expectedPayroll.setAnnualSalary((Long) null);
			expectedPayroll.setTax(5);
			expectedPayroll.setNetSalary(1710);	    
		});
	}
	
	@Test
	@Order(7)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewPayrollWithEmptyTax() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId(1);
			expectedPayroll.setEmployee(employee);
			expectedPayroll.setPayrollDate("19-10-2021");
			expectedPayroll.setHourlyRate(5);
			expectedPayroll.setAnnualSalary(1800);
			expectedPayroll.setTax((Integer) null);
			expectedPayroll.setNetSalary(1710);	    
		});
	}
	
	@Test
	@Order(8)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewPayrollWithEmptyNetSalary() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Payroll expectedPayroll = new Payroll();
			expectedPayroll.setPayrollId(1);
			expectedPayroll.setEmployee(employee);
			expectedPayroll.setPayrollDate("19-10-2021");
			expectedPayroll.setHourlyRate(5);
			expectedPayroll.setAnnualSalary(1800);
			expectedPayroll.setTax(5);
			expectedPayroll.setNetSalary((Integer) null);	    
		});
	}
	
}
