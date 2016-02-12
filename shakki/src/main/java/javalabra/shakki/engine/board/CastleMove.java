/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.Rook;

/**
 *Tornitussiirto.
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
    public boolean isCastleMove() {
        return true;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }

    @Override
    public Board execute() {
        final Board.Builder builder = new Board.Builder();
        for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
            // TODO hashcode and equals for pieces
            if (!this.movedPiece.equals(piece) && !this.getCastleRook().equals(piece)) {
                builder.setPiece(piece);
            }
        }
        for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
            builder.setPiece(piece);
        }
        // move the piece
        builder.setPiece(this.movedPiece.movePiece(this));
        // TODO: isFirstMove field to Rook
        builder.setPiece(new Rook(this.castleRookDestinationCoordinate, this.castleRook.getPieceColor()));
        builder.setMoveMaker(this.board.currentPlayer().getOpponent().getPieceColor());
        return builder.build();
    }

    public Piece getCastleRook() {
        return this.castleRook;
    }

}
