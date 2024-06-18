package marcheur.blanc.Service;

import marcheur.blanc.Model.Lieu;
import marcheur.blanc.Model.Marche;
import marcheur.blanc.Model.Marcheur;

public class MarcheurService {

    public Marche faireMarcherAleatoirement(Lieu lieuDepart, Lieu lieuArrivee) {
        Marcheur marcheur = new Marcheur(lieuDepart);
        int limitePas = 100;

        while (!marcheur.getPositionActuelle().equals(lieuArrivee)) {
            if (limitePas-- <= 0) {
                throw new RuntimeException("Limite de pas atteinte, le lieu d'arrivée peut être inaccessible");
            }
            marcheur.avancerAleatoirementVers(lieuArrivee);
        }
        return marcheur.getMarcheEnCours();
    }
}
