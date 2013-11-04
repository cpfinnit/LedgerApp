/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.accountservice;

import com.ledgerapp.domain.Account;
import javax.jws.WebService;

/**
 *
 * @author Jimmy
 */
@WebService(endpointInterface = "com.ledgerapp.service.accountservice.AddAccount")
public class AddAccountImpl implements AddAccount {

    @Override
    public Account AddAccount(String accountName, String accountNumber, String bankName) {
        
        Account account = new Account();
        account.setAccountName(accountName);
        account.setAccountNum(accountNumber);
        account.setBankName(bankName);
        return account;
        
    }
    
}
