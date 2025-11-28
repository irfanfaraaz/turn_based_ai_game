package com.turnbasedai.api;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.GameState;

public class RuleEngine {
       public GameState isComplete(Board board){
        boolean rowComplete = false;
        boolean columnComplete = false;
        boolean diagonalComplete = false;
        boolean reverseDiagonalComplete = false;
        String firstCell = "-";
        if (board instanceof TicTacToeBoard){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++){
                firstCell = board1.getCell(i, 0);
                rowComplete = firstCell !=null;
                if (firstCell !=null){

                    for (int j = 1; j < 3; j++){
                        if (!firstCell.equals(board1.getCell(i, j))){
                            rowComplete = false;
                            break;
                        }else{
    
                        }
                    }
                }
                if (rowComplete){
                    return new GameState("true", firstCell);
                }
            }
            for (int i = 0; i < 3; i++){
                 firstCell = board1.getCell(0, i);
                 columnComplete = firstCell !=null;
                 if (firstCell !=null){
                    for (int j = 1; j < 3; j++){
                        if (!firstCell.equals(board1.getCell(j, i))){
                            columnComplete = false;
                            break;
                        }else{
                        }
                    }
                    if (columnComplete){
                        return new GameState("true", firstCell);
                    }
                 
                }
            }
            
                 firstCell = board1.getCell(0, 0);
                 diagonalComplete = firstCell !=null;
                 if (firstCell !=null){
                    for (int j = 1; j < 3; j++){
                    if (!firstCell.equals(board1.getCell(j, j))){
                        diagonalComplete = false;
                        break;
                    }else{
                    }
                }
                }
                if (diagonalComplete){
                    return new GameState("true", firstCell);
                }
            
            
                 firstCell = board1.getCell(0, 2);
                 reverseDiagonalComplete = firstCell !=null;
                 if (firstCell !=null){
                for (int j = 1; j < 3; j++){
                    if (!firstCell.equals(board1.getCell(j, 2-j))){
                        reverseDiagonalComplete = false;
                        break;
                    }else{
                    }
                    }
                }
                if (reverseDiagonalComplete){
                    return new GameState("true", firstCell);
                }
            

            int countFilledCells = 0;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board1.getCell(i, j) != null){
                        countFilledCells++;
                    }
                }
            }
            if (countFilledCells == 9){
                return new GameState("true", "-");
            }else{
                return new GameState("false", "-");
            }
        }
        return new GameState("false", "-");
    }


}
