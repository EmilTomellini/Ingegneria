/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


/**
 *
 * @author emil
 */
public class LoginControl {
    public static int authenticator(String user, char[] psw) throws ClassNotFoundException{
        
        String token = user.substring(0,2);
        String password = new String(psw);
        
        switch(token){
            case "pz":
                
		try { 
                  Class.forName("org.postgresql.Driver");
                  Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  //System.out.print(user +" "+ password);
                  //recupero lista user
                  PreparedStatement pst = con.prepareStatement("SELECT username, psw, codice_univoco FROM Paziente WHERE username ILIKE ? AND psw ILIKE ? ");
                  pst.clearParameters();
                  pst.setString(1, user);
                  pst.setString(2, password);
                  System.out.println(pst);
                  ResultSet rs = pst.executeQuery();
                  //controllo result set è vuoto
                  if(!rs.isBeforeFirst()) {
                      return -1;
                  }
                      /*
                      while(rs.next()){
                      System.out.println(rs.getString("username")+" "+rs.getString("codice_univoco")+" "+rs.getString("psw"));
                      }
                      */
                      //aggiunto per evitare un errore di sql
                  //rs.next();
                  String codiceUnivoco = rs.getString("codice_univoco");
                  model.Paziente pz = new model.Paziente(codiceUnivoco);
                  System.out.println("\nnome:  "+pz.getName());
                  rs.close();
                  pst.close();
                  con.close();
                  
                }
                catch (SQLException e){
                    System.out.println("strano paziente" + e.getMessage());
                };
                
                return 0;
                
            case "fm":
                
                try { 
                  Class.forName("org.postgresql.Driver");
                  Connection c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  //System.out.print(user +" "+ password);
                  //recupero lista user
                  PreparedStatement pst = c.prepareStatement("SELECT DISTINCT codice FROM Farmacia WHERE username ILIKE ? AND codice ILIKE ? ");
                  pst.clearParameters();
                  pst.setString(1, user);
                  pst.setString(2, password);
                  System.out.println(pst);
                  ResultSet rs = pst.executeQuery();
                  if(!rs.isBeforeFirst()) {
                      return -1;
                  }
                  while(rs.next()){
                    System.out.println("Codice farmacia: "+rs.getString("codice"));
                  }
                    
                  //aggiunto per evitare un errore di sql
                  rs.next();
                  String codice = rs.getString("codice");
                  
                  
                  rs.close();
                  pst.close();
                  c.close();
                  
                }
                catch (SQLException e){
                    System.out.println("strano farmacia " + e.getMessage());
                };
                
                return 1;
                
            case "mb":
                
                try { 
                  Class.forName("org.postgresql.Driver");
                  Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  //System.out.print(user +" "+ password);
                  //recupero lista user
                  PreparedStatement pst = con.prepareStatement("SELECT username, psw, codice_regionale FROM Medico WHERE username ILIKE ? AND psw ILIKE ? ");
                  pst.clearParameters();
                  pst.setString(1, user);
                  pst.setString(2, password);
                  System.out.println(pst);
                  ResultSet rs = pst.executeQuery(); 
                  //controllo result set è vuoto
                  if(!rs.isBeforeFirst()) {
                      return -1;
                  }
                  /*
                  while(rs.next()){
                    System.out.println(rs.getString("username")+" "+rs.getString("codice_regionale")+" "+rs.getString("psw"));
                  }
                    */
                  //aggiunto per evitare un errore di sql
                  rs.next();
                  String codiceUnivoco = rs.getString("codice_regionale");
                  model.MedicoBase mb = new model.MedicoBase(codiceUnivoco);
                  System.out.println("Nome medico: "+mb.getName());
                  rs.close();
                  pst.close();
                  con.close();
                  
                }
                catch (SQLException e){
                    System.out.println("strano medico" + e.getMessage());
                };
                
                return 2;
                
            case "mc":
                
                try { 
                  Class.forName("org.postgresql.Driver");
                  Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  //System.out.print(user +" "+ password);
                  //recupero lista user
                  PreparedStatement pst = con.prepareStatement("SELECT username, psw, codice_regionale FROM Medico WHERE username ILIKE ? AND psw ILIKE ? ");
                  pst.clearParameters();
                  pst.setString(1, user);
                  pst.setString(2, password);
                  System.out.println(pst);
                  ResultSet rs = pst.executeQuery(); 
                  //controllo result set è vuoto
                  if(!rs.isBeforeFirst()) {
                      return -1;
                  }
                  /*
                  while(rs.next()){
                    System.out.println(rs.getString("username")+" "+rs.getString("codice_regionale")+" "+rs.getString("psw"));
                  }
                    */
                  //aggiunto per evitare un errore di sql
                  rs.next();
                  String codiceUnivoco = rs.getString("codice_regionale");
                  model.Medico mc = new model.Medico(codiceUnivoco);
                  System.out.println("Nome medico: "+mc.getName());
                  rs.close();
                  pst.close();
                  con.close();
                  
                }
                catch (SQLException e){
                    System.out.println("strano medico" + e.getMessage());
                };
                
                return 3;
                
            case "ms":
                
                try { 
                  Class.forName("org.postgresql.Driver");
                  Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  //System.out.print(user +" "+ password);
                  //recupero lista user
                  PreparedStatement pst = con.prepareStatement("SELECT username, psw, codice_regionale FROM Medico WHERE username ILIKE ? AND psw ILIKE ? ");
                  pst.clearParameters();
                  pst.setString(1, user);
                  pst.setString(2, password);
                  System.out.println(pst);
                  ResultSet rs = pst.executeQuery(); 
                  //controllo result set è vuoto
                  if(!rs.isBeforeFirst()) {
                      return -1;
                  }
                  /*
                  while(rs.next()){
                    System.out.println(rs.getString("username")+" "+rs.getString("codice_regionale")+" "+rs.getString("psw"));
                  }
                    */
                  //aggiunto per evitare un errore di sql
                  rs.next();
                  String codiceUnivoco = rs.getString("codice_regionale");
                  model.Medico ms = new model.Medico(codiceUnivoco);
                  System.out.println("Nome medico: "+ms.getName());
                  rs.close();
                  pst.close();
                  con.close();
                  
                }
                catch (SQLException e){
                    System.out.println("strano medico" + e.getMessage());
                };
                
                return 3;
                
            default:
                return -1;
            
        }
        
    }
    
}