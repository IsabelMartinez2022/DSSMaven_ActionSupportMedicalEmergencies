/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;

import java.util.List;
import pojos.Protocol;

/**
 *
 * @author isama
 */

public interface ProtocolManager {
    
    public void addProtocol();
    public Protocol getProtocolofPerson(int personId);
}
