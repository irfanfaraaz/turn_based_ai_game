package com.turnbasedai.api;

import com.turnbasedai.boards.TicTacToeBoard;
import com.turnbasedai.game.Board;
import com.turnbasedai.game.Move;
import com.turnbasedai.game.Player;

public class GameEngine {
    public Board start(String type){
        if (type.equals("TicTacToe")){
            return new TicTacToeBoard();
        }
        else{
            throw new IllegalArgumentException("Invalid board type");
        }

    }

    public void move(Board board, Player player, Move move){
        if (board instanceof TicTacToeBoard){
            board.move(move);
        }
        else{
            throw new IllegalArgumentException("Invalid board type");
        }
    }

   
}
