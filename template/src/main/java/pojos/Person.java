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
    
    private Boolean conscious; // boolean
    private Dizzy dizzy; // enum
    private Breathing breathing; // enum
    private Bleeding bleeding; // enum
    private Boolean emit_words; // boolean
    private ChestPain chest_pain; // enum 
    private Boolean cough; // boolean
    private Boolean seizure; // boolean
    private Boolean possible_poisoning; // boolean
    private Boolean electric_shock; // boolean
    private Boolean major_trauma; // boolean
    private Boolean car_accident; // boolean
    private Boolean vomit; // boolean
    private DifficultyBreathing difficulty_breathing; // enum
    private Boolean communication_problems;
    private Protocol protocol;
    private int userId;
    
    //TODO LATER (POSSIBLE ADDITIONAL FUNCTIONALITY)
    //public static enum Urgency {URGENT,MEDIUM,MINOR};??
   // private Urgency urgency;
   //tenemos que preguntarle todo -> a partir de ahí ejecuta las reglas y el ES elige

    public Person(Boolean conscious, Dizzy dizzy, Breathing breathing, Bleeding bleeding, Boolean emit_words, ChestPain chest_pain, Boolean cough, Boolean seizure, Boolean possible_poisoning, Boolean electric_shock, Boolean major_trauma, Boolean car_accident, Boolean vomit, DifficultyBreathing difficulty_breathing, Boolean communication_problems) {
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
        this.communication_problems=communication_problems;
    }

    public Person(){
        
    } 

    public Boolean getConscious() {
        return conscious;
    }

    public void setConscious(Boolean conscious) {
        this.conscious = conscious;
    }

    public Dizzy getDizzy() {
        return dizzy;
    }

    public void setDizzy(Dizzy dizzy) {
        this.dizzy = dizzy;
    }

    public Breathing getBreathing() {
        return breathing;
    }

    public void setBreathing(Breathing breathing) {
        this.breathing = breathing;
    }

    public Bleeding getBleeding() {
        return bleeding;
    }

    public void setBleeding(Bleeding bleeding) {
        this.bleeding = bleeding;
    }

    public Boolean getEmit_words() {
        return emit_words;
    }

    public void setEmit_words(Boolean emit_words) {
        this.emit_words = emit_words;
    }

    public ChestPain getChest_pain() {
        return chest_pain;
    }

    public void setChest_pain(ChestPain chest_pain) {
        this.chest_pain = chest_pain;
    }

    public Boolean getCough() {
        return cough;
    }

    public void setCough(Boolean cough) {
        this.cough = cough;
    }

    public Boolean getSeizure() {
        return seizure;
    }

    public void setSeizure(Boolean seizure) {
        this.seizure = seizure;
    }

    public Boolean getPossible_poisoning() {
        return possible_poisoning;
    }

    public void setPossible_poisoning(Boolean possible_poisoning) {
        this.possible_poisoning = possible_poisoning;
    }

    public Boolean getElectric_shock() {
        return electric_shock;
    }

    public void setElectric_shock(Boolean electric_shock) {
        this.electric_shock = electric_shock;
    }

    public Boolean getMajor_trauma() {
        return major_trauma;
    }

    public void setMajor_trauma(Boolean major_trauma) {
        this.major_trauma = major_trauma;
    }

    public Boolean getCar_accident() {
        return car_accident;
    }

    public void setCar_accident(Boolean car_accident) {
        this.car_accident = car_accident;
    }

    public Boolean getVomit() {
        return vomit;
    }

    public void setVomit(Boolean vomit) {
        this.vomit = vomit;
    }

    public DifficultyBreathing getDifficulty_breathing() {
        return difficulty_breathing;
    }

    public void setDifficulty_breathing(DifficultyBreathing difficulty_breathing) {
        this.difficulty_breathing = difficulty_breathing;
    }
    
    public Boolean getCommunication_problems(){
        return communication_problems;
    }
    
    public void setCommunication_problems(Boolean communication_problems){
        this.communication_problems=communication_problems;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    @Override
    public String toString() {
        return "Person{" + "conscious=" + conscious + ", dizzy=" + dizzy + ", breathing=" + breathing + ", bleeding=" + bleeding + ", emit_words=" + emit_words + ", chest_pain=" + chest_pain + ", cough=" + cough + ", seizure=" + seizure + ", possible_poisoning=" + possible_poisoning + ", electric_shock=" + electric_shock + ", major_trauma=" + major_trauma + ", car_accident=" + car_accident + ", vomit=" + vomit + ", difficulty_breathing=" + difficulty_breathing + ", communication_problems"+ communication_problems+ ", protocol=" +protocol + '}';
    }
    
    
}
    
