/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author emil
 */
public class Prescrizione {
    
    private String codice;
    private String codice_paziente;
    private Date data_emissione; 
    private Date data_scadenza;
    private String farmaco0;
    private String farmaco1;
    private String farmaco2; 
    private String farmaco3;
    private String farmaco4;
    private Boolean usata;
    private Boolean generici;
    private Date data_uso;
    private Boolean pendente;

    public Prescrizione (String key) {

        try {
            Class.forName("org.postgresql.Driver");
            try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                PreparedStatement pst = con.prepareStatement("SELECT *  FROM prescrizione WHERE nome ILIKE ?");
                pst.clearParameters();
                pst.setString(1, key);
                ResultSet rs = pst.executeQuery();
                 if(!rs.isBeforeFirst()) {
                      System.out.print("Prescrizione non trovata");
                  }
                this.codice=rs.getString("nome");
                this.codice_paziente=rs.getString("codice_paziente");
                this.data_emissione=rs.getDate("data_emissione");
                this.data_scadenza=rs.getDate("data_scadenza");
                this.farmaco0=rs.getString("farmaco0");
                this.farmaco0=rs.getString("farmaco1");
                this.farmaco0=rs.getString("farmaco2");
                this.farmaco0=rs.getString("farmaco3");
                this.farmaco0=rs.getString("farmaco4");
                this.usata=rs.getBoolean("usata");
                this.generici=rs.getBoolean("generici");
                this.data_uso=rs.getDate("data_uso");
                this.pendente=rs.getBoolean("pendente");
             
                
                                
                    rs.close();
                    pst.close();
                    con.close();
                }
        }
                catch(SQLException e) {
                    System.out.print(e.getMessage());
                }
            
            catch(ClassNotFoundException e) {
                System.out.print(e.getMessage());
            }

        }
    } 