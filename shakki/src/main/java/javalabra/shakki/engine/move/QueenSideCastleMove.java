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
 * Kuningattaren puolelta tapahtuva tornitus.
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
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof QueenSideCastleMove)) {
            return false;
        }
        final QueenSideCastleMove otherQueenSideCastleMove = (QueenSideCastleMove) other;
        return super.equals(otherQueenSideCastleMove) && this.castleRook.equals(otherQueenSideCastleMove.getCastleRook());
    }
}
