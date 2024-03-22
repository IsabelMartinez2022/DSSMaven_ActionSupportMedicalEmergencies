/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.PersonManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
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
    
    private JDBCManager manager;

	public JDBCPersonManager(JDBCManager m) {
		this.manager = m;
	}

	@Override
	public void addPerson(Person p) {
		try {

			String sql = "INSERT INTO person (conscious, dizzy, breathing, bleeding, "
                                + "emit_words, chest_pain, cough, seizure, possible_poisoning, electric_shock, "
                                + "major_trauma, car_accident, vomit, difficulty_breathing, communication_problems) VALUES "
                                + "(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			prep.executeUpdate();
			prep.close();

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

    
    @Override
        public Person getPersonById(int choicePerson){
            Person p=null;
            
            try{
                String sql= "SELECT * from person WHERE id LIKE ?";
                PreparedStatement statement = manager.getConnection().prepareStatement(sql);
                statement.setInt(1, choicePerson);
                ResultSet rs = statement.executeQuery();
                
                while(rs.next()){
                    int id = rs.getInt("id");
                    Boolean conscious= rs.getBoolean("conscious");
                    
                    Dizzy dizzy; 
    private Breathing breathing; 
    private Bleeding bleeding; 
    private Boolean emit_words; 
    private ChestPain chest_pain;  
    private Boolean cough; 
    private Boolean seizure; 
    private Boolean possible_poisoning; 
    private Boolean electric_shock; 
    private Boolean major_trauma; 
    private Boolean car_accident; 
    private Boolean vomit; // 
    private DifficultyBreathing difficulty_breathing; 
    private Boolean communication_problems;
                }
            }
        }
        
    @Override
	public List<Person> listAllPeople() {

		List<Person> peopleList = new ArrayList<Person>();

		try {
			String sql = "SELECT * FROM person";

			PreparedStatement prep = manager.getConnection().prepareStatement(sql);
			ResultSet r = prep.executeQuery();

			while (r.next()) {
				Integer id = r.getInt("id");
				Boolean conscious = r.getBoolean("conscious");
                                //ALL SYMPTOMS
				//Person person = new Person(...);
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
