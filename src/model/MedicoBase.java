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
import java.util.Date;

/**
 *
 * @author emil
 */
public class MedicoBase extends Medico {
    
    private String username;
    private String psw;
    private String codiceRegionale;
    private String codiceFiscale;
    private String cognome;
    private String nome;
    private Date dataDiNascita;
    private String luogoDiNascita;
    private String tipoMedico;
    private String specializzazione;
    private Date dataSpecializzazione;
    
    public MedicoBase(String username , String psw , String codiceRegionale , String codiceFiscale , String cognome , String nome , Date dataDiNascita , String luogoDiNascita , String tipoMedico, String specializzazione, Date dataSpecializzazione) {
        super(username, psw, codiceRegionale, codiceFiscale, cognome, nome, dataDiNascita, luogoDiNascita, tipoMedico);
        this.specializzazione=specializzazione;
        this.dataSpecializzazione=dataSpecializzazione;
    }
    
    public MedicoBase(String key) {
        super(key);
        try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("SELECT nome_specialistica, data FROM Specialistica WHERE codice_medico ILIKE ?");
                    pst.clearParameters();
                    pst.setString(1, key);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Query Medico Base vuota");     
                        }
                    rs.next();
                    this.specializzazione=rs.getString("nome_specialistica");
                    this.dataSpecializzazione=rs.getDate("data");
                    System.out.println("Medico di base creato");
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
    
    public String getSpecializzazione() {
        return specializzazione;
    }
    
    public Date getDataSpecializzazione() {
        return dataSpecializzazione;
    }
    
    
}
