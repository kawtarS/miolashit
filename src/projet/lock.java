/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;

import java.io.*;
import java.net.Socket;
import java.util.*;

/**
 *
 * @author AORUS
 */
public class lock {
    File file = new File("./sensors/lock.txt");
    BufferedReader br = null;
    String cor;
    String status;
     ArrayList list;
    private static ObjectInputStream inObject;
    private static ObjectOutputStream outObject;
    public lock(){
        
        try {
         FileReader  fr = new FileReader(file);
         br = new BufferedReader(fr);
       list = new ArrayList();
         
         while((cor=br.readLine())!=null){
             list.add(cor);
         }
         int index = list.size()-1;
         if(list.get(index).equals("on"))
               status="locked";
         else status= "unlocked";
         
         
        } catch (FileNotFoundException ex) { System.out.println("file not found");} catch (IOException ex) {
            
        }
        
    }
     public String getstatus(){
        return status;
    } 
    
     public static void main(String[] args){
         netfunc n = new netfunc();
         
         Timer timer = new Timer();
            
        timer.schedule(new TimerTask() {

           
            
            @Override
            public void run(){
                try {
                    lock g = new lock();
                    Socket s = new Socket("localhost",9999);
                    inObject = new ObjectInputStream(s.getInputStream());
                    outObject= new ObjectOutputStream(s.getOutputStream());
                    //System.out.println(g.getlist());
                    n.sendsens(outObject, "lock");
                    n.sendstatus(outObject, g.getstatus());
                    
                    s.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                
                
                
            }
             
            
         }, 0, 10000);
         //timer.schedule(thread.start, 0, 5000);
         
     }

    
    
}
