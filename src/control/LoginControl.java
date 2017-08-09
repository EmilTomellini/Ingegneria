/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;
import java.util.LinkedList;

/**
 *
 * @author emil
 */
public class LoginControl {
    public static int authenticator(String user, char[] psw){
        
        String token = user.substring(0,2);
        
        switch(token){
            case "pz":
                LinkedList<Object> pazienti = new control.Database().getPazienti();
                return 0;
                
            case "fm":
                return 1;
                
            case "mb":
                return 2;
                
            case "mc":
                return 3;
                
            case "ms":
                return 3;
                
            default:
                return -1;
            
        }
        
    }
    
}