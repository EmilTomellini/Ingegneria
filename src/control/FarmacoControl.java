/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author emil
 */
public class FarmacoControl {
    
    public static ArrayList<String> getListaFarmaci() {
        ArrayList<String> farmaci= new ArrayList<String>();
          try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    Statement st = con.createStatement();
                    System.out.print("banana");
                    ResultSet rs = st.executeQuery("SELECT nome FROM Farmaco");
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Lista farmaci vuota");     
                        }
                    while(rs.next()) {
                        System.out.print(rs.getString("nome"));
                        farmaci.add(rs.getString("nome"));
                        }
                    System.out.println("lista farmaci creata");
                    rs.close();
                    st.close();
                    con.close();
                }
                catch(SQLException e) {
                    System.out.print(e.getMessage());
                }
            }
            catch(ClassNotFoundException e) {
                System.out.print(e.getMessage());
            }  
        
        return farmaci;
    }
    
}
