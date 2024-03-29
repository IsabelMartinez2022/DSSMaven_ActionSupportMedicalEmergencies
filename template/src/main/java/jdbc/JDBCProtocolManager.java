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
        // Se itera sobre los valores del enum ProtocolType
        for (ProtocolType protocolType : ProtocolType.values()) {
            try {
                String sql = "INSERT INTO protocol (type) SELECT ? WHERE NOT EXISTS (SELECT 1 FROM protocol WHERE type = ? LIMIT 1);";
                PreparedStatement statement = cM.getConnection().prepareStatement(sql);
                statement.setString(1, protocolType.name());  
                statement.setString(2, protocolType.name()); // Para verificar si el tipo ya existe
                statement.executeUpdate();
                statement.close();
            } catch (SQLException ex) {
                Logger.getLogger(JDBCActionManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    @Override
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
    
    @Override
    public Protocol obtainProtocol(int protocolId) {
    // Iterar sobre los protocolos en el mapa
    for (Protocol protocol : Protocol.PROTOCOLS_MAP.values()) {
        // Comprobar si el ID del protocolo coincide
        if (protocol.getId() == protocolId) {
            // Si coincide, devolver el protocolo correspondiente
            return protocol;
        }
    }
    // Si no se encuentra el protocolo...
    return null;
    }

}
