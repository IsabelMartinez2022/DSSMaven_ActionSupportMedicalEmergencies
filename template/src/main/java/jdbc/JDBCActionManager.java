/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.ActionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Action;
import pojos.ActionType;

public class JDBCActionManager implements ActionManager{
    private ConnectionManager cM;
    
    public JDBCActionManager (ConnectionManager cManager){
        this.cM = cManager;
    }
    
    @Override
    public void addAction() {
        // Iterates over the enum ActionType values
        for (ActionType actionType : ActionType.values()) {
            try {
                String sql = "INSERT INTO action (type, instruction) SELECT ?, ? WHERE NOT EXISTS (SELECT 1 FROM action WHERE type = ? LIMIT 1)";
                PreparedStatement prep = cM.getConnection().prepareStatement(sql);
                prep.setString(1, actionType.name()); 
                prep.setString(2, actionType.getInstruction());
                prep.setString(3, actionType.name()); // Verify if the type already exists
                prep.executeUpdate();
                prep.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
}
