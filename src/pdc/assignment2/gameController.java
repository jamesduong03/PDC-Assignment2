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
public class gameController implements ActionListener{
    
    // Instance variables
    private mainMenu mainmenu;
    private mainActions actions;
    private GameFrame gameFrame = new GameFrame();
    
    // Constructor
    public gameController(mainMenu mainmenu, mainActions actions, GameFrame gameFrame) {
        this.mainmenu = mainmenu;
        this.actions = actions;
        this.gameFrame = gameFrame;

        mainmenu.eatAction(this);
        mainmenu.drinkAction(this);
        mainmenu.playAction(this);
        mainmenu.sleepAction(this);
        mainmenu.quitAction(this);
    }

    // Method to get user input from main game frame
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        
        switch(input) {
            case "Eat":
                actions.eat();
                break;
                
            case "Drink":
                actions.drink();
                break;
                
            case "Play":
                actions.play();
                break;
                
            case "Sleep":
                actions.sleep();
                break;
            
            case "Quit and Save":
                actions.quitAndSave();
                System.exit(0);
                break;
        }
    }  
}
