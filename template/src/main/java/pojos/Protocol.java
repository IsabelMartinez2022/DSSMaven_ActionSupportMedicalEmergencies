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
    public static enum Type {NOEMERGENCYFOUND, CARDIO_ARREST};
    private Type protocolType;
    private List<Action> actions;
    
    public Protocol(Type protocolType, List<Action> actions){
        this.protocolType=protocolType;
        this.actions= actions;
}
    
    // Map ENUMNOMBREPROTOCOL-PROTOCOL // TODO CHECK UNMODIFIABLE
    //OPTION1 
    
 
    public static final Map<Type, Protocol>PROTOCOLS_MAP=new HashMap();
    static {
        // añadir acciones al protocolo
        List<Action> actions = new LinkedList();
        
        actions.add(new Action("whatever"));
        Protocol protocol1 = new Protocol(Type.CARDIO_ARREST,actions);
        PROTOCOLS_MAP.put(Type.CARDIO_ARREST, protocol1);
    }
    

}
