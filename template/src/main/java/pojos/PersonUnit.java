package pojos;

import java.util.HashSet;
import java.util.Set;

import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import pojos.Person;

public class PersonUnit implements RuleUnitData {

   private final DataStore<Person> people;
   
   private final Map<Protocol> protocols;

    public PersonUnit() {
        this(DataSource.createStore());
        protocols = Protocol.PROTOCOLS_MAP;
    }

    public PersonUnit(DataStore<Person> people) {
        this.people = people;
    }

    public DataStore<Person> getPeople  () {
        return people;
    }


}
