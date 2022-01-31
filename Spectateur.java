/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
import java.time.LocalDate;
import java.time.Period;
import java.util.Random;
/**
 *
 * @author clerb
 */
public class Spectateur extends Personne implements Introduce {
    private char tribune;
    private int numero;
    private boolean interet;
    
    /**
     * Constructeur Spectateur, impossible à créer sans les paramètres
     * @param nom nom du spectateur
     * @param prenom prenom du spectateur
     * @param dateNaissance date de naissance du spectateur
     * @param tribune tribune du spectateur
     * @param numero numero du spectateur
     */
    public Spectateur (String nom, String prenom, String dateNaissance, char tribune, int numero){
        super(nom, prenom, dateNaissance);
        this.tribune = tribune;
        this.numero = numero;
        Random rd = new Random(); //creating random object
        this.interet = rd.nextBoolean();
        introduceYourself();
        crieAge();
    }
    
    /**
    *Récupérer une date de naissance aléatoire
    * année aléatoire entre 1930(inclus) et 2018(exclus)
    * mois aléatoire
    * jour aléatoire entre 1 et 29 (exclus)
    * @return un String correspondant à la date de naissance aléatoire sous la forme pAnnéeyMoismJourd
    */
    public static String dateNaissanceSpectateur(){
        Random rand = new Random();
        //année aléatoire entre 1930(inclus) et 2018(exclus)
        int lowAn = 1930;
        int highAn = 2018;
        int randAn= rand.nextInt(highAn-lowAn)+lowAn;
        //mois aléatoire 
        int lowMois = 1;
        int highMois = 13;
        int randMois= rand.nextInt(highMois-lowMois)+lowMois;
        //jour aléatoire
        int lowJour = 1;
        int highJour = 29;
        int randJour= rand.nextInt(highJour-lowJour)+lowJour;
        String date="p";
        date =date + randAn + "y" + randMois + "m" + randJour + "d";
        return date;
    }
    
    /**
     * Récupérer une tribune alétoire
     * @return tribune (a,b,c ou d)
     */
    public static char tribune(){
        Random rand = new Random();
        //création tribune (a,b,c ou d)
        char tribune = (char)(rand.nextInt(4) + 97);
        return tribune;
    }
    
    /**
     * Récuperer un numero de siege aléatoire
     * @return numero siege (entre 1 et 100)
     */
    public static int siege(){
        Random rand = new Random();
        //crétaion siege
        int lowSiege = 1;
        int highSiege = 100;
        int randSiege= rand.nextInt(highSiege-lowSiege)+lowSiege;
        return randSiege;
    }
    
    /**
     * Le spectateur se présente
     */
    @Override
    public void introduceYourself(){
        if (interet == true){
            System.out.println("Salut tout le monde, je m'appelle " + prenom + " " + nom + " et j'ai de l'interet pour la boxe");
            System.out.println(" ");
        }
        else if (interet == false){
            System.out.println("Salut tout le monde, je m'appelle " + prenom + " " + nom + " et je m'en moque de la boxe...");
            System.out.println(" ");
        }
    }
    
    /**
     * Le spectateur dit son age + commentaire
     */
    //@Override
    public void crieAge(){
        //super.crieAge();
        Period p = Period.parse(dateNaissance);
        LocalDate startDate = LocalDate.of(p.getYears(),p.getMonths(), p.getDays());
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        System.out.print("J'ai "+ period.getYears() + " ans");
        if (15 >= period.getYears()){
            System.out.println(" et je suis un bébé, ce n'est pas de mon âge.");
            System.out.println(" ");
        }
        else if ((15 < period.getYears()) && (period.getYears() <= 30)){
            System.out.println(" et je suis dans la force de l'âge.");
            System.out.println(" ");
        }
        else if ((30 < period.getYears()) && (period.getYears() <= 55)){
            System.out.println(" et j'aurais pu être boxeur si je ne m'étais pas fait les croisés tu connais...");
            System.out.println(" ");
        }
        else if (55 < period.getYears()){
            System.out.println(" et je risque de m'endormir.");
            System.out.println(" ");
        }
    }
}
