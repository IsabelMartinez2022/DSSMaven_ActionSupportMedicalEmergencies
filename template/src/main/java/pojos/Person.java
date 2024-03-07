/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import static pojos.Protocol.PROTOCOLS_MAP;
import pojos.ProtocolType;

/**
 *
 * @author marty
 */
public class Person {
    
    private boolean conscious; // boolean
    private Dizzy dizzy; // enum
    private boolean breathing; // boolean
    private Bleeding bleeding; // enum
    private EmitWords emit_words; // enum
    private ChestPain chest_pain; // enum //
    private boolean cough; // boolean
    private boolean seizure; // boolean
    private boolean possible_poisoning; // boolean
    private boolean electric_shock; // boolean
    private boolean major_trauma; // boolean
    private boolean car_accident; // boolean
    private boolean vomit; // boolean
    private DifficultyBreathing difficulty_breathing; // enum
    private Protocol protocol;
    
    //TODO LATER (POSSIBLE ADDITIONAL FUNCTIONALITY)
    //public static enum Urgency {URGENT,MEDIUM,MINOR};??
   // private Urgency urgency;
   //tenemos que preguntarle todo -> a partir de ahí ejecuta las reglas y el ES elige
    
    public Person(boolean conscious, Dizzy dizzy, boolean breathing, Bleeding bleeding, EmitWords emit_words, 
            ChestPain chest_pain, boolean cough, boolean seizure, boolean possible_poisoning, boolean electric_shock, boolean major_trauma, boolean car_accident, boolean vomit, DifficultyBreathing difficulty_breathing) {
        this.conscious = conscious;
        this.dizzy = dizzy;
        this.breathing = breathing;
        this.bleeding = bleeding;
        this.emit_words = emit_words;
        this.chest_pain = chest_pain;
        this.cough = cough;
        this.seizure = seizure;
        this.possible_poisoning = possible_poisoning;
        this.electric_shock = electric_shock;
        this.major_trauma = major_trauma;
        this.car_accident = car_accident;
        this.vomit = vomit;
        this.difficulty_breathing = difficulty_breathing;
        
        this.protocol=PROTOCOLS_MAP.get(ProtocolType.NOEMERGENCYFOUND);
    }
    
    //EMERGENCY RESPONSE CARDIORESPIRATORY_ARREST
    public Person(boolean conscious, boolean breathing, Bleeding bleeding,boolean electric_shock, 
            boolean major_trauma, boolean seizure) {
        this.conscious = conscious;
        this.breathing = breathing;
        this.bleeding = bleeding;
        this.seizure = seizure;
        this.electric_shock = electric_shock;
        this.major_trauma = major_trauma;
        
        this.protocol=PROTOCOLS_MAP.get(ProtocolType.NOEMERGENCYFOUND);
    }

    public Person() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    /*
    public void setUrgency(Urgency urgency){
        this.urgency= urgency;
    }
    */
    
    public boolean isConscious() {
        return conscious;
    }

    public Dizzy isDizzy() {
        return dizzy;
    }

    public boolean isBreathing() {
        return breathing;
    }

    public Bleeding isBleeding() {
        return bleeding;
    }

    public EmitWords isEmit_words() {
        return emit_words;
    }

    public ChestPain isChest_pain() {
        return chest_pain;
    }

    public boolean isCough() {
        return cough;
    }

    public boolean isSeizure() {
        return seizure;
    }

    public boolean isPossible_poisoning() {
        return possible_poisoning;
    }

    public boolean isElectric_shock() {
        return electric_shock;
    }

    public boolean isMajor_trauma() {
        return major_trauma;
    }

    public boolean isCar_accident() {
        return car_accident;
    }

    public boolean isVomit() {
        return vomit;
    }

    public DifficultyBreathing isDifficulty_breathing() {
        return difficulty_breathing;
    }

    public Protocol getProtocol() {
        return this.protocol;
    }

    public void setConscious(boolean conscious) {
        this.conscious = conscious;
    }

    public void setDizzy(Dizzy dizzy) {
        this.dizzy = dizzy;
    }

    public void setBreathing(boolean breathing) {
        this.breathing = breathing;
    }

    public void setBleeding(Bleeding bleeding) {
        this.bleeding = bleeding;
    }

    public void setEmit_words(EmitWords emit_words) {
        this.emit_words = emit_words;
    }

    public void setChest_pain(ChestPain chest_pain) {
        this.chest_pain = chest_pain;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public void setSeizure(boolean seizure) {
        this.seizure = seizure;
    }

    public void setPossible_poisoning(boolean possible_poisoning) {
        this.possible_poisoning = possible_poisoning;
    }

    public void setElectric_shock(boolean electric_shock) {
        this.electric_shock = electric_shock;
    }

    public void setMajor_trauma(boolean major_trauma) {
        this.major_trauma = major_trauma;
    }

    public void setCar_accident(boolean car_accident) {
        this.car_accident = car_accident;
    }

    public void setVomit(boolean vomit) {
        this.vomit = vomit;
    }

    public void setDifficulty_breathing(DifficultyBreathing difficulty_breathing) {
        this.difficulty_breathing = difficulty_breathing;
    }
        
    public void setProtocol(Protocol protocol) {
        this.protocol=protocol;
    }
    
    @Override
    public String toString() {
        return "Person [conscious=" + conscious + ", dizzy=" + dizzy + ", breathing=" + breathing
		+ ", bleeding=" + bleeding + ", emit_words=" + emit_words + ", chest_pain=" + chest_pain + ", cough="
		+ cough + ", seizure=" + seizure + ", possible_poisoning=" + possible_poisoning + ", electric_shock="
		+ electric_shock + ", major_trauma=" + major_trauma + ", car_accident=" + car_accident + ", vomit="
		+ vomit + ", difficulty_breathing=" + difficulty_breathing + "]";
    }
/*
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + this.id_operation;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Operation other = (Operation) obj;
        if (this.id_operation != other.id_operation) {
            return false;
        }
        return true;
    }

*/
}
    
