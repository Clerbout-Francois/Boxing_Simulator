/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boxsimulator;
/**
 *
 * @author clerb
 */
public class Arbitre extends Personne implements Introduce {
    private int reputation;
    
    /**
     * Constructeur Arbitre, impossible à créer sans les paramètres
     * @param nom nom de l'arbitre
     * @param prenom prenom de l'arbitre
     * @param dateNaissance date de naissance de l'arbitre
     * @param reputation reputation (classement) de l'arbitre
     */
    public Arbitre(String nom, String prenom, String dateNaissance, int reputation){
        super(nom, prenom, dateNaissance);
        this.reputation = reputation;
        introduceYourself();
    }
    
    /**
     * L'arbitre se présente
     */
    @Override
    public void introduceYourself(){
        //super.introduceYourself();
        System.out.println("Salut tout le monde, je m'appelle " + prenom + " " + nom + " et je serai l'arbitre aujourd'hui.");
        System.out.println(" ");
    }
    
    /**
     * Accéder à la réputation de l'arbitre
     * @return reputation arbitre
     */
    public int getReputation(){
        return reputation;
    }

    /**
     * Mutation de la réputation de l'arbitre
     * @param reputation reputation arbitre
     */
    public void setReputation(int reputation){
        this.reputation = reputation;
    }
    
    
        
}
