package com.turnbasedai.api;

import java.util.function.Function;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.GameState;

public class RuleEngine {
    public GameState isComplete(Board board) {
        if (board instanceof TicTacToeBoard) {
            TicTacToeBoard board1 = (TicTacToeBoard) board;
            
            // Check rows
            GameState rowWin = checkRows(board1);
            if (rowWin != null) {
                return rowWin;
            }
            
            // Check columns
            GameState colWin = checkColumns(board1);
            if (colWin != null) {
                return colWin;
            }
            
            // Check main diagonal (top-left to bottom-right)
            GameState mainDiagonalWin = checkLine(
                () -> board1.getCell(0, 0),
                (index) -> board1.getCell(index, index)
            );
            if (mainDiagonalWin != null) {
                return mainDiagonalWin;
            }
            
            // Check reverse diagonal (top-right to bottom-left)
            GameState reverseDiagonalWin = checkLine(
                () -> board1.getCell(0, 2),
                (index) -> board1.getCell(index, 2 - index)
            );
            if (reverseDiagonalWin != null) {
                return reverseDiagonalWin;
            }
            
            // Check for draw (all cells filled)
            return checkDraw(board1);
        }
        return new GameState("false", "-");
    }

    private GameState checkRows(TicTacToeBoard board) {
        for (int i = 0; i < 3; i++) {
            final int row = i;
            GameState win = checkLine(
                () -> board.getCell(row, 0),
                (j) -> board.getCell(row, j)
            );
            if (win != null) {
                return win;
            }
        }
        return null;
    }

    private GameState checkColumns(TicTacToeBoard board) {
        for (int j = 0; j < 3; j++) {
            final int col = j;
            GameState win = checkLine(
                () -> board.getCell(0, col),
                (i) -> board.getCell(i, col)
            );
            if (win != null) {
                return win;
            }
        }
        return null;
    }

    private GameState checkLine(
            java.util.function.Supplier<String> getFirstCell,
            Function<Integer, String> getNextCell) {
        String firstCell = getFirstCell.get();
        if (firstCell == null) {
            return null;
        }
        
        for (int i = 1; i < 3; i++) {
            String nextCell = getNextCell.apply(i);
            if (nextCell == null || !firstCell.equals(nextCell)) {
                return null;
            }
        }
        
        return new GameState("true", firstCell);
    }

    private GameState checkDraw(TicTacToeBoard board) {
        int countFilledCells = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.getCell(i, j) != null) {
                    countFilledCells++;
                }
            }
        }
        
        if (countFilledCells == 9) {
            return new GameState("true", "-");
        }
        return new GameState("false", "-");
    }
}
