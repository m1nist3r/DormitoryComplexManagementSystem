package com.m1nist3r.dormitory.web.application.business.domain.payment;

import com.m1nist3r.dormitory.web.application.business.domain.resident.Resident;
import com.m1nist3r.dormitory.web.application.securing.auth.administrator.Administrator;

import java.math.BigDecimal;
import java.util.Date;

public class Payments {
    private long id;
    private BigDecimal amount;
    private BigDecimal balance;
    private Date paymentDate;
    private String paymentType;
    private Resident resident;
    private Administrator admin;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public Resident getResident() {
        return resident;
    }

    public void setResident(Resident resident) {
        this.resident = resident;
    }

    public Administrator getAdmin() {
        return admin;
    }

    public void setAdministrator(Administrator admin) {
        this.admin = admin;
    }
}
