package com.turnbasedai;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.GameResult;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;

public class Main {
    public static void main(String[] args) {

    }

    public Board start(){
        return new Board();

    }

    public void move(Board board, Player player, Move move){}

    public GameResult isComplete(Board board){
        boolean rowComplete = false;
        boolean columnComplete = false;
        boolean diagonalComplete = false;
        boolean reverseDiagonalComplete = false;
        String firstCell = "-";
        if (board instanceof TicTacToeBoard){
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            for (int i = 0; i < 3; i++){
                 rowComplete = true;
                 firstCell = board1.cells[i][0];
                for (int j = i; j < 3; j++){
                    if (!firstCell.equals(board1.cells[i][j])){
                        rowComplete = false;
                        break;
                    }else{

                    }
                }
                if (rowComplete){
                    return new GameResult("true", firstCell);
                }
            }
            for (int i = 0; i < 3; i++){
                 columnComplete = true;
                 firstCell = board1.cells[0][i];
                for (int j = i; j < 3; j++){
                    if (!firstCell.equals(board1.cells[j][i])){
                        columnComplete = false;
                        break;
                    }else{
                    }
                }
                if (columnComplete){
                    return new GameResult("true", firstCell);
                }
            }
            for (int i = 0; i < 3; i++){
                 diagonalComplete = true;
                 firstCell = board1.cells[i][i];
                for (int j = i; j < 3; j++){
                    if (!firstCell.equals(board1.cells[j][j])){
                        diagonalComplete = false;
                        break;
                    }else{
                    }
                }
                if (diagonalComplete){
                    return new GameResult("true", firstCell);
                }
            }
            for (int i = 0; i < 3; i++){
                 reverseDiagonalComplete = true;
                 firstCell = board1.cells[i][2-i];
                for (int j = i; j < 3; j++){
                    if (!firstCell.equals(board1.cells[j][2-j])){
                        reverseDiagonalComplete = false;
                        break;
                    }else{
                    }
                }
                if (reverseDiagonalComplete){
                    return new GameResult("true", firstCell);
                }
            }

            int countFilledCells = 0;
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){
                    if (board1.cells[i][j] != null){
                        countFilledCells++;
                    }
                }
            }
            if (countFilledCells == 9){
                return new GameResult("true", "-");
            }else{
                return new GameResult("false", "-");
            }
        }
    }
}



