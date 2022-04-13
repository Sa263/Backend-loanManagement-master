package com.loan.model;


import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Getter
@Setter
@NoArgsConstructor
//@Entity
//Used to store loan Details
@Document(collection = "loanDetails")
public class LoanDetails {

    //column
    @Id
    private long loannumber;




    //column
    @NotNull
    private long loanamount;



    //column
    @NotNull
    private String loanstatus;

    //column
    @NotNull
    private long loanmanagementfees;

    //column
//    @NotNull
//    private Date originationDate;

    //column
    @NotNull
    private String leininfo;

    //column
    @NotNull
    private String legaldocument;

    //column
    @NotNull
    private String loanhistory;

    //column
    @NotNull
    private String fname;

    //column
    @NotNull
    private String lname;

    public LoanDetails(long i, long abcdef, String home, long i1, String i2, String active, String i3, String hh,String ff) {
    }

    @Override
    public String toString() {
        return "LoanDetails{" +
                "loannumber=" + loannumber +
                ", loanamount=" + loanamount +
                ", loanstatus='" + loanstatus + '\'' +
                ", loanmanagementfees=" + loanmanagementfees +
                ", leininfo='" + leininfo + '\'' +
                ", legaldocument='" + legaldocument + '\'' +
                ", loanhistory='" + loanhistory + '\'' +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

    public long getLoannumber() {
        return loannumber;
    }

    public void setLoannumber(long loannumber) {
        this.loannumber = loannumber;
    }






    public long getLoanamount() {
        return loanamount;
    }

    public void setLoanamount(long loanamount) {
        this.loanamount = loanamount;
    }



    public String getLoanstatus() {
        return loanstatus;
    }

    public void setLoanstatus(String loanstatus) {
        this.loanstatus = loanstatus;
    }

    public long getLoanmanagementfees() {
        return loanmanagementfees;
    }

    public void setLoanmanagementfees(long loanmanagementfees) {
        this.loanmanagementfees = loanmanagementfees;
    }

    public String getLeininfo() {
        return leininfo;
    }

    public void setLeininfo(String leininfo) {
        this.leininfo = leininfo;
    }

    public String getLegaldocument() {
        return legaldocument;
    }

    public void setLegaldocument(String legaldocument) {
        this.legaldocument = legaldocument;
    }

    public String getLoanhistory() {
        return loanhistory;
    }

    public void setLoanhistory(String loanhistory) {
        this.loanhistory = loanhistory;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

}
