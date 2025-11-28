package com.turnbasedai.api;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;
import junit.framework.TestCase;

public class AIPlayerTest extends TestCase {
    private AIPlayer aiPlayer;
    private Player computer;
    private Board board;

    protected void setUp() {
        aiPlayer = new AIPlayer();
        computer = new Player("X");
        board = new TicTacToeBoard();
    }

    public void testSuggestMoveReturnsFirstEmptyCell() {
        Move move = aiPlayer.suggestMove(computer, board);
        assertNotNull(move);
        assertEquals(computer, move.getPlayer());
        assertEquals(0, move.getCell().getRow());
        assertEquals(0, move.getCell().getCol());
    }

    public void testSuggestMoveReturnsNextEmptyCell() {
        // Fill first cell
        board.move(new Move(new Cell(0, 0), new Player("O")));
        
        Move move = aiPlayer.suggestMove(computer, board);
        assertNotNull(move);
        assertEquals(0, move.getCell().getRow());
        assertEquals(1, move.getCell().getCol());
    }

    public void testSuggestMoveReturnsCorrectCellAfterMultipleMoves() {
        // Fill (0,0), (0,1), (0,2), (1,0)
        board.move(new Move(new Cell(0, 0), new Player("O")));
        board.move(new Move(new Cell(0, 1), new Player("O")));
        board.move(new Move(new Cell(0, 2), new Player("O")));
        board.move(new Move(new Cell(1, 0), new Player("O")));
        
        Move move = aiPlayer.suggestMove(computer, board);
        assertNotNull(move);
        assertEquals(1, move.getCell().getRow());
        assertEquals(1, move.getCell().getCol());
    }

    public void testSuggestMoveThrowsExceptionWhenBoardFull() {
        // Fill entire board
        Player player = new Player("O");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.move(new Move(new Cell(i, j), player));
            }
        }
        
        try {
            aiPlayer.suggestMove(computer, board);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("No empty cells found", e.getMessage());
        }
    }

    public void testSuggestMoveThrowsExceptionForInvalidBoard() {
        Board invalidBoard = new Board() {
            public void move(com.turnbasedai.game.Move move) {
                // Empty implementation for testing
            }
        };
        
        try {
            aiPlayer.suggestMove(computer, invalidBoard);
            fail("Should have thrown IllegalArgumentException");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid board type", e.getMessage());
        }
    }

    public void testSuggestMoveReturnsMoveWithCorrectPlayer() {
        Player differentPlayer = new Player("Y");
        Move move = aiPlayer.suggestMove(differentPlayer, board);
        assertEquals(differentPlayer, move.getPlayer());
    }
}

