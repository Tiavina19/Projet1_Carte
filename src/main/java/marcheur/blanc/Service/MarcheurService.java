package marcheur.blanc.Service;

import marcheur.blanc.Model.Lieu;
import marcheur.blanc.Model.Marche;
import marcheur.blanc.Model.Marcheur;

public class MarcheurService {

    public Marche faireMarcherAleatoirement(Lieu lieuDepart, Lieu lieuArrivee) {
        Marcheur marcheur = new Marcheur(lieuDepart);
        while (!marcheur.getPositionActuelle().equals(lieuArrivee)) {
            marcheur.avancerAleatoirementVers(lieuArrivee);
        }
        return marcheur.getMarcheEnCours();
    }
}
