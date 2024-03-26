/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import Utilities.Auxiliar;
import static Utilities.Auxiliar.translateNumberToString;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import jdbc.ConnectionManager;
import jdbc.JDBCActionManager;
import jdbc.JDBCPersonManager;
import jdbc.JDBCProtocolManager;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import pojos.Bleeding;
import pojos.Breathing;
import pojos.ChestPain;
import pojos.DifficultyBreathing;
import pojos.Dizzy;
import pojos.Person;
import pojos.PersonUnit;
import jdbc.JDBCUserManager;
import pojos.User;

public class ActionSupportMedicalEmergencies {
    public static ConnectionManager connectionManager;
    public static JDBCUserManager userManager;
    public static JDBCPersonManager personManager;
    public static JDBCProtocolManager protocolManager;
    public static JDBCActionManager actionManager;
    private static boolean control;
    private static Scanner sc = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        connectionManager= new ConnectionManager();
        userManager = new JDBCUserManager(connectionManager);
        personManager = new JDBCPersonManager(connectionManager);
        protocolManager = new JDBCProtocolManager(connectionManager);
        actionManager = new JDBCActionManager(connectionManager);
        protocolManager.addProtocol();
        actionManager.addAction();
        Person p = null;
        
        int option;
        try {
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
                
                try {
                    option = sc.nextInt();
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter a number.");
                    sc.next(); // Clear the invalid input
                    continue; // Restart the loop
                }
                switch (option) {
                    case 1:
                        register();
                        break;
                    case 2:
                        login();
                        break;
                    case 0:
                        //instance.close();
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
        
    
    public static void register() throws SQLException {
        Scanner sc = new Scanner(System.in);
        try {
            User u = new User();

            System.out.println("Let's proceed with the registration:");

            String username, password;

            System.out.print("Username:");
            username = sc.nextLine();
            u.setUsername(username);

            System.out.print("Password:");
            password = sc.nextLine();
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] hash = md.digest();
            u.setPassword(hash);
            
            userManager.addUser(u); //aqui el usuario se añade correctamente

        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Auxiliar.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void login() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Username:");
        String username = sc.nextLine();
        System.out.print("password:");
        String password = sc.nextLine();
        byte[] bytesDefaultCharset = password.getBytes();
        if (userManager.verifyUsername(username) && userManager.verifyPassword(username, password)) {
            User u= userManager.getUser(userManager.getId(username));
            menuUser(u);
        }
    }
    
        public static void menuUser(User u){
        int userId = u.getId();
        Person p= null;
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        
        PersonUnit personunit = new PersonUnit();
        RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(personunit);
        
        while (running) {
            System.out.println("Please select an option:");
            System.out.println("1. Enter symptoms for a new person");
            System.out.println("2. Show all people associated with this user");
            System.out.println("0. Exit");
            
            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline left-over

            switch (choice) {
                case 1:
                    p= createPerson(u, personunit, instance);
                    // RULES
                    //personunit.getPeople().add(p);
                    //instance.fire();
                    //instance.close();
                    //System.out.println(p.getProtocol().toString()); 
                    // We need to get this from the database
                    break;
                case 2:
                    userManager.listPeopleofUser(userId);
                    System.out.println("Do you want to choose a specific person to see its protocol? (1: yes \n 2: no");
                    int choice2 = sc.nextInt();
                    switch(choice2){
                        case 1:
                            System.out.println("Introduce the id of the person you want to see: ");
                            int idperson = sc.nextInt();
                            protocolManager.getProtocolofPerson(idperson);
                            break;
                        case 2:
                            running = false;
                            break;
                    }
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
        
    public static Person createPerson (User user, PersonUnit personunit, RuleUnitInstance<PersonUnit> instance) {
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
        
        p.setUser(user);
        personunit.getPeople().add(p);
        instance.fire();
        instance.close();
        
        personManager.addPerson(p); //se añade a la base de datos

        return p;
    }
   
}