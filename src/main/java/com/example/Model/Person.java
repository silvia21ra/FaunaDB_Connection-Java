package com.example.Model;

/**
 * Class that contains the name, last name and age of a person
 * 
 * @author Ruymán Crespo Díaz
 * @author Silvia Oliva Rodríguez
 * @author José Ramón Navarro González
 * @version 1.0
 */
public class Person {

    // - - - PRIVATE FIELDS - - -
    private String name;
    private String lastName;
    private int age;

    /**
     * Constructor of the class Person
     * 
     * @param name     - The name of the person.
     * @param lastName - The last name of the person.
     * @param age      - The age of the person.
     */
    public Person(String name, String lastName, int age) {
        this.name = name;
        this.lastName = lastName;
        this.age = age;
    }

    /**
     * Getter of the name of the person.
     * 
     * @return - The name of the person.
     */
    public String getName() {
        return name;
    }

    /**
     * Setter of the name of the person.
     * 
     * @param name - The name of the person.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Getter of the last name of the person.
     * 
     * @return - The last name of the person.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Setter of the last name of the person.
     * 
     * @param lastName - The last name of the person.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Getter of the age of the person.
     * 
     * @return - The age of the person.
     */
    public int getAge() {
        return age;
    }

    /**
     * Setter of the age of the person.
     * 
     * @param age - The age of the person.
     */
    public void setAge(int age) {
        this.age = age;
    }

}
