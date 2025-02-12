package main;

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class Joueur {
    private String nomJoueur;
    private Color couleur;
    private int pionWagon;
    private int score;
    private Plateau plateau;

    private ArrayList<Route> routes;
    private ArrayList<Destination> mainDest;
    private ArrayList<Wagon> mainWagon;

    /**
     * /!\ Ajouter le système pour les couleurs
     * Constructeur
     *
     * @param nomJoueur le nom du joueur
     * @param plateau   le plateau de la partie en cours
     */
    public Joueur(String nomJoueur, Plateau plateau, Color couleur) throws IOException {
        this.nomJoueur = nomJoueur;
        this.plateau = plateau;
        this.couleur = null;
        this.pionWagon = 45;
        this.score = 0;
        mainWagon = this.plateau.piocherWagon(4);
        mainDest = this.plateau.choisirDest(2);
        routes = new ArrayList<Route>();
    }

    public int getScore() {
        return score;
    }

    public String getNomJoueur() {
        return nomJoueur;
    }

    public void addWagon(Wagon wagon) {
        this.mainWagon.add(wagon);
    }

    public ArrayList<Route> getRoutes() {
        ArrayList<Route> copie = new ArrayList<>();

        for (Route route : this.routes) {
            copie.add(new Route(route));
        }
        return copie;
    }

    /**
     * Vérifie que les villes sont reliées
     * si c'est le cas on ajoute les points, sinon on les soustraits
     * Fait le total des cartes destinations pour chaque joueur et l'ajoute à son score
     */
    public void totalDestJoueur() {
        for (Destination dest: mainDest) {
            if (dest.valide(this))
                this.score += dest.getValeur();
            else
                this.score -= dest.getValeur();
        }
    }

    /**
     * Verfie si une route est achetable par le joueur avec ses cartes wagon actuelles
     * @param route a tester
     * @return true si la route peut être achetée
     */
    public boolean routeAchetable(Route route) {
        int nbWagon = 0;
        Color routeCouleur = route.getRouteCouleur();
        for (Wagon wagon: mainWagon) {
            if (wagon.getCouleur().equals(routeCouleur) || wagon.getCouleur().equals(Color.GRAY)) {
                nbWagon++;
            }
        }
        return route.getLongueur() <= nbWagon;
    }
    
    /**
     * Fonction qui correspond à l'ajout d'une route valide
     * Enlève de ses cartes Wagon le coût correspondant
     * Ajoute les points correspondant à la longueur de la route au score du joueur,
     * décrémente le nombre de pion wagon de la longueur de la route et
     * ajoute la route à la liste de routes du joueur
     * @param route acquise par le joueur
     *  */
    public void ajouteRoute(Route route) {
    	int longueurRoute = route.getLongueur();
    	int nbWagon = route.getLongueur();
    	Color routeCouleur = route.getRouteCouleur();
        int i=0;
        // On enlève autant de carte de la couleur que possible
        while (nbWagon > 0 || i < mainWagon.size()) {
            if (mainWagon.get(i).getCouleur().equals(routeCouleur)) {
                nbWagon--;
                mainWagon.remove(i);
            } else {
                i++;
            }
        }
        // S'il n'y en a pas assez on complète avec des locomotives
        i = 0;
        while (nbWagon > 0 || i < mainWagon.size()) {
            if (mainWagon.get(i).getCouleur().equals(Color.GRAY)) {
                nbWagon--;
                mainWagon.remove(i);
            } else {
                i++;
            }
        }
    	ArrayList<Integer> liste = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 7, 10, 15));
        if (longueurRoute < liste.size()) { // facultatif on part du principe que la route est créée de la bonne taille
            this.score += liste.get(longueurRoute);
            this.pionWagon -= longueurRoute;
            this.routes.add(route);
        }
    }


    /**
     * Exécute le tour d'un joueur
     *
     * Cette méthode exécute une des trois actions possible pour un tour
     *
     * 1. (Pioche) Effectuer un choix pour piocher des cartes
     *
     * 2. (Destinations) Prendre de 1 à 3 cartes destination parmi 3
     *
     * 3. (Route) Le joueur choisit de prendre le contrôle d'une voie s'il a les
     * bonnes cartes wagon en main.
     *
     * Et le joueur a terminé son tour
     */
    public void playTurn() throws Exception {
        // choix prend la valeur 0 dans le cas où le joueur s'est trompé dans ses actions
        // par exemple s'il annonce acheter une route sans avoir les cartes wagon nécessaires

        int choix = 0;
        while (choix == 0) {
            String stringTour = String.format("Tour de %s :\n[1] Pioche wagon deck/visible\n[2] Destinations\n[3] Routes", this.nomJoueur);
            System.out.println(stringTour);
            InputStreamReader streamReader = new InputStreamReader(System.in);
            BufferedReader bufferedReader = new BufferedReader(streamReader);
            choix = Integer.parseInt(bufferedReader.readLine());
            // choix de l'action réalisée (1, 2 ou 3)
            // 1. (Pioche)
            if (choix == 1) {
                mainWagon.addAll(plateau.choisirWagon());
            }
            // 2. (Destinations)
            if (choix == 2) {
                mainDest.addAll(plateau.choisirDest(1));
            }
            // 3. (Route)
            if (choix == 3) {
                Route route = plateau.choisirRoute();
                if (route == null) {
                    choix = 0; // la route n'était pas valide
                } else {
                    ajouteRoute(route);
                }
            }
        }
    }

    /**
     * teste si les deux UV peuvent être reliées en utilisant les routes de la liste
     */
    public boolean UVpeuventEtreReliees(UV a, UV b, ArrayList<Route> routesJoueur){
        if(routesJoueur.isEmpty())
            return false;

        // normalement ce cas ne devraient pas être atteint
        // cependant on le laisse au cas où
        if (a.equals(b))
            return true;

        ArrayList<Route> routesLiees = getRoutesUV(a, routesJoueur);
        ArrayList<Route> routesRestantes = new ArrayList<>();
        for (Route route: routesJoueur) {
            if (!routesLiees.contains(route))
                // ce n'est pas grave si l'on utilise la même route dans toutes les listes
                routesRestantes.add(route);
        }
        for (Route route: routesLiees) {
            UV autreUV;
            if (route.getUVA().equals(a))
                autreUV = route.getUVB();
            else
                autreUV = route.getUVA();
            if (autreUV.equals(b))
                return true;
            else
                return UVpeuventEtreReliees(autreUV,b,routesRestantes);
        }
        // normalement ce cas ne devraient pas être atteint
        // cependant on le laisse pour faciliter le debug avec l'IDE
        return false;
    }

    /**
     * Retourne les routes de la liste qui sont reliées à l'uv
     */
    private ArrayList<Route> getRoutesUV(UV uv, ArrayList<Route> routes){
        ArrayList<Route> tmp = new ArrayList<>();
        for(Route route : routes)
            if(route.getUVA().equals(uv) || route.getUVB().equals(uv))
                tmp.add(route);
        return tmp;
    }
    /**
     * Teste si le joueur à moins de 3 pions wagon pour savoir s'il ne reste plus qu'un tour
     * @@return true s'il ne reste plus assez de pions wagons
     */
    public boolean plusDeWagon() {
        return pionWagon<3;
    }

    /**
     * Renvoie une représentation des informations du joueur sous la forme d'une
     * chaine de caracteres
     *
     * Cette représentation comporte
     * - la liste de ses routes
     * - la liste de ses cartes destinations
     * - la liste de ses cartes wagon
     *
     * On pourrait par exemple avoir l'affichage suivant:
     *
     * Mes routes   Mes destinations   Mes wagons
     * SY40-AP4A    SY40-RN41 10pts    2xLocomotives
     * AP4A-RN41                       3xJaune
     *                                 4xNoir
     */
    @Override
    public String toString() {
        String texte = "Joueur : " + this.nomJoueur + " (" + this.couleur + ")\n";
        texte += this.pionWagon + " pions wagon, " + this.score + " points\n";
        texte += "\nMes routes\n";
        for (Route route: routes) texte += route + "\n";
        texte += "\nMes cartes destination\n";
        for (Destination destination: mainDest) texte += destination + "\n";
        texte += "\nMes cartes wagon\n";
        ArrayList<Wagon> wagons = new ArrayList<>();
        ArrayList<Integer> nbWagons = new ArrayList<>();
        for (Wagon wagon: mainWagon) {
            if (!wagons.contains(wagon)) {
                wagons.add(wagon);
                nbWagons.add(1);
            } else {
                nbWagons.set(wagons.indexOf(wagon),nbWagons.get(wagons.indexOf(wagon))+1);
            }
        }
        for (int i = 0; i < wagons.size(); i++) {
            texte += wagons.get(i) + " x" + nbWagons.get(i);
        }
        return texte;
    }
}
