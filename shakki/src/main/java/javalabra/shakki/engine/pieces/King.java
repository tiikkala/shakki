/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javalabra.shakki.engine.move.AttackMove;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.move.NormalMove;
import javalabra.shakki.engine.board.Tile;

/**
 * Shakin kuningas.
 */
public class King extends Piece {

    private static final int[] CANDIDATE_MOVE_COORDINATES = {-9, -8, -7, -1, 1, 7, 8, 9};

    private final boolean isCastled;
    private final boolean kingSideCastleCapable;
    private final boolean queenSideCastleCapable;

    public King(final int piecePosition, final PieceColor pieceColor,
            final boolean kingSideCastleCapabel,
            final boolean queenSideCastleCapable) {
        super(PieceType.KING, piecePosition, pieceColor, true);
        this.isCastled = false;
        this.kingSideCastleCapable = kingSideCastleCapabel;
        this.queenSideCastleCapable = queenSideCastleCapable;
    }

    public King(final int piecePosition,
            final PieceColor pieceColor,
            final boolean isFirstMove,
            final boolean isCastled,
            final boolean kingSideCastleCapable,
            final boolean queenSideCastleCapable) {
        super(PieceType.KING, piecePosition, pieceColor, isFirstMove);
        this.isCastled = isCastled;
        this.kingSideCastleCapable = kingSideCastleCapable;
        this.queenSideCastleCapable = queenSideCastleCapable;
    }

    @Override
    public Collection<Move> calculateLegalMoves(Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            final int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset;
            if (isFirstColumnExclusion(this.piecePosition, candidateDestinationCoordinate)
                    || isEightColumnExclusion(this.piecePosition, candidateDestinationCoordinate)) {
                continue;
            }
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                final Tile candidateDestinationTile = board.getTile(candidateDestinationCoordinate);
                if (!candidateDestinationTile.isTileOccupied()) {
                    legalMoves.add(new NormalMove(board, this, candidateDestinationCoordinate));
                } else {
                    final Piece pieceAtDestination = candidateDestinationTile.getPiece();
                    final PieceColor pieceColor = pieceAtDestination.getPieceColor();
                    if (this.pieceColor != pieceColor) {
                        legalMoves.add(new AttackMove(board, this, candidateDestinationCoordinate, pieceAtDestination));
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public boolean equals(final Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof King)) {
            return false;
        }
        if (!super.equals(other)) {
            return false;
        }
        final King king = (King) other;
        return isCastled == king.isCastled;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (isCastled ? 1 : 0);
        return result;
    }

    public boolean isCastled() {
        return this.isCastled;
    }

    public boolean isKingSideCastleCapable() {
        return this.kingSideCastleCapable;
    }

    public boolean isQueenSideCastleCapable() {
        return this.queenSideCastleCapable;
    }

    private static boolean isFirstColumnExclusion(final int currentPosition, final int candidatePosition) {
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidatePosition == -1 || candidatePosition == -9
                || candidatePosition == 7);
    }

    private static boolean isEightColumnExclusion(final int currentPosition, final int candidatePosition) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidatePosition == -7 || candidatePosition == 1
                || candidatePosition == 9);
    }

    @Override
    public String toString() {
        return PieceType.KING.toString();
    }

    @Override
    public King movePiece(Move move) {
        return new King(move.getDestinationCoordinate(), move.getMovedPiece().getPieceColor(), false, move.isCastlingMove(), false, false);
    }
}
