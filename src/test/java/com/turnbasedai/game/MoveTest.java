package com.turnbasedai.game;

import junit.framework.TestCase;

public class MoveTest extends TestCase {
    private Player playerX;
    private Cell cell;

    protected void setUp() {
        playerX = new Player("X");
        cell = new Cell(1, 2);
    }

    public void testMoveCreation() {
        Move move = new Move(cell, playerX);
        assertNotNull(move);
    }

    public void testGetCell() {
        Move move = new Move(cell, playerX);
        assertEquals(cell, move.getCell());
        assertEquals(1, move.getCell().getRow());
        assertEquals(2, move.getCell().getCol());
    }

    public void testGetPlayer() {
        Move move = new Move(cell, playerX);
        assertEquals(playerX, move.getPlayer());
        assertEquals("X", move.getPlayer().symbol());
    }

    public void testMoveWithDifferentPlayer() {
        Player playerO = new Player("O");
        Move move = new Move(cell, playerO);
        assertEquals(playerO, move.getPlayer());
        assertEquals("O", move.getPlayer().symbol());
    }

    public void testMoveWithDifferentCell() {
        Cell newCell = new Cell(2, 0);
        Move move = new Move(newCell, playerX);
        assertEquals(newCell, move.getCell());
        assertEquals(2, move.getCell().getRow());
        assertEquals(0, move.getCell().getCol());
    }
}

