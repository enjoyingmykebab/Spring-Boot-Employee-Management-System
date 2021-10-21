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

import com.bondopangaji.emsapp.models.Role;
import com.bondopangaji.emsapp.repositories.RoleRepository;
import com.bondopangaji.emsapp.services.RoleService;

/**
 * @author bondopangaji
 *
 */

@DisplayName("Test case for Role object")
@ExtendWith(MockitoExtension.class)
public class RoleTests {

	@Mock
	private RoleRepository roleRepository;

	@InjectMocks
	private RoleService roleService;

	@Test
	@Order(1)
	@Rollback(value = false)
	void testNewRole() throws Exception {
		Role expectedRole = new Role();
		expectedRole.setRoleId(3);
		expectedRole.setRoleTitle("Super Admin");
		expectedRole.setRoleDescription("Admin with extended authority");

		roleService.storeData(expectedRole);

		when(roleRepository.getById((long) 1)).thenReturn(expectedRole);
		Role actualPayroll = this.roleRepository.getById((long) 1);

		Assertions.assertEquals(expectedRole, actualPayroll);
	}

	@Test
	@Order(2)
	@Rollback(value = false)
	@SuppressWarnings("null")
	void testNewRoleWithEmptyRoleId() throws NullPointerException {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Role expectedRole = new Role();
			expectedRole.setRoleId((Long) null);
			expectedRole.setRoleTitle("Super Admin");
			expectedRole.setRoleDescription("Admin with extended authority");
		});
	}

	@Test
	@Order(3)
	@Rollback(value = false)
	void testNewRoleWithEmptyRoleTitle() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Role title cannot be null!";
		try {
			Role expectedRole = new Role();
			expectedRole.setRoleId(3);
			expectedRole.setRoleTitle("");
			expectedRole.setRoleDescription("Admin with extended authority");

			when(roleRepository.save(expectedRole))
				.thenThrow(new RuntimeException(actualMessage));
			roleService.storeData(expectedRole);
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
	void testNewRoleWithEmptyRoleDescription() throws Exception {
		Throwable e = null;
		String expectedMessage = null;
		String actualMessage = "Role description cannot be null!";
		try {
			Role expectedRole = new Role();
			expectedRole.setRoleId(3);
			expectedRole.setRoleTitle("Super Admin");
			expectedRole.setRoleDescription("");

			when(roleRepository.save(expectedRole))
				.thenThrow(new RuntimeException(actualMessage));
			roleService.storeData(expectedRole);
		} catch (RuntimeException rex) {
			e = rex;
			expectedMessage = e.getMessage();
		}
		Assertions.assertTrue(e instanceof Exception);
		Assertions.assertEquals(expectedMessage, actualMessage);
	}
}
