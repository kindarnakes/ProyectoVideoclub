/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;

import io.VideoClub.Model.Enums.ProductsTypes;

/**
 *
 * @author Santos
 */
public class Other extends Product implements Cloneable, Comparable<Other>{

    public Other(String name, String description, double prize, Status status, ProductsTypes tipo) {
        super(name, description, prize, status, tipo);
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
        return super.toString() + " | Otros";
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null) {
            if (this == o) {
                if (o instanceof Other) {
                    Other aux = (Other) o;
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
    public int compareTo(Other t) {
        return this.getKey().compareTo(t.getKey());
    }

}
