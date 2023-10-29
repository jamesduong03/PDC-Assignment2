/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jamesduong
 */
public class Database {
    
    private static final String USER_NAME = "petgame";
    private static final String PASSWOPD = "petgame123";
    private static final String URL = "jdbc:derby://localhost:1527/PetGameDB;create=true";
    private Connection conn;
    private Statement statement;

    public Database() {
        establishConnection();
    }
    
    public Connection getConnection() {
        return this.conn;
    }

    public void createPetGameTable() {
        try {
            this.statement = conn.createStatement();
            this.statement.addBatch("CREATE TABLE SAVEDGAMES(PLAYER_NAME VARCHAR(20), PET_NAME VARCHAR(20)"
                    + "HUNGER INT, HYDRATION INT, HAPPINESS INT, ENERGY INT)"
                    + "CONSTRAINT PLAYER_NAME_PK PRIMARY KEY(PLAYER_NAME))");
            this.statement.addBatch("INSET INTO SAVEDGAMES VALUES ('James, Max, 6, 6, 7, 5");
            this.statement.executeBatch();
        } catch(SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
    
    public void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWOPD);
                System.out.println(URL + " is connected...");
            } catch(SQLException ex) {
                System.err.println("SQLException: " + ex.getMessage());
            }
        }
    }
    
    public void closeConnection() {
        if(conn != null) {
            try{
                conn.close();
            } catch(SQLException ex) {
                System.err.println("SQLException: " + ex.getMessage());
            }
        }
    }
}

