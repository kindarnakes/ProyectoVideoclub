/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import io.VideoClub.Model.Enums.GameCategory;

/**
 *
 * @author Santos
 */
public class Game extends Product implements Cloneable, Comparable<Game> {

    private GameCategory category;

    public Game(String name, String description, double prize, GameCategory category) {
        super(name, description, prize);
        this.category = category;

    }

    public GameCategory getCategory() {
        return category;
    }

    public void setCategory(GameCategory category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrize() {
        return prize;
    }

    public void setPrize(double prize) {
        this.prize = prize;
    }

    @Override
    public String toString() {
        return super.toString() + "Game{" + "category=" + category + '}';
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

    @Override
    public int compareTo(Game t) {
        return this.getKey().compareTo(t.getKey());
    }

}
