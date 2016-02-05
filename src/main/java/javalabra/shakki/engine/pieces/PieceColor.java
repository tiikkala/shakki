/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.pieces;

import javalabra.shakki.engine.player.BlackPlayer;
import javalabra.shakki.engine.player.Player;
import javalabra.shakki.engine.player.WhitePlayer;

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

                @Override
                public Player choosePlayer(final WhitePlayer whitePlayer, final BlackPlayer blackPlayer) {
                    return whitePlayer;
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
            };

    public abstract int getDirection();

    public abstract boolean isWhite();

    public abstract boolean isBlack();

    public abstract Player choosePlayer(WhitePlayer whitePlayer, BlackPlayer blackPlayer);
}
