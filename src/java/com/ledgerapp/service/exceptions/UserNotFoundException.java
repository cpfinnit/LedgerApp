/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.exceptions;

import java.io.Serializable;

/**
 *
 * @author Jimmy
 */
public class UserNotFoundException extends Exception implements Serializable {
    
    private String exceptionMessage;
    
    public UserNotFoundException() {
        super();
    }
    
    public UserNotFoundException(String _exceptionMessage) {
        super(_exceptionMessage);
    }
    
    public UserNotFoundException(String _exceptionMessage, Exception e) {
        super(_exceptionMessage, e);
    }
    
}
