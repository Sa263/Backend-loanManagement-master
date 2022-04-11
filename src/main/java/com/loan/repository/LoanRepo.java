package com.loan.repository;

import com.loan.model.LoanDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface LoanRepo extends JpaRepository<LoanDetails, Long> {

//    @Query("Select * from LoanDetails where fname=fname")
//    Optional<LoanDetails> findByFname(String fname);


//    @Query(" Select l From LoanDetails l  where l.fname=fname")
    List<LoanDetails> findByFname(String fname);

//    @Query(" Select l From LoanDetails l  where l.lname=lname")
    List<LoanDetails> findByLname(String lname);

//    Optional<LoanDetails> findByFname(String fname);
//
//    Optional<LoanDetails> findByLname(String lname);
}
