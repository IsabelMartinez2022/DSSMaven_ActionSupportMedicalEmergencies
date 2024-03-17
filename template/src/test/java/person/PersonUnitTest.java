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
import pojos.EmitWords;
import pojos.Protocol;
import pojos.ProtocolType;

/**
 *
 * @author isama
 */
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
    
    @Test
    public void testCardiorespiratoryArrest() {
    try {
        LOG.info("Running query to find cardiorespiratory arrests. Rules are also fired");
        instance.fire();
        
        // Crear una instancia de Person
        Person person = new Person();
        person.setConscious(false);
        person.setBreathing(false);
        person.setBleeding(Bleeding.NO);
        person.setElectric_shock(false);
        person.setMajor_trauma(false);
        person.setSeizure(false);
        personUnit.getPeople().add(person);
        
        // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio
        Protocol cardioArrestProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST);
        // Asignar el protocolo a la persona
        person.setProtocol(cardioArrestProtocol);

        // Realizar aserciones basadas en el contenido de person
        assertFalse(person.getConscious());
        assertFalse(person.getBreathing());
        assertEquals(Bleeding.NO, person.getBleeding());
        assertFalse(person.getElectric_shock());
        assertFalse(person.getMajor_trauma());
        assertFalse(person.getSeizure());

        // Verificar que la persona tiene el protocolo adecuado asignado
        assertEquals(ProtocolType.CARDIOARREST, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }
    
    @Test
    public void testCardiorespiratoryArrestByElectricShock() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests by electric shock. Rules are also fired");
            instance.fire();

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(false);
            person.setBleeding(Bleeding.NO);
            person.setElectric_shock(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio por electrocución
            Protocol cardioArrestElectrocutionProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_ELECTROCUTION);
            // Asignar el protocolo a la persona
            person.setProtocol(cardioArrestElectrocutionProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertFalse(person.getBreathing());
            assertEquals(Bleeding.NO, person.getBleeding());
            assertTrue(person.getElectric_shock());

            // Verificar que la persona tiene el protocolo adecuado asignado
            assertEquals(ProtocolType.CARDIOARREST_ELECTROCUTION, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testCardiorespiratoryArrestWithMajorTrauma() {
        try {
            LOG.info("Running query to find cardiorespiratory arrests with major trauma. Rules are also fired");
            instance.fire();

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(false);
            person.setBleeding(Bleeding.NO);
            person.setElectric_shock(false);
            person.setMajor_trauma(true); 
            person.setSeizure(false);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio con trauma mayor
            Protocol cardioArrestMajorTraumaProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_MAJORTRAUMA);
            // Asignar el protocolo a la persona
            person.setProtocol(cardioArrestMajorTraumaProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertFalse(person.getBreathing());
            assertEquals(Bleeding.NO, person.getBleeding());
            assertFalse(person.getElectric_shock());
            assertTrue(person.getMajor_trauma()); 
            assertFalse(person.getSeizure());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(false);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(false);
 
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio y sangrado
            Protocol cardioArrestBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING);
            // Asignar el protocolo a la persona
            person.setProtocol(cardioArrestBleedingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertFalse(person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding()); 
            assertFalse(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
            assertEquals(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testMajorTraumaByCarAccident() {
        try {
            LOG.info("Running query to find major trauma by car accident. Rules are also fired");
            instance.fire();

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(true); 
            person.setBleeding(Bleeding.NO);
            person.setMajor_trauma(true); 
            person.setCar_accident(true); 
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de trauma mayor por accidente automovilístico
            Protocol carProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CAR);
            // Asignar el protocolo a la persona
            person.setProtocol(carProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertTrue(person.getBreathing()); 
            assertEquals(Bleeding.NO, person.getBleeding());
            assertTrue(person.getMajor_trauma()); 
            assertTrue(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(false);
            person.setBleeding(Bleeding.A_LITTLE); // Opcional, pero si se establece, debe ser Bleeding.A_LITTLE o Bleeding.NO
            person.setElectric_shock(false);
            person.setMajor_trauma(true);
            person.setCar_accident(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio con trauma mayor por accidente automovilístico
            Protocol cardioArrestCarProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_CAR);
            // Asignar el protocolo a la persona
            person.setProtocol(cardioArrestCarProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertFalse(person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); // Opcional, pero si se establece, debe ser Bleeding.A_LITTLE o Bleeding.NO
            assertFalse(person.getElectric_shock());
            assertTrue(person.getMajor_trauma());
            assertTrue(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
            assertEquals(ProtocolType.CARDIOARREST_CAR, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testCardiorespiratoryArrestCarAccidentBleeding() {
        try {
            LOG.info("Running query to find cardiorespiratory arrest by car accident and bleeding. Rules are also fired");
            instance.fire();

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(false);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio por accidente automovilístico y sangrado
            Protocol cardioArrestCarBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST_CAR_BLEEDING);
            // Asignar el protocolo a la persona
            person.setProtocol(cardioArrestCarBleedingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertFalse(person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding());
            assertTrue(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.NO);
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(EmitWords.SOME);
            person.setCough(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de obstrucción parcial de las vías respiratorias
            Protocol partialChokingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.PARTIAL_CHOKING);
            // Asignar el protocolo a la persona
            person.setProtocol(partialChokingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.NO, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertEquals(EmitWords.SOME, person.getEmit_words());
            assertTrue(person.getCough());

            // Verificar que la persona tiene el protocolo adecuado asignado
            assertEquals(ProtocolType.PARTIAL_CHOKING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

    @Test
    public void testTotalChoking() {
        try {
            LOG.info("Running query to find total airway blockage. Rules are also fired");
            instance.fire();

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.NO);
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(EmitWords.NONE);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de obstrucción total de las vías respiratorias
            Protocol totalChokingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.TOTAL_CHOKING);
            // Asignar el protocolo a la persona
            person.setProtocol(totalChokingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.NO, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertEquals(EmitWords.NONE, person.getEmit_words());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LOT);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la emergencia de ataque al corazón
            Protocol heartAttackProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.HEART_ATTACK);
            // Asignar el protocolo a la persona
            person.setProtocol(heartAttackProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LOT, person.getChest_pain());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(true);
            person.setBleeding(Bleeding.A_LITTLE); 
            person.setMajor_trauma(false);
            person.setVomit(false);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el desmayo sin vómito
            Protocol faintingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.FAINTING);
            // Asignar el protocolo a la persona
            person.setProtocol(faintingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertTrue(person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 
            assertFalse(person.getMajor_trauma());
            assertFalse(person.getVomit());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(true);
            person.setBleeding(Bleeding.A_LITTLE); 
            person.setMajor_trauma(false);
            person.setVomit(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el desmayo con vómito
            Protocol faintingVomitProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.FAINTING_VOMIT);
            // Asignar el protocolo a la persona
            person.setProtocol(faintingVomitProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertTrue(person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 
            assertFalse(person.getMajor_trauma());
            assertTrue(person.getVomit());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.A_LOT);
            person.setBleeding(Bleeding.A_LITTLE); 
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el mareo
            Protocol dizzinessProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.DIZZINESS);
            // Asignar el protocolo a la persona
            person.setProtocol(dizzinessProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.A_LOT, person.getDizzy());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.NO);
            person.setDizzy(Dizzy.A_LOT);
            person.setBleeding(Bleeding.A_LOT);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el sangrado grave mientras está consciente
            Protocol severeBleedingConsciousProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CONS_SEVERE_BLEEDING);
            // Asignar el protocolo a la persona
            person.setProtocol(severeBleedingConsciousProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.NO, person.getChest_pain());
            assertEquals(Dizzy.A_LOT, person.getDizzy());
            assertEquals(Bleeding.A_LOT, person.getBleeding());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(false);
            person.setBleeding(Bleeding.A_LITTLE);
            person.setElectric_shock(false);
            person.setMajor_trauma(false);
            person.setSeizure(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la convulsión
            Protocol seizureProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.SEIZURE);
            // Asignar el protocolo a la persona
            person.setProtocol(seizureProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertFalse(person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding());
            assertFalse(person.getElectric_shock());
            assertFalse(person.getMajor_trauma());
            assertTrue(person.getSeizure());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE);
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(EmitWords.SOME);
            person.setCough(false);
            person.setPossible_poisoning(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la intoxicación
            Protocol poisoningProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.POISONING);
            // Asignar el protocolo a la persona
            person.setProtocol(poisoningProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertEquals(EmitWords.SOME, person.getEmit_words());
            assertFalse(person.getCough());
            assertTrue(person.getPossible_poisoning());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE);
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(EmitWords.SOME);
            person.setCough(false);
            person.setPossible_poisoning(false);
            person.setVomit(false);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la anafilaxia sin vómito
            Protocol anaphylaxisNoVomitProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.ANAPHYLAXIS);
            // Asignar el protocolo a la persona
            person.setProtocol(anaphylaxisNoVomitProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy());
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertEquals(EmitWords.SOME, person.getEmit_words());
            assertFalse(person.getCough());
            assertFalse(person.getPossible_poisoning());
            assertFalse(person.getVomit());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE); 
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LOT);
            person.setEmit_words(EmitWords.SOME);
            person.setCough(false);
            person.setPossible_poisoning(false);
            person.setVomit(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para la anafilaxia con vómito
            Protocol anaphylaxisVomitProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.ANAPHYLAXIS_VOMIT);
            // Asignar el protocolo a la persona
            person.setProtocol(anaphylaxisVomitProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LOT, person.getDifficulty_breathing());
            assertEquals(EmitWords.SOME, person.getEmit_words());
            assertFalse(person.getCough());
            assertFalse(person.getPossible_poisoning());
            assertTrue(person.getVomit());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE); 
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LITTLE); 
            person.setCommunication_problems(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el accidente cerebrovascular
            Protocol strokeProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.STROKE);
            // Asignar el protocolo a la persona
            person.setProtocol(strokeProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain()); 
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LITTLE, person.getDifficulty_breathing()); 
            assertTrue(person.getCommunication_problems());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(true);
            person.setChest_pain(ChestPain.A_LITTLE); 
            person.setDizzy(Dizzy.A_LITTLE); 
            person.setDifficulty_breathing(DifficultyBreathing.A_LITTLE); 
            person.setCommunication_problems(false);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para cuando no se encuentra emergencia médica
            Protocol noEmergencyFoundProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.NOEMERGENCYFOUND);
            // Asignar el protocolo a la persona
            person.setProtocol(noEmergencyFoundProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertTrue(person.getConscious());
            assertEquals(ChestPain.A_LITTLE, person.getChest_pain());
            assertEquals(Dizzy.A_LITTLE, person.getDizzy()); 
            assertEquals(DifficultyBreathing.A_LITTLE, person.getDifficulty_breathing()); 
            assertFalse(person.getCommunication_problems());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(true);
            person.setBleeding(Bleeding.A_LITTLE);
            person.setMajor_trauma(true);
            person.setCar_accident(false);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el trauma mayor
            Protocol majorTraumaProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.MAJOR_TRAUMA);
            // Asignar el protocolo a la persona
            person.setProtocol(majorTraumaProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertTrue(person.getBreathing());
            assertEquals(Bleeding.A_LITTLE, person.getBleeding()); 
            assertTrue(person.getMajor_trauma());
            assertFalse(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(true);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(false);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el trauma mayor con sangrado
            Protocol majorTraumaBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.MAJOR_TRAUMA_BLEEDING);
            // Asignar el protocolo a la persona
            person.setProtocol(majorTraumaBleedingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertTrue(person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding());
            assertFalse(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
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

            // Crear una instancia de Person
            Person person = new Person();
            person.setConscious(false);
            person.setBreathing(true);
            person.setBleeding(Bleeding.A_LOT);
            person.setCar_accident(true);
            personUnit.getPeople().add(person);

            // Obtener el protocolo adecuado para el trauma mayor por accidente automovilístico con sangrado
            Protocol carAccidentBleedingProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CAR_BLEEDING);
            // Asignar el protocolo a la persona
            person.setProtocol(carAccidentBleedingProtocol);

            // Realizar aserciones basadas en el contenido de person
            assertFalse(person.getConscious());
            assertTrue(person.getBreathing());
            assertEquals(Bleeding.A_LOT, person.getBleeding());
            assertTrue(person.getCar_accident());

            // Verificar que la persona tiene el protocolo adecuado asignado
            assertEquals(ProtocolType.CAR_BLEEDING, person.getProtocol().getType());

        } finally {
            instance.close();
        }
    }

}