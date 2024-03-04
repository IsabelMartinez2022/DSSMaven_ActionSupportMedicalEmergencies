/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author maria
 */
public class Protocol {
    private int id;
    //public static enum Type {ADVICE,INPLACE,SHIPMENT};
    //private Type protocolType;
    private List<Action> actionsList;
    
    
    
    // Map ENUMNOMBREPROTOCOL-PROTOCOL // TODO CHECK UNMODIFIABLE
    
    public static final Map<String,List<Action>> PROTOCOLS_MAP = new HashMap();
    static {
        Protocol protocol1 = new Protocol();
        PROTOCOLS_MAP.put("protocol1",protocol1);
    }
}
