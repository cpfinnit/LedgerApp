/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.transactionservice;

import com.ledgerapp.domain.Transaction;
import javax.jws.WebService;

/**
 *
 * @author Jimmy
 */
@WebService(endpointInterface = "com.ledgerapp.service.transactionservice.AddTransaction")
public class AddTransactionImpl implements AddTransaction {

    @Override
    public Transaction addTransaction(String toFrom, String transDate, double transAmount, String accountNumber) {
        
        Transaction trans = new Transaction();
        
        trans.setAccountNum(accountNumber);
        trans.setToFrom(toFrom);
        trans.setTransAmount(transAmount);
        trans.setTransDate(transDate);
       
        return trans;
    }
    
}
