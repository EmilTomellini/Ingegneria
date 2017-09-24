/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
    public static String reazioniAvvesrse (String nomeFarmaco){
        String result=new String("");
       try{
            Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                 PreparedStatement pst = con.prepareStatement("SELECT controindicazioni FROM Farmaco WHERE nome ILIKE ?");
                    pst.clearParameters();
                    pst.setString(1, nomeFarmaco);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Errore faramco inisistente");     
                        }
                    rs.next();
                    result= rs.getString("controindicazioni");
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
            
    return result;
        
        
        
    }
        
}
