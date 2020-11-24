/*
 * TP_DEMINEUR
 * COURBI_BONNEAU
 * Mini projet, realisation d'un demineur fonctionnel
 * Classe drapeau
 */
package tp5_demineur_01;

/**
 *
 * @author antoi
 */
public class Drapeau {
    String Couleur;
    
    public Drapeau(String couleur){
        //Constructeur du drapeau
        Couleur=couleur;
    }
    public String LireCouleur(){
        return Couleur;
    }
}
