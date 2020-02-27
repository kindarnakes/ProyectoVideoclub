
package io.VideoClub.View;

import io.VideoClub.Model.Client;


public class GUIClient {
    public void MostrarPorNOmbreprimero(Client o){
        System.out.println(o.getName()+o.getID()+o.getPhone()+o.getTime()); 
        
    }
    
    public void MostrarPorPhoneprimero(Client o){
        System.out.println(o.getPhone()+o.getID()+o.getName()+o.getTime());
    }
}
