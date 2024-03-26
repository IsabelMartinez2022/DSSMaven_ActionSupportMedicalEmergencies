/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import ifaces.ActionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.Action;
import pojos.ActionType;

public class JDBCActionManager implements ActionManager{
    private ConnectionManager c;
    
    public JDBCActionManager (ConnectionManager c){
        this.c = c;
    }
    
    @Override
    public void addAction() {
        // Se itera sobre los valores del enum ActionType.
        for (ActionType actionType : ActionType.values()) {
            try {
                String sql = "INSERT INTO action (type, instruction)" + "VALUES (?, ?);";
                //aqui hacer tb lo del protocol
                PreparedStatement prep = c.getConnection().prepareStatement(sql);
                prep.setString(1, actionType.name()); 
                prep.setString(2, actionType.getInstruction());
                prep.executeUpdate();
                prep.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
