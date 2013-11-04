/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.userservice;

import com.ledgerapp.domain.User;
import javax.jws.WebService;

/**
 *
 * @author Jimmy
 */
@WebService(endpointInterface = "com.ledgerapp.service.userservice.GetUserImpl")
public class GetUserImpl implements GetUser {

    @Override
    public User getUser(String userName) {
        
        User user = new User();
        user.setUsername("HomerSimpson");
        
        return user;
    }
    
}
