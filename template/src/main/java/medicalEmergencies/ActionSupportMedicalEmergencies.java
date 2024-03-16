/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.drools.ruleunits.api.RuleUnit;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.drools.ruleunits.api.RuleUnits;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pojos.Bleeding;
import pojos.DifficultyBreathing;
import pojos.Dizzy;
import pojos.EmitWords;
import pojos.Person;
import pojos.PersonUnit;

public class ActionSupportMedicalEmergencies {

    public static void main(String[] args) {
        menu();
        PersonUnit personunit = new PersonUnit();
        RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(personunit);
        
        Person p = execute();
        personunit.getPeople().add(p);
        // Ejecutar las reglas sobre la instancia
        instance.fire();

        // No olvides cerrar la instancia al final para liberar recursos
        instance.close();
    }

    public static Person execute() {
        Person p = new Person();
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is conscious? (true/false): ");
        Boolean consciousAnswer = scanner.nextBoolean();
        if(!consciousAnswer){
            p.setConscious(consciousAnswer);
            System.out.println("It is breathing? (true/false): "); //TODO ADD UNABLE
            boolean breathingAnswer = scanner.nextBoolean();
            if(!breathingAnswer){
                p.setBreathing(breathingAnswer);
                System.out.println("It is bleeding? (NO, A_LITTLE, A_LOT): ");
                Bleeding bleeding = Bleeding.valueOf(scanner.next().toUpperCase());
                if(bleeding == Bleeding.A_LITTLE || bleeding == Bleeding.NO){
                    p.setBleeding(bleeding);
                    System.out.println("It just had an electric shock? (true/false):");
                    Boolean electricAnswer = scanner.nextBoolean();
                    if(!electricAnswer){
                        p.setElectric_shock(electricAnswer);
                        System.out.println("It is a major trauma? (true/false):");
                        Boolean mtAnswer = scanner.nextBoolean();
                        if(!mtAnswer){
                            p.setMajor_trauma(mtAnswer);
                            System.out.println("It has seizures? (true/false): ");
                            Boolean seizuresAnswer = scanner.nextBoolean();
                            if(!seizuresAnswer){
                                p.setSeizure(seizuresAnswer);//RULE 1
                            }else{
                                p.setSeizure(seizuresAnswer);//RULE 15
                            }
                        }else{
                            p.setMajor_trauma(mtAnswer);
                            System.out.println("It just had a car accident?");
                            Boolean carAnswer = scanner.nextBoolean();
                            if(!carAnswer){
                                p.setCar_accident(carAnswer);//RULE 3
                            }else{
                                p.setCar_accident(carAnswer);//RULE 6
                            }
                        }
                    }else{
                        p.setElectric_shock(electricAnswer);//RULE 2
                    }
                }else{
                    p.setBleeding(bleeding);
                    System.out.println("It just had a car accident?");
                    Boolean carAnswer = scanner.nextBoolean();
                    if(!carAnswer){
                        p.setCar_accident(carAnswer);//RULE 4
                    }else{
                        p.setCar_accident(carAnswer);//RULE 7
                    }
                }
            }else{
                p.setBreathing(breathingAnswer);
                System.out.println("It is bleeding? (NO, A_LITTLE, A_LOT): ");
                Bleeding bleeding = Bleeding.valueOf(scanner.next().toUpperCase());
                if(bleeding == Bleeding.A_LITTLE || bleeding == Bleeding.NO){
                    p.setBleeding(bleeding);
                    System.out.println("It is a major trauma? (true/false):");
                    Boolean mtAnswer = scanner.nextBoolean();
                    if(mtAnswer){
                        p.setMajor_trauma(mtAnswer);
                        System.out.println("It just had a car accident?");
                        Boolean carAnswer = scanner.nextBoolean();
                        if(carAnswer){
                            p.setCar_accident(carAnswer);//RULE 5
                        }else{
                            p.setCar_accident(carAnswer);//RULE 26
                        }
                    }else{
                        p.setMajor_trauma(mtAnswer);
                        System.out.println("It is vomitting?");
                        Boolean vomitAnswer = scanner.nextBoolean();
                        if(!vomitAnswer){
                            p.setVomit(vomitAnswer);//RULE 11
                        }else{
                            p.setVomit(vomitAnswer);//RULE 12
                        }
                    }
                }else{
                    
                }
            }
        }else{///////////////////////CONSCIOUS TRUE
            p.setConscious(consciousAnswer);
            System.out.println("It is dizzy? (NO, A_LOT, A_LITTLE): ");
            Dizzy dizzyAnswer = Dizzy.valueOf(scanner.next().toUpperCase());
            if(dizzyAnswer == Dizzy.A_LITTLE || dizzyAnswer == Dizzy.NO){
                p.setDizzy(dizzyAnswer);
                System.out.println("It has breathing problems?");
                DifficultyBreathing diffbreathing = DifficultyBreathing.valueOf(scanner.next().toUpperCase());
                if(diffbreathing == DifficultyBreathing.A_LOT){
                    p.setDifficulty_breathing(diffbreathing);
                    System.out.println("It emit words?");
                    EmitWords wordsAnswer = EmitWords.valueOf(scanner.next().toUpperCase());
                    if(wordsAnswer==EmitWords.SOME){
                        p.setEmit_words(wordsAnswer);
                        System.out.println("It is trying to cough?");
                        Boolean cough = scanner.nextBoolean();
                        if(cough){
                            p.setCough(cough);//RULE 8
                        }else{
                            p.setCough(cough);
                            System.out.println("It seems to be intoxicated? (true/false): ");
                            Boolean intoxicationAnswer = scanner.nextBoolean();
                            if(intoxicationAnswer){
                                p.setPossible_poisoning(intoxicationAnswer);//RULE 16
                            }else{
                                p.setPossible_poisoning(intoxicationAnswer);
                                System.out.println("It is vomiting?");
                                Boolean vomitAnswer = scanner.nextBoolean();
                                if(vomitAnswer){
                                    p.setVomit(vomitAnswer);//RULE 17
                                }else{
                                    p.setVomit(vomitAnswer);//RULE 18
                                }
                            }
                        }
                    }else{
                        p.setEmit_words(wordsAnswer);//RULE 9
                    }
                }else{
                    p.setDifficulty_breathing(diffbreathing);//RULE 21
                }
            }else{
                p.setDizzy(dizzyAnswer);
                System.out.println("It is bleeding? (NO, A_LITTLE, A_LOT): ");
                Bleeding bleeding = Bleeding.valueOf(scanner.next().toUpperCase());
                if(bleeding == Bleeding.A_LITTLE || bleeding == Bleeding.NO){
                    p.setBleeding(bleeding);//RULE 13
                }else{
                    p.setBleeding(bleeding);//RULE 14
                }
            }
        }
        return p;
    }
public static void menu() {
    Scanner scanner = new Scanner(System.in);
        boolean exit = false;
        try {
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
                int option = scanner.nextInt();
                switch (option) {
                    case 1:
                        Utilities.Auxiliar.register();
                        break;
                    case 2:
                        Utilities.Auxiliar.login();
                        break;
                    case 0:
                        System.exit(0);
                }
            } while (true);
        } catch (Exception ex) {
            Logger.getLogger(ActionSupportMedicalEmergencies.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}