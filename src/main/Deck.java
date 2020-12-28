package main;

import java.util.ArrayList;
import java.util.Collections;

public class Deck<T extends Carte> {
    private ArrayList<T> pioche;
    private ArrayList<T> defausse;

    public Deck(ArrayList<T> pioche) {
        this.pioche = pioche;
    }

    /**
     * Pioche x cartes, si la pioche ne contient pas assez de cartes,
     * mélange la pioche et la défausse
     * @param x nombre de cartes à piocher
     * @return une liste des cartes piochées
     */
    public ArrayList<T> piocher(int x) {
        ArrayList<T> cartes = new ArrayList<>();
        if (x>nbCartes()) {
            remettrePioche();
        }
        return cartes;
    }

    /**
     * @return le nombre de cartes dans la pioche
     */
    public int nbCartes() {
        return pioche.size();
    }

    /**
     * @param listeCartes liste des cartes à mettre dans la defausse
     */
    public void defausser(ArrayList<T> listeCartes) {
        defausse.addAll(listeCartes);
    }

    /**
     * Ajoute les cartes de la defausse dans la pioche et la mélange
     */
    public void remettrePioche() {
        pioche.addAll(defausse);
        Collections.shuffle(pioche);
        defausse.clear();
    }
}
