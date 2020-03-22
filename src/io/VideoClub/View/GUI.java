package io.VideoClub.View;

import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Client;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.IClient;
import io.VideoClub.Model.NameComparator;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.ProductNameComparator;
import io.VideoClub.Model.Reservation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Map;

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
            UIUtilities.clearScreen();
            System.out.println("Bienvenido al menú principal Blockbuster");
            System.out.println("1.- Gestión de clientes");
            System.out.println("2.- Gestion de Productos");
            System.out.println("3.- Gestion de Reservas");
            System.out.println("4.- Salir ");

            opciones = UIUtilities.getInt();
            switch (opciones) {
                case 1:
                    UIUtilities.clearScreen();
                    clientes();
                    break;
                case 2:
                    UIUtilities.clearScreen();
                    productos();
                    break;
                case 3:
                    UIUtilities.clearScreen();
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
                    UIUtilities.clearScreen();
                    registrarCliente();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    editCliente();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    eliminarcliente();
                    break;

                case 4:
                    UIUtilities.clearScreen();
                    listarcliente();
                    break;
                case 5:
                    UIUtilities.clearScreen();
                    historialclient();
                    break;
                case 6:
                    UIUtilities.clearScreen();
                    buscarclient();
                    break;
                case 7:
                    UIUtilities.clearScreen();
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
                    UIUtilities.clearScreen();
                    dardealtaproduct();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    catalogo();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    eliminarproducto();
                    break;
                case 4:
                    UIUtilities.clearScreen();
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
            System.out.println("5.- Pagos");
            System.out.println("6.- Volver al menú principal");

            opciones3 = UIUtilities.getInt();

            switch (opciones3) {

                case 1:
                    UIUtilities.clearScreen();
                    nuevareserva();
                    break;

                case 2:
                    UIUtilities.clearScreen();
                    editarreserva();
                    break;

                case 3:
                    UIUtilities.clearScreen();
                    listarreserva();
                    break;

                case 4:
                    UIUtilities.clearScreen();
                    historialReservas();
                    break;
                case 5:
                    UIUtilities.clearScreen();
                    pagos();
                    break;
                default:
                    System.out.println("opcion erronea, vuelva a intentarlo");

            }
        } while (opciones3 != 6);
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
                UIUtilities.clearScreen();
                GUIData.clientToScreen(controller.listAllClients());
                break;

            case 2:
                UIUtilities.clearScreen();
                Comparator c = new NameComparator();
                GUIData.clientToScreen(controller.listAllClients(c));
                break;

            case 3:
                UIUtilities.clearScreen();
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
        do {
            System.out.println("1. Listar todo"
                    + "\n2. Listar familia juegos"
                    + "\n3. Listar familia peliculas"
                    + "\n4. Listar familia"
                    + "\n5. Listar por nombre"
                    + "\n6. Listar por nombre y tipo"
                    + "\n7. Listar por tipo"
                    + "\n8. Listar ordenados por nombre"
                    + "\n9. Listar Por estado"
                    + "\n10. Numero de productos con un nombre"
                    + "\n11. Numero de productos con un nombre y un tipo"
                    + "\n12. Salir");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
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
                case 10:
                    Map<Product, Integer> map1 = controller.listAllAmountOfProducts(UIUtilities.getString("Nombre del producto:"));
                    if (map1 != null) {
                        map1.forEach((p, i) -> {
                            System.out.println("Del producto" + p.getName() + " existen " + i + " copias");
                        });
                    } else {
                        System.out.println("No hay");
                    }
                    break;
                case 11:
                    Map<Product, Integer> map2 = controller.listAllAmountOfProducts(UIUtilities.getType(), UIUtilities.getString("Nombre del producto:"));
                    if (map2 != null) {
                        map2.forEach((p, i) -> {
                            System.out.println("Del producto" + p.getName() + " existen " + i + " copias");
                        });
                    } else {
                        System.out.println("No hay");
                    }
                    break;
                case 12:
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
            UIUtilities.clearScreen();

        } while (opt != 12);

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
        boolean reserved = false;
        do {
            Client c = controller.SearchClient(UIUtilities.getString("Id del cliente: "));
            io.VideoClub.Model.Product p = controller.SearchProduct(UIUtilities.getString("Id de producto: "));
            if (p != null && c != null) {
                reserved = controller.reserveProduct(p, c);
                if (!controller.isAged(p, c)) {
                    System.out.println("No tiene edad para alquilar el producto");
                }
                if (reserved) {
                    GUIReservation.Show(controller.searchReservation(LocalDate.now(), p.getKey(), c.getID()));
                    System.out.println("Reserva completada");
                } else {
                    System.out.println("Fallo en la reserva");
                    char ok = UIUtilities.getChar("¿Desea volver a intentar? [y/n]");
                    switch (ok) {
                        case 'y':
                            reserved = false;
                            break;
                        case 'n':
                            reserved = true;
                            break;
                        default:
                            reserved = false;
                    }
                }
            }
        } while (!reserved);

    }

    public static void editarreserva() {
        int opt;
        do {
            System.out.println("1. Añadir dias"
                    + "\n2. Eliminar reserva"
                    + "\n3. Finalizar reserva"
                    + "\n4. Atras");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    if (controller.addDaysToReservation(controller.searchReservationNotFinished(UIUtilities.getString("Id producto: "),
                            UIUtilities.getString("Id cliente: ")), UIUtilities.getInt("Dias a añadir: "))) {
                        System.out.println("Dias agregados\n");
                    } else {
                        System.out.println("Reserva no encontrada\n");
                    }
                    break;
                case 2:
                    if (controller.removeReservation(controller.searchReservation(UIUtilities.getDate("Fecha de inicio de la reserva", UIUtilities.defaultDateParsed).toLocalDate(), UIUtilities.getString("Id producto: "),
                            UIUtilities.getString("Id cliente: ")))) {
                        System.out.println("Borrada\n");
                    } else {
                        System.out.println("Reserva no encontrada\n");
                    }
                    break;
                case 3:

                    double income = controller.closeReservation(controller.searchReservationNotFinished(UIUtilities.getString("Id producto: "),
                            UIUtilities.getString("Id cliente: ")));

                    if (income == 0) {
                        System.out.println("Reserva no encontrada");
                    } else {
                        System.out.println("--------------------------------\n\t--->El cliente tiene que pagar " + income + "€\n\n--------------------------------");
                    }

                default:

            }
        } while (opt < 1 || opt > 3);

    }

    public static void listarreserva() {
        int opt;
        do {
            System.out.println("1. Listar todas las reservas"
                    + "\n2. Listar todas las reservas acababas"
                    + "\n3. Listar reservas activas"
                    + "\n4. Listar reservas pendientes"
                    + "\n5. Atras");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    GUIData.ReservationToScreen(controller.listAllReservations());
                    break;
                case 2:
                    GUIData.ReservationToScreen(controller.listAllReservations(Reservation.StatusReserve.FINISHED));
                    break;
                case 3:
                    GUIData.ReservationToScreen(controller.listAllReservations(Reservation.StatusReserve.ACTIVE));
                    break;
                case 4:
                    GUIData.ReservationToScreen(controller.listAllReservations(Reservation.StatusReserve.PENDING));
                    break;
                default:

            }
            UIUtilities.clearScreen();
        } while (opt < 1 || opt > 5);
    }

    public static void historialReservas() {
        GUIData.ReservationToScreen(controller.listAllReservations(UIUtilities.getString("Id cliente: ")));

    }

    private static void pagos() {
        int opt;
        do {
            System.out.println("1. Dinero ingresado"
                    + "\n2. Dinero ingresado desde una fecha"
                    + "\n3. Dinero ingresado entre fechas"
                    + "\n4. Dinero ingresado por cada cliente"
                    + "\n5. Atras");
            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    System.out.println("------------------\nDinero ingresado desde los origenes: " + controller.getIncommings() + "€\n------------------");
                    break;
                case 2:
                    LocalDate date = UIUtilities.getDate("Fecha inicio", UIUtilities.defaultDateParsed).toLocalDate();
                    if (date != null) {
                        System.out.println("------------------\nDinero ingresado desde " + date.toString() + " :" + controller.getIncommings(date) + "€\n------------------");
                    } else {
                        System.out.println("Fecha no valida");
                    }
                    break;
                case 3:
                    LocalDate dateini = UIUtilities.getDate("Fecha inicio", UIUtilities.defaultDateParsed).toLocalDate();
                    LocalDate dateend = UIUtilities.getDate("Fecha final", UIUtilities.defaultDateParsed).toLocalDate();
                    if (dateini != null && dateend != null) {
                        System.out.println("------------------\nDinero ingresado desde " + dateini.toString() + " hasta " + dateend.toString() + " :" + controller.getIncommings(dateini, dateend) + "€\n------------------");
                    } else {
                        System.out.println("Fecha no valida");
                    }
                    break;
                case 4:
                    Map<IClient, Double> map = controller.resumeAllIncomingsByClient();
                    System.out.println("-------------------");
                    map.forEach((c, i) -> {
                        System.out.println("El cliente: " + c.getID() + " con nombre: " + c.getName() + " ha gastado en total: " + i + "€");
                    });
                    System.out.println("-------------------");
                    break;
                default:

            }
        } while (opt < 1 || opt > 5);

    }

}
