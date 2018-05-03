/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package textarray;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author One
 */
public class ServerListener extends Thread {
    ServerSocket ss;
    int port;
    Socket cs;
    DataInputStream dis;
    DataOutputStream dos;
    ArrayList<String> list = new ArrayList<String>();
    ObjectInputStream ois;
    ObjectOutputStream oos;   
    
    String s;
   
    @Override 
    public void run() {
            try {
                System.out.append("started server thread run\n");
                cs = ss.accept();
                dis = new DataInputStream(cs.getInputStream());
                dos = new DataOutputStream(cs.getOutputStream());
                oos = new ObjectOutputStream(cs.getOutputStream());
                ois = new ObjectInputStream(cs.getInputStream());
               
                
                System.out.append("Client Connected\n");
            //list.add("d");
            while(true) {
                s = dis.readUTF();
                if (s.equals("0")) {
                    if (!list.isEmpty()) {
                   // System.out.append("00000\n");
                   oos.reset();
                    System.out.println(list);
                    oos.writeObject(list);
                    //oos.flush();
                    }
                }
                else {
                    list.add(s);
                    System.out.append(s + "\n");
                     }           
            }
               
            } catch (IOException ex) {
                Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
            }
        
                    
   }
   
   public ServerListener(int port, InetAddress ip) {
        try {   
            ss= new ServerSocket(port, 0 , ip);
           
        } catch (IOException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
   }
   
  }
