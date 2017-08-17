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
import java.util.concurrent.ThreadLocalRandom;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author emil
 */
public class PazienteControl {
    
    public static void insertPrescrizioneVisita(String codicePaziente){
        System.out.print("oh oh oh oh");
            try {
                Class.forName("org.postgresql.Driver");
                try(Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao")) {
                    PreparedStatement pst = con.prepareStatement("INSERT INTO prescrizione (codice_paziente,data_emissione,data_scadenza,farmaco0,farmaco1,farmaco2,farmaco3,farmaco4,usata,generici,ritirata,data_uso,pendente)"
                            + "                                             VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)");
                    pst.clearParameters();
                    pst.setString(1, codicePaziente);
                    //create date
                    java.util.Date myDate = new java.util.Date();
                    java.sql.Date sqlDate = new java.sql.Date(myDate.getTime());
                    pst.setDate(2, sqlDate);
                    Calendar c = Calendar.getInstance();
                    c.add(Calendar.YEAR, 1);
                    myDate = c.getTime();
                    sqlDate = new java.sql.Date(myDate.getTime());
                    pst.setDate(3, sqlDate);
                    //set farmaci
                    String farmaco1="Aspirina";
                    String farmaco2=null;
                    String farmaco3=null;
                    String farmaco4=null;
                    String farmaco5=null;
                    pst.setString(4, farmaco1);
                    pst.setString(5, farmaco2);
                    pst.setString(6, farmaco3);
                    pst.setString(7, farmaco4);
                    pst.setString(8, farmaco5);
                    //random number
                    int randomNum = ThreadLocalRandom.current().nextInt(0, 4 + 1);
                    System.out.print("random "+randomNum);
                    //listafarmaci
                    //ArrayList<String> listaFarmaci = new ArrayList<String>(control.FarmacoControl.getListaFarmaci());
                    ArrayList<String> listaFarmaci = new ArrayList<String>();
                    listaFarmaci = (ArrayList<String>)control.FarmacoControl.getListaFarmaci().clone();
                    System.out.print(listaFarmaci.size());
                    int size=listaFarmaci.size();
                        for(int i=0; i<randomNum;){
                        
                            int random = ThreadLocalRandom.current().nextInt(0, size-1  + 1);
                            pst.setString((i+4), listaFarmaci.get(random));
                            i++;
                        }
                    
                    //fine set farmaci
                    pst.setBoolean(9, false);
                    pst.setBoolean(10, false);
                    pst.setBoolean(11, false);
                    pst.setDate(12, null);
                    pst.setBoolean(13, false);
                    ResultSet rs = pst.executeQuery();
                    if(!rs.isBeforeFirst()) {
                      System.out.print("Query visita vuota");     
                        }
                    rs.next();
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
