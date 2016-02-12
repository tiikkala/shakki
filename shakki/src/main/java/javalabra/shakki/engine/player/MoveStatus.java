/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

/**
 * Enum-apuluokka siirtojen seurauksien tutkimiseksi.
 * Kun isDone() palauttaa true, siirron voi tehdä ilman, että
 * siirtoa tekevän kuningas jäisi uhatuksi.
 */
public enum MoveStatus {

    DONE {
                @Override
                boolean isDone() {
                    return true;
                }
            },
    ILLEGAL {
                @Override
                boolean isDone() {
                    return false;
                }
            },
    LEAVES_PLAYER_IN_CHECK {
                @Override
                boolean isDone() {
                    return false;
                }
            };
    abstract boolean isDone();
}
