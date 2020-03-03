
package io.VideoClub.View;

import io.VideoClub.Model.IClient;


public class GUIClient {
    
   static public void showClient(IClient o){
        System.out.println(o);
    }
   static public void MostrarPorNOmbreprimero(IClient o){
        System.out.println(o.getName()+o.getID()+o.getPhone()+o.getTime()); 
        
    }
    
   static public void MostrarPorPhoneprimero(IClient o){
        System.out.println(o.getPhone()+o.getID()+o.getName()+o.getTime());
    }
}
