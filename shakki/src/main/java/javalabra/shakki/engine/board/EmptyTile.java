/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;
import javalabra.shakki.engine.pieces.Piece;

/**
 *Tyhjä ruutu.
 */
public class EmptyTile extends Tile {
    
    public EmptyTile(final int tileCoordinate) {
        super(tileCoordinate);
    }
    
    @Override
    public boolean isTileOccupied() {
        return false;
    }
    
    @Override public Piece getPiece() {
        return null;
    }
    
    @Override public String toString() {
        return "–";
    }
           
}
