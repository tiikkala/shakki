/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;
import javalabra.shakki.engine.pieces.Piece;

/**
 *
 * @author tapio
 */
public final class OccupiedTile extends Tile {
    
    private final Piece pieceOnTile;
    
    public OccupiedTile(final int tileCoordinate, final Piece pieceOnTile) {
        super(tileCoordinate);
        this.pieceOnTile = pieceOnTile;
    }
    
    @Override
    public boolean isTileOccupied() {
        return true;
    }
    
    @Override
    public Piece getPiece() {
        return this.pieceOnTile;
    }
    
    @Override
    public String toString() {
        return getPiece().getPieceColor().isBlack() ? getPiece().toString().toLowerCase() :
                    getPiece().toString();
    }
    
}
