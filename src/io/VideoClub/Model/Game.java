/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import io.VideoClub.Model.Enums.GameCategory;
import io.VideoClub.Model.Enums.ProductsTypes;

/**
 *
 * @author Santos
 */
public class Game extends Product implements Cloneable{

    private GameCategory category;

    public Game(String name, String description, double prize, Status status, GameCategory category) {
        super(name, description, prize, status, ProductsTypes.Peliculas);
        this.category = category;
    }

    public Game(GameCategory category, String key, Status status, ProductsTypes type, String name, String description, double prize) {
        super(key, status, type, name, description, prize);
        this.category = category;
    }

    

    public GameCategory getCategory() {
        return category;
    }

    public void setCategory(GameCategory category) {
        this.category = category;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public double getPrize() {
        return prize;
    }

    @Override
    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return "Juego, categoria=" + category + "| " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null) {
            if (this == o) {
                if (o instanceof Game) {
                    Game aux = (Game) o;
                    if (super.equals(o)) {
                        result = true;
                    }

                }

            }
        }

        return result;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

}
