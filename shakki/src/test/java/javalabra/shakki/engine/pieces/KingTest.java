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
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author tapio
 */
public class KingTest {

    Builder boardBuilder;
    Board board;

    @Before
    public void setUp() {
        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));;
        // White Layout
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
        boardBuilder.setMoveMaker(PieceColor.BLACK);
        board = boardBuilder.build();
    }

    @Test
    public void blackPlayerHasCorrectNumberOfMoves() {     
        Collection<Move> legalMoves = board.getBlackPlayer().getLegalMoves();
        assertEquals(5, legalMoves.size());
    }

    @Test
    public void blackKingHasD8() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("d8"));
        assertTrue(blackLegals.contains(bm1));
    }

    @Test
    public void blackKingHasF8() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("f8"));
        assertTrue(blackLegals.contains(bm2));
    }

    @Test
    public void blackKingHasD7() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("d7"));
        assertTrue(blackLegals.contains(bm3));
    }

    @Test
    public void blackKingHasE7() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm4 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("e7"));
        assertTrue(blackLegals.contains(bm4));
    }

    @Test
    public void blackKingHasF7() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("f7"));
        assertTrue(blackLegals.contains(bm5));
    }

    @Test
    public void illegalMoveisIllegal() {
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("g8"));
        assertFalse(blackLegals.contains(bm5));
    }

}
