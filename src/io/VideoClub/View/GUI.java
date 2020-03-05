package io.VideoClub.View;



public class GUI{
    public static void principal(){
       /* boolean result=false;
        do{
        System.out.println("Bienvenido al menú principal Blockbuster");
        System.out.println("1.- Gestión de clientes");
        System.out.println("2.- Gestión de productos");
        System.out.println("3.- Reservas");
        System.out.println("4.- Salir del Sistema");
        System.out.println("Ingrese la accion a realizar: ");
        int opciones=leer();
        switch(opciones) {
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
                result=true;
                
                break;
            default:
                System.out.println("Opcion erroneo");
                        

        }
        
    }while(result!=true);
    }
    
     public static void clientes() {

        System.out.println("Accediendo a Gestión de clientes...");
        System.out.println("1.- Registrar Cliente");
        System.out.println("2.- Editar Cliente");
        System.out.println("3.- Eliminar Cliente");
        System.out.println("4.- Listado de Clientes");
        System.out.println("5.- Historial Cliente");
        System.out.println("6.- Búsqueda de Cliente");
        System.out.println("7.- Volver al menú principal");
        System.out.println("Ingrese la accion a realizar: ");

        int opciones1 = leer();
        

        switch (opciones1) {

            case 1:
                createClient();
                break;

            case 2:
                editClient();
                break;

            case 3:
                removeClient();
                break;

            case 4:
                listadoClientes();
            
                break;
            case 5:
                historialClientes();
                break;
            case 6:
                buscarCliente();
                break;
            case 7:
                principal();
                break;

        }
    }
     public static void productos() {

        System.out.println("Accediendo a Gestión de productos...");
        System.out.println("1.- Dar de alta un producto");
        System.out.println("2.- Catálogo");
        System.out.println("3.- Stock");
        System.out.println("4.- Eliminar un producto");
        System.out.println("5.- Búsqueda");
        System.out.println("6.- Volver al menú principal");
        System.out.println("Ingrese la accion a realizar: ");

        int opciones2 = leer();
       

        switch (opciones2) {

            case 1:
                addProduct();
                break;

            case 2:
                catalogo();
                break;

            case 3:
                stock();
                break;

            case 4:
                removeProduct();
            
                break;
            case 5:
                buscarProducto();
                break;
            case 6:
                principal();
                break;
            
        }
    }
     public static void reservas() {

        System.out.println("Accediendo a Gestión de reservas...");
        System.out.println("1.- Nueva Reserva");
        System.out.println("2.- Editar reserva");
        System.out.println("3.- Listar Reserva");
        System.out.println("4.- Historial de reservas");
        System.out.println("5.- Volver al menú principal");
        System.out.println("Ingrese la accion a realizar: ");

        int opciones3 = leer();
        

        switch (opciones3) {

            case 1:
                nuevaReserva();
                break;

            case 2:
                editarReserva();
                break;

            case 3:
                listarReserva();
                break;

            case 4:
                historialReserva();
            
                break;
            case 5:
                principal();
                break;

        }*/
     }
    

    
    
}
