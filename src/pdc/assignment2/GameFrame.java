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
    
    // Instance variables
    private startMenu menu = new startMenu();
    private newPetMenu petMenu = new newPetMenu();
    private newPetActions petAction = new newPetActions(petMenu);
    private mainMenu mainMenu = new mainMenu();
    
    // Start the start game frame
    public void startFrame() {
        Controller controller = new Controller(menu, this);
        menu.display();
    }
    
    // Start the new pet creation frame
    public void startNewPetFrame() {
        Controller controller = new Controller(petMenu, petAction, this);
        petMenu.display();
    }
    
    // Start the frame for getting saved game
    public void startSaveFrame() {
        Controller controller = new Controller(petMenu, petAction, this);
        petMenu.displaySave();
    }
    
    // Start the main menu frame
    public void startMainMenu() {
        Player player = new Player(petMenu.getName());
        Pet pet = new Pet(petMenu.getPetName(), petMenu.getPetSelected());
        mainActions actions = new mainActions(mainMenu.getStats(), player, pet);
        actions.getSavedGame();
        gameController gamecontroller = new gameController(mainMenu, actions, this);
        mainMenu.display();
    }
    
    // Getter for the newPetMenu
    public newPetMenu getNewPetMenu() {
        return this.petMenu;
    }
    
    // Getter for the newPetActions
    public newPetActions getPetActions() {
        return this.petAction;
    }
}
