/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.Pawn;
import javalabra.shakki.engine.pieces.Piece;

/**
 * Sotilaan erikoissiirto, jossa se siirtyy yhden ruudun sijaan kaksi ruutua
 * eteenpäin.
 */
public class PawnJump extends Move {

    public PawnJump(Board board, Piece movedPiece, int destinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof PawnJump && super.equals(other);
    }

    @Override
    public Board execute() {
        final Board.Builder builder = new Builder();
        for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
            if (!this.movedPiece.equals(piece)) {
                builder.setPiece(piece);
            }
        }
        for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePieces()) {
            builder.setPiece(piece);
        }
        final Pawn movedPawn = (Pawn) this.movedPiece.movePiece(this);
        builder.setPiece(movedPawn);
        builder.setEnPassantPawn(movedPawn);
        builder.setMoveMaker(this.board.currentPlayer().getOpponent().getPieceColor());
        return builder.build();
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
