/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.pieces.King;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.PieceColor;

/**
 *
 * @author tapio
 */
public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;

    Player(final Board board,
            final Collection<Move> legalMoves,
            final Collection<Move> opponentMoves) {

        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = legalMoves;
    }

    private King establishKing() {
        for (final Piece piece : getActivePieces()) {
            if (piece.getPieceType().isKing()) {
                return (King) piece;
            }
        }
        throw new RuntimeException("Should not reach here! Not a valid board!");
    }
    
        public boolean isMoveLegal(Move move) {
        return this.legalMoves.contains(move);
    }
    
    public boolean isCheck() {
        return false;
    }
    
    public boolean isCheckMate() {
        return false;
    }
    
    public boolean isStaleMate() {
        return false;
    }
    
    public boolean isCastled() {
        return false;
    }
    
    public MoveTransision makeMove(final Move move) {
        return null;
    }

    public abstract Collection<Piece> getActivePieces();
    public abstract PieceColor getPieceColor();
    public abstract Player getOpponent();
}
