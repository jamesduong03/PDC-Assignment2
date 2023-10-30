/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

/**
 *
 * @author jamesduong
 */
public class Controller implements ActionListener{
    
    // Instance variables
    private startMenu startmenu;
    private newPetMenu petMenu;
    private newPetActions petAction;
    private GameFrame gameFrame = new GameFrame();
    
    // Constructor 
    public Controller(startMenu startmenu, GameFrame gameFrame) {
        this.startmenu = startmenu;
        this.gameFrame = gameFrame;
        
        startmenu.newGameAction(this);
        startmenu.savedGameAction(this);
        startmenu.quitAction(this);
    }
    
    // Constructor 
    public Controller(newPetMenu petMenu, newPetActions petAction, GameFrame gameFrame) {
        this.petMenu = petMenu;
        this.petAction = petAction;
        this.gameFrame = gameFrame;

        petMenu.enterAction(this);
        petMenu.loadAction(this);
    }
    
    // Method to get Player input from Start menu and New Pet Menu
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        
        switch(input) {
            case "New Game":
                startmenu.dispose();
                gameFrame.startNewPetFrame();
                break;
                
            case "Load Saved Game":
                startmenu.dispose();
                gameFrame.startSaveFrame();
                break;
                
            case "Quit":
                System.exit(0);
                break;
                
            case "Enter":
                // Check if the player name and pet name are not null
                if(!petAction.checkPlayerName() && !petAction.checkPetName()) {
                    if (petAction.checkPlayerDB()) {
                        JOptionPane.showMessageDialog(null, "Name already exist. Please choose another name.");
                    } else {
                        petAction.newPlayer();
                        petMenu.dispose();
                        gameFrame.startMainMenu();
                    }
                }
                break;
                
            case "Load Game":
                // Check if the player exists in the database
                if (petAction.checkPlayerDB() == false) {
                        JOptionPane.showMessageDialog(null, "Name does not exist. Please try another name.");
                } else {
                    petMenu.dispose();
                    gameFrame.startMainMenu();
                }
                break;
        }
    }
}
