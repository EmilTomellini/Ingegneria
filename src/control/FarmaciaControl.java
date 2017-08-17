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

/**
 *
 * @author emil
 */
public class FarmaciaControl  {
    
    public static boolean checkQuantita(int n) {
            return !((n<0 || n>100));
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
        
    
    
    
       
    
    
    
    
    
    
    
    }

    
    
    
    

