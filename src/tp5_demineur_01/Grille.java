/*
 * TP_DEMINEUR
 * COURBI_BONNEAU
 * Mini projet, realisation d'un demineur fonctionnel
 * Classe grille
 */
package tp5_demineur_01;

/**
 *
 * @author antoi
 */
public class Grille {
    //constructeur d'une grille qui donne les dimensions a la grille de cellules
    //en fonction de deux entiers d'entrée, qu'on utilisera dans le menu
    //en fonction du niveau choisit il y a plus ou moins de cellules... 
    Cellule[][] Cellules;
    public Grille(int i, int j){
    Cellules= new Cellule[i][j];
    }
}
