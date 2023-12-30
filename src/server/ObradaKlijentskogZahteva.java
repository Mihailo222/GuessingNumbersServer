/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import controller.Controller;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.SkriveniBroj;
import model.User;
import operacije.Operacije;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Acer
 */
public class ObradaKlijentskogZahteva  extends Thread {
 
    Socket socket;

    public ObradaKlijentskogZahteva(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
       
        while(true){
            
            KlijentskiZahtev kz = prihvatiOdgovor();
            ServerskiOdgovor so = new ServerskiOdgovor();
            
            
            switch(kz.getOperacija()){
                
                case Operacije.LOGIN:
                   User u = Controller.getInstance().loginUser((User)kz.getParametar());
                 
                   
                   System.out.println("OKZ: "+u);
                   so.setOdgovor(u);
                    break;
                
                
                    
                case Operacije.IGRA:
                    int vrednost = Controller.getInstance().vratiBroj((SkriveniBroj)kz.getParametar());
                     so.setOdgovor(vrednost);
                     break;
                
                
                
                
            }
            
           
            posaljiOdgovor(so);
            
            
            
        }
        
        
        
        
        
    
        
        
        
        
        
    }

    private KlijentskiZahtev prihvatiOdgovor() {

        try {
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            return  (KlijentskiZahtev) ois.readObject();
            
            
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }


return null;



    }

    private void posaljiOdgovor(ServerskiOdgovor so) {


        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(so);
            oos.flush();
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskogZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }


    }
    
    

    

    
    
    
    
    
}
