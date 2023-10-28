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
    }
    
    public void setStats() {  
        stats.getHunger().setValue(hunger);
        stats.getHydration().setValue(hydration);
        stats.getHappiness().setValue(happiness);
        stats.getEnergy().setValue(energy);
    }
    
    public void eat() {
        hunger += 2;
        hydration += 0;
        this.energy += 0;
        happiness -= 2;
        setStats();
    }
    
    public void drink() {
        hydration += 4;
        hunger += 0;
        energy += 0;
        happiness -= 2;
        setStats();
    }
    
    public void play() {
        hunger -= 3;
        hydration -= 3;
        energy -= 4;
        happiness += 4;
        setStats();
    }
    
    public void sleep() {
        energy += 5;
        hunger -= 2;
        hydration -= 2;
        happiness -= 2;
        setStats();
    }
}
