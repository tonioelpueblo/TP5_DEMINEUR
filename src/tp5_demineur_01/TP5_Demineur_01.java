/*
 * TP_DEMINEUR
 * COURBI_BONNEAU
 * Mini projet, realisation d'un demineur fonctionnel
 */
package tp5_demineur_01;

/**
 *
 * @author antoi
 */
public class TP5_Demineur_01 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         Grille UneGrille;
         UneGrille=new Grille(10,10);
         UneGrille.Niveau=1;
         UneGrille.NombreTotBombe();
         UneGrille.PlacerBombe();
         UneGrille.AffecterNombreContact();
         System.out.println(" ");
         UneGrille.AfficherGrille();
         
         
         UneGrille.RendreVisible(0,1);
         System.out.println(" ");
         UneGrille.AfficherGrille();
    }
    
}
