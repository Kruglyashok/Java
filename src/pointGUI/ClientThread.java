/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pointGUI;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author One
 */
public class ClientThread  extends Thread {
    Socket cs;
    DataInputStream dis;
    DataOutputStream dos;
    
    
    
    public ClientThread(Socket css) {
        try {
            System.out.append(css.getInetAddress().toString() + "    ip" + "   " + css.getPort() + " port\n");
           // cs = new Socket(css.getInetAddress(),css.getPort());
            
           cs=css;
           dis = new DataInputStream(this.cs.getInputStream());
            dos = new DataOutputStream(this.cs.getOutputStream());
        } catch (IOException ex) {
            Logger.getLogger(ClientThread.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    public void run() {
    
    }
}
