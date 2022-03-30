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

public class Combat {
    private double boxeur1BONUS;
    private double boxeur2BONUS;
    double boxeur1BonusDeMain = 1;
    double boxeur2BonusDeMain = 1;
    double boxeur1BonusEndurance = 1;
    double boxeur2BonusEndurance = 1;
    double boxeur1BonusVitesse = 1;
    double boxeur2BonusVitesse = 1;
    double boxeur1BonusForce = 1;
    double boxeur2BonusForce = 1;
    
    /**
     * Constructeur Combat, impossible à créer sans les paramètres
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param arbitre arbitre
     */
    public Combat(Boxeur boxeur1, Boxeur boxeur2, Arbitre arbitre){
        
        
    }
    
    
    
    /**
     * Calcul du bonus du boxeur 1 par rapport au boxeur 2
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @return le bonus du boxeur 1
     */
    public double calculBonus1(Boxeur boxeur1, Boxeur boxeur2){
        
        if (boxeur1.getMain() != boxeur2.getMain()){
            if (boxeur1.getMain().equals("gauche")){
                boxeur1BonusDeMain = 1.9;
                boxeur2BonusDeMain = 1;
            }
            else if (boxeur2.getMain().equals("gauche")){
                boxeur1BonusDeMain = 1;
                boxeur2BonusDeMain = 1.9;
            }
        }
        else{
            boxeur1BonusDeMain = 1;
            boxeur2BonusDeMain = 1;
        }
        
        
        int differenceEndurance = Math.abs((boxeur1.getEndurance() - boxeur2.getEndurance()));
        if ((differenceEndurance > 15) & (boxeur1.getEndurance() > boxeur2.getEndurance())){
            boxeur1BonusEndurance = 1.4;
            boxeur2BonusEndurance = 1;
        }
        else if ((differenceEndurance > 15) & (boxeur1.getEndurance() < boxeur2.getEndurance())){
            boxeur1BonusEndurance = 1;
            boxeur2BonusEndurance = 1.4;
        }
        else if(differenceEndurance <= 15){
            boxeur1BonusEndurance = 1;
            boxeur2BonusEndurance = 1;
        }
        
        
        int differenceVitesse = Math.abs((boxeur1.getVitesse() - boxeur2.getVitesse()));
        if ((differenceVitesse > 15) & (boxeur1.getVitesse() > boxeur2.getVitesse())){
            boxeur1BonusVitesse = 1.4;
            boxeur2BonusVitesse = 1;
        }
        else if ((differenceVitesse > 15) & (boxeur1.getVitesse() < boxeur2.getVitesse())){
            boxeur1BonusVitesse = 1;
            boxeur2BonusVitesse = 1.4;
        }
        else if(differenceVitesse <= 15){
            boxeur1BonusVitesse = 1;
            boxeur2BonusVitesse = 1;
        }
        
        
        int differenceForce = Math.abs((boxeur1.getForce() - boxeur2.getForce()));
        if ((differenceForce > 15) & (boxeur1.getForce() > boxeur2.getForce())){
            boxeur1BonusForce = 1.4;
            boxeur2BonusForce = 1;
        }
        else if ((differenceForce > 15) & (boxeur1.getForce() < boxeur2.getForce())){
            boxeur1BonusForce = 1;
            boxeur2BonusForce = 1.4;
        }
        else if(differenceForce <= 15){
            boxeur1BonusForce = 1;
            boxeur2BonusForce = 1;
        }
        
        
        //CALCUL DU BONUS TOTAl
        boxeur1BONUS = boxeur1BonusDeMain * boxeur1BonusEndurance * boxeur1BonusVitesse * boxeur1BonusForce ;
        return boxeur1BONUS;
    
    }
    
    /**
     * Calcul du bonus du boxeur 2 par rapport au boxeur 1
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @return bonus boxeur 2
     */
    public double calculBonus2(Boxeur boxeur1, Boxeur boxeur2){
            
        if (boxeur1.getMain() != boxeur2.getMain()){
            if (boxeur1.getMain().equals("gauche")){
                boxeur1BonusDeMain = 1.9;
                boxeur2BonusDeMain = 1;
            }
            else if (boxeur2.getMain().equals("gauche")){
                boxeur1BonusDeMain = 1;
                boxeur2BonusDeMain = 1.9;
            }
        }
        else{
            boxeur1BonusDeMain = 1;
            boxeur2BonusDeMain = 1;
        }
        
        
        int differenceEndurance = Math.abs((boxeur1.getEndurance() - boxeur2.getEndurance()));
        if ((differenceEndurance > 15) & (boxeur1.getEndurance() > boxeur2.getEndurance())){
            boxeur1BonusEndurance = 1.4;
            boxeur2BonusEndurance = 1;
        }
        else if ((differenceEndurance > 15) & (boxeur1.getEndurance() < boxeur2.getEndurance())){
            boxeur1BonusEndurance = 1;
            boxeur2BonusEndurance = 1.4;
        }
        else if(differenceEndurance <= 15){
            boxeur1BonusEndurance = 1;
            boxeur2BonusEndurance = 1;
        }
        
        
        int differenceVitesse = Math.abs((boxeur1.getVitesse() - boxeur2.getVitesse()));
        if ((differenceVitesse > 15) & (boxeur1.getVitesse() > boxeur2.getVitesse())){
            boxeur1BonusVitesse = 1.4;
            boxeur2BonusVitesse = 1;
        }
        else if ((differenceVitesse > 15) & (boxeur1.getVitesse() < boxeur2.getVitesse())){
            boxeur1BonusVitesse = 1;
            boxeur2BonusVitesse = 1.4;
        }
        else if(differenceVitesse <= 15){
            boxeur1BonusVitesse = 1;
            boxeur2BonusVitesse = 1;
        }
        
        
        int differenceForce = Math.abs((boxeur1.getForce() - boxeur2.getForce()));
        if ((differenceForce > 15) & (boxeur1.getForce() > boxeur2.getForce())){
            boxeur1BonusForce = 1.4;
            boxeur2BonusForce = 1;
        }
        else if ((differenceForce > 15) & (boxeur1.getForce() < boxeur2.getForce())){
            boxeur1BonusForce = 1;
            boxeur2BonusForce = 1.4;
        }
        else if(differenceForce <= 15){
            boxeur1BonusForce = 1;
            boxeur2BonusForce = 1;
        }
        
        
        //CALCUL DU BONUS TOTAl
        return boxeur2BONUS = boxeur2BonusDeMain * boxeur2BonusEndurance * boxeur2BonusVitesse * boxeur2BonusForce ;
        
    
    }
    
    /**
     * Choix du boxeur qu'on veut controler
     * @param boxeur1 premier boxeur
     * @param boxeur2 deuxieme boxeur
     * @param couleur couleur du coin choisi
     */
    public void controlBoxeur(Boxeur boxeur1, Boxeur boxeur2, String couleur){
        boxeur1.getNom();
        boxeur1.getPrenom();
        boxeur1.getSurnom();
        boxeur2.getNom();
        boxeur2.getPrenom();
        boxeur2.getSurnom();
        if (couleur == "CB"){
            System.out.println("Le boxeur que vous allez contrôler est le boxeur du coin bleu : " + boxeur1.getNom() + " " + boxeur1.getPrenom());
            System.out.println(" ");
                 
        }
        else if(couleur == "CR"){
            System.out.println("Le boxeur que vous allez contrôler est le boxeur du coin rouge : " + boxeur2.getNom() + " " + boxeur2.getPrenom());
            System.out.println(" ");
        }
    }
    
    /**
     * Présentation des deux boxeurs
     * @param boxeur1 prmeier boxeur
     * @param boxeur2 deuxieme boxeur
     */
    public void annonceBoxeurs(Boxeur boxeur1, Boxeur boxeur2){
        
        if (boxeur1.getSurnom().equals(" ")){
            System.out.println("Le boxeur du coin bleu est : " + boxeur1.getNom() + " " + boxeur1.getPrenom() + ".");
        }
        else if (!boxeur1.getSurnom().equals(" ")){
            System.out.println("Le boxeur du coin bleu est : " + boxeur1.getNom() + " " + boxeur1.getPrenom() + " AKA " + boxeur1.getSurnom() + ".");
        }
        if (boxeur2.getSurnom().equals(" ")){
            System.out.println("Le boxeur du coin rouge est : " + boxeur2.getNom() + " " + boxeur2.getPrenom() + ".");
        }
        else if (!boxeur2.getSurnom().equals(" ")){
            System.out.println("Le boxeur du coin rouge est : " + boxeur2.getNom() + " " + boxeur2.getPrenom() + " AKA " + boxeur2.getSurnom() + ".");
        }
        System.out.println(" ");
        }

    /**
     * Accéder au bonus boxeur 1
     * @return bonus boxeur 1
     */
    public double getBoxeur1BONUS() {
        return boxeur1BONUS;
    }

    /**
     * Mutation du bonus boxeur 1
     * @param boxeur1BONUS bonus boxeur 1
     */
    public void setBoxeur1BONUS(double boxeur1BONUS) {
        this.boxeur1BONUS = boxeur1BONUS;
    }

    /**
     * Accéder au bonus boxeur 2
     * @return bonus boxeur 2
     */
    public double getBoxeur2BONUS() {
        return boxeur2BONUS;
    }

    /**
     * Mutation du bonus boxeur 2
     * @param boxeur2BONUS bonus boxeur 2
     */
    public void setBoxeur2BONUS(double boxeur2BONUS) {
        this.boxeur2BONUS = boxeur2BONUS;
    }
        
        
        
}

    
    
    

