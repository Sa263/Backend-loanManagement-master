package com.loan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.loan.exception.InvalidSessionException;
import com.loan.model.LoanDetails;
import com.loan.service.LoanService;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class LoanController {

    @Autowired
    private LoanService loanService;

    @GetMapping("get/{id}")
    public ResponseEntity<?> getCurrentData(@RequestHeader(name = "Authorization") String token, @PathVariable long id)
            throws InvalidSessionException {
        LoanDetails loan = loanService.getCurrentData(token,id);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }
    @GetMapping("getname/{fname}")
    public ResponseEntity<?> getByfName( @RequestHeader(name = "Authorization") String token,@PathVariable String fname)
            throws InvalidSessionException {
        List<LoanDetails> loan = loanService.getCurrentDataByfName(token, fname);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }

    @GetMapping("getbylname/{lname}")
    public ResponseEntity<?> getBylName( @RequestHeader(name = "Authorization") String token,@PathVariable String lname)
            throws InvalidSessionException {
        List<LoanDetails> loan = loanService.getCurrentDataBylName( token,lname);
        return new ResponseEntity<>(loan, HttpStatus.OK);
    }


    @PostMapping("/new")
    public ResponseEntity<?> addLoan(@RequestHeader(name = "Authorization") String token, @RequestBody LoanDetails loan)
            throws InvalidSessionException {
        LoanDetails loans = this.loanService.addLoanDetails(token, loan);
        return new ResponseEntity<>(loans, HttpStatus.OK);
    }

    @PutMapping("edit/{id}")
    public ResponseEntity<?> updateLoan( @RequestHeader(name = "Authorization") String token,@PathVariable long id,
                                        @RequestBody LoanDetails loan) throws InvalidSessionException {
        loan.setLoannumber(id);
        LoanDetails loan1 = this.loanService.updateLoan(token, loan);
        return new ResponseEntity<>(loan1, HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<?> deleteLoan(@RequestHeader(name = "Authorization") String token, @PathVariable long id)
            throws InvalidSessionException {
        this.loanService.deleteLoan(token, id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
