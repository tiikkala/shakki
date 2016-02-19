/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki;

import java.util.Collection;
import javalabra.shakki.GUI.Table;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.Bishop;
import javalabra.shakki.engine.pieces.King;
import javalabra.shakki.engine.pieces.Pawn;
import javalabra.shakki.engine.pieces.PieceColor;
import javalabra.shakki.engine.pieces.Queen;
import javalabra.shakki.engine.pieces.Rook;

/**
 *
 * @author tapio
 */
public class JChess {

    public static void main(String[] args) {
        
        Board board = Board.createStandardBoard();
        System.out.println(board);
        
        Table table = new Table();
    }    
}
