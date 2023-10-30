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
    
    private newPetMenu menu;
    private Player player;
    private Pet pet;
    private Database db = new Database();
    
    public newPetActions(newPetMenu menu) {
        this.menu = menu;
    }
    
    public boolean checkPlayerName() {
        return menu.getName().isEmpty();
    }
    
    public boolean checkPetName() {
        return menu.getPetName().isEmpty();
    }
    
    public void newPlayer() {
        player = new Player(menu.getName());
        pet = new Pet(menu.getName(), menu.getPetSelected());
        db.newPlayer(menu.getName(), menu.getPetName(), pet.getAnimal());
    }
    
    public boolean checkPlayerDB() {
        return db.findPlayer(menu.getName());
    }
}
