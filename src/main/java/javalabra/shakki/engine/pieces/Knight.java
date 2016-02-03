/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.List;
import javalabra.shakki.engine.board.AttackMove;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.board.NormalMove;
import javalabra.shakki.engine.board.Tile;

/**
 *
 * @author tapio
 */
public class Knight extends Piece {

    private final static int[] CANDIDATE_MOVE_COORDINATES = {-17, -15, -10, -6, 6, 10, 15, 17};

    public Knight(final int piecePosition, final PieceColor color) {
        super(PieceType.KNIGHT, piecePosition, color);
    }

    public List<Move> calculateLegalMoves(final Board board) {
        int candidateDestinationCoordinate;
        final List<Move> legalMoves = new ArrayList<>();
        for (final int candidateCoordinateOffset : CANDIDATE_MOVE_COORDINATES) {
            candidateDestinationCoordinate = this.piecePosition + candidateCoordinateOffset;
            if (BoardUtils.isValidTileCoordinate(candidateDestinationCoordinate)) {
                if (isFirstColumnExclusion(this.piecePosition, candidateCoordinateOffset)
                        || isSecondColumnExclusion(this.piecePosition, candidateCoordinateOffset)
                        || isSeventhColumnExclusion(this.piecePosition, candidateCoordinateOffset)
                        || isEightColumnExclusion(this.piecePosition, candidateCoordinateOffset)) {
                    continue;
                }
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
        return BoardUtils.FIRST_COLUMN[currentPosition] && (candidatePosition == -17 || candidatePosition == -10
                || candidatePosition == 6 || candidatePosition == 15);
    }

    private static boolean isSecondColumnExclusion(final int currentPosition, final int candidatePosition) {
        return BoardUtils.SECOND_COLUMN[currentPosition] && (candidatePosition == -10 || candidatePosition == 6);
    }

    private static boolean isSeventhColumnExclusion(final int currentPosition, final int candidatePosition) {
        return BoardUtils.SEVENTH_COLUMN[currentPosition] && (candidatePosition == -6 || candidatePosition == 10);
    }

    private static boolean isEightColumnExclusion(final int currentPosition, final int candidatePosition) {
        return BoardUtils.EIGHTH_COLUMN[currentPosition] && (candidatePosition == -15 || candidatePosition == -6
                || candidatePosition == 10 || candidatePosition == 17);
    }

    @Override
    public String toString() {
        return PieceType.KNIGHT.toString();
    }
}
