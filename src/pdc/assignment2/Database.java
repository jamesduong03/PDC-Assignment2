/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

/**
 *
 * @author jamesduong
 */
public class Database {
    
    private static final String USER_NAME = "petgame";
    private static final String PASSWORD = "petgame123";
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
            ResultSet rs = conn.getMetaData().getTables(null, null, "SAVEDGAMES", null);

            if (!rs.next()) {
                this.statement.addBatch("CREATE TABLE SAVEDGAMES(PLAYER_NAME VARCHAR(20), PET_NAME VARCHAR(20), PET_ANIMAL VARCHAR(10),"
                    + "HUNGER INT, HYDRATION INT, HAPPINESS INT, ENERGY INT)");
                this.statement.executeBatch();
            } else {
                System.out.println("SAVEDGAMES table already exists.");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
            System.err.println(ex.getNextException());
        }
    }
    
    public void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " is connected...");
            } catch (SQLException ex) {
                System.err.println("SQLException2: " + ex.getMessage());
            }
        }
    }
    
    public void closeConnection() {
        if(conn != null) {
            try{
                conn.close();
            } catch(SQLException ex) {
                System.err.println("SQLException3: " + ex.getMessage());
            }
        }
    }
    
    public void newPlayer(String pname, String name, String animal) {     
        try{
            this.statement.executeUpdate("INSERT INTO SAVEDGAMES (PLAYER_NAME, PET_NAME, PET_ANIMAL) VALUES ('" + pname + "', '" + name + "', '" + animal + "')");
        } catch (SQLException ex) {
            System.err.println("SQLException4: " + ex.getMessage());
        }
    }
    
    public boolean findPlayer(String name) {
        boolean found = false;
        
        try{
            ResultSet rs = this.statement.executeQuery("SELECT PLAYER_NAME FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "'");
            if(rs.next()){
                found = true;
            } else {
                System.out.println("Cannot find Player");
            }
        }catch(SQLException ex) {
            System.err.println("SQLException6: " + ex.getMessage());
        }
        return found;
    }
    
    public boolean findPet(String name) {
        boolean found = false;

        try {
            ResultSet rs = this.statement.executeQuery("SELECT PET_NAME FROM SAVEDGAMES WHERE PET_NAME = '" + name + "'");
            if(rs.next()) {
                found = true;
            } else {
                System.out.println("Cannot find pet");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException7: " + ex.getMessage());
        }
        return found;
    }
    
    public void saveGame(String name, String petname, String animal,  int hunger, int hydration, int happiness, int energy) {
        try{
            this.statement.executeUpdate("UPDATE SAVEDGAMES SET HUNGER = " + hunger + ", HYDRATION = " + hydration
            + ", HAPPINESS = " + happiness + ", ENERGY = " + energy 
            + " WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "' AND PET_ANIMAL = '" + animal + "'");
        }catch(SQLException ex) {
            System.err.println("SQLException8: " + ex.getMessage());
        }
    }
    
    public int getHunger(String name, String petname) {
        int hunger = 0;
        try{
            ResultSet rs = this.statement.executeQuery("SELECT HUNGER FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "'");
            if(rs.next()) {
                hunger = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("SQLException9: " + ex.getMessage());
        }
        return hunger;
    }
    
    public int getHydration(String name, String petname) {
        int hydration = 0;
        try {
            ResultSet rs = this.statement.executeQuery("SELECT HYDRATION FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "'");
            if (rs.next()) {
                hydration = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("SQLException10: " + ex.getMessage());
        }
        return hydration;
    }
    
    public int getHappiness(String name, String petname) {
        int happiness = 0;
        try {
            ResultSet rs = this.statement.executeQuery("SELECT HAPPINESS FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "'");
            if (rs.next()) {
                happiness = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("SQLException11: " + ex.getMessage());
        }
        return happiness;
    }
    
    public int getEnergy(String name, String petname) {
        int energy = 0;
        try {
            ResultSet rs = this.statement.executeQuery("SELECT ENERGY FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "'");
            if (rs.next()) {
                energy = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("SQLException12: " + ex.getMessage());
        }
        return energy;
    }
}

