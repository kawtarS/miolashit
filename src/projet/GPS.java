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
public class GPS implements Serializable {
    File file = new File("./sensors/gps.txt");
    BufferedReader br = null;
    String cor;
    String status;
    ArrayList list;
    static String mac;
    Random r;
    static Socket s;
    private static ObjectInputStream inObject;
    private static ObjectOutputStream outObject;
    
    public GPS(){
        
        try {
        s = new Socket("localhost",9999); 
        inObject = new ObjectInputStream(s.getInputStream());
        outObject= new ObjectOutputStream(s.getOutputStream());
        } catch (FileNotFoundException ex) { System.out.println("file not found");} catch (IOException ex) {
            Logger.getLogger(GPS.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    public void trait() {
        r=new Random();
         FileReader  fr = null;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            list = new ArrayList();
            while((cor=br.readLine())!=null){
                list.add(cor);
            }  int index = r.nextInt(list.size());
            if(list.get(index).equals("10,20"))
                
                status = "good";
            
            else
                status =" bad ";
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GPS.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(GPS.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fr.close();
            } catch (IOException ex) {
                Logger.getLogger(GPS.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
         
    }
     public String getlist(){
            int index = list.size()-1;
            return (String) list.get(index);
        }
    public String getstatus(){
        return status;
    }
    
    
     public static void main(String[] args){
         GPS g= new GPS();
         netfunc n = new netfunc();
         //int currentTime = 0;
         Timer timer = new Timer();
         System.out.println("first"); 
         Thread thread = new Thread(){
             @Override
            public void run(){
         try{
               
               
               n.sendsens(outObject,"mac");
               mac=inObject.readUTF();
                   System.out.println("second"); 
                    if(mac.equals("close")) 
                    {
                        System.out.println("sensor cant be activated");
                        System.exit(0);
                    }

                    System.out.println(mac); 
       
         }catch(Exception e){}
                     }
        };
        
        
         timer.schedule(new TimerTask() {
                    
            @Override
            public void run(){
                try{
        
                    g.trait();
                    n.sendsens(outObject, "gps");
                    n.sendstatus(outObject, g.getstatus()+"gps id: "+mac);
                    
         }catch(Exception e){}
                
          
            }
           
         }, 0, 2000);
         
         
        thread.start();
         //timer.schedule(thread.start, 0, 5000);
         
     }
}

