/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.Random;
import java.util.*;
import java.time.*;
/**
 *
 * @author clerb
 */
public class BoxSimulator implements Annonce{
    
    
    /**
     *  Affichage de toutes les caractéristiques d'un boxeur
     * @param boxeur
     */
    public static void affichage_auto_boxeur(Boxeur boxeur){
        //affichage automatique d'un joueur
        System.out.println("Classement : "+boxeur.getClassement());
        System.out.println("Prénom: "+ boxeur.prenom);
        System.out.println("Nom: "+boxeur.nom);
        Period p = Period.parse(boxeur.dateNaissance);
        LocalDate startDate = LocalDate.of(p.getYears(),p.getMonths(), p.getDays());
        LocalDate endDate = LocalDate.now();
        Period period = Period.between(startDate, endDate);
        System.out.println("Date de naissance: "+p.getDays()+"/"+p.getMonths()+"/"+p.getYears()+"     (Age: "+period.getYears()+")");
        System.out.println("Poids: "+boxeur.getPoids());
        System.out.println("Main dominante: main "+boxeur.getMain());
        System.out.println("Solidité: "+boxeur.getSolidite());
        System.out.println("Endurance: "+boxeur.getEndurance());
        System.out.println("Vitesse: "+boxeur.getVitesse());
        System.out.println("Force: "+boxeur.getForce());
        System.out.println("Victoire(s) : "+boxeur.getVictoire());
        System.out.println("Defaite(s) : "+boxeur.getDefaite());
        System.out.println("Coups reçus : "+boxeur.getEncaisse());
        System.out.println("Frappes significatives : "+boxeur.getAttaque());
    }
    
    
    /**
     * Permet de lire un fichier (.txt) et d'ajouter le contenu dans une liste
     * ligne par ligne
     *
     * @param liste
     * @param filename
     * @throws java.io.IOException
     */
    public static void lectureFichier(List<String> liste, String filename) throws IOException {
        FileInputStream ins = null;
        try {

            ins = new FileInputStream(filename);
            Scanner obj = new Scanner(ins);
            while (obj.hasNextLine()) {
                liste.add(obj.nextLine());
            }
        } finally {
            if (ins != null) {
                ins.close();
            }
        }
    }
    
    /**
     * Retourner un entier entré par l'utilisateur qui correspond aux conditions
     * @param min nombre minimum
     * @param max nombre maximum
     * @param info information 
     * @return un entier qui rempli les conditions
     */
    public static int entreeClavier(int min, int max, String info){
        Scanner keyboard = new Scanner(System.in);
        boolean condition = false;
        String manuel;
        int creation =1;
        do {
            manuel = keyboard.nextLine();//lecture de l'entrée du clavier
            try {
                creation = Integer.parseInt(manuel);//tranformation d'un string en int
                while ((creation < min) | (creation > max)) {
                    System.out.println("Erreur, "+info+" ?");
                    manuel = keyboard.nextLine();
                    creation = Integer.parseInt(manuel);
                }
                condition = true; // si ton exécution arrive jusque là, ça signifie qu'il n'y a aucune exception lancée et que ta saisie est donc bien un chiffre
            } catch (NumberFormatException e) { //exception si l'entrée n'est pas un chiffre
                System.out.println("Cette valeur n'est pas un chiffre, essaie encore !");
            }
        } while (condition != true);
        return creation;
    }
        
    
    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {
        
        //initialisation des variables compteurs boxeur, arbitre et spectateur afin de
        //ne pas créer plus de 128 boxeurs par exemple
        int compteur_arbitre = 0;
        int compteur_boxeur = 0;
        int compteur_spectateur = 0;
        Random rd = new Random();
        
        //Création des listes pour génération auto des personnes...
        List<String> liste_prenom = new ArrayList<>();
        List<String> liste_nom = new ArrayList<>();
        List<String> liste_surnom = new ArrayList<>();
        List<String> liste_tournoi = new ArrayList<>();
        
        lectureFichier(liste_prenom, "prenom.txt");
        lectureFichier(liste_nom, "nom.txt");
        lectureFichier(liste_surnom, "surnom.txt");
        lectureFichier(liste_tournoi, "tournoi.txt");

        
        ArrayList<Boxeur> ListBoxeur=new ArrayList<>();
        ArrayList<Spectateur> ListSpectateur=new ArrayList<>();
        ArrayList<Arbitre> ListArbitre=new ArrayList<>();
        ArrayList<Tournoi> ListTournoi=new ArrayList<>();
        
        Tournoi tournoi1 = new Tournoi("Madison Square Garden", ListBoxeur, ListArbitre, ListSpectateur);
        Tournoi tournoi2 = new Tournoi("Championnats du monde", ListBoxeur, ListArbitre, ListSpectateur);
        Tournoi tournoi3 = new Tournoi("JO", ListBoxeur, ListArbitre, ListSpectateur);
        ListTournoi.add(tournoi1);
        ListTournoi.add(tournoi2);
        ListTournoi.add(tournoi3);
        
        
        
        boolean quitter_programme = false;
        System.out.println("BONJOUR A VOUS UTILISATEUR !!");
        System.out.println(" ");
        //Utilisation de l'interface
        Interface annonce_initiale = new Interface();
        annonce_initiale.revelationAuteursCode();
        
        while(quitter_programme == false){
                       

            
            Scanner keyboard = new Scanner(System.in); //initialisation du keyboard afin que l'utilisateur puisse interagir avec le programme

            
            System.out.println(" ");
            System.out.println("MENU");
            System.out.println(" ");
            System.out.println("Que voulez-vous faire ?");
            System.out.println(" ");
            System.out.println("--------------------------->Creation");
            System.out.println("--------------------------->Jouer");
            System.out.println("--------------------------->Infos");
            System.out.println("--------------------------->Quitter");
            //long debut = System.currentTimeMillis();

            //Création d'un menu
            String choix_menu = keyboard.nextLine();

            while (!choix_menu.equals("Creation") & !choix_menu.equals("Jouer") & !choix_menu.equals("Infos") & !choix_menu.equals("Quitter")) {
                System.out.println("Veuillez répondre correctement (respectez la syntaxe et l'orthographe !) ");
                choix_menu = keyboard.nextLine();
            }

            //MENU CREATION 
            if (choix_menu.equals("Creation")) {
                System.out.println("VOUS ETES DANS LE MENU CREATION :");
                System.out.println("Vous avez la possibilité de créer une personne ou un tournoi, que voulez-vous faire ?");
                System.out.println(" ");
                System.out.println("--------------------------->Personne");
                System.out.println("--------------------------->Tournoi");
                System.out.println(" ");
                String choix_creation = keyboard.nextLine();

                while (!choix_creation.equals("Personne") & !choix_creation.equals("Tournoi")) {
                    System.out.println("Veuillez répondre correctement à la question : Voulez-vous créer une Personne ou un Tournoi ?");
                    System.out.println(" ");
                    choix_creation = keyboard.nextLine();
                }

                if (choix_creation.equals("Personne")) {
                    System.out.println("VOUS ETES DANS LE MENU CREATION DE PERSONNE :");
                    System.out.println(" ");
                    System.out.println("--------------------------->Boxeur");
                    System.out.println("--------------------------->Arbitre");
                    System.out.println("--------------------------->Spectateur");
                    System.out.println(" ");
                    String choix_creation_personne = keyboard.nextLine();

                    if (!choix_creation_personne.equals("Boxeur") & !choix_creation_personne.equals("Juge") & !choix_creation_personne.equals("Arbitre") & !choix_creation_personne.equals("Spectateur")) {
                        System.out.println("Veuillez répondre correctement à la question : Quel type de personne voulez-vous créer ?");
                        System.out.println(" ");
                        choix_creation = keyboard.nextLine();
                    } else if (choix_creation_personne.equals("Boxeur")) {
                        System.out.println("VOUS ETES DANS LE MENU CREATION DE BOXEUR :");
                        System.out.println(" ");
                        System.out.println("Quelle méthode voulez-vous utiliser ?");
                        System.out.println(" ");
                        System.out.println("--------------------------->Manuelle");
                        System.out.println("--------------------------->Automatique");
                        System.out.println(" ");
                        String choix_creation_personne_methode = keyboard.nextLine();

                        while (!choix_creation_personne_methode.equals("Manuelle") & !choix_creation_personne_methode.equals("Automatique")) {
                            System.out.println("Veuillez répondre correctement à la question : Voulez-vous créer une personne de manière manuelle ou automatique ?");
                            System.out.println(" ");
                            choix_creation_personne_methode = keyboard.nextLine();
                        }

                        if (choix_creation_personne_methode.equals("Manuelle")) {

                            System.out.println("prenom ?");
                            String creation_prenom = keyboard.nextLine();

                            System.out.println("nom ?");
                            String creation_nom = keyboard.nextLine();

                            System.out.println("surnom ?");
                            String creation_surnom = keyboard.nextLine();

                            System.out.println("Main dominante ? (droite ou gauche)");
                            String creation_main = keyboard.nextLine();
                            while ((!creation_main.equals("gauche")) & (!creation_main.equals("droite"))) {
                                System.out.println("Erreur, Main dominante ? (droite ou gauche)");
                                creation_main = keyboard.nextLine();
                            }

                            System.out.println("Jour de naissance ?");
                            int creation_journaissance = entreeClavier(1, 28, "Jour de naissance");

                            System.out.println("Mois de naissance ?");
                            int creation_moisnaissance = entreeClavier(1, 12, "Mois de naissance");

                            System.out.println("Année de naissance (entre 1980 et 2002) ?");
                            int creation_anneenaissance = entreeClavier(1980, 2002, "Année de naissance");

                            String creation_datedeNaissance = "p" + creation_anneenaissance + "y" + creation_moisnaissance + "m" + creation_journaissance + "d";

                            System.out.println("Poids (Supérieur à 65) ?");
                            int creation_poids = entreeClavier(65, 81, "Poids (Supérieur à 65)");

                            System.out.println("Solidite (entre 10 et 100) ?");
                            int creation_solidite = entreeClavier(10, 100, "Solidite (entre 10 et 100)");

                            System.out.println("Endurance (entre 10 et 100) ?");
                            int creation_endurance = entreeClavier(10, 100, "Endurance (entre 10 et 100)");

                            System.out.println("Vitesse (entre 10 et 100) ?");
                            int creation_vitesse = entreeClavier(10, 100, "Vitesse (entre 10 et 100)");

                            System.out.println("Force (entre 10 et 100) ?");
                            int creation_force = entreeClavier(10, 100, "Force (entre 10 et 100)");

                            //int creation_classement = 1;
                            compteur_boxeur++;
                            Boxeur boxeurc = new Boxeur(creation_nom, creation_prenom, creation_datedeNaissance, creation_poids, creation_surnom, creation_main, compteur_boxeur, creation_solidite, creation_endurance, creation_vitesse, creation_force, 0, 0, 0, 0);
                            ListBoxeur.add(boxeurc);
           
                        } else if (choix_creation_personne_methode.equals("Automatique")) {
                            
                                String prenomb = Personne.prenom(liste_prenom);
                                String nomb = Personne.nom(liste_nom, compteur_boxeur);
                                String surnomb = Personne.prenom(liste_surnom);
                                String dateDeNaissance = Personne.dateNaissance();
                                int poids = Boxeur.poids_legers();
                                String main_dominante = Boxeur.main_dominante();
                                int solidite = Boxeur.capacite();
                                int force = Boxeur.capacite();
                                int endurance = Boxeur.capacite();
                                int vitesse = Boxeur.capacite();
                                int victoire = 0;
                                int defaite = 0;
                                int attaque = 0;
                                int encaisse = 0;

                                Boxeur boxeur = new Boxeur(nomb, prenomb, dateDeNaissance, poids, surnomb, main_dominante, compteur_boxeur + 1, solidite, endurance, vitesse, force, victoire, defaite, attaque, encaisse);
                                affichage_auto_boxeur(boxeur);
                                compteur_boxeur++;
                                ListBoxeur.add(boxeur);

                            }

                     

                    } else if (choix_creation_personne.equals("Arbitre")) {
                        System.out.println("VOUS ETES DANS LE MENU CREATION D'ARBITRE :");
                        System.out.println(" ");
                        System.out.println("Quelle méthode voulez-vous utiliser ?");
                        System.out.println(" ");
                        System.out.println("--------------------------->Manuelle");
                        System.out.println("--------------------------->Automatique");
                        System.out.println(" ");
                        String choix_creation_personne_methode = keyboard.nextLine();

                        while (!choix_creation_personne_methode.equals("Manuelle") & !choix_creation_personne_methode.equals("Automatique")) {
                            System.out.println("Veuillez répondre correctement à la question : Voulez-vous créer un arbitre de manière manuelle ou automatique ?");
                            System.out.println(" ");
                            choix_creation_personne_methode = keyboard.nextLine();
                        }

                        if (choix_creation_personne_methode.equals("Manuelle")) {
                            System.out.println("prenom ?");
                            String creation_prenom_a = keyboard.nextLine();

                            System.out.println("nom ?");
                            String creation_nom_a = keyboard.nextLine();

                            System.out.println("Jour de naissance ?");
                            int creation_journaissance_a = entreeClavier(1, 28, "Jour de naissance");

                            System.out.println("Mois de naissance ?");
                            int creation_moisnaissance_a = entreeClavier(1, 12, "Mois de naissance");

                            System.out.println("Année de naissance ?");
                            int creation_anneenaissance_a = entreeClavier(1921, 2021, "Année de naissance");

                            String creation_datedeNaissance_a = "p" + creation_anneenaissance_a + "y" + creation_moisnaissance_a + "m" + creation_journaissance_a + "d";

                            compteur_arbitre++;
                            Arbitre arbitre = new Arbitre(creation_nom_a, creation_prenom_a, creation_datedeNaissance_a, compteur_arbitre);
                            ListArbitre.add(arbitre);

                        } else if (choix_creation_personne_methode.equals("Automatique")) {
                            String prenom_a = Personne.prenom(liste_prenom);
                            String nom_a = Personne.nom(liste_nom, rd.nextInt(liste_nom.size()));
                            String dateDeNaissance_a = Personne.dateNaissance();
                            
                            compteur_arbitre++;
                            Arbitre arbitre = new Arbitre(nom_a, prenom_a, dateDeNaissance_a, compteur_arbitre);
                            ListArbitre.add(arbitre);

                        }
                    } else if (choix_creation_personne.equals("Spectateur")) {
                        System.out.println("VOUS ETES DANS LE MENU CREATION DE SPECTATEUR :");
                        System.out.println(" ");
                        System.out.println("Quelle méthode voulez-vous utiliser ?");
                        System.out.println(" ");
                        System.out.println("--------------------------->Manuelle");
                        System.out.println("--------------------------->Automatique");
                        System.out.println(" ");
                        String choix_creation_personne_methode = keyboard.nextLine();

                        while (!choix_creation_personne_methode.equals("Manuelle") & !choix_creation_personne_methode.equals("Automatique")) {
                            System.out.println("Veuillez répondre correctement à la question : Voulez-vous créer un spectateur de manière manuelle ou automatique ?");
                            System.out.println(" ");
                            choix_creation_personne_methode = keyboard.nextLine();
                        }

                        if (choix_creation_personne_methode.equals("Manuelle")) {
                            System.out.println("prenom ?");
                            String creation_prenom_s = keyboard.nextLine();

                            System.out.println("nom ?");
                            String creation_nom_s = keyboard.nextLine();

                            System.out.println("Jour de naissance ?");
                            int creation_journaissance_s = entreeClavier(1, 28, "Jour de naissance");

                            System.out.println("Mois de naissance ?");
                            int creation_moisnaissance_s = entreeClavier(1, 12, "Mois de naissance");

                            System.out.println("Année de naissance ?");
                            int creation_anneenaissance_s = entreeClavier(1921, 2021, "Année de naissance");

                            String creation_datedeNaissance_s = "p" + creation_anneenaissance_s + "y" + creation_moisnaissance_s + "m" + creation_journaissance_s + "d";

                            System.out.println("Tribune (a, b, c ou d) ?");
                            String creation_tribune_s = keyboard.nextLine();
                            while ((!creation_tribune_s.equals("a")) & (!creation_tribune_s.equals("b")) & (!creation_tribune_s.equals("c")) & (!creation_tribune_s.equals("d"))) {
                                System.out.println("Erreur, Tribune (a, b, c ou d) ?");
                                creation_tribune_s = keyboard.nextLine();
                            }
                            char creation_tribune = creation_tribune_s.charAt(0);
                            System.out.println("Numéro du siège (entre 1 et 100) ?");
                            int creation_numero = entreeClavier(1, 100, "Numéro du siège (entre 1 et 100)");
                            Spectateur spectateur1 = new Spectateur(creation_nom_s, creation_prenom_s, creation_datedeNaissance_s, creation_tribune, creation_numero);
                            ListSpectateur.add(spectateur1);
                            compteur_spectateur ++;

                        } else if (choix_creation_personne_methode.equals("Automatique")) {
                                String prenom_s = Personne.prenom(liste_prenom);
                                String nom_s = Personne.nom(liste_nom, rd.nextInt(liste_nom.size()));
                                String dateDeNaissance = Spectateur.dateNaissanceSpectateur();
                                char tribune = Spectateur.tribune();
                                int numero = Spectateur.siege();
                                Spectateur spectateur1 = new Spectateur(nom_s, prenom_s, dateDeNaissance, tribune, numero);
                                ListSpectateur.add(spectateur1);
                                compteur_spectateur ++;

                        }

                    }
                } else if (choix_creation.equals("Tournoi")) {
                    System.out.println("VOUS ETES DANS LE MENU CREATION DE TOURNOI :");
                    System.out.println(" ");
                    System.out.println("Quelle méthode voulez-vous utiliser ?");
                    System.out.println(" ");
                    System.out.println("--------------------------->Manuelle");
                    System.out.println("--------------------------->Automatique");
                    System.out.println(" ");
                    String choix_creation_tournoi_methode = keyboard.nextLine();

                    while (!choix_creation_tournoi_methode.equals("Manuelle") & !choix_creation_tournoi_methode.equals("Automatique")) {
                        System.out.println("Veuillez répondre correctement à la question : Voulez-vous créer un tournoi de manière manuelle ou automatique ?");
                        System.out.println(" ");
                        choix_creation_tournoi_methode = keyboard.nextLine();
                    }

                    if (choix_creation_tournoi_methode.equals("Manuelle")) {
                        System.out.println("Nom du tournoi ?");
                        String nom_tournoi_m = keyboard.nextLine();
                        Tournoi tournoi = new Tournoi(nom_tournoi_m, ListBoxeur, ListArbitre, ListSpectateur);
                        ListTournoi.add(tournoi);
                        System.out.println(" ");
                        System.out.println("Vous venez de creer le tournoi : " + nom_tournoi_m);

                    } else if (choix_creation_tournoi_methode.equals("Automatique")) {
                        String nom_tournoi_a = Personne.prenom(liste_tournoi);
                        Tournoi tournoi4 = new Tournoi(nom_tournoi_a, ListBoxeur, ListArbitre, ListSpectateur);
                        ListTournoi.add(tournoi4);
                        System.out.println(" ");
                        System.out.println("Vous venez de creer le tournoi : " + nom_tournoi_a);

                    }

                }
            } //MENU JEU
            else if (choix_menu.equals("Jouer")) {
                //Création des joueurs manquants afin d'atteindre les 128
                while (compteur_boxeur < 128){
                    String prenomb = Personne.prenom(liste_prenom);
                    String nomb = Personne.nom(liste_nom, compteur_boxeur);
                    String surnomb = Personne.prenom(liste_surnom);
                    String dateDeNaissance = Personne.dateNaissance();
                    int poids = Boxeur.poids_legers();
                    String main_dominante = Boxeur.main_dominante();
                    int solidite = Boxeur.capacite();
                    int force = Boxeur.capacite();
                    int endurance = Boxeur.capacite();
                    int vitesse = Boxeur.capacite();
                    compteur_boxeur ++;
                    Boxeur boxeur = new Boxeur(nomb, prenomb, dateDeNaissance, poids, surnomb, main_dominante, compteur_boxeur, solidite, endurance, vitesse, force, 0, 0, 0, 0);
                    ListBoxeur.add(boxeur);
                }
                
                
                //Création des arbitres manquants
                while (compteur_arbitre < 10){
                    String prenom_a = Personne.prenom(liste_prenom);
                    String nom_a = Personne.nom(liste_nom, compteur_arbitre);
                    String dateDeNaissance_a = Personne.dateNaissance();
                    compteur_arbitre ++;
                    Arbitre arbitre = new Arbitre(nom_a, prenom_a, dateDeNaissance_a, compteur_arbitre);
                    ListArbitre.add(arbitre);
                }
                
                
                //Création des spectateurs manquants
                Random alea = new Random();
                for (int k=compteur_spectateur; k<alea.nextInt(200 - 50) + 15; k++){
                    String prenom_s = Personne.prenom(liste_prenom);
                    String nom_s = Personne.nom(liste_nom, k);
                    String dateDeNaissance_a = Spectateur.dateNaissance();
                    char tribune = Spectateur.tribune();
                    int numero = Spectateur.siege();

                    Spectateur spectateur = new Spectateur(nom_s, prenom_s, dateDeNaissance_a, tribune, numero);
                    ListSpectateur.add(spectateur);
                }
                //ANNONCE COMBAT PUIS CHOIX MANUEL/AUTO
                System.out.println("Choisir un tournoi (entrez son numéro)");
                for (int i = 0; i < ListTournoi.size(); i++) {
                    System.out.println((i + 1) + " Tournoi " + (ListTournoi.get(i)).getNomTournoi());
                }
                int choix_tournoi = entreeClavier(1, ListTournoi.size() + 1, "Choix du tournoi");
                String nom_tournoi = (ListTournoi.get(choix_tournoi - 1)).getNomTournoi();
                
                System.out.println(" ");
                System.out.println("On commence le tournoi !!");
                System.out.println(" ");
                Tournoi tournoi = new Tournoi(nom_tournoi, ListBoxeur,ListArbitre,ListSpectateur);
                tournoi.deroulementTournoi(nom_tournoi);
                

            } //MENU INFOS ET STATS
            else if (choix_menu.equals("Infos")) {
                for(int i = 0; i<ListBoxeur.size(); i++){
                    affichage_auto_boxeur(ListBoxeur.get(i));
                    System.out.println(" ");
                }
                

            } //MENU INFOS ET STATS
            else if (choix_menu.equals("Quitter")) {
                System.out.println("!! Vous allez quitter le jeu... !!");
                quitter_programme = true;
            }


        }           
    }
    
    
}