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
import pojos.User;
import jdbc.JDBCUserManager;

public class Auxiliar {
private static Scanner sc = new Scanner(System.in);

    public static void register(JDBCUserManager userManager) throws SQLException {
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
            userManager.addUser(u);

        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    //PARA HACER LOG IN NECESITAMOS UNA ABSE DE DATOS
    public static User login(JDBCUserManager userManager) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Username:");
        String username = sc.nextLine();
        System.out.print("password:");
        String password = sc.nextLine();
        byte[] bytesDefaultCharset = password.getBytes();
        if (userManager.verifyUsername(username) && userManager.verifyPassword(username, password)) {
            return userManager.getUser(userManager.getId(username));
        }
        return null;
    }
    
    public static void menuUser(User u){
        //int userId = ;
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        
        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Enter symptoms for a new person");
            System.out.println("2. Show all people associated with this user");
            System.out.println("3. Select a person to view the protocol and actions");
            System.out.println("0. Exit");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    // Assuming a method that handles new person entry
                    break;
                case 2:
                    // Assuming a method that lists all people for the user
                    break;
                case 3:
                    // Assuming a method that handles selection of a person and displays protocol and actions
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
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
