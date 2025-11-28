package com.turnbasedai.boards;

import com.turnbasedai.game.Cell;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;
import junit.framework.TestCase;

public class TicTacToeBoardTest extends TestCase {
    private TicTacToeBoard board;
    private Player playerX;
    private Player playerO;

    protected void setUp() {
        board = new TicTacToeBoard();
        playerX = new Player("X");
        playerO = new Player("O");
    }

    public void testNewBoardIsEmpty() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertNull(board.getCell(i, j));
            }
        }
    }

    public void testSetCellPlacesSymbol() {
        board.setCell(new Cell(0, 0), "X");
        assertEquals("X", board.getCell(0, 0));
    }

    public void testSetCellPlacesMultipleSymbols() {
        board.setCell(new Cell(0, 0), "X");
        board.setCell(new Cell(1, 1), "O");
        board.setCell(new Cell(2, 2), "X");
        
        assertEquals("X", board.getCell(0, 0));
        assertEquals("O", board.getCell(1, 1));
        assertEquals("X", board.getCell(2, 2));
        assertNull(board.getCell(0, 1));
    }

    public void testMovePlacesPlayerSymbol() {
        Move move = new Move(new Cell(1, 2), playerX);
        board.move(move);
        assertEquals("X", board.getCell(1, 2));
    }

    public void testMovePlacesCorrectPlayerSymbol() {
        Move moveX = new Move(new Cell(0, 0), playerX);
        Move moveO = new Move(new Cell(0, 1), playerO);
        
        board.move(moveX);
        board.move(moveO);
        
        assertEquals("X", board.getCell(0, 0));
        assertEquals("O", board.getCell(0, 1));
    }

    public void testToStringShowsEmptyBoard() {
        String result = board.toString();
        assertNotNull(result);
        assertTrue(result.contains("-"));
    }

    public void testToStringShowsSymbols() {
        board.setCell(new Cell(0, 0), "X");
        board.setCell(new Cell(0, 1), "O");
        board.setCell(new Cell(0, 2), "X");
        
        String result = board.toString();
        assertTrue(result.contains("X"));
        assertTrue(result.contains("O"));
    }

    public void testToStringFormat() {
        board.setCell(new Cell(0, 0), "X");
        board.setCell(new Cell(0, 1), "O");
        board.setCell(new Cell(0, 2), "X");
        board.setCell(new Cell(1, 0), "O");
        board.setCell(new Cell(1, 1), "X");
        board.setCell(new Cell(1, 2), "O");
        board.setCell(new Cell(2, 0), "X");
        board.setCell(new Cell(2, 1), "O");
        board.setCell(new Cell(2, 2), "X");
        
        String result = board.toString();
        String[] lines = result.split("\n");
        assertEquals(3, lines.length);
    }

    public void testGetCellReturnsNullForEmptyCell() {
        assertNull(board.getCell(2, 2));
    }

    public void testGetCellReturnsCorrectValue() {
        board.setCell(new Cell(1, 1), "X");
        assertEquals("X", board.getCell(1, 1));
    }
}

