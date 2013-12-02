/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */
@Entity
@Table(name="accounts")
@XmlRootElement(name="Account")
public class Account implements Serializable {
        
        @Column(name="accountname")
        private String accountName = null;
        @Id
        @Column(name="accountnum")
	private String accountNum = null;
        @Column(name="bankname")
	private String bankName = null;
        @Column(name="username")
        private String username = null;
        
        private User user = null;
	
	public Account (){}
	
	public Account (String _accountName, String _accountNum, String _bankName) {
		
		this.accountName = _accountName;
		this.accountNum = _accountNum;
		this.bankName = _bankName;
	}
        
        @ManyToOne
        public User getUser() {
            return user;
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
        
        public String getUsername() {
            return username;
        }
        
        public void setUsername(String username) {
            this.username = username;
        }
        
        public void setUser(User user) {
            this.user = user;
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
