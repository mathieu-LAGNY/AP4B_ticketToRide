package main;

public class UV {
    private String nom;
    private Boolean printemps;
    private Boolean automne;

    // on pourra eventuellement creer un Enum pour la categorie d'UV (EC,OOM,QC,TM,CS,ST)

    public UV(String nom) {
        this.nom = nom;
    }

    public UV(String nom, Boolean printemps, Boolean automne) {
        this(nom);
        this.printemps = printemps;
        this.automne = automne;
    }

    @Override
    public String toString() {
        return nom.toString();
    }
}
