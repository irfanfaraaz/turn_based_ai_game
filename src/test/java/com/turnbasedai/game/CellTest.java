package com.turnbasedai.game;

import junit.framework.TestCase;

public class CellTest extends TestCase {
    
    public void testCellCreation() {
        Cell cell = new Cell(0, 0);
        assertNotNull(cell);
    }

    public void testGetRow() {
        Cell cell = new Cell(2, 1);
        assertEquals(2, cell.getRow());
    }

    public void testGetCol() {
        Cell cell = new Cell(1, 3);
        assertEquals(3, cell.getCol());
    }

    public void testCellWithDifferentCoordinates() {
        Cell cell1 = new Cell(0, 0);
        Cell cell2 = new Cell(2, 2);
        
        assertEquals(0, cell1.getRow());
        assertEquals(0, cell1.getCol());
        assertEquals(2, cell2.getRow());
        assertEquals(2, cell2.getCol());
    }
}

