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
    private GameFrame gameFrame = new GameFrame();
    
    public Controller(startMenu startmenu, GameFrame gameFrame) {
        this.startmenu = startmenu;
        this.gameFrame = gameFrame;
        
        startmenu.newGameAction(this);
        startmenu.savedGameAction(this);
        startmenu.quitAction(this);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String input = e.getActionCommand();
        
        switch(input) {
            case "New Game":
                startmenu.dispose();
                break;
                
            case "Load Saved Game":
                startmenu.dispose();
                break;
                
            case "Quit":
                System.exit(0);
                break;
        }
    }
}
