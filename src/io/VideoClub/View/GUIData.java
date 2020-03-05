package io.VideoClub.View;

import io.VideoClub.Model.IClient;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.Reservation;
import java.util.Set;

/**
 *
 * @author Ángel Serrano García
 */
public class GUIData {

    public static void ItemToScreen(Set<Product> s) {
        s.forEach((item) -> {
            GUIItem.Show(item);
        });
    }

    public static void clientToScreen(Set<IClient> s) {
        s.forEach((client) -> {
            GUIClient.showClient(client);
        });
    }
    public static void ReservationToScreen(Set<Reservation> s) {
        s.forEach((reservation) -> {
            GUIReservation.Show(reservation);
        });
    }
}