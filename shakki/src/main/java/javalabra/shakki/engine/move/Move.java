/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.pieces.Piece;

/**
 * Siirto-luokka, joka tarjoaa metodin siirron toteuttamiseen.
 */
public abstract class Move {

    protected final Board board;
    protected final Piece movedPiece;
    protected final int destinationCoordinate;
    protected final boolean isFirstMove;

    public static final Move NULL_MOVE = new NullMove();

    public Move(final Board board,
            final Piece pieceMoved,
            final int destinationCoordinate) {
        this.board = board;
        this.destinationCoordinate = destinationCoordinate;
        this.movedPiece = pieceMoved;
        this.isFirstMove = pieceMoved.isFirstMove();
    }

    public Move(final Board board,
            final int destinationCoordinate) {
        this.board = board;
        this.destinationCoordinate = destinationCoordinate;
        this.movedPiece = null;
        this.isFirstMove = false;
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
    
    public Board getBoard() {
        return this.board;
    }

    /**
     * Metodi kertoo, onko kyseessä hyökkäysiirto.
     */
    public abstract boolean isAttack();

    /**
     * Metodi kertoo, onko kyseessä tornitussiirto.
     */
     public boolean isCastlingMove() {
        return false;
    }

    /**
     * Palauttaa nappulan, joka syödään hyökkäyssiirrossa
     * @return Piece, syötävä nappula
     */
    public abstract Piece getAttackedPiece();

    /**
     * Metodi toteuttaa siirron luomalla uuden pelilaudan, jossa kyseinen siirto
     * on tehty ja siirtovuoro siirretty seuraavalle pelaajalle.
     *
     * @return Board, pelilauta, jossa siirto on tehty
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
        // nappulan siirtäminen
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
