package com.turnbasedai.game;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {
    
    public void testPlayerCreation() {
        Player player = new Player("X");
        assertNotNull(player);
    }

    public void testPlayerSymbol() {
        Player playerX = new Player("X");
        assertEquals("X", playerX.symbol());
        
        Player playerO = new Player("O");
        assertEquals("O", playerO.symbol());
    }

    public void testPlayerWithDifferentSymbol() {
        Player player = new Player("Y");
        assertEquals("Y", player.symbol());
    }
}

