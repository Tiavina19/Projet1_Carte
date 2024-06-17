package marcheur.blanc.Model;

import java.util.*;

public class Marcheur {
    private Lieu positionActuelle;
    private Marche marcheEnCours;
    private Set<Lieu> lieuxVisites;

    public Marcheur(Lieu positionActuelle) {
        this.positionActuelle = positionActuelle;
        this.marcheEnCours = new Marche(positionActuelle);
        this.lieuxVisites = new HashSet<>();
        this.lieuxVisites.add(positionActuelle);
    }

    public Lieu getPositionActuelle() {
        return positionActuelle;
    }

    public Marche getMarcheEnCours() {
        return marcheEnCours;
    }

    public void avancerVers(Lieu lieu) {
        positionActuelle = lieu;
        marcheEnCours.ajouterLieu(lieu);
        lieuxVisites.add(lieu);
    }

    public void avancerAleatoirementVers(Lieu destination) {
        List<Rue> ruesPossibles = new ArrayList<>(positionActuelle.getRues());
        Collections.shuffle(ruesPossibles);

        for (Rue rue : ruesPossibles) {
            Lieu voisin = rue.getLieu1().equals(positionActuelle) ? rue.getLieu2() : rue.getLieu1();
            if (!lieuxVisites.contains(voisin) || voisin.equals(destination)) {
                avancerVers(voisin);
                return;
            }
        }
        if (!ruesPossibles.isEmpty()) {
            Rue rue = ruesPossibles.get(0);
            Lieu voisin = rue.getLieu1().equals(positionActuelle) ? rue.getLieu2() : rue.getLieu1();
            avancerVers(voisin);
        }
    }
}

