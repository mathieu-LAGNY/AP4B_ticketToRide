package main;

import java.awt.*;

public class Wagon extends Carte {


    private Color couleur;

    public Wagon(Color couleur) {
        this.couleur = couleur;
    }

    public boolean equals(Wagon wagon) {
        return wagon.couleur == this.couleur;
    }

    @Override
    public String toString() {
        return this.couleur.toString();
    }

    public Color getCouleur() {
        return couleur;
    }
}
