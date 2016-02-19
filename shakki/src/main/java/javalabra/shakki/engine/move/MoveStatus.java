/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.move;

/**
 * Enum-apuluokka siirtojen seurauksien tutkimiseksi. Kun isDone() palauttaa
 * true, siirron voi tehdä ilman, että siirtoa tekevän kuningas jäisi uhatuksi.
 */
public enum MoveStatus {

    DONE {
                @Override
                public boolean isDone() {
                    return true;
                }
            },
    ILLEGAL {
                @Override
                public boolean isDone() {
                    return false;
                }
            },
    LEAVES_PLAYER_IN_CHECK {
                @Override
                public boolean isDone() {
                    return false;
                }
            };

    public abstract boolean isDone();
}
