package main;

import java.awt.*;

public class Route {
    private UV UVA;
    private UV UVB;
    private Color routeCouleur;
    private int longueur;

    public Route(UV UVA, UV UVB, Color routeCouleur, int longueur) {
        this.UVA = UVA;
        this.UVB = UVB;
        this.routeCouleur = routeCouleur;
        this.longueur = longueur;
    }

    public String getName() {
        return UVA + "-" + UVB;
    }

    public int getLongueur() {
        return longueur;
    }

    public Color getRouteCouleur() {
        return routeCouleur;
    }

    @Override
    public String toString() {
        return UVA +
                "-" + UVB +
                " " + longueur +
                "x" + routeCouleur;
    }
}
