/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.accountservice;

import com.ledgerapp.domain.Account;
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
public interface AddAccount {
    
    @WebMethod public void AddAccount(String accountName, String accountNumber, String bankName);
    
}
