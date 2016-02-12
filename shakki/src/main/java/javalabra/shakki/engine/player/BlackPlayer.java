/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.KingSideCastleMove;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.board.QueenSideCastleMove;
import javalabra.shakki.engine.board.Tile;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.PieceColor;
import javalabra.shakki.engine.pieces.Rook;

/**
 *Musta pelaaja.
 */
public class BlackPlayer extends Player {

    public BlackPlayer(final Board board, final Collection<Move> blackStandardLegalMoves,
            final Collection<Move> whiteStandardLegalMoves) {
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
        return this.board.getWhitePlayer();
    }

    @Override
    public Collection<Move> calculateKingCastles(Collection<Move> playersLegalMoves, Collection<Move> opponentsLegalMoves) {
        final List<Move> kingCastles = new ArrayList<>();
        if (this.playerKing.isFirstMove() && !this.isInCheck()) {
            if (!this.board.getTile(5).isTileOccupied() && !this.board.getTile(6).isTileOccupied()) {
                final Tile rookTile = this.board.getTile(7);
                if (rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()) {
                    if (Player.calculateAttacksOnTile(5, opponentsLegalMoves).isEmpty()
                            && Player.calculateAttacksOnTile(6, opponentsLegalMoves).isEmpty()) {
                        kingCastles.add(new KingSideCastleMove(
                                this.board,
                                this.playerKing,
                                6,
                                (Rook) rookTile.getPiece(),
                                rookTile.getTileCoordinate(),
                                5));
                    }
                }
            }
            if (!this.board.getTile(1).isTileOccupied() && !this.board.getTile(2).isTileOccupied()
                    && this.board.getTile(3).isTileOccupied()) {
                final Tile rookTile = this.board.getTile(0);
                if (rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove()) {
                    kingCastles.add(new QueenSideCastleMove(
                            this.board,
                            this.playerKing,
                            2,
                            (Rook) rookTile.getPiece(),
                            rookTile.getTileCoordinate(),
                            3));
                }
            }
        }
        return ImmutableList.copyOf(kingCastles);
    }
}
