/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.Piece;

/**
 * Shakin "syöntisiirto", jossa nappula siirretään vastustajan nappulan asuttamaan ruutuun
 * ja vastustajan nappula poistetaan pelistä.
 */
public class AttackMove extends Move {

    final Piece attackedPiece;

    public AttackMove(final Board board, final Piece movedPiece,
            final int destinationCoordinate, final Piece attackedPiece) {
        super(board, movedPiece, destinationCoordinate);
        this.attackedPiece = attackedPiece;
    }

    @Override
    public int hashCode() {
        return this.attackedPiece.hashCode() + super.hashCode();
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AttackMove)) {
            return false;
        }
        final AttackMove otherAttackMove = (AttackMove) other;
        return super.equals(otherAttackMove)
                && this.getAttackedPiece().equals(otherAttackMove.getAttackedPiece());
    }

    @Override
    public boolean isAttack() {
        return true;
    }

    @Override
    public boolean isCastleMove() {
        return false;
    }

    @Override
    public Piece getAttackedPiece() {
        return this.attackedPiece;
    }
}
