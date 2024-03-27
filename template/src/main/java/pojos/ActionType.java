/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package pojos;

import java.io.Serializable;

public enum ActionType implements Serializable{
    NO_EMERGENCY("No medical emergency was found. \n\t\t\tIn case of doubt, call the emergency services and remain nearby to provide assistance if needed"),
    CALL_112("Call the emergency services (112) and remain nearby to provide assistance if needed"),
    PERFORM_CPR("Perform CPR. \n\t\t\tKneel beside the person. \n\t\t\tPlace the person on their back on a firm, flat surface. \n\t\t\tGive 30 chest compressions. \n\t\t\tHand position: Two hands centered on the chest. \n\t\t\tBody position: Shoulders directly over hands; elbows locked. \n\t\t\tDepth: At least 2 inches. \n\t\t\tRate: 100 to 120 per minute. \n\t\t\tGive 2 breaths. \n\t\t\tOpen the airway to a past-neutral position using the head-tilt/chin-lift technique. \n\t\t\tPinch the nose shut, take a normal breath, and make complete seal over the person’s mouth with your mouth.. \n\t\t\tContinue giving sets of 30 chest compressions and 2 breaths. \n\t\t\tUse an AED as soon as one is available! \n\t\t\tMinimize interruptions to chest compressions to less than 10 seconds"),
    USE_AED("Find an automated external defibrillator. \n\t\t\tAs soon as an AED is available, turn it on and follow the voice prompts. \n\t\t\tRemove clothing and attach pads correctly. \n\t\t\tPlace one pad on the upper right side of the chest. \n\t\t\tPlace the other pad on the lower left side of the chest, a few inches below the left armpit. \n\t\t\tPrepare to let the AED analyze the heart’s rhythm and make sure no one is touching the person. \n\t\t\tPush the “shock” button to deliver the shock. \n\t\t\tAfter the AED delivers the shock, or if no shock is advised, immediately start CPR, beginning with compressions"),
    BURNS_PROCEDURE("Turn off power source, do not cover the burns. \n\t\t\tDo not attempt to touch the person directly with your hands if they are still in contact with the electrical source, as you risk getting shocked as well. \n\t\t\tInstead, utilize a non-conductive object like a wooden stick or a dry towel to carefully separate the person from the electrical source. \n\t\t\tAvoid covering the burns, as this can trap heat and exacerbate the injury. \n\t\t\tSeek immediate medical attention without delay"),
    DO_NOT_MOVE("Do not move the injured person. \n\t\t\tStay with the patient and offer reassurance while awaiting medical help"),
    APPLY_PRESSURE("Apply pressure to stop bleeding. \n\t\t\tIf a tourniquet is available, use it. \n\t\t\tYou can apply a tourniquet to bare skin or over clothing. \n\t\t\tPlace the tourniquet high and tight on the extremity (arm or leg), near the armpit or groin. \n\t\t\tPull the “tail\" strap of the tourniquet tight and twist the windlass until the bleeding stops. \n\t\t\tSecure the windlass to keep the tourniquet tight and in place"),
    PROTECT_PAR("Protect the person according to PAS rule. \n\t\t\tEnsure the safety of yourself, the patient, and bystanders. \n\t\t\tMove the patient away from any immediate danger if possible. \n\t\t\tWear a reflective vest and put warning triangles. \n\t\t\tCall medical emergencies services"),
    RESCUE_PAR("Rescue the person according to PAS rule. \n\t\t\tCall medical emergencies services. \n\t\t\tEnsure the safety of yourself, the patient, and bystanders. \n\t\t\tMove the patient away from any immediate danger if possible. \n\t\t\tWear a reflective vest and put warning triangles. \n\t\t\tBe careful to not add or aggravating injuries"),
    ENCOURAGE_COUGH("Encourage the person to cough"),
    HEIMLICH_MANEUVER("Perform the Heimlich maneuver. \n\t\t\tMake a fist with one hand and clasp your other hand tightly around it. \n\t\t\tPlace the thumb side of your fist just below your ribcage and about two inches above your belly button (navel). \n\t\t\tSharply and quickly thrust your hands inward and upward five times. \n\t\t\tRepeat this process until you free (dislodge) the object"),
    SEARCH_MEDICATION("Ask if the person has any medication for heart attacks and help them search for it"),
    CALL_112_RECOVERY("Call the emergency services (112) if the person did not recover after your help"),
    SECURE_AREA("Secure the area. \n\t\t\tEnsuring that the immediate surroundings are safe and free from potential hazards or dangers"),
    LEGS_UP_LOOSEN("Elevate the person's legs above the level of their heart if possible \n\t\t\tand loosen any tight clothing, such as belts, ties, or restrictive garments, to ensure that circulation is not further impeded"),
    RECOVERY_POSITION("Put the person in a recovery position. \n\t\t\tMove them onto their side and tilt their head back"),
    LAY_DOWN("Lay the person down"),
    HYDRATION("Offer the person water and wet their face with a little water"),
    CUSHION_HEAD("Place a soft cushion or rolled-up clothing under the person's head to provide support and comfort. \n\t\t\tPosition the cushion or support so that the person's head is in a neutral position, with their neck aligned with their spine. \n\t\t\tAvoid tilting or twisting the head unnaturally"),
    FRESH_AIR("Bring the person outside to get some fresh air and take deep breaths"),
    CALL_TOXICOLOGYCENTER("Call 915 620420"),
    AUTO_INJECTOR("Ask if the person has any auto-injector and help them search for it and use it. \n\t\t\tEnsure the person is lying down or seated in a comfortable position. \n\t\t\tExpose the outer thigh (upper leg) where the injection will be administered. \n\t\t\tPress down firmly until you hear or feel a click"),
    AMBULANCE("Ask for ambulance");
    
    private static final long serialVersionUID = 5L;
    private int id;
    private final String instruction;

    ActionType(String instruction) {
        this.instruction = instruction;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    public String getInstruction() {
        return instruction;
    }
    
}
