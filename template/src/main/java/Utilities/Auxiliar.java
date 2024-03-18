/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Person;

/**
 *
 * @author maria
 */
public class Auxiliar {
    
    
    
    //public static void register() throws SQLException {
    public static Person register() throws SQLException {
        Person p = null;
        try {
            Scanner scanner = new Scanner(System.in);
            p = new Person();

            System.out.println("Let's proceed with the registration:");

            String username, password;

            System.out.print("Username:");
            username = scanner.nextLine();
            p.setUsername(username);

            System.out.print("password:");
            password = scanner.nextLine();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            p.setPassword(hash);
            
            //return p;

        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return p;
    }
    //PARA HACER LOG IN NECESITAMOS UNA ABSE DE DATOS
    public static Person login() {
        /*try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Username:");

            String username = scanner.nextLine();

            System.out.print("password:");
            String password = scanner.nextLine();
            byte[] bytesDefaultCharset = password.getBytes();
            if (verifyUsername(username) && verifyPassword(username, password)) {

                return manager.getUser(manager.getId(username));
            }
        } catch (IOException ex) {
            
        }*/
        return null;
    }
}
