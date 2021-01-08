package main;

import java.util.Objects;

public class UV {
    private String nom;

    // on pourra eventuellement creer un Enum pour la categorie d'UV (EC,OOM,QC,TM,CS,ST)

    public UV(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return nom.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UV uv = (UV) o;
        return nom.equals(uv.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }
}
