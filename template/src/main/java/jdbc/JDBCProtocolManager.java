/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.ProtocolManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Protocol;
import pojos.ProtocolType;

public class JDBCProtocolManager implements ProtocolManager{
    
    private ConnectionManager cM;

    public JDBCProtocolManager(ConnectionManager cManager) {
        this.cM = cManager;
    }
    
    @Override
    public void addProtocol() {
        //It iterates over the values of ProtocolType enum 
        for (ProtocolType protocolType : ProtocolType.values()) {
            try {
                String sql = "INSERT INTO protocol (type) SELECT ? WHERE NOT EXISTS (SELECT 1 FROM protocol WHERE type = ? LIMIT 1);";
                PreparedStatement statement = cM.getConnection().prepareStatement(sql);
                statement.setString(1, protocolType.name());  
                statement.setString(2, protocolType.name()); // Verify if the type añready exists
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public int getProtocolId(String protocolType) {
    int protocolId = 0; //Initialiced to 0 in case no protocol is found

        try {
            String sql = "SELECT id FROM protocol WHERE type = ? LIMIT 1";
            PreparedStatement prep = cM.getConnection().prepareStatement(sql);
            prep.setString(1, protocolType);
            ResultSet rs = prep.executeQuery();

            if (rs.next()) {
                protocolId = rs.getInt("id");
            }

            rs.close();
            prep.close();
        } catch (SQLException ex) {
             ex.printStackTrace();
        }

        return protocolId;
    }
    
    @Override
    public Protocol obtainProtocol(int protocolId) {
    //Iterates over the protocols of the map
    for (Protocol protocol : Protocol.PROTOCOLS_MAP.values()) {
        //Verify if the protocol id is the same
        if (protocol.getId() == protocolId) {
            // If they are the same the protocol is returned
            return protocol;
        }
    }
    //If no protocol is found then it returns null
    return null;
    }

}
