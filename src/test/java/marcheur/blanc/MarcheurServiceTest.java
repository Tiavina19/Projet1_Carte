package marcheur.blanc;
import marcheur.blanc.Model.*;
import marcheur.blanc.Service.MarcheurService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;


public class MarcheurServiceTest {
        private Carte carte;

        @BeforeEach
        public void setUp() {
            carte = preparerCarte();
        }

        @Test
        public void testLaMarcheDoitCommencerABoulevardDeLEurope() {
            MarcheurService marcheurService = new MarcheurService();
            Lieu boulevardEurope = carte.getLieu("Boulevard de l'Europe");
            Lieu nexta = carte.getLieu("Nexta");
            Marche marche = marcheurService.faireMarcherAleatoirement(boulevardEurope, nexta);

            Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

            Lieu premierLieu = marche.getParcours().get(0);
            Assertions.assertEquals("Boulevard de l'Europe", premierLieu.getNom(), "La marche doit commencer à Boulevard de l'Europe");
        }

        @Test
        public void testLaMarcheDoitSeTerminerANexta() {
            MarcheurService marcheurService = new MarcheurService();
            Lieu boulevardEurope = carte.getLieu("Boulevard de l'Europe");
            Lieu nexta = carte.getLieu("Nexta");
            Marche marche = marcheurService.faireMarcherAleatoirement(boulevardEurope, nexta);

            Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

            Lieu dernierLieu = marche.getParcours().get(marche.getParcours().size() - 1);
            Assertions.assertEquals("Nexta", dernierLieu.getNom(), "La marche doit se terminer à Nexta");
        }

        @Test
        public void testLaMarcheDoitCommencerAHEI() {
            MarcheurService marcheurService = new MarcheurService();
            Lieu hei = carte.getLieu("HEI");
            Lieu esti = carte.getLieu("ESTI");
            Marche marche = marcheurService.faireMarcherAleatoirement(hei, esti);

            Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

            Lieu premierLieu = marche.getParcours().get(0);
            Assertions.assertEquals("HEI", premierLieu.getNom(), "La marche doit commencer à HEI");
        }

        @Test
        public void testLaMarcheDoitSeTerminerAESTI() {
            MarcheurService marcheurService = new MarcheurService();
            Lieu hei = carte.getLieu("HEI");
            Lieu esti = carte.getLieu("ESTI");
            Marche marche = marcheurService.faireMarcherAleatoirement(hei, esti);

            Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

            Lieu dernierLieu = marche.getParcours().get(marche.getParcours().size() - 1);
            Assertions.assertEquals("ESTI", dernierLieu.getNom(), "La marche doit se terminer à ESTI");
        }

        @Test
        public void testAffichageTousLesLieuxDeHEIAESTI() {
            MarcheurService marcheurService = new MarcheurService();
            Lieu hei = carte.getLieu("HEI");
            Lieu esti = carte.getLieu("ESTI");
            Marche marche = marcheurService.faireMarcherAleatoirement(hei, esti);

            Assertions.assertFalse(marche.getParcours().isEmpty(), "La marche ne doit pas être vide");

            List<Lieu> parcours = marche.getParcours();
            System.out.println("Parcours de HEI à ESTI:");
            for (Lieu lieu : parcours) {
                System.out.println(lieu.getNom());
            }
        }

        private Carte preparerCarte() {
            Carte carte = new Carte();

            Lieu marais = new Lieu("Marais");
            Lieu sekolintsika = new Lieu("Sekolintsika");
            Lieu hei = new Lieu("HEI");
            Lieu balancoire = new Lieu("Balancoire");
            Lieu esti = new Lieu("ESTI");
            Lieu boulevardEurope = new Lieu("Boulevard de l'Europe");
            Lieu pullman = new Lieu("Pullman");
            Lieu nexta = new Lieu("Nexta");

            carte.ajouterLieu(marais);
            carte.ajouterLieu(sekolintsika);
            carte.ajouterLieu(hei);
            carte.ajouterLieu(balancoire);
            carte.ajouterLieu(esti);
            carte.ajouterLieu(boulevardEurope);
            carte.ajouterLieu(pullman);
            carte.ajouterLieu(nexta);

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

