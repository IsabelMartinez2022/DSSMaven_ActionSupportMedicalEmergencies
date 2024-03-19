/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import java.sql.SQLException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import pojos.Bleeding;
import pojos.Breathing;
import pojos.ChestPain;
import pojos.DifficultyBreathing;
import pojos.Dizzy;
import pojos.Person;
import pojos.PersonUnit;

public class ActionSupportMedicalEmergencies {

    public static void main(String[] args) {
        PersonUnit personunit = new PersonUnit();
        RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(personunit);
        
        Person p = null;
        //User u = null;
        
        try {
            do{
                int option = menu();
                switch (option) {
                    case 1:{//REGISTER
                        //u =  Utilities.Auxiliar.register();
                        Utilities.Auxiliar.register();
                        break;
                    }
                    case 2:{//LOG IN
                        Utilities.Auxiliar.login();
                        //int option2 = menulogin();
                        p = execute();
                        personunit.getPeople().add(p);
                        // Ejecutar las reglas sobre la instancia
                        instance.fire();
                        instance.close();
                        System.out.println(p.getProtocol().toString());
                        break;
                    }
                    case 0:{//CLOSE
                        // No olvides cerrar la instancia al final para liberar recursos
                        instance.close();
                        System.exit(0);
                    }

                }
            }while(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static Person execute() {
        Scanner scanner = new Scanner(System.in);
        Person p = new Person();
        System.out.println("Is the person conscious? (true/false): ");
        Boolean consciousAnswer = scanner.nextBoolean();
        p.setConscious(consciousAnswer);
        System.out.println("Is the person breathing? (NO,UNABLE_TO_CHECK, YES): "); 
        Breathing breathingAnswer = Breathing.valueOf(scanner.next().toUpperCase());
        p.setBreathing(breathingAnswer);
            //if(!consciousAnswer && breathingAnswer == Breathing.NO) {
                    /*p.getProtocol().getType().CALL_112; //acaba directamente la ejecución de la aplicación 
                    return ; //acaba directamente la ejecución de la aplicación */
        System.out.println("Is the person bleeding? (NO, A_LITTLE, A_LOT): ");
        Bleeding bleeding = Bleeding.valueOf(scanner.next().toUpperCase());
        p.setBleeding(bleeding);
        System.out.println("Has the person just had an electric shock? (true/false): ");
        Boolean electricAnswer = scanner.nextBoolean();
        p.setElectric_shock(electricAnswer);
        System.out.println("Has the person just suffered a major trauma? (true/false): ");
        Boolean mtAnswer = scanner.nextBoolean();
        p.setMajor_trauma(mtAnswer);
        System.out.println("Is the person having seizures? (true/false): ");
        Boolean seizuresAnswer = scanner.nextBoolean();
        p.setSeizure(seizuresAnswer);
        System.out.println("Has the person just had a car accident? (true/false): ");
        Boolean carAnswer = scanner.nextBoolean();
        p.setCar_accident(carAnswer);
        System.out.println("Is the person vomiting? (true/false): ");
        Boolean vomitAnswer = scanner.nextBoolean();
        p.setVomit(vomitAnswer);
        System.out.println("Does the person have chest pain? (A_LOT, A_LITTLE, NO): ");
        ChestPain chestPainAnswer = ChestPain.valueOf(scanner.next().toUpperCase());
        p.setChest_pain(chestPainAnswer);
        System.out.println("Is the person dizzy? (A_LOT, A_LITTLE, NO): ");
        Dizzy dizzyAnswer = Dizzy.valueOf(scanner.next().toUpperCase());
        p.setDizzy(dizzyAnswer);
        System.out.println("Does the person have any difficulty breathing? (A_LOT, A_LITTLE, NO): ");
        DifficultyBreathing diffbreathing = DifficultyBreathing.valueOf(scanner.next().toUpperCase());
        p.setDifficulty_breathing(diffbreathing);
        System.out.println("Does the person have any communication problems? (true/false): ");
        Boolean communicationProblemsAnswer = scanner.nextBoolean();
        p.setCommunication_problems(communicationProblemsAnswer);
        System.out.println("Is the person emitting words? (true/false): ");
        Boolean wordsAnswer = scanner.nextBoolean();
        p.setEmit_words(wordsAnswer);
        System.out.println("Is the person trying to cough? (true/false): ");
        Boolean cough = scanner.nextBoolean();
        p.setCough(cough);
        System.out.println("Could the person be intoxicated? (true/false): ");
        Boolean intoxicationAnswer = scanner.nextBoolean();
        p.setPossible_poisoning(intoxicationAnswer);
        return p;
    }
        
    
    public static int menu() {
    Scanner scanner = new Scanner(System.in);
        //boolean exit = false;
        int option = -1;
        //try {
            do {
                System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@@                                                                  @@");
                System.out.println("@@                 Welcome.                                         @@");
                System.out.println("@@                 1. Register                                      @@");
                System.out.println("@@                 2. Login                                         @@");
                System.out.println("@@                 0. Exit                                          @@");
                System.out.println("@@                                                                  @@");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                
                System.out.println("Select an option: ");
                
                try{
                    option = scanner.nextInt();
                } catch (Exception ex) {
                    Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
                }
                
                /*switch (option) {
                    case 1:
                        Utilities.Auxiliar.register();
                        break;
                    case 2:
                        Utilities.Auxiliar.login();
                        break;
                    case 0:
                        System.exit(0);
                }*/
                return option;
            } while ((option<0 || option>2));
        /*} catch (Exception ex) {
            Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    /*public static void menulogin(){

    }*/
    
}