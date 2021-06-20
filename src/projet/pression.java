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
public class pression {
    File file = new File("./sensors/pression.txt");
    BufferedReader br = null;
    String cor;
   String status;
    ArrayList list;
    private static ObjectInputStream inObject;
    private static ObjectOutputStream outObject;

    public pression(){
        
        try {
         FileReader  fr = new FileReader(file);
         br = new BufferedReader(fr);
         list = new ArrayList();
         
         while((cor=br.readLine())!=null){
             list.add(cor);
         }
         int index = list.size()-1;
         int pr= Integer.parseInt((String) list.get(index));
         if(pr>=30)
               status="danger: high pression ";
         else status="normal";
         
         
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
                    pression g = new pression();
                    Socket s = new Socket("localhost",9999);
                    inObject = new ObjectInputStream(s.getInputStream());
                    outObject= new ObjectOutputStream(s.getOutputStream());
                    System.out.println(g.getstatus());
                    n.sendsens(outObject, "pression");
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
