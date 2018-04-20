/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointGUI;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
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
    ArrayList<ClientThread> ct;
    
    public ServerListener(int port) {
        System.out.append("server started\n");
        this.port = port;
        try {
            ss = new ServerSocket(port, 0, InetAddress.getLocalHost());
            ct = new ArrayList<>();
            System.out.append("server socket created\n");
        } catch (UnknownHostException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public void run() {
        while(true) {
            try {
                System.out.append("started server thread run\n");
                cs = ss.accept();
                ClientThread ctt = new ClientThread(cs);
                ct.add(ctt);
                ctt.start();
            } catch (IOException ex) {
                Logger.getLogger(ServerListener.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
