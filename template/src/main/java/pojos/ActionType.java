/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pojos;

/**
 *
 * @author marty
 */
public enum ActionType {
    //NO_EMERGENCY("No medical emergency was found. In case of doubt, call the emergency services"),
    CALL_112("Call the emergency services (112)"),
    PERFORM_CPR("Perform CPR"),
    USE_AED("Use automated external defibrillator"),
    BURNS_PROCEDURE("Turn off power source, do not cover the burns"),
    DO_NOT_MOVE("Do not move the injured person"),
    APPLY_PRESSURE("Apply pressure to stop bleeding"),
    PROTECT_PAR("Protect the person according to PAS rule"),
    RESCUE_PAR("Rescue the person according to PAS rule"),
    ENCOURAGE_COUGH("Encourage the person to cough"),
    HEIMLICH_MANEUVER("Perform the Heimlich maneuver");

    private final String instruction;

    ActionType(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }
}
