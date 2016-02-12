/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.pieces.Piece;

/**
 *Siirto-luokka, joka tarjoaa metodin siirron toteuttamiseen.
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
        return getDestinationCoordinate() == otherMove.getDestinationCoordinate()
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
    /**
     * Metodi kertoo, onko kyseessä tornitussiirto.
     */
    public abstract boolean isCastleMove();
    public abstract Piece getAttackedPiece();

    /**
     * Metodi toteuttaa siirron luomalla uuden pelilaudan, jossa kyseinen siirto on tehty ja
     * siirtovuoro siirretty seuraavalle pelaajalle.
     * @return palauttaa pelilaudan
     */  
    public Board execute() {
        final Builder builder = new Board.Builder();
        for (final Piece piece : this.board.currentPlayer().getActivePieces()) {
            if (!this.movedPiece.equals(piece)) {
                builder.setPiece(piece);
            }
        }
        for (final Piece piece : this.board.currentPlayer().getOpponent().getActivePieces()) {
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
