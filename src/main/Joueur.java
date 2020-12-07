package main;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {
    private String nomJoueur;
    private int idJoueur;
    private Color color;
    private int wagon;
    private int score;

    private ArrayList<Destination> mainDest;
    private ArrayList<Wagon> mainWagon;

    public int totalDestJoueur() {
        int total = 0;
        for (Destination dest: mainDest) {
            total += dest.getValeur();
        }
        return total;
    }
}
