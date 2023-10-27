/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author jamesduong
 */
public class startMenu {
    
    private int screenWidth = 600;
    private int screenHeight = 600;
    private int frameWidth = screenWidth;
    private int frameHeight = screenHeight;
    
    private JFrame startMenuFrame;
    private JPanel startMenuPanel;
    
    private JButton newGame = new JButton("New Game");
    private JButton savedGame = new JButton("Load Saved Game");
    private JButton quit = new JButton("Quit");
    
    public startMenu() {
        startMenuFrame = new JFrame("Pet Game");
        startMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        startMenuFrame.setSize(frameWidth, frameHeight);
        startMenuFrame.setLocationRelativeTo(null);
    }
    
    public void menu() {
        
        startMenuPanel = new JPanel();
        
        startMenuPanel.setLayout(new BoxLayout(startMenuPanel, BoxLayout.Y_AXIS));
        
        startMenuPanel.add(Box.createHorizontalGlue());
        startMenuPanel.add(Box.createHorizontalStrut(frameWidth / 4));
        startMenuPanel.add(Box.createVerticalGlue());
        startMenuPanel.add(newGame);
        startMenuPanel.add(Box.createVerticalStrut(10));
        startMenuPanel.add(savedGame);
        startMenuPanel.add(Box.createVerticalStrut(10));
        startMenuPanel.add(quit);
        startMenuPanel.add(Box.createVerticalGlue());
        startMenuPanel.add(Box.createHorizontalStrut(frameWidth / 4));
        startMenuPanel.add(Box.createHorizontalGlue());
    }
    
    public void display() {
        menu();
        startMenuFrame.add(startMenuPanel);
        startMenuFrame.setVisible(true);
    }
    
    public void dispose() {
        startMenuFrame.dispose();
    }
    
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
