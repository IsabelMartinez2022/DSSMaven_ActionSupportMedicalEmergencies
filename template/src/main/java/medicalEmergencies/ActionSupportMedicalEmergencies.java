/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import static Utilities.Auxiliar.translateNumberToString;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionManager;
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
    private static ConnectionManager connectionManager;
    private static boolean control;
    private static Scanner sc = new Scanner(System.in);
    
    /*public static boolean logIn() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type the user name:");
        String username = sc.nextLine();
        System.out.println("Type the password:");
        String password = sc.nextLine();
        //boolean d = user.login(username, password);
        return d;
    }*/

    
    public static void main(String[] args) {
        PersonUnit personunit = new PersonUnit();
        RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(personunit);
        Person p = null;
        int option;
        try {
            connectionManager = new ConnectionManager();
            
            boolean log = true;
            /*while (log) {
                    log = logIn();
            }*/
            
            boolean control = true;
            while (control)  {
                System.out.println("\n@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.println("@@                                                                  @@");
                System.out.println("@@                 Welcome.                                         @@");
                System.out.println("@@                 1. Register                                      @@");
                System.out.println("@@                 2. Login                                         @@");
                System.out.println("@@                 0. Exit                                          @@");
                System.out.println("@@                                                                  @@");
                System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@");
                System.out.print("\nSelect an option: ");
                
                //int option = sc.nextInt();
                try {
                    option = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next(); // Clear the invalid input
                    continue; // Restart the loop
                }
                switch (option) {
                    case 1:
                        Utilities.Auxiliar.register();
                        break;
                    case 2:
                        Utilities.Auxiliar.login(); //TODO descomentar el método
                        p = execute();
                        personunit.getPeople().add(p);
                        // Ejecutar las reglas sobre la instancia
                        instance.fire();
                        instance.close();
                        System.out.println(p.getProtocol().toString());
                        break;
                    case 0:
                        instance.close();
                        control = false;
			break;
                    default:
                        System.out.println("  NOT AN OPTION \n");
                        break;
                    }
                }
                
        }catch (NumberFormatException e) {
            System.out.println("  NOT A NUMBER. Closing application... \n");
            sc.close();
        }catch (SQLException ex) {
            Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
        }finally {
            sc.close();
	}
    }
        
    public static Person execute() {
        Person p = new Person();
        String info;

        System.out.println("\nYou will be presented with some casuistic at which you need to input a number: ");
        System.out.println("\t1 = True/Yes/a little; "
                    + "\t2 = False/No; "
                    + "\t3 = Unable to check/a lot");

        System.out.print("\nIs the person conscious? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean consciousAnswer = Boolean.valueOf(info);
        p.setConscious(consciousAnswer);

        System.out.print("\nIs the person breathing? (YES(1), NO(2), UNABLE_TO_CHECK(3)): ");
        info = translateNumberToString(3, new String[]{"YES", "NO", "UNABLE_TO_CHECK"});
        Breathing breathingAnswer = Breathing.valueOf(info);
        p.setBreathing(breathingAnswer);

        System.out.print("\nIs the person bleeding? (A_LITTLE(1), NO(2), A_LOT(3)): ");
        info = translateNumberToString(3, new String[]{"A_LITTLE", "NO", "A_LOT"});
        Bleeding bleeding = Bleeding.valueOf(info);
        p.setBleeding(bleeding);

        System.out.print("\nHas the person just had an electric shock? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean electricAnswer = Boolean.valueOf(info);
        p.setElectric_shock(electricAnswer);

        System.out.print("\nHas the person just suffered a major trauma? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean majorTraumaAnswer = Boolean.valueOf(info);
        p.setMajor_trauma(majorTraumaAnswer);

        System.out.print("\nIs the person having seizures? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean seizuresAnswer = Boolean.valueOf(info);
        p.setSeizure(seizuresAnswer);

        System.out.print("\nHas the person just had a car accident? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean carAccidentAnswer = Boolean.valueOf(info);
        p.setCar_accident(carAccidentAnswer);

        System.out.print("\nIs the person vomiting? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean vomitingAnswer = Boolean.valueOf(info);
        p.setVomit(vomitingAnswer);

        System.out.print("\nDoes the person have chest pain? (A_LITTLE(1), NO(2), A_LOT(3)): ");
        info = translateNumberToString(3, new String[]{"A_LITTLE", "NO", "A_LOT"});
        ChestPain chestPainAnswer = ChestPain.valueOf(info);
        p.setChest_pain(chestPainAnswer);

        System.out.print("\nIs the person dizzy? (A_LITTLE(1), NO(2), A_LOT(3)): ");
        info = translateNumberToString(3, new String[]{"A_LITTLE", "NO", "A_LOT"});
        Dizzy dizzyAnswer = Dizzy.valueOf(info);
        p.setDizzy(dizzyAnswer);

        System.out.print("\nDoes the person have any difficulty breathing? (A_LITTLE(1), NO(2), A_LOT(3)): ");
        info = translateNumberToString(3, new String[]{"A_LITTLE", "NO", "A_LOT"});
        DifficultyBreathing difficultyBreathingAnswer = DifficultyBreathing.valueOf(info);
        p.setDifficulty_breathing(difficultyBreathingAnswer);

        System.out.print("\nDoes the person have any communication problems? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean communicationProblemsAnswer = Boolean.valueOf(info);
        p.setCommunication_problems(communicationProblemsAnswer);

        System.out.print("\nIs the person emitting words? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean emitWordsAnswer = Boolean.valueOf(info);
        p.setEmit_words(emitWordsAnswer);

        System.out.print("\nIs the person trying to cough? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean coughAnswer = Boolean.valueOf(info);
        p.setCough(coughAnswer);

        System.out.print("\nCould the person be intoxicated? (true(1)/false(2)): ");
        info = translateNumberToString(2, new String[]{"true", "false"});
        Boolean intoxicatedAnswer = Boolean.valueOf(info);
        p.setPossible_poisoning(intoxicatedAnswer);

        return p;
    }
}