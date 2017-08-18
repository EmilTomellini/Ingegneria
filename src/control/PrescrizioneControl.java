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
import java.util.ArrayList;

/**
 *
 * @author emil
 */
public class PrescrizioneControl {
    
    public static ArrayList<String> getListaFarmaci(String codicePaziente, String codicePrescrizione) {
        String s = new String();
        ArrayList<String> lista = new ArrayList<String>();
            try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("SELECT farmaco0, farmaco1, farmaco2, farmaco3, farmaco4 FROM Prescrizione WHERE codice_paziente ILIKE ? AND codice = ?");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    pst.setInt(2, Integer.parseInt(codicePrescrizione));
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non esistente");
                        rs.close();
                        pst.close();
                        con.close();
                        }
                    while(rs.next()) {
                        lista.add(rs.getString("farmaco0"));
                        
                        if(rs.getString("farmaco1").equals(s))
                            break;
                        else
                            lista.add(rs.getString("farmaco1"));
                        
                        if(rs.getString("farmaco2").equals(s))
                            break;
                        else
                            lista.add(rs.getString("farmaco2"));
                        
                        if(rs.getString("farmaco3").equals(s))
                            break;
                        else
                            lista.add(rs.getString("farmaco3"));
                        
                        if(rs.getString("farmaco4").equals(s))
                            break;
                        else
                            lista.add(rs.getString("farmaco4"));
                        
                        }
                    System.out.println("lista farmaci creata");
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


         return lista;
        }
    
    public static boolean checkUsoPrescrizione(String codice) {
            
            try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("SELECT codice FROM Prescrizione WHERE codice = ? AND usata = FALSE");
                    pst.clearParameters();
                    pst.setInt(1, Integer.parseInt(codice));
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("prescrizione usata");
                        rs.close();
                        pst.close();
                        con.close();
                        return false;
                        }
                    rs.next();
                    System.out.println("prescrizione non usata");
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
    
            return true;
        }
    
    public static void setUsoPrescrizione(String codice, boolean generico) {
        
            java.util.Date myDate = new java.util.Date();
            java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
    
            try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("UPDATE prescrizione SET usata = TRUE WHERE codice = ?");
                    pst.clearParameters();
                    pst.setInt(1, Integer.parseInt(codice));
                    ResultSet rs = pst.executeQuery();
                    
                    pst = con.prepareStatement("UPDATE prescrizione SET data_uso = ? WHERE codice = ?");
                    pst.clearParameters();
                    pst.setDate(1, sqlDate);
                    pst.setInt(2, Integer.parseInt(codice));
                    rs = pst.executeQuery();
                    
                    pst = con.prepareStatement("UPDATE prescrizione SET generici = ? WHERE codice = ?");
                    pst.clearParameters();
                    pst.setBoolean(1, generico);
                    pst.setInt(2, Integer.parseInt(codice));
                    rs = pst.executeQuery();
                    
                    
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non esistente");
                        rs.close();
                        pst.close();
                        con.close();
                        }
                    rs.next();
                    System.out.println("Faramco esitente");
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
    
}
