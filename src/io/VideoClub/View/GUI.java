package io.VideoClub.View;

import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Client;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.NameComparator;
import io.VideoClub.Model.ProductNameComparator;
import java.time.LocalDateTime;
import java.util.Comparator;

public class GUI {

    static AppController controller = new AppController();

    public static void principal() {
        boolean load = controller.loadAllDDBB();
        boolean save = false;
        if (!load) {
            System.out.println("\n"
                    + "Error en la carga de datos"
                    + "\n\n\n");

            load = true;
        }
        int opciones;
        do {
            System.out.println("Bienvenido al menú principal Blockbuster");
            System.out.println("1.- Gestión de clientes");
            System.out.println("2.- Gestion de Productos");
            System.out.println("3.- Gestion de Reservas");
            System.out.println("4.- Salir ");

            opciones = UIUtilities.getInt();
            switch (opciones) {
                case 1:
                    clientes();
                    break;
                case 2:
                    productos();
                    break;
                case 3:
                    reservas();
                    break;
                case 4:
                    System.out.println("Hasta luego");

                    break;
                default:
                    System.out.println("introduce una opcion correcta");
            }

        } while (opciones != 4);

        if (!load) {
            do {
                char option = UIUtilities.getChar("¿Desea guardar? Hubo error al cargar datos [y/n]");
                switch (option) {
                    case 'y':
                        save = controller.saveAllDDBB();
                        load = true;
                        break;
                    case 'n':
                        break;
                    default:
                        System.out.println("Opcion incorrecta");
                }
            } while (!load);
        } else {
            save = controller.saveAllDDBB();
        }

        while (!save) {
            System.out.println("Error al guardar");
            char re = UIUtilities.getChar("¿Reintentar? [y/n]");
            switch (re) {
                case 'y':
                    save = controller.saveAllDDBB();
                    break;
                case 'n':
                    save = true;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }

        }
    }

    public static void clientes() {
        int opciones1;
        do {
            System.out.println("Accediendo a Gestión de clientes...");
            System.out.println("1.- Registrar Cliente");
            System.out.println("2.- Editar Cliente");
            System.out.println("3.- Eliminar Cliente");
            System.out.println("4.- Listado de Clientes");
            System.out.println("5.- Historial Cliente");
            System.out.println("6.- Búsqueda de Cliente");
            System.out.println("7.- Volver al menú principal");

            opciones1 = UIUtilities.getInt();

            switch (opciones1) {

                case 1:
                    registrarCliente();
                    break;

                case 2:
                    editCliente();
                    break;

                case 3:
                    eliminarcliente();
                    break;

                case 4:
                    listarcliente();
                    break;
                case 5:
                    historialclient();
                    break;
                case 6:
                    buscarclient();
                    break;
                case 7:
                    break;
                default:
                    System.out.println("opcion erronea, vuelva a intentarlo");
            }
        } while (opciones1 != 7);
    }

    public static void productos() {
        int opciones2;
        do {
            System.out.println("1.- Dar de alta un producto");
            System.out.println("2.- Catálogo");
            System.out.println("3.- Eliminar un producto");
            System.out.println("4.- Volver al menú principal");

            opciones2 = UIUtilities.getInt();

            switch (opciones2) {

                case 1:
                    dardealtaproduct();
                    break;

                case 2:
                    catalogo();
                    break;

                case 3:
                    eliminarproducto();
                    break;
                case 4:
                    break;
                default:
                    System.out.println("opcion erronea, vuelva a intentarlo");

            }
        } while (opciones2 != 4);
    }

    public static void reservas() {
        int opciones3;
        do {
            System.out.println("1.- Nueva Reserva");
            System.out.println("2.- Editar reserva");
            System.out.println("3.- Listar Reserva");
            System.out.println("4.- Historial de reservas de un cliente");
            System.out.println("5.- Volver al menú principal");

            opciones3 = UIUtilities.getInt();

            switch (opciones3) {

                case 1:
                    nuevareserva();
                    break;

                case 2:
                    editarreserva();
                    break;

                case 3:
                    listarreserva();
                    break;

                case 4:
                    historialReservas();
                    break;
                default:
                    System.out.println("opcion erronea, vuelva a intentarlo");

            }
        } while (opciones3 != 5);
    }

    public static void registrarCliente() {
        String name = UIUtilities.getString("introduzca nombre");
        String phone = UIUtilities.getString("introduzca telefono");
        LocalDateTime born = UIUtilities.getDate("Introduzca fecha de nacimiento", UIUtilities.defaultDateParsed);

        controller.createClient(name, phone, born);
    }

    public static void editCliente() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        if (e != null) {
            Client newC = new Client(UIUtilities.getString("Nuevo nombre"), UIUtilities.getString("Nuevo Telefono"));
            newC.setTime(UIUtilities.getDate("Fecha de nacimiento", UIUtilities.defaultDateParsed));
            controller.editClient(e, newC);
        } else {
            System.out.println("-> Id erronea");
        }
    }

    public static void eliminarcliente() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        String pantalla;
        if (e != null) {
            boolean removed = controller.removeClient(e.getID());
            if (removed) {
                pantalla = "Eliminado";
            } else {
                pantalla = "No se ha podido borrar";
            }
        } else {
            pantalla = "-> Id erronea";
        }
        System.out.println(pantalla);
    }

    public static void listarcliente() {
        int opciones3;
        System.out.println("1.- listar clientes");
        System.out.println("2.- listar por nombre");
        System.out.println("3.- Listar clientes con reservas no finalizadas");

        System.out.println("4.- atras");

        opciones3 = UIUtilities.getInt();

        switch (opciones3) {

            case 1:
                GUIData.clientToScreen(controller.listAllClients());
                break;

            case 2:
                Comparator c = new NameComparator();
                GUIData.clientToScreen(controller.listAllClients(c));
                break;

            case 3:
                GUIData.clientToScreen(controller.listAllClientsWithReservationsNotFinished());
                break;
            case 4:
                break;
            default:
                System.out.println("opcion erronea, vuelva a intentarlo");

        }

    }

    public static void buscarclient() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        if (e != null) {
            System.out.println(e);
        } else {
            System.out.println("-> Id erronea");
        }
    }

    public static void historialclient() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        if (e != null) {
            GUIClient.showClient(e);
            GUIData.ReservationToScreen(controller.listAllReservations(e.getID()));
        } else {
            System.out.println("-> Id incorrecta");
        }
    }

    public static void dardealtaproduct() {
        int opt;
        boolean add;
        do {
            System.out.println("---------------------------------"
                    + "\n1. Nuevo producto de una familia\n"
                    + "2. Nueva familia de productos");
            opt = UIUtilities.getInt("Opcion");

            switch (opt) {
                case 1:
                    add = controller.addProduct(UIUtilities.getString("Nombre de la familia"));
                    if (!add) {
                        System.out.println("Nombre erroneo");
                    }
                    break;
                case 2:
                    anyadirProducto();
                    break;
                default:
                    System.out.println("Opcion erronea");
            }

        } while (opt != 1 && opt != 2);
    }

    private static void anyadirProducto() {
        boolean add;
        int tipo;
        do {
            System.out.println("\n1. Pelicula"
                    + "\n2. Juego"
                    + "\n3. Otros");
            tipo = UIUtilities.getInt("Tipo");
            switch (tipo) {
                case 1:

                    add = controller.createMovie(ProductsTypes.Peliculas, UIUtilities.getString("Inserte nombre"), UIUtilities.getString("Descripcion:"),
                            UIUtilities.getMovieCategory(), UIUtilities.getInt("Edad minima recomendada"), UIUtilities.getFloat("Precio"));
                    if (!add) {
                        System.out.println("Error de creacion, pruebe de nuevo ...");
                    }
                    break;
                case 2:

                    add = controller.createGame(ProductsTypes.Juegos, UIUtilities.getString("Inserte nombre"), UIUtilities.getString("Descripcion:"),
                            UIUtilities.getGameCategory(), UIUtilities.getInt("Edad minima recomendada"), UIUtilities.getFloat("Precio"));
                    if (!add) {
                        System.out.println("Error de creacion, pruebe de nuevo ...");
                    }
                    break;
                case 3:
                    add = controller.createProduct(UIUtilities.getString("Inserte nombre"), UIUtilities.getString("Descripcion:"), UIUtilities.getFloat("Precio"));
                    if (!add) {
                        System.out.println("Error de creacion, pruebe de nuevo ...");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (tipo <= 0 || tipo > 3);
    }

    public static void catalogo() {
        int opt;
        do{
            System.out.println("1. Listar todo"
                    + "\n2. Listar familia juegos"
                    + "\n3. Listar familia peliculas"
                    + "\n4. Listar familia"
                    + "\n5. Listar por nombre"
                    + "\n6. Listar por nombre y tipo"
                    + "\n7. Listar por tipo"
                    + "\n8. Listar ordenados por nombre"
                    + "\n9. Listar Por estado");
            opt = UIUtilities.getInt("Opcion");
            switch(opt){
                case 1:
                    GUIData.ItemToScreen(controller.listAllProducts());
                    break;
                case 2:
                    GUIData.ItemToScreen(controller.listAllDifferentGames());
                    break;
                case 3:
                    GUIData.ItemToScreen(controller.listAllDifferentMovies());
                    break;
                case 4:
                    GUIData.ItemToScreen(controller.listAllDifferentProducts());
                    break;
                case 5:
                    GUIData.ItemToScreen(controller.listAllByName(UIUtilities.getString("Nombre:")));
                    break;
                case 6:
                    GUIData.ItemToScreen(controller.listAllByName(UIUtilities.getString("Nombre:"), UIUtilities.getType()));
                    break;
                case 7:
                    GUIData.ItemToScreen(controller.listAllByType(UIUtilities.getType()));
                    break;
                case 8:
                    ProductNameComparator c = new ProductNameComparator();
                    GUIData.ItemToScreen(controller.listAllProducts(c));
                    break;
                case 9:
                    GUIData.ItemToScreen(controller.listAllByStatus(UIUtilities.getStatus()));
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
            
        }while(opt <=0 || opt >9);

    }

    public static void eliminarproducto() {
        int opt;
        do {
            System.out.println("1. Eliminar un producto"
                    + "\n2. Eliminar familia de productos");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    if (!controller.removeUniqueProduct(UIUtilities.getString("Id del producto"))) {
                        System.out.println("-> Id erronea");
                    } else {
                        System.out.println("Eliminado");
                    }
                    break;
                case 2:
                    if (!controller.removeProduct(UIUtilities.getString("Nombre de la familia"))) {
                        System.out.println("-> Nombre erroneo");
                    } else {
                        System.out.println("Familia eliminada");
                    }
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt != 1 && opt != 2);
    }

    public static void nuevareserva() {

    }

    public static void editarreserva() {

    }

    public static void listarreserva() {

    }

    public static void historialReservas() {

    }

    public static void listarclientes() {

    }

    public static void clientesreservas() {

    }

}
