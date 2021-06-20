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
public class vitesse {
    File file = new File("./sensors/vitesse.txt");
    BufferedReader br = null;
    String cor;
    String status;
    ArrayList list;
    private static ObjectInputStream inObject;
    private static ObjectOutputStream outObject;
    
    public vitesse(){
        
        try {
         FileReader  fr = new FileReader(file);
         br = new BufferedReader(fr);
         ArrayList list = new ArrayList();
         
         while((cor=br.readLine())!=null){
             list.add(cor);
         }
         int index = list.size()-1;
         int vi= Integer.parseInt((String) list.get(index));
         if(vi>=200)
               status = "danger";
         else status =" good ";
         
         
        } catch (FileNotFoundException ex) { System.out.println("file not found");} catch (IOException ex) {
           
        }
        
    }
    
       public String getstatus(){
        return status;
    }
    public  void getvitesse (){
         netfunc n = new netfunc();
         
         Timer timer = new Timer();
            
        timer.schedule(new TimerTask() {

           
            
            @Override
            public void run(){
                try {
                    vitesse g = new vitesse();
                    Socket s = new Socket("localhost",9999);
                    inObject = new ObjectInputStream(s.getInputStream());
                    outObject= new ObjectOutputStream(s.getOutputStream());
                    System.out.println(g.getstatus());
                    n.sendsens(outObject, "vitesse");
                    n.sendstatus(outObject, g.getstatus());
                    
//                    s.close();
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                
                
                
            }
             
            
         }, 0, 10000);
         //timer.schedule(thread.start, 0, 5000);
         
     }
}
