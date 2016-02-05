/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.board.Move;

/**
 *
 * @author tapio
 */
public class MoveTransision {

    private final Board transisionBoard;
    private final Move move;
    private final MoveStatus moveStatus;

    public MoveTransision(final Board transisionBoard,
            final Move move,
            final MoveStatus moveStatus) {
        this.transisionBoard = transisionBoard;
        this.move = move;
        this.moveStatus = moveStatus;
    }

    public MoveStatus getMoveStatus() {
        return this.moveStatus;
    }

}
