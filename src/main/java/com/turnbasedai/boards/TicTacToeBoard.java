package com.turnbasedai.boards;


import com.turnbasedai.game.Cell;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Board;

public class TicTacToeBoard implements Board{
    String cells[][] = new String[3][3];
    public String getCell(int row, int column){
        return cells[row][column];
    }
    public void setCell(Cell cell, String symbol){
        //check if cell is valid
        if (cell.getRow() < 0 || cell.getRow() > 2 || cell.getCol() < 0 || cell.getCol() > 2){
            throw new IllegalArgumentException("Invalid cell");
        }
        else if (cells[cell.getRow()][cell.getCol()] != null){
            throw new IllegalArgumentException("Cell already taken");
        }
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
    @Override
    public void move(Move move) {
        setCell(move.getCell(), move.getPlayer().symbol());
    }
    public String getSymbol(int i, int j) {
        return getCell(i, j);
    }
    public void undo(Move move) {
        setCell(move.getCell(), null);
    }

    @Override
    public TicTacToeBoard copy() {
        TicTacToeBoard ticTacToeBoardCopy = new TicTacToeBoard();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                String symbol = getCell(i, j);
                if (symbol != null) {
                    ticTacToeBoardCopy.setCell(new Cell(i, j), symbol);
                }
            }
        }
        return ticTacToeBoardCopy;
    }
}
