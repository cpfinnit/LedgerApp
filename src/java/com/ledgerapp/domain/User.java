/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author Jimmy
 */
public class User {
    
        private String username;
	
	public User(){};
	
	//This ArrayList holds a list of the user's Accounts
	private Map<String, Account> accounts = new HashMap<>();
	
	
	public User(String _username) {
		this.username = _username;
	}
	
	/**
	 * Gets username
	 * @return
	 */
	public String getUsername() {
		return username;
	}
	
	/**
	 * Sets username
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * Adds account to HashMap
	 * @param key
	 * @param account
	 */
	public void addAccount(String key, Account account) {
         this.accounts.put(key, account);
	}
	
	/**
	 * Returns the associated account for a given key.
	 * @param key
	 * @return
	 */
	public Account getAccount(String key) {
         return this.accounts.get(key);
	}
	
	/**
	 * Returns Set of strings containing account keys
	 * @return
	 */
    public Set<String> getKeySet() {
        Set<String> keySet = accounts.keySet();
	
        return keySet;
    }
    
    /**
     * Returns the number of associated accounts.
     * @return
     */
    public int getAccountSize() {
    	return this.accounts.size();
    }

	public Map<String, Account> getAccounts() {
		return accounts;
	}
    
    public void setAccounts(Map<String, Account> accounts) {
    	this.accounts = accounts;
    }
    
    @Override
    public String toString() {
        return this.getUsername();
    }
	
	
    
}
