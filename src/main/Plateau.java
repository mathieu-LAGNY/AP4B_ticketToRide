package main;

import java.util.ArrayList;

public class Plateau {
    private final ArrayList<Joueur> joueurs;
    private Deck<Wagon> deckWagon;
    private Deck<Destination> deckDestination;
    private ArrayList<Wagon> wagonVisible;
    private int joueurActuel;
    private int nbManche; // Pour coller avec le theme on envisage manche = semestre

    /*
    /!\ Ajouter une méthode pour permettre les saisies :
    - Pour l'action de Pioche
    - Pour l'action de destination (+ méthode + affichage)
    - Pour l'action d'achat d'une Route
     */

    /**
     * /!\ Ajouter initalisation des decks, des routes et des UV
     *
     * Constructeur
     *
     * @param nomJoueurs liste des noms des joueurs qui participent à la partie.
     */
    public Plateau(String[] nomJoueurs, String[] couleurs, int nbManche) {
        joueurActuel = 0;
        int nbJoueurs = nomJoueurs.length;

        // initialisation deckDestination
        // initialisation deckWagon

        // Création des joueurs
        joueurs = new ArrayList<>(nbJoueurs);
        for (String nomJoueur : nomJoueurs)
            joueurs.add(new Joueur(nomJoueur,this));

        wagonVisible = piocherWagon(5);
    }

    /**
     * Renvoie le joueur correspondant à l'indice passé en argument
     * On suppose {@code index} est un indice valide du tableau
     * {@code joueurs}
     *
     * @param index indice dans le tableau des joueurs du joueur à renvoyer
     */
    public Joueur getPlayer(int index) {
        return joueurs.get(index);
    }

    /**
     * @param x nombre de cartes wagon a prendre dans la pioche de Wagon
     */
    public ArrayList<Wagon> piocherWagon(int x) {
        return deckWagon.piocher(x);
    }

    /**
     * /!\ Ajouter le choix : saisie
     * Action de Pioche, le joueur choisit s'il tire dans la pioche ou dans les
     * cartes visibles à deux reprises. Une seule fois si la première est une locomotive
     * visible et il ne peut prendre de locomotive visible en deuxième.
     */
    public ArrayList<Wagon> choisirWagon() {
        ArrayList<Wagon> pioche = new ArrayList<>();
        // saisie
        // pioche dans le deck ou dans les cartes visibles
        //pioche.add(carte);
        // saisie
        // pioche dans le deck ou dans les cartes visibles
        //pioche.add(carte);
        return pioche;
    }

    /**
     * @param x nombre de cartes destination a prendre dans la pioche de Destination
     */
    public ArrayList<Destination> piocherDest(int x) {
        return deckDestination.piocher(x);
    }

    /**
     * /!\ Ajouter le choix : affichage + saisie
     * Prend 3 cartes destination et fait choisir au joueur
     * @param min nombre minimum de cartes à prendre (2 au début, 1 sinon)
     */
    public ArrayList<Destination> choisirDest(int min) {
        ArrayList<Destination> pioche = deckDestination.piocher(3);
        // affichage
        // choix
        // on eneleve ce qu'on ne veut pas
        return pioche;
    }

    /**
     * Fait le total des cartes destinations pour chaque joueur
     * à la fin de la partie et l'ajoute à leur score.
     */
    private void totalDest() {

    }

    /**
     * Teste si la partie est terminée
     *
     * @return un booléen indiquant si la partie est terminée, c'est-à-dire si
     * au moins l'un des joueurs a moins de 3 pions wagons
     */
    private boolean estFini() {
        return true;
    }

    /**
     * /!\ Penser aux routes doubles
     *
     * Un joueur achète une route entre deux villes
     */
    private void acheterRoute(String villeA, String villeB) {

    }

    /**
     * Boucle d'exécution d'une partie.
     *
     * Cette méthode exécute les tours des joueurs jusqu'à ce que la partie soit
     * terminée. Lorsque la partie se termine, la méthode affiche le score final
     */
    public void run() {

    }

    /**
     * Renvoie une représentation de l'état de la partie sous forme d'une chaîne
     * de caractères.
     *
     * Cette représentation comporte
     * - l'affichage du joueur dont c'est le tour
     * - la liste des 5 cartes wagons retournées avec leur couleur
     * - la liste des routes libres avec pour chacune :
     * - les villes reliees
     * - son coût
     *
     * On pourrait par exemple avoir l'affichage suivant:
     *
     *      -- Tour de toto --
     * Mes routes   Mes destinations   Mes wagons
     * SY40-AP4A    SY40-RN41 10pts    2xLocomotives
     * AP4A-RN41                       3xJaune
     *                                 4xNoir
     *      - Pioche -
     * Bleu Locomotive Rouge Rouge Vert
     *      - Routes -
     * SY40-LE02 4xBleu   SY40-LE02 2xRouge   AP4A-IT40 4xOrange
     * LE02-IT40 3xVert   RN40-LE02 3xBlanc   IT40-DR04 3xBlanc
     * RN40-RN41 5xNoir
     */
    @Override
    public String toString() {
        return null;
    }
}
