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
public class Farmaco {
    
    private String nome;
    private float prezzo;
    private String formato;
    private String controIndicazioni;
    private String classeAtc;
    private String principioAttivo;
    private String descrizionePrincipio;
    private String effettoPrincio;
    private String quantitaPrincipio;
    
   
    public Farmaco (String key) {

        try {
            Class.forName("org.postgresql.Driver");
            try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                PreparedStatement pst = con.prepareStatement("SELECT *  FROM Farmaco WHERE nome ILIKE ?");
                pst.clearParameters();
                pst.setString(1, key);
                ResultSet rs = pst.executeQuery();
                 if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non trovato");
                  }
                rs.next();
                this.nome=rs.getString("nome");
                this.prezzo=rs.getFloat("costo");
                this.formato=rs.getString("forma_farmaceutica");
                this.controIndicazioni=rs.getString("controindicazioni");
                this.classeAtc=rs.getString("classe_atc");
                                
                pst = con.prepareStatement("SELECT * FROM principio_attivo WHERE farmaco ILIKE ?");
                pst.clearParameters();
                pst.setString(1, key);
                rs = pst.executeQuery();
                 if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non trovato");
                  }
                rs.next();
                this.principioAttivo=rs.getString("nome");
                this.descrizionePrincipio=rs.getString("descrizione");
                this.effettoPrincio=rs.getString("effetto");
                
                pst = con.prepareStatement("SELECT * FROM quantita WHERE nome_farmaco ILIKE ?");
                pst.clearParameters();
                pst.setString(1, key);
                rs = pst.executeQuery();
                 if(!rs.isBeforeFirst()) {
                      System.out.print("Farmaco non trovato");
                  }
                rs.next();
                this.quantitaPrincipio=rs.getString("quantita");                
               
                System.out.println("faramco creato");
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
    
   public String prezzo(){
      
       Float price = this.prezzo;
       return price.toString();
   }
    
     public float prezzoF(){
      
       return this.prezzo;

   }
   
   
}
