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
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.board.NormalMove;

/**
 *
 * @author tapio
 */
public class Pawn extends Piece {

    private static final int[] CANDIDATE_MOVE_COORDINATES = {7, 8, 9, 16};

    public Pawn(final int piecePosition, final PieceColor pieceColor) {
        super(PieceType.PAWN, piecePosition, pieceColor);
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate = this.piecePosition + currentCandidateOffset * this.pieceColor.getDirection();
            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }
            if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                // TODO: Luo erillinen PawnMove-luokka, promotions, en passe, attack
                legalMoves.add(new NormalMove(board, this, candidateDestinationCoordinate));
            } else if (candidateDestinationCoordinate == 16 && this.isFirstMove() && ((BoardUtils.SECOND_ROW[this.piecePosition]
                    && this.pieceColor.isWhite()) || (BoardUtils.SECOND_ROW[this.piecePosition] && this.pieceColor.isBlack()))) {
                final int behindCandidateDestinationCoordinate = this.piecePosition - this.pieceColor.getDirection() * 8;
                if (!board.getTile(behindCandidateDestinationCoordinate).isTileOccupied() && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new NormalMove(board, this, candidateDestinationCoordinate));
                }
            } else if (currentCandidateOffset == 7
                    && (!((BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceColor.isWhite())
                    || (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceColor.isBlack())))) {
                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceColor != pieceOnCandidate.pieceColor) {
                        legalMoves.add(new NormalMove(board, this, candidateDestinationCoordinate));
                    }
                }
            } else if (currentCandidateOffset == 9
                    && (!((BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceColor.isWhite())
                    || (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceColor.isBlack())))) {
                legalMoves.add(new NormalMove(board, this, candidateDestinationCoordinate));
            }
            if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                if (this.pieceColor != pieceOnCandidate.pieceColor) {
                    legalMoves.add(new NormalMove(board, this, candidateDestinationCoordinate));
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public String toString() {
        return PieceType.PAWN.toString();
    }
}
