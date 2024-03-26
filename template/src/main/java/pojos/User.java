/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author maria
 */
public class User implements Serializable{

    private static final long serialVersionUID = 2L;
    private int id;
    public String username;
    public byte[] password;
    public List<Person> people; //One to many relationship

    public User() {
        super();
    }

    public User(String username, byte[] password) {
        super();
        this.username = username;
        this.password = password;
    }

    public User(int id, String username, byte[] password) {
        this.id=id;
        this.username=username;
        this.password=password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    
    public List<Person> getPeople() {
        return people;
    }

    public void setPeople(List<Person> people) {
        this.people = people;
    }

    public byte[] getPassword() {
        return password;
    }

    public void setPassword(byte[] password) {
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", password=" + password + ", userId=" + id + '}';
    }
}
