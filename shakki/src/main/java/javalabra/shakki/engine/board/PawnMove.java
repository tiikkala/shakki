/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.pieces.Piece;

/**
 *Bastrakti aliluokka sotilaan erilaisille siirroille.
 */
public abstract class PawnMove extends Move {

    public PawnMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }

    @Override
    public boolean isAttack() {
        return false;
    }

    @Override
    public boolean isCastleMove() {
        return false;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }
}
