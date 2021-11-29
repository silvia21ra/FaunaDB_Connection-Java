package com.example;

import com.example.Controller.Controller;
import com.example.Model.Person;
import com.example.Model.PersonSentence;
import com.example.View.MenuFauna;

/**
 * Main class for the CRUD Fauna application.
 * 
 * @author Ruymán Crespo Díaz
 * @author Silvia Oliva Rodríguez
 * @author José Ramón Navarro González
 * @version 1.0
 */
public class CRUD_Fauna {
    /**
     * Main method of the program.
     * 
     * @param args Arguments of the program.
     */
    public static void main(String[] args) {

        MenuFauna view = new MenuFauna();
        Person person = new Person(null, null, 0);
        PersonSentence model = new PersonSentence();

        Controller controller = new Controller(view, person, model);

        controller.start();
    }
}
