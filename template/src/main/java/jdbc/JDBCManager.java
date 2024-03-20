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
			c = DriverManager.getConnection("jdbc:sqlite:./db/epiplus.db");//CHANGE TO PATH
			c.createStatement().execute("PRAGMA foreign_keys=ON");
			System.out.println("Database connection opened.");
			// Create tables
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
	
	public Integer getLastId() {
		String query = "SELECT last_insert_rowid() AS lastId";
		PreparedStatement p;
		Integer lastId = null;
		try {
			p = c.prepareStatement(query);
			ResultSet rs = p.executeQuery();
			lastId = rs.getInt("lastId");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return lastId;
	}

//------CREATE TABLES-------------
	public void createTables() {  
            // Create Tables
		try {
			Statement stmt = c.createStatement();
			String sql = "CREATE TABLE...";
			stmt.executeUpdate(sql);
                        
		} catch (SQLException e) {
			if (!e.getMessage().contains("already exists")) {
				e.printStackTrace();
			}
		}
	}

}