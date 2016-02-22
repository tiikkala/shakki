/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.move.NormalMove;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.pieces.King;
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
public class MoveTest {

    Board boardAfterTheMove;
    Move move;
    Board testBoardTempalate;

    @Before
    public void setUp() {
        Builder boardBuilder = new Board.Builder();
        // black layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK));
        // white layout
        boardBuilder.setPiece(new King(61, PieceColor.WHITE));
        boardBuilder.setMoveMaker(PieceColor.BLACK);
        boardAfterTheMove = boardBuilder.build();
        Builder testBoardBuilder = new Board.Builder();
        // Black Layout
        testBoardBuilder.setPiece(new King(4, PieceColor.BLACK));
        // White Layout
        testBoardBuilder.setPiece(new King(60, PieceColor.WHITE));
        testBoardBuilder.setMoveMaker(PieceColor.WHITE);
        testBoardTempalate = testBoardBuilder.build();
        move = new NormalMove(testBoardTempalate, testBoardTempalate.getTile(60).getPiece(), 61);
    }

    @Test
    public void executeMoveReturnsBoardWithThePieceMovedToCorrecPosition() {
        Board testBoard = move.execute();
        assertEquals(boardAfterTheMove.getTile(61).getPiece(), testBoard.getTile(61).getPiece());
    }

    @Test
    public void executeMoveReturnBoardWithAllUnmovedPiecesAPlace() {
        Board testBoard = move.execute();
        assertEquals(boardAfterTheMove.getTile(4).getPiece(), testBoard.getTile(4).getPiece());
    }

    @Test
    public void afterWhiteMoveIsExecutedItIsBlackPlayersTurn() {
        Board testBoard = move.execute();
        assertTrue(testBoard.currentPlayer().getPieceColor().isBlack());
    }

}
