package Yannick;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Game {
    //Set 10 words to guess
    String[] wordsList = new String[]{
        "prelude", "serendipite", "equanime", "ballade", "lambiner", "marmelade", "bise", "flanquer", "melliflu", "immarcessible"
    };
    String answer = "";
    int compteur=0;
    String wordToGuess;
    String finalResult = "_";
    String guess = " ";
    Scanner sc = new Scanner(System.in);
    Display display = new Display();
    Player player = new Player("  ");
    boolean beforeGuess = true;
    int errors = 0;

    //Reset all value of the game 
    public void reset(){
        this.pickAWord();
        beforeGuess = true;
        errors = 1;
        guess = "%";
        player.setScore(0);
    }

    //Chose a random word in wordlist
    public void pickAWord() {
        int randomIndex = (int) (Math.random() * wordsList.length);
        wordToGuess = this.wordsList[randomIndex];
    }
    //If the player guess correctly return 'true'
    public boolean checkGuess(String guess) {
        Pattern guessPatern = Pattern.compile(guess);
        Matcher hasGuess = guessPatern.matcher(wordToGuess);

        return hasGuess.find();
    }

    //Display the letter of the player when it's correct
    public String displayGoodGuess(String guess) {
        String resultInter = new String();
        char[] charFinalResult = finalResult.toCharArray();


        char[] wordToGuessToChar = wordToGuess.toCharArray();

        for (char letterToGuess : wordToGuessToChar) {

            if (letterToGuess == guess.charAt(0)) {
                resultInter = resultInter + letterToGuess;
            } else {
                resultInter = resultInter + "-";
            }

        }
        char[] resultInterToChar = resultInter.toCharArray();
        for (int i = 0; i < resultInterToChar.length; i++) {
            if (resultInterToChar[i] != '-') {
                charFinalResult[i] = resultInterToChar[i];
                player.setScore(player.getScore()+10);
            }

        }
        finalResult = String.valueOf(charFinalResult);

        if (beforeGuess) {
            beforeGuess = false;
            finalResult = resultInter;
        }
        else if(finalResult.equals(wordToGuess)){
            System.out.println("Le mot a trouver était effectivement : " + wordToGuess);
            System.out.println("Ton score est de : " + (player.getScore()+ 500 +(100*wordToGuess.length())-(20*errors)));
            display.displayWin();
            String answer = sc.next();
            if(answer.equals("y")){
                this.reset();
                return " ";

            }else{
                errors = 9;

            }

        }

        return finalResult;

    }

    // Game progress
    public void gameStart() {

        //Set player's name
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("");
        System.out.println("Bienvenue sur le jeu du pendu!");
        System.out.println("                                       ");
        System.out.println("Je vais te rappeler rapidement les règles du jeu mais tout d'abord");
        System.out.println("entre ton nom?");
        player.setName(sc.nextLine());

        
        // Remind rules to the player and ask him if he still want to play
        while (!answer.equals("y")) {

            if (answer.equals("q")) {
                break;
            }
            System.out.println("==========================================================");
            System.out.println("==========================================================");
            System.out.println("");
            if(compteur<1){
                System.out.println("Très bien " + player.getName() + " , je te rappel donc rapidement les règles du jeu: ");
                System.out.println("C'est très simple, je vais choisir aléatoirement un mot dans ma base de donnée");
                System.out.println("et tu devras le deviner!");
                System.out.println("Pour se faire à chaque tour tu me proposeras une lettre qui selon toi");
                System.out.println("compose le mot que je cherche à te faire deviner.");
                System.out.println("Mais attention tu n'as le droit qu'a six erreurs donc à la septieme ce sera...GAME-OVER!");
            }else{
                System.out.println("Désolé " + player.getName() + ", je n'ai pas compris ce que tu m'as demandé... ");
            }

            System.out.println("Si tu es prêt à jouer tape 'y' ;");
            System.out.println("Mais si tu souhaite quitter le jeu tape 'q'");
            answer = sc.next();
            compteur++;
        }
        //If player want to play the game start
        if (answer.equals("y")) {

            //Select a random word
            this.pickAWord();

            while (errors <= 8) {

                System.out.println("");
                System.out.println("==========================================================");
                System.out.println("==========================================================");
                System.out.println("");
                System.out.println("");

                if (!this.checkGuess(guess)) {
                    errors++;
                }
                switch (errors) {
                        //Display screen according to the number of errors
                        case 1:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displayStart();
                            break;
                        case 2:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displayFirstError();
                            break;
                        case 3:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displaySecondError();
                            break;
                        case 4:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displayThirdError();
                            break;
                        case 5:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displayFourthError();
                            break;
                        case 6:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displayFithError();
                            break;
                        case 7:
                            System.out.println(this.displayGoodGuess(guess));
                            System.out.println(" ");
                            display.displaySixthError();
                            break;
                        case 8:
                            System.out.println("Le mot a deviner était '" + wordToGuess + "'");
                            System.out.println("Ton score est de : " + (player.getScore()-(20*errors))+(100*wordToGuess.length()));
                            display.displayLose();
                            answer = sc.next();
                            if (answer.equals("y")) {
                                this.reset();
                            }
                            break;

                }
                // Ask the player to guess one letter
                if(errors>0 && errors<8) {

                    System.out.println("Le mot à deviner comporte " + wordToGuess.length() + " lettres. Propose moi une lettre :");
                    guess = sc.next();

                }
                if(errors == 0){
                    errors++;
                }

            }


        }
        // Game exit
        System.out.println("Salut! A la prochaine! :) ");
    }


}



