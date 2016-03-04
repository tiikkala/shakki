/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import javalabra.shakki.engine.board.BoardUtils;
import javalabra.shakki.engine.player.BlackPlayer;
import javalabra.shakki.engine.player.Player;
import javalabra.shakki.engine.player.WhitePlayer;

/**
 *Enum-class for piece color.
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

                @Override
                public boolean isPawnPromotionSquare(final int position) {
                    return BoardUtils.FIRST_ROW[position];
                }

                @Override
                public Player choosePlayer(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer) {
                    return whitePlayer;
                }

                @Override
                public int getOppositeDirection() {
                    return 1;
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

                @Override
                public Player choosePlayer(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer) {
                    return blackPlayer;
                }

                @Override
                public boolean isPawnPromotionSquare(final int position) {
                    return BoardUtils.EIGHTH_ROW[position];
                }

                @Override
                public int getOppositeDirection() {
                    return -1;
                }
            };

    /**
     * Metodi kertoo, onko ruutu sellainen, jossa sotilaasta tulee kuningatar.
     * @param int ruudunKoordinaatti
     * @return 
     */
    public abstract boolean isPawnPromotionSquare(int position);

    /**
     * Palauttaa värin hyökkäyssuunnan
     * @return 1, jos musta, -1, jos valkoinen
     */
    public abstract int getDirection();

    /**
     * Palauttaa värin vastustajan hyökkäyssuunnan
     * @return -1, jos musta, 1, jos valkoinen
     */
    public abstract int getOppositeDirection();

    public abstract boolean isWhite();

    public abstract boolean isBlack();

    /**
     * Palauttaa valkoisella värilla valkoisen ja mustalla mustan pelaajan.
     * @param whitePlayer
     * @param blackPlayer
     * @return Player
     */
    public abstract Player choosePlayer(WhitePlayer whitePlayer, BlackPlayer blackPlayer);
}
