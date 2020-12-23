package main;

import java.util.ArrayList;

public class Plateau {
    private final ArrayList<Joueur> joueurs;
    private Deck<Wagon> deckWagon;
    private ArrayList<Destination> pileDestination;
    private ArrayList<Wagon> wagonVisible;
    private int joueurActuel;
    private int nbManche; // Pour coller avec le theme on envisage manche = semestre

    private ArrayList<Route> listeRoute;
    private ArrayList<UV> listeUV;

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
     * @return liste des cartes wagon piochées
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
     * /!\ Ajouter le choix : affichage + saisie
     * Prend 3 cartes destination et fait choisir au joueur
     * @param min nombre minimum de cartes à prendre (2 au début, 1 sinon)
     * @return liste des cartes destinaation choisies
     */
    public ArrayList<Destination> choisirDest(int min) {
        ArrayList<Destination> pioche = new ArrayList<>();
        for (int i = 0; i < 3; i++) pioche.add(pileDestination.remove(0));
        // affichage
        System.out.println("Cartes destination piochees");
        for (Destination destination: pioche) {
            System.out.println(destination + "\n");
        }
        // choix
        // les cartes qu'on ne veut pas sont remises sous la pile de cartes destination
        // pileDestination.add(pioche.remove(indice des cartes non choisies));
        return pioche;
    }

    /**
     * /!\ Ajouter le choix : affichage + saisie
     * @return route choisie, null si la route n'est pas valide
     */
    public Route choisirRoute() {
        // choix
        // appel à acheterRoute (les arguments peuvent être modifiés en fonction de ce qui nous arrange)
        Route route = acheterRoute("UVA","UVB"); // patron
        return route;
    }

    /**
     * Fait le total des cartes destinations pour chaque joueur
     * à la fin de la partie et l'ajoute à leur score.
     */
    private void totalDest() {

    }

    /**
     * Appelle totalDest puis affiche les scores de chaque joueur
     */
    private void finPartie() {
        totalDest();
        String affichage = "Scores\n";
        for (Joueur joueur: joueurs) {
            affichage += joueur.getNomJoueur() + " ";
            affichage += joueur.getScore() + "\n";
        }
        System.out.println(affichage);
    }

    /**
     * Teste si la partie est terminée
     *
     * @return un booléen indiquant si la partie est terminée, c'est-à-dire si
     * au moins l'un des joueurs a moins de 3 pions wagons
     */
    private boolean estFini() {
        for (Joueur joueur: joueurs) {
            if (joueur.plusDeWagon()) return true;
        }
        return false;
    }

    /**
     * /!\ Penser aux routes doubles
     *
     * Un joueur achète une route entre deux villes, la route doit être libre
     * (dans listeRoute) et le joueur doit avoir les cartes wagon correspondantes.
     * Si l'action est valide on renvoie la route, sinon null;
     */
    private Route acheterRoute(String villeA, String villeB) {
        boolean valide = true; // patron
        Route route = null; // patron
        // verification de la validité et on recupere l'indice de la route dans la liste
        int indice = 0; // patron

        if (valide) {
            // retire la route de celles disponible
            route = listeRoute.get(indice);
        }
        return route;
    }

    /**
     * Boucle d'exécution d'une partie.
     *
     * Cette méthode exécute les tours des joueurs jusqu'à ce que la partie soit
     * terminée. Lorsque la partie se termine, un dernier tour est effectuée puis
     * la méthode affiche le score final
     */
    public void run() {
        while (!estFini()) {
            // joue le tour du joueur courant
            joueurs.get(joueurActuel).playTurn();
            // passe au joueur suivant
            joueurActuel += 1;
            if (joueurActuel >= joueurs.size()) {
                joueurActuel = 0;
            }
        }
        // le dernier tour avant la fin
        for (int i = 0; i < joueurs.size(); i++) {
            // joue le tour du joueur courant
            joueurs.get(joueurActuel).playTurn();
            // passe au joueur suivant
            joueurActuel += 1;
            if (joueurActuel >= joueurs.size()) {
                joueurActuel = 0;
            }
        }
        finPartie();
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
        String texte = joueurs.get(joueurActuel) + "\n";
        texte += "\nPioche\n";
        for (Wagon wagon: wagonVisible) texte += wagon;
        texte += "\nRoutes libres\n";
        for (Route route: listeRoute) texte += route + "\n";
        return texte;
    }
}
