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
    
    Boolean Visible;
    //Si la cellule est cachée Visible=false
    //Ce boolean permet de savoir si on peut poser un drapeau, a afficher les 
    //numeros... 
    int Contact;
    Drapeau DrapeauCell;
    
    public Cellule(){
        //Constructeur d'une cellule qui initialise par defaut pas de bombe
        //et zero contact et cellule cachee et pas de drapeau :
        DrapeauCell=null;
        Bombe=false;
        Visible=false;
        Contact=0;
    }
    
    public boolean AffecterDrapeau(Drapeau NouveauDrapeau){
        if(PresenceDrapeau()==false){//si il n'y a pas de drapeau on peut l'
            //affecter : 
            DrapeauCell=NouveauDrapeau;
            return true;
        }else{//sinon je renvoie faux
            return false;
        }
    }
    public String LireCouleurDrapeau(){
        if(PresenceDrapeau()==true){
            return DrapeauCell.LireCouleur();//Si il y a un drapeau, renvoie
            //couleur
        }
        else{
            return "null";//si pas de drapeau 
        }
    }
    public boolean PresenceDrapeau(){
        if(DrapeauCell==null){//si je n'ai pas de drapeau je renvoie vrai
            return true;
        }else{//sinon je renvoie faux
            return false;
        }
    }
    public boolean PlacerBombe(){//Pose une bombe  (//aleatoire)
        if(PresenceBombe()==false){//Si pas de bombe on l'active
            Bombe=true;
            return true;//Si ca s'est bien passé on renvoie vrai
            
        }else{
            return false;//sion on renvoie false
        }
    }
    public boolean PresenceBombe(){
        if(Bombe==null){//Renvoie vrai si presence de bombe
            return false;
        }else{
            return true;
        }
    }
    public boolean RendreVisible(){
        if(Visible==false){//si je suis caché
            Visible=true;//je deviens visible
            return true;//tout s'est bien passé
        }else{//sinon ca s'est mal passé, on renvoie false
            return false;
        }
    }
    public void AffecterNombreContact(int NbreContact){
        Contact=NbreContact;//Mon nombre de contact de la cellule change
    }
    public int LireNombreContact(){
        return Contact;//renvoie le nombre de contact
    }
}
