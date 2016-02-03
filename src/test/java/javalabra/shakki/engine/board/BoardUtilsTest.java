package javalabra.shakki.engine.board;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class BoardUtilsTest {
    
    @Test
    public void invalidCoordinateBelowZero() {
        assertEquals(false, BoardUtils.isValidTileCoordinate(-1));
    }
    
    @Test
    public void invalidCoordinateOverSixtyFour() {
        assertEquals(false, BoardUtils.isValidTileCoordinate(64));
    }
    
    @Test
    public void isvalidCoordinate() {
        assertEquals(true, BoardUtils.isValidTileCoordinate(12));
    }
    
    @Test
    public void isFirstColumn() {
        assertEquals(true, BoardUtils.FIRST_COLUMN[0]);
    }
    
    @Test
    public void firstColumnIsOnlyFirstColumn() {
        assertEquals(false, BoardUtils.FIRST_COLUMN[1]);
    }
    
    @Test
    public void isFirsRow() {
        assertEquals(true, BoardUtils.FIRST_ROW[0]);
    }
    
    @Test
    public void firstRowisOnlyFirstRow() {
        assertEquals(false, BoardUtils.FIRST_ROW[8]);
    }
    
    @Test
    public void testAlgebraicNotation() {
        assertEquals("a8", BoardUtils.ALGEBRAIC_NOTATION[0]);
    }
    
    @Test
    public void testPositiontoCoordinate() {
        assertEquals((long) 8, (long) BoardUtils.POSITION_TO_COORDINATE.get("a7"));
    }
}
    
