/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Controller;

import io.VideoClub.Model.Client;
import io.VideoClub.Model.Data;
import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.MovieCategory;
import io.VideoClub.Model.Enums.ProductsTypes;
import io.VideoClub.Model.Game;
import io.VideoClub.Model.IClient;
import io.VideoClub.Model.Movie;
import io.VideoClub.Model.Other;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.ProductNameComparator;
import io.VideoClub.Model.Reservation;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Ángel Serrano García
 */
public class AppController implements IAppController {

    @Override
    public Set<Product> listAllProducts() {
        Set<Product> aux = new TreeSet<>();
        for (Product p : Data.getInstance().getProductos()) {
            if (p.getStatus() != Product.Status.REMOVED) {
                aux.add(p);
            }
        }
        return aux;
    }

    @Override
    public Set<Product> listAllProducts(Comparator c) {

        Set<Product> aux = new TreeSet<>();
        for (Product p : Data.getInstance().getProductos()) {
            if (p.getStatus() != Product.Status.REMOVED) {
                aux.add(p);
            }
        }
        ArrayList<Product> aux2 = new ArrayList<>(aux);
        Collections.sort(aux2, c);
        aux = new TreeSet<>(aux2);

        return aux;

    }

    @Override
    public Set<Product> listAllByType(ProductsTypes type) {
        Set<Product> data = Data.getInstance().getProductos();
        Set<Product> aux = new TreeSet<>();

        data.forEach((lista) -> {
            if (lista.getType() == type && lista.getStatus() != Product.Status.REMOVED) {
                aux.add(lista);

            }
        });
        return aux;

    }

    @Override
    public Set<Product> listAllByName(String name) {
        Set<Product> data = Data.getInstance().getProductos();
        Set<Product> aux = new TreeSet<>();
        for (Product lista : data) {
            if (lista.getName().equals(name) && lista.getStatus() != Product.Status.REMOVED) {
                aux.add(lista);

            }

        }
        return aux;

    }

    @Override
    public Set<Product> listAllByName(String name, ProductsTypes type) {
        Set<Product> data = Data.getInstance().getProductos();
        Set<Product> aux = new TreeSet<>();
        for (Product lista : data) {
            if (lista.getType() == type && lista.getName().equals(name) && lista.getStatus() != Product.Status.REMOVED) {
                aux.add(lista);
            }

        }
        return aux;
    }

    @Override
    public Set<Product> listAllByStatus(Product.Status status) {
        Set<Product> data = Data.getInstance().getProductos();
        Set<Product> aux = new TreeSet<>();
        for (Product lista : data) {
            if (lista.getStatus() == status && lista.getStatus() != Product.Status.REMOVED) {
                aux.add(lista);

            }
        }
        return aux;
    }

    @Override
    public List<Product> listAllDifferentProducts() {
        Set<Product> data = Data.getInstance().getProductos();
        TreeSet<Product> aux = new TreeSet<>(new ProductNameComparator());
        for (Product lista : data) {
            aux.add(lista);
        }
        ArrayList<Product> listaProductos = new ArrayList<>(aux);

        return listaProductos;

    }

    @Override
    public List<Product> listAllDifferentMovies() {
        Set<Product> data = Data.getInstance().getProductos();
        TreeSet<Movie> aux = new TreeSet<>(new ProductNameComparator());
        for (Product p : data) {
            if (p instanceof Movie && p.getStatus() != Product.Status.REMOVED) {
                aux.add((Movie) p);
            }
        }
        ArrayList<Product> listaProductos = new ArrayList<>(aux);
        return listaProductos;
    }

    @Override
    public List<Product> listAllDifferentGames() {
        Set<Product> data = Data.getInstance().getProductos();
        TreeSet<Game> aux = new TreeSet<>(new ProductNameComparator());
        for (Product p : data) {
            if (p instanceof Game && p.getStatus() != Product.Status.REMOVED) {
                aux.add((Game) p);
            }
        }
        ArrayList<Product> listaProductos = new ArrayList<>(aux);
        return listaProductos;
    }

    @Override
    public Map<Product, Integer> listAllAmountOfProducts(String name) {
        Set<Product> data = Data.getInstance().getProductos();
        int n = 0;
        Product p1 = null;
        TreeMap<Product, Integer> aux = new TreeMap<>();

        for (Product p : data) {
            if (p.getName().equals(name) && p.getStatus() != Product.Status.REMOVED) {
                if (p1 == null) {
                    p1 = p;
                }
                n++;

            }
        }
        if (p1 != null) {
            aux.put(p1, n);
        }
        return aux;

    }

    @Override
    public Map<Product, Integer> listAllAmountOfProducts(ProductsTypes type, String name) {
        Set<Product> data = Data.getInstance().getProductos();
        int n = 0;
        Product p1 = null;
        TreeMap<Product, Integer> aux = new TreeMap<>();

        for (Product p : data) {
            if (p.getName().equals(name) && p.getType() == type && p.getStatus() != Product.Status.REMOVED) {
                if (p1 == null) {
                    p1 = p;
                }
                n++;

            }
        }
        if (p1 != null) {
            aux.put(p1, n);
        }
        return aux;

    }

    @Override
    public Set<IClient> listAllClients() {
        Set<IClient> aux = new TreeSet<>();
        for (IClient c : Data.getInstance().getClientes()) {
            if (!c.getName().equals("BORRADO")) {
                aux.add(c);
            }
        }
        return aux;

    }

    @Override
    public Set<IClient> listAllClients(Comparator c) {
        Set<IClient> aux = new TreeSet<>();
        for (IClient cli : Data.getInstance().getClientes()) {
            if (!cli.getName().equals("BORRADO")) {
                aux.add(cli);
            }
        }
        ArrayList<IClient> aux2 = new ArrayList<>(aux);
        Collections.sort(aux2, c);
        aux = new TreeSet<>(aux2);

        return aux;

    }

    @Override
    public Set<IClient> listAllClientsWithReservationsNotFinished() {
        Set<Reservation> A = Data.getInstance().getReservas();
        Set<IClient> aux = new TreeSet<>();
        for (Reservation lista : A) {
            if (lista.status != Reservation.StatusReserve.FINISHED) {
                aux.add(lista.cli);

            }

        }
        return aux;

    }

    public Set<Reservation> listAllReservations(String id) {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        Set<Reservation> aux = new TreeSet<>();
        reservations.forEach((r) -> {
            if (r.cli.getID().equals(id)) {
                aux.add(r);
            }
        });

        return aux;
    }

    @Override
    public Set<Reservation> listAllReservations() {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        Set<Reservation> aux = new TreeSet<>();
        for (Reservation r : reservations) {
            aux.add(r);
        }

        return aux;
    }

    @Override
    public Set<Reservation> listAllReservations(Comparator c) {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        List<Reservation> aux = new ArrayList<>();
        for (Reservation r : reservations) {
            aux.add(r);
        }
        aux.sort(c);
        Set<Reservation> aux1 = new TreeSet<>(aux);
        return aux1;
    }

    @Override
    public Set<Reservation> listAllReservations(Reservation.StatusReserve status) {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        Set<Reservation> aux = new TreeSet<>();
        for (Reservation r : reservations) {
            if (r.status == status) {
                aux.add(r);
            }

        }

        return aux;
    }

    @Override
    public double getIncommings() {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        double result = 0;
        for (Reservation lista : reservations) {

            if (lista.status == Reservation.StatusReserve.FINISHED) {
                result = result + lista.pro.getPrize();
            }
        }
        return result;

    }

    @Override
    public double getIncommings(LocalDate from) {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        double result = 0;
        for (Reservation lista : reservations) {

            if (lista.status == Reservation.StatusReserve.FINISHED && (lista.finished.isAfter(from) || lista.finished.isEqual(from))) {
                result = result + lista.pro.getPrize();
            }
        }
        return result;

    }

    @Override
    public double getIncommings(LocalDate from, LocalDate to) {
        Set<Reservation> reservations = Data.getInstance().getReservas();
        double result = 0;
        for (Reservation lista : reservations) {

            if (lista.status == Reservation.StatusReserve.FINISHED
                    && (lista.finished.isAfter(from) || lista.finished.isEqual(from))
                    && (lista.finished.isBefore(to) || lista.finished.isEqual(to))) {
                result = result + lista.pro.getPrize();
            }
        }
        return result;
    }

    @Override
    public Map<IClient, Double> resumeAllIncomingsByClient() {
        Map<IClient, Double> map = new HashMap<>();
        Iterator<IClient> itC = Data.getInstance().getClientes().iterator();

        while (itC.hasNext()) {
            IClient c = itC.next();
            Double incoming = new Double(0);
            for (Reservation r : Data.getInstance().getReservas()) {
                if (r.cli.equals(c) && r.status == Reservation.StatusReserve.FINISHED) {
                    incoming += r.getIncome();
                }
            }
            map.put(c, incoming);
        }
        return map;
    }

    @Override
    public boolean createProduct(String name, String description, double prize) {
        Other o = new Other(name, description, prize, Product.Status.AVAILABLE);

        return Data.getInstance().getProductos().add(o);

    }

    @Override
    public boolean createMovie(ProductsTypes type, String name, String description, MovieCategory cat, int minAge, double prize) {
        Movie m = new Movie(cat, minAge, name, description, prize, Product.Status.AVAILABLE, type);

        return Data.getInstance().getProductos().add(m);
    }

    @Override
    public boolean createGame(ProductsTypes type, String name, String description, GameCategory cat, int minAge, double prize) {
        Game g = new Game(cat, minAge, name, description, prize, Product.Status.AVAILABLE, type);

        return Data.getInstance().getProductos().add(g);
    }

    @Override
    public boolean createClient(String name, String phone, LocalDateTime time) {

        IClient aux = new Client(name, phone);
        aux.setTime(time);

        return Data.getInstance().getClientes().add(aux);

    }

    @Override
    public boolean removeClient(String id) {
        boolean result = false;
        Set<IClient> A = Data.getInstance().getClientes();
        for (IClient a : A) {
            boolean reservationnotFinished = false;
            for (Reservation r : Data.getInstance().getReservas()) {
                if (r.cli.equals(a) && r.finished == null) {
                    reservationnotFinished = true;
                }
            }
            if (a.getID().equals(id) && !reservationnotFinished) {
                Client c = (Client) a;
                c.setRemoved();
                result = true;
                break;
            }

        }

        return result;
    }

    @Override
    public boolean editClient(IClient e, IClient newC) {
        boolean result = false;
        Set<IClient> A = Data.getInstance().getClientes();
        if (A.contains(e)) {
            e.setName(newC.getName());
            e.setPhone(newC.getPhone());
            e.setTime(newC.getTime());
            result = true;
        }
        return result;
    }

    public Client SearchClient(String id) {
        Set<IClient> A = Data.getInstance().getClientes();
        Client aux = new Client("", "");
        for (IClient a : A) {
            if (a.getID().equals(id)) {
                aux = (Client) a;
                break;

            }
        }
        return aux;

    }

    public Product SearchProduct(String id) {

        for (Product p : Data.getInstance().getProductos()) {
            if (p.getKey().equals(id)) {
                return p;
            }
        }

        return null;
    }

    public Product SearchProductByName(String name) {

        for (Product p : Data.getInstance().getProductos()) {
            if (p.getName().equals(name)) {
                return p;
            }
        }

        return null;
    }

    @Override
    public boolean addProduct(String name) {
        Product p = SearchProductByName(name);
        boolean added;

        if (p != null) {
            try {
                p = (Product) p.clone();
                added = Data.getInstance().getProductos().add(p);
            } catch (CloneNotSupportedException ex) {
                added = false;
            }
        } else {
            added = false;
        }

        return added;
    }

    @Override
    public boolean removeProduct(String name) {
        Product p;
        boolean removed = false;
        do {
            p = SearchProductByName(name);
            if (p != null) {
                boolean reservationnotFinished = false;
                for (Reservation r : Data.getInstance().getReservas()) {
                    if (r.pro.equals(p) && r.finished == null) {
                        reservationnotFinished = true;
                    }
                }
                if (!reservationnotFinished) {
                    removed = removed || p.setRemoved();
                }
            }
        } while (p != null);

        return removed;
    }

    public boolean removeUniqueProduct(String id) {
        Product p;
        boolean removed = false;

        p = SearchProduct(id);
        if (p != null) {
            boolean reservationnotFinished = false;
            for (Reservation r : Data.getInstance().getReservas()) {
                if (r.pro.equals(p) && r.finished == null) {
                    reservationnotFinished = true;
                }
            }
            if (!reservationnotFinished) {
                removed = p.setRemoved();
            }
        }

        return removed;
    }

    @Override
    public boolean editProduct(String key, Product newP) {
        boolean edited;
        Product p = SearchProduct(key);

        if (p != null && p.getClass() == newP.getClass()) {
            edited = removeUniqueProduct(key);

            if (edited == true) {
                newP.setKey(key);
                edited = Data.getInstance().getProductos().add(newP);
            }
        } else {
            edited = false;
        }
        return edited;
    }

    @Override
    public Product isAvailableProduct(String name, ProductsTypes type) {
        Product p = null;

        for (Product aux : Data.getInstance().getProductos()) {
            if (aux.getName().equals(name) && aux.getType() == type && aux.getStatus() == Product.Status.AVAILABLE) {
                p = aux;
                break;
            }
        }
        return p;
    }

    @Override
    public boolean reserveProduct(Product prod, IClient client) {
        boolean result = false;
        boolean age;
        Product p = SearchProduct(prod.getKey());
        Client c = SearchClient(client.getID());

        if (p != null && c != null) {
            age = isAged(p, c);
            if (p.getStatus() == Product.Status.AVAILABLE && age) {
                p.setStatus(Product.Status.RESERVED);
                Reservation R = new Reservation(prod, client);
                result = Data.getInstance().getReservas().add(R);
            }
        }

        return result;
    }

    public boolean isAged(Product p, Client c) {
        boolean age = false;
        if (p != null && c != null) {
            if (p instanceof Movie) {
                Movie m = (Movie) p;
                age = (LocalDate.now().getDayOfYear() >= c.getTime().getDayOfYear())
                        ? (LocalDate.now().getYear() - c.getTime().getYear()) >= m.getMinAge()
                        : (LocalDate.now().getYear() - c.getTime().getYear()) - 1 >= m.getMinAge();
            }
            if (p instanceof Game) {
                Game g = (Game) p;
                age = (LocalDate.now().getDayOfYear() >= c.getTime().getDayOfYear())
                        ? (LocalDate.now().getYear() - c.getTime().getYear()) >= g.getMinAge()
                        : (LocalDate.now().getYear() - c.getTime().getYear()) - 1 >= g.getMinAge();
            }
            if (p instanceof Other) {
                age = true;
            }
        }
        return age;
    }

    public boolean addDaysToReservation(Reservation r, int days) {
        boolean added = false;
        if (r != null) {
            r.addDays(days);
            added = true;
        }
        return added;
    }

    public Reservation searchReservationNotFinished(String productId, String clientId) {
        boolean find = false;
        Iterator<Reservation> it = Data.getInstance().getReservas().iterator();
        Reservation r = null;
        while (it.hasNext() && !find) {
            r = it.next();
            if (r.finished == null && r.cli.getID().equals(clientId) && r.pro.getKey().equals(productId)) {
                find = true;
            }
        }
        return find ? r : null;
    }

    public boolean removeReservation(Reservation r) {
        return Data.getInstance().getReservas().remove(r);
    }

    public Reservation searchReservation(LocalDate ini, String productId, String clientId) {
        boolean find = false;
        Iterator<Reservation> it = Data.getInstance().getReservas().iterator();
        Reservation r = null;
        while (it.hasNext() && !find) {
            r = it.next();
            if (r.ini.equals(ini) && r.cli.getID().equals(clientId) && r.pro.getKey().equals(productId)) {
                find = true;
            }
        }
        return find ? r : null;
    }

    @Override
    public double closeReservation(Reservation r) {
        double result = 0;
        if (r != null) {
            r.finish();
            result = r.getIncome();
        }

        return result;
    }

    @Override
    public boolean loadCatalogFromDDBB() {
        Data data = Data.getInstance();
        boolean loaded = false;
        data.getProductos().clear();

        try {
            File file = new File(catalogDDBB);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Movie");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String movie_category = eElement.getElementsByTagName("movie_category").item(0).getTextContent();
                    String minAge = eElement.getElementsByTagName("min_age").item(0).getTextContent();
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    String prize = eElement.getElementsByTagName("prize").item(0).getTextContent();
                    String status = eElement.getElementsByTagName("status").item(0).getTextContent();
                    String key = eElement.getElementsByTagName("key").item(0).getTextContent();
                    MovieCategory category;
                    Product.Status statusfilm;

                    switch (movie_category) {
                        case "Horror":
                            category = MovieCategory.Horror;
                            break;
                        case "Love":
                            category = MovieCategory.Love;
                            break;
                        case "Action":
                            category = MovieCategory.Action;
                            break;
                        case "SciFi":
                            category = MovieCategory.SciFi;
                            break;
                        default:
                            category = null;
                    }

                    switch (status) {
                        case "AVAILABLE":
                            statusfilm = Product.Status.AVAILABLE;
                            break;
                        case "RESERVED":
                            statusfilm = Product.Status.RESERVED;
                            break;
                        case "REMOVED":
                            statusfilm = Product.Status.REMOVED;
                            break;
                        default:
                            statusfilm = null;
                    }

                    data.getProductos().add(new Movie(category, key, statusfilm, ProductsTypes.Peliculas, name, description, Double.valueOf(prize), Integer.parseInt(minAge)));

                }

            }
            nList = doc.getElementsByTagName("Game");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String game_category = eElement.getElementsByTagName("game_category").item(0).getTextContent();
                    String minAge = eElement.getElementsByTagName("min_age").item(0).getTextContent();
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    String prize = eElement.getElementsByTagName("prize").item(0).getTextContent();
                    String status = eElement.getElementsByTagName("status").item(0).getTextContent();
                    String key = eElement.getElementsByTagName("key").item(0).getTextContent();
                    GameCategory category;
                    Product.Status statusgame;

                    switch (game_category) {
                        case "Adventures":
                            category = GameCategory.Adventures;
                            break;
                        case "Cars":
                            category = GameCategory.Cars;
                            break;
                        case "Shooter":
                            category = GameCategory.Shooter;
                            break;
                        default:
                            category = null;
                    }

                    switch (status) {
                        case "AVAILABLE":
                            statusgame = Product.Status.AVAILABLE;
                            break;
                        case "RESERVED":
                            statusgame = Product.Status.RESERVED;
                            break;
                        case "REMOVED":
                            statusgame = Product.Status.REMOVED;
                            break;
                        default:
                            statusgame = null;
                    }

                    data.getProductos().add(new Game(category, key, statusgame, ProductsTypes.Juegos, name, description, Double.valueOf(prize), Integer.parseInt(minAge)));

                }

            }
            nList = doc.getElementsByTagName("Other");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;

                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String description = eElement.getElementsByTagName("description").item(0).getTextContent();
                    String prize = eElement.getElementsByTagName("prize").item(0).getTextContent();
                    String status = eElement.getElementsByTagName("status").item(0).getTextContent();
                    String key = eElement.getElementsByTagName("key").item(0).getTextContent();
                    Product.Status statusother;

                    switch (status) {
                        case "AVAILABLE":
                            statusother = Product.Status.AVAILABLE;
                            break;
                        case "RESERVED":
                            statusother = Product.Status.RESERVED;
                            break;
                        case "REMOVED":
                            statusother = Product.Status.REMOVED;
                            break;
                        default:
                            statusother = null;
                    }

                    data.getProductos().add(new Other(key, statusother, ProductsTypes.Otros, name, description, Double.valueOf(prize)));

                }

            }

            loaded = true;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }
        return loaded;
    }

    @Override
    public boolean loadClientsFromDDBB() {
        boolean loaded = false;

        Data data = Data.getInstance();
        data.getClientes().clear();

        try {
            File file = new File(clientsDDBB);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Client");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    String id = eElement.getElementsByTagName("id").item(0).getTextContent();
                    String name = eElement.getElementsByTagName("name").item(0).getTextContent();
                    String phone = eElement.getElementsByTagName("phone").item(0).getTextContent();
                    LocalDateTime born = LocalDateTime.parse(eElement.getElementsByTagName("born_date").item(0).getTextContent());
                    Client c = new Client(id, name, phone, born);
                    data.getClientes().add(c);
                }
            }
            loaded = true;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }
        return loaded;

    }

    @Override
    public boolean loadReservationsFromDDBB() {
        boolean loaded = false;

        Data data = Data.getInstance();
        data.getReservas().clear();

        try {
            File file = new File(reservationsDDBB);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder;
            dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(file);

            doc.getDocumentElement().normalize();
            NodeList nList = doc.getElementsByTagName("Reservation");
            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {

                    Element eElement = (Element) nNode;
                    String clientid = eElement.getElementsByTagName("clientid").item(0).getTextContent();
                    IClient c = this.SearchClient(clientid);
                    String productkey = eElement.getElementsByTagName("productkey").item(0).getTextContent();
                    Product p = this.SearchProduct(productkey);
                    LocalDate dateini = LocalDate.parse(eElement.getElementsByTagName("dateini").item(0).getTextContent());
                    LocalDate dateend = LocalDate.parse(eElement.getElementsByTagName("dateend").item(0).getTextContent());
                    String datefinish = eElement.getElementsByTagName("datefinish").item(0).getTextContent();
                    LocalDate finish = datefinish.equals("") ? null : LocalDate.parse(datefinish);
                    Reservation.StatusReserve status;
                    String Sstatus = eElement.getElementsByTagName("status").item(0).getTextContent();

                    switch (Sstatus) {
                        case "ACTIVE":
                            status = Reservation.StatusReserve.ACTIVE;
                            break;
                        case "FINISHED":
                            status = Reservation.StatusReserve.FINISHED;
                            break;
                        case "PENDING":
                            status = Reservation.StatusReserve.PENDING;
                            break;
                        default:
                            status = null;
                            break;
                    }

                    Reservation r = new Reservation(p, c, dateini, dateend, finish, status);
                    data.getReservas().add(r);

                }
            }
            loaded = true;
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            System.out.println(ex);
        }
        return loaded;
    }

    @Override
    public boolean loadAllDDBB() {
        return loadCatalogFromDDBB() && loadClientsFromDDBB() && loadReservationsFromDDBB();
    }

    @Override
    public boolean saveCatalogFromDDBB() {
        boolean saved = false;

        try {
            Data data = Data.getInstance();
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build;

            build = dFact.newDocumentBuilder();

            org.w3c.dom.Document doc = build.newDocument();

            Element root = doc.createElement("Products");

            data.getProductos().stream().map((c) -> {
                Element con;

                if (c instanceof Movie) {
                    Movie m = (Movie) c;
                    con = doc.createElement("Movie");
                    Element category = doc.createElement("movie_category");
                    category.appendChild(doc.createTextNode((String.valueOf(m.getCategory()))));
                    con.appendChild(category);
                    Element minAge = doc.createElement("min_age");
                    minAge.appendChild(doc.createTextNode(String.valueOf(m.getMinAge())));
                    con.appendChild(minAge);

                } else if (c instanceof Game) {
                    Game g = (Game) c;
                    con = doc.createElement("Game");
                    Element category = doc.createElement("game_category");
                    category.appendChild(doc.createTextNode((String.valueOf(g.getCategory()))));
                    con.appendChild(category);
                    Element minAge = doc.createElement("min_age");
                    minAge.appendChild(doc.createTextNode(String.valueOf(g.getMinAge())));
                    con.appendChild(minAge);

                } else {
                    con = doc.createElement("Other");

                }
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(c.getName()));
                con.appendChild(name);

                Element description = doc.createElement("description");
                description.appendChild(doc.createTextNode(c.getDescription()));
                con.appendChild(description);

                Element prize = doc.createElement("prize");
                prize.appendChild(doc.createTextNode(String.valueOf(c.getPrize())));
                con.appendChild(prize);

                Element status = doc.createElement("status");
                status.appendChild(doc.createTextNode(String.valueOf(c.getStatus())));
                con.appendChild(status);

                Element key = doc.createElement("key");
                key.appendChild(doc.createTextNode(c.getKey()));
                con.appendChild(key);

                return con;
            }).forEachOrdered((con) -> {
                root.appendChild(con);
            });
            doc.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(catalogDDBB));

            transformer.transform(source, result);
            saved = true;
        } catch (TransformerException | ParserConfigurationException ex) {
            System.out.println(ex);
        }

        return saved;
    }

    @Override
    public boolean saveClientsFromDDBB() {
        boolean saved = false;

        try {
            Data data = Data.getInstance();
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build;

            build = dFact.newDocumentBuilder();

            org.w3c.dom.Document doc = build.newDocument();

            Element root = doc.createElement("Clients");

            data.getClientes().stream().map((c) -> {
                Element con = doc.createElement("Client");
                Element id = doc.createElement("id");
                id.appendChild(doc.createTextNode(c.getID()));
                con.appendChild(id);
                Element name = doc.createElement("name");
                name.appendChild(doc.createTextNode(c.getName()));
                con.appendChild(name);
                Element phone = doc.createElement("phone");
                phone.appendChild(doc.createTextNode(c.getPhone()));
                con.appendChild(phone);
                Element born = doc.createElement("born_date");
                born.appendChild(doc.createTextNode(String.valueOf(c.getTime())));
                con.appendChild(born);
                return con;
            }).forEachOrdered((con) -> {
                root.appendChild(con);
            });
            doc.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(clientsDDBB));

            transformer.transform(source, result);
            saved = true;
        } catch (TransformerException | ParserConfigurationException ex) {
            System.out.println(ex);
        }

        return saved;
    }

    @Override
    public boolean saveReservationsFromDDBB() {
        boolean saved = false;

        try {
            Data data = Data.getInstance();
            DocumentBuilderFactory dFact = DocumentBuilderFactory.newInstance();
            DocumentBuilder build;

            build = dFact.newDocumentBuilder();

            org.w3c.dom.Document doc = build.newDocument();

            Element root = doc.createElement("Reservations");

            data.getReservas().stream().map((r) -> {
                Element con = doc.createElement("Reservation");

                Element clientid = doc.createElement("clientid");
                clientid.appendChild(doc.createTextNode(r.cli.getID()));
                con.appendChild(clientid);

                Element productkey = doc.createElement("productkey");
                productkey.appendChild(doc.createTextNode(r.pro.getKey()));
                con.appendChild(productkey);

                Element dateini = doc.createElement("dateini");
                dateini.appendChild(doc.createTextNode(r.ini.toString()));
                con.appendChild(dateini);

                Element dateend = doc.createElement("dateend");
                dateend.appendChild(doc.createTextNode(r.end.toString()));
                con.appendChild(dateend);

                Element datefinish = doc.createElement("datefinish");
                datefinish.appendChild(doc.createTextNode((r.finished != null) ? r.finished.toString() : ""));
                con.appendChild(datefinish);

                Element status = doc.createElement("status");
                status.appendChild(doc.createTextNode(String.valueOf(r.status)));
                con.appendChild(status);

                return con;
            }).forEachOrdered((con) -> {
                root.appendChild(con);
            });
            doc.appendChild(root);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();

            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");

            transformer.setOutputProperty(
                    "{http://xml.apache.org/xslt}indent-amount", "4");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");

            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(reservationsDDBB));

            transformer.transform(source, result);
            saved = true;
        } catch (TransformerException | ParserConfigurationException ex) {
            System.out.println(ex);
        }

        return saved;
    }

    @Override
    public boolean saveAllDDBB() {
        return saveCatalogFromDDBB() && saveClientsFromDDBB() && saveReservationsFromDDBB();
    }

}
