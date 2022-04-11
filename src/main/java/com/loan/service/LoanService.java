package com.loan.service;

import com.loan.exception.InvalidSessionException;
import com.loan.model.LoanDetails;
import org.springframework.stereotype.Service;

import java.util.List;


public interface LoanService {

    public LoanDetails getCurrentData(String token, long id) throws InvalidSessionException;


    public List<LoanDetails> getCurrentDataByfName(String token, String fName) throws InvalidSessionException;


    public List<LoanDetails> getCurrentDataBylName(String token, String lName) throws InvalidSessionException;


    public LoanDetails updateLoan( String token,LoanDetails loan) throws InvalidSessionException;

    public void deleteLoan(String token, long id) throws InvalidSessionException;

    LoanDetails addLoanDetails(String token, LoanDetails loan) throws InvalidSessionException;
}
