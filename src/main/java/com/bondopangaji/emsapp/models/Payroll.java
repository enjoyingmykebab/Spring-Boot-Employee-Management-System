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

package com.bondopangaji.emsapp.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author bondopangaji
 *
 */

@Entity(name = "Payroll")
@Table(name = "payroll")
public class Payroll {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "payroll_id",
			length = 36,
			nullable = false,
			updatable = false)
	private long payrollId;
	
	@ManyToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "employee_id",
    			referencedColumnName = "employee_id")
	private Employee employee;
	
	@Column(name = "payroll_date",
			length = 10,
			nullable = false,
			insertable = true,
			updatable = true,
			columnDefinition = "TEXT")
	private String payrollDate;
	
	@Column(name = "hourly_rate",
			length = 255,
			nullable = false,
			insertable = true,
			updatable = true)
	private long hourlyRate;
	
	@Column(name = "annual_salary",
			length = 255,
			nullable = false,
			insertable = true,
			updatable = true)
	private long annualSalary;

	@Column(name = "tax",
			length = 255,
			nullable = false,
			insertable = true,
			updatable = true)
	private int tax;
	
	@Column(name = "net_salary",
			length = 255,
			nullable = false,
			insertable = true,
			updatable = true)
	private int netSalary;

	/**
	 * @return the payrollId
	 */
	public long getPayrollId() {
		return payrollId;
	}

	/**
	 * @param payrollId the payrollId to set
	 */
	public void setPayrollId(long payrollId) {
		this.payrollId = payrollId;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the payrollDate
	 */
	public String getPayrollDate() {
		return payrollDate;
	}

	/**
	 * @param payrollDate the payrollDate to set
	 */
	public void setPayrollDate(String payrollDate) {
		this.payrollDate = payrollDate;
	}

	/**
	 * @return the hourlyRate
	 */
	public long getHourlyRate() {
		return hourlyRate;
	}

	/**
	 * @param hourlyRate the hourlyRate to set
	 */
	public void setHourlyRate(long hourlyRate) {
		this.hourlyRate = hourlyRate;
	}

	/**
	 * @return the annualSalary
	 */
	public long getAnnualSalary() {
		return annualSalary;
	}

	/**
	 * @param annualSalary the annualSalary to set
	 */
	public void setAnnualSalary(long annualSalary) {
		this.annualSalary = annualSalary;
	}

	/**
	 * @return the tax
	 */
	public int getTax() {
		return tax;
	}

	/**
	 * @param tax the tax to set
	 */
	public void setTax(int tax) {
		this.tax = tax;
	}

	/**
	 * @return the netSalary
	 */
	public int getNetSalary() {
		return netSalary;
	}

	/**
	 * @param netSalary the netSalary to set
	 */
	public void setNetSalary(int netSalary) {
		this.netSalary = netSalary;
	}
	
}
