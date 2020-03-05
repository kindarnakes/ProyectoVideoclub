package io.VideoClub.View;

import java.util.Scanner;
import io.VideoClub.Controller.AppController;
import io.VideoClub.Model.Client;
import io.VideoClub.Model.NameComparator;
import java.time.LocalDateTime;
import java.util.Comparator;
import javax.sound.midi.ControllerEventListener;

public class GUI {

    static AppController controller = new AppController();

    public static void principal() {

        int opciones;
        do {
            System.out.println("Bienvenido al menú principal Blockbuster");
            System.out.println("1.- Gestión de clientes");
            System.out.println("2.- Gestion de Productos");
            System.out.println("3.- Gestion deReservas");
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
                    datosclient();
                    break;
                case 6:
                    buscarclient();
                    break;
                case 7:
                    principal();
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
                    principal();
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
                case 5:
                    principal();
                    break;
                default:
                    System.out.println("opcion erronea, vuelva a intentarlo");

            }
        } while (opciones3 != 5);
    }

    public static void registrarCliente() {
        String id = UIUtilities.getString("introduzca id");
        String name = UIUtilities.getString("introduzca nombre");
        String phone = UIUtilities.getString("introduzca telefono");
        

        controller.createClient(id, name, phone,LocalDateTime.MAX);//hay que cambiarlo para wue 
        //llame al metodo de meter la fecha
    }

    public static void editCliente() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        controller.editClient(e);
    }

    public static void eliminarcliente() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        controller.removeClient(e.getID());
    }

    public static void listarcliente() {
        int opciones3;
        do {
            System.out.println("1.- listar clientes");
            System.out.println("2.- listar por nombre");
            System.out.println("3.- Listar clientes con reservas no finalizadas");

            System.out.println("4.- atras");

            opciones3 = UIUtilities.getInt();

            switch (opciones3) {

                case 1:
                    listarcliente();
                    break;

                case 2:
                    Comparator c = new NameComparator();
                    listarclientes(c);
                    break;

                case 3:
                    clientesreservas();
                    break;

                case 4:
                    clientes();
                    break;
                default:
                    System.out.println("opcion erronea, vuelva a intentarlo");

            }
        } while (opciones3 != 4);

    }

    public static void datosclient() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        System.out.println(e);
    }

    public static void buscarclient() {
        Client e = controller.SearchClient(UIUtilities.getString("introduzca id"));
        System.out.println(e);
    }

    public static void dardealtaproduct() {
        String name = UIUtilities.getString("nombre del producto");
        String description = UIUtilities.getString("descripcion del producto");
        float price = UIUtilities.getFloat("precio del producto");
        if (controller.createProduct(name, description, price)) {
            System.out.println("Producto guardado con exito");
        } else {
            System.out.println("error al guardar producto");
        }
    }

    public static void catalogo() {

    }

    public static void eliminarproducto() {

    }

    public static void nuevareserva() {
        controller.reserveProduct(controller.SearchProduct(UIUtilities.getString("id producto")),
                controller.SearchClient(UIUtilities.getString("id del cliente")));
    }

    public static void editarreserva() {

    }

    public static void listarreserva() {

    }

    public static void historialReservas() {

    }

    public static void listarclientes() {

    }

    public static void listarclientes(Comparator c) {

    }

    public static void clientesreservas() {

    }


   }
