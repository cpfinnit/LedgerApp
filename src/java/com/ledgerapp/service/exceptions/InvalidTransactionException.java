/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.exceptions;

/**
 *
 * @author Jimmy
 */
public class InvalidTransactionException extends Exception {
    
     String exceptionMessage;
    
    public InvalidTransactionException (String cause, String _exceptionMessage) {
        super(cause);
        this.exceptionMessage = _exceptionMessage;
    }
    
    public String getFaultInfo() {
        return null;
    }
    
    
}
