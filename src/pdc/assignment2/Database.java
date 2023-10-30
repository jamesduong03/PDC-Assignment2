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
public final class Database {

    // Database connection properties
    private static final String USER_NAME = "petgame";
    private static final String PASSWORD = "petgame123";
    private static final String URL = "jdbc:derby://localhost:1527/PetGameDB;create=true";
    
    // Database connection and statement objects
    private Connection conn;
    private Statement statement;

    // Constructor 
    public Database() {
        establishConnection(); // Establish a database connection
        initializeStatement(); // Initialize the database statement
    }

    // Method initialize the database statement
    public void initializeStatement() {
        try {
            if (conn != null) {
                statement = conn.createStatement();
            } else {
                System.err.println("Connection is null. Statement initialization failed.");
            }
        } catch (SQLException ex) {

            System.err.println("SQLException13: " + ex.getMessage());
        }
    }

    // Get the database connection
    public Connection getConnection() {
        return this.conn;
    }

    // Create the "SAVEDGAMES" table if it doesn't exist
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

    // Establish a database connection
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

    // Close the database connection
    public void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.err.println("SQLException3: " + ex.getMessage());
            }
        }
    }

    // Insert a new player into the database
    public void newPlayer(String pname, String name, String animal) {
        try {
            this.statement.executeUpdate("INSERT INTO SAVEDGAMES (PLAYER_NAME, PET_NAME, PET_ANIMAL) VALUES ('" + pname + "', '" + name + "', '" + animal + "')");
        } catch (SQLException ex) {
            System.err.println("SQLException4: " + ex.getMessage());
        }
    }

    // Check if a player with the given name exists in the database
    public boolean findPlayer(String name) {
        boolean found = false;
        
        try{
            ResultSet rs = this.statement.executeQuery("SELECT PLAYER_NAME FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "'");
            if (rs.next()) {
                found = true;
            } else {
                System.out.println("Cannot find Player");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException6: " + ex.getMessage());
        }
        return found;
    }

    // Check if a pet with the given name exists in the database
    public boolean findPet(String name) {
        boolean found = false;

        try {
            ResultSet rs = this.statement.executeQuery("SELECT PET_NAME FROM SAVEDGAMES WHERE PET_NAME = '" + name + "'");
            if (rs.next()) {
                found = true;
            } else {
                System.out.println("Cannot find pet");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException7: " + ex.getMessage());
        }
        return found;
    }

    // Save game data for a player and their pet
    public void saveGame(String name, String petname, String animal, int hunger, int hydration, int happiness, int energy) {
        try {
            this.statement.executeUpdate("UPDATE SAVEDGAMES SET HUNGER = " + hunger + ", HYDRATION = " + hydration
                    + ", HAPPINESS = " + happiness + ", ENERGY = " + energy
                    + " WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "' AND PET_ANIMAL = '" + animal + "'");
        } catch (SQLException ex) {
            System.err.println("SQLException8: " + ex.getMessage());
        }
    }

    // Retrieve the hunger level for a player and their pet
    public int getHunger(String name, String petname) {
        int hunger = 0;
        try {
            ResultSet rs = this.statement.executeQuery("SELECT HUNGER FROM SAVEDGAMES WHERE PLAYER_NAME = '" + name + "' AND PET_NAME = '" + petname + "'");
            if (rs.next()) {
                hunger = rs.getInt(1);
            }
        } catch (SQLException ex) {
            System.err.println("SQLException9: " + ex.getMessage());
        }
        return hunger;
    }

    // Retrieve the hydration level for a player and their pet
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

    // Retrieve the happiness level for a player and their pet
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

    // Retrieve the energy level for a player and their pet
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

