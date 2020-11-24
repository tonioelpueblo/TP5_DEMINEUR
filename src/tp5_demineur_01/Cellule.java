/*
 * TP_DEMINEUR
 * COURBI_BONNEAU
 * Mini projet, realisation d'un demineur fonctionnel
 * Classe cellule
 */
package tp5_demineur_01;

/**
 *
 * @author antoi
 */
public class Cellule {
    Boolean Bombe;
    int Contact;
    
    public Cellule(){
        //Constructeur d'une cellule qui initialise par defaut pas de bombe
        //et zero contact :
        Bombe=null;
        Contact=0;
    }
}
