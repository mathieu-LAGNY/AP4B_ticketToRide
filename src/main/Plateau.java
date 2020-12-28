package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class Plateau {
    private final ArrayList<Joueur> joueurs;
    private Deck<Wagon> deckWagon;
    private Deck<Destination> deckDestination;
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

    //TODO Ajouter une méthode qui permet de remplacer de prendre puis remplacer le wagon visible
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

    public ArrayList<Integer> saisieDestination() {
        ArrayList<Integer> tabIndice = new ArrayList<>();
        tabIndice.add(1);
        tabIndice.add(2);
        tabIndice.add(3);
        while (true) {
            System.out.println("Saisir les cartes de destination à garder, saisir \"V\" pour valider");
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
                break;
            }
        }
    }

    /**
     * /!\ Ajouter initalisation des decks, des routes et des UV
     * <p>
     * Constructeur
     *
     * @param nomJoueurs liste des noms des joueurs qui participent à la partie.
     */
    public Plateau(String[] nomJoueurs, String[] couleurs, int nbManche) {
        joueurActuel = 0;
        int nbJoueurs = nomJoueurs.length;

        // initialisation listeUV
        listeUV = [UV AP4A = new UV("AP4A"),
        UV SY40 = new UV("SY40"),
        UV LE01 = new UV("LE01"),
        UV LE02 = new UV("LE02"),
        UV LE03 = new UV("LE03"),
        UV LS01 = new UV("LS01"),
        UV LS02 = new UV("LS02"),
        UV LS03 = new UV("LS03"),
        UV IA41 = new UV("IA41"),
        UV EI10 = new UV("EI10"),
        UV PMA = new UV("PMA"),
        UV MTA = new UV("MTA"),
        UV MTB = new UV("MTB"),
        UV MTC = new UV("MTC"),
        UV PSA1 = new UV("PSA1"),
        UV PSB1 = new UV("PSB1"),
        UV LO52 = new UV("LO52"),
        UV ST10 = new UV("ST10"),
        UV ST40 = new UV("ST40"),
        UV ST50 = new UV("ST50"),
        UV IT41 = new UV("IT41"),
        UV IT40 = new UV("IT40"),
        UV IT42 = new UV("IT42"),
        UV IT43 = new UV("IT43"),
        UV IT44 = new UV("IT44"),
        UV IT45 = new UV("IT45"),
        UV RS40 = new UV("RS40"),
        UV HM40 = new UV("HM40"),
        UV SI40 = new UV("SI40"),
        UV SY41 = new UV("SY41"),
        UV GE01 = new UV("GE01"),
        UV GE10 = new UV("GE10"),
        UV PH02 = new UV("PH02"),
        UV PH05 = new UV("PH05"),
        UV SY80 = new UV("SY80"),
        UV SY45 = new UV("SY45")]
        // Initialisation listeRoute
        listeRoute = [Route PMA_MTA = new Route(PMA, MTA, gray, 1),
        Route MTA_PMA = new Route(MTA, PMA, gray, 1),
        Route MTA_PSA1 = new Route(MTA, PSA1, gray, 1),
        Route PSA1_MTA = new Route(PSA1, MTA, gray, 1),
        Route PSA1_LS01 = new Route(PSA1, LS01, GREEN, 5),
        Route LS01_PSA1 = new Route(LS01, PSA1, PINK, 5),
        Route LS01_ST10 = new Route(LS01, ST10, YELLOW, 3),
        Route ST10_LS01 = new Route(ST10, LS01, PINK, 3),
        Route PMA_EI10 = new Route(PMA, EI10, gray, 3),
        Route MTA_EI10 = new Route(MTA, EI10, gray, 4),
        Route MTA_MTB = new Route(MTA, MTB, YELLOW, 6),
        Route EI10_MTB = new Route(EI10, MTB, GREEN, 4),
        Route PSA1_LS02 = new Route(PSA1, LS02, BLUE, 6),
        Route LS01_LS02 = new Route(LS01, LS02, ORANGE, 5),
        Route LS02_LS01 = new Route(LS02, LS01, YELLOW, 5),
        Route LE01_LS02 = new Route(LE01, LS02, BLUE, 3),
        Route ST10_LE01 = new Route(ST10, LE01, gray, 2),
        Route ST10_GE01 = new Route(ST10, GE01, gray, 3),
        Route PMA_MTA = new Route(PMA, MTA, gray, 3),
        Route EI10_SY41 = new Route(EI10, SY41, WHITE, 6),
        Route MTB_SY41 = new Route(MTB, SY41, BLUE, 4),
        Route LS02_MTB = new Route(LS02, MTB, PINK, 3),
        Route MTB_PSB1 = new Route(MTB, PSB1, GREEN, 4),
        Route LS02_MTB = new Route(LS02, MTB, RED, 3),
        Route MTB_LS02 = new Route(MTB, LS02, YELLOW, 3),
        Route GE01_PSB1 = new Route(GE01, PSB1, WHITE, 5),
        Route GE01_LE02 = new Route(GE01, LE02, BLUE, 3),
        Route LE02_LE03 = new Route(LE02, LE03, BLUE, 3),
        Route PSB1_LE03 = new Route(PSB1, LE03, RED, 4),
        Route ST10_GE10 = new Route(ST10, GE10, BLACK, 6),
        Route GE01_GE10 = new Route(GE01, GE10, gray, 3),
        Route GE10_LE03 = new Route(GE10, LE03, YELLOW, 5),
        Route MTB_MTC = new Route(MTB, MTC, ORANGE, 6),
        Route MTB_LS03 = new Route(MTB, LS03, RED, 5),
        Route SY41_MTC = new Route(SY41, MTC, BLACK, 4),
        Route SY41_PH02 = new Route(SY41, PH02, gray, 6),
        Route MTC_LS03 = new Route(MTC, LS03, gray, 2),
        Route LS03_MTC = new Route(LS03, MTC, GREEN, 2),
        Route MTC_PH02 = new Route(MTC, PH02, YELLOW, 3),
        Route MTC_PH05 = new Route(MTC, PH05, PINK, 6),
        Route MTC_HM40 = new Route(MTC, HM40, RED, 3),
        Route PSB1_LS03 = new Route(PSB1, LS03, PINK, 4),
        Route LS03_AP4A = new Route(LS03, AP4A, gray, 1),
        Route AP4A_LS03 = new Route(AP4A, LS03, gray, 1),
        Route LS03_HM40 = new Route(LS03, HM40, BLUE, 4),
        Route PSB1_AP4A = new Route(PSB1, AP4A, BLACK, 4),
        Route AP4A_PSB1 = new Route(AP4A, PSB1, ORANGE, 4),
        Route GE10_IA41 = new Route(GE10, IA41, RED, 4),
        Route GE10_ST40 = new Route(GE10, ST40, GREEN, 6),
        Route AP4A_SY40 = new Route(AP4A, SY40, GREEN, 2),
        Route SY40_AP4A = new Route(SY40, AP4A, PINK, 2),
        Route AP4A_LE03 = new Route(AP4A, LE03, gray, 2),
        Route LE03_AP4A = new Route(LE03, AP4A, YELLOW, 2),
        Route LE03_IT40 = new Route(LE03, IT40, BLACK, 2),
        Route LE03_IA41 = new Route(LE03, IA41, gray, 2),
        Route IA41_LE03 = new Route(IA41, LE03, gray, 2),
        Route IA41_ST40 = new Route(IA41, ST40, gray, 2),
        Route ST40_IA41 = new Route(ST40, IA41, gray, 2),
        Route IA41_IT4O = new Route(IA41, IT40, gray, 2),
        Route IT40_SI40 = new Route(IT40, SI40, GREEN, 3),
        Route IT40_IT41 = new Route(IT40, IT41, WHITE, 3),
        Route IT40_SY40 = new Route(IT40, SY40, gray, 2),
        Route SI40_ST50 = new Route(SI40, ST50, RED, 6),
        Route SI40_IT42 = new Route(SI40, IT42, YELLOW, 4),
        Route IT42_SI40 = new Route(IT42, SI40, ORANGE, 4),
        Route IT42_ST50 = new Route(IT42, ST50, BLACK, 5),
        Route IT44_ST50 = new Route(IT44, ST50, PINK, 4),
        Route SY40_HM40 = new Route(SY40, HM40, WHITE, 2),
        Route HM40_SY40 = new Route(HM40, SY40, GREEN, 2),
        Route SY40_RS40 = new Route(SY40, RS40, ORANGE, 5),
        Route SY40_IT41 = new Route(SY40, IT41, gray, 2),
        Route IT41_IT42 = new Route(IT41, IT42, gray, 1),
        Route IT41_IT43 = new Route(IT41, IT43, BLACK, 3),
        Route IT41_RS40 = new Route(IT41, RS40, YELLOW, 4),
        Route IT42_IT43 = new Route(IT42, IT43, gray, 2),
        Route IT43_IT42 = new Route(IT43, IT42, BLACK, 2),
        Route IT42_IT44 = new Route(IT42, IT44, gray, 2),
        Route IT44_IT43 = new Route(IT44, IT43, gray, 2),
        Route IT43_IT45 = new Route(IT43, IT45, gray, 2),
        Route IT45_IT43 = new Route(IT45, IT43, gray, 2),
        Route IT43_RS40 = new Route(IT43, RS40, gray, 2),
        Route IT45_SY45 = new Route(IT45, SY45, BLACK, 2),
        Route SY45_IT45 = new Route(SY45, IT45, ORANGE, 2),
        Route RS40_IT45 = new Route(RS40, IT45, gray, 2),
        Route HM40_PH05 = new Route(HM40, PH05, WHITE, 4),
        Route HM40_RS40 = new Route(HM40, RS40, ORANGE, 3),
        Route RS40_HM40 = new Route(RS40, HM40, BLACK, 3),
        Route PH05_RS40 = new Route(PH05, RS40, gray, 2),
        Route PH05_LO52 = new Route(PH05, LO52, gray, 3),
        Route RS40_SY45 = new Route(RS40, SY45, GREEN, 2),
        Route SY45_RS40 = new Route(SY45, RS40, WHITE, 2),
        Route SY45_SY80 = new Route(SY45, SY80, RED, 2),
        Route SY80_SY45 = new Route(SY80, SY45, YELLOW, 2),
        Route SY45_LO52 = new Route(SY45, LO52, BLUE, 3),
        Route LO52_SY80 = new Route(LO52, SY80, gray, 2),
        Route SY80_LO52 = new Route(SY80, LO52, ORANGE, 2)]
        //initialisation deckDestination
        deckDestination.definirPioche([Destination LS01 / LS03 = new Destination(LS01, LS03, 13),
                Destination LE01 / LE03 = new Destination(LE01, LE03, 9),
                Destination PSA1 / PSB1 = new Destination(PSA1, PSB1, 9),
                Destination MTA / MTC = new Destination(MTA, MTC, 13),
                Destination ST10 / ST50 = new Destination(ST10, ST50, 22),
                Destination SY40 / SY80 = new Destination(SY40, SY80, 9),
                Destination SY40 / SY45 = new Destination(SY40, SY45, 7),
                Destination SY41 / SY80 = new Destination(SY41, SY80, 14),
                Destination SY41 / SY40 = new Destination(SY41, SY40, 9),
                Destination PMA / LO52 = new Destination(PMA, LO52, 22),
                Destination EI10 / GE10 = new Destination(EI10, GE10, 13),
                Destination ST10 / ST40 = new Destination(ST10, ST40, 13),
                Destination MTA / AP4A = new Destination(MTA, AP4A, 13),
                Destination PMA / ST10 = new Destination(PMA, ST10, 11),
                Destination MTC / IA41 = new Destination(MTC, IA41, 7),
                Destination MTB / IT40 = new Destination(MTB, IT40, 11),
                Destination SI40 / IT45 = new Destination(SI40, IT45, 8),
                Destination PH05 / ST50 = new Destination(PH05, ST50, 11),
                Destination PH02 / SI40 = new Destination(PH02, SI40, 12),
                Destination MTB / HM40 = new Destination(MTB, HM40, 9),
                Destination MTB / PH05 = new Destination(MTB, PH05, 13),
                Destination AP4A / SY80 = new Destination(AP4A, SY80, 12),
                Destination IT41 / IT45 = new Destination(IT41, IT45, 5),
                Destination IT40 / IT44 = new Destination(IT40, IT44, 6),
                Destination PSB1 / HM40 = new Destination(PSB1, HM40, 8),
                Destination MTC / RS40 = new Destination(MTC, RS40, 6),
                Destination ST40 / ST50 = new Destination(ST40, ST50, 8),
                Destination GE01 / AP4A = new Destination(GE01, AP4A, 8),
                Destination PH02 / IT44 = new Destination(PH02, IT44, 8),
                Destination SY41 / AP4A = new Destination(SY41, AP4A, 7)]);
        // initialisation deckWagon
        // Question définir 12 fois un wagon de couleur X ou une seule fois et l'utiliser 12 ?
        // Création des joueurs
        joueurs = new ArrayList<>(nbJoueurs);
        for (String nomJoueur : nomJoueurs)
            joueurs.add(new Joueur(nomJoueur, this));

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
        // choix
        saisieDestination(); //retourne un tableau des indices non choisies
        // les cartes qu'on ne veut pas sont remises sous la pile de cartes destination
        // pileDestination.add(pioche.remove(indice des cartes non choisies));
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
