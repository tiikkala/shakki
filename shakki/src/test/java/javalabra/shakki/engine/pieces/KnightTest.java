/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.board.MoveFactory;
import javalabra.shakki.engine.pieces.Knight;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.PieceColor;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tapio
 */
public class KnightTest {

    @Test
    public void testLegalMoveAllAvailable() {

        final Builder boardBuilder = new Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        boardBuilder.setPiece(new Knight(28, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Knight(36, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
        // Set the current player
        boardBuilder.setMoveMaker(PieceColor.WHITE);

        final Board board = boardBuilder.build();

        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();

        assertEquals(whiteLegals.size(), 13);
        assertEquals(blackLegals.size(), 13);

        final Move wm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d6"));
        final Move wm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f6"));
        final Move wm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c5"));
        final Move wm4 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g5"));
        final Move wm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c3"));
        final Move wm6 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g3"));
        final Move wm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d2"));
        final Move wm8 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f2"));

        assertTrue(whiteLegals.contains(wm1));
        assertTrue(whiteLegals.contains(wm2));
        assertTrue(whiteLegals.contains(wm3));
        assertTrue(whiteLegals.contains(wm4));
        assertTrue(whiteLegals.contains(wm5));
        assertTrue(whiteLegals.contains(wm6));
        assertTrue(whiteLegals.contains(wm7));
        assertTrue(whiteLegals.contains(wm8));

        final Move bm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("d7"));
        final Move bm2 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("f7"));
        final Move bm3 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("c6"));
        final Move bm4 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("g6"));
        final Move bm5 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("c4"));
        final Move bm6 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("g4"));
        final Move bm7 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("d3"));
        final Move bm8 = MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e5"), BoardUtils.POSITION_TO_COORDINATE.get("f3"));

        assertTrue(blackLegals.contains(bm1));
        assertTrue(blackLegals.contains(bm2));
        assertTrue(blackLegals.contains(bm3));
        assertTrue(blackLegals.contains(bm4));
        assertTrue(blackLegals.contains(bm5));
        assertTrue(blackLegals.contains(bm6));
        assertTrue(blackLegals.contains(bm7));
        assertTrue(blackLegals.contains(bm8));

    }
}
