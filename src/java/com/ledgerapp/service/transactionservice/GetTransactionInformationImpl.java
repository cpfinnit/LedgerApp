/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.transactionservice;

import com.ledgerapp.domain.Transaction;
import com.ledgerapp.service.exceptions.InvalidTransactionException;
import javax.jws.WebService;

/**
 *
 * @author Jimmy
 */
@WebService(endpointInterface = "com.ledgerapp.service.transactionservice.GetTransactionInformation")
public class GetTransactionInformationImpl implements GetTransactionInformation {

    @Override
    public Transaction getTransaction() throws InvalidTransactionException {
        
        Transaction trans = new Transaction();
        
        trans.setAccountNum("867309");
        trans.setToFrom("Moe's Tavern");
        trans.setTransDate("11/1/2013");
        trans.setTransAmount(35.99);
        
        if (trans == null)
        {
           throw new InvalidTransactionException("Invalid transaction", null); 
        }
            
                
        
        return trans;
        
    }
    
}
