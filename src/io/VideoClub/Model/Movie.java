/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.VideoClub.Model;


import io.VideoClub.Model.Enums.MovieCategory;

/**
 *
 * @author Santos
 */
public class Movie extends Product implements Cloneable, Comparable<Movie> {

    private MovieCategory category;

    public Movie(String name, String description, double prize, Status status, MovieCategory category) {
        super(name, description, prize, status);
        this.category=category;
    }

    

  
 

   

    public MovieCategory getCategory() {
        return category;
    }

    public void setCategory(MovieCategory category) {
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
        return super.toString() + " | Pelicula, categoria=" + category;
    }

    @Override
    public boolean equals(Object o) {
        boolean result = false;
        if (o != null) {
            if (this == o) {
                if (o instanceof Movie) {
                    Movie aux = (Movie) o;
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
    public int compareTo(Movie t) {
        return this.getKey().compareTo(t.getKey());
    }
   
   
   
   
   
   

}