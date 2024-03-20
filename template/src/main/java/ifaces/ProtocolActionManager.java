/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;

import java.util.List;
import pojos.Action;
import pojos.Protocol;
import pojos.ProtocolAction;

/**
 *
 * @author isama
 */
public interface ProtocolActionManager {
    public void assignActionProtocol(ProtocolAction prA);
    public List<Action> getActionsOfProtocol(int prId);
    public ProtocolAction getProtocolAction(Protocol pr, Action a); 
}
