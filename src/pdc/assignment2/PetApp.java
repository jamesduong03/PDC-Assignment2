/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pdc.assignment2;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jamesduong
 */
public class PetApp {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Database table = new Database();
        table.createPetGameTable();
        GameFrame newGame = new GameFrame();
        newGame.startFrame();
        table.closeConnection();
    }
    
}
