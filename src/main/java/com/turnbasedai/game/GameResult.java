package com.turnbasedai.game;

public class GameResult {
    String isOver = "";
    String Winner = "";

    public GameResult(String isOver, String Winner){
        this.isOver = isOver;
        this.Winner = Winner;
    }

    public String isOver(){
        return isOver;
    }

    public String Winner(){
        return Winner;
    }
}
