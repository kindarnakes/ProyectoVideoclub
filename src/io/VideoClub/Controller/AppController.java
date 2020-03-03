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
import io.VideoClub.Model.IClient;
import io.VideoClub.Model.Product;
import io.VideoClub.Model.Reservation;
import io.VideoClub.View.UIUtilities;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllProducts(Comparator c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByType(ProductsTypes type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByName(String name, ProductsTypes type) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Product> listAllByStatus(Product.Status status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listAllDifferentProducts() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listAllDifferentMovies() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Product> listAllDifferentGames() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Product, Integer> listAllAmountOfProducts(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<Product, Integer> listAllAmountOfProducts(ProductsTypes type, String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IClient> listAllClients() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IClient> listAllClients(Comparator c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<IClient> listAllClientsWithReservationsNotFinished() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Reservation> listAllReservations() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Reservation> listAllReservations(Comparator c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Set<Reservation> listAllReservations(Reservation.StatusReserve status) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getIncommings() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getIncommings(LocalDate from) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double getIncommings(LocalDate from, LocalDate to) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Map<IClient, Double> resumeAllIncomingsByClient() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createProduct(String name, String description, double prize) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createMovie(ProductsTypes type, String name, String description, MovieCategory cat, int minAge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createGame(ProductsTypes type, String name, String description, GameCategory cat, int minAge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean createClient(String id, String name, String phone, LocalDateTime time) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeClient(String id) {
        boolean result = false;
        Set<IClient> A = Data.getInstance().getClientes();
        for (IClient a : A) {
            if (a.getID().equals(id)) {

                result = A.remove(a);
                break;
            }

        }

        return result;
    }

    @Override
    public boolean editClient(IClient e) {
        boolean result = false;
        Set<IClient> A = Data.getInstance().getClientes();
        if (A.contains(e)) {

            e.setName(UIUtilities.getString("Nuevo nombre"));
            e.setPhone(UIUtilities.getString("Nuevo telefono"));
            e.setTime(UIUtilities.getDate("Fecha de nacimiento [yyyy/mm/dd]", "yyyy/MM/dd"));
        }
        return result;
    }

    @Override
    public boolean addProduct(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean removeProduct(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean editProduct(String key, Product newP) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Product isAvailableProduct(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean reserveProduct(Product prod, IClient client) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public double closeReservation() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadCatalogFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean loadAllDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveCatalogFromDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean saveAllDDBB() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
