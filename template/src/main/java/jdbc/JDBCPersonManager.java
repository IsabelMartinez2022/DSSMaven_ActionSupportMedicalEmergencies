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

/*
  SUBSTITUED BY getPeopleofUser 
   @Override
        public Person getPersonById(int choicePerson){
            Person person = null;
            
            try{
                String sql= "SELECT * from person WHERE id LIKE ?";
                PreparedStatement statement = manager.getConnection().prepareStatement(sql);
                statement.setInt(1, choicePerson);
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()){
                    person = new Person();
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
                    //person.setProtocol(rs.get???.getProtocol())
                }
            } catch(SQLException e){
                e.printStackTrace();
            }
            return person;
}
/*

