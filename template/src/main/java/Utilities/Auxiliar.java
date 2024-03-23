/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Person;
import pojos.User;

public class Auxiliar {
private static Scanner sc = new Scanner(System.in);

    public static void register() throws SQLException {
        User u = null;
        try {
            u = new User();

            System.out.println("Let's proceed with the registration:");

            String username, password;

            System.out.print("Username:");
            username = sc.nextLine();
            u.setUsername(username);

            System.out.print("password:");
            password = sc.nextLine();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            u.setPassword(hash);
            
            //return p;

        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //PARA HACER LOG IN NECESITAMOS UNA ABSE DE DATOS
    public static Person login() {
        /*try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Username:");

            String username = sc.nextLine();

            System.out.print("password:");
            String password = sc.nextLine();
            byte[] bytesDefaultCharset = password.getBytes();
            if (verifyUsername(username) && verifyPassword(username, password)) {

                return manager.getUser(manager.getId(username));
            }
        } catch (IOException ex) {
            
        }*/
        return null;
    }
    
    public static String translateNumberToString(int optionsCount, String[] optionStrings) { //1º, nº total opciones posibles; 2º, txt opciones posibles
        int number;
        String string = "";
        do {
            number = inputNumber();
            if (number >= 1 && number <= optionsCount) {
                string = optionStrings[number - 1]; // Adjust index
            } else {
                System.out.print("Please input a correct number: ");
            }
        } while (number < 1 || number > optionsCount);

        return string;
    }
    
    private static int inputNumber() {
        int number = -1;
        try {
            number = sc.nextInt();
        } catch (Exception ex) {
            System.out.println("\nError on the input. Please try again\n");
        } finally {
            sc.nextLine(); // Consume newline character
        }
        return number;
    }
    
}
