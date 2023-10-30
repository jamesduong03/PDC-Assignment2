/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import javax.swing.JProgressBar;

/**
 *
 * @author jamesduong
 */
public class Stats {
    
    // JProgressBar components for visualizing stats
    private JProgressBar hunger = new JProgressBar(0, 100);
    private JProgressBar hydration = new JProgressBar(0, 100);
    private JProgressBar happiness = new JProgressBar(0, 100);
    private JProgressBar energy = new JProgressBar(0, 100);
    
    // Variables
    private int hungerV;
    private int hydrationV;
    private int happinessV;
    private int energyV;
    
    // Constructor
    public Stats() {
        // Initialize default values
        this.hungerV = 50;
        this.hydrationV = 50;
        this.happinessV = 50;
        this.energyV = 50;
        
        // Set the JProgressBar values to the default values
        this.hunger.setValue(hungerV);
        this.hydration.setValue(hydrationV);
        this.happiness.setValue(happinessV);
        this.energy.setValue(energyV);
        
        // Enable text display on JProgressBar components
        hunger.setStringPainted(true);
        hydration.setStringPainted(true);
        happiness.setStringPainted(true);
        energy.setStringPainted(true);
    }

    // Getters for JProgressBar components
    public JProgressBar getHunger() {
        return hunger;
    }

    public JProgressBar getHydration() {
        return hydration;
    }

    public JProgressBar getHappiness() {
        return happiness;
    }

    public JProgressBar getEnergy() {
        return energy;
    }

    // Getters for the current values of statistics
    public int getHungerV() {
        return hungerV;
    }

    public int getHydrationV() {
        return hydrationV;
    }

    public int getHappinessV() {
        return happinessV;
    }

    public int getEnergyV() {
        return energyV;
    }
}
