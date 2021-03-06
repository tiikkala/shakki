/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.Move;

/**
 *
 * @author tapio
 */
public abstract class Piece {

    protected final PieceType pieceType;
    protected final int piecePosition;
    protected final PieceColor pieceColor;
    protected final boolean isFirstMove;
    private final int cachedHashCode;

    protected Piece(final PieceType pieceType,
            final int piecePosition,
            final PieceColor pieceColor,
            final boolean isFirstMove) {
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
        this.isFirstMove = isFirstMove;
        this.pieceType = pieceType;
        this.cachedHashCode = computeHashCode();
    }

    /**
     * Metodi määrittää, mihin nappula voi liikkua pelilaudalla. Metodin palauttamassa
     * listassa on mukana myös siirtoja, jotka ovat pelin sääntöjen vastaisia, koska
     * ne jättävät pelaajan kuninkaan uhatuksi.
     * @param board pelilauta
     * @return lista siirroista, jotka nappula voi tehdä
     */
    public abstract Collection<Move> calculateLegalMoves(final Board board);

    @Override
    public int hashCode() {
        return this.cachedHashCode;
    }

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }

    public boolean isFirstMove() {
        return this.isFirstMove;
    }

    public int getPiecePosition() {
        return this.piecePosition;
    }

    public PieceType getPieceType() {
        return this.pieceType;
    }
/**
 * Metodi palauttaa nappulan, jonka sijainti pelilaudalla on päivitetty
 * vastaamaan nappulan sijaintia siirron jälkeen. 
 * @param move siirto, joka tehdään
 * @return siirretty nappula
 */    
    public abstract Piece movePiece(final Move move);

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Piece)) {
            return false;
        }
        final Piece otherPiece = (Piece) other;
        return this.piecePosition == otherPiece.getPiecePosition()
                && this.pieceType == otherPiece.getPieceType()
                && this.pieceColor == otherPiece.getPieceColor()
                && this.isFirstMove == otherPiece.isFirstMove();
    }

    private int computeHashCode() {
        int result = pieceType.hashCode();
        result = 31 * result + pieceColor.hashCode();
        result = 31 * result + piecePosition;
        result = 31 * result + (isFirstMove ? 1 : 0);
        return result;
    }
}
