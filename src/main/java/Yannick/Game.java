package Yannick;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Game {

    String[] wordsList = new String[]{
        "prelude", "serendipite", "equanime", "ballade", "lambiner", "marmelade", "bise", "flanquer", "melliflu", "immarcessible"
    };
    int compteur=0;
    String wordToGuess;
    String finalResult = "_";
    String guess = " ";
    Scanner sc = new Scanner(System.in);
    Display display = new Display();
    boolean beforeGuess = true;
    int errors = 0;

    public void reset(){
        this.pickAWord();
        beforeGuess = true;
        errors = 1;
        guess = "%";
    }
    public void pickAWord() {
        int randomIndex = (int) (Math.random() * wordsList.length);
        wordToGuess = this.wordsList[randomIndex];
    }

    public boolean checkGuess(String guess) {
        Pattern guessPatern = Pattern.compile(guess);
        Matcher hasGuess = guessPatern.matcher(wordToGuess);

        return hasGuess.find();
    }

    public String displayGoodGuess(String guess) {
        String resultInter = new String();
        char[] charFinalResult = finalResult.toCharArray();


        char[] wordToGuessToChar = wordToGuess.toCharArray();

        for (char letterToGuess : wordToGuessToChar) {

            if (letterToGuess == guess.charAt(0)) {
                resultInter = resultInter + letterToGuess;
            } else {
                resultInter = resultInter + "_";
            }

        }
        char[] resultInterToChar = resultInter.toCharArray();
        for (int i = 0; i < resultInterToChar.length; i++) {
            if (resultInterToChar[i] != '_') {
                charFinalResult[i] = resultInterToChar[i];
            }

        }
        finalResult = String.valueOf(charFinalResult);

        if (beforeGuess) {
            beforeGuess = false;
            finalResult = resultInter;
        }
        else if(finalResult.equals(wordToGuess)){
            display.displayWin();
            String answer = sc.next();
            if(answer.equals("y")){
                this.reset();

            }else{
                errors = 9;

            }

        }

        return finalResult;

    }

    public void gameStart() {
        System.out.println("======================================");
        System.out.println("======================================");
        System.out.println("");
        System.out.println("Bienvenue sur le jeu du pendu!");
        System.out.println("                                       ");
        System.out.println("Je vais te rappeler rapidement les règles du jeu mais tout d'abord");
        System.out.println("entre ton nom?");
        Player player = new Player(sc.nextLine());

        String answer = "";

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

        if (answer.equals("y")) {
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
                        case 1:
                            display.displayStart();
                            break;
                        case 2:
                            display.displayFirstError();
                            break;
                        case 3:
                            display.displaySecondError();
                            break;
                        case 4:
                            display.displayThirdError();
                            break;
                        case 5:
                            display.displayFourthError();
                            break;
                        case 6:
                            display.displayFithError();
                            break;
                        case 7:
                            display.displaySixthError();
                            break;
                        case 8:
                            display.displayLose();
                            answer = sc.next();
                            if (answer.equals("y")) {
                                this.reset();
                            }
                            break;

                }
                System.out.println(this.displayGoodGuess(guess));
                if(errors>0 && errors<8) {

                    System.out.println("Le mot à deviner comporte " + wordToGuess.length() + " lettres. Propose moi une lettre :");
                    guess = sc.next();

                }
                if(errors == 0){
                    errors++;
                }

            }


        }
        System.out.println("Salut! A la prochaine! :) ");
    }


}



