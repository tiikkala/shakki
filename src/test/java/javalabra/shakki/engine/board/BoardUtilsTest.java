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
        assertEquals(false, BoardUtils.isValidTileCoordinate(-1));
    }
    
    @Test
    public void invalidTileCoordinateOverSixtyThree() {
        assertEquals(false, BoardUtils.isValidTileCoordinate(64));
    }
    
    @Test
    public void isValidTileCoordinateValid() {
        assertEquals(true, BoardUtils.isValidTileCoordinate(12));
    }
    
    @Test
    public void isFirstColumnFirstColumn() {
        assertEquals(true, BoardUtils.FIRST_COLUMN[0]);
    }
    
    @Test
    public void ifFirstColumnOnlyFirstColumn() {
        assertEquals(false, BoardUtils.FIRST_COLUMN[1]);
    }
    
    @Test
    public void isFirsRowFirstRow() {
        assertEquals(true, BoardUtils.FIRST_ROW[0]);
    }
    
    @Test
    public void isFirstRowisOnlyFirstRow() {
        assertEquals(false, BoardUtils.FIRST_ROW[8]);
    }
       
    @Test
    public void positiontoCoordinateReturnsCorrectCoordinate() {
        assertEquals((Integer) 8, BoardUtils.POSITION_TO_COORDINATE.get("a7"));
    }
}
    
