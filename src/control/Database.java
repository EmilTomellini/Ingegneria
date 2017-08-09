/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
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
    
    private static Connection c = null;
    private static Statement stmt = null;
    
    public LinkedList<Object> getPazienti(){
		LinkedList<Object> result = new LinkedList<Object>();
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
                    System.out.println("miserabile");
                    System.exit(0);
                }
                
                
                
                
         return result;      
    }
}

