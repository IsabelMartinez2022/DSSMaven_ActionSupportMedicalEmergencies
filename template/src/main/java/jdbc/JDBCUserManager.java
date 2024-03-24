/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.UserManager;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import pojos.Person;
import pojos.User;

/**
 *
 * @author isama
 */
public class JDBCUserManager implements UserManager{
    
    private ConnectionManager manager;

	public JDBCUserManager(ConnectionManager m) {
		this.manager = m;
	}
        
    @Override
    public void addUser(User user) {
        try {
            String sql = "INSERT INTO user (username, password) VALUES (?, ?)";
            PreparedStatement prep = manager.getConnection().prepareStatement(sql);
            prep.setString(1, user.getUsername());
            prep.setBytes(2, user.getPassword());
            prep.executeUpdate();
            prep.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    @Override
    public boolean verifyUsername(String username) {
        String sql = "SELECT username FROM USER WHERE username LIKE ?";
        try {
            PreparedStatement prep = manager.getConnection().prepareStatement(sql);
            prep.setString(1, username);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }
    
    @Override
    public boolean verifyPassword(String username, String passwordIntroduced) {
        String sql = "SELECT password FROM user WHERE username LIKE ?";
        try {
            PreparedStatement prep = manager.getConnection().prepareStatement(sql);
            prep.setString(1, username);
            ResultSet rs = prep.executeQuery();
            if (rs.next()) {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(passwordIntroduced.getBytes());
                byte[] hashIntroduced = md.digest();
                byte[] hashSaved = rs.getBytes("password");
                return Arrays.equals(hashIntroduced, hashSaved);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException ex) {
        }
        return false;
    }
    
    // TODO NOT FINISHED
    @Override
	public List<Person> listPeopleofUser(int userId) {

		List<Person> peopleList = new ArrayList<Person>();

		try {
			String sql = "SELECT * FROM person WHERE userId LIKE ?";

			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, userId);
			ResultSet r = prep.executeQuery();

			while (r.next()) {
				int id = r.getInt("id");
				//Protocol p=
				//peopleList.add(person);

			}
			r.close();
			prep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return peopleList;
	}


}
