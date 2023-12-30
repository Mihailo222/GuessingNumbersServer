/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import model.SkriveniBroj;
import model.User;

/**
 *
 * @author Acer
 */
public class Controller {
    private static Controller instance;
    private ArrayList<User> ulogovani = new ArrayList<>();
    private ArrayList<SkriveniBroj> skriveniBrojevi = new ArrayList<>();

    
    private Controller() {
        User u1 = new User("pera@gmail.com", "123456","Pera","Peric");
        User u2 = new User("mara@gmail.com", "654321", "Mara", "Maric");
    
        ulogovani.add(u1);
        ulogovani.add(u2);
        
    
    
    }


    
    
    
    public ArrayList<SkriveniBroj> getSkriveniBrojevi() {
        return skriveniBrojevi;
    }

    public void setSkriveniBrojevi(ArrayList<SkriveniBroj> skriveniBrojevi) {
        this.skriveniBrojevi = skriveniBrojevi;
    }
    
    
    
    public static Controller getInstance(){
        if(instance == null)
            instance = new Controller();
        
        
        return instance;
        
    }

    public ArrayList<User> getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(ArrayList<User> ulogovani) {
        this.ulogovani = ulogovani;
    }

    public boolean daLiPostoji(SkriveniBroj sb) {

        for(SkriveniBroj broj : skriveniBrojevi){
            if(broj.equals(sb))
                return true;
        }

return false;

    }
    
    
    public void ispisiSkriveneBrojeve(){
        for(SkriveniBroj sb : skriveniBrojevi)
            System.out.println(sb);
    }

    public void dodajBroj(SkriveniBroj sb) {



        skriveniBrojevi.add(sb);





    }

    public User loginUser(User user) {


        for(User u : ulogovani){
            if(u.getGmail().equals(user.getGmail())    &&   u.getPassword().equals(user.getPassword()) )
                return u;
        }
        
return null;

    }

    public int vratiBroj(SkriveniBroj skriveniBroj) {

        for(SkriveniBroj sb : skriveniBrojevi){
            if(sb.getRed()==skriveniBroj.getRed() && sb.getKolona()==skriveniBroj.getKolona()){
                return sb.getVrednost();
            }
        }

        

return -1;



    }
    
    
    
    
    
    
    
    
    
    
    
    
}
