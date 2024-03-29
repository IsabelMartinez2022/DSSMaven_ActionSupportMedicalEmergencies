/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;

import java.util.List;
import pojos.Person;
import pojos.User;

public interface UserManager {
    public void addUser(User user);
    public boolean verifyPassword(String username, String passwordIntroduced);
    public boolean verifyUsername(String username);
    public List<Person> listPeopleofUser(int userId);
}
