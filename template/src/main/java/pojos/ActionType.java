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
    NO_EMERGENCY("No medical emergency was found. In case of doubt, call the emergency services"),
    CALL_112("Call the emergency services (112)"),
    PERFORM_CPR("Perform CPR"),
    USE_AED("Use automated external defibrillator"),
    BURNS_PROCEDURE("Turn off power source, do not cover the burns"),
    DO_NOT_MOVE("Do not move the injured person"),
    APPLY_PRESSURE("Apply pressure to stop bleeding"),
    PROTECT_PAR("Protect the person according to PAS rule"),
    RESCUE_PAR("Rescue the person according to PAS rule"),
    ENCOURAGE_COUGH("Encourage the person to cough"),
    HEIMLICH_MANEUVER("Perform the Heimlich maneuver"),
    SEARCH_MEDICATION("Ask if the person has any medication for heart attacks and help them search for it"),
    CALL_112_RECOVERY("Call the emergency services (112) if not recovered"),
    SECURE_AREA("Secure the area"),
    LEGS_UP_LOOSEN("Legs up and..."),
    RECOVERY_POSITION("Put the person in a recovery position"),
    LAY_DOWN("Lay the person down"),
    HYDRATION("Provide water to the person"),
    CUSHION_HEAD("Cushion the person's head"),
    FRESH_AIR("Bring the person outside to get some fresh air"),
    CALL_TOXICOLOGYCENTER("Call 915..."),
    AUTO_INJECTOR("\"Ask if the person has any auto-injector and help them search for it"),
    AMBULANCE("Ask for ambulance");
    
    private final String instruction;

    ActionType(String instruction) {
        this.instruction = instruction;
    }

    public String getInstruction() {
        return instruction;
    }

    /*@Override
    public String toString() {
        return "ActionType{" + "instruction=" + this.instruction + '}';
    }*/
    
}
