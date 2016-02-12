/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.Rook;

/**
 *Kuningattaren puolelta tapahtuva tornitus.
 */
public class QueenSideCastleMove extends CastleMove {

    public QueenSideCastleMove(final Board board,
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
        return "0-0-0";
    }
}
