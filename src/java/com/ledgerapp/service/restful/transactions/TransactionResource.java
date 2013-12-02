/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.restful.transactions;

import com.ledgerapp.domain.Transaction;
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
@Path("/transactions")
public class TransactionResource {
    
    @GET
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    @Path("{transactionID}")
    public Response getAccount(@PathParam("accountNumber") String accountNumber) {
        ResponseBuilder builder = Response.ok(returnTransaction(accountNumber));
        return builder.build();
    }
    
    private Transaction returnTransaction(String transactionID) {
        
        Transaction trans = new Transaction();
        
        trans.setAccountNum("123456789");
        trans.setToFrom("Alfred Pennyworth");
        trans.setTransAmount(9954.25);
        trans.setTransDate("11/12/13");
        
        return trans;
        
    }
    
}
