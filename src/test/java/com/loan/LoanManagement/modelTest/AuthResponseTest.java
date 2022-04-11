package com.loan.LoanManagement.modelTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.model.AuthResponse;

@SpringBootTest
 class AuthResponseTest {

	@InjectMocks
	AuthResponse authResponse;

	@Test
	void authGetterSetterMethodTest() {
		authResponse = new AuthResponse("user", "user", false);

		authResponse.setUsername("admin");
		authResponse.setRole("admin");
		authResponse.setValid(true);

		//comm

		assertEquals("admin", authResponse.getUsername());
		assertEquals("admin", authResponse.getRole());
		assertEquals(true, authResponse.isValid());
	}

	@Test
	 void constructorTest() {
		authResponse = new AuthResponse("user", "user", false);
		assertNotNull(authResponse);
		assertNotNull(new AuthResponse("user", "user", false));

	}

}
