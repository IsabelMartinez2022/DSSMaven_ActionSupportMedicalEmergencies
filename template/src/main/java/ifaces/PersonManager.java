/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;

import pojos.Person;

public interface PersonManager {
        public void addPerson(Person p);
        public Person selectPerson(int id);
}
