
import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Client;
import io.VideoClub.Model.Data;
import io.VideoClub.View.GUIData;
import java.time.LocalDateTime;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Ángel Serrano García
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Client c = new Client("3", "1", "01", LocalDateTime.now());*/
        Data data = Data.getInstance();
        /*data.getClientes().add(c);
        c = new Client("2", "4", "02", LocalDateTime.now());
        data.getClientes().add(c);*/
        
        AppController controller = new AppController();
        controller.loadClientsFromDDBB();
        GUIData.clientToScreen(data.getClientes());
        //controller.saveClientsFromDDBB();
    }
    
}
