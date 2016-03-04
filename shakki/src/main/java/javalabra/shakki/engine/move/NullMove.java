/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.Piece;

/**
 * Siirto, joka ei ole koskaan toteutettavissa.
 */
public class NullMove extends Move {

    public NullMove() {
        super(null, -1);
    }

    public Board ecexute() {
        throw new RuntimeException("Cannot execute the null move!");
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }

    @Override
    public boolean isAttack() {
        return false;
    }
}
