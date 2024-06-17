package marcheur.blanc.Model;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Marche {
    private Lieu lieuDepart;
    private List<Lieu> parcours;

    public Marche(Lieu lieuDepart) {
        this.lieuDepart = lieuDepart;
        this.parcours = new ArrayList<>();
        parcours.add(lieuDepart);
    }

    public void ajouterLieu(Lieu lieu) {
        parcours.add(lieu);
    }
}