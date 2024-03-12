/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Protocol {
    private int id;
    public static final Map<ProtocolType, Protocol> PROTOCOLS_MAP = new HashMap<>();

    private ProtocolType type;
    private List<Action> actions;

    public Protocol(ProtocolType type, List<Action> actions) {
        this.type = type;
        this.actions = actions;
    }

    public ProtocolType getType() {
        return type;
    }

    public List<Action> getActions() {
        return actions;
    }

    static {
        List<Action> cardioArrestActions = new LinkedList<>();
        cardioArrestActions.add(new Action(ActionType.CALL_112));
        cardioArrestActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestProtocol = new Protocol(ProtocolType.CARDIO_ARREST, cardioArrestActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIO_ARREST, cardioArrestProtocol);

        List<Action> electrocutionActions = new LinkedList<>();
        electrocutionActions.add(new Action(ActionType.BURNS_PROCEDURE));
        electrocutionActions.add(new Action(ActionType.CALL_112));
        electrocutionActions.add(new Action(ActionType.PERFORM_CPR));
        electrocutionActions.add(new Action(ActionType.USE_AED));
        Protocol electrocutionProtocol = new Protocol(ProtocolType.ELECTROCUTION_NO_BURN, electrocutionActions);
        PROTOCOLS_MAP.put(ProtocolType.ELECTROCUTION_NO_BURN, electrocutionProtocol);

        List<Action> majorTraumaActions = new LinkedList<>();
        majorTraumaActions.add(new Action(ActionType.CALL_112));
        majorTraumaActions.add(new Action(ActionType.DO_NOT_MOVE));
        majorTraumaActions.add(new Action(ActionType.PERFORM_CPR));
        majorTraumaActions.add(new Action(ActionType.USE_AED));
        Protocol majorTraumaProtocol = new Protocol(ProtocolType.MAJOR_TRAUMA_SEVERE_BLEEDING_NO_CAR_ACCIDENT, majorTraumaActions);
        PROTOCOLS_MAP.put(ProtocolType.MAJOR_TRAUMA_SEVERE_BLEEDING_NO_CAR_ACCIDENT, majorTraumaProtocol);
    }
    
}
