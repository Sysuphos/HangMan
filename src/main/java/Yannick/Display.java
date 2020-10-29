package Yannick;

public class Display {
   /* String displayStart;
    String displayFirstError;
    String displaySecondError;
    String displayThirdError;
    String displayForthError;
    String displayFithError;
    String displaySixthError;
    String displaySeventhError;
    String displayLose;
    String displayWin;

    public Display(String displayStart, String displayFirstError, String displaySecondError,
                   String displayThirdError, String displayForthError, String displayFithError,
                   String displaySixthError, String displaySeventhError, String displayLose, String displayWin) {
        this.displayStart = displayStart;
        this.displayFirstError = displayFirstError;
        this.displaySecondError = displaySecondError;
        this.displayThirdError = displayThirdError;
        this.displayForthError = displayForthError;
        this.displayFithError = displayFithError;
        this.displaySixthError = displaySixthError;
        this.displaySeventhError = displaySeventhError;
        this.displayLose = displayLose;
        this.displayWin = displayWin;
    }*/
    public void displayStart(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *               *");
        System.out.println("  **                  ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }

    public void displayFirstError(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *..*");
        System.out.println("  *                   =");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }
    public void displaySecondError(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *..*");
        System.out.println("  *                  =");
        System.out.println("  *                  *");
        System.out.println("  *                  *");
        System.out.println("  *                  ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }
    public void displayThirdError(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *..*");
        System.out.println("  *                  =");
        System.out.println("  *          *********");
        System.out.println("  *                  * ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }

    public void displayFourthError(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *..*");
        System.out.println("  *                  =");
        System.out.println("  *          *****************");
        System.out.println("  *                  * ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }

    public void displayFithError(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *..*");
        System.out.println("  *                  =");
        System.out.println("  *          *****************");
        System.out.println("  *                  * ");
        System.out.println("  *                  *");
        System.out.println("  *                 * ");
        System.out.println("  *                *  ");
        System.out.println("  *              *    ");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }

    public void displaySixthError(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *..*");
        System.out.println("  *                  =");
        System.out.println("  *          *****************");
        System.out.println("  *                  * ");
        System.out.println("  *                  *");
        System.out.println("  *                 * *");
        System.out.println("  *                *   *");
        System.out.println("  *              *       *");
        System.out.println("  *                   ");
        System.out.println("**********************************");
    }

    public void displayLose(){
        System.out.println("***********************");
        System.out.println("  *      *           *");
        System.out.println("  *    *             *");
        System.out.println("  *  *              ***");
        System.out.println("  **                *xx*");
        System.out.println("  *                  =");
        System.out.println("  *               *********");
        System.out.println("  *               *   *   *              Tu");
        System.out.println("  *               *   *   *                as ");
        System.out.println("  *              *   * *   *                 Perdu!!!!!");
        System.out.println("  *                *    *                         ");
        System.out.println("  *                *    *");
        System.out.println("  *                   ");
        System.out.println("**********************************");
        System.out.println("Si tu veux rejouer tape 'y' , sinon tape sur une autre touche.");
    }

    public void displayWin(){
        System.out.println("Félicitation :");
        System.out.println("    Tu as gagné !!!!!");
        System.out.println("       :)");
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("Si tu veux rejouer tape 'y' , sinon tape sur une autre touche.");
    }

}



