/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ledgerapp.test.usermgrbeantests;

import com.ledgerapp.business.user.UserMgr;
import com.ledgerapp.domain.User;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Jimmy
 */
@DataSourceDefinition(
    name="java:jdbc/ledgerapp",
    className="com.mysql.jdbc.jdbc2.optional.MysqlDataSource",
    user="root",
    password="password",
    databaseName="ledgerapp",
    serverName="localhost",
    portNumber=3306)
public class UserMgrBeanTest {
    
     static EJBContainer ec;
     static Context ctx;
     static UserMgr manager;
    
    public UserMgrBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        
        ec = EJBContainer.createEJBContainer();
        ctx = ec.getContext();
         try { 
             manager = (UserMgr) ctx.lookup("java:global/classes/UserMgrBean!com.ledgerapp.business.user.UserMgr");
         } catch (NamingException ex) {
             Logger.getLogger(UserMgrBeanTest.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    //retrieves the number of rows from the database.  Used to test insert/delete
    public static int getNumOfRows() {
        
        int rows = 0;
        Connection conn = null;
        Properties connectionProps = new Properties();
        connectionProps.put("user", "root");
        connectionProps.put("password", "password");
        Statement stmt = null;
        String query = "SELECT COUNT(*) from users";
        ResultSet rs = null;
        
         try {
             conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/ledgerapp", connectionProps);
             stmt = (Statement) conn.createStatement();
             rs = stmt.executeQuery(query);
             
             while(rs.next())
             {
                 rows = rs.getInt("count(*)");
             }
   
         } catch (SQLException ex) {
             Logger.getLogger(UserMgrBeanTest.class.getName()).log(Level.SEVERE, null, ex);
         }
         finally
         {
            try {
                conn.close();
            } catch (SQLException ex) {
                Logger.getLogger(UserMgrBeanTest.class.getName()).log(Level.SEVERE, null, ex);
            }
         }
        
        return rows;
    }
    
    @AfterClass
    public static void tearDownClass() {
        
        ec.close();
    }
  
    @Test
    public void readUserTest() {
    
        int id = 1;
        Assert.assertNotNull(manager.read(id)); 
    }
    
    
    @Test
    public void insertUserTest() {
        
        User user = new User();
        user.setUsername("Clark Kent");
        int preInsertRowCount = getNumOfRows();
        manager.create(user);
        int postInsertRowCount = getNumOfRows();
        Assert.assertTrue(preInsertRowCount <  postInsertRowCount);
    }
    
    @Test
    public void updateUserTest() {
        
        String oldUsername = "Clark Kent";
        String newUsername = "Superman";
        User user = null;
        user = manager.update(oldUsername, newUsername);
        Assert.assertTrue(user.getUsername().equals(newUsername));
    }
    
    @Test
    public void deleteUserTest() {
        
        int preDeleteCount = getNumOfRows();
        manager.delete("Superman");
        int postDeleteCount = getNumOfRows();
        Assert.assertTrue(preDeleteCount > postDeleteCount);
    }
}
