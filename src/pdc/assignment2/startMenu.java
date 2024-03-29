/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author jamesduong
 */
public class startMenu {
    
    // variables
    private int Width = 500;
    private int Height = 500;
    
    private JFrame startMenuFrame;
    private JPanel startMenuPanel;
    
    private JLabel title = new JLabel("PET GAME!");
    private JButton newGame = new JButton("New Game");
    private JButton savedGame = new JButton("Load Saved Game");
    private JButton quit = new JButton("Quit");
    
    // Constructor
    public startMenu() {
        startMenuFrame = new JFrame("Pet Game");
        startMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startMenuFrame.setSize(Width, Height);
        startMenuFrame.setLocationRelativeTo(null);
    }
    
    // Add components and configure the layout for the start menu
    public void menu() {
        
        startMenuPanel = new JPanel();
        
        startMenuPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(30, 10, 10, 10);
        startMenuPanel.add(title, gbc);
        title.setFont(new Font("Ariel", Font.PLAIN, 30));

        gbc.gridy = 1;
        startMenuPanel.add(newGame, gbc);

        gbc.gridy = 2;
        startMenuPanel.add(savedGame, gbc);

        gbc.gridy = 3;
        startMenuPanel.add(quit, gbc);
    }
    
    // Display the start menu
    public void display() {
        menu();
        startMenuFrame.add(startMenuPanel);
        startMenuFrame.setVisible(true);
    }
    
    // Close and dispose of the start menu
    public void dispose() {
        startMenuFrame.dispose();
    }
    
    // Set ActionListener for the buttons
    public void newGameAction(ActionListener action) {
        newGame.addActionListener(action);
    }
    
    public void savedGameAction(ActionListener action) {
        savedGame.addActionListener(action);
    }
    
    public void quitAction(ActionListener action) {
        quit.addActionListener(action);
    }
}
