/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
import java.util.Random;
/**
 *
 * @author clerb
 */
public class Boxeur extends Personne implements Introduce {
    private int poids;
    private String surnom;
    private String main;
    private int classement;
    private int solidite;
    private int endurance;
    private int vitesse;
    private int force;
    public int victoire;
    public int defaite;
    public int attaque;
    public int encaisse;
    
    /**
     * Constructeur Boxeur, impossible à créer sans les paramètres
     * @param nom nom du boxeur
     * @param prenom prenom du boxeur
     * @param dateNaissance date de naissance du boxeur
     * @param poids poids du boxeur
     * @param surnom surnom du boxeur
     * @param main main dominante du boxeur
     * @param classement classement du boxeur
     * @param solidite solidite du boxeur
     * @param endurance endurance du boxeur
     * @param vitesse vitesse du boxeur
     * @param force force du boxeur
     * @param victoire nombre de victoires du boxeur
     * @param defaite nombre de défaites du boxeur
     * @param attaque nombre d'attaques du boxeur
     * @param encaisse nombre de coups encaissés du boxeur
     */
    public Boxeur (String nom, String prenom, String dateNaissance, int poids, String surnom, String main, int classement, int solidite, int endurance, int vitesse,int force, int victoire, int defaite, int attaque, int encaisse){
        super(nom, prenom, dateNaissance);
        this.poids = poids;
        this.surnom = surnom;
        this.main = main; 
        this.classement = classement;
        this.solidite = solidite;
        this.endurance = endurance;
        this.vitesse = vitesse;
        this.force = force;
        this.victoire = victoire;
        this.defaite = defaite;
        this.attaque = attaque;
        this.encaisse = encaisse;
        introduceYourself();
    }
    
    
    /**
     * Récupérer un poids aléatoire entre 65 et 80
     * @return poids
     */
    public static int poids_legers(){
        //creation poids légers entre 65 et 80
        Random rand = new Random();
        int lowPoidsLegers = 65;
        int highPoidsLegers = 81;
        int randPoidsLegers= rand.nextInt(highPoidsLegers-lowPoidsLegers)+lowPoidsLegers;
        return randPoidsLegers;
    }
    
    /**
     * Récupérer un poids aléatoire entre 81 et 100
     * @return poids
     */
    public static int poids_moyens(){
        Random rand = new Random();
        //creation poids moyens entre 81 et 100
        int lowPoidsMoyens = 81;
        int highPoidsMoyens = 101;
        int randPoidsMoyens= rand.nextInt(highPoidsMoyens-lowPoidsMoyens)+lowPoidsMoyens;
        return randPoidsMoyens;
    }  
    
    /**
     * Récupérer un poids aléatoire entre 101 et 150
     * @return poids
     */
    public static int poids_lourds(){
        //creation poids lourds entre 101 et 150
        Random rand = new Random();
        int lowPoidsLourds = 101;
        int highPoidsLourds = 151;
        int randPoidsLourds= rand.nextInt(highPoidsLourds-lowPoidsLourds)+lowPoidsLourds;
        return randPoidsLourds;
    }
    
    /**
     * Récuperer aléatoirement une capacité (solidite, endurance, vitesse ou force) entre 10 et 100
     * @return capacité
     */
    public static int capacite(){
        Random rand = new Random();
        //création capacités (solidité, endurance, vitesse, force) entre 10 et 100 (%)
        int lowCapacite = 10;
        int highCapacite = 101;
        int randCapacite= rand.nextInt(highCapacite-lowCapacite)+lowCapacite;
        return randCapacite;
    }
    
    /**
     * Déterminer la main dominante
     * @return main dominante
     */
    public static String main_dominante(){
        Random rand = new Random();
        String main_d;
        //création main dominante
        boolean main_dominante=rand.nextBoolean();
        if (main_dominante){
            main_d="gauche";
        }
        else{
            main_d="droite";
        }
        return main_d;
        
    }
    
    /**
     *Le boxeur se présente
     */
    @Override
    public void introduceYourself(){
        //super.introduceYourself();
        if (surnom.equals(" ")){
            System.out.println("Je suis " + prenom + " " + nom + ".");
            System.out.println(" ");
        }
        else{
            System.out.println("Je suis " + prenom + " " + nom + " AKA " + surnom + ".");
        System.out.println(" ");
        }
        
    } 
    
    /**
     * Accéder au surnom du boxeur
     * @return surnom
     */
    public String getSurnom(){
        return surnom;
    }

    /**
     * Mutation du surnom du boxeur
     * @param surnom surnom boxeur
     */
    public void setSurnom(String surnom){
        this.surnom = surnom;
    }
    
    /**
     * Accéder à la main dominante du boxeur
     * @return main dominante
     */    
    public String getMain(){
        return main;
    }

    /**
     * Mutation de la main dominante du boxeur
     * @param main main dominante
     */
    public void setMain(String main){
        this.main = main;
    }
    
    
    /**
     * Accéder au classement du boxeur
     * @return classement
     */    
    public int getClassement(){
        return classement;
    }

    /**
     * Mutation du classement du boxeur
     * @param classement classement du boxeur
     */
    public void setClassement(int classement){
        this.classement = classement;
    }
    
    /**
     * Accéder à la solidité du boxeur
     * @return solidite
     */    
    public int getSolidite(){
        return solidite;
    }

    /**
     * Mutation de la solidite du boxeur
     * @param solidite solidite du boxeur
     */
    public void setSolidite(int solidite){
        this.solidite = solidite;
    }
    
    /**
     * Accéder à l'endurance du boxeur
     * @return endurance
     */    
    public int getEndurance(){
        return endurance;
    }

    /**
     * Accéder à la vitesse du boxeur
     * @return vitesse
     */   
    public int getVitesse(){
        return vitesse;
    }

    /**
     * Accéder à la force du boxeur
     * @return force
     */    
    public int getForce(){
        return force;
    }

    /**
     * Accéder au poids du boxeur
     * @return poids
     */
    public int getPoids(){
        return poids;
    }

    /**
     * Accéder aux nombres de victoires du boxeur
     * @return nombre de victoires
     */
    public int getVictoire() {
        return victoire;
    }

    /**
     * Mutation du nombre de victoires
     * @param victoire nombre de victoires
     */
    public void setVictoire(int victoire) {
        this.victoire = victoire;
    }

    /**
    * Accéder aux nombres de défaites du boxeur
    * @return nombre de défaites
    */
    public int getDefaite() {
        return defaite;
    }

    /**
     * Mutation du nombre de défaites
     * @param defaite nombre de défaites
     */
    public void setDefaite(int defaite) {
        this.defaite = defaite;
    }

    /**
    * Accéder aux nombres d'attaques du boxeur
    * @return nombre d'attaques
    */
    public int getAttaque() {
        return attaque;
    }

    /**
     * Mutation du nombre d'attaques
     * @param attaque nombre d'attaques
     */
    public void setAttaque(int attaque) {
        this.attaque = attaque;
    }

    /**
    * Accéder aux nombres de coups encaissés du boxeur
    * @return nombre de coups encaissés
    */
    public int getEncaisse() {
        return encaisse;
    }

    /**
     * Mutation du nombre de coups encaissés
     * @param encaisse nombre de coups encaissés
     */
    public void setEncaisse(int encaisse) {
        this.encaisse = encaisse;
    }
    
    
}
