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
 
    private final String instruction;
    //Many to many relationship with Protocols
    
    public Action(String instruction){
        this.instruction= instruction;
    }
    
    /* TODO???? I
    
    Instead of static factory methods, MAP ENUM-STRING/LIST (Alberto's idea)
    
    public Action(Type protocolType){
        this.instruction= setAction(protocolType);
    }
   
    + getter enum
    */
    
    public static Action call_112(){
        String info= "";
        return new Action(info);
    }
    
    public static Action perform_CPR(){
       String info= "";
        return new Action(info);
   }
    
    public static Action use_AED(){
        String info= "";
        return new Action(info);
    }
   
    //"Turn off power source, do not cover the burnts
    public static Action burns_procedure(){
        String info= "";
        return new Action(info);
    }

   public static Action donot_move(){
        String info= "";
        return new Action(info);
   }
   
   public static Action apply_pressure(){
        String info= "";
        return new Action(info);
   }
   
   //Proteger from Spanish PAS rule
   public static Action protect_PAR(){
        String info= "";
        return new Action(info);
   }
   
   //Socorrer from Spanish PAS rule
   public static Action rescue_PAR(){
        String info= "";
        return new Action(info);
   }
   
}
