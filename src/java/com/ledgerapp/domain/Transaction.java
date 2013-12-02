/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@XmlRootElement(name="Transaction")
public class Transaction {
    
    private String transDate;
    private double transAmount;
    private String toFrom;
    private String accountNum;

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public double getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(double transAmount) {
        this.transAmount = transAmount;
    }

    public String getToFrom() {
        return toFrom;
    }

    public void setToFrom(String toFrom) {
        this.toFrom = toFrom;
    }

    public String getAccountNum() {
        return accountNum;
    }

    public void setAccountNum(String accountNum) {
        this.accountNum = accountNum;
    }
    
    @Override
    public String toString() {
        
        StringBuffer sb = new StringBuffer();
        
        sb.append("Transaction Date: " + this.getTransDate() + "/n");
        sb.append("To/From: " + this.getToFrom() + "/n");
        sb.append("Transaction Amount: " + this.getTransAmount() + "/n");
        
        
        return sb.toString();
    }
    
    
    
    
}
