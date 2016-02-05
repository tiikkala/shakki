/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.pieces.Piece;

/**
 *
 * @author tapio
 */
public class NormalMove extends Move {

    public NormalMove(final Board board, final Piece movedPiece, final int destinationCoordinate) {
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
