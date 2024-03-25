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
import pojos.Bleeding;
import pojos.Breathing;
import pojos.ChestPain;
import pojos.DifficultyBreathing;
import pojos.Dizzy;
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
    
    @Override
	public List<Person> listPeopleofUser(int userId) {

		List<Person> peopleList = new ArrayList<>();

		try {
			String sql = "SELECT * FROM person WHERE userId LIKE ?";

			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			prep.setInt(1, userId);
			ResultSet rs = prep.executeQuery();

			while (rs.next()) {
                        Person person = new Person();
                        person.setId(rs.getInt("id"));
                        person.setConscious(rs.getBoolean("conscious"));
                        person.setDizzy(Dizzy.valueOf(rs.getString("dizzy")));
                        person.setBreathing(Breathing.valueOf(rs.getString("breathing")));
                        person.setBleeding(Bleeding.valueOf(rs.getString("bleeding")));
                        person.setEmit_words(rs.getBoolean("emit_words"));
                        person.setChest_pain(ChestPain.valueOf(rs.getString("chest_pain")));
                        person.setCough(rs.getBoolean("cough"));
                        person.setSeizure(rs.getBoolean("seizure"));
                        person.setPossible_poisoning(rs.getBoolean("possible_poisoning"));
                        person.setElectric_shock(rs.getBoolean("electric_shock"));
                        person.setMajor_trauma(rs.getBoolean("major_trauma"));
                        person.setCar_accident(rs.getBoolean("car_accident"));
                        person.setVomit(rs.getBoolean("vomit"));
                        person.setDifficulty_breathing(DifficultyBreathing.valueOf(rs.getString("difficulty_breathing")));
                        person.setCommunication_problems((rs.getBoolean("communication_problems")));
			peopleList.add(person);

			}
			rs.close();
			prep.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return peopleList;
	}


}
