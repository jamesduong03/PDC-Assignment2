/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pdc.assignment2;

/**
 *
 * @author jamesduong
 */
public class Pet {
    
    // Variables
    private String name;
    private String animal;
    
    // Constructor
    public Pet(String name, String animal) {
        this.name = name;
        this.animal = animal;
    }

    // Get the name of the pet
    public String getName() {
        return name;
    }

    // Get the type of animal the pet is
    public String getAnimal() {
        return animal;
    }

    // Set the name of the pet
    public void setName(String name) {
        this.name = name;
    }

    // Set the type of animal the pet is
    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
