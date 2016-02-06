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
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author tapio
 */
public class RookTest {

    @Test
    public void testMiddleRookOnEmptyBoard() {

        final Builder builder = new Builder();

        // Black Layout
        builder.setPiece(new King(4, PieceColor.BLACK));
        // White Layout
        builder.setPiece(new Rook(36, PieceColor.WHITE));
        builder.setPiece(new King(60, PieceColor.WHITE));
        // Set the current player
        builder.setMoveMaker(PieceColor.WHITE);

        final Board board = builder.build();

        final Collection<Move> whiteLegals = board.getWhitePlayer().getLegalMoves();
        final Collection<Move> blackLegals = board.getBlackPlayer().getLegalMoves();

        assertEquals(whiteLegals.size(), 18);
        assertEquals(blackLegals.size(), 5);
        assertTrue(whiteLegals.contains(MoveFactory.createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e8"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e7"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e6"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e5"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e3"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("e2"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("a4"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("b4"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("c4"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("d4"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("f4"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("g4"))));
        assertTrue(whiteLegals.contains(MoveFactory
                .createMove(board, BoardUtils.POSITION_TO_COORDINATE.get("e4"), BoardUtils.POSITION_TO_COORDINATE.get("h4"))));
    }
}
