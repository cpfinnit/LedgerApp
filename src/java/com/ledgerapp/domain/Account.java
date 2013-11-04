/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.domain;

/**
 *
 * @author Jimmy
 */
public class Account {
    
        private String accountName = null;
	private String accountNum = null;
	private String bankName = null;
	
	public Account (){}
	
	public Account (String _accountName, String _accountNum, String _bankName) {
		
		this.accountName = _accountName;
		this.accountNum = _accountNum;
		this.bankName = _bankName;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getBankName() {
		return bankName;
	}

	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	
	public boolean validate() {
		
		boolean validated = true;
		
		if (accountName == null || accountName.equals(""))
			return false;
		if ( accountNum == null || accountNum.equals(""))
			return false;
		if ( bankName == null || bankName.equals(""))
			return false;
			
		return validated;
	}
        
        @Override
        public String toString() {
            
            StringBuffer sb = new StringBuffer();
            
            sb.append("Account Name: " + this.getAccountName() + "\n");
            sb.append("Account Number: " + this.getAccountNum() + "\n");
            sb.append("Bank Name: " + this.getBankName());
            
            return sb.toString();
        }
    
}
