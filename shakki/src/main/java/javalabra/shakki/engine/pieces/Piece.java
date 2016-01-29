/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Move;

/**
 *
 * @author tapio
 */
public abstract class Piece {

    protected final int piecePosition;
    protected final PieceColor pieceColor;

    protected Piece(final int piecePosition, final PieceColor pieceColor) {
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);

    public PieceColor getPieceColor() {
        return this.pieceColor;
    }
}
