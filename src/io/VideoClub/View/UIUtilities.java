package io.VideoClub.View;

import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.MovieCategory;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.Product;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class UIUtilities {

    private static Scanner keyboard = new Scanner(System.in);
    public static final String defaultDateParsed = "yyyy/MM/dd";

    /**
     * Lee un entero de teclado
     *
     * @return devuelve el entero leído
     */
    public static int getInt() {
        int result = 0;
        boolean valid = false;
        do {
            try {
                result = Integer.parseInt(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                System.out.println("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                System.out.println("Error reading integer type. Please, try it again: ");
            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }

    /**
     * Lee un entero de teclado
     *
     * @param f Mensaje a imprimir al usuario antes de solicitar el entero
     * @return devuelve el entero leído
     */
    public static int getInt(String f) {
        System.out.print(f + " ");
        return UIUtilities.getInt();
    }

    /**
     * Lee un float de teclado
     *
     * @return devuelve el float leído
     */
    public static float getFloat() {
        float result = 0;
        boolean valid = false;
        do {
            try {
                result = Float.parseFloat(keyboard.nextLine());
                valid = true;

            } catch (IllegalStateException ex) {
                keyboard = new Scanner(System.in);
                System.out.println("Error in keyboard. Please, try it again: ");
            } catch (NumberFormatException ex) {
                System.out.println("Error reading decimal number. Please, try it again: ");
            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }

    /**
     * Lee un float del teclado, imprimiendo previamente un mensaje al usuario
     *
     * @param f mensaje a imprimir antes de solicitar el float
     * @return float insertado por el usuario
     */
    public static float getFloat(String f) {
        System.out.print(f + " ");
        return UIUtilities.getFloat();
    }

    /**
     * Lee un string de teclado
     *
     * @return strint insertado por el usuario
     */
    public static String getString() {
        String result = "";
        boolean valid = false;
        do {
            try {
                result = keyboard.nextLine();
                valid = true;

            } catch (Exception ex) {
                System.out.println("Error unknown. Please, try it again: ");
            }
        } while (!valid);
        return result;
    }

    /**
     * Lee un string de teclado, imprimiendo previamente un mensaje
     *
     * @param f mensaje a mostrar antes de solicitar el string
     * @return string insertado por el usuario
     */
    public static String getString(String f) {
        System.out.print(f + " ");
        return UIUtilities.getString();
    }

    /**
     *
     * @param f mensaje a mostrar
     * @return char insertado por consola
     */
    public static char getChar(String f) {

        String s;
        do {
            System.out.print(f + " ");
            s = UIUtilities.getString();
            if (s.length() != 1) {
                System.out.println("No válido");
            }
        } while (s.length() != 1);

        return s.charAt(0);
    }

    /**
     * Limpia la consola metiendo lineas en blanco
     */
    public static void clearScreen() {
        System.out.print("\n\n\n\n\n\n\n\n\n\n");
        System.out.flush();
    }

    /**
     * Recoge una fecha como string y la devuelve como LocalDateTime
     *
     * @param s String a mostrar por pantalla
     * @param parsed formato en el que se debe insertar la fecha
     * @return Fecha correcta
     */
    public static LocalDateTime getDate(String s, String parsed) {
        boolean result = false;
        LocalDateTime time = null;

        while (!result) {
            try {
                String fecha = UIUtilities.getString(s + " [" + parsed + "]") + " 00:00";
                DateTimeFormatter format = DateTimeFormatter.ofPattern(parsed + " HH:mm");
                time = LocalDateTime.parse(fecha, format);
                result = true;
            } catch (Exception ex) {
                System.out.println("Fecha no correcta");
            }
        }
        return time;
    }

    /**
     * Consigue un tipo de pelicula por teclado
     *
     * @return El tipo correcto
     */
    public static MovieCategory getMovieCategory() {
        int opt;
        MovieCategory type = null;
        do {
            System.out.println("1. Horror"
                    + "\n2. Love"
                    + "\n3. Action"
                    + "\n4. SciFi");

            opt = UIUtilities.getInt("Categoria");
            switch (opt) {
                case 1:
                    type = MovieCategory.Horror;
                    break;
                case 2:
                    type = MovieCategory.Love;
                    break;
                case 3:
                    type = MovieCategory.Action;
                    break;
                case 4:
                    type = MovieCategory.SciFi;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 4);

        return type;

    }

    /**
     * Consigue un tipo de juego por teclado
     *
     * @return El tipo correcto
     */
    public static GameCategory getGameCategory() {
        int opt;
        GameCategory type = null;
        do {
            System.out.println("1. Adventures"
                    + "\n2. Cars"
                    + "\n3. Shooter");

            opt = UIUtilities.getInt("Categoria");
            switch (opt) {
                case 1:
                    type = GameCategory.Adventures;
                    break;
                case 2:
                    type = GameCategory.Cars;
                    break;
                case 3:
                    type = GameCategory.Shooter;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 3);

        return type;

    }
        /**
     * Consigue un tipo de producto por teclado
     *
     * @return El tipo correcto
     */
    public static ProductsTypes getType() {
        int opt;
        ProductsTypes type = null;
        do {
            System.out.println("1. Juegos"
                    + "\n2. Peliculas"
                    + "\n3. Otros");

            opt = UIUtilities.getInt("Categoria");
            switch (opt) {
                case 1:
                    type = ProductsTypes.Juegos;
                    break;
                case 2:
                    type = ProductsTypes.Peliculas;
                    break;
                case 3:
                    type = ProductsTypes.Otros;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 3);

        return type;

    }
    
            /**
     * Consigue un status por teclado
     *
     * @return El status correcto
     */
    public static Product.Status getStatus() {
        int opt;
        Product.Status type = null;
        do {
            System.out.println("1. Reservados"
                    + "\n2. Disponibles");

            opt = UIUtilities.getInt("Opcion");
            switch (opt) {
                case 1:
                    type = Product.Status.RESERVED;
                    break;
                case 2:
                    type = Product.Status.AVAILABLE;
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }
        } while (opt <= 0 || opt > 2);

        return type;

    }
    

}
