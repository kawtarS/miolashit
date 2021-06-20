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
import BD.*;

/**
 *
 * @author AORUS
 */
public class server  {
   static crud_capteur cap ;
   static String mac;
   private  static Socket s;
   private static ServerSocket ss;
    public static ObjectOutputStream outObject;
    public static ObjectInputStream inObject;
  
   public server (){
       try {
           cap= new crud_capteur();
           ss = new ServerSocket(9999);

           
       } catch (IOException ex) {
           System.out.println(ex);
       }
       
   }
   public void returnsoc(){
       try {
           s = ss.accept();
           outObject= new ObjectOutputStream(s.getOutputStream());
           inObject = new ObjectInputStream(s.getInputStream());
       } catch (IOException ex) {
           
       }
   }
   public static void main(String[] args){
      netfunc n = new netfunc();
      
   Thread thread1 = new Thread(){
    @Override
    public void run() {
       server sss = new server();
       
        while(true){
            sss.returnsoc();
        Thread thread = new Thread(){
            public void run(){
                try{
                    String info;
                    while(true){
                        info = inObject.readUTF();
                        switch(info){
                            case "mac": 
                                  mac = cap.getmac("GPS");
                                       //if(mac!=null) 
                                  n.sendmac(outObject,mac);
                                       
                            case "gps" :
                                System.out.println("gps");       
//                                String sgps = inObject.readUTF();
//                                System.out.println("les cordonnes gps :"+sgps);
//                                outObject.flush();
                                break;
                            case "temp":
                                String stemp = inObject.readUTF();
                                System.out.println("niveau du temperature :"+stemp);
                                break;
                            case "vitesse":
                                String svit = inObject.readUTF();
                                System.out.println("status du vitesse :"+svit);
                                break;
                            case "pression":
                                String spress = inObject.readUTF();
                                System.out.println("status du pression :"+spress);
                                break;
                            case "mov":
                                String smov = inObject.readUTF();
                                System.out.println("status du movement :"+smov);
                                break;
                            case "lock" :
                                String slock = inObject.readUTF();
                                System.out.println("verouillage :"+slock);
                                break;
                                
                        }
                    }
                    

                }catch(IOException ex){
                   // System.out.println(ex);
                }
            }
        };
        thread.start();
    }
    }
    
};
    thread1.start();
           }
}
