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
public class AttackMove extends Move {
    
    final Piece attackedPiece;
    
    public AttackMove(final Board board, final Piece movedPiece,
                            final int destinationCoordinate, final Piece attackedPiece) {
        super(board, movedPiece, destinationCoordinate);
        this.attackedPiece = attackedPiece;
    }  
}
