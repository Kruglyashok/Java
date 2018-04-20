/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatgui;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author One
 */
public class Client {
    
	/**
	 * 
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
				
		try {   
                        
                        Socket socket = new Socket(InetAddress.getLocalHost(), 1234);
                	DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
			DataInputStream dis = new DataInputStream(socket.getInputStream());
			
			System.out.println("Client connected to socket.");
			System.out.println();
			System.out.println("Client writing channel = oos & reading channel = ois initialized.");			
                         
                        while (true) {
                           
                        dos.writeUTF("from client\n");
                        String s = dis.readUTF();
                        
                        System.out.append(s);
                        Thread.sleep(5000);
                        }
                        
                        
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
