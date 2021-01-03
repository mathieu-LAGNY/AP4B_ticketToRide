package main;

import java.awt.*;

public class Wagon extends Carte {


    private Color couleur;

    public Wagon(Color couleur) {
        this.couleur = couleur;
    }

    public Color getCouleur() {
        return couleur;
    }

    @Override
    public String toString() {
        return this.couleur.toString();
    }
}
