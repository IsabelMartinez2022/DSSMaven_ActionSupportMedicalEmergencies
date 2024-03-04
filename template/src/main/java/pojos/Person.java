/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author marty
 */
public class Person {
    
    private boolean conscious; // boolean
    private boolean dizzy; // enum
    private boolean breathing; // boolean
    private enum bleeding; // enum
    private boolean emit_words; // enum
    private boolean chest_pain; // enum //YO LO PONDRíA BOOLEAN
    private boolean cough; // boolean
    private boolean seizure; // enum //YO LO PONDRÍA BOOLEAN
    private boolean possible_poisoning; // boolean
    private boolean electric_shock; // boolean
    private boolean major_trauma; // boolean
    private boolean car_accident; // boolean
    private boolean vomit; // boolean
    private boolean difficulty_breathing; // enum
    private List<String> protocol;
   //tenemos que preguntarle todo -> a partir de ahí ejecuta las reglas y el ES elige
   //unknown -> enum que comprendan el si o el no
    
    //CRITICAL STATE
    public Person(boolean conscious, boolean breathing, enum bleeding, boolean bleeding, )
    public Person(boolean conscious, boolean dizzy, boolean breathing, boolean bleeding, boolean emit_words, boolean chest_pain, boolean cough, boolean seizure, boolean possible_poisoning, boolean electric_shock, boolean major_trauma, boolean car_accident, boolean vomit, boolean difficulty_breathing) {
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
        
        this.protocol= new ArrayList<String>();
    }

    public boolean isConscious() {
        return conscious;
    }

    public boolean isDizzy() {
        return dizzy;
    }

    public boolean isBreathing() {
        return breathing;
    }

    public boolean isBleeding() {
        return bleeding;
    }

    public boolean isEmit_words() {
        return emit_words;
    }

    public boolean isChest_pain() {
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

    public boolean isDifficulty_breathing() {
        return difficulty_breathing;
    }

    public List<String> getProtocol() {
        return protocol;
    }

    public void setConscious(boolean conscious) {
        this.conscious = conscious;
    }

    public void setDizzy(boolean dizzy) {
        this.dizzy = dizzy;
    }

    public void setBreathing(boolean breathing) {
        this.breathing = breathing;
    }

    public void setBleeding(boolean bleeding) {
        this.bleeding = bleeding;
    }

    public void setEmit_words(boolean emit_words) {
        this.emit_words = emit_words;
    }

    public void setChest_pain(boolean chest_pain) {
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

    public void setDifficulty_breathing(boolean difficulty_breathing) {
        this.difficulty_breathing = difficulty_breathing;
    }
        
    public void setProtocol(int num) {
        
        switch (num){
            case 1: this.protocol.add(call_112());
            case 2: this.protocol.add(perform_CPR());
            case 3: this.protocol.add(use_AED());
            case 4: this.protocol.add(burns_procedure());//"Turn off power source, do not cover the burnts
            case 5: this.protocol.add(donot_move());
            case 6: this.protocol.add(apply_pressure());
            case 7: this.protocol.add(protect_PAR());
            case 8: this.protocol.add(rescue_PAR);
        }		
        
	}
	
    // removeProtocol???
    
    //para los test
    /*
    public boolean isTurnOffPowerSourcePrinted() {
        return turnOffPowerSourcePrinted;
    }

    public void setTurnOffPowerSourcePrinted(boolean turnOffPowerSourcePrinted) {
        this.turnOffPowerSourcePrinted = turnOffPowerSourcePrinted;
    }

    public boolean isDoNotCoverBurntsPrinted() {
        return doNotCoverBurntsPrinted;
    }

    public void setDoNotCoverBurntsPrinted(boolean doNotCoverBurntsPrinted) {
        this.doNotCoverBurntsPrinted = doNotCoverBurntsPrinted;
    }

    public boolean isCall112Printed() {
        return call112Printed;
    }

    public void setCall112Printed(boolean call112Printed) {
        this.call112Printed = call112Printed;
    }

    public boolean isStartCPRPrinted() {
        return startCPRPrinted;
    }

    public void setStartCPRPrinted(boolean startCPRPrinted) {
        this.startCPRPrinted = startCPRPrinted;
    }

    public boolean isUseAEDPrinted() {
        return useAEDPrinted;
    }

    public void setUseAEDPrinted(boolean useAEDPrinted) {
        this.useAEDPrinted = useAEDPrinted;
    }
    */
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
    
