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

package com.bondopangaji.emsapp.interfaces;


import java.util.List;

import com.bondopangaji.emsapp.models.Employee;

/**
 *
 * @author bondopangaji
 */

public interface EmployeeInterface {

	Employee authEmail(String email, String password) throws Exception;
	List<Employee> getAll();
	void storeData(Employee employee) throws Exception;
	void storeEditData(Employee employee) throws Exception;
	Employee getDataById(long id);
	void deleteDataById(long id);
}
