/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.Map;

/**
 *Utility-luokka apumetodeille.
 */
public class BoardUtils {

    /**
     *Apulistoja, joiden avulla voi helposti tutkia, sijaitseeko jonkin nappula
     * tai ruutu tietyllä rivillä tai sarakkeella.
     */
    public static final boolean[] FIRST_COLUMN = initColumn(0);
    public static final boolean[] SECOND_COLUMN = initColumn(1);
    public static final boolean[] THIRD_COLUMN = initColumn(2);
    public static final boolean[] FOURTH_COLUMN = initColumn(3);
    public static final boolean[] FIFTH_COLUMN = initColumn(4);
    public static final boolean[] SIXTH_COLUMN = initColumn(5);
    public static final boolean[] SEVENTH_COLUMN = initColumn(6);
    public static final boolean[] EIGHTH_COLUMN = initColumn(7);
    public static final boolean[] FIRST_ROW = initRow(0);
    public static final boolean[] SECOND_ROW = initRow(8);
    public static final boolean[] THIRD_ROW = initRow(16);
    public static final boolean[] FOURTH_ROW = initRow(24);
    public static final boolean[] FIFTH_ROW = initRow(32);
    public static final boolean[] SIXTH_ROW = initRow(40);
    public static final boolean[] SEVENTH_ROW = initRow(48);
    public static final boolean[] EIGHTH_ROW = initRow(56);

    /**
     *Vakioita esimerkiksi for-looppien kirjoittamisen helpottamiseksi.
     */
    public static final int START_TILE_INDEX = 0;
    public static final int NUM_TILES = 64;
    public static final int NUM_TILES_PER_ROW = 8;

    public static final String[] ALGEBRAIC_NOTATION = initializeAlgebraicNotation();
    /**
     * Hajautustaulu, jossa ruudun sijaintia muodossa A4 vastaa kokonaisluku koordinaatti. (A4 = 32)
     */
    public static final Map<String, Integer> POSITION_TO_COORDINATE = initializePositionToCoordinateMap();

    private BoardUtils() {
        throw new RuntimeException("You cannot instantiate me!");
    }

    /**
     * Riviapulistan alustus.
     * @param rowNumber rivin numero
     * @return  palatuttaa listan, jossa on parametrina annetun rivin kohdalla on true
     */
    private static boolean[] initRow(int rowNumber) {
        final boolean[] row = new boolean[NUM_TILES];
        do {
            row[rowNumber] = true;
            rowNumber++;
        } while (rowNumber % NUM_TILES_PER_ROW != 0);
        return row;
    }

    /**
     * Sarakeapulistan alustus.
     * @param columnNumber sarakkeen numero
     * @return palauttaa listan, jossa on parametrina annetun sarakkeen kohdalla true
     */
    private static boolean[] initColumn(int columnNumber) {
        final boolean[] column = new boolean[64];
        do {
            column[columnNumber] = true;
            columnNumber += NUM_TILES_PER_ROW;
        } while (columnNumber < NUM_TILES);
        return column;
    }

    /**
     * Kertoo, onko parametrina annettu koordinaatti shakkilaudalla.
     * @param coordinate koordinaatti
     * @return 
     */
    public static boolean isValidTileCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }

    /**
     * Metodi alustaa numerokoordinaatit ja numero-kirjain-merkinnän yhdistävän
     * hajautustaulun.
     * @return hajautustaulu, joka yhdistää numerokoordinaatit ja numero-kirjain-
     * merkinnän
     */
    private static Map<String, Integer> initializePositionToCoordinateMap() {
        final Map<String, Integer> positionToCoordinate = new HashMap<>();
        for (int i = START_TILE_INDEX; i < NUM_TILES; i++) {
            positionToCoordinate.put(ALGEBRAIC_NOTATION[i], i);
        }
        return ImmutableMap.copyOf(positionToCoordinate);
    }

    private static String[] initializeAlgebraicNotation() {
        return new String[]{
            "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8",
            "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7",
            "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6",
            "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5",
            "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4",
            "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3",
            "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2",
            "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1"
        };
    }
}
