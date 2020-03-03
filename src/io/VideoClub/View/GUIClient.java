
package io.VideoClub.View;

import io.VideoClub.Model.Client;


public class GUIClient {
    
   static public void showClient(Client o){
        System.out.println(o);
    }
   static public void MostrarPorNOmbreprimero(Client o){
        System.out.println(o.getName()+o.getID()+o.getPhone()+o.getTime()); 
        
    }
    
   static public void MostrarPorPhoneprimero(Client o){
        System.out.println(o.getPhone()+o.getID()+o.getName()+o.getTime());
    }
}
