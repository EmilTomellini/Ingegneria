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
public class FarmaciaControl  {
    
    public static boolean checkQuantita(int n) {
            return !((n<0 || n>100));
            }
          
    
    public static ArrayList<String> listaNomiFarmacie() {
                
            ArrayList<String> farmacie= new ArrayList<String>();
          try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    Statement st = con.createStatement();
                    System.out.print("banana");
                    ResultSet rs = st.executeQuery("SELECT DISTINCT nome, codice FROM Farmacia ORDER BY nome");
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Lista farmacie vuota");     
                        }
                    while(rs.next()) {
                        System.out.print(rs.getString("nome"));
                        farmacie.add(rs.getString("nome"));
                        }
                    System.out.println("lista farmacie creata");
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
        
        return farmacie;

      }
    
        public static ArrayList<String> listaCodiciFarmacie() {
                
            ArrayList<String> farmacie= new ArrayList<String>();
          try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    Statement st = con.createStatement();
                    System.out.print("banana");
                    ResultSet rs = st.executeQuery("SELECT DISTINCT nome, codice FROM Farmacia ORDER BY nome");
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Lista farmacie vuota");     
                        }
                    while(rs.next()) {
                        System.out.print(rs.getString("nome"));
                        farmacie.add(rs.getString("codice"));
                        }
                    System.out.println("lista farmacie creata");
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
        
        return farmacie;

      }

    public static boolean checkEsistenza(String s){
        
         try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("SELECT nome FROM Farmaco WHERE nome ILIKE ? ");
                    pst.clearParameters();
                    pst.setString(1, s);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non esistente");
                        rs.close();
                        pst.close();
                        con.close();
                        return false;
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

         return true;
        }

    public static void updateFaramcoGenerico(String nomeFarmaco, String codiceFarmacia, int quantita){
        
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("UPDATE Farmacia SET quantita_generico=quantita_generico+ ? WHERE codice ILIKE ? AND farmaco ILIKE ?");
                    pst.clearParameters();
                    pst.setInt(1, quantita);
                    pst.setString(2, codiceFarmacia);
                    pst.setString(3, nomeFarmaco);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non esistente");

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
     
    

    public static void updateFaramcoMarca(String nomeFarmaco, String codiceFarmacia, int quantita){
        
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("UPDATE Farmacia SET quantita_marca=quantita_marca + ? WHERE codice ILIKE ? AND farmaco ILIKE ?");
                    pst.clearParameters();
                    pst.setInt(1, quantita);
                    pst.setString(2, codiceFarmacia);
                    pst.setString(3, nomeFarmaco);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non esistente");

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
        
 
    public static void inserimentoNuovoFaramcoGenerico(String nomeFarmaco, model.Farmacia fm, int quantita){
        
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Farmacia (nome, username, codice, farmaco, quantita_marca, quantita_generico) VALUES (?,?,?,?,?,?)");
                    pst.clearParameters();
                    pst.setString(1, fm.getNome());
                    pst.setString(2, fm.getUser());        
                    pst.setString(3, fm.getPsw());
                    pst.setString(4, nomeFarmaco);
                    pst.setInt(5, 0);
                    pst.setInt(6, quantita); 
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Inserimeto errato");

                        }
                    rs.next();
                    System.out.println("Inserimento avvenuto con successo");
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
        
 
    public static void inserimentoNuovoFaramcoMarca(String nomeFarmaco, model.Farmacia fm, int quantita){
        
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO Farmacia (nome, username, codice, farmaco, quantita_marca, quantita_generico) VALUES (?,?,?,?,?,?)");
                    pst.clearParameters();
                    pst.setString(1, fm.getNome());
                    pst.setString(2, fm.getUser());        
                    pst.setString(3, fm.getPsw());
                    pst.setString(4, nomeFarmaco);
                    pst.setInt(5, quantita);
                    pst.setInt(6, 0); 
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Inserimeto errato");

                        }
                    rs.next();
                    System.out.println("Inserimento avvenuto con successo");
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
    
    //forse da cambiare per controllo errore mancanza farmaci
    public static void ritiraFarmaciGenerico(String paziente, String codicePrescrizione, String codiceFarmacia) {
              
            ArrayList<String> listaFarmaci = control.PrescrizioneControl.getListaFarmaci(paziente, codicePrescrizione);
            PreparedStatement pst;
            
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    
                    
                    pst = con.prepareStatement("UPDATE Farmacia SET quantita_generico = quantita_generico-1 WHERE codice ILIKE ? AND farmaco ILIKE ? ");
                    pst.clearParameters();
                    pst.setString(1, codiceFarmacia);
                    
                    for(int i=0;i<listaFarmaci.size();i++){
                        pst.setString(2, listaFarmaci.get(i));
                        pst.executeUpdate();
                    }
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
    
    
    public static void ritiraFarmaciMarca(String paziente, String codicePrescrizione, String codiceFarmacia) {
              
            ArrayList<String> listaFarmaci = control.PrescrizioneControl.getListaFarmaci(paziente, codicePrescrizione);
            PreparedStatement pst;
            
             try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    
                    pst = con.prepareStatement("UPDATE Farmacia SET quantita_marca = quantita_marca-1 WHERE codice ILIKE ? AND farmaco ILIKE ? ");
                    pst.clearParameters();
                    pst.setString(1, codiceFarmacia);
                    
                    for(int i=0;i<listaFarmaci.size();i++){
                         pst.setString(2, listaFarmaci.get(i));
                         pst.executeUpdate();
                    }
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

    
    
    
    

