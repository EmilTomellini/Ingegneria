/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
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
public class Medico {
    
    private String username;
    private String psw;
    private String codiceRegionale;
    private String codiceFiscale;
    private String cognome;
    private String nome;
    private Date dataDiNascita;
    private String luogoDiNascita;
    private String tipoMedico;
    
    public Medico(String username , String psw , String codiceRegionale , String codiceFiscale , String cognome , String nome , Date dataDiNascita , String luogoDiNascita , String tipoMedico) {
                this.username=username;
                this.psw=psw;
                this.codiceRegionale=codiceRegionale;
                this.codiceFiscale=codiceFiscale;
                this.cognome=cognome;
                this.nome=nome;
                this.dataDiNascita=dataDiNascita;
                this.luogoDiNascita=luogoDiNascita;
                this.tipoMedico=tipoMedico;
    }
    
    public Medico(String key) {
    
            System.out.println("oh oh oh ");
            try {
                Class.forName("org.postgresql.Driver");
                try(Connection con=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst=con.prepareStatement("SELECT * FROM Medico WHERE username ILIKE ?");
                    pst.clearParameters();
                    pst.setString(1, key);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                       System.out.print("ResultSet vuoto");
                         }
                    rs.next();
                    this.username=rs.getString("username");
                    this.psw=rs.getString("psw");
                    this.codiceRegionale=rs.getString("codice_regionale");
                    this.codiceFiscale=rs.getString("codice_fiscale");
                    this.cognome=rs.getString("cognome");
                    this.nome=rs.getString("nome");
                    this.dataDiNascita=rs.getDate("data_nascita");
                    this.luogoDiNascita=rs.getString("luogo_nascita");
                    this.tipoMedico=rs.getString("tipo_medico").toLowerCase();
                    
                    System.out.println("Medico "+tipoMedico +" creato");
                    
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
    
    
    public String getCodiceRegionale() {
        return codiceRegionale;
    }
    
    public String getCodiceFiscale() {
        return codiceFiscale;
    }
    
    public String getName() {
        return nome;
    }  
    
    public String getCognome() {
        return cognome;
    }
    
    public Date getDataNascita() {
        return dataDiNascita;
    }
    
    public String getLuogoNascita() {
        return luogoDiNascita;
    }
    
    public String getTipo() {
        return tipoMedico;
    }
    
}
