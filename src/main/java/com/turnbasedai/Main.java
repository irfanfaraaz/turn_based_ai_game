package com.turnbasedai;

import com.turnbasedai.api.GameEngine;
import com.turnbasedai.api.AIPlayer;
import com.turnbasedai.api.RuleEngine;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;
import com.turnbasedai.game.GameState;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        GameEngine gameEngine = new GameEngine();
        AIPlayer aiPlayer = new AIPlayer();
        RuleEngine ruleEngine = new RuleEngine();
        Board board = gameEngine.start("TicTacToe");
        Player computer = new Player("X");
        Player opponent = new Player("O");
        Scanner scanner = new Scanner(System.in);

        //make moves in a loop
        while (ruleEngine.isComplete(board).isOver().equals("false")) {
            System.out.println("\nCurrent board:");
            System.out.println(board);
            System.out.println("Make a move (enter row and column, 0-2):");
            
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            Move opMove = new Move(new Cell(row, col), opponent);
            gameEngine.move(board, opponent, opMove);

            if (ruleEngine.isComplete(board).isOver().equals("false")) {
                Move computerMove = aiPlayer.suggestMove(computer, board);
                gameEngine.move(board, computer, computerMove);
                System.out.println("Computer played at (" + computerMove.getCell().getRow() + ", " + computerMove.getCell().getCol() + ")");
            }
        }

        System.out.println("\nFinal board:");
        System.out.println(board);
        GameState result = ruleEngine.isComplete(board);
        System.out.println("Game Result: " + result.isOver());
        System.out.println("Winner: " + result.Winner());
        scanner.close();
    }


 
}



