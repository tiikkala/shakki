/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.pieces.King;
import javalabra.shakki.engine.pieces.PieceColor;
import javalabra.shakki.engine.pieces.Queen;

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
        Board.Builder boardBuilder;
        Board board;

        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        boardBuilder.setPiece(new Queen(36, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Queen(54, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
        boardBuilder.setMoveMaker(PieceColor.WHITE);
        board = boardBuilder.build();
        
        Collection<Move> whiteMoves = board.getWhitePlayer().getLegalMoves();
        board.getTile(54).getPiece().calculateLegalMoves(board);
        
        for (Move move : whiteMoves) {
            System.out.println(move.toString());
        }
        
    }
}
