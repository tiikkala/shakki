/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki;

import javalabra.shakki.engine.board.Board;

/**
 *
 * @author tapio
 */
public class JChess {
    
    public static void main (String[] args) {
        
        Board board = Board.createStandardBoard();
        System.out.println(board);
        
    }    
}
