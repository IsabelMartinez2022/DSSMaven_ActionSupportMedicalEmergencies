/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.InterfaceConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionManager implements InterfaceConnectionManager{

	private Connection c= null;

        public ConnectionManager() {
		try {
                    Class.forName("org.sqlite.JDBC");
                    c = DriverManager.getConnection("jdbc:sqlite:./db/ActionSupportMedicalEmergencies.db");
                    c.createStatement().execute("PRAGMA foreign_keys=ON");
                    System.out.println("Database connection opened.");
                    this.createTables();
		} catch (ClassNotFoundException e) {
			System.out.println("Libraries not loaded");
		} catch (SQLException ex) {
                Logger.getLogger(ConnectionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
	}

//------CREATE TABLES-------------
        @Override
	public void createTables() {  
		try {
			Statement stmt = c.createStatement();
			String table = "CREATE TABLE user ("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "username TEXT NOT NULL,"
                                +" password BLOB NOT NULL"
                                + ");";
			stmt.executeUpdate(table);
                        String table1 = "CREATE TABLE person ("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                +"conscious BOOLEAN,"
                                +"dizzy VARCHAR(20),"
                                +"breathing VARCHAR(20),"
                                +"bleeding VARCHAR(20),"
                                +"emit_words BOOLEAN,"
                                +"chest_pain VARCHAR(20),"
                                + "cough BOOLEAN,"
                                +"seizure BOOLEAN,"
                                +"possible_poisoning BOOLEAN,"
                                +"electric_shock BOOLEAN,"
                                +"major_trauma BOOLEAN,"
                                +"car_accident BOOLEAN,"
                                +"vomit BOOLEAN,"
                                +"difficulty_breathing VARCHAR(20),"
                                +"communication_problems BOOLEAN,"
                                +"userId INTEGER NOT NULL,"
                                +"protocolId INTEGER NOT NULL,"
                                +"FOREIGN KEY(userId) REFERENCES user(id),"
                                +"FOREIGN KEY(protocolId) REFERENCES protocol(id)"
                                +");";
                        stmt.executeUpdate(table1);
                        String table2 ="CREATE TABLE protocol ("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                +"type TEXT NOT NULL"
                                +");";
                        stmt.executeUpdate(table2);
                        String table3 ="CREATE TABLE action("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "type VARCHAR(255) NOT NULL,"
                                +"instruction TEXT NOT NULL"
                                +");";
                        stmt.executeUpdate(table3);
                        String table4 ="CREATE TABLE protocolAction ("
                                +"protocolId INTEGER NOT NULL,"
                                + "actionId INTEGER NOT NULL,"
                                + "PRIMARY KEY (protocolId, actionId),"
                                + "FOREIGN KEY (protocolId) REFERENCES protocol(id),"
                                + "FOREIGN KEY (actionId) REFERENCES action(id)"
                                +");";
                        stmt.executeUpdate(table4);    
		} catch (SQLException e) {
                    // Check if the exception is because the tables already exist
                    if (e.getMessage().contains("already exist")) {
                        System.out.println("Tables already created.");
                        return;
                    }
                    System.out.println("Database error.");
                    e.printStackTrace();
		}
	}
        
        @Override
        public Connection getConnection() {
            return c;
	}
        
        @Override
        public void disconnect() {
            try {
                c.close();
            } catch (SQLException e) {
                System.out.println("Database error.");
                e.printStackTrace();
            }
	}
}