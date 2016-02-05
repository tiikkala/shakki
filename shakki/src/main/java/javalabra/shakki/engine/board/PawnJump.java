/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.pieces.Piece;

/**
 *
 * @author tapio
 */
public class PawnJump extends Move {

    public PawnJump(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }

    @Override
    public boolean isAttack() {
        return false;
    }

    @Override
    public boolean isCastlingMove() {
        return false;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }

}
