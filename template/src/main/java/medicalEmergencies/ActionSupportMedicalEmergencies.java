/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import static Utilities.Auxiliar.inputnumber;
import static Utilities.Auxiliar.translatenumbertoString;
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
                    /*default:{
                        System.out.println("Please introduce a correct optcion(0-2)");
                    }*/
                }
            }while(true);
            
        } catch (SQLException ex) {
            Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    public static Person execute() {
        Scanner scanner = new Scanner(System.in);
        Person p = new Person();
        
        System.out.println("You will be presented with some casuistic at which you need to input a number: ");
        System.out.println("1 = Yes; \t2 = No; \t3 = Unable to check;\n"
                    + "4 = a little; \t5 = a lot;\n"
                    + "6 = true; \t7 = false");
        
        System.out.println("Is the person conscious? (true(6)/false(7)): ");
        String info = translatenumbertoString();
        //Boolean consciousAnswer = scanner.nextBoolean();
        Boolean consciousAnswer = Boolean.valueOf(info);
        p.setConscious(consciousAnswer);
        
        System.out.println("Is the person breathing? (NO(2),UNABLE_TO_CHECK(3), YES(1)): "); 
        Breathing breathingAnswer = Breathing.valueOf(scanner.next().toUpperCase());
        p.setBreathing(breathingAnswer);
            //if(!consciousAnswer && breathingAnswer == Breathing.NO) {
                    /*p.getProtocol().getType().CALL_112; //acaba directamente la ejecución de la aplicación 
                    return ; //acaba directamente la ejecución de la aplicación */
        
        System.out.println("Is the person bleeding? (NO(2), A_LITTLE(4), A_LOT(5)): ");
        Bleeding bleeding = Bleeding.valueOf(scanner.next().toUpperCase());
        p.setBleeding(bleeding);
        
        System.out.println("Has the person just had an electric shock? (true(6)/false(7)): ");
        Boolean electricAnswer = scanner.nextBoolean();
        p.setElectric_shock(electricAnswer);
        
        System.out.println("Has the person just suffered a major trauma? (true(6)/false(7)): ");
        Boolean mtAnswer = scanner.nextBoolean();
        p.setMajor_trauma(mtAnswer);
        
        System.out.println("Is the person having seizures? (true(6)/false(7)): ");
        Boolean seizuresAnswer = scanner.nextBoolean();
        p.setSeizure(seizuresAnswer);
        
        System.out.println("Has the person just had a car accident? (true(6)/false(7)): ");
        Boolean carAnswer = scanner.nextBoolean();
        p.setCar_accident(carAnswer);
        
        System.out.println("Is the person vomiting? (true(6)/false(7)): ");
        Boolean vomitAnswer = scanner.nextBoolean();
        p.setVomit(vomitAnswer);
        
        System.out.println("Does the person have chest pain? (A_LOT(5), A_LITTLE(4), NO(2)): ");
        ChestPain chestPainAnswer = ChestPain.valueOf(scanner.next().toUpperCase());
        p.setChest_pain(chestPainAnswer);
        
        System.out.println("Is the person dizzy? (A_LOT(5), A_LITTLE(4), NO(2)): ");
        Dizzy dizzyAnswer = Dizzy.valueOf(scanner.next().toUpperCase());
        p.setDizzy(dizzyAnswer);
        
        System.out.println("Does the person have any difficulty breathing? (A_LOT(5), A_LITTLE(4), NO(2)): ");
        DifficultyBreathing diffbreathing = DifficultyBreathing.valueOf(scanner.next().toUpperCase());
        p.setDifficulty_breathing(diffbreathing);
        
        System.out.println("Does the person have any communication problems? (true(1)/false(2)): ");
        Boolean communicationProblemsAnswer = scanner.nextBoolean();
        p.setCommunication_problems(communicationProblemsAnswer);
       
        System.out.println("Is the person emitting words? (true(6)/false(7)): ");
        Boolean wordsAnswer = scanner.nextBoolean();
        p.setEmit_words(wordsAnswer);
        
        System.out.println("Is the person trying to cough? (true(6)/false(7)): ");
        Boolean cough = scanner.nextBoolean();
        p.setCough(cough);
        
        System.out.println("Could the person be intoxicated? (true(6)/false(7)): ");
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
                option = inputnumber(); //is an import but it could be: Utilities.Auxiliar.inputnumber()
                
                if(option<0 || option>2){
                    System.out.println("Please introduce a correct optcion(0-2): ");
                }
                
                /*try{
                    option = scanner.nextInt();
                } catch (Exception ex) {
                    //Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("\nError on the input. "
                            + "Please try again\n");
                }*/
                
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
                //return option; //the return shoul be outside so that the loop could be effective
            } while ((option<0 || option>2));
            return option;

        /*} catch (Exception ex) {
            Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
        }*/
    }
    
    /*public static void menulogin(){

    }*/
    
}