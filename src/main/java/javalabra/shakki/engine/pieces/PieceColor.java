/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

/**
 *
 * @author tapio
 */
public enum PieceColor {

    WHITE {
                @Override
                public int getDirection() {
                    return -1;
                }

                @Override
                public boolean isWhite() {
                    return true;
                }

                @Override
                public boolean isBlack() {
                    return false;
                }
            },
    BLACK {
                @Override
                public int getDirection() {
                    return 1;
                }

                @Override
                public boolean isWhite() {
                    return false;
                }

                @Override
                public boolean isBlack() {
                    return true;
                }
            };

    public abstract int getDirection();

    public abstract boolean isWhite();

    public abstract boolean isBlack();
}
