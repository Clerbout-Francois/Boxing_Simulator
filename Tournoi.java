/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author lbris
 */
public class Tournoi {
    protected ArrayList<Boxeur> liste_boxeur;
    protected ArrayList<Arbitre> liste_arbitre;
    protected ArrayList<Spectateur> liste_spectateur;
    protected String nomTournoi;
    
    
    
    /**
     * Constructeur Tournoi, impossible à créer sans les paramètres
     * @param nomTournoi
     * @param liste_boxeur
     * @param liste_arbitre
     * @param liste_spectateur
     */
    public Tournoi(String nomTournoi,ArrayList<Boxeur> liste_boxeur, ArrayList liste_arbitre, ArrayList liste_spectateur){
        this.nomTournoi=nomTournoi;
        this.liste_boxeur=liste_boxeur;
        this.liste_arbitre=liste_arbitre;
        this.liste_spectateur=liste_spectateur;
    }
    
    /**
     *
     * Accéder au nom du tournoi
     * @return nomTournoi
     */
    public String getNomTournoi(){
        return nomTournoi;
    }
    /**
     *Déroulement d'un tournoi entre 128 boxeurs
     * @param nomTournoi
     */
    public void deroulementTournoi(String nomTournoi){
        Random rand =new Random();
        ArrayList<Boxeur> vainqueur_tour1= new ArrayList<>();
        int tour1=0;
        ArrayList<Boxeur> vainqueur_tour2= new ArrayList<>();
        int tour2=0;
        ArrayList<Boxeur> vainqueur_tour3= new ArrayList<>();
        int tour3=0;
        ArrayList<Boxeur> vainqueur_tour4= new ArrayList<>();
        int tour4=0;
        ArrayList<Boxeur> vainqueur_quarts= new ArrayList<>();
        int quarts=0;
        ArrayList<Boxeur> vainqueur_demis= new ArrayList<>();
        int demis=0;
        int finale=0;
        Collections.shuffle(liste_boxeur);
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("On attaque le premier tour du tournoi " + nomTournoi);
        System.out.println(" ");
        while (tour1<128){
            Boxeur boxeur1=liste_boxeur.get(tour1);
            Boxeur boxeur2=liste_boxeur.get(tour1+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);;
            vainqueur_tour1.add(vainqueur);
            System.out.println(" ");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            tour1+=2;
        }
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("On attaque le deuxième tour du tournoi " + nomTournoi);
        System.out.println(" ");
        while (tour2<64){
            Boxeur boxeur1=vainqueur_tour1.get(tour2);
            Boxeur boxeur2=vainqueur_tour1.get(tour2+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);;
            vainqueur_tour2.add(vainqueur);
            vainqueur_tour2.add(boxeur2);
            System.out.println(" ");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            tour2+=2;
        }
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("On attaque le troisème tour du tournoi " + nomTournoi);
        System.out.println(" ");
        while (tour3<32){
            Boxeur boxeur1=vainqueur_tour2.get(tour3);
            Boxeur boxeur2=vainqueur_tour2.get(tour3+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);;
            vainqueur_tour3.add(vainqueur);
            System.out.println(" ");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            tour3+=2;
        }
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("On attaque le quatrième tour du tournoi " + nomTournoi);
        System.out.println(" ");
        while (tour4<16){
            Boxeur boxeur1=vainqueur_tour3.get(tour4);
            Boxeur boxeur2=vainqueur_tour3.get(tour4+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);;
            vainqueur_tour4.add(vainqueur);
            System.out.println(" ");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            tour4+=2;
        }
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("Place au tableau final !!!!");
        System.out.println("On attaque maintenant les quarts de finale du tournoi " + nomTournoi);
        System.out.println(" ");
        while (quarts<8){
            Boxeur boxeur1= liste_boxeur.get(quarts);
            Boxeur boxeur2= liste_boxeur.get(quarts+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);;
            vainqueur_quarts.add(vainqueur);
            System.out.println(" ");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            quarts+=2;
        }
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("Beaucoup d'appelés, peu d'élus...voici les demi-finales du tournoi " + nomTournoi);
        System.out.println(" ");
        while (demis<4){
            Boxeur boxeur1=vainqueur_quarts.get(demis);
            Boxeur boxeur2=vainqueur_quarts.get(demis+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);;
            vainqueur_demis.add(vainqueur);
            System.out.println(" ");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            demis+=2;
        }
        System.out.println(" ");
        System.out.println("!!!!!!!!!!!!!!!!!!!");
        System.out.println("Le dénouement de ce tournoi d'ici quelques coups : la finale du tournoi " + nomTournoi + " !!!!!!");
        System.out.println(" ");
        while (finale<2){
            Boxeur boxeur1=vainqueur_demis.get(finale);
            Boxeur boxeur2=vainqueur_demis.get(finale+1);
            Arbitre arbitre=liste_arbitre.get(rand.nextInt(liste_arbitre.size()));
            Combat combat=new Combat(boxeur1, boxeur2, arbitre);
            Round round = new Round(boxeur1, boxeur2, arbitre);
            System.out.println("On commence par la présentation des deux boxeurs...TADAM");
            System.out.println(" ");
            combat.annonceBoxeurs(boxeur1, boxeur2);
            Boxeur vainqueur = processus(combat, round, boxeur1, boxeur2, arbitre);
            try{
                FileWriter Annonce_Champion = new FileWriter("Annonce_Champion.txt");
                Annonce_Champion.write("Ladies and Gentlemen.......\nVoici votre nouveau champion....\nIncontesté tout au long de ce tournoi, il a remporté tous ses combats !!\nIl a encaissé " + vainqueur.getEncaisse() + " coup(s) et a réalisé " + vainqueur.getAttaque() + " frappe(s) significative(s) !!\nJe vous demande un tonnerre d'applaudissements pour " + vainqueur.getPrenom() + " " + vainqueur.getNom() + " !!!!!!!!!");
                Annonce_Champion.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            
            System.out.println(" ");
            System.out.println("L'article de presse relatant les exploits du vainqueurs est visible (et lisible !) dans le fichier Annonce_Champion.txt,");
            System.out.println("bonne lecture et si cela vous inspire...prenez les gants !!");
            int alea = rand.nextInt(liste_spectateur.size());
            System.out.println("Spectateur "+ (liste_spectateur.get(alea)).getPrenom() + " "+ (liste_spectateur.get(alea)).getNom()+": Bravo !!" );
            finale+=2;
        }
        
        
        
    }
    
    /**
     * Choix du type de combat, auto ou manuel, avec affichage ou non du combat
     * @param combat0 combat
     * @param round0 round
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param arbitre0 arbitre
     * @return boxeur gagnant
     */
    public Boxeur processus(Combat combat0, Round round0, Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre0){
        Scanner keyboard = new Scanner(System.in);
        System.out.println(" ");
        System.out.println("Voulez-vous jouer ce combat manuellement (m) ou qu'il se fasse automatiquement (a) ?");
        String maniere = keyboard.nextLine();
        while (!maniere.equals("m") & !maniere.equals("a")) {
            System.out.println(" ");
            System.out.println("Veuillez répondre correctement à la question : Voulez-vous jouer ce combat manuellement (m) ou qu'il se fasse automatiquement (a) ?");
            maniere = keyboard.nextLine();
        }
        if (maniere.equals("m")) {
            //ICI LE PROGRAMME EN MODE MANUEL
            System.out.println(" ");
            System.out.println("!!!!!!!!!!!!");
            System.out.println("CONSIGNE DE JEU :");
            System.out.println(" ");
            System.out.println("Pour frapper/esquiver, une consigne (lettre minuscule aléatoire) vous est donnée");
            System.out.println("Saisir la lettre au clavier (en minuscule) et valider avec la touche entrée");
            System.out.println("Tout ceci avant la fin du temps imparti (déterminé aléatoirement) entre 2 et 6 secondes");
            System.out.println("Si vous dépassez ce temps, il sera considéré que vous n'avez pas réussi à frapper/esquiver");
            System.out.println("!!!!!!!!!!!!");
            System.out.println(" ");
            System.out.println("Comme vous voulez jouer ce combat, quel boxeur voulez-vous contrôler ? Coin bleu (CB) ou coin rouge (CR)?");
            String choix_boxeur = keyboard.nextLine();

            while (!choix_boxeur.equals("CB") & !choix_boxeur.equals("CR")) {
                System.out.println(" ");
                System.out.println("Veuillez répondre correctement à la question : Voulez-vous jouer le boxeur du coin bleu (CB) ou du coin rouge (CR) ?");
                choix_boxeur = keyboard.nextLine();
            }
            //Combat.annonceBoxeurs();
            if (choix_boxeur.equals("CB")) {
                choix_boxeur = "CB";
                System.out.println(" ");
                combat0.controlBoxeur(boxeur1, boxeur2, choix_boxeur);
                round0.controlManuelCombatBoxeur1(boxeur1, boxeur2, arbitre0);
                Boxeur vainqueur=round0.controlManuelCombatBoxeur1(boxeur1, boxeur2, arbitre0);
                return vainqueur;
            } else if (choix_boxeur.equals("CR")) {
                choix_boxeur = "CR";
                System.out.println(" ");
                combat0.controlBoxeur(boxeur1, boxeur2, choix_boxeur);
                round0.controlManuelCombatBoxeur2(boxeur1, boxeur2, arbitre0);
                Boxeur vainqueur=round0.controlManuelCombatBoxeur2(boxeur1, boxeur2, arbitre0);
                return vainqueur;
            }

        } else if (maniere.equals("a")) {
            //Combat combat0 = new Combat(boxeur1, boxeur2, arbitre0);
            //ICI LE PROGRAMME EN MODE AUTOMATIQUE
            System.out.println(" ");
            System.out.println("Le combat va se jouer automatiquement, vous pouvez maintenant décider si vous voulez voir le déroulé ou non du match (Y/N).");
            String deroule = keyboard.nextLine();
            while (!deroule.equals("Y") & !deroule.equals("N")) {
                System.out.println(" ");
                System.out.println("Veuillez répondre par Y ou N afin de choisir si vous voulez ou non observer le déroulé du combat.");
                deroule = keyboard.nextLine();
            }
            if (deroule.equals("Y")) {
                System.out.println(" ");
                System.out.println("Voici le déroulé du match :");
                System.out.println(" ");
                Boxeur vainqueur=round0.affichageDetailsCombat(boxeur1, boxeur2, arbitre0);
                return vainqueur;
            } else if (deroule.equals("N")) {
                System.out.println(" ");
                System.out.println("Voici le résultat du match :");
                Boxeur vainqueur=round0.affichageSansDetailsCombat(boxeur1, boxeur2, arbitre0);//annonce du vainqueur
                System.out.println(" ");
                return vainqueur;
                

            }
        }
        return boxeur1;
    }
}
