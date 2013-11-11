/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.accountservice;

import com.ledgerapp.domain.Account;
import com.ledgerapp.service.exceptions.InvalidAccountException;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.*;
import javax.jws.soap.SOAPBinding.Style;

/**
 *
 * @author Jimmy
 */
@WebService
@SOAPBinding(style = Style.DOCUMENT)
public interface GetAccountInformation {
    
    @WebMethod public Account getAccount (String accountNum) throws InvalidAccountException;
    @WebMethod public List<Account> getAccounts (String userName) throws InvalidAccountException;
    
}
