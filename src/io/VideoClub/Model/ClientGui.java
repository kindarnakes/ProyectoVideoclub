
package io.VideoClub.Model;


public class ClientGui {
    public void MostrarPorNOmbreprimero(Client o){
        System.out.println(o.getName()+o.getID()+o.getPhone()+o.getTime()); 
        
    }
    
    public void MostrarPorPhoneprimero(Client o){
        System.out.println(o.getPhone()+o.getID()+o.getName()+o.getTime());
    }
}
