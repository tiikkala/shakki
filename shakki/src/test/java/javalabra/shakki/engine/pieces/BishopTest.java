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
public class BishopTest {

    // Black Bishop with 11 normal moves & 1 attacing move (calculate legal moves accepts moves that leave 
    // the player in check). White king has 5 possible moves.
    Builder boardBuilder;
    Board board;

    @Before
    public void setUp() {
        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK, true, true));
        boardBuilder.setPiece(new Bishop(36, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Bishop(54, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE, true, true));
        boardBuilder.setMoveMaker(PieceColor.BLACK);
        board = boardBuilder.build();
    }

    @Test
    public void blackPlayerHasCorrectNumberofMoves() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        assertEquals(17, blackLegals.size());
    }

    @Test
    public void blackBishopHasF5() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f5"));
        assertTrue(blackLegals.contains(bm1));
    }

    @Test
    public void blackBishopHasG6() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g6"));
        assertTrue(blackLegals.contains(bm2));
    }

    @Test
    public void blackBishopHasH7() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("h7"));
        assertTrue(blackLegals.contains(bm3));
    }

    @Test
    public void blackBishopHasD5() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm4 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d5"));
        assertTrue(blackLegals.contains(bm4));
    }

    @Test
    public void blackBishopHasC6() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c6"));
        assertTrue(blackLegals.contains(bm5));
    }

    @Test
    public void blackBishopHasB7() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm6 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("b7"));
        assertTrue(blackLegals.contains(bm6));
    }

    @Test
    public void blackBishopHasA8() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("a8"));
        assertTrue(blackLegals.contains(bm7));
    }

    @Test
    public void blackBishopHasD3() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm8 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d3"));
        assertTrue(blackLegals.contains(bm8));
    }

    @Test
    public void blackBishopHasC2() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm9 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c2"));
        assertTrue(blackLegals.contains(bm9));
    }

    @Test
    public void blackBishopHasB1() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm10 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("b1"));
        assertTrue(blackLegals.contains(bm10));
    }

    @Test
    public void blackBishopHasF3() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm11 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f3"));
        assertTrue(blackLegals.contains(bm11));
    }

    @Test
    public void blackBishopHasG2() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm12 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g2"));
        assertTrue(blackLegals.contains(bm12));
    }

    @Test
    public void illegalMoveisIllegal() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("h8"));
        assertFalse(blackLegals.contains(bm5));
    }
}
