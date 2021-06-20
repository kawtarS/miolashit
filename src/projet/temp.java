/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projet;
import java.io.*;
import java.net.Socket;
import java.util.*;
//import static projet.GPS.count;
/**
 *
 * @author AORUS
 */
public class temp {
     File file = new File("./sensors/temp.txt");
    BufferedReader br = null;
    String cor;
    static int count=1;
    Random r;
    int vi;
    
    ArrayList list;
    private static ObjectInputStream inObject;
    private static ObjectOutputStream outObject;

    public temp(){
        r=new Random();
        try {
         FileReader  fr = new FileReader(file);
         br = new BufferedReader(fr);
         list = new ArrayList();
         
         while((cor=br.readLine())!=null){
             list.add(cor);
         }
         int index = r.nextInt(list.size());
        vi= Integer.parseInt((String) list.get(index));
         
         
         
        } catch (FileNotFoundException ex) { System.out.println("file not found");} catch (IOException ex) {
           
        }
        
    }
    
    public int getstatus(){
        return vi;
    }
    public void gettemp (){
         netfunc n = new netfunc();
         
         Timer timer = new Timer();
            
        timer.schedule(new TimerTask() {

           
            
            @Override
            public void run(){
                try {
                    temp g = new temp();
                    Socket s = new Socket("localhost",9999);
                    inObject = new ObjectInputStream(s.getInputStream());
                    outObject= new ObjectOutputStream(s.getOutputStream());
                    System.out.println(g.getstatus());
                    n.sendsens(outObject, "temp");
                    n.sendstatus(outObject, count+","+g.getstatus());
                    
//                    s.close();
                    count++;
                } catch (IOException ex) {
                    System.out.println(ex);
                }
                
                
                
                
            }
             
            
         }, 0, 10000);
    
         
     }
}
