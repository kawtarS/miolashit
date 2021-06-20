/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.io.*;
import java.util.*;
import java.net.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AORUS
 */
public class netfunc {
    
    public  void sendstatus(ObjectOutputStream outObject,String s){
        try {
            outObject.writeUTF(s);
            outObject.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
   
    public  void sendmac(ObjectOutputStream outObject,String s){
        try {
            outObject.writeUTF(s);
            outObject.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
     public  void sendsens(ObjectOutputStream outObject,String s){
        try {
            outObject.writeUTF(s);
            outObject.flush();
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }
    
}
