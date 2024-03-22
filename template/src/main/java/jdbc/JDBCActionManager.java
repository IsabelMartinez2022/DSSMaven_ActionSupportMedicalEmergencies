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

/**
 *
 * @author maria
 */
public class JDBCActionManager implements ActionManager{
    private JDBCManager manager;
    
    public JDBCActionManager (JDBCManager m){
        this.manager=m;
    }
    
    @Override
    public void addAction() {
        // Se itera sobre los valores del enum ActionType.
        for (ActionType actionType : ActionType.values()) {
            try {
                String sql = "INSERT INTO action (type, instruction) VALUES (?, ?)";
                PreparedStatement statement = manager.getConnection().prepareStatement(sql);
                statement.setString(1, actionType.name()); 
                statement.setString(2, actionType.getInstruction()); 
                
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
