package marcheur.blanc.Model;

import lombok.Getter;


@Getter
public class Rue {
    private String nom;
    private Lieu lieu1;
    private Lieu lieu2;

    public Rue(String nom, Lieu lieu1, Lieu lieu2) {
        this.nom = nom;
        this.lieu1 = lieu1;
        this.lieu2 = lieu2;
    }
}

