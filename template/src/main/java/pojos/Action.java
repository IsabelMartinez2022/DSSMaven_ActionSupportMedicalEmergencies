/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author isama
 */
public class Action {
    private final ActionType type;

    public Action(ActionType type) {
        this.type = type;
    }

    public ActionType getType() {
        return type;
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