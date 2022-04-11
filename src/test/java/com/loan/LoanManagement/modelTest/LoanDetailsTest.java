package com.loan.LoanManagement.modelTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Date;

import com.loan.model.LoanDetails;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.model.LoanDetails;

@SpringBootTest
 class LoanDetailsTest {

	@InjectMocks
	LoanDetails loanDetails;

	@Test
	 void getterSetterTest() {
		loanDetails = new LoanDetails();
		loanDetails.setLoannumber((long) 1);
		loanDetails.setFname("Sanchit");
		loanDetails.setLname("Arora");
		loanDetails.setLegaldocument("Pan");
		loanDetails.setLeininfo("hh");
		loanDetails.setLoanamount(12345);
		loanDetails.setLoanhistory("Good");
		loanDetails.setLoanmanagementfees(234);
		loanDetails.setLoanstatus("Active");

		assertEquals(1, loanDetails.getLoannumber());
		assertEquals("Sanchit", loanDetails.getFname());
		assertEquals("Arora", loanDetails.getLname());
		assertEquals("Pan", loanDetails.getLegaldocument());
		assertEquals("hh", loanDetails.getLeininfo());
		assertEquals(12345, loanDetails.getLoanamount());
		assertEquals("Good", loanDetails.getLoanhistory());
		assertEquals(234, loanDetails.getLoanmanagementfees());
		assertEquals("Active", loanDetails.getLoanstatus());

	}

	@Test
	 void constructorTest() {
		loanDetails = new LoanDetails();

		assertNotNull(loanDetails);

		assertNotNull(new LoanDetails(1, 2,"2", 3, "12345", "kskk", "Active", "234", "hh"));

	}

}
