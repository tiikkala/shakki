/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javalabra.shakki.engine.board.BoardUtils;
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
        assertEquals(false, BoardUtils.isValidTileCoordinate(65));
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
    public void firstColumnisOnlyFirstColumn() {
        assertEquals(false, BoardUtils.FIRST_COLUMN[1]);
    }
}
