/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author isama
 */
public class Action implements Serializable {
    
    private static final long serialVersionUID = 4L;
    private final ActionType type; // Many to one relationship
    private List<Protocol> protocols; // Many to many relationship

    //Used to try correct implementation of menus
    public Action(ActionType type) {
        this.type = type;
    }
    //When the doubts are solve change to this --> also change protocol
    /*public Action(ActionType type, List<Protocol> protocols) {
        this.type = type;
    }*/

    public ActionType getType() {
        return type;
    }
    
    public List<Protocol> getProtocols() {
        return protocols;
    }
   
    
    @Override
    public String toString() {
        //return "Action{" + "type=" + type + '}';
        //return "Action{" + "type=" + type + "info="+ type.getInstruction() +'}';
        
        /*
        this.type --> access the type of Action (CPR, AED...)
        this.type.getInstructions --> access the instruction of the type
        If we put the toString on ActionType when we put this.type it will only print the instruction and not the type
            thats why the toString is commented
        */
        return "\n\t\t" + this.type + ": "+ this.type.getInstruction();

    }   
}