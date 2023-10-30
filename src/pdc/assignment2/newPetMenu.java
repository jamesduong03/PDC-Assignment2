/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 *
 * @author jamesduong
 */
public class newPetMenu {
    
    // Variables
    private int Width = 500;
    private int Height = 500;
    
    private JFrame newPetFrame = new JFrame("Pet Game");
    private JPanel newPetPanel = new JPanel();
    
    private JLabel nametext = new JLabel("Please enter your name: ");
    private JTextField nameInput = new JTextField(25);
    
    private JLabel petText = new JLabel(" Please choose a new pet: ");
    private JRadioButton newDog = new JRadioButton("Dog");
    private JRadioButton newCat = new JRadioButton("Cat");
    private ButtonGroup pickPet = new ButtonGroup();
    private JLabel petName = new JLabel("Please name your new pet: ");
    private JTextField petNameInput = new JTextField(25);
    
    private JButton enter = new JButton("Enter");
    private JButton load = new JButton("Load Game");
    
    // Constructor
    public newPetMenu() {
        
        newPetFrame = new JFrame("Pet Game");
        newPetFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        newPetFrame.setSize(Width, Height);
        newPetFrame.setLocationRelativeTo(null);
    }
    
    // Add components for creating a new pet
    public void menuOptions() {
        
        newPetPanel.add(nametext);
        newPetPanel.add(nameInput);
        
        pickPet.add(newDog);
        pickPet.add(newCat);
        
        newPetPanel.add(petText);
        newPetPanel.add(newDog);
        newPetPanel.add(newCat);
        
        newPetPanel.add(petName);
        newPetPanel.add(enter);  
    }
    
    // Add components for loading a saved game
    public void saveMenu() {
        newPetPanel.add(nametext);
        newPetPanel.add(nameInput);
        newPetPanel.add(load); 
    }
    
    // Add components and configure the layout for the new pet menu
    public void menu() {
        newPetPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        newPetPanel.add(nametext, gbc);

        gbc.gridy = 1;
        newPetPanel.add(nameInput, gbc);

        gbc.gridy = 2;
        newPetPanel.add(petText, gbc);

        gbc.gridy = 3;
        pickPet.add(newDog);
        newPetPanel.add(newDog, gbc);
        
        gbc.gridy = 4;
        pickPet.add(newCat);
        newPetPanel.add(newCat, gbc);

        gbc.gridy = 5;
        newPetPanel.add(petName, gbc);

        gbc.gridy = 6;
        newPetPanel.add(petNameInput, gbc);

        gbc.gridy = 7;
        newPetPanel.add(enter, gbc);  
    }
    
    // Display the new pet menu
    public void display() {
        menu();
        newPetFrame.add(newPetPanel);
        newPetFrame.setVisible(true);
    }
    
    // Display the menu for saved game
    public void displaySave() {
        saveMenu();
        newPetFrame.add(newPetPanel);
        newPetFrame.setVisible(true);
    }
    
    // Close and dispose of the new pet menu
    public void dispose() {
        newPetFrame.dispose();
    }
    
    // Set ActionListener for buttons
    public void enterAction(ActionListener action) {
        enter.addActionListener(action);
    }
    
    public void loadAction(ActionListener action) {
        load.addActionListener(action);
    }
    
    // Get the selected pet type (Dog or Cat)
    public String getPetSelected() {
        String petSelected = "";
        
        if (newDog.isSelected())
            petSelected = "Dog";
        else if (newCat.isSelected())
            petSelected = "Cat";
        return petSelected;
    }
    
    // Get the entered player name
    public String getName() {
        return this.nameInput.getText();
    }
    
    // Get the entered pet name
    public String getPetName() {
        return this.petNameInput.getText();
    }
}
