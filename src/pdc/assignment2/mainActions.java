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
    
    private Stats stats;
    private Player player;
    private Pet pet;
    
    private int hunger;
    private int hydration;
    private int happiness;
    private int energy;
    
    public mainActions(Stats stats, Player player, Pet pet) {
        this.stats = stats;
        this.player = player;
        this.pet = pet;
        
        this.hunger = 0;
        this.hydration = 0;
        this.happiness = 0;
        this.energy = 0;
    }
    
    public void setStats() {
        stats.getHunger().setValue(this.hunger);
        stats.getHydration().setValue(this.hydration);
        stats.getHappiness().setValue(this.happiness);
        stats.getEnergy().setValue(this.energy);
    }
    
    public void eat() {
        this.hunger += 3;
        setStats();
    }
    
    public void drink() {
        this.hydration += 4;
        setStats();
    }
    
    public void play() {
        this.hunger -= 3;
        this.hydration -= 3;
        this.energy -= 4;
        this.happiness += 4;
        setStats();
    }
    
    public void sleep() {
        this.energy += 8;
        setStats();
    }
}
