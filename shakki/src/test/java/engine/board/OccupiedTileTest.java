package engine.board;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javalabra.shakki.engine.board.OccupiedTile;
import javalabra.shakki.engine.board.Tile;
import javalabra.shakki.engine.pieces.Knight;
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
public class OccupiedTileTest {
    
    Tile testTile;
    
    @Before
    public void setUp() {
        testTile = Tile.createTile(0, new Knight(0, PieceColor.WHITE));
    }
    
    @Test
    public void constructorSetsCorrectPiece() {      
        assertEquals(new Knight(0, PieceColor.WHITE), testTile.getPiece());
    }
    
    @Test
    public void isOccupiedTileOccupied() {
        assertEquals(true, testTile.isTileOccupied());
    }
}
