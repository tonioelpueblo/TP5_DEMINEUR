/*
 * TP_DEMINEUR
 * COURBI_BONNEAU
 * Mini projet, realisation d'un demineur fonctionnel
 * Classe grille
 */
package tp5_demineur_01;

import java.util.Random;

/**
 *
 * @author antoi
 */
public class Grille {

    //constructeur d'une grille qui donne les dimensions a la grille de cellules
    //en fonction de deux entiers d'entrée, qu'on utilisera dans le menu
    //en fonction du niveau choisit il y a plus ou moins de cellules...
    Cellule[][] Cellules;
    int ligne;
    int colonne;
    int Niveau;
    int NombreBombe;
    int NombreBombeAffiche;

    public Grille(int i, int j) {
        ligne = i;//ce constructeur permet de garder dans les variables ligne et
        //colonne la taille de notre grille, et permet de construire une grille
        //de cellulles de cette taille
        colonne = j;

        Cellules = new Cellule[ligne][colonne];//on cree notre grille

        for (int k = 0; k < ligne; k++) {//on la remplie de nouvelles cellules
            for (int l = 0; l < colonne; l++) {
                Cellules[k][l] = new Cellule();
            }
        }

    }

    public void ViderGrille() {

        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                //Tout devient null false ou zero
                Cellules[i][j].DrapeauCell = null;
                Cellules[i][j].Bombe = false;
                Cellules[i][j].Visible = false;
                Cellules[i][j].Contact = 0;
            }
        }

    }

    public String LireCouleurDrapeau(int i, int j) {
        return Cellules[i][j].LireCouleurDrapeau();
    }
    public boolean PlacerDrapeau(int i,int j,String coul){
        //Place un drapeau dans la cellule :
        return Cellules[i][j].PlacerDrapeau(coul);
    }
public void EnleverDrapeau(int i,int j){
    Cellules[i][j].EnleverDrapeau();
}
    public void NombreTotBombe() {
        switch (Niveau) {//en fonction du niveau j'ai un nombre de bombe :
            case 1:
                NombreBombe = 10;
                break;
            case 2:
                NombreBombe = 50;
                break;
            case 3:
                NombreBombe = 100;
                break;
            default:
                break;
        }
        NombreBombeAffiche = NombreBombe;
    }

    public void PlacerBombe() {

        //modifier
        Random r = new Random();
        for (int i = 0; i < NombreBombe; i++) {

            while (true) {//il faut que la celulle n'ai pas de bombe

                int ligne_Bombe = r.nextInt(ligne);//ligne colonne aleatoire
                int colonne_Bombe = r.nextInt(colonne);

                if (Cellules[ligne_Bombe][colonne_Bombe].PresenceBombe() == false) {

                    Cellules[ligne_Bombe][colonne_Bombe].Bombe = true;
                    break;//si on a reussi on sort du while on incremente
                    //le nombre de bombe et on continue
                }
            }

        }
    }

    public boolean RendreVisible(int i, int j) {
        //on va rendre la cellule visibles a moins qu'une bombe s'y cache au
        //quel cas la partie est perdue ...
        //On rend visible la cellule et on envoie vrai si tout va bien et faux
        //si on avait une bombe ... On renvoit pas juste faux sans rendre
        //visible pour pouvoir tout afficher a la fin ...

        if (Cellules[i][j].RendreVisible() == true) {
            if (Cellules[i][j].PresenceBombe() == true) {
                return false;
            }
            if (Cellules[i][j].Contact == 0) {
                EtendreSansContact(i, j);
                return true;
            }
        } else {//la cellule était visible ou il y a un bug ... 
            Cellules[i][j].RendreVisible();
            return true;
        }
        return true;
    }
public void EtendreSansContact(int i,int j){
    //Il nous faut une methode propre au demineur qui etend la zone ou il n'y a
    //pas de contact, par exemple si l'utilisateur choisit une case ou il n'y a
    //pas de contact la carte va rendrevisible toutes les cases sans contact 
    //qui y sont directement liees et les cases avec contact qui forment la
    //peripherie de cette zone ... 
    
    Cellules[i][j].Visible=true;
    //Huit directions possibles : 
    int a=i;
    int b=j;
    
    //1
    if(VerifPossible(a-1,b-1)==true){
        if(Cellules[a-1][b-1].Visible==false){
            if(Cellules[a-1][b-1].Contact==0){
            EtendreSansContact(a-1,b-1);
            }else{
                Cellules[a-1][b-1].RendreVisible();
            }
        }
    }
    
    
    //2
    if(VerifPossible(a-1,b)==true){
        if(Cellules[a-1][b].Visible==false){
            if(Cellules[a-1][b].Contact==0){
            EtendreSansContact(a-1,b);
            }else{
                Cellules[a-1][b].RendreVisible();
            }
        }
    }
    
    
    //3
    if(VerifPossible(a-1,b+1)==true){
        if(Cellules[a-1][b+1].Visible==false){
            if(Cellules[a-1][b+1].Contact==0){
        
            EtendreSansContact(a-1,b+1);
            }else{
                Cellules[a-1][b+1].RendreVisible();
            }
        }
    }
    
    
    
    //4
    if(VerifPossible(a,b-1)==true){
        if(Cellules[a][b-1].Visible==false){
            if(Cellules[a][b-1].Contact==0){
            EtendreSansContact(a,b-1);
            }else{
                Cellules[a][b-1].RendreVisible();
            }
            
        }
    }
    
    
    //5
    if(VerifPossible(a,b+1)==true){
        if(Cellules[a][b+1].Visible==false){
            if(Cellules[a][b+1].Contact==0){
            EtendreSansContact(a,b+1);
            }else{
                Cellules[a][b+1].RendreVisible();
            }
        }
    }
    
    
    //6
    if(VerifPossible(a+1,b-1)==true){
        if(Cellules[a+1][b-1].Visible==false){
            if(Cellules[a+1][b-1].Contact==0){
            EtendreSansContact(a+1,b-1);
            }else{
                Cellules[a+1][b-1].RendreVisible();
            }
        }
    }
    
    
    //7
    if(VerifPossible(a+1,b)==true){
        if(Cellules[a+1][b].Visible==false){
            if(Cellules[a+1][b].Contact==0){
            EtendreSansContact(a+1,b);
            }else{
                Cellules[a+1][b].RendreVisible();
            }
        }
    }
    
    
    //8
    if(VerifPossible(a+1,b+1)==true){
        if(Cellules[a+1][b+1].Visible==false){
            if(Cellules[a+1][b+1].Contact==0){
            EtendreSansContact(a+1,b+1);
            }else{
                Cellules[a+1][b+1].RendreVisible();
            }
        }
    }
    
}
public boolean VerifPossible(int a, int b){
    if((a<ligne)&&(a>=0)&&(b<colonne)&&(b>=0)){
        return true;
    }else{
        return false;
    }
}
    public void IncrementerContact(int i, int j) {//ajoute un contact
        Cellules[i][j].Contact++;//La cellule visee a un contact en plus
    }

    public void Autourbombe(int ligneBombe, int colonneBombe) {//incremente aux
        //alentours d'une
        //cellule
        for (int k = -1; k < 2; k++) {//k va de -1 a 1 en passant par 0 :
            for (int l = -1; l < 2; l++) {//l va de -1 a 1 en passant par 0 :
                //Pour ne pas depasser les bornes de la grille on fait :
                if ((ligneBombe + k < ligne) && (ligneBombe + k >= 0) && (colonneBombe + l < colonne) && (colonneBombe + l >= 0)) {

                    IncrementerContact(ligneBombe + k, colonneBombe + l);
                }
            }
        }

    }

    public void AffecterNombreContact() {//cette methode va parcourir les bombes
        //des qu'elle a une bombe elle regarde ses voisins distants de 1
        //et incremente leur nombre de contact de 1
        //a moins que ce voisin ne soit une bombe ...
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                if (Cellules[i][j].PresenceBombe() == true) {
                    Autourbombe(i, j);
                }
            }
        }
    }

    public boolean EtreGagnante() {
        //La grille est gagnante si les cases non decouverte sont les cases de
        //bombes : 
        for (int i = 0; i < ligne; i++) {
            for (int j = 0; j < colonne; j++) {
                if (Cellules[i][j].Visible == false) {
                    if (Cellules[i][j].Bombe == false) {
                        return false;
                    }
                }
            }
        }
        return true;//si apres avoir tout regarde je n'ai pas trouve de cellules
        //visible sans bombe la grille est gagnante ... 

    }

    public void AfficherGrille() {
        String LaLigne = "";
        for (int i = 0; i < ligne; i++) {
        for (int j = 0; j < colonne; j++) {
            
                LaLigne += "[" + Cellules[i][j].LireNombreContact() + "]";
            }
            System.out.println(LaLigne);
            LaLigne = "";
        }
    }
}
