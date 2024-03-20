/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.drools.ruleunits.api.RuleUnitInstance;
import org.drools.ruleunits.api.RuleUnitProvider;

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
        List<Action> heartAttackActions = new LinkedList<>();
        heartAttackActions.add(new Action(ActionType.CALL_112));
        heartAttackActions.add(new Action(ActionType.SEARCH_MEDICATION));
        Protocol heartAttackProtocol = new Protocol(ProtocolType.HEART_ATTACK, heartAttackActions);
        PROTOCOLS_MAP.put(ProtocolType.HEART_ATTACK, heartAttackProtocol);
        
        //11
        List<Action> faintingActions = new LinkedList<>();
        faintingActions.add(new Action(ActionType.SECURE_AREA));
        faintingActions.add(new Action(ActionType.LEGS_UP_LOOSEN));
        faintingActions.add(new Action(ActionType.CALL_112_RECOVERY));
        Protocol faintingProtocol = new Protocol(ProtocolType.FAINTING, faintingActions);
        PROTOCOLS_MAP.put(ProtocolType.FAINTING, faintingProtocol);
        
        //12
        List<Action> faintingVomitActions = new LinkedList<>();
        faintingVomitActions.add(new Action(ActionType.SECURE_AREA));
        faintingVomitActions.add(new Action(ActionType.RECOVERY_POSITION));
        faintingVomitActions.add(new Action(ActionType.CALL_112_RECOVERY));
        Protocol faintingVomitProtocol = new Protocol(ProtocolType.FAINTING_VOMIT, faintingVomitActions);
        PROTOCOLS_MAP.put(ProtocolType.FAINTING_VOMIT, faintingVomitProtocol);
        
        //13
        List<Action> dizzinessActions = new LinkedList<>();
        dizzinessActions.add(new Action(ActionType.LAY_DOWN));
        dizzinessActions.add(new Action(ActionType.LEGS_UP_LOOSEN));
        dizzinessActions.add(new Action(ActionType.HYDRATION));
        Protocol dizzinessProtocol = new Protocol(ProtocolType.DIZZINESS, dizzinessActions);
        PROTOCOLS_MAP.put(ProtocolType.DIZZINESS, dizzinessProtocol);
        
        //14
        List<Action> consSevereBleedingActions = new LinkedList<>();
        consSevereBleedingActions.add(new Action(ActionType.APPLY_PRESSURE));
        Protocol consSevereBleedingProtocol = new Protocol(ProtocolType.CONS_SEVERE_BLEEDING, consSevereBleedingActions);
        PROTOCOLS_MAP.put(ProtocolType.CONS_SEVERE_BLEEDING, consSevereBleedingProtocol);
        
        //15
        List<Action> seizureActions = new LinkedList<>();
        seizureActions.add(new Action(ActionType.SECURE_AREA));
        seizureActions.add(new Action(ActionType.CUSHION_HEAD));        
        seizureActions.add(new Action(ActionType.RECOVERY_POSITION));
        seizureActions.add(new Action(ActionType.CALL_112_RECOVERY));
        Protocol seizureProtocol = new Protocol(ProtocolType.SEIZURE, seizureActions);
        PROTOCOLS_MAP.put(ProtocolType.SEIZURE, seizureProtocol);
        
        //16
        List<Action> poisoningActions = new LinkedList<>();  
        poisoningActions.add(new Action(ActionType.RECOVERY_POSITION));
        poisoningActions.add(new Action(ActionType.FRESH_AIR));
        Protocol poisoningProtocol = new Protocol(ProtocolType.POISONING, poisoningActions);
        PROTOCOLS_MAP.put(ProtocolType.POISONING, poisoningProtocol);
        
        //17
        List<Action> anaphylaxisActions = new LinkedList<>(); 
        anaphylaxisActions.add(new Action(ActionType.CALL_112));
        anaphylaxisActions.add(new Action(ActionType.LAY_DOWN));
        anaphylaxisActions.add(new Action(ActionType.AUTO_INJECTOR));
        Protocol anaphylaxisProtocol = new Protocol(ProtocolType.ANAPHYLAXIS, anaphylaxisActions);
        PROTOCOLS_MAP.put(ProtocolType.ANAPHYLAXIS, anaphylaxisProtocol);
        
        //18
        List<Action> anaphylaxisVomitActions = new LinkedList<>(); 
        anaphylaxisVomitActions.add(new Action(ActionType.CALL_112));
        anaphylaxisVomitActions.add(new Action(ActionType.RECOVERY_POSITION));
        anaphylaxisVomitActions.add(new Action(ActionType.AUTO_INJECTOR));
        Protocol anaphylaxisVomitProtocol = new Protocol(ProtocolType.ANAPHYLAXIS_VOMIT, anaphylaxisVomitActions);
        PROTOCOLS_MAP.put(ProtocolType.ANAPHYLAXIS_VOMIT, anaphylaxisVomitProtocol);
        
        //19
        List<Action> strokeActions = new LinkedList<>(); 
        strokeActions.add(new Action(ActionType.CALL_112));
        strokeActions.add(new Action(ActionType.AMBULANCE));
        Protocol strokeProtocol = new Protocol(ProtocolType.STROKE, strokeActions);
        PROTOCOLS_MAP.put(ProtocolType.STROKE, strokeProtocol);
        
        //20
        List<Action> noEmergencyActions = new LinkedList<>();
        noEmergencyActions.add(new Action(ActionType.NO_EMERGENCY));
        Protocol noEmergencyProtocol = new Protocol(ProtocolType.NOEMERGENCYFOUND, noEmergencyActions);
        PROTOCOLS_MAP.put(ProtocolType.NOEMERGENCYFOUND, noEmergencyProtocol);
        
        //21
        List<Action> majorTraumaActions = new LinkedList<>(); 
        majorTraumaActions.add(new Action(ActionType.CALL_112));
        majorTraumaActions.add(new Action(ActionType.DO_NOT_MOVE));
        Protocol majorTraumaProtocol = new Protocol(ProtocolType.MAJOR_TRAUMA, majorTraumaActions);
        PROTOCOLS_MAP.put(ProtocolType.MAJOR_TRAUMA, majorTraumaProtocol);
        
        //22
        List<Action> majorTraumaBleedingActions = new LinkedList<>(); 
        majorTraumaBleedingActions.add(new Action(ActionType.CALL_112));
        majorTraumaBleedingActions.add(new Action(ActionType.DO_NOT_MOVE));
        majorTraumaBleedingActions.add(new Action(ActionType.APPLY_PRESSURE));
        Protocol majorTraumaBleedingProtocol = new Protocol(ProtocolType.MAJOR_TRAUMA_BLEEDING, majorTraumaBleedingActions);
        PROTOCOLS_MAP.put(ProtocolType.MAJOR_TRAUMA_BLEEDING, majorTraumaBleedingProtocol);
        
        //23
        List<Action> carBleedingActions = new LinkedList<>();
        carBleedingActions.add(new Action(ActionType.PROTECT_PAR));
        carBleedingActions.add(new Action(ActionType.CALL_112));
        carBleedingActions.add(new Action(ActionType.RESCUE_PAR));
        carBleedingActions.add(new Action(ActionType.APPLY_PRESSURE));
        Protocol carBleedingProtocol = new Protocol(ProtocolType.CAR_BLEEDING, carBleedingActions);
        PROTOCOLS_MAP.put(ProtocolType.CAR_BLEEDING, carBleedingProtocol);
       
    }

    public String actionString(){       
        String info = "";
        
        /*
        1_THIS FOR WILL GO THROUGH THE MAP
        2_WHEN THE KEY IS THE SAME AS THE ONE THAT OUR PROTOCAL HAS IT WILL SAVE IT IN THE STRING
        */
        for (Map.Entry<ProtocolType, Protocol> entry : PROTOCOLS_MAP.entrySet()) {
            //System.out.println("ENTRY KEY: "+entry.getKey().toString()); //IMPRIME BIEN --> son las Keys
            //System.out.println("ENTRY VALUE: "+entry.getValue().toString()); //MAL --> Con est redirijo otra vez al tostring del protocol que vuelve a esta funcion --> errores
            //System.out.println("ENTRY VALUE: "+entry.getValue().getActions()); //IMPRIME BIEN --> son las actions
            //LOS 2 SOUT IMPRIMEN TODOS LOS PROTOCOLOS!!
            
            /*
            getKey --> access the key
            getValue --> access the value of the key
            */
            
            if(entry.getKey() == this.type){
                //info = info + /*"[Key] : " + entry.getKey().toString() +*/ " [Value] : " + entry.getValue().getActions() + "\n";
                info = info + entry.getValue().getActions() + "\n";
            }
        }

        return info;
    }
    
    @Override
    public String toString() {
        return "\nProtocol{\n" + "\tid=" + this.id + "\n\ttype: " + this.type + "\n\tActions: " + actionString() + '}';
    }
    
    //MAIN TO TRY PROTOCOL WITHOUT HAVING TO INPUT ALL THE DATA AND RUNNING OUR MENU
    public static void main(String[] args) {
        
        PersonUnit personunit = new PersonUnit();
        RuleUnitInstance<PersonUnit> instance = RuleUnitProvider.get().createRuleUnitInstance(personunit);
                
        Person person = new Person();
        
        person.setConscious(false);
        person.setBreathing(Breathing.NO);
        person.setBleeding(Bleeding.NO);
        person.setElectric_shock(false);
        person.setMajor_trauma(false);
        person.setSeizure(false);
        personunit.getPeople().add(person);
        
        // Obtener el protocolo adecuado para la emergencia de paro cardiorrespiratorio
        Protocol cardioArrestProtocol = Protocol.PROTOCOLS_MAP.get(ProtocolType.CARDIOARREST);
        // Asignar el protocolo a la persona
        person.setProtocol(cardioArrestProtocol);
        
        personunit.getPeople().add(person);
        // Ejecutar las reglas sobre la instancia
        instance.fire();
        instance.close();
        System.out.println(person.getProtocol().toString());
        
    }
    
}

