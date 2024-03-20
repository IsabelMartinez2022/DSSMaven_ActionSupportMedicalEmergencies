/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.io.IOException;
import java.util.Scanner;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Person;
import pojos.User;

/**
 *
 * @author maria
 */
public class Auxiliar {
    
    public static void register() throws SQLException {
        User u = null;
        try {
            Scanner scanner = new Scanner(System.in);
            u = new User();

            System.out.println("Let's proceed with the registration:");

            String username, password;

            System.out.print("Username:");
            username = scanner.nextLine();
            u.setUsername(username);

            System.out.print("password:");
            password = scanner.nextLine();
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
    
    public static int inputnumber(){
        Scanner scanner = new Scanner(System.in);
        int number = -1;
        try{
            number = scanner.nextInt();
        } catch (Exception ex) {
            //Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("\nError on the input. "
                    + "Please try again\n");
        }
        return number;
    }
    
    public static String translatenumbertoString(){
        /*
        1 = Yes; 2 = No; 3 = Unable to check; 4 = a little; 5 = a lot"
        6 = true; 7 = false");
        */
        String string = "";
        int number;
        do{
            number = inputnumber();
            switch (number) {
                case 1:{
                    string = "YES";
                    break;
                }
                case 2:{
                    string = "NO";
                    break;
                }
                case 3:{
                    string = "UNABLE_TO_CHECK";
                    break;
                }
                case 4:{
                    string = "A_LITTLE";
                    break;
                }
                case 5:{
                    string = "A_LOT";
                    break;
                }
                case 6:{
                    string = "true";
                    break;
                }
                case 7:{
                    string = "false";
                    break;
                }
                default:
                    System.out.print("Please input a correct number: ");
            }
        }while((number<1 || number > 7));
        
        return string;
    }
}
