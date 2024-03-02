package pojos;

import atm.*;
import java.util.HashSet;
import java.util.Set;

import dss.Measurement;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;
import pojos.Person;

public class PersonUnit implements RuleUnitData {

   private final DataStore<Person> people;

    public PersonUnit() {
        this(DataSource.createStore());
    }

    public PersonUnit(DataStore<Person> people) {
        this.people = people;
    }

    public DataStore<Person> getPeople  () {
        return people;
    }


}
