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
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.move.MoveFactory;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tapio
 */
public class RookTest {

    // Black rook with 11 normal moves & 1 attacing move (calculate legal moves accepts moves that leave 
    // the player in check). Black King has 5 possible moves.
    Builder boardBuilder;
    Board board;

    @Before
    public void setUp() {
        boardBuilder = new Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        boardBuilder.setPiece(new Rook(36, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Rook(52, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
        boardBuilder.setMoveMaker(PieceColor.WHITE);
        board = boardBuilder.build();
    }

    @Test
    public void blackPlayerHasCorrectNumberofMoves() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        assertEquals(17, blackLegals.size());
    }

    @Test
    public void blackRookHasE5() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e5"));
        assertTrue(blackLegals.contains(bm1));
    }

    @Test
    public void blackRookHasE6() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e6"));
        assertTrue(blackLegals.contains(bm2));
    }

    @Test
    public void blackRookHasE7() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e7"));
        assertTrue(blackLegals.contains(bm3));
    }

    @Test
    public void blackRookHasF4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm4 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f4"));
        assertTrue(blackLegals.contains(bm4));
    }

    @Test
    public void blackRookHasG4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g4"));
        assertTrue(blackLegals.contains(bm5));
    }

    @Test
    public void blackRookHasH4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm6 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("h4"));
        assertTrue(blackLegals.contains(bm6));
    }

    @Test
    public void blackRookHasD4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d4"));
        assertTrue(blackLegals.contains(bm7));
    }

    @Test
    public void blackRookHasC4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm8 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c4"));
        assertTrue(blackLegals.contains(bm8));
    }

    @Test
    public void blackRookHasB4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm9 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("b4"));
        assertTrue(blackLegals.contains(bm9));
    }

    @Test
    public void blackRookHasA4() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm10 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("a4"));
        assertTrue(blackLegals.contains(bm10));
    }

    @Test
    public void blackRookHasE3() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm11 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e3"));
        assertTrue(blackLegals.contains(bm11));
    }

    @Test
    public void blackRookHasE2() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm12 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e2"));
        assertTrue(blackLegals.contains(bm12));
    }

    @Test
    public void illegalMoveisIllegal() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("h1"));
        assertFalse(blackLegals.contains(bm5));
    }
}
