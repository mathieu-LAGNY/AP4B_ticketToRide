package main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck<Carte> {
    private ArrayList<Carte> pioche;
    private ArrayList<Carte> defausse;

    public ArrayList<Carte> piocher(int x) {
        ArrayList<Carte> cartes = new ArrayList<>();
        if (x>nbCartes()) {
            remettrePioche();
        }
        return cartes;
    }

    public int nbCartes() {
        return pioche.size();
    }

    public void defausser(ArrayList<Carte> listeCartes) {
        defausse.addAll(listeCartes);
    }

    public void remettrePioche() {
        pioche.addAll(defausse);
        Collections.shuffle(pioche);
        defausse.clear();
    }
}
