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
 * Sotilaan erikoissiirto, jossa se siirtyy yhden ruudun sijaan kaksi ruutua eteenpäin.
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
    public boolean isCastleMove() {
        return false;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }

}
