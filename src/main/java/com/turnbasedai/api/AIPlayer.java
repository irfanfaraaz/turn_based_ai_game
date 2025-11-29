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
        Move suggestion;
        if (isStarting(board1, 4)){
          suggestion = getBasicMove(computer, board1);
        }else{
          suggestion = getSmartMove(computer, board1);
        }
        if (suggestion != null){
          return suggestion;
        }
        throw new IllegalArgumentException("No empty cells found");
      }
      else{
        throw new IllegalArgumentException("Invalid board type");
      }
    }

      private Move getSmartMove(Player player, TicTacToeBoard board1) {
        RuleEngine ruleEngine = new RuleEngine();

        //victory move
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            if (board1.getSymbol(i, j) == null){
              Move move = new Move(new Cell(i, j), player);
              TicTacToeBoard boardCopy = board1.copy();
              boardCopy.move(move);
              if (ruleEngine.isComplete(boardCopy).isOver().equals("true")){
                return move;
              }
            }
          }
        }
        
        // Defensive move
        for (int i = 0; i < 3; i++){
          for (int j = 0; j < 3; j++){
            if (board1.getCell(i, j) == null){
              Move move = new Move(new Cell(i, j), player.flip());
              TicTacToeBoard boardCopy = board1.copy();
              boardCopy.move(move);
              if (ruleEngine.isComplete(boardCopy).isOver().equals("true")){
                return new Move(new Cell(i, j), player);
              }
            }
          }
        }
        return null;
      }


      private boolean isStarting(TicTacToeBoard board1, int threshold) {
        int count = 0;
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board1.getCell(i, j) != null){
                     count++;
                }
            }
        }
        return count < threshold;
      }

      public Move getBasicMove(Player computer, TicTacToeBoard board1) {
      
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                if (board1.getCell(i, j) == null){
                    return new Move(new Cell(i, j), computer);
                }
            }
        }
        return null;
      }
      
    }


