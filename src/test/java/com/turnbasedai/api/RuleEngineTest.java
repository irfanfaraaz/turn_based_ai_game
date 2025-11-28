package com.turnbasedai.api;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Cell;
import com.turnbasedai.game.GameState;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;
import junit.framework.TestCase;

public class RuleEngineTest extends TestCase {
    private RuleEngine ruleEngine;
    private Board board;
    private Player playerX;
    private Player playerO;

    protected void setUp() {
        ruleEngine = new RuleEngine();
        board = new TicTacToeBoard();
        playerX = new Player("X");
        playerO = new Player("O");
    }

    public void testEmptyBoardIsNotComplete() {
        GameState result = ruleEngine.isComplete(board);
        assertEquals("false", result.isOver());
        assertEquals("-", result.Winner());
    }

    public void testRowWinFirstRow() {
        // X X X in first row
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(0, 1), playerX));
        board.move(new Move(new Cell(0, 2), playerX));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("X", result.Winner());
    }

    public void testRowWinSecondRow() {
        // O O O in second row
        board.move(new Move(new Cell(1, 0), playerO));
        board.move(new Move(new Cell(1, 1), playerO));
        board.move(new Move(new Cell(1, 2), playerO));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("O", result.Winner());
    }

    public void testRowWinThirdRow() {
        // X X X in third row
        board.move(new Move(new Cell(2, 0), playerX));
        board.move(new Move(new Cell(2, 1), playerX));
        board.move(new Move(new Cell(2, 2), playerX));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("X", result.Winner());
    }

    public void testColumnWinFirstColumn() {
        // X X X in first column
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(1, 0), playerX));
        board.move(new Move(new Cell(2, 0), playerX));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("X", result.Winner());
    }

    public void testColumnWinSecondColumn() {
        // O O O in second column
        board.move(new Move(new Cell(0, 1), playerO));
        board.move(new Move(new Cell(1, 1), playerO));
        board.move(new Move(new Cell(2, 1), playerO));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("O", result.Winner());
    }

    public void testColumnWinThirdColumn() {
        // X X X in third column
        board.move(new Move(new Cell(0, 2), playerX));
        board.move(new Move(new Cell(1, 2), playerX));
        board.move(new Move(new Cell(2, 2), playerX));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("X", result.Winner());
    }

    public void testMainDiagonalWin() {
        // X X X in main diagonal (0,0), (1,1), (2,2)
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(1, 1), playerX));
        board.move(new Move(new Cell(2, 2), playerX));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("X", result.Winner());
    }

    public void testReverseDiagonalWin() {
        // O O O in reverse diagonal (0,2), (1,1), (2,0)
        board.move(new Move(new Cell(0, 2), playerO));
        board.move(new Move(new Cell(1, 1), playerO));
        board.move(new Move(new Cell(2, 0), playerO));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("O", result.Winner());
    }

    public void testDrawGame() {
        // Fill board without a winner
        // X O X
        // O O X
        // O X O
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(0, 1), playerO));
        board.move(new Move(new Cell(0, 2), playerX));
        board.move(new Move(new Cell(1, 0), playerO));
        board.move(new Move(new Cell(1, 1), playerO));
        board.move(new Move(new Cell(1, 2), playerX));
        board.move(new Move(new Cell(2, 0), playerO));
        board.move(new Move(new Cell(2, 1), playerX));
        board.move(new Move(new Cell(2, 2), playerO));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("true", result.isOver());
        assertEquals("-", result.Winner());
    }

    public void testIncompleteGame() {
        // Only a few moves, game not complete
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(1, 1), playerO));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("false", result.isOver());
        assertEquals("-", result.Winner());
    }

    public void testRowNotCompleteWithDifferentSymbols() {
        // X O X in first row - not a win
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(0, 1), playerO));
        board.move(new Move(new Cell(0, 2), playerX));
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("false", result.isOver());
    }

    public void testRowNotCompleteWithEmptyCell() {
        // X X - in first row - not a win
        board.move(new Move(new Cell(0, 0), playerX));
        board.move(new Move(new Cell(0, 1), playerX));
        // Cell (0,2) is empty
        
        GameState result = ruleEngine.isComplete(board);
        assertEquals("false", result.isOver());
    }
}

