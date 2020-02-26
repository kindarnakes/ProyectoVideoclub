package io.VideoClub.Model;

import java.util.TreeSet;
import java.util.Set;

/**
 *
 * @author Ángel Serrano García
 */
public class Data {
    
    private static final Data INSTANCE = new Data();
    protected Set<Product> productos;
    protected Set<IClient> clientes;
    protected Set<Reservation> reservas;

    private Data() {
        this.clientes = new TreeSet<>();
        this.productos = new TreeSet<>();
        this.reservas = new TreeSet<>();
    }
    
    public static Data getInstance(){
        return Data.INSTANCE;
    }
    

    public Set<Product> getProductos() {
        return productos;
    }

    public Set<IClient> getClientes() {
        return clientes;
    }

    public Set<Reservation> getReservas() {
        return reservas;
    }
    
    
    
}
