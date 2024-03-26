/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.PersonManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Bleeding;
import pojos.Breathing;
import pojos.ChestPain;
import pojos.DifficultyBreathing;
import pojos.Dizzy;
import pojos.Person;

/**
 *
 * @author isama
 */
public class JDBCPersonManager implements PersonManager{
    
    private ConnectionManager cM;

	public JDBCPersonManager(ConnectionManager cManager) {
		this.cM = cManager;
	}

	@Override
	public void addPerson(Person p) {
            
            try {
            
            if (!checkIfUserExists(p.getUser().getId())) {
                throw new RuntimeException("El usuario no existe en la base de datos.");
            }

            if (!checkIfProtocolExists(p.getProtocol().getId())) {
                throw new RuntimeException("El protocolo no existe en la base de datos.");
            }
			String sql = "INSERT INTO person (conscious, dizzy, breathing, bleeding, "
                                + "emit_words, chest_pain, cough, seizure, possible_poisoning, electric_shock, "
                                + "major_trauma, car_accident, vomit, difficulty_breathing, communication_problems, "
                                + "userId, protocolId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prep = cM.getConnection().prepareStatement(sql);
			prep.setBoolean(1, p.getConscious());
                        prep.setString(2, p.getDizzy().name());
                        prep.setString(3, p.getBreathing().name());
                        prep.setString(4, p.getBleeding().name());
                        prep.setBoolean(5, p.getEmit_words());
                        prep.setString(6, p.getChest_pain().name());
                        prep.setBoolean(7, p.getCough());
                        prep.setBoolean(8, p.getSeizure());
                        prep.setBoolean(9, p.getPossible_poisoning());
                        prep.setBoolean(10,p.getElectric_shock());
                        prep.setBoolean(11, p.getMajor_trauma());
                        prep.setBoolean(12, p.getCar_accident());
                        prep.setBoolean(13, p.getVomit());
                        prep.setString(14, p.getDifficulty_breathing().name());
                        prep.setBoolean(15, p.getCommunication_problems());
                        prep.setInt(16, p.getUser().getId());
                        prep.setInt(17, p.getProtocol().getId());
			prep.executeUpdate();
			prep.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
        
    @Override
    public Person selectPerson(int id) {
        Person p = null;
    try {
        String sql = "SELECT * FROM person WHERE id = ?";
        PreparedStatement pr = cM.getConnection().prepareStatement(sql);
        pr.setInt(1, id);
        ResultSet rs = pr.executeQuery();
        if (rs.next()) {
            p = new Person();
            p.setId(rs.getInt("id"));
            p.setConscious(rs.getBoolean("conscious"));
            p.setDizzy(Dizzy.valueOf(rs.getString("dizzy")));
            p.setBreathing(Breathing.valueOf(rs.getString("breathing")));
            p.setBleeding(Bleeding.valueOf(rs.getString("bleeding")));
            p.setEmit_words(rs.getBoolean("emit_words"));
            p.setChest_pain(ChestPain.valueOf(rs.getString("chest_pain")));
            p.setCough(rs.getBoolean("cough"));
            p.setSeizure(rs.getBoolean("seizure"));
            p.setPossible_poisoning(rs.getBoolean("possible_poisoning"));
            p.setElectric_shock(rs.getBoolean("electric_shock"));
            p.setMajor_trauma(rs.getBoolean("major_trauma"));
            p.setCar_accident(rs.getBoolean("car_accident"));
            p.setVomit(rs.getBoolean("vomit"));
            p.setDifficulty_breathing(DifficultyBreathing.valueOf(rs.getString("difficulty_breathing")));
            p.setCommunication_problems(rs.getBoolean("communication_problems"));
        }
        pr.close();
        rs.close();
    } catch (SQLException ex) {
        Logger.getLogger(JDBCPersonManager.class.getName()).log(Level.SEVERE, null, ex);
    }
    return p;
    }
    
    private boolean checkIfUserExists(int userId) throws SQLException {
        String query = "SELECT COUNT(*) FROM user WHERE id = ?";
        PreparedStatement prep = cM.getConnection().prepareStatement(query);
        prep.setInt(1, userId);
        ResultSet rs = prep.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        rs.close();
        prep.close();
        return false;
    }
    
    private boolean checkIfProtocolExists(int protocolId) throws SQLException {
        String query = "SELECT COUNT(*) FROM protocol WHERE id = ?";
        PreparedStatement prep = cM.getConnection().prepareStatement(query);
        prep.setInt(1, protocolId);
        ResultSet rs = prep.executeQuery();
        if (rs.next()) {
            return rs.getInt(1) > 0;
        }
        rs.close();
        prep.close();
        return false;
    }
}

