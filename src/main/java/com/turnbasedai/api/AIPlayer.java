package com.turnbasedai.api;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;

public class AIPlayer {
      public Move suggestMove(Player computer, Board board) {
      if (board instanceof TicTacToeBoard){
        TicTacToeBoard board1 = (TicTacToeBoard) board;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board1.getCell(i, j) == null){
                    return new Move(new Cell(i, j), computer);
                }
            }
        }
        throw new IllegalArgumentException("No empty cells found");
      }
      else{
        throw new IllegalArgumentException("Invalid board type");
      }
    }

}
