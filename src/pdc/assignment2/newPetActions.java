/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

/**
 *
 * @author jamesduong
 */
public class newPetActions {
    
    // Instance variables
    private newPetMenu menu;
    private Player player;
    private Pet pet;
    private Database db = new Database();
    
    // Constructor
    public newPetActions(newPetMenu menu) {
        this.menu = menu;
    }
    
    // Check if the player name input is empty
    public boolean checkPlayerName() {
        return menu.getName().isEmpty();
    }
    
    // Check if the pet name input is empty

    public boolean checkPetName() {
        return menu.getPetName().isEmpty();
    }
    // Create a new player and pet, and store the information in the database
    public void newPlayer() {
        player = new Player(menu.getName());
        pet = new Pet(menu.getName(), menu.getPetSelected());
        db.newPlayer(menu.getName(), menu.getPetName(), pet.getAnimal());
    }
    
    // Check if the player already exists in the database
    public boolean checkPlayerDB() {
        return db.findPlayer(menu.getName());
    }
}
