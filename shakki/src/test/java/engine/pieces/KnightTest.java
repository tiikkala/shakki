/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package engine.pieces;

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
    
    @Before
    public void setUp() {
        testPiece = new Knight(0, PieceColor.WHITE);
    }
    
    @Test
    public void constructorSetsCorrectPieceColor() {
        assertEquals(PieceColor.WHITE, testPiece.getPieceColor());
    }
    
    @After
    public void tearDown() {
    }

}
