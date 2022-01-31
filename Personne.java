/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
import java.util.Random;
import java.util.List;
/**
 *
 * @author clerb
 */
public class Personne {
    
    protected String nom;
    protected String prenom;
    protected String dateNaissance; //Le format de la date de Naissance est un String de la forme suivante = "P1999Y5M12D";
    //protected String lieuNaissance;
    //String nationalite;
    //int taille;
    //int poids;
    
    /** Personne constructor, it is not possible
     * to create a personne without
     * @param nom nom de la personne
     * @param prenom prenom de la personne 
     * @param dateNaissance date de naissance de la personne 
     */    
    public Personne(String nom, String prenom, String dateNaissance){
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;

        
       // introduceYourself(); utile que au tout début
       //crieAge();
    }
    
    
    
    /**
    *Récupérer une date de naissance aléatoire
    * année aléatoire entre 1980(inclus) et 2002(exclus)
    * mois aléatoire
    * jour aléatoire entre 1 et 29 (exclus)
    * @return un String correspondant à la date de naissance aléatoire sous la forme pAnnéeyMoismJourd
    */
    public static String dateNaissance(){
        Random rand = new Random();
        //année aléatoire entre 1980(inclus) et 2002(exclus)
        int lowAn = 1980;
        int highAn = 2002;
        int randAn= rand.nextInt(highAn-lowAn)+lowAn;
        //mois aléatoire 
        int lowMois = 1;
        int highMois = 13;
        int randMois= rand.nextInt(highMois-lowMois)+lowMois;
        //jour aléatoire
        int lowJour = 1;
        int highJour = 29;
        int randJour= rand.nextInt(highJour-lowJour)+lowJour;
        String age="p";
        age =age + randAn + "y" + randMois + "m" + randJour + "d";
        return age;
    }
    
    
    /**
     * Récupérer un prénom aléatoire dans la liste de prénoms
     * @param liste_prenom liste de prenom
     * @return prenom
     */
    public static String prenom(List<String> liste_prenom){
        Random rand = new Random();
        //création automatique d'un joueur
        int prenom_alea=rand.nextInt(liste_prenom.size());
        return liste_prenom.get(prenom_alea);
    }

    /**
     * Recuperer un nom dans une liste dans l'ordre
     * @param liste_nom liste de noms
     * @param compteur_liste_nom compteur
     * @return nom
     */
    public static String nom(List<String> liste_nom,int compteur_liste_nom){
        
        return liste_nom.get(compteur_liste_nom);
    }
    

    /**
     * Accéder au nom de la personne
     * @return nom de la personne
     */
    public String getNom() {
        return nom;
    }
    /**
     * Accéder au prenom de la personne
     * @return prenom de la personne
     */
    public String getPrenom() {
        return prenom;
    }

    /**
    * Accéder à la date de naissance de la personne
    * @return date de naissance de la personne
    */
    public String getDateNaissance() {
        return dateNaissance;
    }

    

    

    
    
}
