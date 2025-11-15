package com.turnbasedai.boards;

import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;

public class TicTacToeBoard extends Board{
    String cells[][] = new String[3][3];
    public String getCell(int row, int column){
        return cells[row][column];
    }
    public void setCell(Cell cell, String symbol){
        cells[cell.getRow()][cell.getCol()] = symbol;
    }
}
