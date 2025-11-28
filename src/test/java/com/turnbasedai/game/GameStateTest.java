package com.turnbasedai.game;

import junit.framework.TestCase;

public class GameStateTest extends TestCase {
    
    public void testGameStateCreation() {
        GameState state = new GameState("false", "-");
        assertNotNull(state);
    }

    public void testIsOver() {
        GameState state = new GameState("true", "X");
        assertEquals("true", state.isOver());
        
        GameState state2 = new GameState("false", "-");
        assertEquals("false", state2.isOver());
    }

    public void testWinner() {
        GameState state = new GameState("true", "X");
        assertEquals("X", state.Winner());
        
        GameState state2 = new GameState("true", "O");
        assertEquals("O", state2.Winner());
        
        GameState state3 = new GameState("true", "-");
        assertEquals("-", state3.Winner());
    }

    public void testGameStateForDraw() {
        GameState state = new GameState("true", "-");
        assertEquals("true", state.isOver());
        assertEquals("-", state.Winner());
    }

    public void testGameStateForWin() {
        GameState state = new GameState("true", "X");
        assertEquals("true", state.isOver());
        assertEquals("X", state.Winner());
    }
}

