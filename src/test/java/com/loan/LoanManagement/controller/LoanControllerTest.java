package com.loan.LoanManagement.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.Optional;

import com.loan.controller.LoanController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.loan.exception.InvalidSessionException;
import com.loan.model.AuthResponse;
import com.loan.model.LoanDetails;
import com.loan.proxy.AuthProxy;
import com.loan.repository.LoanRepo;
import com.loan.service.LoanService;

@SpringBootTest
 class LoanControllerTest {

	@InjectMocks
	LoanController loanController;

	@Mock
	LoanRepo loanRepo;

	@Mock
	LoanService loanService;

	@Mock
	LoanDetails loanDetails;

	@Mock
	AuthResponse authResponse;


		//jnjn
	@Mock
	AuthProxy authProxy;

	private MockMvc mockMvc;

	@BeforeEach
	void setup() {

		mockMvc = MockMvcBuilders.standaloneSetup(loanController).build();

		loanDetails = new LoanDetails();
		loanDetails.setLoannumber(1);
		loanDetails.setFname("Sanchit");
		loanDetails.setLname("Arora");
		loanDetails.setLegaldocument("Pan");
		loanDetails.setLeininfo("hh");
		loanDetails.setLoanamount(12345);
		loanDetails.setLoanhistory("Good");
		loanDetails.setLoanmanagementfees(234);
		loanDetails.setLoanstatus("Active");
	}

	@Test
	 void getCurrentDataTest() throws InvalidSessionException {


		when(loanService.getCurrentData("token", 1)).thenReturn(loanDetails);
		ResponseEntity<?> loanCheck = loanController.getCurrentData("token", 1);
		assertEquals(200, loanCheck.getStatusCodeValue());
	}

	@Test
	 void deleteTest() throws Exception {

		when(loanRepo.findById(loanDetails.getLoannumber())).thenReturn(Optional.of(loanDetails));
		ResponseEntity<?> loanCheck = loanController.deleteLoan("token", 1);
		assertEquals(200, loanCheck.getStatusCodeValue());

	}

	@Test
	 void addNewTest() throws InvalidSessionException {
		when(loanService.addLoanDetails("token", loanDetails)).thenReturn(loanDetails);
		ResponseEntity<?> loanCheck = loanController.addLoan("token", loanDetails);
		assertEquals(200, loanCheck.getStatusCodeValue());

	}

	@Test
	 void updateTest() throws InvalidSessionException {

		when(loanService.updateLoan("token", loanDetails)).thenReturn(loanDetails);
		loanDetails.setFname("P");
		when(loanRepo.save(loanDetails)).thenReturn(loanDetails);
		ResponseEntity<?> loanCheck = loanController.updateLoan("token", 1, loanDetails);
		assertEquals(200, loanCheck.getStatusCodeValue());

	}

}
