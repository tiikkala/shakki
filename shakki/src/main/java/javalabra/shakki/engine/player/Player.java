/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.player;

import javalabra.shakki.engine.move.MoveTransision;
import javalabra.shakki.engine.move.MoveStatus;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javalabra.shakki.engine.board.Board;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.pieces.King;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.PieceColor;

/**
 *Pelaaja-luokka.
 */
public abstract class Player {

    protected final Board board;
    protected final King playerKing;
    protected final Collection<Move> legalMoves;
    private final boolean isInCheck;

    Player(final Board board,
            final Collection<Move> legalMoves,
            final Collection<Move> opponentsMoves) {
        this.board = board;
        this.playerKing = establishKing();
        this.legalMoves = ImmutableList.copyOf(Iterables.concat(legalMoves, calculateKingCastles(legalMoves, opponentsMoves)));
        this.isInCheck = !Player.calculateAttacksOnTile(this.playerKing.getPiecePosition(), opponentsMoves).isEmpty();
    }

    protected King establishKing() {
        for (final Piece piece : getActivePieces()) {
            if (piece.getPieceType().isKing()) {
                return (King) piece;
            }
        }
        throw new RuntimeException("Should not reach here! Not a valid board!");
    }

    /**
     * Metodi määrittää siirrot, joilla pääsee kyseiseen ruutuun.
     * @param tile ruutu, johon kohdistuvat hyökkäykset halutaan selvittää
     * @param moves läpi käytävät siirrot
     * @return palauttaa listan siirroista, joilla pääsee annettuun ruutuun
     */
    public static Collection<Move> calculateAttacksOnTile(final int tile, final Collection<Move> moves) {
        final List<Move> attackMoves = new ArrayList<>();
        for (final Move move : moves) {
            if (tile == move.getDestinationCoordinate()) {
                attackMoves.add(move);
            }
        }
        return ImmutableList.copyOf(attackMoves);
    }
    
    protected boolean hasEscapeMoves() {
        for (final Move move : this.legalMoves) {
            final MoveTransision transision = makeMove(move);
            if (transision.getMoveStatus().isDone()) {
                return true;
            }
        }
        return false;
    }
    
    public King getPlayerKing() {
        return this.playerKing;
    }
    
    public Collection<Move> getLegalMoves() {
        return this.legalMoves;
    }

    public boolean isMoveLegal(final Move move) {
        return this.legalMoves.contains(move);
    }

    public boolean isInCheck() {
        return this.isInCheck;
    }

    public boolean isInCheckMate() {
        return this.isInCheck && !hasEscapeMoves();
    }

    /**
     * Metodi kertoo, onko peli päätynyt tasapeliin eli tilanteeseen,
     * jossa jompi kumpi pelaajista ei pysty tekemään yhtäkään siirtoa.
     * @return true, jos tasapeli
     */
    public boolean isStaleMate() {
        return !this.isInCheck && !hasEscapeMoves();
    }

    /**
     * Metodi palauttaa MoveTransision-olion, joka kertoo, voidaanko siirto tehdä ilman,
     * että siirron tehneen pelaajan kuningas jää uhatuksi. Mikäli siirto voidaan tehdä,
     * saadaan siirron jälkeisen pelilaudan tilaa koskevat tiedot MoveTransision-olion
     * transisionBoard-attribuutista.
     * @param move siirto, jonka laillisuus halutaan tarkistaa
     * @return MoveTransision-olio, josta selviää siirron laillisuus
     */
    public MoveTransision makeMove(final Move move) {
        if (!isMoveLegal(move)) {
            return new MoveTransision(this.board, move, MoveStatus.ILLEGAL);
        }
        final Board transisionBoard = move.execute();
        final Collection<Move> kingAttacks = calculateAttacksOnTile(transisionBoard.currentPlayer().getOpponent().getPlayerKing().getPiecePosition(),
                transisionBoard.currentPlayer().getLegalMoves());
        if (!kingAttacks.isEmpty()) {
            return new MoveTransision(this.board, move, MoveStatus.LEAVES_PLAYER_IN_CHECK);
        }
        return new MoveTransision(transisionBoard, move, MoveStatus.DONE);
    }

    public abstract Collection<Piece> getActivePieces();
    public abstract PieceColor getPieceColor();
    public abstract Player getOpponent();
    /**
     * Metodi kertoo, onko pelaajan mahdollista tehdä tornitus-nimistä erikoissiirtoa,
     * @param playersLegalMoves pelaajan mahdolliset siirrot
     * @param opponentsLegalMoves vastustajan mahdolliset siirrot
     * @return palauttaa listan mahdollisista tornitussiirroista (näitä on enintään kaksi)
     */
    public abstract Collection<Move> calculateKingCastles(Collection<Move> playersLegalMoves, Collection<Move> opponentsLegalMoves);
}
