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
public enum PieceType {

    PAWN("P") {
                @Override
                public boolean isKing() {
                    return false;
                }

                @Override
                public boolean isRook() {
                    return false;
                }
            },
    KNIGHT("N") {
                @Override
                public boolean isKing() {
                    return false;
                }

                @Override
                public boolean isRook() {
                    return false;
                }
            },
    BISHOP("B") {
                @Override
                public boolean isKing() {
                    return false;
                }

                @Override
                public boolean isRook() {
                    return false;
                }
            },
    ROOK("R") {
                @Override
                public boolean isKing() {
                    return false;
                }

                @Override
                public boolean isRook() {
                    return true;
                }
            },
    QUEEN("Q") {
                @Override
                public boolean isKing() {
                    return false;
                }

                @Override
                public boolean isRook() {
                    return false;
                }
            },
    KING("K") {
                @Override
                public boolean isKing() {
                    return true;
                }

                @Override
                public boolean isRook() {
                    return false;
                }
            };

    private String pieceName;

    PieceType(String pieceName) {
        this.pieceName = pieceName;
    }

    @Override
    public String toString() {
        return this.pieceName;
    }

    public abstract boolean isKing();

    public abstract boolean isRook();
}
