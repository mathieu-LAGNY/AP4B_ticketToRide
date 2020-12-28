package main;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Pattern;

import static java.awt.Color.*;

public class Plateau {
    private final ArrayList<Joueur> joueurs;
    private Deck<Wagon> deckWagon;
    private ArrayList<Destination> pileDestination;
    private ArrayList<Wagon> wagonVisible;
    private int joueurActuel;
    // private int nbManche; Pour coller avec le theme on envisage manche = semestre

    private ArrayList<Route> listeRoute;
    private ArrayList<UV> listeUV;

    /*
    /!\ Ajouter une méthode pour permettre les saisies :
    - Pour l'action de Pioche
    - Pour l'action de destination (+ méthode + affichage)
    - Pour l'action d'achat d'une Route
     */

    /**
     * /!\ Ajouter initalisation de deckWagon
     * Constructeur
     *
     * @param nomJoueurs liste des noms des joueurs qui participent à la partie.
     */
    public Plateau(String[] nomJoueurs, String[] couleurs) {
        joueurActuel = 0;
        int nbJoueurs = nomJoueurs.length;

        // initialisation listeUV
        listeUV = new ArrayList<>();
        UV AP4A = new UV("AP4A");
        listeUV.add(AP4A);
        UV SY40 = new UV("SY40");
        listeUV.add(SY40);
        UV LE01 = new UV("LE01");
        listeUV.add(LE01);
        UV LE02 = new UV("LE02");
        listeUV.add(LE02);
        UV LE03 = new UV("LE03");
        listeUV.add(LE03);
        UV LS01 = new UV("LS01");
        listeUV.add(LS01);
        UV LS02 = new UV("LS02");
        listeUV.add(LS02);
        UV LS03 = new UV("LS03");
        listeUV.add(LS03);
        UV IA41 = new UV("IA41");
        listeUV.add(IA41);
        UV EI10 = new UV("EI10");
        listeUV.add(EI10);
        UV PMA = new UV("PMA");
        listeUV.add(PMA);
        UV MTA = new UV("MTA");
        listeUV.add(MTA);
        UV MTB = new UV("MTB");
        listeUV.add(MTB);
        UV MTC = new UV("MTC");
        listeUV.add(MTC);
        UV PSA1 = new UV("PSA1");
        listeUV.add(PSA1);
        UV PSB1 = new UV("PSB1");
        listeUV.add(PSB1);
        UV LO52 = new UV("LO52");
        listeUV.add(LO52);
        UV ST10 = new UV("ST10");
        listeUV.add(ST10);
        UV ST40 = new UV("ST40");
        listeUV.add(ST40);
        UV ST50 = new UV("ST50");
        listeUV.add(ST50);
        UV IT41 = new UV("IT41");
        listeUV.add(IT41);
        UV IT40 = new UV("IT40");
        listeUV.add(IT40);
        UV IT42 = new UV("IT42");
        listeUV.add(IT42);
        UV IT43 = new UV("IT43");
        listeUV.add(IT43);
        UV IT44 = new UV("IT44");
        listeUV.add(IT44);
        UV IT45 = new UV("IT45");
        listeUV.add(IT45);
        UV RS40 = new UV("RS40");
        listeUV.add(RS40);
        UV HM40 = new UV("HM40");
        listeUV.add(HM40);
        UV SI40 = new UV("SI40");
        listeUV.add(SI40);
        UV SY41 = new UV("SY41");
        listeUV.add(SY41);
        UV GE01 = new UV("GE01");
        listeUV.add(GE01);
        UV GE10 = new UV("GE10");
        listeUV.add(GE10);
        UV PH02 = new UV("PH02");
        listeUV.add(PH02);
        UV PH05 = new UV("PH05");
        listeUV.add(PH05);
        UV SY80 = new UV("SY80");
        listeUV.add(SY80);
        UV SY45 = new UV("SY45");
        listeUV.add(SY45);
        // Initialisation listeRoute
        listeRoute = new ArrayList<>(Arrays.asList(
                new Route(PMA, MTA, gray, 1),
                new Route(MTA, PMA, gray, 1),
                new Route(MTA, PSA1, gray, 1),
                new Route(PSA1, MTA, gray, 1),
                new Route(PSA1, LS01, GREEN, 5),
                new Route(LS01, PSA1, PINK, 5),
                new Route(LS01, ST10, YELLOW, 3),
                new Route(ST10, LS01, PINK, 3),
                new Route(PMA, EI10, gray, 3),
                new Route(MTA, EI10, gray, 4),
                new Route(MTA, MTB, YELLOW, 6),
                new Route(EI10, MTB, GREEN, 4),
                new Route(PSA1, LS02, BLUE, 6),
                new Route(LS01, LS02, ORANGE, 5),
                new Route(LS02, LS01, YELLOW, 5),
                new Route(LE01, LS02, BLUE, 3),
                new Route(ST10, LE01, gray, 2),
                new Route(ST10, GE01, gray, 3),
                new Route(PMA, MTA, gray, 3),
                new Route(EI10, SY41, WHITE, 6),
                new Route(MTB, SY41, BLUE, 4),
                new Route(LS02, MTB, PINK, 3),
                new Route(MTB, PSB1, GREEN, 4),
                new Route(LS02, MTB, RED, 3),
                new Route(MTB, LS02, YELLOW, 3),
                new Route(GE01, PSB1, WHITE, 5),
                new Route(GE01, LE02, BLUE, 3),
                new Route(LE02, LE03, BLUE, 3),
                new Route(PSB1, LE03, RED, 4),
                new Route(ST10, GE10, BLACK, 6),
                new Route(GE01, GE10, gray, 3),
                new Route(GE10, LE03, YELLOW, 5),
                new Route(MTB, MTC, ORANGE, 6),
                new Route(MTB, LS03, RED, 5),
                new Route(SY41, MTC, BLACK, 4),
                new Route(SY41, PH02, gray, 6),
                new Route(MTC, LS03, gray, 2),
                new Route(LS03, MTC, GREEN, 2),
                new Route(MTC, PH02, YELLOW, 3),
                new Route(MTC, PH05, PINK, 6),
                new Route(MTC, HM40, RED, 3),
                new Route(PSB1, LS03, PINK, 4),
                new Route(LS03, AP4A, gray, 1),
                new Route(AP4A, LS03, gray, 1),
                new Route(LS03, HM40, BLUE, 4),
                new Route(PSB1, AP4A, BLACK, 4),
                new Route(AP4A, PSB1, ORANGE, 4),
                new Route(GE10, IA41, RED, 4),
                new Route(GE10, ST40, GREEN, 6),
                new Route(AP4A, SY40, GREEN, 2),
                new Route(SY40, AP4A, PINK, 2),
                new Route(AP4A, LE03, gray, 2),
                new Route(LE03, AP4A, YELLOW, 2),
                new Route(LE03, IT40, BLACK, 2),
                new Route(LE03, IA41, gray, 2),
                new Route(IA41, LE03, gray, 2),
                new Route(IA41, ST40, gray, 2),
                new Route(ST40, IA41, gray, 2),
                new Route(IA41, IT40, gray, 2),
                new Route(IT40, SI40, GREEN, 3),
                new Route(IT40, IT41, WHITE, 3),
                new Route(IT40, SY40, gray, 2),
                new Route(SI40, ST50, RED, 6),
                new Route(SI40, IT42, YELLOW, 4),
                new Route(IT42, SI40, ORANGE, 4),
                new Route(IT42, ST50, BLACK, 5),
                new Route(IT44, ST50, PINK, 4),
                new Route(SY40, HM40, WHITE, 2),
                new Route(HM40, SY40, GREEN, 2),
                new Route(SY40, RS40, ORANGE, 5),
                new Route(SY40, IT41, gray, 2),
                new Route(IT41, IT42, gray, 1),
                new Route(IT41, IT43, BLACK, 3),
                new Route(IT41, RS40, YELLOW, 4),
                new Route(IT42, IT43, gray, 2),
                new Route(IT43, IT42, BLACK, 2),
                new Route(IT42, IT44, gray, 2),
                new Route(IT44, IT43, gray, 2),
                new Route(IT43, IT45, gray, 2),
                new Route(IT45, IT43, gray, 2),
                new Route(IT43, RS40, gray, 2),
                new Route(IT45, SY45, BLACK, 2),
                new Route(SY45, IT45, ORANGE, 2),
                new Route(RS40, IT45, gray, 2),
                new Route(HM40, PH05, WHITE, 4),
                new Route(HM40, RS40, ORANGE, 3),
                new Route(RS40, HM40, BLACK, 3),
                new Route(PH05, RS40, gray, 2),
                new Route(PH05, LO52, gray, 3),
                new Route(RS40, SY45, GREEN, 2),
                new Route(SY45, RS40, WHITE, 2),
                new Route(SY45, SY80, RED, 2),
                new Route(SY80, SY45, YELLOW, 2),
                new Route(SY45, LO52, BLUE, 3),
                new Route(LO52, SY80, gray, 2),
                new Route(SY80, LO52, ORANGE, 2)));
        //initialisation deckDestination
        pileDestination = new ArrayList<>(Arrays.asList(
                new Destination(LS01, LS03, 13),
                new Destination(LE01, LE03, 9),
                new Destination(PSA1, PSB1, 9),
                new Destination(MTA, MTC, 13),
                new Destination(ST10, ST50, 22),
                new Destination(SY40, SY80, 9),
                new Destination(SY40, SY45, 7),
                new Destination(SY41, SY80, 14),
                new Destination(SY41, SY40, 9),
                new Destination(PMA, LO52, 22),
                new Destination(EI10, GE10, 13),
                new Destination(ST10, ST40, 13),
                new Destination(MTA, AP4A, 13),
                new Destination(PMA, ST10, 11),
                new Destination(MTC, IA41, 7),
                new Destination(MTB, IT40, 11),
                new Destination(SI40, IT45, 8),
                new Destination(PH05, ST50, 11),
                new Destination(PH02, SI40, 12),
                new Destination(MTB, HM40, 9),
                new Destination(MTB, PH05, 13),
                new Destination(AP4A, SY80, 12),
                new Destination(IT41, IT45, 5),
                new Destination(IT40, IT44, 6),
                new Destination(PSB1, HM40, 8),
                new Destination(MTC, RS40, 6),
                new Destination(ST40, ST50, 8),
                new Destination(GE01, AP4A, 8),
                new Destination(PH02, IT44, 8),
                new Destination(SY41, AP4A, 7)));
        // initialisation deckWagon
        // Question définir 12 fois un wagon de couleur X ou une seule fois et l'utiliser 12 ?
        // Création des joueurs
        joueurs = new ArrayList<>(nbJoueurs);
        int i = 0;
        for (String nomJoueur : nomJoueurs){
            joueurs.add(new Joueur(nomJoueur, this, Color.getColor(couleurs[i]))); // a tester
            i++;
        }
        wagonVisible = piocherWagon(5);
    }

    public Wagon saisiePiocheVisible(Boolean locomotiveTiree) {
        while (true) {
            System.out.println("Prendre une carte de la pioche [1] ou une carte visible [2] ?");
            String choix = System.console().readLine();
            switch (choix) {
                case "1":
                    //Note : Lorsqu'on pioche, il n'y a pas à vérifier si la carte pioché est une locomotive.
                    return this.piocherWagon(1).get(1);
                case "2":
                    return saisieVisible(locomotiveTiree);
                default:
                    System.out.println("Choix incorrect");
                    break;
            }
        }
    }

    public Wagon saisieVisible(Boolean locomotiveTiree) {
        int indice = 0;
        for (Wagon wagon : wagonVisible) {
            String string = String.format("[%d] %s", indice, wagonVisible);
            System.out.println(string);
        }
        while (true) {
            System.out.println("Choisir le numéro de la carte à tirer");
            String choix = System.console().readLine();
            switch (choix) {
                case "1":
                    System.out.println(wagonVisible.get(1).getClass());
                case "2":
                    System.out.println(wagonVisible.get(2).getClass());
                case "3":
                    System.out.println(wagonVisible.get(3).getClass());
                case "4":
                    System.out.println(wagonVisible.get(4).getClass());
                case "5":
                    System.out.println(wagonVisible.get(5).getClass());
                default:
                    System.out.println("Choix incorrect");
                    break;
            }
        }
    }
    /**
     * Permet de piocher la carte {indice} dans les cartes visibles
     * la renvoie et complète les cartes wagon visibles
     */
    public Wagon piocheWagonVisible(int indice) {
        Wagon wagon = wagonVisible.remove(indice-1);
        wagonVisible.addAll(piocherWagon(1));
        return wagon;
    }

    public ArrayList<Integer> saisieDestination() {
        ArrayList<Integer> tabIndice = new ArrayList<>();
        tabIndice.add(1);
        tabIndice.add(2);
        tabIndice.add(3);
        while (true) {
            System.out.println("Saisir une par une les cartes destination à enlever, puis saisir \"V\" pour valider");
            String choix = System.console().readLine();
            switch (choix) {
                case "1":
                    tabIndice.removeIf(x -> (x==1));
                    break;
                case "2":
                    tabIndice.removeIf(x -> (x==2));
                    break;
                case "3":
                    tabIndice.removeIf(x -> (x==3));
                    break;
                case "V":
                    return tabIndice;
                default:
                    System.out.println("Saisie incorrect");
                    break;
            }
        }
    }

    public ArrayList<String> saisieRoute(){
        while (true) {
            System.out.println("Saisir les deux routes en séparant par un espace (insensible à la case)");
            String choix = System.console().readLine();
            String regex = "/[A-Z] [A-Z]/i";
            if(Pattern.matches(regex, choix))
            {
                ArrayList<String> choixRoute = new ArrayList<>(Arrays.asList(choix.split(" ")));
                return choixRoute;
            }
            else{
                System.out.println("Saisie incorrect");
            }
        }
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
     *
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
     *
     * @param min nombre minimum de cartes à prendre (2 au début, 1 sinon)
     * @return liste des cartes destinaation choisies
     */
    public ArrayList<Destination> choisirDest(int min) {
        ArrayList<Destination> pioche = new ArrayList<>();
        for (int i = 0; i < 3; i++) pioche.add(pileDestination.remove(0));
        // affichage
        System.out.println("Cartes destination piochees");
        for (Destination destination : pioche) {
            System.out.println(destination + "\n");
        }
        // retourne un tableau des indices non choisis
        // les cartes qu'on ne veut pas sont remises sous la pile de cartes destination
        for (int indice: saisieDestination()) {
            pileDestination.add(pioche.remove(indice-1));
        }
        return pioche;
    }

    /**
     * /!\ Ajouter le choix : affichage + saisie
     *
     * @return route choisie, null si la route n'est pas valide
     */
    public Route choisirRoute() {
        // choix
        // appel à acheterRoute (les arguments peuvent être modifiés en fonction de ce qui nous arrange)
        Route route = acheterRoute("UVA", "UVB"); // patron
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
        for (Joueur joueur : joueurs) {
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
        for (Joueur joueur : joueurs) {
            if (joueur.plusDeWagon()) return true;
        }
        return false;
    }

    /**
     * /!\ Penser aux routes doubles
     * <p>
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
     * <p>
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
     * <p>
     * Cette représentation comporte
     * - l'affichage du joueur dont c'est le tour
     * - la liste des 5 cartes wagons retournées avec leur couleur
     * - la liste des routes libres avec pour chacune :
     * - les villes reliees
     * - son coût
     * <p>
     * On pourrait par exemple avoir l'affichage suivant:
     * <p>
     * -- Tour de toto --
     * Mes routes   Mes destinations   Mes wagons
     * SY40-AP4A    SY40-RN41 10pts    2xLocomotives
     * AP4A-RN41                       3xJaune
     * 4xNoir
     * - Pioche -
     * Bleu Locomotive Rouge Rouge Vert
     * - Routes -
     * SY40-LE02 4xBleu   SY40-LE02 2xRouge   AP4A-IT40 4xOrange
     * LE02-IT40 3xVert   RN40-LE02 3xBlanc   IT40-DR04 3xBlanc
     * RN40-RN41 5xNoir
     */
    @Override
    public String toString() {
        String texte = joueurs.get(joueurActuel) + "\n";
        texte += "\nPioche\n";
        for (Wagon wagon : wagonVisible) texte += wagon;
        texte += "\nRoutes libres\n";
        for (Route route : listeRoute) texte += route + "\n";
        return texte;
    }
}
