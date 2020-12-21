package main;

import java.awt.*;
import java.util.ArrayList;

public class Joueur {
    private String nomJoueur;
    private Color couleur;
    private int wagon;
    private int score;
    private Plateau plateau;

    private ArrayList<Destination> mainDest;
    private ArrayList<Wagon> mainWagon;

    /**
     * /!\ Ajouter le système pour les couleurs
     * Constructeur
     *
     * @param nomJoueur le nom du joueur
     * @param plateau   le plateau de la partie en cours
     */
    public Joueur(String nomJoueur, Plateau plateau) {
        this.nomJoueur = nomJoueur;
        this.plateau = plateau;
        this.couleur = null;
        this.wagon = 45;
        this.score = 0;
        mainWagon = this.plateau.piocherWagon(4);
        mainDest = this.plateau.choisirDest(2);
    }

    /**
     * /!\ Ne vérifie pas que les villes sont reliées
     * Fait le total des cartes destinations pour chaque joueur
     */
    public int totalDestJoueurs() {
        int total = 0;
        for (Destination dest: mainDest) {
            total += dest.getValeur();
        }
        return total;
    }
    
        /**
     * /!\ La fonction comptage des points  
     *     elle prend en paramtre le joueur concerné et la route qu'il souhaite occupé 
     *     compare le nombre de wogon à la longueur de la route 
     *  */
    public void comptageDesPoints(Route r) {
    	int longueurRoute = this.longueur;
    	ArrayList<Integer> Liste = new ArrayList<>();
    	Liste.add(0);
    	Liste.add(1);
    	Liste.add(2);
    	Liste.add(4);
    	Liste.add(7);
    	Liste.add(10);
    	Liste.add(15);{
    		if (Liste.contains(longueurRoute)) {
    		this.score +=Liste.get(longueurRoute)	
                this.wagon -= this.longueur
    	    }
    }


    /**
     * Exécute le tour d'un joueur
     *
     * Cette méthode exécute successivement les 3 phases du tour d'un joueur:
     *
     * 1. (Pioche) Effectuer un choix pour piocher des cartes
     *
     * 2. (Destinations) Facultatif : prendre de 1 à 3 cartes destination parmi 3
     *
     * 3. (Route) Le joueur choisit de prendre le contrôle d'une voie s'il a les
     * bonnes cartes wagon en main. Les points correspondant à la longeueur de la voie
     * sont ajoutés à son score. Le nombre de pion Wagon correspondant est decremente de
     * son compteur wagon.
     *
     * Et le joueur à terminé son tour
     */
    public void playTurn() {
        // 1. (Pioche)
        // 2. (Destinations)
        // 3. (Route)
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
        return null;
    }
}
