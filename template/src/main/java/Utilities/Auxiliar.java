/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Utilities;

import java.util.Scanner;

public class Auxiliar {
private static Scanner sc = new Scanner(System.in);
  
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
            sc.nextLine();
        }
        return number;
    }
    
}
