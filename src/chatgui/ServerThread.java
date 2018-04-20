/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatgui;

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
public class ServerThread extends Thread {
    public static Socket cs;
    public ServerThread(Socket socket)  {
       cs = socket;
    }
    
    @Override
    public void run() {
    
		try {
			DataInputStream dis = new DataInputStream(cs.getInputStream());
			System.out.println("DataInputStream created");

			DataOutputStream dos = new DataOutputStream(cs.getOutputStream());
			System.out.println("DataOutputStream  created");

			while (!cs.isClosed()) {
                            
				System.out.println("Server reading from channel");
				String entry = dis.readUTF();
				System.out.println("READ from clientDialog message - " + entry);
				
				System.out.println("Server try writing to channel");
				dos.writeUTF("Server reply - " + entry + " - OK");
				System.out.println("Server Wrote message to clientDialog.");
				dos.flush();
			}
                        
			System.out.println("Client disconnected");
			System.out.println("Closing connections & channels.");

			dis.close();
			dos.close();
			cs.close();

			System.out.println("Closing connections & channels - DONE.");
		
                        
                        } catch (IOException e) {
			e.printStackTrace();
		}
    }   
}   
