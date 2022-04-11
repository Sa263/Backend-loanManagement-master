package com.loan.LoanManagement.serviceTest;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import com.loan.model.LoanDetails;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.loan.exception.InvalidSessionException;
import com.loan.exception.ResourceNotFoundException;
import com.loan.model.AuthResponse;
import com.loan.proxy.AuthProxy;
import com.loan.repository.LoanRepo;
import com.loan.serviceImpl.LoanServiceImpl;

@SpringBootTest
 class LoanServiceImplTest {

	@InjectMocks
	LoanServiceImpl loanServiceImpl;

	@Mock
	LoanRepo loanRepo;

	@Mock
	LoanDetails loanDetails;

	@Mock
	private AuthProxy authProxy;

	@Mock
	AuthResponse authResponse;

	@BeforeEach
	void setup() {
		
		loanDetails = new LoanDetails();

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
	}

	@Test
	 void getByIdTest() throws InvalidSessionException {

		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);

		long id = 1;
		when(loanRepo.findById(id)).thenReturn(Optional.of(loanDetails));
		LoanDetails result = loanServiceImpl.getCurrentData("token", id);
		assertEquals(1, result.getLoannumber());
		assertEquals("Sanchit", result.getFname());
		assertEquals("Arora", result.getLname());
		assertEquals("Pan", result.getLegaldocument());
		assertEquals("hh", result.getLeininfo());
		assertEquals(12345, result.getLoanamount());
		assertEquals("Good", result.getLoanhistory());
		assertEquals(234, result.getLoanmanagementfees());
		assertEquals("Active", result.getLoanstatus());
	}

	@Test
	 void getByIdExceptionTest() throws InvalidSessionException {
		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);

		long id = 0;
		assertThrows(ResourceNotFoundException.class, () -> loanServiceImpl.getCurrentData("token", id));
	}

	@Test
	 void ResourceNotFoundException() {
		authResponse = new AuthResponse();
		authResponse.setValid(false);
		when(authProxy.getValidity("token")).thenReturn(authResponse);

		long id = 0;
		assertThrows(ResourceNotFoundException.class, () -> loanServiceImpl.getCurrentData("token", id));
	}

	@Test
	void saveLoanTest() throws InvalidSessionException {

		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);

		when(loanRepo.save(loanDetails)).thenReturn(loanDetails);
		LoanDetails result = loanServiceImpl.addLoanDetails("token", loanDetails);
		assertEquals(1, result.getLoannumber());
		assertEquals("Sanchit", result.getFname());
		assertEquals("Arora", result.getLname());
		assertEquals("Pan", result.getLegaldocument());
		assertEquals("hh", result.getLeininfo());
		assertEquals(12345, result.getLoanamount());
		assertEquals("Good", result.getLoanhistory());
		assertEquals(234, result.getLoanmanagementfees());
		assertEquals("Active", result.getLoanstatus());

	}



	@Test
	 void deleteTest() throws InvalidSessionException {

		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);

		when(loanRepo.findById(loanDetails.getLoannumber())).thenReturn(Optional.of(loanDetails));
		loanServiceImpl.deleteLoan("token", loanDetails.getLoannumber());
		verify(loanRepo).deleteById(loanDetails.getLoannumber());
	}

	@Test
	 void deleteExceptionTest() throws InvalidSessionException {
		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);
		long id = 0;
		assertThrows(ResourceNotFoundException.class, () -> loanServiceImpl.deleteLoan("token", id));
	}

	@Test
	 void deleteInvalidSessionExceptionTest()  {
		authResponse = new AuthResponse();
		authResponse.setValid(false);
		when(authProxy.getValidity("token")).thenReturn(authResponse);
		long id = 0;
		assertThrows(ResourceNotFoundException.class, () -> loanServiceImpl.deleteLoan("token", id));
	}

	@Test
	 void updateTest() throws InvalidSessionException {

		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);

		when(loanRepo.findById(loanDetails.getLoannumber())).thenReturn(Optional.of(loanDetails));
		loanServiceImpl.updateLoan("token", loanDetails);
		loanDetails.setFname("P");
		loanRepo.save(loanDetails);
		LoanDetails updatedDetails = loanServiceImpl.getCurrentData("token", loanDetails.getLoannumber());
		assertEquals("P", updatedDetails.getFname());

	}

	@Test
	 void updateExceptionTest() throws InvalidSessionException {
		authResponse = new AuthResponse();
		authResponse.setValid(true);
		when(authProxy.getValidity("token")).thenReturn(authResponse);
		assertThrows(ResourceNotFoundException.class, () -> loanServiceImpl.updateLoan("token", loanDetails));
	}

	@Test
	 void updateInvalidExceptionTest() throws InvalidSessionException {
		authResponse = new AuthResponse();
		authResponse.setValid(false);
		when(authProxy.getValidity("token")).thenReturn(authResponse);
		assertThrows(ResourceNotFoundException.class, () -> loanServiceImpl.updateLoan("token", loanDetails));
	}

}
