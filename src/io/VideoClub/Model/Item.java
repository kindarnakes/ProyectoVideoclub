package io.VideoClub.Model;


public abstract class Item {
     protected String name;
     protected String description;
     protected double prize;
    
    public Item(){}
    public Item(String name, String description, double prize) {
        this.name = name;
        this.description = description;
        this.prize = prize;
    }

    @Override
    public String toString() {
       return "Item, nombre="+name+", descripcion="+description+", precio="+prize;
       
    }
    
}
