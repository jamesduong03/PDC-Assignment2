/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jamesduong
 */
public class Controller implements ActionListener{
    
    private startMenu startmenu;
    private newPetMenu petMenu;
    private newPetActions petAction;
    private mainMenu mainmenu;
    private mainActions actions;
    private GameFrame gameFrame = new GameFrame();
    
    public Controller(startMenu startmenu, GameFrame gameFrame) {
        this.startmenu = startmenu;
        this.gameFrame = gameFrame;
        
        startmenu.newGameAction(this);
        startmenu.savedGameAction(this);
        startmenu.quitAction(this);
    }
    
    public Controller(newPetMenu petMenu, newPetActions petAction, GameFrame gameFrame) {
        this.petMenu = petMenu;
        this.petAction = petAction;
        this.gameFrame = gameFrame;

        petMenu.enterAction(this);
    }
    
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
                break;
                
            case "Quit":
                System.exit(0);
                break;
                
            case "Enter":
                if(!petAction.checkPlayerName() && !petAction.checkPetName()) {
                    petMenu.dispose();
                    gameFrame.startMainMenu();
                }
                break;
        }
    }
}
