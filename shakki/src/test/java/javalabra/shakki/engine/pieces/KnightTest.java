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
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tapio
 */
public class KnightTest {

    // Black and white knight positioned on an empty board. For white 7 normal moves & 1 attacking move,
    // for black 6 normal moves & 1 attacking move.
    Builder boardBuilder;

    @Before
    public void setUp() {
        boardBuilder = new Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        boardBuilder.setPiece(new Knight(21, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Knight(36, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
    }

    private Board buildForWhite() {
        boardBuilder.setMoveMaker(PieceColor.WHITE);
        return boardBuilder.build();
    }

    private Board buildForBlack() {
        boardBuilder.setMoveMaker(PieceColor.BLACK);
        return boardBuilder.build();
    }

    @Test
    public void whitePlayerHasCorrectNumberofMoves() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        assertEquals(13, whiteLegals.size());
    }

    @Test
    public void blackPlayerHasCorrectNumberofMoves() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        assertEquals(12, blackLegals.size());
    }

    @Test
    public void whiteKnightHasD6() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d6"));
        assertTrue(whiteLegals.contains(wm1));
    }

    @Test
    public void whiteKnightHasF6() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f6"));
        assertTrue(whiteLegals.contains(wm2));
    }

    @Test
    public void whiteKnightHasC5() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c5"));
        assertTrue(whiteLegals.contains(wm3));
    }

    @Test
    public void whiteKnightHasG5() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm4 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g5"));
        assertTrue(whiteLegals.contains(wm4));
    }

    @Test
    public void whiteKnightHasC3() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c3"));
        assertTrue(whiteLegals.contains(wm5));
    }

    @Test
    public void whiteKnightHasF2() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm6 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f2"));
        assertTrue(whiteLegals.contains(wm6));
    }

    @Test
    public void whiteKnightHasD2() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d2"));
        assertTrue(whiteLegals.contains(wm7));
    }

    @Test
    public void whiteKnightHasG3() {
        final Board board = buildForWhite();
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm8 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g3"));
        assertTrue(whiteLegals.contains(wm8));
    }

    @Test
    public void blackKnightHasG8() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("g8"));
        assertTrue(blackLegals.contains(bm1));
    }

    @Test
    public void blackKnightHasG4() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("g4"));
        assertTrue(blackLegals.contains(bm2));
    }

    @Test
    public void blackKnightHasE4() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("e4"));
        assertTrue(blackLegals.contains(bm3));
    }

    @Test
    public void blackKnightHasH7() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("h7"));
        assertTrue(blackLegals.contains(bm5));
    }

    @Test
    public void blackKnightHasH5() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm6 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("h5"));
        assertTrue(blackLegals.contains(bm6));
    }

    @Test
    public void blackKnightHasD5() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("d5"));
        assertTrue(blackLegals.contains(bm7));
    }

    @Test
    public void blackKnightHasD7() {
        final Board board = buildForBlack();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f6"), BoardUtils.POSITION_TO_COORDINATE.get("d7"));
        assertTrue(blackLegals.contains(bm7));
    }

    @Test
    public void illegalWhiteMoveisIllegal() {
        final Board board = buildForWhite();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("h1"));
        assertFalse(blackLegals.contains(bm5));
    }

    @Test
    public void illegalBlackMoveisIllegal() {
        final Board board = buildForWhite();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();
        final Move bm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e8"), BoardUtils.POSITION_TO_COORDINATE.get("h1"));
        assertFalse(blackLegals.contains(bm5));
    }
}
