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
public abstract class Move {

    final Board board;
    final Piece movedPiece;
    final int destinationCoordinate;

    public static final Move NULL_MOVE = new NullMove();

    protected Move(final Board board, final Piece movedPiece, final int destinationCoordinate) {
        this.board = board;
        this.movedPiece = movedPiece;
        this.destinationCoordinate = destinationCoordinate;
    }

    @Override
    public int hashCode() {
        final int prime = 33;
        int result = 1;
        result = prime * result + this.movedPiece.getPiecePosition();
        result = prime * result + this.destinationCoordinate;
        result = prime * result + this.movedPiece.hashCode();
        return result;
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Move)) {
            return false;
        }
        final Move otherMove = (Move) other;
        return this.getDestinationCoordinate() == otherMove.getDestinationCoordinate()
                && getMovedPiece() == otherMove.getMovedPiece()
                && getCurrentCoordinate() == otherMove.getCurrentCoordinate();
    }

    public int getDestinationCoordinate() {
        return this.destinationCoordinate;
    }

    public int getCurrentCoordinate() {
        return this.movedPiece.getPiecePosition();
    }

    public abstract boolean isAttack();
    public abstract boolean isCastlingMove();
    public abstract Piece getAttackedPiece();

    public Board execute() {
        final Board.Builder builder = new Board.Builder();
        for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
            // TODO hashcode and equals for pieces
            if (!this.movedPiece.equals(piece)) {
                builder.setPiece(piece);
            }
        }
        for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
            builder.setPiece(piece);
        }
        // move the piece
        builder.setPiece(this.movedPiece.movePiece(this));
        builder.setMoveMaker(this.board.currentPlayer().getOpponent().getPieceColor());
        return builder.build();
    }

    public Piece getMovedPiece() {
        return this.movedPiece;
    }
    
    @Override
    public String toString() {
        return Integer.toString(this.destinationCoordinate);
    }
}
