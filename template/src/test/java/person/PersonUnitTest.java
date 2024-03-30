/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import pojos.Person;
import pojos.PersonUnit;

import org.drools.ruleunits.api.RuleUnitProvider;
import org.drools.ruleunits.api.RuleUnitInstance;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Before;
import pojos.Bleeding;
import pojos.ChestPain;
import pojos.DifficultyBreathing;
import pojos.Dizzy;
import pojos.Protocol;
import pojos.ProtocolType;
import pojos.Breathing;

public class PersonUnitTest {

    static final Logger LOG = LoggerFactory.getLogger(PersonUnitTest.class);

    PersonUnit personUnit;
    RuleUnitInstance<PersonUnit> instance;
    /**
     * This method will be run before EACH single test. If we want to have common code for all tests we can use @BeforeClass
     * In this case, the creations of the facts (operations) and the insertion in each instance will be common to each test, but they should be
     * run before each test, otherwise the instance will have already trigger/fire its rules so they will not be run apart from the first test if
     * the facts do not change (refractoriness).
     */
    @Before
    public void setUp() {
        LOG.info("Creating RuleUnit");
        personUnit = new PersonUnit();
        instance = RuleUnitProvider.get().createRuleUnitInstance(personUnit);
        LOG.info("Insert data");
    }
    
    /*
    THE TESTS COMMENTED ARE THE ONES THAT WE CREATED IN A WRONG WAY SO WE CAN 
    SEE IT THEY WORK OR NOT
    THEY NEED TO BE COMMENTED SO THE JAR FILE CAN WORK
    */
    
    @Test
    public void testCardiorespiratoryArrest() {
    try {
        LOG.info("Running query to find cardiorespiratory arrests. Rules are also fired");
        instance.fire();
        
        // Creates an instance of Person
        Person person = new Person();
        person.setConscious(false);
        person.setBreathing(Breathing.NO);
        person.setBleeding(Bleeding.NO);
        person.setElectric_shock(false);
        person.setMajor_trauma(false);
        person.setSeizure(false);
        personUnit.getPeople().add(person);
        
        // Obtains the protocol suitable for cardiorespiratoryarrest emergency
        Protocol cardioArrestProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST);
        //Assign the protocol to the person
        person.setProtocol(cardioArrestProtocol);

        // Makes assertions based on the person information
        assertFalse(person.getConscious());
        assertEquals(Breathing.NO, person.getBreathing());
        assertEquals(Bleeding.NO, person.getBleeding());
        assertFalse(person.getElectric_shock());
        assertFalse(person.getMajor_trauma());
        assertFalse(person.getSeizure());

        // Verify that the person has the proper protocol assigned 
        assertEquals(ProtocolType.CARDIOARREST, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    /*@Test
    public void testCardiorespiratoryArrestBad() {
    try {
        LOG.info("Running query to find cardiorespiratory arrests. Rules are also fired");
        instance.fire();
        
        // Creates an instance of Person
        Person person = new Person();
        person.setConscious(true); //should be false
        person.setBreathing(Breathing.NO);
        person.setBleeding(Bleeding.A_LOT); //should be No o A_Little
        person.setElectric_shock(false);
        person.setMajor_trauma(true); //should be false
        person.setSeizure(false);
        personUnit.getPeople().add(person);
        
        // Obtains the protocol suitable for cardiorespiratory arrest emergency
        Protocol cardioArrestProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST);
        //Assign the protocol to the person
        person.setProtocol(cardioArrestProtocol);

       // Makes assertions based on the person information
        assertFalse(person.getConscious());
        assertEquals(Breathing.NO, person.getBreathing());
        assertEquals(Bleeding.NO, person.getBleeding());
        assertFalse(person.getElectric_shock());
        assertFalse(person.getMajor_trauma());
        assertFalse(person.getSeizure());

        // Verify that the person has the proper protocol assigned
        assertEquals(ProtocolType.CARDIOARREST, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }*/
    
    @Test
    public void testCardiorespiratoryArrestByElectricShock() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests by electric shock. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.NO);
            person.setElectric_shock(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratoryarreste by electric shock emergency
            Protocol cardioArrestElectrocutionProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_ELECTROCUTION);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestElectrocutionProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO, person.getBreathing());
            assertEquals(Bleeding.NO, person.getBleeding());
            assertTrue(person.getElectric_shock());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_ELECTROCUTION, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    /*@Test
    public void testCardiorespiratoryArrestByElectricShockBad() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests by electric shock. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.A_LOT); //should be  No o A_Litle
            person.setElectric_shock(false); //should be  true
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratory arrest by electric shock
            Protocol cardioArrestElectrocutionProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_ELECTROCUTION);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestElectrocutionProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO, person.getBreathing());
            assertEquals(Bleeding.NO, person.getBleeding());
            assertTrue(person.getElectric_shock());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_ELECTROCUTION, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }*/

    @Test
    public void testCardiorespiratoryArrestWithMajorTrauma() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests with major trauma. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.NO);
            person.setElectric_shock(false);
            person.setMajor_trauma(true); 
            person.setSeizure(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratory arrest by major trauma
            Protocol cardioArrestMajorTraumaProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_MAJORTRAUMA);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestMajorTraumaProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO,person.getBreathing());
            assertEquals(Bleeding.NO, person.getBleeding());
            assertFalse(person.getElectric_shock());
            assertTrue(person.getMajor_trauma()); 
            assertFalse(person.getSeizure());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_MAJORTRAUMA, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testCardiorespiratoryArrestAndBleeding() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests and bleeding. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(false);
 
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratoryarrest and bleeding
            Protocol cardioArrestBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestBleedingProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO,person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding()); 
            assertFalse(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    /*@Test
    public void testCardiorespiratoryArrestAndBleedingBad() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests and bleeding. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true); //should be  false
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(true);  //should be  false
 
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratoryarrest and bleeding
            Protocol cardioArrestBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestBleedingProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO,person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding()); 
            assertFalse(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }*/

    @Test
    public void testMajorTraumaByCarAccident() {
        try {
            LOG.info("Running query to find major trauma by car accident. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.YES); 
            person.setBleeding(Bleeding.NO);
            person.setMajor_trauma(true); 
            person.setCar_accident(true); 
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for major trauma by car accident
            Protocol carProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CAR);
            //Assign the protocol to the person
            person.setProtocol(carProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.YES, person.getBreathing()); 
            assertEquals(Bleeding.NO, person.getBleeding());
            assertTrue(person.getMajor_trauma()); 
            assertTrue(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CAR, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    @Test
    public void testCardiorespiratoryArrestCarAccident() {
        try {
            LOG.info("Running query to find cardiorespiratory arrest with major trauma by car accident. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.A_LITTLE); // Optional, but it should be Bleeding.A_LITTLE or Bleeding.NO
            person.setElectric_shock(false);
            person.setMajor_trauma(true);
            person.setCar_accident(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratory arrest by car accident
            Protocol cardioArrestCarProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_CAR);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestCarProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO, person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); // optional, but it should be Bleeding.A_LITTLE o Bleeding.NO
            assertFalse(person.getElectric_shock());
            assertTrue(person.getMajor_trauma());
            assertTrue(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_CAR, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    /*@Test
    public void testCardiorespiratoryArrestCarAccidentBad() {
        try {
            LOG.info("Running query to find cardiorespiratory arrest with major trauma by car accident. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.A_LITTLE); 
            person.setElectric_shock(true); //should be  false
            person.setMajor_trauma(false); //should be  true
            person.setCar_accident(false); //should be  true
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratory arrest by car accident
            Protocol cardioArrestCarProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_CAR);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestCarProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO, person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); // Optional, but it should be Bleeding.A_LITTLE or Bleeding.NO
            assertFalse(person.getElectric_shock());
            assertTrue(person.getMajor_trauma());
            assertTrue(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_CAR, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }*/

    
    @Test
    public void testCardiorespiratoryArrestCarAccidentBleeding() {
        try {
            LOG.info("Running query to find cardiorespiratory arrest by car accident and bleeding. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.NO);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for cardiorespiratory arrest by car accident and bleeding
            Protocol cardioArrestCarBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_CAR_BLEEDING);
            //Assign the protocol to the person
            person.setProtocol(cardioArrestCarBleedingProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.NO, person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding());
            assertTrue(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CARDIOARREST_CAR_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testPartialChoking() {
        try {
            LOG.info("Running query to find partial airway blockage. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.NO);
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(true);
            person.setCough(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for partial obstruction of air way
            Protocol partialChokingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.PARTIAL_CHOKING);
            //Assign the protocol to the person
            person.setProtocol(partialChokingProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.NO, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertTrue( person.getEmit_words());
            assertTrue(person.getCough());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.PARTIAL_CHOKING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    /*@Test
    public void testPartialChokingBad() {
        try {
            LOG.info("Running query to find partial airway blockage. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.A_LOT); //should be  NO o A_Little
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(false); //should be  true
            person.setCough(false); //should be  true
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for partial obstruction of air way
            Protocol partialChokingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.PARTIAL_CHOKING);
            //Assign the protocol to the person
            person.setProtocol(partialChokingProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.NO, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertTrue(person.getEmit_words());
            assertTrue(person.getCough());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.PARTIAL_CHOKING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }*/

    @Test
    public void testTotalChoking() {
        try {
            LOG.info("Running query to find total airway blockage. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.NO);
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for total obstruction of air way
            Protocol totalChokingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.TOTAL_CHOKING);
            //Assign the protocol to the person
            person.setProtocol(totalChokingProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.NO, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertFalse(person.getEmit_words());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.TOTAL_CHOKING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testHeartAttack() {
        try {
            LOG.info("Running query to find heart attack. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LOT);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for heart attack
            Protocol heartAttackProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.HEART_ATTACK);
            //Assign the protocol to the person
            person.setProtocol(heartAttackProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LOT, person.getChest_pain());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.HEART_ATTACK, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    @Test
    public void testFaintingNoVomit() {
        try {
            LOG.info("Running query to find fainting without vomit. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.YES);
            person.setBleeding(Bleeding.A_LITTLE); 
            person.setMajor_trauma(false);
            person.setVomit(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for fainting without vomit
            Protocol faintingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.FAINTING);
            //Assign the protocol to the person
            person.setProtocol(faintingProtocol);

            //Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.YES, person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 
            assertFalse(person.getMajor_trauma());
            assertFalse(person.getVomit());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.FAINTING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    @Test
    public void testFaintingVomit() {
        try {
            LOG.info("Running query to find fainting with vomit. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.YES);
            person.setBleeding(Bleeding.A_LITTLE); 
            person.setMajor_trauma(false);
            person.setVomit(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for fainting with vomit
            Protocol faintingVomitProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.FAINTING_VOMIT);
            //Assign the protocol to the person
            person.setProtocol(faintingVomitProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.YES, person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 
            assertFalse(person.getMajor_trauma());
            assertTrue(person.getVomit());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.FAINTING_VOMIT, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testDizziness() {
        try {
            LOG.info("Running query to find dizziness. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.A_LOT);
            person.setBleeding(Bleeding.A_LITTLE); 
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for dizziness
            Protocol dizzinessProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.DIZZINESS);
            //Assign the protocol to the person
            person.setProtocol(dizzinessProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.A_LOT, person.getDizzy());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.DIZZINESS, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    @Test
    public void testSevereBleedingConscious() {
        try {
            LOG.info("Running query to find severe bleeding while conscious. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.A_LOT);
            person.setBleeding(Bleeding.A_LOT);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for heavy bleeding while conscious
            Protocol severeBleedingConsciousProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CONS_SEVERE_BLEEDING);
            //Assign the protocol to the person
            person.setProtocol(severeBleedingConsciousProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.A_LOT, person.getDizzy());
            assertEquals(Bleeding.A_LOT, person.getBleeding());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CONS_SEVERE_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testSeizure() {
        try {
            LOG.info("Running query to find seizure. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.UNABLE_TO_CHECK);
            person.setBleeding(Bleeding.A_LITTLE);
            person.setElectric_shock(false);
            person.setMajor_trauma(false);
            person.setSeizure(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for seizure
            Protocol seizureProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.SEIZURE);
            //Assign the protocol to the person
            person.setProtocol(seizureProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.UNABLE_TO_CHECK,person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding());
            assertFalse(person.getElectric_shock());
            assertFalse(person.getMajor_trauma());
            assertTrue(person.getSeizure());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.SEIZURE, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testPoisoning() {
        try {
            LOG.info("Running query to find poisoning. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE);
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(true);
            person.setCough(false);
            person.setPossible_poisoning(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for poisoning
            Protocol poisoningProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.POISONING);
            //Assign the protocol to the person
            person.setProtocol(poisoningProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertTrue(person.getEmit_words());
            assertFalse(person.getCough());
            assertTrue(person.getPossible_poisoning());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.POISONING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testAnaphylaxisNoVomit() {
        try {
            LOG.info("Running query to find anaphylaxis without vomit. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE);
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(true);
            person.setCough(false);
            person.setPossible_poisoning(false);
            person.setVomit(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for anaphylaxis without vomit
            Protocol anaphylaxisNoVomitProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.ANAPHYLAXIS);
            //Assign the protocol to the person
            person.setProtocol(anaphylaxisNoVomitProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertTrue(person.getEmit_words());
            assertFalse(person.getCough());
            assertFalse(person.getPossible_poisoning());
            assertFalse(person.getVomit());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.ANAPHYLAXIS, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testAnaphylaxisVomit() {
        try {
            LOG.info("Running query to find anaphylaxis with vomit. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE); 
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(true);
            person.setCough(false);
            person.setPossible_poisoning(false);
            person.setVomit(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for anaphylaxis with vomit
            Protocol anaphylaxisVomitProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.ANAPHYLAXIS_VOMIT);
            //Assign the protocol to the person
            person.setProtocol(anaphylaxisVomitProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertTrue(person.getEmit_words());
            assertFalse(person.getCough());
            assertFalse(person.getPossible_poisoning());
            assertTrue(person.getVomit());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.ANAPHYLAXIS_VOMIT, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testStroke() {
        try {
            LOG.info("Running query to find stroke. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE); 
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LITTLE); 
            person.setCommunication_problems(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for a stroke
            Protocol strokeProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.STROKE);
            //Assign the protocol to the person
            person.setProtocol(strokeProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LITTLE, person.getDifficulty_breathing()); 
            assertTrue(person.getCommunication_problems());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.STROKE, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testNoEmergencyFound() {
        try {
            LOG.info("Running query to find no medical emergency found. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE); 
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LITTLE); 
            person.setCommunication_problems(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable when there is no emergency
            Protocol noEmergencyFoundProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.NOEMERGENCYFOUND);
            //Assign the protocol to the person
            person.setProtocol(noEmergencyFoundProtocol);

            // Makes assertions based on the person information
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain());
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LITTLE, person.getDifficulty_breathing()); 
            assertFalse(person.getCommunication_problems());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.NOEMERGENCYFOUND, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testMajorTrauma() {
        try {
            LOG.info("Running query to find major trauma. Rules are also fired");
            instance.fire();

            // Creates an instance of Personn
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.YES);
            person.setBleeding(Bleeding.A_LITTLE);
            person.setMajor_trauma(true);
            person.setCar_accident(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for major trauma
            Protocol majorTraumaProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.MAJOR_TRAUMA);
            //Assign the protocol to the person
            person.setProtocol(majorTraumaProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.YES, person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 
            assertTrue(person.getMajor_trauma());
            assertFalse(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.MAJOR_TRAUMA, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    @Test
    public void testMajorTraumaBleeding() {
        try {
            LOG.info("Running query to find major trauma and bleeding. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.YES);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(false);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for major trauma and bleeding
            Protocol majorTraumaBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.MAJOR_TRAUMA_BLEEDING);
            //Assign the protocol to the person
            person.setProtocol(majorTraumaBleedingProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.YES, person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding());
            assertFalse(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.MAJOR_TRAUMA_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testCarAccidentBleeding() {
        try {
            LOG.info("Running query to find major trauma by car accident and bleeding. Rules are also fired");
            instance.fire();

            // Creates an instance of Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(Breathing.YES);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(true);
            personUnit.getPeople().add(person);

            // Obtains the protocol suitable for a car accident and bleeding
            Protocol carAccidentBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CAR_BLEEDING);
            //Assign the protocol to the person
            person.setProtocol(carAccidentBleedingProtocol);

            // Makes assertions based on the person information
            assertFalse(person.getConscious());
            assertEquals(Breathing.YES, person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding());
            assertTrue(person.getCar_accident());

            // Verify that the person has the proper protocol assigned
            assertEquals(ProtocolType.CAR_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

}