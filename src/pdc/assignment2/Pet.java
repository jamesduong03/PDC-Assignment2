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
    
    private String name;
    private String animal;
    
    public Pet(String name, String animal) {
        this.name = name;
        this.animal = animal;
    }

    public String getName() {
        return name;
    }

    public String getAnimal() {
        return animal;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
    
    
}
