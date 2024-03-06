/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maria
 */
public class Protocol {
    private int id;
    public static enum ProtocolType {NOEMERGENCYFOUND, CARDIO_ARREST};
    private ProtocolType protocolType;
    private List<Action> actions;
    
    public Protocol(ProtocolType protocolType, List<Action> actions){
        this.protocolType=protocolType;
        this.actions= actions;
}
    
    // Map ENUMNOMBREPROTOCOL-PROTOCOL // TODO CHECK UNMODIFIABLE
 
    public static final Map<ProtocolType, Protocol> PROTOCOLS_MAP =new HashMap();
    static {
        
        // OR ARRAYLIST???
        List<Action> actions = new LinkedList();
        
        //EMERGENCY RESPONSE CARDIORESPIRATORY ARREST
        actions.add(Action.call_112());
        actions.add(Action.perform_CPR());
        actions.add(Action.use_AED());
        Protocol protocol1 = new Protocol(ProtocolType.CARDIO_ARREST,actions);
        PROTOCOLS_MAP.put(ProtocolType.CARDIO_ARREST, protocol1);
    }
    

}
