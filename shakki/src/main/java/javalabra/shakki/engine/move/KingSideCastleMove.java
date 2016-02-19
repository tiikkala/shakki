/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.CastleMove;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.Rook;

/**
 *Tornitussiirto kuninkaan puolelta.
 */
public class KingSideCastleMove extends CastleMove {

    public KingSideCastleMove(final Board board,
            final Piece movedPiece,
            final int destinationCoordinate,
            final Rook castleRook,
            final int castleRookStartCoordinate,
            final int castleRookDestinationCoordinate) {
        super(board, movedPiece, destinationCoordinate, castleRook,
                castleRookStartCoordinate, castleRookDestinationCoordinate);
    }
    
    @Override
    // Siirron pgn-notaatio https://www.wikiwand.com/en/Portable_Game_Notation
    public String toString() {
        return "0-0";
    }
}