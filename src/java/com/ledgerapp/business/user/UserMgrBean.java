/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.business.user;

import com.ledgerapp.domain.User;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;


/**
 *
 * @author Jimmy
 */
@Stateless
public class UserMgrBean implements UserMgr {
    
    @PersistenceContext(unitName="LedgerAppPU")
    EntityManager em;

    @Override
    public User create(User user) {
    
        em.persist(user);
        return user;
    }

    
    @Override
    public User read(int id) {

        User foundUser = null;
        foundUser = em.find(User.class, id);
        return foundUser;
        
    }

    @Override
    public User update(String oldUsername, String newUsername) {
        
        User user = null;
        em.createQuery("UPDATE User u SET u.username = :newUsername WHERE u.username = :oldUsername").setParameter("newUsername", newUsername).setParameter("oldUsername", oldUsername).executeUpdate();
        return user = (User) em.createQuery("SELECT u from User u where u.username = :newUsername").setParameter("newUsername", newUsername).getSingleResult();
    }

    @Override
    public void delete(String username) {
        
        em.createQuery("DELETE FROM User u WHERE u.username = :username").setParameter("username", username).executeUpdate();
    }
}

    

