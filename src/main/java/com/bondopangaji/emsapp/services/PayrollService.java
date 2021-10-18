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

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bondopangaji.emsapp.interfaces.PayrollInterface;
import com.bondopangaji.emsapp.models.Payroll;
import com.bondopangaji.emsapp.repositories.PayrollRepository;

/**
 * @author bondopangaji
 *
 */

@Service
public class PayrollService implements PayrollInterface {

	@Autowired
	private PayrollRepository payrollRepository;
	
	@Override
	public List<Payroll> getAll() {
		return payrollRepository.findAll();
	}

	@Override
	public void storeData(Payroll payroll) throws Exception {
		this.payrollRepository.save(payroll);
	}

	@Override
	public void storeEditData(Payroll payroll) throws Exception {
		this.payrollRepository.save(payroll);
	}

	@Override
	public Payroll getDataById(long employeeId) {
		Optional<Payroll> optional = payrollRepository.findById(employeeId);
		
		if (!optional.isPresent()) {
			throw new RuntimeException(" Payroll not found for id :: " + employeeId);
		}
		Payroll payroll = optional.get();
		
		return payroll;
	}
	
	@Override
	public void deleteDataById(long id) {
		this.payrollRepository.deleteById(id);
	}

}
