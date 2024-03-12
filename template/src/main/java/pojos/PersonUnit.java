package pojos;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class PersonUnit implements RuleUnitData {
    
    private final DataStore<Person> people;
    private final Map<ProtocolType,Protocol> protocols;
   
    private final Set<Person> cardiorespiratoryArrestpeople; //will contain person with this emergency. Adding from rules
   
    private String testString;

    public PersonUnit() {
        this(DataSource.createStore());
    }

    public PersonUnit(DataStore<Person> people) {
        this.people = people;
        this.protocols = Protocol.PROTOCOLS_MAP; // Utilizar directamente los protocolos definidos en Protocol
        this.cardiorespiratoryArrestpeople = new HashSet<>();

        // Crear instancias de Person y agregarlas a people
        Person person1 = new Person(false, false, Bleeding.NO, false, false, false);
        Person person2 = new Person(false, true, Bleeding.NO, false, false, false);
        this.people.add(person1);
        this.people.add(person2);

        // Agregar instancias de Person a cardiorespiratoryArrestpeople para ejemplo
        this.cardiorespiratoryArrestpeople.add(person1);

        // Generar la cadena de prueba
        this.testString = generateTestString();
    }

    public DataStore<Person> getPeople  () {
        return people;
    }
    
    public Map<ProtocolType,Protocol> getProtocols() {
        return this.protocols;
    }
    
    public Set<Person> getCardiorespiratoryArrestpeople() {
        return this.cardiorespiratoryArrestpeople;
    }
    
    private String generateTestString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("People: ").append(people).append(", ");
        stringBuilder.append("Protocols: ").append(protocols).append(", ");
        stringBuilder.append("Cardiorespiratory Arrest People: ").append(cardiorespiratoryArrestpeople);
        return stringBuilder.toString();
    }

    public String getTestString() {
        return testString;
    }
    public void setTestString(String testString) {
        this.testString = testString;
    }

}
