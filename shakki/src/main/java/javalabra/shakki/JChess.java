/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Move;
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
//        
//        Board board = Board.createStandardBoard();
//        System.out.println(board);
//        
//    }    
        Board board;
        Board.Builder boardBuilder;

        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        boardBuilder.setPiece(new Rook(12, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Pawn(45, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
        boardBuilder.setPiece(new Queen(43, PieceColor.BLACK));
        boardBuilder.setPiece(new Bishop(39, PieceColor.BLACK));
        boardBuilder.setMoveMaker(PieceColor.WHITE);
        board = boardBuilder.build();
    }
}
