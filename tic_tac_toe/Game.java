package tic_tac_toe;

import java.util.List;
import java.util.Scanner;

import tic_tac_toe.player.Player;

public class Game implements Board {
    List<Player> players;

    public Game(List<Player> players) {
        this.players = players;
    }

    @Override
    public void printBoard(String[][] board) {
        for (int index = 0; index < 3; index++) {
            for (int index2 = 0; index2 < 3; index2++) {
                System.out.print(board[index][index2]);
            }
            System.out.println("");
        }
    }

    public void start() {
        int size = this.players.size();
        if (size < 2 || size > 2) {
            System.out.println("Game chi 2 nguoi choi!");
            return;
        }
        final String TURN_X = " X";
        final String TURN_O = " O";
        Scanner sc = new Scanner(System.in);

        String[][] board = new String[3][3];
        for (int index = 0; index < 3; index++) {
            for (int index2 = 0; index2 < 3; index2++) {
                board[index][index2] = " *";
            }
        }
        printBoard(board);

        boolean isTurn = true;
        while (true) {
            String turn = isTurn ? " Turn O!" : " Turn X!";
            int index = isTurn ? 0 : 1;
            String player = this.players.get(index).getName();
            System.out.println(player + turn + " Nhap vao lan luot la: so dong, so cot:");
            int x = sc.nextInt();
            int y = sc.nextInt();
            boolean a = isTurn ? inputTurn(x, y, board, TURN_O) : inputTurn(x, y, board, TURN_X);
            while (!a) {
                System.out.println(player + turn + " Nhap vao lan luot la: so dong, so cot:");
                x = sc.nextInt();
                y = sc.nextInt();
                a = isTurn ? inputTurn(x, y, board, TURN_O) : inputTurn(x, y, board, TURN_X);
            }
            isTurn = !isTurn;
            printBoard(board);

            int winRow = winGameRow(board, TURN_X, TURN_O);
            int winColumn = winGameColumn(board, TURN_X, TURN_O);
            int winDiagonally = winGameDiagonally(board, TURN_X, TURN_O);
            boolean endGame = printWiner(winRow, winColumn, winDiagonally);
            if (endGame) {
                break;
            }
        }
    }

    private int winGameRow(String[][] board, String turnX, String turnO) {
        int countX = 0;
        int countO = 0;
        for (int index = 0; index < 3; index++) {
            countX = 0;
            countO = 0;
            for (int index2 = 0; index2 < 3; index2++) {
                if (board[index][index2] == turnX) {
                    countX++;
                    if (countX == 3) {
                        return 1;
                    }
                } else if (board[index][index2] == turnO) {
                    countO++;
                    if (countO == 3) {
                        return 0;
                    }
                }
            }
        }
        return -1;
    }

    private int winGameDiagonally(String[][] board, String turnX, String turnO) {
        int countX = 0;
        int countO = 0;
        for (int index = 0; index < 3; index++) {
            if (board[index][index] == turnX) {
                countX++;
                if (countX == 3) {return 1;}
            } else if (board[index][index] == turnO) {
                countO++;
                if (countO == 3) {return 0;}
            }
        }
        countX = 0;
        countO = 0;
        int size = board.length - 1;
        for (int index = 0; index < 3; index++) {
            if (board[size - index][index] == turnX) {
                countX++;
                if (countX == 3) {return 1;}
            } else if (board[size - index][index] == turnO) {
                countO++;
                if (countO == 3) {return 0;}
            }
        }

        return -1;
    }

    private int winGameColumn(String[][] board, String turnX, String turnO) {
        int countX = 0;
        int countO = 0;
        for (int index = 0; index < 3; index++) {
            countX = 0;
            countO = 0;
            for (int index2 = 0; index2 < 3; index2++) {
                if (board[index2][index] == turnX) {
                    countX++;
                    if (countX == 3) {
                        return 1;
                    }
                } else if (board[index2][index] == turnO) {
                    countO++;
                    if (countO == 3) {
                        return 0;
                    }
                }
            }
        }
        return -1;
    }

    private boolean inputTurn(int x, int y, String[][] board, String turn) {
        if (x > 2 || y > 2 || board[x][y] != " *") {
            System.out.println("O da duoc danh hoac ban nhap sai o! Vui long nhap lai :");
            return false;
        }
        board[x][y] = turn;
        return true;
    }

    private boolean printWiner(int winRow, int winColumn, int winDiagonally) {
        if (winRow == 1) {
            System.out.println("X Win!");
            return true;
        } else if (winRow == 0) {
            System.out.println("O Win!");
            return true;
        }

        if (winColumn == 1) {
            System.out.println("X Win!");
            return true;
        } else if (winColumn == 0) {
            System.out.println("O Win!");
            return true;
        }

        if (winDiagonally == 1) {
            System.out.println("X Win!");
            return true;
        } else if (winDiagonally == 0) {
            System.out.println("O Win!");
            return true;
        }
        return false;
    }

}
