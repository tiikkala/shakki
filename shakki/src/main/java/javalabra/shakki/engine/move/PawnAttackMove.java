/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.move.AttackMove;
import javalabra.shakki.engine.pieces.Piece;

/**
 * Sotilaan hyökkäyssiirto.
 */
public class PawnAttackMove
        extends AttackMove {

    public PawnAttackMove(final Board board,
            final Piece pieceMoved,
            final int destinationCoordinate,
            final Piece pieceAttacked) {
        super(board, pieceMoved, destinationCoordinate, pieceAttacked);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof PawnAttackMove && super.equals(other);
    }
}
