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

    protected final PieceType pieceType;
    protected final int piecePosition;
    protected final PieceColor pieceColor;
    protected final boolean isFirstMove;

    protected Piece(final PieceType pieceType,
                    final int piecePosition, 
                    final PieceColor pieceColor) {
        
        this.pieceColor = pieceColor;
        this.piecePosition = piecePosition;
        // more work here
        this.isFirstMove = false;
        this.pieceType = pieceType;
        
    }

    public abstract Collection<Move> calculateLegalMoves(final Board board);

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
    
}
