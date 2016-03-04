/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javalabra.shakki.engine.move.AttackMove;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Board.Builder;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.Bishop;
import javalabra.shakki.engine.pieces.King;
import javalabra.shakki.engine.pieces.Knight;
import javalabra.shakki.engine.pieces.Pawn;
import javalabra.shakki.engine.pieces.PieceColor;
import javalabra.shakki.engine.pieces.Queen;
import javalabra.shakki.engine.pieces.Rook;
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
public class PlayerTest {
    
    // calculateKingCastles-metodi puuttuu testeistä

    Builder boardBuilder;

    @Before
    public void setUp() {
        boardBuilder = new Board.Builder();
        // Black Layout
        boardBuilder.setPiece(new King(4, PieceColor.BLACK, true, true));
        // White Layout
        boardBuilder.setPiece(new King(60, PieceColor.WHITE, true, true));
        boardBuilder.setMoveMaker(PieceColor.WHITE);
    }

    @Test
    public void whitePlayerIsInCheckMate() {
        boardBuilder.setPiece(new Queen(43, PieceColor.BLACK));
        boardBuilder.setPiece(new Bishop(39, PieceColor.BLACK));
        Board board = boardBuilder.build();
        assertTrue(board.getWhitePlayer().isInCheckMate());
    }

    @Test
    public void whitePlayerIsInCheckReturnsCheck() {
        boardBuilder.setPiece(new Rook(12, PieceColor.BLACK));
        Board board = boardBuilder.build();
        assertTrue(board.getWhitePlayer().isInCheck());
    }

    @Test
    public void blackPlayerIsNotInCheck() {
        Board board = boardBuilder.build();
        assertFalse(board.getBlackPlayer().isInCheck());
    }

    @Test
    public void whitePlayerIsInStaleMate() {
        boardBuilder.setPiece(new Queen(43, PieceColor.BLACK));
        boardBuilder.setPiece(new Pawn(46, PieceColor.BLACK));
        boardBuilder.setPiece(new Knight(37, PieceColor.BLACK));
        Board board = boardBuilder.build();
        assertTrue(board.getWhitePlayer().isStaleMate());
    }

    @Test
    public void calculatesAttacksOnWhiteKingRightWhenAttacked() {
        boardBuilder.setPiece(new Bishop(39, PieceColor.BLACK));
        Board board = boardBuilder.build();
        Set<Move> onlyMove = new HashSet<>();
        onlyMove.add(new AttackMove(board, board.getTile(39).getPiece(), 60, board.getTile(60).getPiece()));
        Collection<Move> attackMoves = Player.calculateAttacksOnTile(60, board.getBlackPlayer().getLegalMoves());
        Set<Move> attackSet = new HashSet<>();
        attackSet.addAll(attackMoves);
        assertEquals(onlyMove, attackSet);
    }

    @Test
    public void calculatesAttacksOnWhiteKingRightWhenNotAttacked() {
        Board board = boardBuilder.build();
        Set<Move> onlyMove = new HashSet<>();
        Collection<Move> attackMoves = Player.calculateAttacksOnTile(60, board.getBlackPlayer().getLegalMoves());
        assertTrue(attackMoves.isEmpty());
    }
}
