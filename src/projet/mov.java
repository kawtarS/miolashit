/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.io.*;
import java.net.Socket;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author AORUS
 */
public class mov {
    File file = new File("./sensors/mov.txt");
    BufferedReader br = null;
    String cor;
     String status;
    ArrayList list;
    private static ObjectInputStream inObject;
    private static ObjectOutputStream outObject;
    
    public mov(){
        
        try {
         FileReader  fr = new FileReader(file);
         br = new BufferedReader(fr);
         list = new ArrayList();
         
         while((cor=br.readLine())!=null){
             list.add(cor);
         }
         int index = list.size()-1;
         if(list.get(index).equals("-1"))
                status="warning !!!!!";
         else status="good";
         
         
        } catch (FileNotFoundException ex) { System.out.println("file not found");} catch (IOException ex) {
            Logger.getLogger(GPS.class.getName()).log(Level.SEVERE, null, ex);
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
                    mov g = new mov();
                    Socket s = new Socket("localhost",9999);
                    inObject = new ObjectInputStream(s.getInputStream());
                    outObject= new ObjectOutputStream(s.getOutputStream());
                    System.out.println(g.getstatus());
                    n.sendsens(outObject, "mov");
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
