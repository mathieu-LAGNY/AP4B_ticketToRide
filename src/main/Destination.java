package main;

public class Destination extends Carte {
    private UV UVA;
    private UV UVB;
    private int valeur;

    public Destination(UV UVA, UV UVB, int valeur) {
        this.UVA = UVA;
        this.UVB = UVB;
        this.valeur = valeur;
    }

    /**
     * @return la valeur en points de la carte
     */
    public int getValeur() {
        return valeur;
    }

    public boolean valide(Joueur joueur) {
        return joueur.UVpeuventEtreReliees(UVA,UVB,joueur.getRoutes());
    }

    @Override
    public String toString() {
        return UVA + "-" +
                UVB +
                " " + valeur;
    }
}
