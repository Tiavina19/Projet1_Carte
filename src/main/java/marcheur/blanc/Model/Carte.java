package marcheur.blanc.Model;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class Carte {
    private Map<String, Lieu> lieux;
    private Map<String, Rue> rues;

    public Carte() {
        this.lieux = new HashMap<>();
        this.rues = new HashMap<>();
    }

    public void ajouterLieu(Lieu lieu) {
        lieux.put(lieu.getNom(), lieu);
    }

    public void ajouterRue(String nomLieu1, String nomLieu2, String nomRue) {
        Lieu lieu1 = lieux.computeIfAbsent(nomLieu1, Lieu::new);
        Lieu lieu2 = lieux.computeIfAbsent(nomLieu2, Lieu::new);
        Rue rue = new Rue(nomRue, lieu1, lieu2);
        rues.put(nomRue, rue);
        lieu1.ajouterRue(rue);
        lieu2.ajouterRue(rue);
    }

    public Lieu getLieu(String nom) {
        return lieux.get(nom);
    }
}
