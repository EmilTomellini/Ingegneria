/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author emil
 */
public class Paziente {
    
    private String username;
    private String psw;
    private String codiceUnivoco;
    private String cognome;
    private String nome;
    private Date dataDiNascita;
    private String luogoDiNascita;
    private String indirizzo;
    private String codiceMedico;
    private boolean cronico;
    private ArrayList<String> fattoriDiRischio;
    
    
    public Paziente(String username,String psw, String codiceUnivoco, String cognome, String nome, Date dataDiNascita, String luogoDiNascita, String indirizzo, String codiceMedico, 
                            boolean cronico, ArrayList<String> fattoriDiRischio) {
    
        this.username=username;
        this.psw=psw;
        this.codiceUnivoco=codiceUnivoco;
        this.cognome=cognome;
        this.nome=nome;
        this.dataDiNascita=dataDiNascita;
        this.luogoDiNascita=luogoDiNascita;
        this.indirizzo=indirizzo;
        this.codiceMedico=codiceMedico;
        this.cronico=cronico;
        this.fattoriDiRischio=fattoriDiRischio;
    
    }
    
    
    public Paziente(String key) {
           try { 
                  Class.forName("org.postgresql.Driver");
                  Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  //recupero lista user
                  PreparedStatement pst = con.prepareStatement("SELECT * FROM Paziente P WHERE P.codice_univoco ILIKE ?");
                  pst.clearParameters();
                  pst.setString(1, key);
                  ResultSet rs = pst.executeQuery();
                  //aggiunto rs.next() stesso motivo del login control
                  rs.next();
                  this.username  = rs.getString("username");
                  this.psw = rs.getString("psw");
                  this.codiceUnivoco = rs.getString("codice_univoco");
                  this.cognome = rs.getString("cognome");
                  this.nome = rs.getString("nome");
                  this.dataDiNascita  = rs.getDate("data_nascita");
                  this.luogoDiNascita= rs.getString("luogo_nascita");
                  this.indirizzo = rs.getString("indirizzo");
                  this.cronico  = rs.getBoolean("cronico");
                  this.codiceMedico = rs.getString("codice_medico");
                  pst = con.prepareStatement("SELECT * FROM Fattore_di_rischio WHERE codice_paziente ILIKE ?");
                  pst.clearParameters();
                  pst.setString(1, key);
                  rs = pst.executeQuery();
                  ArrayList<String> fattoriDiRischio = new ArrayList<>();
                  while ( rs.next() ) {
                      String fattoreDiRischio = rs.getString("fattore_rischio");
                      fattoriDiRischio.add(fattoreDiRischio);
                    }
                  this.fattoriDiRischio=fattoriDiRischio;
                  System.out.print("paziente creato");
                  
                }
                catch (ClassNotFoundException | SQLException e){
                    System.out.println("creazione paziente fallita" + e.getMessage());
                }
    
    
    
    }
    
    public String getCodice() {
        return codiceUnivoco;
    }
    
    public String getCognome() {
        return cognome;
    }
    
    public String getName() {
           return nome;
    }
    
    public Date getDataNascita() {
        return dataDiNascita;
    }
    
    public String getLuogoNascita() {
        return luogoDiNascita;
    }
        
    public String getIndirizzo() {
        return indirizzo;
    }
    
    public String getCodiceMedico() {
        return codiceMedico;
    }
    
    public boolean getCronico() {
        return cronico;
    }
    
    public ArrayList<String> getFattori() {
        return fattoriDiRischio;
    }
    
    public String getFattoriToString() {
        String result=new String();
        for(String fattore: fattoriDiRischio)
            result=result+fattore+" ";
        return result;
    }
    
}
