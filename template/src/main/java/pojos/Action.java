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
}