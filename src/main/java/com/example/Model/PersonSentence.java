package com.example.Model;

import static com.faunadb.client.query.Language.Collection;
import static com.faunadb.client.query.Language.Create;
import static com.faunadb.client.query.Language.Delete;
import static com.faunadb.client.query.Language.Get;
import static com.faunadb.client.query.Language.Index;
import static com.faunadb.client.query.Language.Lambda;
import static com.faunadb.client.query.Language.Map;
import static com.faunadb.client.query.Language.Match;
import static com.faunadb.client.query.Language.Obj;
import static com.faunadb.client.query.Language.Paginate;
import static com.faunadb.client.query.Language.Update;
import static com.faunadb.client.query.Language.Value;
import static com.faunadb.client.query.Language.Var;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;

import com.example.Connection.FaunaConnection;
import com.faunadb.client.FaunaClient;
import com.faunadb.client.types.Value;
import com.faunadb.client.types.Value.RefV;

/**
 * Class that represents a sentence of a person.
 * 
 * @author Ruymán Crespo Díaz
 * @author Silvia Oliva Rodríguez
 * @author José Ramón Navarro González
 * @version 1.0
 */
public class PersonSentence extends FaunaConnection {

    // - - - FAUNA DATABASE - - -
    private final FaunaClient connection = getConnection();

    // - - - COLLECTION - - -
    private final String collection = "prueba";

    // - - - SEARCH INDEX - - -
    private final String indexGetReferenceByName = "prueba_BorrarNombre";
    private final String indexSearchByName = "pruebaBusquedaPorNombre";

    // - - - PUBLIC METHODS - - -

    /**
     * Method that creates a new collection in FaunaDB.
     * 
     * @param person - The model of the application data.
     * @return - The result of the operation.
     */
    public boolean insert(Person person) {
        try {
            // Adds a new person to the collection.
            Value result = connection
                    .query(Create(Collection(Value(collection)), Obj("data", Obj("name", Value(person.getName()),
                            "apellido", Value(person.getLastName()), "edad", Value(person.getAge())))))
                    .get();

            if (result != null) {
                return true;
            }

        } catch (InterruptedException | IllegalStateException | ExecutionException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }

        return false;
    }

    /**
     * Method that updates the data of a people in the collection.
     * 
     * @param person - The model of the application data.
     * @return - The result of the operation.
     */
    public boolean update(Person person) {

        FaunaClient connection = getConnection();
        Value result = null;
        RefV reference;

        try {
            // Gets the reference of the people by name.
            reference = getReferenceByName(person);

            // If the reference is not null, updates the person.
            if (reference != null) {

                // Updates the persons.
                result = connection
                        .query(Update(reference,
                                Obj("data",
                                        Obj("name", Value(person.getName()), "apellido",
                                                Value(person.getLastName()), "edad", Value(person.getAge())))))
                        .get();
            }

            // If the update was successful, returns true.
            if (result != null) {
                return true;
            }

        } catch (InterruptedException | IllegalStateException | ExecutionException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return false;

    }

    /**
     * Method that searches the people by name.
     * 
     * @param name - The name of the person.
     * @return - The person.
     */
    public Person search(String name) {

        try {
            // Returns the person by name.
            Value result = connection.query(Paginate(Match(Index(indexSearchByName), Value(name)))).get();

            // If the person is not null, returns it.
            if (result != null) {

                // Stores the person.
                String personName = result.at("data").at(0).at(0).to(String.class).get();
                String personLastName = result.at("data").at(0).at(1).to(String.class).get();
                Integer personAge = result.at("data").at(0).at(2).to(int.class).get();

                // Returns the person.
                return new Person(personName, personLastName, personAge);
            }
        } catch (InterruptedException | ExecutionException | IllegalStateException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return null;
    }

    // - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - -
    /**
     * Method that deletes the people by name.
     * 
     * @param person - The model of the application data.
     * @return - The result of the operation.
     */
    public boolean delete(Person person) {

        try {
            // Gets the reference of the person by name.
            RefV ref = getReferenceByName(person);

            // Security check.
            int resp = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete the persons?", "Delete",
                    JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

            // If the user confirms the deletion, deletes the person.
            if (ref != null && resp == JOptionPane.YES_OPTION) {

                // Deletes the person.
                connection.query(Delete(ref)).get();
                return true;
            }

        } catch (InterruptedException | IllegalStateException | ExecutionException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }

        return false;
    }

    /**
     * Method that gets all the people in the collection.
     * 
     * @return - The list of people.
     */
    public Person[] getAll() {
        try {

            Value queryIndexResults = connection
                    .query(Map(Paginate(Match(Index("prueba_index"))), Lambda("X",
                            Get(Var("X")))))
                    .get();

            Collection<Object> collection = queryIndexResults.at("data").asCollectionOf(Object.class).get();
            ArrayList<?> array = new ArrayList<>(collection);

            // Get all the people.
            Person[] persons = new Person[array.size()];

            for (int i = 0; i < array.size(); i++) {

                persons[i] = new Person(queryIndexResults.at("data").at(i).at("data").at("name").to(String.class).get(),
                        queryIndexResults.at("data").at(i).at("data").at("apellido").to(String.class).get(),
                        queryIndexResults.at("data").at(i).at("data").at("edad").to(Integer.class).get());
            }

            return persons;
        } catch (InterruptedException | IllegalStateException | ExecutionException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return null;

    }

    // - - - PRIVATE METHODS - - -

    /**
     * Method that gets the reference of the person by name.
     * 
     * @param person - The model of the application data.
     * @return - The reference of the person.
     */
    private RefV getReferenceByName(Person person) {

        try {
            // Returns the reference of the person by name.
            return connection.query(Paginate(Match(Index(indexGetReferenceByName), Value(person.getName())))).get()
                    .at("data").at(0).to(RefV.class).get();
        } catch (InterruptedException | IllegalStateException | ExecutionException e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }
        return null;
    }

}
