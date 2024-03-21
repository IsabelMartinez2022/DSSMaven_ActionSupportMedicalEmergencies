/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import static Utilities.Auxiliar.inputnumber;
//import static Utilities.Auxiliar.translatenumbertoString;
import static Utilities.Auxiliar.translatenumbertoStringBoolean;
import static Utilities.Auxiliar.translatenumbertoStringEnum1;
import static Utilities.Auxiliar.translatenumbertoStringEnum2;
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
                        System.out.println("\nYou are leaving the app\n");
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
        String info;
        
        System.out.println("\nYou will be presented with some casuistic at which you need to input a number: ");
        /*System.out.println("1 = Yes; \t2 = No; \t3 = Unable to check;\n"
                    + "4 = a little; \t5 = a lot;\n"
                    + "6 = true; \t7 = false");*/
        System.out.println("\t1 = True/Yes/a little; "
                    + "\t2 = False/No; "
                    + "\t3 = Unable to check/a lot");
        
        System.out.print("\nIs the person conscious? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean consciousAnswer = scanner.nextBoolean();
        Boolean consciousAnswer = Boolean.valueOf(info); //'true' --> true; other txt is interpretated as false
        p.setConscious(consciousAnswer);
        
        System.out.print("\nIs the person breathing? (YES(1), NO(2), UNABLE_TO_CHECK(3)): "); 
        //Breathing breathingAnswer = Breathing.valueOf(scanner.next().toUpperCase());
        info = translatenumbertoStringEnum1();
        Breathing breathingAnswer = Breathing.valueOf(info);
        p.setBreathing(breathingAnswer);
            //if(!consciousAnswer && breathingAnswer == Breathing.NO) {
                    /*p.getProtocol().getType().CALL_112; //acaba directamente la ejecución de la aplicación 
                    return ; //acaba directamente la ejecución de la aplicación */
        
        System.out.print("\nIs the person bleeding? (A_LITTLE(1), NO(2),  A_LOT(3)): ");
        info = translatenumbertoStringEnum2();
        //Bleeding bleeding = Bleeding.valueOf(scanner.next().toUpperCase());
        Bleeding bleeding = Bleeding.valueOf(info);
        p.setBleeding(bleeding);
        
        System.out.print("\nHas the person just had an electric shock? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean electricAnswer = scanner.nextBoolean();
        Boolean electricAnswer = Boolean.valueOf(info);
        p.setElectric_shock(electricAnswer);
        
        System.out.print("\nHas the person just suffered a major trauma? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean mtAnswer = scanner.nextBoolean();
        Boolean mtAnswer = Boolean.valueOf(info);
        p.setMajor_trauma(mtAnswer);
        
        System.out.print("\nIs the person having seizures? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean seizuresAnswer = scanner.nextBoolean();
        Boolean seizuresAnswer = Boolean.valueOf(info);
        p.setSeizure(seizuresAnswer);
        
        System.out.print("\nHas the person just had a car accident? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean carAnswer = scanner.nextBoolean();
        Boolean carAnswer = Boolean.valueOf(info);
        p.setCar_accident(carAnswer);
        
        System.out.print("\nIs the person vomiting? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean vomitAnswer = scanner.nextBoolean();
        Boolean vomitAnswer = Boolean.valueOf(info);
        p.setVomit(vomitAnswer);
        
        System.out.print("\nDoes the person have chest pain? (A_LITTLE(1), NO(2),  A_LOT(3)): ");
        info = translatenumbertoStringEnum2();
        //ChestPain chestPainAnswer = ChestPain.valueOf(scanner.next().toUpperCase());
        ChestPain chestPainAnswer = ChestPain.valueOf(info);
        p.setChest_pain(chestPainAnswer);
        
        System.out.print("\nIs the person dizzy? (A_LITTLE(1), NO(2),  A_LOT(3)): ");
        info = translatenumbertoStringEnum2();
        //Dizzy dizzyAnswer = Dizzy.valueOf(scanner.next().toUpperCase());
        Dizzy dizzyAnswer = Dizzy.valueOf(info);
        p.setDizzy(dizzyAnswer);
        
        System.out.print("\nDoes the person have any difficulty breathing? (A_LITTLE(1), NO(2),  A_LOT(3)): ");
        info = translatenumbertoStringEnum2();
        //DifficultyBreathing diffbreathing = DifficultyBreathing.valueOf(scanner.next().toUpperCase());
        DifficultyBreathing diffbreathing = DifficultyBreathing.valueOf(info);
        p.setDifficulty_breathing(diffbreathing);
        
        System.out.print("\nDoes the person have any communication problems? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean communicationProblemsAnswer = scanner.nextBoolean();
        Boolean communicationProblemsAnswer = Boolean.valueOf(info);
        p.setCommunication_problems(communicationProblemsAnswer);
       
        System.out.print("\nIs the person emitting words? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean wordsAnswer = scanner.nextBoolean();
        Boolean wordsAnswer = Boolean.valueOf(info);
        p.setEmit_words(wordsAnswer);
        
        System.out.print("\nIs the person trying to cough? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean cough = scanner.nextBoolean();
        Boolean cough = Boolean.valueOf(info);
        p.setCough(cough);
        
        System.out.print("\nCould the person be intoxicated? (true(1)/false(2)): ");
        info = translatenumbertoStringBoolean();
        //Boolean intoxicationAnswer = scanner.nextBoolean();
        Boolean intoxicationAnswer = Boolean.valueOf(info);
        p.setPossible_poisoning(intoxicationAnswer);
        
        return p;
    }
        
    
    public static int menu() {
    Scanner scanner = new Scanner(System.in);
        //boolean exit = false;
        int option = -1;
        //try {
        
        System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
        System.out.println("@@                                                                  @@");
        System.out.println("@@                 Welcome.                                         @@");
        System.out.println("@@                 1. Register                                      @@");
        System.out.println("@@                 2. Login                                         @@");
        System.out.println("@@                 0. Exit                                          @@");
        System.out.println("@@                                                                  @@");
        System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");

        System.out.print("\nSelect an option: ");
        
            do {
                
                option = inputnumber(); //is an import but it could be: Utilities.Auxiliar.inputnumber()
                
                if(option<0 || option>2){
                    System.out.print("\nPlease introduce a correct optcion(0-2): ");
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