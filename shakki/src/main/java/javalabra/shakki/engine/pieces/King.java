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

    public King(final int piecePosition, final PieceColor pieceColor) {
        super(PieceType.KING, piecePosition, pieceColor, true);
    }

    public King(final int piecePosition, final PieceColor pieceColor, final boolean isFirstMove) {
        super(PieceType.KING, piecePosition, pieceColor, isFirstMove);
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
        return new King(move.getDestinationCoordinate(), move.getMovedPiece().getPieceColor());
    }
}
