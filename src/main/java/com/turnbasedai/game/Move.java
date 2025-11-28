package com.turnbasedai.game;

public class Move {
    private Player player;

    private Cell cell;

    public Move(Cell cell, Player player){
        this.player = player;
        this.cell = cell;
    }

    public  Cell getCell() {
        return cell;
    }

    public Player getPlayer() {
        return player;
    }
    
}
