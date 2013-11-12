/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.transactionservice;

import com.ledgerapp.domain.Transaction;
import com.ledgerapp.service.exceptions.InvalidTransactionException;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Jimmy
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface GetTransactionInformation {
    
    @WebMethod public Transaction getTransaction() throws InvalidTransactionException;
    
}
