/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import model.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
/**
 *
 * @author emil
 */
public class Database {
    
    private static Connection con = null;
    private static Statement st = null;
    
    public LinkedList<Paziente> getPazienti(){
		LinkedList<Paziente> result = new LinkedList<>();
                try {
                Class.forName("org.postgresql.Driver");
                }
                catch (ClassNotFoundException e){
                    System.out.print("Class not found");
                }
                
		try { 
                  Connection con= DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","ciao");
                  
                }
                catch ( SQLException e){
                    System.out.println("Database "+ e.getMessage());
                    System.exit(0);
                }

                
                
                
         return result;      
    }
}

