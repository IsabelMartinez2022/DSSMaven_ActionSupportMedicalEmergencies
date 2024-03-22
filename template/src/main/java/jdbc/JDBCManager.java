/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author isama
 */
public class JDBCManager {

	private Connection c = null;

        public JDBCManager() {
		try {
			// Open database connection
			Class.forName("org.sqlite.JDBC");
			c = DriverManager.getConnection("jdbc:sqlite:./db/ActionSupportMedicalEmergencies.db");
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			this.createTables();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			System.out.println("Libraries not loaded");
		}
	}

	public void disconnect() {
		try {
			c.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		return c;
	}

//------CREATE TABLES-------------
	public void createTables() {  
            // Create Tables
		try {
			Statement stmt = c.createStatement();
			String sql = "CREATE TABLE user ("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "username TEXT NOT NULL,"
                                +" password BLOB NOT NULL"
                                + ");";
			stmt.executeUpdate(sql);
                        sql = "CREATE TABLE person ("
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
                        stmt.executeUpdate(sql);
                        sql="CREATE TABLE protocol ("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                +"type TEXT NOT NULL"
                                +");";
                        stmt.executeUpdate(sql);
                        sql="CREATE TABLE action("
                                +"id INTEGER PRIMARY KEY AUTOINCREMENT,"
                                + "type VARCHAR(255) NOT NULL,"
                                +"intruction TEXT NOT NULL"
                                +");";
                        stmt.executeUpdate(sql);
                        sql="CREATE TABLE protocolAction ("
                                +"protocolId INTEGER NOT NULL,"
                                + "actionId INTEGER NOT NULL,"
                                + "PRIMARY KEY (protocolId, actionId),"
                                + "FOREIGN KEY (protocolId) REFERENCES protocol(id),"
                                + "FOREIGN KEY (actionId) REFERENCES action(id)"
                                +");";
                        stmt.executeUpdate(sql);    
		} catch (SQLException e) {
			if (!e.getMessage().contains("already exists")) {
				e.printStackTrace();
			}
		}
	}

}