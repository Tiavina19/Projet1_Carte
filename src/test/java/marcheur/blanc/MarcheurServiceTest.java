package marcheur.blanc;

import marcheur.blanc.Model.*;
import marcheur.blanc.Service.MarcheurService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class MarcheurServiceTest {
    private Carte carte;
    private MarcheurService marcheurService;

    @BeforeEach
    public void setUp() {
        carte = preparerCarte();
        marcheurService = new MarcheurService();
    }

    @Test
    public void testLaMarcheDoitCommencerEtSeTerminerCorrectement() {
        verifierMarche("Boulevard de l'Europe", "Nexta");
        verifierMarche("HEI", "ESTI");
        verifierMarche("Marais", "ESTI");
        verifierMarche("Nexta", "ESTI");
        verifierMarche("Sekolintsika", "ESTI");
        verifierMarche("Boulevard de l'Europe", "ESTI");
    }

    @Test
    public void testAffichageTousLesLieuxDeHEIAESTI() {
        Lieu hei = carte.getLieu("HEI");
        Lieu esti = carte.getLieu("ESTI");
        Marche marche = marcheurService.faireMarcherAleatoirement(hei, esti);

        Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

        List<Lieu> parcours = marche.getParcours();
        System.out.println("Le chemin à mener vers ESTI est:");
        for (Lieu lieu : parcours) {
            System.out.println(lieu.getNom());
        }
    }

    private void verifierMarche(String nomLieuDepart, String nomLieuArrivee) {
        Lieu lieuDepart = carte.getLieu(nomLieuDepart);
        Lieu lieuArrivee = carte.getLieu(nomLieuArrivee);
        Marche marche = marcheurService.faireMarcherAleatoirement(lieuDepart, lieuArrivee);

        Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

        Lieu premierLieu = marche.getParcours().get(0);
        Lieu dernierLieu = marche.getParcours().get(marche.getParcours().size() - 1);

        Assertions.assertEquals(nomLieuDepart, premierLieu.getNom(), "La marche doit commencer à " + nomLieuDepart);
        Assertions.assertEquals(nomLieuArrivee, dernierLieu.getNom(), "La marche doit se terminer à " + nomLieuArrivee);
    }

    private Carte preparerCarte() {
        Carte carte = new Carte();

        Lieu marais = new Lieu("Marais");
        Lieu sekolintsika = new Lieu("Sekolintsika");
        Lieu hei = new Lieu("HEI");
        Lieu pullman = new Lieu("Pullman");
        Lieu nexta = new Lieu("Nexta");
        Lieu balancoire = new Lieu("Balancoire");
        Lieu boulevardEurope = new Lieu("Boulevard de l'Europe");
        Lieu esti = new Lieu("ESTI");

        carte.ajouterLieu(marais);
        carte.ajouterLieu(sekolintsika);
        carte.ajouterLieu(hei);
        carte.ajouterLieu(pullman);
        carte.ajouterLieu(nexta);
        carte.ajouterLieu(balancoire);
        carte.ajouterLieu(boulevardEurope);
        carte.ajouterLieu(esti);

        carte.ajouterRue("Marais", "Sekolintsika", "Rue1");
        carte.ajouterRue("Sekolintsika", "HEI", "Rue2");
        carte.ajouterRue("HEI", "Balancoire", "Rue3");
        carte.ajouterRue("HEI", "Pullman", "Rue4");
        carte.ajouterRue("Balancoire", "ESTI", "Rue5");
        carte.ajouterRue("Balancoire", "Boulevard de l'Europe", "Rue6");
        carte.ajouterRue("Boulevard de l'Europe", "ESTI", "Rue7");
        carte.ajouterRue("Pullman", "Nexta", "Rue8");

        return carte;
    }
}
