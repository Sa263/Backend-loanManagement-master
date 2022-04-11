package com.loan.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
//@Entity
@Table(name = "loanDetails")
//Used to store loan Details
@Entity
public class LoanDetails {

    //column
    @Id
    @GeneratedValue
    @Column(name = "loannumber")
    private long loannumber;




    //column
    @NotNull
    @Column(name = "loanamount")
    private long loanamount;



    //column
    @NotNull
    @Column(name = "loanstatus")
    private String loanstatus;

    //column
    @NotNull
    @Column(name = "loanmanagementfees")
    private long loanmanagementfees;

    //column
//    @NotNull
//    private Date originationDate;

    //column
    @NotNull
    @Column(name = "leininfo")
    private String leininfo;

    //column
    @NotNull
    @Column(name = "loandocument")
    private String legaldocument;

    //column
    @NotNull
    @Column(name = "loanhistory")
    private String loanhistory;

    //column
    @NotNull
    @Column(name = "fname")
    private String fname;

    //column
    @NotNull
    @Column(name = "lname")
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
