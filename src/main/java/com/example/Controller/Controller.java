package com.example.Controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import com.example.Model.Person;
import com.example.Model.PersonSentence;
import com.example.View.MenuFauna;
import com.formdev.flatlaf.FlatLightLaf;

/**
 * Controller class for the Fauna menu.
 * 
 * @author Ruymán Crespo Díaz
 * @author Silvia Oliva Rodríguez
 * @author José Ramón Navarro González
 * @version 1.0
 */
public class Controller implements ActionListener {

    // PRIVATE VARIABLES
    private MenuFauna viewFauna;
    private Person person;
    private PersonSentence model;

    /**
     * Constructor of the class Controller with the parameters of the view and the
     * model of the application and adds action listeners to the buttons of the
     * view.
     * 
     * @param view   - The view of the application.
     * @param person - The model of the application data.
     * @param model  - The model of the application.
     */
    public Controller(MenuFauna view, Person person, PersonSentence model) {

        this.viewFauna = view;
        this.person = person;
        this.model = model;

        view.buttonInsert.addActionListener(this);
        view.buttonUpdate.addActionListener(this);
        view.buttonDelete.addActionListener(this);
        view.buttonSearch.addActionListener(this);
        view.comboBox.addActionListener(this);
    }

    /**
     * Method that initializes the view of the application.
     */
    public void start() {
        reloadDropdown();
        clearBoxs();

        // The look and feel of the application is set to the Flat Light Laf.
        FlatLightLaf.setup();

        viewFauna.setTitle("FaunaDB");
        viewFauna.setLocationRelativeTo(null);
        viewFauna.setResizable(false);
        viewFauna.setVisible(true);

    }

    /**
     * Method that executes the actions of the buttons of the view.
     * 
     * @param e - Pressed button
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        /**
         * INSERT
         * If the button Insert is pressed, checks if the fields
         * are empty and if they are not, inserts the data in the database.
         */
        if (e.getSource() == viewFauna.buttonInsert) {
            if (viewFauna.boxName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The name is required.");
                return;
            } else if (viewFauna.boxLastName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The last name is required.");
                return;
            } else if (viewFauna.boxAge.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The age is required.");
                return;
            }
            
            person.setName(viewFauna.boxName.getText());
            person.setLastName(viewFauna.boxLastName.getText());
            person.setAge(Integer.parseInt(viewFauna.boxAge.getText()));

            if (model.insert(person)) {
                JOptionPane.showMessageDialog(null, "Client inserted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Error inserting client");
            }

            reloadDropdown();
            clearBoxs();
        }

        /**
         * UPDATE
         * If the button Update is pressed, checks if the fields
         * are empty and if they are not, updates the person in the database.
         */
        if (e.getSource() == viewFauna.buttonUpdate) {
            try {

                if (viewFauna.boxName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "The name is required.");
                    return;
                } else if (viewFauna.boxLastName.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "The last name is required.");
                    return;
                } else if (viewFauna.boxAge.getText().equals("")) {
                    JOptionPane.showMessageDialog(null, "The age is required.");
                    return;
                }

                person.setName(viewFauna.boxName.getText());
                person.setLastName(viewFauna.boxLastName.getText());
                person.setAge(Integer.parseInt(viewFauna.boxAge.getText()));

                if (model.update(person)) {
                    JOptionPane.showMessageDialog(null, "Client updated successfully");
                } else {
                    JOptionPane.showMessageDialog(null, "Error updating client");
                }

                reloadDropdown();
                clearBoxs();
            } catch (NumberFormatException error) {
                JOptionPane.showMessageDialog(null, "Only numbers are allowed on age");
            }
        }

        /**
         * SEARCH
         * If the button Search is pressed, checks if the field name
         * is empty and if it is not, searches the person in the database.
         */
        if (e.getSource() == viewFauna.buttonSearch) {
            if (viewFauna.boxName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The name is required.");
                return;
            }
            person.setName(viewFauna.boxName.getText());

            Person persona = model.search(viewFauna.boxName.getText());

            if (persona != null) {
                viewFauna.boxLastName.setText(persona.getLastName());
                viewFauna.boxAge.setText(String.valueOf(persona.getAge()));
            } else {
                JOptionPane.showMessageDialog(null,
                        "The client " + viewFauna.boxName.getText() + " does not exist");
                reloadDropdown();
                clearBoxs();
            }
        }

        /**
         * DELETE
         * If the button Delete is pressed, checks if the field name
         * is empty and if it is not, deletes the person in the database.
         */
        if (e.getSource() == viewFauna.buttonDelete) {
            if (viewFauna.boxName.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "The name is required.");
                return;
            }

            person.setName(viewFauna.boxName.getText());

            if (model.delete(person)) {
                JOptionPane.showMessageDialog(null, "Client deleted successfully");
            } else {
                JOptionPane.showMessageDialog(null, "Error deleting client");
            }

            reloadDropdown();
            clearBoxs();
        }

        /**
         * COMBOBOX
         * If the ComboBox is changed, the name of the person is taken from the
         * ComboBox.
         */
        if (e.getSource() == viewFauna.comboBox) {
            if (viewFauna.comboBox.getSelectedItem() != null) {
                person.setName(viewFauna.comboBox.getSelectedItem().toString());
                viewFauna.boxName.setText(person.getName().trim());
            }
        }

    }

    /**
     * Method that cleans the text fields of the view.
     */
    public void clearBoxs() {
        viewFauna.boxName.setText(null);
        viewFauna.boxLastName.setText(null);
        viewFauna.boxAge.setText(null);
    }

    /**
     * @return MenuFauna return the viewFauna
     */
    public MenuFauna getViewFauna() {
        return viewFauna;
    }

    /**
     * @param viewFauna the viewFauna to set
     */
    public void setViewFauna(MenuFauna viewFauna) {
        this.viewFauna = viewFauna;
    }

    /**
     * @return Person return the person
     */
    public Person getPerson() {
        return person;
    }

    /**
     * @param person the person to set
     */
    public void setPerson(Person person) {
        this.person = person;
    }

    /**
     * @return PersonSentence return the model
     */
    public PersonSentence getModel() {
        return model;
    }

    /**
     * @param model the model to set
     */
    public void setModel(PersonSentence model) {
        this.model = model;
    }

    /**
     * Method that reloads the dropdown of the view.
     */
    public void reloadDropdown() {
        Person[] personList = model.getAll();
        viewFauna.comboBox.removeAllItems();

        for (Person person : personList) {
            viewFauna.comboBox.addItem(person.getName());
        }
    }

}
