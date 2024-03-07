package pojos;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import pojos.Person;
import pojos.ProtocolType;

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
        this.protocols=new HashMap(); 
        this.cardiorespiratoryArrestpeople= new HashSet<>();
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
    
    public String getTestString() {
        return testString;
    }
    public void setTestString(String testString) {
        this.testString = testString;
    }

}
