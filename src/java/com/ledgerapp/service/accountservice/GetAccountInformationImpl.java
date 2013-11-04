/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.accountservice;

import com.ledgerapp.domain.Account;
import java.util.List;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author Jimmy
 */
@WebService(endpointInterface = "com.ledgerapp.service.accountservice.GetAccountInformation")
public class GetAccountInformationImpl implements GetAccountInformation {

    @Override
    public Account getAccount(String AccountNum) {
        
        Account account = new Account();
        
        account.setAccountName("My Checking Account");
        account.setAccountNum("8675309");
        account.setBankName("First National Bank of Springfield");
        
        return account;
    }

    @Override
    public List<Account> getAccounts(String userName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
