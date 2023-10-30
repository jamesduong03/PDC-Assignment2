/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package pdc.assignment2;

import java.awt.event.ActionListener;
import javax.swing.JTextField;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jamesduong
 */
public class newPetMenuTest {
    
    private newPetMenu menu;
    
    public newPetMenuTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        menu = new newPetMenu();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getPetSelected method, of class newPetMenu.
     */
    @Test
    public void testGetPetSelected() {
        String petSelected = menu.getPetSelected();
        petSelected = "Dog";
        assertEquals("Dog", petSelected);
    }

    /**
     * Test of getName method, of class newPetMenu.
     */
    @Test
    public void testGetName() {
        String name = menu.getName();
        name = "James";
        assertEquals("James", name);
    }

    /**
     * Test of getPetName method, of class newPetMenu.
     */
    @Test
    public void testGetPetName() {
        String petName = menu.getPetName();
        petName = "Max";
        assertEquals("Max", petName);
    }
    
}
