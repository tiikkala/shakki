/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.pieces.Piece;

/**
 *Normaali siirto, jossa pelinappula siirretään tyhjään ruutuun.
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
    public boolean isCastleMove() {
        return false;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }
}
