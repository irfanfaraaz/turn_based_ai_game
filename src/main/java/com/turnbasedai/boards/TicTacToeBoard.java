package com.turnbasedai.boards;

import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;

public class TicTacToeBoard extends Board{
    String cells[][] = new String[3][3];
    public String getCell(int row, int column){
        return cells[row][column];
    }
    public void setCell(String symbol, Cell cell){
        cells[cell.getRow()][cell.getCol()] = symbol;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String cell = cells[i][j];
                sb.append(cell == null ? "-" : cell);
                if (j < 2) sb.append(" ");
            }
            if (i < 2) sb.append("\n");
        }
        return sb.toString();
    }
}
