/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package person;

import java.util.Set;
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

/**
 *
 * @author isama
 */
public class PersonUnitTest {

    static final Logger LOG = LoggerFactory.getLogger(PersonUnitTest.class);

    PersonUnit personUnit;
    RuleUnitInstance<PersonUnit> instance;
    Person person1, person2;
    
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
        person1 = new Person(false, false, Bleeding.NO, false, false, false);
        person2 = new Person(false, true, Bleeding.NO, false, false, false);

        personUnit.getPeople().add(person1);
        personUnit.getPeople().add(person2);
        // instance.close() should not be instantiated because it will be used in each test!
    }
    
    /*
    @Test Prueba Alberto
    public void whatever() {
        instance.fire();
    }
    */
/*
    @Test Prueba Isabel
    public void testCardiorespiratoryArrest() {
        try {
            LOG.info("Run query to find cardiorespiratory arrests. Rules are also fired");
            instance.fire();
            Set<Person> cardiorespiratoryArrest = personUnit.getCardiorespiratoryArrestpeople();
            assertEquals(1, cardiorespiratoryArrest.size());
            assertTrue(cardiorespiratoryArrest.contains(person1));
            //assertTrue("contains protocol1", cardiorespiratoryArrest.get(0).getProtocol().equals(PROTOCOLS_MAP.get(ProtocolType.CARDIO_ARREST)));
        
            System.out.println(personUnit.getTestString());
        } finally {
            instance.close();
        }
    }  
    */
    /*@Test Prueba1 Martina
    public void testCardiorespiratoryArrest() {
        try {
            LOG.info("Run query to find cardiorespiratory arrests. Rules are also fired");
            instance.fire();
            Set<Person> cardiorespiratoryArrest = personUnit.getCardiorespiratoryArrestpeople();
            assertEquals(1, cardiorespiratoryArrest.size());
            assertTrue(cardiorespiratoryArrest.contains(person1));
            
            // Realizar aserciones basadas en el contenido de person1
            assertFalse(person1.isConscious()); 
            assertFalse(person1.isBreathing());
            assertEquals(Bleeding.NO, person1.getBleeding());
            assertFalse(person1.isElectric_shock()); 
            assertFalse(person1.isMajor_trauma());
            assertFalse(person1.isSeizure()); 

            // Finalmente, imprimir la cadena de prueba (testString)
            System.out.println(personUnit.getTestString());
        } finally {
            instance.close();
        }
    }*/
    
        @Test
        public void testCardiorespiratoryArrest() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests. Rules are also fired");
            instance.fire();

            // Verificar que hay al menos una persona en paro cardiorrespiratorio
            Set<Person> cardiorespiratoryArrest = personUnit.getCardiorespiratoryArrestpeople();
            assertTrue("Expected at least one person in cardiorespiratory arrest", !cardiorespiratoryArrest.isEmpty());

            // Realizar aserciones basadas en el contenido de person1 (primer elemento en cardiorespiratoryArrest)
            Person person1 = cardiorespiratoryArrest.iterator().next();
            assertFalse(person1.getConscious()); 
            assertFalse(person1.getBreathing());
            assertEquals(Bleeding.NO, person1.getBleeding());
            assertFalse(person1.getElectric_shock()); 
            assertFalse(person1.getMajor_trauma());
            assertFalse(person1.getSeizure()); 

            // Finalmente, imprimir la cadena de prueba (testString)
            System.out.println(personUnit.getTestString());
        } finally {
            instance.close();
        }
    }
}