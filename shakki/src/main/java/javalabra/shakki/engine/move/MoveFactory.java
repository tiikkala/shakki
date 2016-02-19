/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;
import javalabra.shakki.engine.board.Board;
import static javalabra.shakki.engine.move.Move.NULL_MOVE;

/**
 *Factory-luokka Move-olioiden luomiseksi.
 */
public class MoveFactory {
    
    private MoveFactory() {
        throw new RuntimeException("Not instantiable!");
    }
    
    /**
    *Metodi luo sille parametrina syötettyjä tietoja vastaavan
    *Move-olion. Jos kyseistä siirtoa ei voi tehdä, metodi palauttaa
    * NULL_MOVE-olion, jota ei voi koskaan toteuttaa laudalla.
    * 
    * @param board pelilauta, jolla siirto tehdään
    * @param currentCoordinate mistä siirretään
    * @param destinationCoordinate mihin siirretään
    * 
    * @return koordinaatteja vastaava siirto laudalla
    */    
    public static Move createMove(final Board board,
                                  final int currentCoordinate,
                                  final int destinationCoordinate) {
        for (final Move move : board.getAllLegalMoves()) {
            if (move.getCurrentCoordinate() == currentCoordinate &&
                move.getDestinationCoordinate() == destinationCoordinate) {
                return move;
            }
        }
        return NULL_MOVE;
    }
    
}
