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
import javax.persistence.EntityNotFoundException;
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
import javax.ws.rs.QueryParam;
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
    @Path("{id}")
    public Response getUserXML(@PathParam("id") int id, @QueryParam("reqFormat") String reqFormat) throws UserNotFoundException {
        
        User user = null;
        
        user = userMgr.read(id);
        
        if (reqFormat.equalsIgnoreCase("xml"))
        {   
            ResponseBuilder builder = Response.ok(user, MediaType.APPLICATION_XML);
            return builder.build();
        }
        else if (reqFormat.equalsIgnoreCase("plain/text"))
        {
            ResponseBuilder builder = Response.ok(user.getUsername(), MediaType.TEXT_PLAIN);
            return builder.build();
        }
        else
        {
            throw new EntityNotFoundException();
        }
    }

    @POST
    public Response createUserXML(@FormParam("username") String username, @QueryParam("reqFormat") String reqFormat) throws IOException {
        
        User user = new User();   //creates user object
        
        if (reqFormat.equalsIgnoreCase("plain/text"))
        {
            user.setUsername(username);  //sets properties
            user = userMgr.create(user); //persists the user object
            ResponseBuilder builder = Response.ok(user.getUsername(), MediaType.TEXT_PLAIN);  //returns the xml representation of the user object.
            return builder.build();
        }
        else if (reqFormat.equalsIgnoreCase("xml"))
        {
            user.setUsername(username);  //sets properties
            user = userMgr.create(user); //persists the user object
            ResponseBuilder builder = Response.ok(user, MediaType.APPLICATION_XML);  //returns the xml representation of the user object.
            return builder.build();
        }
        else
        {
            throw new EntityNotFoundException();
        }        
    }

    @PUT
    @Path("{username}")
    public Response updateUserXML(@PathParam("username") String username, @FormParam("_username") String _username, @QueryParam("reqFormat") String reqFormat) {
        if (reqFormat.equalsIgnoreCase("plain/text"))
        {
            User user = userMgr.update(username, _username);
            ResponseBuilder builder = Response.ok(user.getUsername(), MediaType.TEXT_PLAIN);
            return builder.build();
        }
        else if (reqFormat.equalsIgnoreCase("xml"))
        {
            User user = userMgr.update(username, _username);
            ResponseBuilder builder = Response.ok(user, MediaType.APPLICATION_XML);
            return builder.build();
        }
        else
        {
            throw new EntityNotFoundException();
        }
    }

    @DELETE
    @Path("{username}")
    public Response deleteUserXML(@PathParam("username") String username, @QueryParam("reqFormat") String reqFormat) {
        
        if (reqFormat.equalsIgnoreCase("plain/text"))
        {
            userMgr.delete(username);
            ResponseBuilder builder = Response.ok();
            return builder.build();
        }
        else if (reqFormat.equalsIgnoreCase("xml"))
        {
            userMgr.delete(username);
            ResponseBuilder builder = Response.ok();
            return builder.build();
        }
        else
        {
            throw new EntityNotFoundException();
        }
        
        
    }
    
}
