/*
 * TP_DEMINEUR
 * COURBI_BONNEAU
 * Mini projet, realisation d'un demineur fonctionnel
 * Classe partie
 */
package tp5_demineur_01;

import java.util.Scanner;

/**
 *
 * @author antoi
 */
public class Partie {
    Joueur LeJoueur;
    Grille UneGrille;
    public void Init(){
        
         UneGrille=new Grille(10,10);
         UneGrille.Niveau=1;
         UneGrille.NombreTotBombe();
         UneGrille.PlacerBombe();
         UneGrille.AffecterNombreContact();
         System.out.println(" ");
         UneGrille.AfficherGrille();
    }
    public void DebuterPartie(){
        //Debute la partie
        Scanner saisieUtilisateur = new Scanner(System.in);
        while (true){
            System.out.println("Ligne");
            int ligne = saisieUtilisateur.nextInt();
            System.out.println("Colonne");
            int colonne = saisieUtilisateur.nextInt();
            
            UneGrille.RendreVisible(ligne,colonne);
         System.out.println(" ");
         UneGrille.AfficherGrille();
        
        }
    }
}
