/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.ProtocolManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.ActionType;
import pojos.ProtocolType;

/**
 *
 * @author maria
 */
public class JDBCProtocolManager implements ProtocolManager{
    private JDBCManager manager;
    
    public JDBCProtocolManager (JDBCManager m){
        this.manager=m;
    }
    
    @Override
    public void addProtocol() {
        // Se itera sobre los valores del enum ActionType.
        for (ProtocolType protocolType : ProtocolType.values()) {
            try {
                String sql = "INSERT INTO protocol (type) VALUES (?)";
                PreparedStatement statement = manager.getConnection().prepareStatement(sql);
                statement.setString(1, protocolType.name());  
                
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
