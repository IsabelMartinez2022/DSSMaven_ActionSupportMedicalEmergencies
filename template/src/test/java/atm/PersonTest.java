package atm;


import dss.Measurement;
import dss.MeasurementUnit;
import dss.RuleTest;
import org.drools.ruleunits.api.RuleUnitProvider;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import pojos.PersonUnit;


public class PersonTest {


     static final Logger LOG = LoggerFactory.getLogger(PersonTest.class);

    @Test
    public void test() {
        LOG.info("Creating RuleUnit");
        PersonUnit pUnit = new PersonUnit();

        RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(pUnit);
        try {
            LOG.info("Insert data");
            /*Person p1 = new Person(1, true, false, true, Tries.EXPIRED, 100, 1000, 500);
            Person p2 = new Person(2, true, false, true, Tries.NOT_EXPIRED, 100, 1000, 500);
            Person p3 = new Person(3, true, false, true, Tries.NOT_EXPIRED, 1000, 100, 500);
            Person p4 = new Person(4, true, false, true, Tries.NOT_EXPIRED, 1000, 10000, 500);
            Person p5 = new Person(5, true, true, true, Tries.EXPIRED, 100, 1000, 500);
            Person p6 = new Person(6, false, true, true, Tries.NOT_EXPIRED, 100, 1000, 500);
            Person p7 = new Person(6, false, true, true, Tries.NOT_EXPIRED, 100, 1000, 500);*/

            /*pUnit.getPeople().add(p1);
            pUnit.getPeople().add(p2);
            pUnit.getPeople().add(p3);
            pUnit.getPeople().add(p4);
            pUnit.getPeople().add(p5);
            pUnit.getPeople().add(p6);
            pUnit.getPeople().add(p7);*/

            LOG.info("Run query. Rules are also fired");
            //instance.fire();
            //List<Person> authorizedOperations = instance.executeQuery("FindAuthorizedOperations").toList("$operations");
            //assertEquals(1, authorizedOperations.size());
            //assertEquals(p3, authorizedOperations.get(0));


        } finally {
            //instance.close();
        }
    }

}