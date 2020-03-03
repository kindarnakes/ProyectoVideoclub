
import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Client;
import io.VideoClub.Model.Data;
import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.MovieCategory;
import io.VideoClub.Model.Game;
import io.VideoClub.Model.Movie;
import io.VideoClub.Model.Other;
import io.VideoClub.Model.Product;
import io.VideoClub.View.GUIData;
import java.time.LocalDateTime;


/**
 *
 * @author Ángel Serrano García
 */
public class pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Client c = new Client("3", "1", "01", LocalDateTime.now());
        Data data = Data.getInstance();
        /*data.getClientes().add(c);
        /*c = new Client("2", "4", "02", LocalDateTime.now());
        data.getClientes().add(c);*/
        AppController controller = new AppController();

       /* Game g = new Game("game", "1", 0, Product.Status.AVAILABLE, GameCategory.Cars);
        Movie m = new Movie("movie", "2", 0, Product.Status.AVAILABLE, MovieCategory.Horror);
        Other o = new Other("other", "3", 0, Product.Status.AVAILABLE);
        data.getProductos().add(o);
        data.getProductos().add(g);
        data.getProductos().add(m);
        controller.saveCatalogFromDDBB();*/
       controller.loadCatalogFromDDBB();
        GUIData.ItemToScreen(data.getProductos());
        //controller.loadClientsFromDDBB();
        /*GUIData.clientToScreen(data.getClientes());
        controller.editClient(c);
        GUIData.clientToScreen(data.getClientes());
        //controller.saveClientsFromDDBB();*/

    }

}
