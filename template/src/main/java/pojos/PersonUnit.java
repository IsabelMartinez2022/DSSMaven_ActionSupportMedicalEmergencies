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

    public PersonUnit() {
        this(DataSource.createStore());
    }

    public PersonUnit(DataStore<Person> people) {
        this.people = people;
        this.protocols = Protocol.PROTOCOLS_MAP; // Utilizar directamente los protocolos definidos en Protocol
    }

    public DataStore<Person> getPeople  () {
        return people;
    }
    
    public Map<ProtocolType,Protocol> getProtocols() {
        return this.protocols;
    }

}
