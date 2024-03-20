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
    NO_EMERGENCY("No medical emergency was found. In case of doubt, call the emergency services and remain nearby to provide assistance if needed"),
    CALL_112("Call the emergency services (112) and remain nearby to provide assistance if needed"),
    PERFORM_CPR("Perform CPR. Kneel beside the person. Place the person on their back on a firm, flat surface. Give 30 chest compressions. Hand position: Two hands centered on the chest. Body position: Shoulders directly over hands; elbows locked. Depth: At least 2 inches. Rate: 100 to 120 per minute. Give 2 breaths. Open the airway to a past-neutral position using the head-tilt/chin-lift technique. Pinch the nose shut, take a normal breath, and make complete seal over the person’s mouth with your mouth.. Continue giving sets of 30 chest compressions and 2 breaths. Use an AED as soon as one is available! Minimize interruptions to chest compressions to less than 10 seconds"),
    USE_AED("Find an automated external defibrillator. As soon as an AED is available, turn it on and follow the voice prompts. Remove clothing and attach pads correctly. Place one pad on the upper right side of the chest. Place the other pad on the lower left side of the chest, a few inches below the left armpit. Prepare to let the AED analyze the heart’s rhythm and make sure no one is touching the person. Push the “shock” button to deliver the shock. After the AED delivers the shock, or if no shock is advised, immediately start CPR, beginning with compressions"),
    BURNS_PROCEDURE("Turn off power source, do not cover the burns. Do not attempt to touch the person directly with your hands if they are still in contact with the electrical source, as you risk getting shocked as well. Instead, utilize a non-conductive object like a wooden stick or a dry towel to carefully separate the person from the electrical source. Avoid covering the burns, as this can trap heat and exacerbate the injury. Seek immediate medical attention without delay"),
    DO_NOT_MOVE("Do not move the injured person. Stay with the patient and offer reassurance while awaiting medical help"),
    APPLY_PRESSURE("Apply pressure to stop bleeding. If a tourniquet is available, use it. You can apply a tourniquet to bare skin or over clothing. Place the tourniquet high and tight on the extremity (arm or leg), near the armpit or groin. Pull the “tail\" strap of the tourniquet tight and twist the windlass until the bleeding stops. Secure the windlass to keep the tourniquet tight and in place"),
    PROTECT_PAR("Protect the person according to PAS rule. Ensure the safety of yourself, the patient, and bystanders. Move the patient away from any immediate danger if possible. Wear a reflective vest and put warning triangles. Call medical emergencies services"),
    RESCUE_PAR("Rescue the person according to PAS rule. Call medical emergencies services. Ensure the safety of yourself, the patient, and bystanders. Move the patient away from any immediate danger if possible. Wear a reflective vest and put warning triangles. Be careful to not add or aggravating injuries"),
    ENCOURAGE_COUGH("Encourage the person to cough"),
    HEIMLICH_MANEUVER("Perform the Heimlich maneuver. Make a fist with one hand and clasp your other hand tightly around it. Place the thumb side of your fist just below your ribcage and about two inches above your belly button (navel). Sharply and quickly thrust your hands inward and upward five times. Repeat this process until you free (dislodge) the object"),
    SEARCH_MEDICATION("Ask if the person has any medication for heart attacks and help them search for it"),
    CALL_112_RECOVERY("Call the emergency services (112) if the person did not recovered after your help"),
    SECURE_AREA("Secure the area. Ensuring that the immediate surroundings are safe and free from potential hazards or dangers"),
    LEGS_UP_LOOSEN("Elevate the person's legs above the level of their heart if possible and loosen any tight clothing, such as belts, ties, or restrictive garments, to ensure that circulation is not further impeded"),
    RECOVERY_POSITION("Put the person in a recovery position. Move them onto their side and tilt their head back"),
    LAY_DOWN("Lay the person down"),
    HYDRATION("Offer the person water and wet their face with a little water"),
    CUSHION_HEAD("Place a soft cushion or rolled-up clothing under the person's head to provide support and comfort. Position the cushion or support so that the person's head is in a neutral position, with their neck aligned with their spine. Avoid tilting or twisting the head unnaturally"),
    FRESH_AIR("Bring the person outside to get some fresh air and take deep breaths"),
    CALL_TOXICOLOGYCENTER("Call 915 620420"),
    AUTO_INJECTOR("Ask if the person has any auto-injector and help them search for it and use it. Ensure the person is lying down or seated in a comfortable position. Expose the outer thigh (upper leg) where the injection will be administered. Press down firmly until you hear or feel a click"),
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
