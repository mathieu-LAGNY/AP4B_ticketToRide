package main;

import java.awt.*;
import java.util.Objects;

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

    public Route(Route R) {
        this.UVA = R.UVA;
        this.UVB = R.UVB;
        this.routeCouleur = R.routeCouleur;
        this.longueur = R.longueur;
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

    public UV getUVA() {
        return UVA;
    }

    public UV getUVB() {
        return UVB;
    }

    @Override
    public String toString() {
        return UVA +
                "-" + UVB +
                " " + longueur +
                "x" + routeCouleur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Route route = (Route) o;
        return longueur == route.longueur && UVA.equals(route.UVA) && UVB.equals(route.UVB) && routeCouleur.equals(route.routeCouleur);
    }

    @Override
    public int hashCode() {
        return Objects.hash(UVA, UVB, routeCouleur, longueur);
    }
}
