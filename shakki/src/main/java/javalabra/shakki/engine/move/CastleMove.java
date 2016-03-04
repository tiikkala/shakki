/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.Rook;

/**
 * Tornitussiirto.
 */
public abstract class CastleMove extends Move {

    protected final Rook castleRook;
    protected final int castleRookStartCoordinate;
    protected final int castleRookDestinationCoordinate;

    public CastleMove(final Board board,
            final Piece movedPiece,
            final int destinationCoordinate,
            final Rook castleRook,
            final int castleRookStartCoordinate,
            final int castleRookDestinationCoordinate) {
        super(board, movedPiece, destinationCoordinate);
        this.castleRook = castleRook;
        this.castleRookStartCoordinate = castleRookStartCoordinate;
        this.castleRookDestinationCoordinate = castleRookDestinationCoordinate;
    }

    @Override
    public boolean isAttack() {
        return false;
    }

    @Override
    public boolean isCastlingMove() {
        return true;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }

    @Override
    public Board execute() {
        final Board.Builder builder = new Builder();
        for (final Piece piece : this.board.getAllPieces()) {
            if (!this.movedPiece.equals(piece) && !this.castleRook.equals(piece)) {
                builder.setPiece(piece);
            }
        }
        builder.setPiece(this.movedPiece.movePiece(this));
        builder.setPiece(new Rook(this.castleRookDestinationCoordinate, this.castleRook.getPieceColor(), false));
        builder.setMoveMaker(this.board.currentPlayer().getOpponent().getPieceColor());
        return builder.build();
    }

    public Piece getCastleRook() {
        return this.castleRook;
    }

}
