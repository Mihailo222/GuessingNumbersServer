/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class PokreniServer extends Thread{

    
    ServerSocket ssocket;
    Socket socket;
    ObradaKlijentskogZahteva okz;
    
    
    
    @Override
    public void run() {
        
        try {
            ssocket = new ServerSocket(9000);
            System.out.println("Server je pokrenut...");
            while(true){
                
                socket = ssocket.accept();
                System.out.println("Klijent se povezao.");
                okz = new ObradaKlijentskogZahteva(socket);
                okz.start();
                
                
                
                
                
                
                
                
                
                
                
                
            }
            
            
            
 
            
            
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}
