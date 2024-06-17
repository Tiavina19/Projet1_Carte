package marcheur.blanc.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashSet;
import java.util.Set;

@Getter
@AllArgsConstructor
public class Lieu {
    private String nom;
    private Set<Rue> rues;

    public Lieu(String nom) {
        this.nom = nom;
        this.rues = new HashSet<>();
    }

    public void ajouterRue(Rue rue) {
        this.rues.add(rue);
    }
}