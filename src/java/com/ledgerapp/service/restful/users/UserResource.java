/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.service.restful.users;

import com.ledgerapp.business.user.UserMgr;
import com.ledgerapp.domain.User;
import com.ledgerapp.service.exceptions.UserNotFoundException;
import java.io.IOException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.persistence.NoResultException;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
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
@Path("/users")
@RequestScoped
public class UserResource {
    
    @Inject
    private UserMgr userMgr;
    
   
    @GET
    @Consumes(MediaType.APPLICATION_XML)
    @Produces({MediaType.APPLICATION_XML})
    @Path("{username}")
    public Response getUserXML(@PathParam("username") String username) throws UserNotFoundException {
        
        User user = null;
        
        try
        {
            user = userMgr.read(username);
        }
        catch (NoResultException nre)
        {
            throw new UserNotFoundException("User with username " + username + " not found.");
        }
        
       ResponseBuilder builder = Response.ok(user);
       return builder.build();
    }
    
    
    @GET
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    @Path("{username}")
    public String getUserString(@PathParam("username") String username) throws UserNotFoundException {
        
        User user = null;
        
        try
        {
            user = userMgr.read(username);  
        }
        catch (NoResultException nre)
        {
            throw new UserNotFoundException("User with " + username + " not found.");
        }
        
        return user.getUsername();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public Response createUserXML(@FormParam("username") String username) throws IOException {
        
        User user = new User();   //creates user object
        user.setUsername(username);  //sets properties
        
        user = userMgr.create(user); //persists the user object
        
        ResponseBuilder builder = Response.ok(user);  //returns the xml representation of the user object.
        
        return builder.build();        
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String createUserString(@FormParam("username") String username) throws IOException {
        
        User user = new User();
        user.setUsername(username);
        return userMgr.create(user).toString();    
    }
    
    @PUT
    @Path("{username}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.APPLICATION_XML)
    public Response updateUserXML(@PathParam("username") String username, @FormParam("_username") String _username) {
        User user = userMgr.update(username, _username);         
        ResponseBuilder builder = Response.ok(user);
        return builder.build();
    }
    
    @PUT
    @Path("{username}")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public String updateUserString(@PathParam("username") String username, @FormParam("_username") String _username) {
        User user = userMgr.update(username, _username);
        return (user.getUsername().toString());
    }
    
    
    @DELETE
    @Path("{username}")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public Response deleteUserXML(@PathParam("username") String username) {
               
        userMgr.delete(username);

        ResponseBuilder builder = Response.ok();
        return builder.build();
        
    }
   
    
    @DELETE
    @Path("{username}")
    @Consumes(MediaType.TEXT_PLAIN)
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteUserString(@PathParam("username") String username) {
        
        userMgr.delete(username);
        ResponseBuilder builder = Response.ok();
        return builder.build();
        
    }
    
}
