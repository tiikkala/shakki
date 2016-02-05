package javalabra.shakki.engine.board;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tapio
 */
public class BoardUtilsTest {
    
    @Test
    public void invalidTileCoordinateBelowZero() {
        assertFalse(BoardUtils.isValidTileCoordinate(-1));
    }
    
    @Test
    public void invalidTileCoordinateOverSixtyThree() {
        assertFalse(BoardUtils.isValidTileCoordinate(64));
    }
    
    @Test
    public void isValidTileCoordinateValid() {
        assertTrue(BoardUtils.isValidTileCoordinate(12));
    }
    
    @Test
    public void isFirstColumnFirstColumn() {
        assertTrue(BoardUtils.FIRST_COLUMN[0]);
    }
    
    @Test
    public void ifFirstColumnOnlyFirstColumn() {
        assertEquals(false, BoardUtils.FIRST_COLUMN[1]);
    }
    
    @Test
    public void isFirsRowFirstRow() {
        assertTrue(BoardUtils.FIRST_ROW[0]);
    }
    
    @Test
    public void isFirstRowisOnlyFirstRow() {
        assertFalse(BoardUtils.FIRST_ROW[8]);
    }
       
    @Test
    public void positiontoCoordinateReturnsCorrectCoordinate() {
        assertTrue(8 == BoardUtils.POSITION_TO_COORDINATE.get("a7"));
    }
}
    
