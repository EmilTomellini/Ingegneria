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
import java.util.Calendar;
import java.util.HashMap;


/**
 *
 * @author emil
 */
public class PrescrizioneControl {
    
    public static ArrayList<String> getListaFarmaci(String codicePaziente, String codicePrescrizione) {
        
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
                        
                        if(rs.getString("farmaco1") == null)
                            break;
                        else
                            lista.add(rs.getString("farmaco1"));
                        
                        if(rs.getString("farmaco2") == null)
                            break;
                        else
                            lista.add(rs.getString("farmaco2"));
                        
                        if(rs.getString("farmaco3") == null)
                            break;
                        else
                            lista.add(rs.getString("farmaco3"));
                        
                        if(rs.getString("farmaco4") == null)
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
                    return true;
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
                    pst.executeUpdate();
                    
                    pst = con.prepareStatement("UPDATE prescrizione SET data_uso = ? WHERE codice = ?");
                    pst.clearParameters();
                    pst.setDate(1, sqlDate);
                    pst.setInt(2, Integer.parseInt(codice));
                    pst.executeUpdate();
                    
                    pst = con.prepareStatement("UPDATE prescrizione SET generici = ? WHERE codice = ?");
                    pst.clearParameters();
                    pst.setBoolean(1, generico);
                    pst.setInt(2, Integer.parseInt(codice));
                    pst.executeUpdate();
                    
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
    public static String prescrizoniUso (String codicePaziente){
        
               String result=new String("");
       try{
            Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                 PreparedStatement pst = con.prepareStatement("SELECT codice from Prescrizione Where codice_paziente = ? And usata = false and ritirata=true" );
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Errore faramco inisistente");     
                        }
                    
                    while (rs.next()){
                        result=result + " " + ( rs.getString("codice") );
                    }
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
    
    
    
    public static String usoGenerico (String codicePaziente){
        
               String result=new String("");
       try{
            Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                 PreparedStatement pst = con.prepareStatement("SELECT codice from Prescrizione Where codice_paziente = ? And usata = true And generici= true");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Errore faramco inisistente");     
                        }
                    
                    while (rs.next()){
                        result=result + " " + ( rs.getString("codice") );
                    }
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
    
    
      public static HashMap<String, Integer> farmaciPazienti(String codicePaziente, int data){
        
               HashMap<String, Integer> result = new HashMap<>();
               Calendar calendar = Calendar.getInstance();
               java.util.Date today = calendar.getTime();
               calendar.add(Calendar.MONTH, -data);
               java.util.Date modified = calendar.getTime();
               java.sql.Date sqlToday = new java.sql.Date(today.getTime());
               java.sql.Date sqlModified = new java.sql.Date(modified.getTime());
               
               
               ArrayList<String> farmaci = FarmacoControl.getListaFarmaci();
               for (String s:farmaci){
                   result.put(s,0);
               }
       try{
            Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                 PreparedStatement pst = con.prepareStatement("SELECT farmaco0 from Prescrizione Where codice_paziente = ? And usata = true And generici= true AND (data_emissione BETWEEN (? AND ?))");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    pst.setDate(2, sqlModified);
                    pst.setDate(3, sqlToday);
                    ResultSet rs = pst.executeQuery();
                    while (rs.next()){
                        String farmaco = rs.getString("farmaco0");
                        
                        if (result.containsKey(farmaco)){
                            int i = result.get(farmaco);
                            result.put(farmaco, i++);
                        }
   
                        
                    }
                    
                    pst = con.prepareStatement("SELECT farmaco1 from Prescrizione Where codice_paziente = ? And usata = true And generici= true AND (data_emissione BETWEEN (? AND ?))");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    pst.setDate(2, sqlModified);
                    pst.setDate(3, sqlToday);
                    rs = pst.executeQuery();
                    while (rs.next()){
                        String farmaco = rs.getString("farmaco1");
                        
                        if (result.containsKey(farmaco)){
                            int i = result.get(farmaco);
                            result.put(farmaco, i++);
                        }
   
                        
                    }
                        pst = con.prepareStatement("SELECT farmaco2 from Prescrizione Where codice_paziente = ? And usata = true And generici= true AND (data_emissione BETWEEN (? AND ?))");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    pst.setDate(2, sqlModified);
                    pst.setDate(3, sqlToday);
                    rs = pst.executeQuery();
                    while (rs.next()){
                        String farmaco = rs.getString("farmaco2");
                        
                        if (result.containsKey(farmaco)){
                            int i = result.get(farmaco);
                            result.put(farmaco, i++);
                        }
   
                        
                    }
                        pst = con.prepareStatement("SELECT farmaco3 from Prescrizione Where codice_paziente = ? And usata = true And generici= true AND (data_emissione BETWEEN (? AND ?))");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    pst.setDate(2, sqlModified);
                    pst.setDate(3, sqlToday);
                    rs = pst.executeQuery();
                    while (rs.next()){
                        String farmaco = rs.getString("farmaco3");
                        
                        if (result.containsKey(farmaco)){
                            int i = result.get(farmaco);
                            result.put(farmaco, i++);
                        }
   
                        
                    }
                        pst = con.prepareStatement("SELECT farmaco4 from Prescrizione Where  codice_paziente = ? And usata = true And generici= true AND (data_emissione BETWEEN (? AND ?))");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    pst.setDate(2, sqlModified);
                    pst.setDate(3, sqlToday);
                    rs = pst.executeQuery();
                    while (rs.next()){
                        String farmaco = rs.getString("farmaco4");
                        
                        if (result.containsKey(farmaco)){
                            int i = result.get(farmaco);
                            result.put(farmaco, i++);
                        }
   
                        
                    }

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
