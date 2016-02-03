/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.PieceColor;

/**
 *
 * @author tapio
 */
public class BlackPlayer extends Player {

    public BlackPlayer(Board board, Collection<Move> blackStandardLegalMoves,
            Collection<Move> whiteStandardLegalMoves) {
        super(board, blackStandardLegalMoves, whiteStandardLegalMoves);
    }

    @Override
    public Collection<Piece> getActivePieces() {
       return this.board.getBlackPieces();
    }

    @Override
    public PieceColor getPieceColor() {
      return PieceColor.BLACK;
    }

    @Override
    public Player getOpponent() {
        return this.board.getBlackPlayer();
    }
    
}
