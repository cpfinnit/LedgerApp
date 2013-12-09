/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.business.user;

import com.ledgerapp.domain.User;

/**
 *
 * @author Jimmy
 */
public interface UserMgr {
    
    public User create(User user);
    public User read(int id);
    public User update(String username, String _username);
    public void delete(String user); 
}
