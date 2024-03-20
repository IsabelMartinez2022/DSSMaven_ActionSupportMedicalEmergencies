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

			String sql = "INSERT INTO person...";
			PreparedStatement prep = manager.getConnection().prepareStatement(sql);

			prep.setBoolean(1, p.getConscious());
                        //ALL SYMPTOMS
			prep.executeUpdate();
			prep.close();

		} catch (Exception ex) {
			ex.printStackTrace();
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
