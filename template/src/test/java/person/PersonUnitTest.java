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

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.junit.Before;
import pojos.Bleeding;
import pojos.ProtocolType;

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
        //person1 = new Person(false, false, Bleeding.NO, false, false, false);
        //person2 = new Person(false, true, Bleeding.NO, false, false, false);

        //personUnit.getPeople().add(person1);
        //personUnit.getPeople().add(person2);
        // instance.close() should not be instantiated because it will be used in each test!
    }
    
    // Test para la regla "Cardiorrespiratory Arrest"
    @Test
    public void testCardiorespiratoryArrest() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests. Rules are also fired");
            instance.fire();

            // Realizar aserciones basadas en el contenido de person1 (primer elemento en cardiorespiratoryArrest)
            assertFalse(person1.getConscious());
            assertFalse(person1.getBreathing());
            assertEquals(Bleeding.NO, person1.getBleeding());
            assertFalse(person1.getElectric_shock());
            assertFalse(person1.getMajor_trauma());
            assertFalse(person1.getSeizure());

            // Verificar que la persona tiene el protocolo adecuado asignado
            assertEquals(ProtocolType.CARDIOARREST, person1.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
}