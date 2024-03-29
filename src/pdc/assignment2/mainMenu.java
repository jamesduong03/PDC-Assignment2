/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jamesduong
 */
public class mainMenu {
    
    // Variables
    private int Width = 500;
    private int Height = 500;
    private Stats stats = new Stats();
    private JPanel buttons;
    private JPanel Stats;
    private JFrame mainFrame = new JFrame("Pet Game");
    
    private JButton eat = new JButton("Eat");
    private JButton drink = new JButton("Drink");
    private JButton play = new JButton("Play");
    private JButton sleep = new JButton("Sleep");
    private JButton quit = new JButton("Quit and Save");
    
    private JLabel hunger = new JLabel("Hunger: ");
    private JLabel hydration = new JLabel("Hydration: ");
    private JLabel happiness = new JLabel("Happiness: ");
    private JLabel energy = new JLabel("Energy: ");
    
    // Constructor
    public void mainMenu() {
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setSize(Width, Height);
        mainFrame.setLocationRelativeTo(null);
    }
    
    // Add the pet's statistics to the interface
    public void addPetStats() {
        Stats = new JPanel(new GridLayout(2, 2));
        
        Stats.add(hunger);
        Stats.add(stats.getHunger());
        Stats.add(hydration);
        Stats.add(stats.getHydration());
        Stats.add(happiness);
        Stats.add(stats.getHappiness());
        Stats.add(energy);
        Stats.add(stats.getEnergy());
        mainFrame.add(Stats, BorderLayout.NORTH);
    }
    
    // Add action buttons to the interface
    public void addButtons() {
        buttons = new JPanel();

        buttons.add(eat);
        buttons.add(drink);
        buttons.add(play);
        buttons.add(sleep);
        buttons.add(quit);
    }
    
    // Display the main menu interface
    public void display() {
        addButtons();
        addPetStats(); 
        mainFrame.add(buttons);
        mainFrame.setSize(Width, Height);
        mainFrame.setVisible(true); 
        mainFrame.setLocationRelativeTo(null);
    }
    
    // Close and dispose of the main menu

    public void dispose() {
        mainFrame.dispose();
    }
    
    // Getter for the Stats object
    public Stats getStats() {
        return this.stats;
    }
    
    // Set ActionListener for the buttons
    public void eatAction(ActionListener action) {
        eat.addActionListener(action);
    }
    
    public void drinkAction(ActionListener action) {
        drink.addActionListener(action);
    }
    
    public void playAction(ActionListener action) {
        play.addActionListener(action);
    }
    
    public void sleepAction(ActionListener action) {
        sleep.addActionListener(action);
    }
    
    public void quitAction(ActionListener action) {
        quit.addActionListener(action);
    }
}
