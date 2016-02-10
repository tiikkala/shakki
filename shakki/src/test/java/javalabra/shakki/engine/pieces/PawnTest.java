/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import java.util.Collection;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.board.Move;
import javalabra.shakki.engine.board.MoveFactory;
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
public class PawnTest {

    // Test for nomal pawn moves. Pawn can move forward or attack.
    Board.Builder boardBuilder;
    Board board;

    @Before
    public void setUp() {
        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        boardBuilder.setPiece(new Pawn(36, PieceColor.BLACK));
        // White Layout
        boardBuilder.setPiece(new Pawn(45, PieceColor.WHITE));
        boardBuilder.setPiece(new King(60, PieceColor.WHITE));
        boardBuilder.setMoveMaker(PieceColor.WHITE);
        board = boardBuilder.build();
    }

    @Test
    public void whitePlayerHasCorrectNumberOfMoves() {
        Collection<Move> legalMoves = board.getWhitePlayer().getLegalMoves();
        assertEquals(7, legalMoves.size());
    }
    
   @Test
    public void whitePawnHasF4() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm1 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f3"), BoardUtils.POSITION_TO_COORDINATE.get("f4"));
        assertTrue(whiteLegals.contains(wm1));
    }

    @Test
    public void whitePawnHasH2() {
        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Move wm2 = MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("f3"), BoardUtils.POSITION_TO_COORDINATE.get("e4"));
        assertTrue(whiteLegals.contains(wm2));
    }

}
