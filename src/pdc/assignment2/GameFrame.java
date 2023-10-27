/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

/**
 *
 * @author jamesduong
 */
public class GameFrame {
    
    private startMenu menu = new startMenu();
    
    public void startFrame() {
        Controller controller = new Controller(menu, this);
        menu.display();
    }

    public startMenu getstartMenu() {
        return this.menu;
    }
    
    
}
