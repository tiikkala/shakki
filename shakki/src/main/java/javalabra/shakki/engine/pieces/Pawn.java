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
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.move.PawnAttackMove;
import javalabra.shakki.engine.move.PawnEnPassantAttack;
import javalabra.shakki.engine.move.PawnJump;
import javalabra.shakki.engine.move.PawnMove;
import javalabra.shakki.engine.move.PawnPromotion;

/**
 * Shakin sotilas.
 */
public class Pawn extends Piece {

    private static final int[] CANDIDATE_MOVE_COORDINATES = {7, 8, 9, 16};

    public Pawn(final int piecePosition, final PieceColor pieceColor) {
        super(PieceType.PAWN, piecePosition, pieceColor, true);
    }

    public Pawn(final int piecePosition,
            final PieceColor pieceColor,
            final boolean isFirstMove) {
        super(PieceType.PAWN, piecePosition, pieceColor, isFirstMove);
    }

    @Override
    public boolean equals(final Object other) {
        return this == other || other instanceof Pawn && (super.equals(other));
    }

    @Override
    public Collection<Move> calculateLegalMoves(final Board board) {
        final List<Move> legalMoves = new ArrayList<>();
        for (final int currentCandidateOffset : CANDIDATE_MOVE_COORDINATES) {
            int candidateDestinationCoordinate
                    = this.piecePosition + (this.pieceColor.getDirection() * currentCandidateOffset);
            if (!BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                continue;
            }
            if (currentCandidateOffset == 8 && !board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                if (this.pieceColor.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                    legalMoves.add(new PawnPromotion(
                            new PawnMove(board, this, candidateDestinationCoordinate)));
                } else {
                    legalMoves.add(new PawnMove(board, this, candidateDestinationCoordinate));
                }
            } else if (currentCandidateOffset == 16 && this.isFirstMove()
                    && ((BoardUtils.SECOND_ROW[this.piecePosition] && this.pieceColor.isBlack())
                    || (BoardUtils.SEVENTH_ROW[this.piecePosition] && this.pieceColor.isWhite()))) {
                final int behindCandidateDestinationCoordinate
                        = this.piecePosition + (this.pieceColor.getDirection() * 8);
                if (!board.getTile(candidateDestinationCoordinate).isTileOccupied()
                        && !board.getTile(behindCandidateDestinationCoordinate).isTileOccupied()) {
                    legalMoves.add(new PawnJump(board, this, candidateDestinationCoordinate));
                }
            } else if (currentCandidateOffset == 7
                    && !((BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceColor.isWhite())
                    || (BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceColor.isBlack()))) {

                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    final Piece pieceOnCandidate = board.getTile(candidateDestinationCoordinate).getPiece();
                    if (this.pieceColor != pieceOnCandidate.getPieceColor()) {
                        if (this.pieceColor.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                            legalMoves.add(new PawnPromotion(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate, pieceOnCandidate)));
                        } else {
                            legalMoves.add(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                        }
                    }
                } else if (board.getEnPassantPawn() != null) {
                    if (board.getEnPassantPawn().getPiecePosition() == (this.piecePosition + (this.pieceColor.getOppositeDirection()))) {
                        final Piece pieceOnCandidate = board.getEnPassantPawn();
                        if (this.pieceColor != pieceOnCandidate.getPieceColor()) {
                            if (this.pieceColor.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                                legalMoves.add(new PawnPromotion(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate)));
                            } else {
                                legalMoves.add(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                            }
                        }
                    }
                }
            } else if (currentCandidateOffset == 9
                    && !((BoardUtils.FIRST_COLUMN[this.piecePosition] && this.pieceColor.isWhite())
                    || (BoardUtils.EIGHTH_COLUMN[this.piecePosition] && this.pieceColor.isBlack()))) {

                if (board.getTile(candidateDestinationCoordinate).isTileOccupied()) {
                    if (this.pieceColor
                            != board.getTile(candidateDestinationCoordinate).getPiece().getPieceColor()) {
                        if (this.pieceColor.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                            legalMoves.add(new PawnPromotion(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate,
                                            board.getTile(candidateDestinationCoordinate).getPiece())));
                        } else {
                            legalMoves.add(
                                    new PawnAttackMove(board, this, candidateDestinationCoordinate,
                                            board.getTile(candidateDestinationCoordinate).getPiece()));
                        }
                    }
                } else if (board.getEnPassantPawn() != null) {
                    if (board.getEnPassantPawn().getPiecePosition() == (this.piecePosition - (this.pieceColor.getOppositeDirection()))) {
                        final Piece pieceOnCandidate = board.getEnPassantPawn();
                        if (this.pieceColor != pieceOnCandidate.getPieceColor()) {
                            if (this.pieceColor.isPawnPromotionSquare(candidateDestinationCoordinate)) {
                                legalMoves.add(new PawnPromotion(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate)));
                            } else {
                                legalMoves.add(
                                        new PawnEnPassantAttack(board, this, candidateDestinationCoordinate, pieceOnCandidate));
                            }
                        }
                    }
                }
            }
        }
        return ImmutableList.copyOf(legalMoves);
    }

    @Override
    public String toString() {
        return this.pieceType.toString();
    }

    public Piece getPromotionPiece() {
        return new Queen(this.piecePosition, this.pieceColor, false);
    }

    @Override
    public Pawn movePiece(Move move) {
        return new Pawn(move.getDestinationCoordinate(), move.getMovedPiece().getPieceColor());
    }
}
