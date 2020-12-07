package main;

import java.util.ArrayList;

public class Deck {
    private ArrayList<Carte> pioche;
    private ArrayList<Carte> defausse;

    public ArrayList<Carte> piocher(int x) {
        return null;
    }

    public int nbCartes() {
        return pioche.size();
    }

    public void defausser(ArrayList<Carte> listeCartes) {
        defausse.addAll(listeCartes);
    }

    public void remettrePioche() {
        pioche.addAll(defausse);
        defausse.clear();
    }
}
