/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.business.user;

import com.ledgerapp.domain.Transaction;
import com.ledgerapp.domain.User;
import com.ledgerapp.service.exceptions.UserNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.ManagedBean;
import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transactional;
import javax.transaction.UserTransaction;


/**
 *
 * @author Jimmy
 */
@ManagedBean
public class UserMgrBean implements UserMgr {
    
    @PersistenceContext
    @PersistenceUnit
    EntityManagerFactory emf;
    EntityManager em;
    @Resource
    UserTransaction utx;

    @Override
    public User create(User user) {
        
        //Create an entityManager from the EntityManagerFactory
        em = emf.createEntityManager();
        
        try
        {
            utx.begin();
            em.joinTransaction();
            em.persist(user);   //persist the user
            em.flush();
            utx.commit();
        }
        catch (Exception e) 
        {
            Logger.getLogger(UserMgrBean.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
            
            try
            {
                utx.rollback();  //attempt to roll back transaction in case of error
            }
            catch (IllegalStateException ex)
            {
                Logger.getLogger(UserMgrBean.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            catch (SecurityException ex)
            {
                Logger.getLogger(UserMgrBean.class.getName()).log(Level.SEVERE, null, ex);
                ex.printStackTrace();
            }
            catch (SystemException ex)
            {
                Logger.getLogger(UserMgrBean.class.getName()).log(Level.SEVERE, null, e);
                ex.printStackTrace();
            }
        }
        
        return user;
        
    }

    
    @Override
    public User read(String username) {

        User foundUser = null;
        
        em = emf.createEntityManager();
        Query q = em.createQuery("SELECT u FROM User u WHERE u.username = :username");
        foundUser = (User) q.setParameter("username", username).getSingleResult();
    
        return foundUser;
        
    }

    @Override
    public User update(String username, String _username) {
        
        em = emf.createEntityManager();
        Query q = em.createQuery("Update User u Set u.username = :_username WHERE u.username = :username");
        q.setParameter("username", username).setParameter("_username", _username);
        
            try 
            {
                utx.begin();
                em.joinTransaction();
                q.executeUpdate();
                em.flush();
                utx.commit();
            } 
            catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) 
            {
                Logger.getLogger(UserMgrBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        User updatedUser = null;
        Query q1 = em.createQuery("SELECT u FROM User u WHERE u.username = :_username");
        updatedUser = (User) q1.setParameter("_username", _username).getSingleResult();
        
        return updatedUser;
   
    }

    @Override
    public void delete(String username) {
        
        em = emf.createEntityManager();
        Query q = em.createQuery("DELETE FROM User u WHERE u.username = :username ");
        q.setParameter("username", username);
      
            try 
            {
                utx.begin();
                em.joinTransaction();
                q.executeUpdate();
                em.flush();
                utx.commit();
            } 
            catch (NotSupportedException | SystemException | RollbackException | HeuristicMixedException | HeuristicRollbackException | SecurityException | IllegalStateException ex) 
            {
                Logger.getLogger(UserMgrBean.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }

    

