# Box Simulator

<a name="table_of_contents"/>

## Table of Contents
1. [Instructions](#instructions_)
2. [Introduction](#introduction_)
3. [Class diagram](#class_diagram) 
4. [Development](#development_)
5. [Conclusion](#conclusion_)
6. [License](#license_)



<a name="instructions_"/>

## Instructions

For this BoxSimulator program to work properly, the .txt files must be placed in the src folder (as shown in the following figure).

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image1.png?raw=true)

_Figure 1: Photograph to indicate the placement of the program's .txt files._


[Table of Contents](#table_of_contents)
<a name="introduction_"/>

## Introduction

This project aims to allow the user to create, manually or automatically, people (boxers, referees and spectators) and tournaments. It should also allow the user to play or not the fights, to control each boxer and thus to try to beat his opponent in order to obtain a newspaper article recounting his exploit.

We chose to carry out this project because it seemed ambitious to us and we were keen to take up this challenge. We were also particularly interested in this sports-related project because we are both sportsmen and women and are keen to discover new activities.

[Table of Contents](#table_of_contents)
<a name="class_diagram"/>

## Class diagram

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image2.png?raw=true)

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image9.png?raw=true)

_Figure 2: Class diagram of the Java program "BoxSimulator"._


In each class, getter and setter methods have been created where necessary. They allow to retrieve or modify information.

[Table of Contents](#table_of_contents)

### The Personne class

In this parent class the goal was to define the attributes of a person in our program. To do this, we decided that a person must have a name, a first name and a date of birth to be created.

We have created three methods which are the following: String **dateNaissance()**, String **nom()** and String **prenom()**.

 * String **dateNaissance()** : this method aims to return a random date of birth when the program calls it. It creates a date of birth ranging from 1980 to 2002. It returns a String of the form pYearyMonthmDayd which our program will use in order to calculate the age of the person in order to introduce itself or if the user requests to see the boxers' information.
      
* String **nom()** : this method allows us to retrieve a name from a list of names. It also returns a String. Thus each person is different because there are only different names.
      
* String **prenom()** : this method allows to retrieve a random first name from a list of first names. It returns a String. 

[Table of Contents](#table_of_contents)
***
### The Boxeur class

In this class, heir of the Person class and implementing the Introduce interface, the goal was to define the attributes of a boxer. By extension of the parent class, a Boxer has a name, a first name and a date of birth. In addition, a boxer has a weight, a nickname (or not), a dominant hand, a ranking, abilities (toughness, stamina, strength and speed), as well as statistics (number of wins, losses, number of punches landed and number of punches landed).

We have created several methods in this class to randomly create these attributes: int **poids_legers()**, int **poids_moyens()**, int **poids_lourds()**, int **capacite()** and String **main_dominante()**.

* Int **poids_legers()**, int **poids_moyens()**, int **poids_lourds()** : these are three methods which allow to randomly generate a weight according to the category. Between 65kg and 80kg for light weights, between 81kg and 100kg for the next category, then for the heavy weight category, a weight between 101kg and 150kg is generated.

* int **capacite()** : this method is used to generate an ability (strength, force, speed and endurance) between 10 and 100. We have chosen to define these abilities as a percentage.
      
* String **main_dominante()** : using a boolean, this method returns the dominant hand (left or right).

[Table of Contents](#table_of_contents)
***
### The Arbitre class

The Referee class inherits from the Person class and implements the Introduce interface which will be described later. By extension of the Person class, a referee also has a name, a first name and a date of birth. In this class, it is considered that a referee cannot be created if he does not have a reputation in addition to the previously required parameters within the Person class, the lower his reputation the better he is (this works like the ranking for a boxer).

[Table of Contents](#table_of_contents)
***
### The Spectateur class 

The Spectator class also inherits from the Person class and also implements the Introduce interface. By extension of the Person class, a spectator also has a name, a first name and a date of birth. We also consider that a spectator cannot be created without a ticket (i.e. a stand defined by a letter from a to d inclusive and a seat number between 1 and 100 inclusive).

We have created different methods which are the following: String **dateNaissanceSpectateur()**, char **tribune()**, int **siege()** and void **crieAge()**.

* String **dateNaissanceSpectateur()** : this method aims to create a random date of birth between 1930 and 2018 because even a baby can come with his parents to attend a boxing tournament (let's imagine that the dad is a Rocky fan...) and it returns a String of the form pYearyMonthmDayd.

* char **tribune()** : this method returns a random letter in a and d included in order to identify the place of the spectator.

* int **siege()** : this method returns a random number between 1 and 100, this number completes the tribune letter.
      
* void **crieAge()** : this method takes as a parameter the date of birth of the spectator in order to display a message when a spectator is created. This message is personalised according to the age of the spectator created.

[Table of Contents](#table_of_contents)
***
### The Combat class

The Combat class makes a combat have as parameters two boxers and a referee. In this class, we have created several methods to help us to give the fairest possible advantage to a boxer who is stronger than his opponent in order to make the game as realistic as possible, as a boxing match is not only related to chance but also to the intrinsic abilities of each candidate.

This is why we have created the following methods: double **calculBonus1()**, double **calculBonus2()**, void **controlBoxeur()** and void **annonceBoxeurs()**.

* double **calculBonus1()** and double **calculBonus2()** : this method takes two boxers as parameters. We had decided to create boxers with different attributes and physical and sporting capacities: the dominant hand (left or right), solidity (= resistance to blows from the opponent), strength, speed and endurance. At the heart of our code, during a fight the attributes (dominant hand) and abilities (strength, speed and stamina) of the two boxers are compared in order to determine a bonus that will favour the boxer with the most physical or sporting abilities (of course the proportion of the population with a dominant left hand being low, this leads to a considerable advantage and therefore a significant bonus). For the three abilities of strength, speed and stamina, a bonus is given if the ability of one fighter is at least 15 higher than the same ability of the other fighter. This calculated bonus is then reused in the fight. The bonus of a boxer is thus specific to a fight, it varies according to the boxer encountered. This gives an advantage to the strongest boxer. These two methods thus return the bonus of each boxer for this combat precisely.

* void **controlBoxeur()** : this method allows the program to display the name, the first name and the corner of the boxer that the user has chosen to control in manual mode.
      
* void **annonceBoxeurs()** : this method allows the program to display the name, the first name and the nickname of the two boxers when announcing a fight and presenting the two boxers.

[Table of Contents](#table_of_contents)
***
### The Round class

The Round class is the heir of the Combat class. The purpose of this class was to designate the winner of each round (the fights all took place in 3 rounds, an odd number allowing to designate a winner even by judges' decision if there was no boxer knocked out). During a round the boxer who attacks is determined randomly and once one of the two boxers has attacked 5 times (no matter if he succeeds or not), the round ends. The punches thrown are determined randomly and are 3 in number (jab, hook and uppercut: ranked in ascending order of damage caused) as is the area of the body targeted (body and face, again ranked in ascending order of damage). The damage value of the blow is multiplied by the damage value of the target area and then by the fighter's bonus obtained using the Combat class method.

During the course of a fight, at the end of a round, if no fighter is knocked out, the judges must decide the winner of the round. To do this they compare the damage inflicted by each fighter on the other. If a boxer inflicts strictly 7 more damages than his opponent then he is declared winner of the round. In the case where the boxers do not have a significant tie, the winner of the round is declared randomly using a Boolean. At the end of the fight, the number of rounds won is useful to determine the winner of the fight (if there is no KO).

We then distinguish 2 cases: the **automatic running** of a fight and the **manual running** of a fight.

**In the case of automatic match play,** it is again determined randomly whether the blow hits its target or not. If the punch hits its target, the strength of the hit fighter is reduced by the value of the punch (damage specific to the style of punch * damage specific to the area hit * bonus specific to the fighter who struck the punch), otherwise the strength of the attacked fighter is not modified.

The user can choose to display or not the details of the match: in the case of the visualization of the details of a match, the user observes the blows carried out and their success or not, that results in messages of announcement of blow personalized according to the type of blow sent as well as the zone aimed at. The message indicating the success or failure of a move is also personalised (two possibilities for failure). If the user chooses not to see the details of a fight, they will only see the winner's announcement. If one of the two fighters is knocked out (if he sees his strength become negative or null due to hits) by his opponent, a personalised message is displayed. If he wins by decision of the judges a different customised message is displayed.

**In the case of a manual match,** the program informs the user of the rules of the game or rather the instructions (random lower case letter and maximum time allowed for the entry of the letter also determined randomly) to be respected in order to play.

The user then chooses to control a boxer (either the boxer in the blue corner or the boxer in the red corner, these colours were chosen because they are the colours of the "neutral corners" of Olympic boxing). Messages are then displayed indicating the type of blow attempted, the area targeted or whether and how the opponent is attacking. It also indicates the lower case letter that the user must enter in order to successfully attack, or dodge, and the time allowed for this entry. If the user enters the wrong letter, enters too many letters, enters another character or takes longer than the allowed time, the attack or dodge attempt will fail (a personalised message is displayed). If not, his attack or dodge will be successful and he will see personalised displays.

It is for all these reasons that we have created methods: Boxeur **affichageDetailsCombat()**, Boxeur **affichageSansDetailsCombat()**, Boxeur **controlManuelCombatBoxeur1()** and Boxeur **controlManuelCombatBoxeur2()**.

These 4 methods return the winner of the fight in order to be able to organise the following fights (between the winners and this time in an ordered way, the winner of the first fight against the winner of the second fight and so on until the final). It is in these methods that the different messages are displayed and the name of the winner is announced.

[Table of Contents](#table_of_contents)
***
### The Tournoi class

A tournament cannot be created without a name, a list of boxers, a list of referees and a list of spectators.

Within this class, we have created the following methods: void **deroulementTournoi()** et Boxeur **processus()**.

* void **deroulementTournoi()** : as its name indicates, this method allows us to manage the running of a tournament. It consists of random first round fights and then an organisation of the fights in the following way: the winner of the first fight of the first round against the winner of the second fight of the same first round and so on until the final.) By judiciously commenting on this method you can reduce the number of fights (from 64 fights in the first round to 32, 16, 8, 4 or even 2 or only one fight).
      
* Boxeur **processus()** : this method allows you to manage the user's choice for each match (automatic or manual) as well as the display or not of the details of a match in automatic mode.

[Table of Contents](#table_of_contents)
***
### The Introduce interface

This interface is used to reference the **introduceYourself()** method which is implemented in the Boxeur, Arbitre and Spectateur classes.

This **introduceYourself()** method allows a person, whether a Boxer, Referee or Spectator, to introduce themselves. The introduction of a person depends on his role but also on other parameters.

A boxer will introduce himself by announcing his first name, his last name and his nickname if he has one.

A referee will introduce himself by announcing his name and surname and also by specifying that he will be a referee.

A spectator will introduce himself in the following way, he will announce his name and surname and then according to a boolean he will say if he is interested in boxing or not.

[Table of Contents](#table_of_contents)
***
### The Annonce interface

This interface makes it possible to reference the method **revelationAuteursCode()** which displays at the very beginning of the program, as soon as it is launched, the name of the authors of this code as well as the framework of this project.

[Table of Contents](#table_of_contents)

<a name="development_"/>

## Development

When the program starts, the following menu is displayed:

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image3.png?raw=true)

_Figure 3: Menu displayed when the programme starts._

From this menu, the user can interact with the program.

We are going to present the different methods of the BoxSimulator class which are the following: void **affichage_auto_boxeur()**, void **lectureFichier()** and int **entreeClavier()**.

* void **affichage_auto_boxeur()** : this method takes a Boxer as a parameter, it displays a summary of all its attributes : name, first name, date of birth, age, weight, dominant hand, solidity, endurance, speed, strength, number of victory(s), number of defeat(s), number of hits received and number of significant strikes.

* void **lectureFichier()** : is a method that reads a .txt file and adds each line of this file to a list. This method uses an exception, to handle the error.

* and int **entreeClavier()**: this method asks the user to enter a number and checks that it matches the conditions requested (between two specified values). An exception is used to handle the case of a user who does not enter a number.

We will therefore move on to explain the main hand by producing a "manual" to guide you if necessary. The main menu is also equipped with an error management system to avoid any problems caused by incorrect entries.

You should distinguish between the different options available to you at this moment: **Creation**, **Jouer**, **Infos** and **Quitter**. We will explain the possibilities of each mode.

[Table of Contents](#table_of_contents)

### Creation mode

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image4.png?raw=true)

_Figure 4: Menu displayed once in Creation mode._

We still have to distinguish between 2 cases: the creation of a person, be it a boxer, a referee or a spectator, and the creation of a tournament.

We will use the example of the creation (manual and automatic) of a boxer, knowing that the creation of a referee, a spectator and a tournament works the same way.

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image5.png?raw=true)

_Figure 5: Menu displayed in Person Creation mode._

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image6.png?raw=true)

_Figure 6: Menu displayed to create a boxer._

The purpose of this program is to guide you step by step in the manual creation of a person (be it a boxer, a referee or a spectator) or to propose you the automatic creation of a boxer.

In the case of a **manual creation** of a boxer, the program will ask you for all the necessary parameters to create a boxer and will then return to the main menu.

In the case of an automatic creation of a boxer, the program will decide itself the name, the first name and all the parameters necessary for the creation. To do this, it will use the methods detailed earlier in this report such as int **capacite()** for example.

[Table of Contents](#table_of_contents)
***
### Play mode (Jouer)

This mode allows the user to choose which tournament they want to play, for this the main program will create the missing boxers to reach 128 boxers as well as the referees and a random number of spectators. The user arrives in this program where he will find the 3 pre-entered tournament names (he can of course add more in the Tournament Creation mode).

![alt text](https://github.com/Clerbout-Francois/Box_Simulator/blob/main/Image7.png?raw=true)

_Figure 7: Display of available tournaments._

The user will then be able to see the matches and choose the mode of play (automatic or manual) of the matches until the final announcement of the winner and the publication of an article in the .txt file "Annonce_Champion.txt".

[Table of Contents](#table_of_contents)
***
### Info mode (Infos)

The Info mode allows the user to have access to the information of each boxer before and/or after each tournament whether it is the weight, the name the first name, the current ranking or the number of victory(s), defeat(s), punch(s) received and also punch(s) carried.

[Table of Contents](#table_of_contents)
***
### Quit mode (Quitter)

As the name suggests, the quit mode allows the user to exit the program.

[Table of Contents](#table_of_contents)
<a name="conclusion_"/>

## Conclusion

We liked this project because it corresponded to our expectations in terms of work to be done and it also allowed us to progress in the field of programming in Java. 

Indeed, we spent several weeks on this project and chose to work in the following way : one of us coded and the other was there to proofread the code (and vice versa), this allowed us to progress much faster because we limited the errors of inattention. Of course it was not always the same person who coded and the same for the person in charge of proofreading. When we were not together, we determined tasks to be carried out (such as the creation of methods, error management or the schematisation of future methods) which each person could do on their own in order to make as much progress as possible. We would pool this progress when we got back together.

Furthermore, we are aware that we could continue to develop this programme in order to complete and improve it. This could mean the following ideas: 

* creating a graphical interface to make the program more visually pleasing,

* adding parameters to the tournament class to allow the user to choose how many players he wants for his tournament (currently the number of matches can be changed manually by judiciously commenting the void **deroulementTournoi()** method),

* allow an eliminated boxer to automatically become a spectator, 

* have more spectator interaction but in a sensible way.


We're proud of what we've achieved and the addition of many features such as bonus calculations to make the program as real as possible. We like this because we have been able to link our thinking with our Java programming and this results in a realistic and functional Java program.

[Table of Contents](#table_of_contents)
<a name="license_"/>

## License
Project carried out with Laura Brisoux.

Please do not forget that this project is under [MIT license](https://choosealicense.com/licenses/mit/).



[Table of Contents](#table_of_contents)
