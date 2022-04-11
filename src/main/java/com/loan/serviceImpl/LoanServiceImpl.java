package com.loan.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import com.loan.exception.InvalidSessionException;
import com.loan.exception.ResourceNotFoundException;
import com.loan.model.LoanDetails;
import com.loan.proxy.AuthProxy;
import com.loan.repository.LoanRepo;
import com.loan.service.LoanService;

import javax.transaction.Transactional;


@Service
@Transactional
public class LoanServiceImpl implements LoanService {

    @Autowired
    private AuthProxy authProxy;

    @Autowired
    private LoanRepo loanRepo;

    @Override
    public LoanDetails getCurrentData(String token, long id) throws InvalidSessionException {

        Optional<LoanDetails> loanDb = this.loanRepo.findById(id);
        if (loanDb.isPresent()) {
            return loanDb.get();
        } else {
            throw new ResourceNotFoundException("Record not found");
        }
    }

    @Override
    public List<LoanDetails> getCurrentDataByfName( String token,String fname) throws InvalidSessionException {
        return loanRepo.findByFname(fname);
    }

    @Override
    public List<LoanDetails> getCurrentDataBylName( String token,String lname) throws InvalidSessionException {
        return loanRepo.findByLname(lname);
    }


    @Override
    public LoanDetails updateLoan(String token, LoanDetails loan) throws InvalidSessionException {

        Optional<LoanDetails> loanDb = this.loanRepo.findById(loan.getLoannumber());
        if (loanDb.isPresent()) {
            LoanDetails loanUpdate = loanDb.get();
            loanUpdate.setFname(loan.getFname());
            loanUpdate.setLname(loan.getLname());
            loanUpdate.setLoanamount(loan.getLoanamount());
            loanUpdate.setLegaldocument(loan.getLegaldocument());
            loanUpdate.setLeininfo(loan.getLeininfo());
            loanUpdate.setLoanhistory(loan.getLoanhistory());
            loanUpdate.setLoanmanagementfees(loan.getLoanmanagementfees());
            loanUpdate.setLoanstatus(loan.getLoanstatus());
            loanRepo.save(loanUpdate);
            return loanUpdate;
        } else {
            throw new ResourceNotFoundException("Record not found");
        }
    }

    @Override
    public void deleteLoan( String token,long id) throws InvalidSessionException {

        Optional<LoanDetails> loanDb = this.loanRepo.findById(id);
        if (loanDb.isPresent()) {
            loanRepo.deleteById(id);
        } else {
            throw new ResourceNotFoundException("Record not found");
        }

    }

    @Override
    public LoanDetails addLoanDetails(String token, LoanDetails loan) throws InvalidSessionException {
        return loanRepo.save(loan);
    }

}
