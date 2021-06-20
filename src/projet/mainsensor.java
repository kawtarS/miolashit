/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 *
 * @author Zayrof
 */

public class mainsensor  {
    
    vitesse vit ; 
    temp temp;
    public static void main(String[] args) {
        Thread th = new Thread(){
               @Override
            public void run(){
               
                 netfunc n = new netfunc();
                try {
                  vitesse   vit = new vitesse();
                  temp temp = new temp();
                    Socket s = new Socket("localhost",9999);
                    ObjectInputStream inObject = new ObjectInputStream(s.getInputStream());
                ObjectOutputStream  outObject= new ObjectOutputStream(s.getOutputStream());
             
vit.getvitesse();
temp.gettemp();                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                
                
                
            }
        };
    }

   
}
