/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package ifaces;

import pojos.Protocol;

public interface ProtocolManager {
    
    public void addProtocol();
    public int getProtocolId(String protocolType);
    public Protocol obtainProtocol(int protocolId);
}
