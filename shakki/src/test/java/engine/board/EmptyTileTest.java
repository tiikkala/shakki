package engine.board;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.Map;
import javalabra.shakki.engine.board.EmptyTile;
import javalabra.shakki.engine.board.Tile;
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
public class EmptyTileTest {
    
    Tile testTile;
    
    @Before
    public void setUp() {  
        testTile = Tile.createTile(0, null);
    }
    
    @Test public void emptyTileisEmpty() {
        assertEquals(false, testTile.isTileOccupied());
    }
}
