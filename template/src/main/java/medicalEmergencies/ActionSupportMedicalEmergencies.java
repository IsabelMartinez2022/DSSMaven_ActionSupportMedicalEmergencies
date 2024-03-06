/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package medicalEmergencies;

import java.util.Scanner;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import pojos.Person;

public class ActionSupportMedicalEmergencies {

   /* public static void main(String[] args) {
        System.out.println("prueba");
        KieServices ks = KieServices.Factory.get();
        KieContainer kc = ks.getKieClasspathContainer();

        execute(kc);
    }*/
/*
    public static void execute(KieContainer kc) {
        KieSession ksession = kc.newKieSession("MedicalEmergencyKS");
        Person p = new Person();
        //assignUrgency(p);
        ksession.insert(p);
        /*Person p1 = new Person(false, false, false, false, false, false, false, false, false, false, false, false, false, false, false); //primera rama empezando por derecha
        Person p2 = new Person(false, false, false, false, false, false, false, false, false, false, false, false, false, false, true);
        Person p3 = new Person(false, false, false, false, false, false, false, false, false, false, true, false, false, false, false);
        Person p4 = new Person(false, false, false, false, false, false, false, false, false, false, true, true, false, false, false);
        Person p5 = new Person(false, false, false, false, false, false, false, false, false, true, false, false, false, false, false);
        Person p6 = new Person(false, false, false, true, false, false, false, false, false, false, false, false, false, false, false);
        Person p7 = new Person(false, false, false, true, false, false, false, false, false, false, true, false, false, false, false);
        Person p8 = new Person(false, false, false, true, false, false, false, false, false, false, true, true, false, false, false);
        Person p9 = new Person(false, false, true, false, false, false, false, false, false, false, false, false, false, false, false);
        Person p10 = new Person(false, false, true, false, false, false, false, false, false, false, false, false, true, false, false);
        Person p11 = new Person(false, false, true, false, false, false, false, false, false, false, true, false, false, false, false);
        Person p12 = new Person(false, false, true, false, false, false, false, false, false, false, true, true, false, false, false);
        Person p13 = new Person(false, false, true, true, false, false, false, false, false, false, false, false, false, false, false);
        Person p14 = new Person(false, false, true, true, false, false, false, false, false, false, true, false, false, false, false);
        Person p15 = new Person(false, false, true, true, false, false, false, false, false, false, true, true, false, false, false);
        Person p16 = new Person(true, true, false, false, false, false, false, false, false, false, false, false, false, false, false);
        Person p17 = new Person(true, true, false, true, false, false, false, false, false, false, false, false, false, false, false);
        Person p18 = new Person(true, false, false, false, false, false, false, false, false, false, false, false, false, false, false);
        Person p19 = new Person(true, false, false, false, false, false, false, false, false, false, false, false, false, true, false);
        Person p20 = new Person(true, false, false, false, true, false, true, false, false, false, false, false, false, true, false);
        Person p21 = new Person(true, false, false, false, true, false, false, false, true, false, false, false, false, true, false);
        Person p22 = new Person(true, false, false, false, true, false, false, false, false, false, false, false, false, true, false);
        Person p23 = new Person(true, false, false, false, true, false, false, false, false, false, false, false, true, true, false);
        
        ksession.insert(p1);
        ksession.insert(p2);
        ksession.insert(p3);
        ksession.insert(p4);
        ksession.insert(p5);
        ksession.insert(p6);
        ksession.insert(p7);
        ksession.insert(p8);
        ksession.insert(p9);
        ksession.insert(p10);
        ksession.insert(p11);
        ksession.insert(p12);
        ksession.insert(p13);
        ksession.insert(p14);
        ksession.insert(p15);
        ksession.insert(p16);
        ksession.insert(p17);
        ksession.insert(p18);
        ksession.insert(p19);
        ksession.insert(p20);
        ksession.insert(p21);
        ksession.insert(p22);
        ksession.insert(p23);
        
        ksession.fireAllRules();
        ksession.dispose();
    }*/
    /*
    public static void assignUrgency(Person p){
        Scanner scanner = new Scanner(System.in);
        System.out.println("It is conscious?");
        boolean consciousAnswer = scanner.nextBoolean();
        if (consciousAnswer) {
            p.setUrgency(Urgency.MINOR);
            System.out.println("It is dizzy?");
            boolean dizzyAnswer = scanner.nextBoolean();
            p.setDizzy(dizzyAnswer);
            System.out.println("It is bleeding?");
            boolean bleedingAnswer = scanner.nextBoolean();
            p.setBleeding(bleedingAnswer);
            System.out.println("It has breathing problems?");
            boolean breathingPAnswer = scanner.nextBoolean();
            p.setDifficulty_breathing(breathingPAnswer);
            System.out.println("It emit words?");
            boolean wordsAnswer = scanner.nextBoolean();
            p.setEmit_words(wordsAnswer);
            System.out.println("It is trying to cough?");
            boolean coughAnswer = scanner.nextBoolean();
            p.setCough(coughAnswer);
            System.out.println("It is intoxicated?");
            boolean intoxicationAnswer = scanner.nextBoolean();
            p.setPossible_poisoning(intoxicationAnswer);
            System.out.println("It is vomitting?");
            boolean vomitAnswer = scanner.nextBoolean();
            p.setVomit(vomitAnswer);
        } else {
            System.out.println("It is breathing? (true/false): ");
            boolean breathingAnswer = scanner.nextBoolean();
            if (breathingAnswer) {
                p.setUrgency(Urgency.MEDIUM);
                System.out.println("It is bleeding?");
                boolean bleeding2Answer = scanner.nextBoolean();
                p.setBleeding(bleeding2Answer);
                System.out.println("It is a major trauma?");
                boolean mtAnswer = scanner.nextBoolean();
                p.setMajor_trauma(mtAnswer);
                System.out.println("It just had a car accident?");
                boolean carAnswer = scanner.nextBoolean();
                p.setCar_accident(carAnswer);
                System.out.println("It is vomitting?");
                boolean vomitAnswer = scanner.nextBoolean();
                p.setVomit(vomitAnswer);
            } else {
                p.setUrgency(Urgency.URGENT);
                System.out.println("It is bleeding?");
                boolean bleeding2Answer = scanner.nextBoolean();
                p.setBleeding(bleeding2Answer);
                System.out.println("It is a major trauma?");
                boolean mtAnswer = scanner.nextBoolean();
                p.setMajor_trauma(mtAnswer);
                System.out.println("It just had a car accident?");
                boolean carAnswer = scanner.nextBoolean();
                p.setCar_accident(carAnswer);
                System.out.println("It just had an electric shock?");
                boolean electricAnswer = scanner.nextBoolean();
                p.setVomit(electricAnswer);
                System.out.println("It has seizures?");
                boolean seizuresAnswer = scanner.nextBoolean();
                p.setVomit(seizuresAnswer);
            }
        }
    }*/
}