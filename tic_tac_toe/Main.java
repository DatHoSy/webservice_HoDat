package tic_tac_toe;

import java.util.List;

import tic_tac_toe.player.Player;

public class Main {

    public static void main(String[] args) {
        String[][] board = new String[3][3];
        for (int index = 0; index < 3; index++) {
            for (int index2 = 0; index2 < 3; index2++) {
                board[index][index2] = " *";
            }
        }
        Player player1 = new Player("Hoa");
        Player player2 = new Player("Tai");


        Game game1 = new Game(List.of(player1, player2));
        game1.start();

    }

}
