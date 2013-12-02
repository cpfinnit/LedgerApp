/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MapKeyColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Jimmy
 */

@XmlRootElement(name="User")
@Entity
@Table(name="users")
public class User implements Serializable {
        
        @Id
        @GeneratedValue
        @Column(name="id")
        private int id;
        
        @Column(name="username", unique=true)
        private String username;
       
        
        private List<Account> accounts = new ArrayList();
        
        @OneToMany(cascade={CascadeType.ALL})
        public List<Account> getAccounts() {
            return accounts;
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
        
        public void addAccount(Account account) {
            accounts.add(account);
        }
        
        public void setID(int id) {
            this.id = id;
        }
	
        public int getID() {
            return id;
        }
    
    @Override
    public String toString() {
        return this.getUsername();
    }
	
	
    
}
