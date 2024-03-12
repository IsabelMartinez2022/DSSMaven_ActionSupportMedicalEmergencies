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
        
        //0 DESDE UI? CÓMO IMPLEMENTAR EN LAS REGLAS?
        //List<Action> noEmergencyActions = new LinkedList<>();
        //noEmergencyActions.add(new Action(ActionType.NO_EMERGENCY));
        //Protocol noEmergencyProtocol = new Protocol(ProtocolType.NOEMERGENCYFOUND, noEmergencyActions);
        //PROTOCOLS_MAP.put(ProtocolType.NOEMERGENCYFOUND, noEmergencyProtocol);
        
        //1
        List<Action> cardioArrestActions = new LinkedList<>();
        cardioArrestActions.add(new Action(ActionType.CALL_112));
        cardioArrestActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestProtocol = new Protocol(ProtocolType.CARDIOARREST, cardioArrestActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIOARREST, cardioArrestProtocol);

        //2
        List<Action> cardioArrestElectrocutionActions = new LinkedList<>();
        cardioArrestElectrocutionActions.add(new Action(ActionType.BURNS_PROCEDURE));
        cardioArrestElectrocutionActions.add(new Action(ActionType.CALL_112));
        cardioArrestElectrocutionActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestElectrocutionActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestElectrocutionProtocol = new Protocol(ProtocolType.CARDIOARREST_ELECTROCUTION, cardioArrestElectrocutionActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIOARREST_ELECTROCUTION, cardioArrestElectrocutionProtocol);

        //3
        List<Action> cardioArrestMajorTraumaActions = new LinkedList<>();
        cardioArrestMajorTraumaActions.add(new Action(ActionType.CALL_112));
        cardioArrestMajorTraumaActions.add(new Action(ActionType.DO_NOT_MOVE));
        cardioArrestMajorTraumaActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestMajorTraumaActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestMajorTraumaProtocol = new Protocol(ProtocolType.CARDIOARREST_MAJORTRAUMA, cardioArrestMajorTraumaActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIOARREST_MAJORTRAUMA, cardioArrestMajorTraumaProtocol);
        
        //4
        List<Action> cardioArrestMajorTraumaBleedingActions = new LinkedList<>();
        cardioArrestMajorTraumaBleedingActions.add(new Action(ActionType.CALL_112));
        cardioArrestMajorTraumaBleedingActions.add(new Action(ActionType.DO_NOT_MOVE));
        cardioArrestMajorTraumaBleedingActions.add(new Action(ActionType.APPLY_PRESSURE));
        cardioArrestMajorTraumaBleedingActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestMajorTraumaBleedingActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestMajorTraumaBleedingProtocol = new Protocol(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING, cardioArrestMajorTraumaBleedingActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIOARREST_MAJORTRAUMA_BLEEDING, cardioArrestMajorTraumaBleedingProtocol);
        
        //5
        List<Action> carActions = new LinkedList<>();
        carActions.add(new Action(ActionType.PROTECT_PAR));
        carActions.add(new Action(ActionType.CALL_112));
        carActions.add(new Action(ActionType.RESCUE_PAR));
        Protocol carProtocol = new Protocol(ProtocolType.CAR, carActions);
        PROTOCOLS_MAP.put(ProtocolType.CAR, carProtocol);
        
        //6
        List<Action> cardioArrestCarActions = new LinkedList<>();
        cardioArrestCarActions.add(new Action(ActionType.PROTECT_PAR));
        cardioArrestCarActions.add(new Action(ActionType.CALL_112));
        cardioArrestCarActions.add(new Action(ActionType.RESCUE_PAR));
        cardioArrestCarActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestCarActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestCarProtocol = new Protocol(ProtocolType.CARDIOARREST_CAR, cardioArrestCarActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIOARREST_CAR, cardioArrestCarProtocol);
        
        //7
        List<Action> cardioArrestCarBleedingActions = new LinkedList<>();
        cardioArrestCarBleedingActions.add(new Action(ActionType.PROTECT_PAR));
        cardioArrestCarBleedingActions.add(new Action(ActionType.CALL_112));
        cardioArrestCarBleedingActions.add(new Action(ActionType.RESCUE_PAR));
        cardioArrestCarBleedingActions.add(new Action(ActionType.APPLY_PRESSURE));
        cardioArrestCarBleedingActions.add(new Action(ActionType.PERFORM_CPR));
        cardioArrestCarBleedingActions.add(new Action(ActionType.USE_AED));
        Protocol cardioArrestCarBleedingProtocol = new Protocol(ProtocolType.CARDIOARREST_CAR_BLEEDING, cardioArrestCarBleedingActions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIOARREST_CAR_BLEEDING, cardioArrestCarBleedingProtocol);
   
        //8
        List<Action> partialChokingActions = new LinkedList<>();
        partialChokingActions.add(new Action(ActionType.ENCOURAGE_COUGH));
        Protocol partialChokingProtocol = new Protocol(ProtocolType.PARTIAL_CHOKING, partialChokingActions);
        PROTOCOLS_MAP.put(ProtocolType.PARTIAL_CHOKING, partialChokingProtocol);
        
        //9
        List<Action> totalChokingActions = new LinkedList<>();
        totalChokingActions.add(new Action(ActionType.HEIMLICH_MANEUVER));
        Protocol totalChokingProtocol = new Protocol(ProtocolType.TOTAL_CHOKING, totalChokingActions);
        PROTOCOLS_MAP.put(ProtocolType.TOTAL_CHOKING, totalChokingProtocol);
        
        //10
        
    }
    
}
