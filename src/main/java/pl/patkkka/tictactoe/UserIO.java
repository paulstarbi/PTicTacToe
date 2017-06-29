package pl.patkkka.tictactoe;

import java.util.Scanner;

/**
 * Created by patrycja on 29.06.17.
 */
public class UserIO {

    private static Scanner scanner = new Scanner(System.in);

    public static void askAboutFirstPlayer(){
        System.out.println("Who goes first? (X or O)");
    }

    //should give String or Player?
    public static String getFirstPlayer(){
        askAboutFirstPlayer();
        String firstPlayer = scanner.nextLine().trim().toUpperCase();
        return firstPlayer;

    }

}
