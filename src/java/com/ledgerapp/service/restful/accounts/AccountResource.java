/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.restful.accounts;



import com.ledgerapp.domain.Account;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.ResponseBuilder;

/**
 *
 * @author Jimmy
 */
@Path("/accounts")
public class AccountResource {
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{accountNumber}")
    public Response getAccount(@PathParam("accountNumber") String accountNumber) {
        ResponseBuilder builder = Response.ok(returnAccount(accountNumber));
        return builder.build();
    }
    
    private Account returnAccount(String accountNum) {
        
        Account account = new Account();
        
        account.setAccountName("My Checking");
        account.setAccountNum("123456789");
        account.setBankName("First Bank of Gotham");
        
        return account;
        
    }
    
    
    
    
}
