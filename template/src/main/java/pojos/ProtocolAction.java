/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

import java.io.Serializable;

/**
 *
 * @author isama
 */
public class ProtocolAction implements Serializable{
    
    private static final long serialVersionUID = 8962678955441389723L;
	
	private Protocol protocol;
	private Action action;

    public Protocol getProtocol() {
        return protocol;
    }

    public Action getAction() {
        return action;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    public void setAction(Action action) {
        this.action = action;
    }
        
    
}
