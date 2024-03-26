/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ifaces;

import java.sql.Connection;

public interface InterfaceConnectionManager {
    public void disconnect();
    public void createTables();
    public Connection getConnection();
}
