package io.VideoClub.View;

import io.VideoClub.Model.Client;
import io.VideoClub.Model.Item;
import io.VideoClub.Model.Reservation;
import java.util.Set;

/**
 *
 * @author Ángel Serrano García
 */
public class GUIData {

    public static void ItemToScreen(Set<Item> s) {
        s.forEach((item) -> {
            GUIItem.Show(item);
        });
    }

    public static void clientToScreen(Set<Client> s) {
        s.forEach((client) -> {
            //GUIClient ....
        });
    }
    public static void ReservationToScreen(Set<Reservation> s) {
        s.forEach((reservation) -> {
            GUIReservation.Show(reservation);
        });
    }
}