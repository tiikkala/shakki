/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import javalabra.shakki.engine.board.Board;
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

    Piece testPiece;

    @Test
    public void constructorSetsCorrectPieceColor() {
        testPiece = new Knight(0, PieceColor.WHITE);
        assertEquals(PieceColor.WHITE, testPiece.getPieceColor());
    }

//    @Test
//    public void knightAlmostTopLeftCorner() {
//        Board board = new Board();
//        testPiece = new Knight(9, PieceColor.WHITE);
//        assertEquals(4, testPiece.calculateLegalMoves(board).size());
//    }
//    
//    @Test
//    public void knightTopLeftCorner() {
//        Board board = new Board();
//        testPiece = new Knight(0, PieceColor.WHITE);
//        assertEquals(3, testPiece.calculateLegalMoves(board).size());
//    }
}
