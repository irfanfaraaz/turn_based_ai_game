package com.turnbasedai;

import com.turnbasedai.api.GameEngine;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;
import com.turnbasedai.game.GameResult;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        Board board = gameEngine.start("TicTacToe");
        Player computer = new Player("X");
        Player opponent = new Player("O");
        Scanner scanner = new Scanner(System.in);

        //make moves in a loop
        while (gameEngine.isComplete(board).isOver().equals("false")) {
            System.out.println("\nCurrent board:");
            System.out.println(board);
            System.out.println("Make a move (enter row and column, 0-2):");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Move opMove = new Move(new Cell(row, col));
            gameEngine.move(board, opponent, opMove);

            if (gameEngine.isComplete(board).isOver().equals("false")) {
                Move computerMove = gameEngine.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
                System.out.println("Computer played at (" + computerMove.getCell().getRow() + ", " + computerMove.getCell().getCol() + ")");
            }
        }

        System.out.println("\nFinal board:");
        System.out.println(board);
        GameResult result = gameEngine.isComplete(board);
        System.out.println("Game Result: " + result.isOver());
        System.out.println("Winner: " + result.Winner());
        scanner.close();
    }


 
}



