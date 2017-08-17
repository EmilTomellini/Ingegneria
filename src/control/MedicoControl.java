/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author emil
 */
public class MedicoControl {
    
    public static void effettuaPrescrizioni(){
        
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    
                    try (Statement st = con.createStatement()) {
                        System.out.print("eseguo update");
                        st.executeUpdate("UPDATE Prescrizione SET pendente = TRUE where pendente = FALSE ");
                    }
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
     
    

    
        
    
    
    
}
