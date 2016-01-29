/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;
import javalabra.shakki.engine.pieces.Piece;

/**
 *
 * @author tapio
 */
public abstract class Tile {

    protected final int tileCoordinate;
    private static final Map<Integer, EmptyTile> EMPTY_TILES_CACHE = createAllPossibleEmptyTiles();

    private static Map<Integer, EmptyTile> createAllPossibleEmptyTiles() {
        final Map<Integer, EmptyTile> emptyTileMap = new HashMap();
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            EMPTY_TILES_CACHE.put(i, new EmptyTile(i));
        }
        return ImmutableMap.copyOf(emptyTileMap);
    }

    public Tile(final int tileCoordinate) {
        this.tileCoordinate = tileCoordinate;
    }
    
    public static Tile createTile(final int tileCoordinate, final Piece piece) {
        return piece != null ? new OccupiedTile(tileCoordinate, piece) : EMPTY_TILES_CACHE.get(tileCoordinate);
    }

    public abstract boolean isTileOccupied();

    public abstract Piece getPiece();
}