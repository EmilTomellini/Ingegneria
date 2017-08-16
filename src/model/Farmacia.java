/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emil
 */
public class Farmacia {
 
 private String username;
 private String codice;
 private String farmaco;
 private int quantita_marca;
 private int quantita_generico;
 

 public Farmacia (String key) {

        try {
            Class.forName("org.postgresql.Driver");
            try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                PreparedStatement pst = con.prepareStatement("SELECT *  FROM faramcia WHERE nome ILIKE ?");
                pst.clearParameters();
                pst.setString(1, key);
                ResultSet rs = pst.executeQuery();
                 if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non trovato");
                  }
                this.username=rs.getString("username");
                this.codice=rs.getString("codice");
                this.farmaco=rs.getString("farmaco");
                this.quantita_marca=rs.getInt("controIndicazioni");
                this.quantita_generico=rs.getInt("quantita_generico");
                                
                System.out.println("farmacia creata");
                rs.close();
                pst.close();
                con.close();
            }
            catch(SQLException e) {
                    System.out.print(e.getMessage());
                }
            }
            catch(ClassNotFoundException e) {
                System.out.print(e.getMessage());
            }
    }
    
   
    public String getPsw() {
           return codice;
        }
    
    
}
