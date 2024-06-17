package marcheur.blanc;

import marcheur.blanc.Model.*;
import marcheur.blanc.Service.*;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Carte carteAntananarivo = initialiserCarteAntananarivo();
        MarcheurService marcheurService = new MarcheurService(carteAntananarivo);

        Lieu lieuHEI = new Lieu("HEI");
        Lieu lieuESTI = new Lieu("ESTI");
        Marcheur bjarni = new Marcheur("Bjarni", lieuHEI);

        int nombreMarches = 5;
        System.out.println("Simuler " + nombreMarches + " marches aléatoires de " + lieuHEI.getNom() + " à " + lieuESTI.getNom() + ":");

        for (int i = 1; i <= nombreMarches; i++) {
            System.out.println("Marche aléatoire #" + i + ":");
            try {
                Marche marcheVersESTI = marcheurService.marcherVersDestination(bjarni, lieuESTI);
                List<Lieu> parcours = marcheVersESTI.getParcours();
                for (int j = 0; j < parcours.size() - 1; j++) {
                    System.out.print(parcours.get(j).getNom() + " -> ");
                }
                System.out.println(parcours.get(parcours.size() - 1).getNom());
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
            System.out.println();
        }
    }

    private static Carte initialiserCarteAntananarivo() {
        Carte carte = new Carte();

        Lieu lieuHEI = new Lieu("HEI");
        Lieu lieuPullman = new Lieu("Pullman");
        Lieu lieuBalançoire = new Lieu("Balançoire");
        Lieu lieuESTI = new Lieu("ESTI");

        Rue rueHEI_Pullman = new Rue(lieuHEI, lieuPullman, "Rue Andriatsihoarana");
        Rue ruePullman_Balançoire = new Rue(lieuPullman, lieuBalançoire, "Rue Ranaivo");
        Rue rueBalançoire_ESTI = new Rue(lieuBalançoire, lieuESTI, "");

        carte.ajouterRue(rueHEI_Pullman);
        carte.ajouterRue(ruePullman_Balançoire);
        carte.ajouterRue(rueBalançoire_ESTI);

        return carte;
    }
}
