/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import static javalabra.shakki.engine.board.Move.NULL_MOVE;

/**
 *
 * @author tapio
 */
public class MoveFactory {
    
    private MoveFactory() {
        throw new RuntimeException("Not instantiable!");
    }
    
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
