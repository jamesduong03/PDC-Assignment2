/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

/**
 *
 * @author jamesduong
 */
public class GameFrame {
    
    private startMenu menu = new startMenu();
    private newPetMenu petMenu = new newPetMenu();
    private newPetActions petAction = new newPetActions(petMenu);
    private mainMenu mainMenu = new mainMenu();
    
    public void startFrame() {
        Controller controller = new Controller(menu, this);
        menu.display();
    }
    
    public void startNewPetFrame() {
        Controller controller = new Controller(petMenu, petAction, this);
        petMenu.display();
    }
    
    public void startMainMenu() {
        mainMenu.display();
    }
}
