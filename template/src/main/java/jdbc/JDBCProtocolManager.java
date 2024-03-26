/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.ProtocolManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Action;
import pojos.ActionType;
import pojos.Protocol;
import pojos.ProtocolType;

public class JDBCProtocolManager implements ProtocolManager{
    
    private ConnectionManager cM;

    public JDBCProtocolManager(ConnectionManager cManager) {
        this.cM = cManager;
    }
    
    @Override
    public void addProtocol() {
        // Se itera sobre los valores del enum ActionType.
        for (ProtocolType protocolType : ProtocolType.values()) {
            try {
                String sql = "INSERT INTO protocol (type)" + "VALUES (?);";
                PreparedStatement statement = cM.getConnection().prepareStatement(sql);
                statement.setString(1, protocolType.name());  
                
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
    public Protocol getProtocolofPerson(int personId){
        List<Action> actions= new ArrayList<>();
        ProtocolType pType = null;
        Protocol protocol= null;
        
        try {
            
            String sql = "SELECT a.id AS actionId, a.type AS actionType, a.instruction AS actionInstruction, " +
                        "p.type AS protocolType " +
                        "FROM action AS a " +
                        "JOIN protocolAction AS pa ON a.id = pa.actionId " +
                        "JOIN protocol AS p ON pa.protocolId = p.id " +
                        "JOIN person AS per ON p.id = per.protocolId " +
                        "WHERE per.id = ?";
            
            PreparedStatement statement = cM.getConnection().prepareStatement(sql);
            statement.setInt(1, personId);
            ResultSet rs = statement.executeQuery();
            
            while (rs.next()) {
                ActionType aType= ActionType.valueOf(rs.getString("actionType"));
                Action action = new Action(aType);
                actions.add(action);
                
                    if (pType == null) {
                    pType = ProtocolType.valueOf(rs.getString("protocolType"));
        }
    }
            protocol= new Protocol(pType,actions);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return protocol; 
    }
    
    public int getProtocolId(String protocolType) {
    int protocolId = 0; // Inicializamos a 0 por si no se encuentra ningún protocolo

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
}
