/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

/**
 *
 * @author jamesduong
 */
public class mainActions {
    
    // Instance variables
    private Stats stats;
    private Player player;
    private Pet pet;
    private Database db = new Database();
    
    // Variables
    private int hunger;
    private int hydration;
    private int happiness;
    private int energy;
    
    // Constructor
    public mainActions(Stats stats, Player player, Pet pet) {
        this.stats = stats;
        this.player = player;
        this.pet = pet;
    }
    
    // Load saved game data from the database
    public void getSavedGame() {
        if(db.findPlayer(this.player.getName())) {
            hunger = db.getHunger(player.getName(), pet.getName());
            hydration = db.getHydration(player.getName(), pet.getName());
            happiness = db.getHappiness(player.getName(), pet.getName());
            energy = db.getEnergy(player.getName(), pet.getName());
        }
        setStats();
    }
    
    // Update the game statistics based on the current values
    public void setStats() {  
        stats.getHunger().setValue(hunger);
        stats.getHydration().setValue(hydration);
        stats.getHappiness().setValue(happiness);
        stats.getEnergy().setValue(energy);
    }
    
    // Eat method
    public void eat() {
        hunger += 20;
        hydration += 0;
        this.energy += 0;
        happiness -= 20;
        setStats();
    }
    
    // drink method
    public void drink() {
        hydration += 40;
        hunger += 0;
        energy += 0;
        happiness -= 20;
        setStats();
    }
    
    // play method
    public void play() {
        hunger -= 30;
        hydration -= 30;
        energy -= 40;
        happiness += 40;
        setStats();
    }
    
    // sleep method
    public void sleep() {
        energy += 50;
        hunger -= 20;
        hydration -= 20;
        happiness -= 20;
        setStats();
    }
    // Quit and Save the game method
    public void quitAndSave() {
        db.saveGame(player.getName(), pet.getName(), pet.getAnimal(), stats.getHungerV(), stats.getHydrationV(), stats.getHappinessV(), stats.getEnergyV());
    }
}
