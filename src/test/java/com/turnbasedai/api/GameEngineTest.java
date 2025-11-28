package com.turnbasedai.api;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;
import junit.framework.TestCase;

public class GameEngineTest extends TestCase {
    private GameEngine gameEngine;
    private Player playerX;
    private Player playerO;

    protected void setUp() {
        gameEngine = new GameEngine();
        playerX = new Player("X");
        playerO = new Player("O");
    }

    public void testStartCreatesTicTacToeBoard() {
        Board board = gameEngine.start("TicTacToe");
        assertNotNull(board);
        assertTrue(board instanceof TicTacToeBoard);
    }

    public void testStartThrowsExceptionForInvalidType() {
        try {
            gameEngine.start("InvalidGame");
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid board type", e.getMessage());
        }
    }

    public void testMovePlacesSymbolOnBoard() {
        Board board = gameEngine.start("TicTacToe");
        Move move = new Move(new Cell(0, 0), playerX);
        gameEngine.move(board, playerX, move);
        
        TicTacToeBoard tttBoard = (TicTacToeBoard) board;
        assertEquals("X", tttBoard.getCell(0, 0));
    }

    public void testMovePlacesMultipleSymbols() {
        Board board = gameEngine.start("TicTacToe");
        gameEngine.move(board, playerX, new Move(new Cell(0, 0), playerX));
        gameEngine.move(board, playerO, new Move(new Cell(0, 1), playerO));
        gameEngine.move(board, playerX, new Move(new Cell(1, 1), playerX));
        
        TicTacToeBoard tttBoard = (TicTacToeBoard) board;
        assertEquals("X", tttBoard.getCell(0, 0));
        assertEquals("O", tttBoard.getCell(0, 1));
        assertEquals("X", tttBoard.getCell(1, 1));
        assertNull(tttBoard.getCell(2, 2));
    }

    public void testMoveThrowsExceptionForInvalidBoard() {
        Board invalidBoard = new Board() {
            public void move(com.turnbasedai.game.Move move) {
                // Empty implementation for testing
            }
        };
        
        try {
            gameEngine.move(invalidBoard, playerX, new Move(new Cell(0, 0), playerX));
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid board type", e.getMessage());
        }
    }
}

