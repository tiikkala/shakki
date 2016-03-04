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
public class QueenTest {

    // White Queen has 18 normal moves & 1 attacing move (calculate legal moves accepts moves that leave 
    // the player in check). White king has 5 possible moves.
    Builder boardBuilder;
    Board board;

    @Before
    public void setUp() {
        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK, true, true));
        boardBuilder.setPiece(new Queen(36, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Queen(54, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE, true, true));
        boardBuilder.setMoveMaker(PieceColor.WHITE);
        board = boardBuilder.build();
    }

    @Test
    public void whitePlayerHasCorrectNumberOfMoves() {
        Collection<Move> legalMoves = board.getWhitePlayer().getLegalMoves();
        assertEquals(24, legalMoves.size());
    }

    @Test
    public void whiteQueenHasH1() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("h1"));
        assertTrue(whiteLegals.contains(wm1));
    }

    @Test
    public void whiteQueenHasH2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("h2"));
        assertTrue(whiteLegals.contains(wm2));
    }

    @Test
    public void whiteQueenHasH3() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm3 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("h3"));
        assertTrue(whiteLegals.contains(wm3));
    }

    @Test
    public void whiteQueenHasG3() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm4 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("g3"));
        assertTrue(whiteLegals.contains(wm4));
    }

    @Test
    public void whiteQueenHasF3() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm5 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("f3"));
        assertTrue(whiteLegals.contains(wm5));
    }

    @Test
    public void whiteQueenHasF2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm6 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("f2"));
        assertTrue(whiteLegals.contains(wm6));
    }

    @Test
    public void whiteQueenHasF1() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm7 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("f1"));
        assertTrue(whiteLegals.contains(wm7));
    }

    @Test
    public void whiteQueenHasE2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm8 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("e2"));
        assertTrue(whiteLegals.contains(wm8));
    }

    @Test
    public void whiteQueenHasE4() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm9 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("e4"));
        assertTrue(whiteLegals.contains(wm9));
    }

    @Test
    public void whiteQueenHasD2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm10 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("d2"));
        assertTrue(whiteLegals.contains(wm10));
    }

    @Test
    public void whiteQueenHasC2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm11 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("c2"));
        assertTrue(whiteLegals.contains(wm11));
    }

    @Test
    public void whiteQueenHasB2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm12 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("b2"));
        assertTrue(whiteLegals.contains(wm12));
    }

    @Test
    public void illegalMoveisIllegal() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm13 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("g2"), BoardUtils.POSITION_TO_COORDINATE.get("e1"));
        assertFalse(whiteLegals.contains(wm13));
    }
}
