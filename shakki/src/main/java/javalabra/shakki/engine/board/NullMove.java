/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import javalabra.shakki.engine.pieces.Piece;

/**
 * Siirto, joka ei ole koskaan toteutettavissa.
 */
public class NullMove extends Move {

    public NullMove() {
        super(null, null, -1);
    }

    public Board ecexute() {
        throw new RuntimeException("Cannot execute the null move!");
    }

    @Override
    public boolean isAttack() {
        return false;
    }

    @Override
    public boolean isCastleMove() {
        return false;
    }

    @Override
    public Piece getAttackedPiece() {
        return null;
    }
}
