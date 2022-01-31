/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
import java.util.Scanner;
import java.util.Random;
/**
 *
 * @author clerb
 */
public class Round extends Combat {
    private int numeroRound;
    private boolean coup;
    private int compteur_boxeur1;
    private int compteur_boxeur2;
    private int compteur_round_boxeur1;
    private int compteur_round_boxeur2;
    private double solidite_boxeur1;
    private double solidite_boxeur2;
    private double boxeur1BONUS;
    private double boxeur2BONUS;
    private int boxeur1_victoire;
    private int boxeur1_defaite;
    private int boxeur1_attaque;
    private int boxeur1_encaisse;
    private int boxeur2_victoire;
    private int boxeur2_defaite;
    private int boxeur2_attaque;
    private int boxeur2_encaisse;
    double solidite_initiale_boxeur1;
    double solidite_initiale_boxeur2;
    double difference_boxeur1;
    double difference_boxeur2;
    double ecart;
    int choix_coup;
    boolean localisation;
    double degat=0;
    boolean reussite_coup;
    boolean type_esquive;
    boolean gagnant_round_hasard;
    String style_de_coup = "";
    String zone = "";
    char action;
    int temps;
    long debut;
    long fin;
    long diff;
    int gagnant = 0;

    
    /**
    * Constructeur Round, impossible à créer sans les paramètres
    * @param boxeur1 premier boxeur
    * @param boxeur2 deuxieme boxeur
    * @param arbitre arbitre
    */
    public Round(Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre){
        super(boxeur1, boxeur2, arbitre);
        
        
    }
    
    /**
     * affichage des détails du match
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param arbitre arbitre
     * @return boxeur gagnant
     */
    public Boxeur affichageDetailsCombat(Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre){
        boxeur1_victoire = boxeur1.getVictoire();
        boxeur1_defaite = boxeur1.getDefaite();
        boxeur1_attaque = boxeur1.getAttaque();
        boxeur1_encaisse = boxeur1.getEncaisse();
        boxeur2_victoire = boxeur2.getVictoire();
        boxeur2_defaite = boxeur2.getDefaite();
        boxeur2_attaque = boxeur2.getAttaque();
        boxeur2_encaisse = boxeur2.getEncaisse();
        solidite_initiale_boxeur1 = boxeur1.getSolidite();
        solidite_initiale_boxeur2 = boxeur2.getSolidite();
        solidite_boxeur1 = solidite_initiale_boxeur1;
        solidite_boxeur2  = solidite_initiale_boxeur2;
        Random rd = new Random(); //creating random object
        numeroRound = 1;
        boxeur1BONUS=calculBonus1(boxeur1, boxeur2);
        boxeur2BONUS=calculBonus2(boxeur1, boxeur2);
        difference_boxeur1 = 0;
        difference_boxeur2 = 0;
        ecart = 0;
        degat=0;
        compteur_round_boxeur1 = 0;
        compteur_round_boxeur2 = 0;
        
        while((solidite_boxeur1 > 0) & (solidite_boxeur2 > 0) & (numeroRound <= 3)){

            while ((compteur_boxeur1 < 5) & (compteur_boxeur2 < 5) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)) {
                choix_coup = rd.nextInt(4 - 1) + 1;
                switch (choix_coup) {
                    case 1:
                        style_de_coup = "crochet";
                        degat = 2;
                        break;
                    case 2:
                        style_de_coup = "direct";
                        degat = 1;
                        break;
                    case 3:
                        style_de_coup = "uppercut";
                        degat = 3;
                        break;
                    default:
                        break;
                }
                localisation = rd.nextBoolean();
                if (localisation == true) {
                    zone = "visage";
                    degat = degat * 2;
                } 
                else if (localisation == false) {
                    zone = "corps";
                    //degat = degat;
                }
                coup = rd.nextBoolean();
                if (coup == true) {
                    System.out.println("Le boxeur " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " lance un " + style_de_coup + " en direction du " + zone + " ! ");
                    reussite_coup = rd.nextBoolean();
                    if (reussite_coup == true) {
                        solidite_boxeur2 = solidite_boxeur2 - degat * boxeur1BONUS;
                        System.out.println("Cible atteinte !!");
                        boxeur2_encaisse ++;
                        boxeur1_attaque ++;
                        boxeur2.setEncaisse(boxeur2_encaisse);
                        boxeur1.setAttaque(boxeur1_attaque);
                        
                        
                    } 
                    else if (reussite_coup == false) {
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            System.out.println("Le coup a été magistralement esquivé par " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " ! ");
                        } 
                        else if (type_esquive == false) {                     
                            System.out.println("Le coup a été bloqué par " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " ! ");
                        }
                    }
                    compteur_boxeur1++;
                } 
                else if (coup == false) {
                    System.out.println("Le boxeur " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " lance un " + style_de_coup + " en direction du " + zone + " ! ");
                    reussite_coup = rd.nextBoolean();
                    if (reussite_coup == true) {
                        solidite_boxeur1 = solidite_boxeur1 - degat * boxeur2BONUS;
                        System.out.println("Cible atteinte !!");
                        boxeur1_encaisse ++;
                        boxeur2_attaque ++;
                        boxeur1.setEncaisse(boxeur1_encaisse);
                        boxeur2.setAttaque(boxeur2_attaque);
                    } 
                    else if (reussite_coup == false) {
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            System.out.println("Le coup a été magistralement esquivé par " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " ! ");
                        } 
                        else if (type_esquive == false) {
                            System.out.println("Le coup a été bloqué par " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " ! ");
                        }

                    }
                    compteur_boxeur2++;

                }
            }
            compteur_boxeur1=0;
            compteur_boxeur2=0;
            difference_boxeur1 = solidite_initiale_boxeur1 - solidite_boxeur1;
            solidite_initiale_boxeur1 = solidite_boxeur1;
            difference_boxeur2 = solidite_initiale_boxeur2 - solidite_boxeur2;
            solidite_initiale_boxeur2 = solidite_boxeur2;
            ecart = difference_boxeur1 - difference_boxeur2;
            System.out.println(" ");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if((ecart > 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " au round numero " + numeroRound);
                compteur_round_boxeur2++;
            }
            else if((ecart < -7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " au round numero " + numeroRound);
                compteur_round_boxeur1++;
            }
            else if((ecart >= -7) & (ecart <= 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                gagnant_round_hasard = rd.nextBoolean();
                if(gagnant_round_hasard == true){
                    System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " au round numero " + numeroRound);
                    compteur_round_boxeur1++;
                }
                else if(gagnant_round_hasard == false) {
                    System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " au round numero " + numeroRound);
                    compteur_round_boxeur2++;
                }
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(" ");
            numeroRound++;
            
        }
        
        
        if(solidite_boxeur1 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " par KO");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant =2;
        }
        else if(solidite_boxeur2 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " par KO");
            boxeur1.setVictoire(boxeur1_victoire + 1);
            boxeur2.setDefaite(boxeur2_defaite + 1);
            gagnant = 1;
        }       
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 > compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Et ceci sur le score de " + compteur_round_boxeur1 + " round(s) à " + compteur_round_boxeur2 + " !!");
            System.out.println(" ");
            boxeur1.setVictoire(boxeur1_victoire + 1);
            boxeur2.setDefaite(boxeur2_defaite + 1);
            gagnant =1;
        }
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 < compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Et ceci sur le score de " + compteur_round_boxeur2 + " round(s) à " + compteur_round_boxeur1 + " !!");
            System.out.println(" ");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        if(gagnant == 1){
            if (boxeur1.getClassement()>boxeur2.getClassement()){
                int classement_tampon = boxeur2.getClassement();
                boxeur2.setClassement(boxeur1.getClassement());
                boxeur1.setClassement(classement_tampon);
            }
            return boxeur1;
            
        }
        else{
            if (boxeur2.getClassement()>boxeur1.getClassement()){
                int classement_tampon = boxeur1.getClassement();
                boxeur1.setClassement(boxeur2.getClassement());
                boxeur2.setClassement(classement_tampon);
            }
            return boxeur2;
        }
    }
    
    /**
     * affichage sans détails du match, juste le résultat
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param arbitre arbitre
     * @return boxeur gagnant
     */
    public Boxeur affichageSansDetailsCombat(Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre){
        boxeur1_victoire = boxeur1.getVictoire();
        boxeur1_defaite = boxeur1.getDefaite();
        boxeur1_attaque = boxeur1.getAttaque();
        boxeur1_encaisse = boxeur1.getEncaisse();
        boxeur2_victoire = boxeur2.getVictoire();
        boxeur2_defaite = boxeur2.getDefaite();
        boxeur2_attaque = boxeur2.getAttaque();
        boxeur2_encaisse = boxeur2.getEncaisse();
        solidite_initiale_boxeur1 = boxeur1.getSolidite();
        solidite_initiale_boxeur2 = boxeur2.getSolidite();
        solidite_boxeur1 = solidite_initiale_boxeur1;
        solidite_boxeur2  = solidite_initiale_boxeur2; 
        difference_boxeur1 = 0;
        difference_boxeur2 = 0;
        ecart = 0;
        Random rd = new Random(); //creating random object
        degat=0;
        numeroRound = 1;
        boxeur1BONUS=calculBonus1(boxeur1, boxeur2);
        boxeur2BONUS=calculBonus2(boxeur1, boxeur2);
        compteur_round_boxeur1 = 0;
        compteur_round_boxeur2 = 0;
        
        while((solidite_boxeur1 > 0) & (solidite_boxeur2 > 0) & (numeroRound <= 3)){

            while ((compteur_boxeur1 < 5) & (compteur_boxeur2 < 5) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)) {
                choix_coup = rd.nextInt(4 - 1) + 1;
                switch (choix_coup) {
                    case 1:
                        style_de_coup = "crochet";
                        degat = 2;
                        break;
                    case 2:
                        style_de_coup = "direct";
                        degat = 1;
                        break;
                    case 3:
                        style_de_coup = "uppercut";
                        degat = 3;
                        break;
                    default:
                        break;
                }
                localisation = rd.nextBoolean();
                if (localisation == true) {
                    zone = "visage";
                    degat = degat * 2;
                } 
                else if (localisation == false) {
                    zone = "corps";
                    //degat = degat;
                }
                coup = rd.nextBoolean();
                if (coup == true) {
                    //System.out.println("Le boxeur " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " lance un " + style_de_coup + " en direction du " + zone + " ! ");
                    reussite_coup = rd.nextBoolean();
                    if (reussite_coup == true) {
                        solidite_boxeur2 = solidite_boxeur2 - degat * boxeur1BONUS;
                        //System.out.println("Cible atteinte !!");
                        boxeur2_encaisse ++;
                        boxeur1_attaque ++;
                        boxeur2.setEncaisse(boxeur2_encaisse);
                        boxeur1.setAttaque(boxeur1_attaque);
                    } 
                    else if (reussite_coup == false) {
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            //System.out.println("Le coup a été magistralement esquivé par " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " ! ");
                        } 
                        else if (type_esquive == false) {                     
                            //System.out.println("Le coup a été bloqué par " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " ! ");
                        }
                    }
                    compteur_boxeur1++;
                } 
                else if (coup == false) {
                    //System.out.println("Le boxeur " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " lance un " + style_de_coup + " en direction du " + zone + " ! ");
                    reussite_coup = rd.nextBoolean();
                    if (reussite_coup == true) {
                        solidite_boxeur1 = solidite_boxeur1 - degat * boxeur2BONUS;
                        //System.out.println("Cible atteinte !!");
                        boxeur1_encaisse ++;
                        boxeur2_attaque ++;
                        boxeur1.setEncaisse(boxeur1_encaisse);
                        boxeur2.setAttaque(boxeur2_attaque);
                    } 
                    else if (reussite_coup == false) {
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            //System.out.println("Le coup a été magistralement esquivé par " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " ! ");
                        } 
                        else if (type_esquive == false) {
                            //System.out.println("Le coup a été bloqué par " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " ! ");
                        }

                    }
                    compteur_boxeur2++;

                }
            }
            compteur_boxeur1=0;
            compteur_boxeur2=0;
            difference_boxeur1 = solidite_initiale_boxeur1 - solidite_boxeur1;
            solidite_initiale_boxeur1 = solidite_boxeur1;
            difference_boxeur2 = solidite_initiale_boxeur2 - solidite_boxeur2;
            solidite_initiale_boxeur2 = solidite_boxeur2;
            ecart = difference_boxeur1 - difference_boxeur2;
            //System.out.println(" ");
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if((ecart > 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                //System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " au round numero " + numeroRound);
                compteur_round_boxeur2++;
            }
            else if((ecart < -7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                //System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " au round numero " + numeroRound);
                compteur_round_boxeur1++;
            }
            else if ((ecart >= -7) & (ecart <= 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                gagnant_round_hasard = rd.nextBoolean();
                if(gagnant_round_hasard == true){
                    //System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " au round numero " + numeroRound);
                    compteur_round_boxeur1++;
                }
                else if(gagnant_round_hasard == false) {
                    //System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " au round numero " + numeroRound);
                    compteur_round_boxeur2++;
                }
            }
            //System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            //System.out.println(" ");
            numeroRound++;
            
        }
        
        
        if(solidite_boxeur1 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " par KO");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        else if(solidite_boxeur2 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " par KO");
            boxeur2.setDefaite(boxeur2_defaite + 1);
            boxeur1.setVictoire(boxeur1_victoire + 1);
            gagnant = 1;
        }       
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 > compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Et ceci sur le score de " + compteur_round_boxeur1 + " round(s) à " + compteur_round_boxeur2 + " !!");
            System.out.println(" ");
            boxeur2.setDefaite(boxeur2_defaite + 1);
            boxeur1.setVictoire(boxeur1_victoire + 1);
            gagnant = 1;
        }
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 < compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Et ceci sur le score de " + compteur_round_boxeur2 + " round(s) à " + compteur_round_boxeur1 + " !!");
            System.out.println(" ");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        if(gagnant == 1){
            if (boxeur1.getClassement()>boxeur2.getClassement()){
                int classement_tampon = boxeur2.getClassement();
                boxeur2.setClassement(boxeur1.getClassement());
                boxeur1.setClassement(classement_tampon);
            }
            return boxeur1;
            
        }
        else{
            if (boxeur2.getClassement()>boxeur1.getClassement()){
                int classement_tampon = boxeur1.getClassement();
                boxeur1.setClassement(boxeur2.getClassement());
                boxeur2.setClassement(classement_tampon);
            }
            return boxeur2;
        }
}

    /**
     * Controler le match manuellement pour le boxeur 1
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param arbitre arbitre
     * @return boxeur gagnant
     */
    public Boxeur controlManuelCombatBoxeur1(Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre){
        boxeur1_victoire = boxeur1.getVictoire();
        boxeur1_defaite = boxeur1.getDefaite();
        boxeur1_attaque = boxeur1.getAttaque();
        boxeur1_encaisse = boxeur1.getEncaisse();
        boxeur2_victoire = boxeur2.getVictoire();
        boxeur2_defaite = boxeur2.getDefaite();
        boxeur2_attaque = boxeur2.getAttaque();
        boxeur2_encaisse = boxeur2.getEncaisse();
        solidite_initiale_boxeur1 = boxeur1.getSolidite();
        solidite_initiale_boxeur2 = boxeur2.getSolidite();
        solidite_boxeur1 = solidite_initiale_boxeur1;
        solidite_boxeur2  = solidite_initiale_boxeur2; 
        difference_boxeur1 = 0;
        difference_boxeur2 = 0;
        ecart = 0;
        Random rd = new Random(); //creating random object
        degat=0;
        numeroRound = 1;
        Scanner keyboard = new Scanner(System.in); //initialisation du keyboard afin que l'utilisateur puisse interagir avec le programme
        boxeur1BONUS=calculBonus1(boxeur1, boxeur2);
        boxeur2BONUS=calculBonus2(boxeur1, boxeur2);
        compteur_round_boxeur1 = 0;
        compteur_round_boxeur2 = 0;
        
        
        while((solidite_boxeur1 > 0) & (solidite_boxeur2 > 0) & (numeroRound <= 3)){
            
            while ((compteur_boxeur1 < 5) & (compteur_boxeur2 < 5) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)) {
                choix_coup = rd.nextInt(4 - 1) + 1;
                switch (choix_coup) {
                    case 1:
                        style_de_coup = "crochet";
                        degat = 2;
                        break;
                    case 2:
                        style_de_coup = "direct";
                        degat = 1;
                        break;
                    case 3:
                        style_de_coup = "uppercut";
                        degat = 3;
                        break;
                    default:
                        break;
                }
                localisation = rd.nextBoolean();
                if (localisation == true) {
                    zone = "visage";
                    degat = degat * 2;
                } 
                else if (localisation == false) {
                    zone = "corps";
                    //degat = degat;
                }
                coup = rd.nextBoolean();
                if (coup == true) {
                    action = (char)(rd.nextInt(26) + 97);//pour être en code ASCII et sortir un char
                    temps = rd.nextInt(7 - 2) + 2;
                    //int t = reaction.length();
                    
                    System.out.println(" ");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!! ATTENTION !!");
                    System.out.println("Vous avez l'occasion d'envoyer un " + style_de_coup + " au " + zone + " de votre adversaire !!");
                    System.out.println("Frappez avec         " + action + "         puis avec la touche entrée avant " + temps + " secondes");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println(" ");
                    debut = System.currentTimeMillis( ); 
                    String reaction = keyboard.nextLine();
                    
                    char charVar = ' ';
                    try {
                        charVar = reaction.charAt(0);//convertir la liste en char, en extrayant le premier terme seulement
                    //System.out.println(charVar);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Erreur");
                    }
                    
                    fin = System.currentTimeMillis( ); 
                    diff = fin - debut;
                    if ((action == charVar) & (reaction.length() == 1) & (diff < (temps * 1000))) {//réussite du coup
                        solidite_boxeur2 = solidite_boxeur2 - degat * boxeur1BONUS;
                        System.out.println("Cible atteinte !!");
                        boxeur2_encaisse ++;
                        boxeur1_attaque ++;
                        boxeur2.setEncaisse(boxeur2_encaisse);
                        boxeur1.setAttaque(boxeur1_attaque);
                    } 
                    else if ((action != charVar) | (reaction.length() != 1) | (diff > (temps * 1000))) {//échec de coup
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            System.out.println("Le coup a été magistralement esquivé par " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " ! ");
                        } 
                        else if (type_esquive == false) {
                            System.out.println("Le coup a été bloqué par " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " ! ");
                        }
                    }
                    compteur_boxeur1++;
                } 
                else if (coup == false) {
                    action = (char)(rd.nextInt(26) + 97);//pour être en code ASCII et sortir un char
                    temps = rd.nextInt(7 - 2) + 2;
                    //int t = reaction.length();
                    
                    System.out.println(" ");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!! ATTENTION !!");
                    System.out.println("Votre opposant vous envoie un " + style_de_coup + " au " + zone + " !!");
                    System.out.println("Esquivez avec         " + action + "         puis avec la touche entrée avant " + temps + " secondes");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println(" ");
                    debut = System.currentTimeMillis( ); 
                    String reaction = keyboard.nextLine();
                    char charVar = ' ';
                    try {
                        charVar = reaction.charAt(0);//convertir la liste en char, en extrayant le premier terme seulement
                    //System.out.println(charVar);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Erreur");
                    }
                    
                    
                    fin = System.currentTimeMillis( ); 
                    diff = fin - debut;
                    if ((action != charVar) | (reaction.length() != 1) | (diff > (temps * 1000))) {//pas d'esquive, le boxeur 1 va encaisser des dégâts
                        solidite_boxeur1 = solidite_boxeur1 - degat * boxeur2BONUS;
                        System.out.println("Outch ça pique !!");
                        boxeur1_encaisse ++;
                        boxeur2_attaque ++;
                        boxeur1.setEncaisse(boxeur1_encaisse);
                        boxeur2.setAttaque(boxeur2_attaque);
                    } 
                    else if ((action == charVar) & (reaction.length() == 1) & (diff < (temps * 1000))) {//esquive ou contre
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            System.out.println("Vous avez magistralement esquivé cette attaque !! Une esquive digne de Mohammed Ali... ");
                        } 
                        else if (type_esquive == false) {
                            System.out.println("Vous venez de contrer le coup avec autorité !! On dirait Mike Tyson...");
                        }

                    }
                    compteur_boxeur2++;

                }
            }
            compteur_boxeur1=0;
            compteur_boxeur2=0;
            difference_boxeur1 = solidite_initiale_boxeur1 - solidite_boxeur1;
            solidite_initiale_boxeur1 = solidite_boxeur1;
            difference_boxeur2 = solidite_initiale_boxeur2 - solidite_boxeur2;
            solidite_initiale_boxeur2 = solidite_boxeur2;
            ecart = difference_boxeur1 - difference_boxeur2;
            System.out.println(" ");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if((ecart > 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur2.getNom() + " " + boxeur2.getPrenom());
                compteur_round_boxeur2++;
            }
            else if((ecart < -7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur1.getNom() + " " + boxeur1.getPrenom());
                compteur_round_boxeur1++;
            }
            else if((ecart >= -7) & (ecart <= 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                gagnant_round_hasard = rd.nextBoolean();
                if(gagnant_round_hasard == true){
                    System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur1.getNom() + " " + boxeur1.getPrenom());
                    compteur_round_boxeur1++;
                }
                else if(gagnant_round_hasard == false) {
                    System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur2.getNom() + " " + boxeur2.getPrenom());
                    compteur_round_boxeur2++;
                }
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(" ");
            numeroRound++;
            
        }
        
                
        if(solidite_boxeur1 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " (VOTRE ADVERSAIRE) par KO");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        else if(solidite_boxeur2 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " (VOUS) par KO");
            boxeur2.setDefaite(boxeur2_defaite + 1);
            boxeur1.setVictoire(boxeur1_victoire + 1);
            gagnant = 1;
        }       
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 > compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " (VOUS) par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Et ceci sur le score de " + compteur_round_boxeur1 + " round(s) à " + compteur_round_boxeur2 + " !!");
            System.out.println(" ");
            boxeur2.setDefaite(boxeur2_defaite + 1);
            boxeur1.setVictoire(boxeur1_victoire + 1);
            gagnant = 1;
        }
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 < compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " (VOTRE ADVERSAIRE) par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Et ceci sur le score de " + compteur_round_boxeur2 + " round(s) à " + compteur_round_boxeur1 + " !!");
            System.out.println(" ");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        if(gagnant == 1){
            if (boxeur1.getClassement()>boxeur2.getClassement()){
                int classement_tampon = boxeur2.getClassement();
                boxeur2.setClassement(boxeur1.getClassement());
                boxeur1.setClassement(classement_tampon);
            }
            return boxeur1;
            
        }
        else{
            if (boxeur2.getClassement()>boxeur1.getClassement()){
                int classement_tampon = boxeur1.getClassement();
                boxeur1.setClassement(boxeur2.getClassement());
                boxeur2.setClassement(classement_tampon);
            }
            return boxeur2;
        }
    }

    /**
     * Controler manuellement le match pour le boxeur 2
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param arbitre arbitre
     * @return boxeur gagnant
     */
    public Boxeur controlManuelCombatBoxeur2(Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre){
        boxeur1_victoire = boxeur1.getVictoire();
        boxeur1_defaite = boxeur1.getDefaite();
        boxeur1_attaque = boxeur1.getAttaque();
        boxeur1_encaisse = boxeur1.getEncaisse();
        boxeur2_victoire = boxeur2.getVictoire();
        boxeur2_defaite = boxeur2.getDefaite();
        boxeur2_attaque = boxeur2.getAttaque();
        boxeur2_encaisse = boxeur2.getEncaisse();
        solidite_initiale_boxeur1 = boxeur1.getSolidite();
        solidite_initiale_boxeur2 = boxeur2.getSolidite();
        solidite_boxeur1 = solidite_initiale_boxeur1;
        solidite_boxeur2  = solidite_initiale_boxeur2; 
        difference_boxeur1 = 0;
        difference_boxeur2 = 0;
        ecart = 0;
        Random rd = new Random(); //creating random object
        degat=0;
        numeroRound = 1;
        Scanner keyboard = new Scanner(System.in); //initialisation du keyboard afin que l'utilisateur puisse interagir avec le programme
        boxeur1BONUS=calculBonus1(boxeur1, boxeur2);
        boxeur2BONUS=calculBonus2(boxeur1, boxeur2);
        compteur_round_boxeur1 = 0;
        compteur_round_boxeur2 = 0;
        
        
        while((solidite_boxeur1 > 0) & (solidite_boxeur2 > 0) & (numeroRound <= 3)){
            
            while ((compteur_boxeur1 < 5) & (compteur_boxeur2 < 5) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)) {
                choix_coup = rd.nextInt(4 - 1) + 1;
                switch (choix_coup) {
                    case 1:
                        style_de_coup = "crochet";
                        degat = 2;
                        break;
                    case 2:
                        style_de_coup = "direct";
                        degat = 1;
                        break;
                    case 3:
                        style_de_coup = "uppercut";
                        degat = 3;
                        break;
                    default:
                        break;
                }
                localisation = rd.nextBoolean();
                if (localisation == true) {
                    zone = "visage";
                    degat = degat * 2;
                } 
                else if (localisation == false) {
                    zone = "corps";
                }
                coup = rd.nextBoolean();
                if (coup == true) {
                    action = (char)(rd.nextInt(26) + 97);//pour être en code ASCII et sortir un char
                    temps = rd.nextInt(7 - 2) + 2;
                    //int t = reaction.length();
                    
                    System.out.println(" ");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!! ATTENTION !!");
                    System.out.println("Vous avez l'occasion d'envoyer un " + style_de_coup + " au " + zone + " de votre adversaire !!");
                    System.out.println("Frappez avec         " + action + "         puis avec la touche entrée avant " + temps + " secondes");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println(" ");
                    debut = System.currentTimeMillis( ); 
                    String reaction = keyboard.nextLine();
                    
                    char charVar = ' ';
                    try {
                        charVar = reaction.charAt(0);//convertir la liste en char, en extrayant le premier terme seulement
                    //System.out.println(charVar);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Erreur");
                    }
                    
                    fin = System.currentTimeMillis( ); 
                    diff = fin - debut;
                    if ((action == charVar) & (reaction.length() == 1) & (diff < (temps * 1000))) {//réussite du coup
                        solidite_boxeur1 = solidite_boxeur1 - degat * boxeur2BONUS;
                        System.out.println("Cible atteinte !!");
                        boxeur1_encaisse ++;
                        boxeur2_attaque ++;
                        boxeur1.setEncaisse(boxeur1_encaisse);
                        boxeur2.setAttaque(boxeur2_attaque);
                    } 
                    else if ((action != charVar) | (reaction.length() != 1) | (diff > (temps * 1000))) {//échec de coup
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            System.out.println("Le coup a été magistralement esquivé par " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " ! ");
                        } 
                        else if (type_esquive == false) {
                            System.out.println("Le coup a été bloqué par " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " ! ");
                        }
                    }
                    compteur_boxeur2++;
                } 
                else if (coup == false) {
                    action = (char)(rd.nextInt(26) + 97);//pour être en code ASCII et sortir un char
                    temps = rd.nextInt(7 - 2) + 2;
                    //int t = reaction.length(); 
                    
                    System.out.println(" ");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println("!! ATTENTION !!");
                    System.out.println("Votre opposant vous envoie un " + style_de_coup + " au " + zone + " !!");
                    System.out.println("Esquivez avec         " + action + "         puis avec la touche entrée avant " + temps + " secondes");
                    System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                    System.out.println(" ");
                    debut = System.currentTimeMillis( ); 
                    String reaction = keyboard.nextLine();
                    
                    char charVar = ' ';
                    try {
                        charVar = reaction.charAt(0);//convertir la liste en char, en extrayant le premier terme seulement
                    //System.out.println(charVar);
                    } catch (StringIndexOutOfBoundsException e) {
                        System.out.println("Erreur");
                    }
                    
                    fin = System.currentTimeMillis( ); 
                    diff = fin - debut;
                    if ((action != charVar) | (reaction.length() != 1) | (diff > (temps * 1000))) {//pas d'esquive, le boxeur 2 va encaisser des dégâts
                        solidite_boxeur2 = solidite_boxeur2 - degat * boxeur1BONUS;
                        System.out.println("Outch ça pique !!");
                        boxeur2_encaisse ++;
                        boxeur1_attaque ++;
                        boxeur2.setEncaisse(boxeur2_encaisse + 1);
                        boxeur1.setAttaque(boxeur1_attaque + 1);
                    } 
                    else if ((action == charVar) & (reaction.length() == 1) & (diff < (temps * 1000))) {//esquive ou contre
                        type_esquive = rd.nextBoolean();
                        if (type_esquive == true) {
                            System.out.println("Vous avez magistralement esquivé cette attaque !! Une esquive digne de Mohammed Ali... ");
                        } 
                        else if (type_esquive == false) {
                            System.out.println("Vous venez de contrer le coup avec autorité !! On dirait Mike Tyson...");
                        }

                    }
                    compteur_boxeur1++;

                }
            }
            compteur_boxeur1=0;
            compteur_boxeur2=0;
            difference_boxeur1 = solidite_initiale_boxeur1 - solidite_boxeur1;
            solidite_initiale_boxeur1 = solidite_boxeur1;
            difference_boxeur2 = solidite_initiale_boxeur2 - solidite_boxeur2;
            solidite_initiale_boxeur2 = solidite_boxeur2;
            ecart = difference_boxeur1 - difference_boxeur2;
            System.out.println(" ");
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            if((ecart > 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur2.getNom() + " " + boxeur2.getPrenom());
                compteur_round_boxeur2++;
            }
            else if((ecart < -7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur1.getNom() + " " + boxeur1.getPrenom());
                compteur_round_boxeur1++;
            }
            else if ((ecart >= -7) & (ecart <= 7) & (solidite_boxeur1 > 0) & (solidite_boxeur2 > 0)){
                gagnant_round_hasard = rd.nextBoolean();
                if(gagnant_round_hasard == true){
                    System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur1.getNom() + " " + boxeur1.getPrenom());
                    compteur_round_boxeur1++;
                }
                else if(gagnant_round_hasard == false) {
                    System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : Le vainqueur du round numero " + numeroRound + " est " + boxeur2.getNom() + " " + boxeur2.getPrenom());
                    compteur_round_boxeur2++;
                }
            }
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println(" ");
            numeroRound++;
        }

        
        if(solidite_boxeur1 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " (VOUS) par KO");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        else if(solidite_boxeur2 <=0){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " (VOTRE ADVERSAIRE) par KO");
            boxeur2.setDefaite(boxeur2_defaite + 1);
            boxeur1.setVictoire(boxeur1_victoire + 1);
            gagnant = 1;
        }       
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 > compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " (VOTRE ADVERSAIRE) par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Et ceci sur le score de " + compteur_round_boxeur1 + " round(s) à " + compteur_round_boxeur2 + " !!");
            System.out.println(" ");
            boxeur2.setDefaite(boxeur2_defaite + 1);
            boxeur1.setVictoire(boxeur1_victoire + 1);
            gagnant = 1;
        }
        else if(((numeroRound-1) == 3) & (compteur_round_boxeur1 < compteur_round_boxeur2)){
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Le vainqueur de ce combat est " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " (VOUS) par décision des juges.");
            System.out.println("Arbitre " + arbitre.getNom() + " " + arbitre.getPrenom() + " : " + "Et ceci sur le score de " + compteur_round_boxeur2 + " round(s) à " + compteur_round_boxeur1 + " !!");
            System.out.println(" ");
            boxeur1.setDefaite(boxeur1_defaite + 1);
            boxeur2.setVictoire(boxeur2_victoire + 1);
            gagnant = 2;
        }
        if(gagnant == 1){
            if (boxeur1.getClassement()>boxeur2.getClassement()){
                int classement_tampon = boxeur2.getClassement();
                boxeur2.setClassement(boxeur1.getClassement());
                boxeur1.setClassement(classement_tampon);
            }
            return boxeur1;
            
        }
        else{
            if (boxeur2.getClassement()>boxeur1.getClassement()){
                int classement_tampon = boxeur1.getClassement();
                boxeur1.setClassement(boxeur2.getClassement());
                boxeur2.setClassement(classement_tampon);
            }
            return boxeur2;
        }
    }
    
    



}