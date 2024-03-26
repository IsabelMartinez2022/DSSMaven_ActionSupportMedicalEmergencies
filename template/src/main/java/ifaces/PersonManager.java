/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;

import java.util.List;
import pojos.Person;
import pojos.Protocol;

public interface PersonManager {
        public void addPerson(Person p);
        public Person selectPerson(int id);
        // SUBSTITUED public Person getPersonById(int choicePerson);
}
