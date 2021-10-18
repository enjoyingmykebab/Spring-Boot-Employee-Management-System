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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author bondopangaji
 *
 */

@Entity(name = "Employee")
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "employee_id",
			length = 36,
			nullable = false,
			updatable = false)
	private long employeeId;
	
	
	@Column(name = "role_id",
			nullable = false,
			insertable = true,
			updatable = true)
	private int roleId;

	@Column(name = "full_name",
			length = 128,
			nullable = false,
			insertable = true,
			updatable = true,
			columnDefinition = "TEXT")
	private String fullName;

	@Column(name = "birth_date",
			length = 10,
			nullable = false,
			insertable = true,
			updatable = true,
			columnDefinition = "TEXT")
	private String birthDate;

	@Column(name = "home_address",
			length = 512,
			nullable = false,
			insertable = true,
			updatable = true,
			columnDefinition = "TEXT")
	private String homeAddress;

	@Column(name = "domicile_address",
			length = 512,
			nullable = true,
			updatable = true,
			columnDefinition = "TEXT")
	private String domicileAddress;

	@Column(name = "phone_number",
			length = 24,
			nullable = false,
			insertable = true,
			updatable = true)
	private String phoneNumber;

	@Column(name = "email",
			length = 48,
			nullable = false,
			insertable = true,
			updatable = true,
			columnDefinition = "TEXT")
	private String email;

	@Column(name = "password",
			nullable = false,
			insertable = true,
			updatable = false,	
			columnDefinition = "TEXT")
	private String password;
	
	/**
	 * @return the employeeId
	 */
	public long getEmployeeId() {
		return employeeId;
	}

	/**
	 * @param employeeId the employeeId to set
	 */
	public void setEmployeeId(long employeeId) {
		this.employeeId = employeeId;
	}

	/**
	 * @return the roleId
	 */
	public int getRoleId() {
		return roleId;
	}

	/**
	 * @param roleId the roleId to set
	 */
	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}

	/**
	 * @return the fullName
	 */
	public String getFullName() {
		return fullName;
	}

	/**
	 * @param fullName the fullName to set
	 */
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	/**
	 * @return the birthDate
	 */
	public String getBirthDate() {
		return birthDate;
	}

	/**
	 * @param birthDate the birthDate to set
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the domicileAddress
	 */
	public String getDomicileAddress() {
		return domicileAddress;
	}

	/**
	 * @param domicileAddress the domicileAddress to set
	 */
	public void setDomicileAddress(String domicileAddress) {
		this.domicileAddress = domicileAddress;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
