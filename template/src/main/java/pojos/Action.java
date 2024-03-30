/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.Serializable;
import java.util.List;

public class Action implements Serializable {
    
    private static final long serialVersionUID = 4L;
    private final ActionType type; // Many to one relationship
    private List<Protocol> protocols; // Many to many relationship

    //Used to try correct implementation of menus
    public Action(ActionType type) {
        super();
        this.type = type;
    }

    public ActionType getType() {
        return type;
    }
    
    public List<Protocol> getProtocols() {
        return protocols;
    }
    
    @Override
    public String toString() {
        return "\n\t\t" + this.type + ": "+ this.type.getInstruction();

    }   
}