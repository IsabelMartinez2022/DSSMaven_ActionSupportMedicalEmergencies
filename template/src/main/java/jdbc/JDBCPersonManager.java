/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.PersonManager;
import java.sql.PreparedStatement;
import pojos.Person;

/**
 *
 * @author isama
 */
public class JDBCPersonManager implements PersonManager{
    
    private ConnectionManager manager;

	public JDBCPersonManager(ConnectionManager m) {
		this.manager = m;
	}

	@Override
	public void addPerson(Person p) {
		try {

			String sql = "INSERT INTO person (conscious, dizzy, breathing, bleeding, "
                                + "emit_words, chest_pain, cough, seizure, possible_poisoning, electric_shock, "
                                + "major_trauma, car_accident, vomit, difficulty_breathing, communication_problems, "
                                + "userId, protocolId) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
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
}

