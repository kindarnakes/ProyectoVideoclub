
package io.VideoClub.Model;
import java.util.Comparator;

/**
 *
 * @author manue
 */
public class NameComparator implements Comparator<Client> {

    @Override
    public int compare(Client o1, Client o2) {
        return o1.getName().compareTo(o2.getName());
    }
 
}
