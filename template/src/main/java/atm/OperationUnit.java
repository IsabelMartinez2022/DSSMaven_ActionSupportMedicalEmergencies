package atm;

import java.util.HashSet;
import java.util.Set;

import dss.Measurement;
import org.drools.ruleunits.api.DataSource;
import org.drools.ruleunits.api.DataStore;
import org.drools.ruleunits.api.RuleUnitData;

public class OperationUnit implements RuleUnitData {

    private final DataStore<Operation> operations;

    public OperationUnit() {
        this(DataSource.createStore());
    }

    public OperationUnit(DataStore<Operation> operations) {
        this.operations = operations;
    }

    public DataStore<Operation> getOperations() {
        return operations;
    }


}
