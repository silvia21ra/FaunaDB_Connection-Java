package com.example.Connection;

import com.faunadb.client.FaunaClient;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.jdbc.JDBCAppender;

/**
 * Connection to FaunaDB database
 * 
 * @author Ruymán Crespo Díaz
 * @author Silvia Oliva Rodríguez
 * @author José Ramón Navarro González
 * @version 1.0
 */
public class FaunaConnection {

    // Secret key for the FaunaDB and the database URL
    private static final String secretKey = "SECRET_KEY";
    public static final String URL = "SERVER_URL"; //Example: https://db.eu.fauna.com

    /**
     * Method that returns the FaunaDB client connection.
     * 
     * @return FaunaClient - The FaunaDB client connection.
     */
    public FaunaClient getConnection() {

        FaunaClient connection = null;

        // We configure the Log4j to show us the errors in the console
        JDBCAppender appender = new JDBCAppender();
        appender.setLayout(new PatternLayout("%d %-5p %c - %m%n"));
        appender.setThreshold(Level.INFO);
        appender.activateOptions();
        Logger.getLogger("com.faunadb.common.Connection").addAppender(appender);

        try {

            connection = FaunaClient.builder().withSecret(secretKey).withEndpoint(URL).build();

        } catch (Exception e) {
            System.err.println("Error: " + e.getLocalizedMessage());
        }

        return connection;

    }

}
