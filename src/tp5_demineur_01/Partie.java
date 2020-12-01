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

    public void Init() {
        Scanner saisieUtilisateur = new Scanner(System.in);
        //On initialise le nom du joueur :
        System.out.println("Bonjour, quel est votre nom ?");
        String Nom = saisieUtilisateur.next();
        LeJoueur=new Joueur(Nom);
        
        //On initialise la grille avec le niveau et les elements (attributs) de
        //la grille : 
        System.out.println("\n"+LeJoueur.Nom+" veuillez choisir un niveau :\n1) Facile"
                + "\n2) Medium\n3) Difficile");
        int choix;
        while (true) {
            choix = saisieUtilisateur.nextInt();
            if ((choix != 1) && (choix != 2) && (choix != 3)) {

            } else {
                break;
            }
        }
        switch (choix) {//en fonction du niveau on cree la grille et on
            //initialise le niveau : 

            case 1:
                UneGrille = new Grille(10, 10);
                UneGrille.Niveau = 1;
                break;
            case 2:
                UneGrille = new Grille(20, 30);
                UneGrille.Niveau = 2;
                break;
            case 3:
                UneGrille = new Grille(30, 30);
                UneGrille.Niveau = 2;
                break;
            default:
                break;
        }

        UneGrille.NombreTotBombe();
        UneGrille.PlacerBombe();
        UneGrille.AffecterNombreContact();
        System.out.println(" ");
        UneGrille.AfficherGrille();
    }

    public void DebuterPartie() {
        //Debute la partie
        //Le joueur a le choix entre poser un drapeau (et choisir la couleur) et
        //creuser (rendre visible une case) en prenant le risque de tomber sur 
        //une bombe ... 
        //pour faire tourner le menu on utilise un indice "indice"
        boolean indice=true;
        while(indice){
        Scanner saisieUtilisateur = new Scanner(System.in);
        System.out.println("Vous souhaitez :"
                + "\n1) Poser un drapeau"
                + "\n2) Creuser"
                + "\n3) Quitter");
        int choix;
        while (true) {
            choix = saisieUtilisateur.nextInt();
            if ((choix != 1) && (choix != 2) && (choix != 3)) {

            } else {
                break;
            }
            
        }
        switch (choix) {//en fonction du niveau on cree la grille et on
            //initialise le niveau : 

            case 1:
                //Poser un drapeau
            String coul="rien";    
            while((coul!="r")&&(coul!="b")){
                System.out.println("Quelle drapeau voulez-vous poser ? (r,b)");
                coul = saisieUtilisateur.next();
            }    
            int ligneDrap=-1;
            int colonneDrap=-1;
            boolean ind=false;
            while(((ligneDrap<=0)||(ligneDrap>UneGrille.ligne)||(colonneDrap<=0)||(colonneDrap>UneGrille.colonne))&&(ind==false)){
                System.out.println("Ligne");
            ligneDrap = saisieUtilisateur.nextInt();
            System.out.println("Colonne");
            colonneDrap = saisieUtilisateur.nextInt();
            ind=UneGrille.PlacerDrapeau(ligneDrap,colonneDrap,coul);
            }
            
            
            

        
                break;
            case 2:
                //Creuser
                System.out.println("Ligne");
            int ligne = saisieUtilisateur.nextInt();
            System.out.println("Colonne");
            int colonne = saisieUtilisateur.nextInt();

            UneGrille.RendreVisible(ligne, colonne);
            System.out.println(" ");
            UneGrille.AfficherGrille();
                break;
            case 3:
                //quitter
                indice=false;
                break;
            default:
                break;
        }
        
        
    }
    }
}
