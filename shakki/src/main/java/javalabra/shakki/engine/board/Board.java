/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.engine.board;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterables;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javalabra.shakki.engine.pieces.Bishop;
import javalabra.shakki.engine.pieces.King;
import javalabra.shakki.engine.pieces.Knight;
import javalabra.shakki.engine.pieces.Pawn;
import javalabra.shakki.engine.pieces.Piece;
import javalabra.shakki.engine.pieces.PieceColor;
import javalabra.shakki.engine.pieces.Queen;
import javalabra.shakki.engine.pieces.Rook;
import javalabra.shakki.engine.player.BlackPlayer;
import javalabra.shakki.engine.player.Player;
import javalabra.shakki.engine.player.WhitePlayer;

/**
 * Pelilauta-olio, joka kuvaa pelitilannetta.
 */
public class Board {

    private final List<Tile> gameBoard;
    private final Collection<Piece> whitePieces;
    private final Collection<Piece> blackPieces;

    private final WhitePlayer whitePlayer;
    private final BlackPlayer blackPlayer;
    private final Player currentPlayer;

    private Board(final Builder builder) {
        this.gameBoard = createGameBoard(builder);
        this.whitePieces = calculateActivePieces(this.gameBoard, PieceColor.WHITE);
        this.blackPieces = calculateActivePieces(this.gameBoard, PieceColor.BLACK);
        final Collection<Move> whiteStandardLegalMoves = calculateLegalMoves(this.whitePieces);
        final Collection<Move> blackStandardLegalMoves = calculateLegalMoves(this.blackPieces);
        this.whitePlayer = new WhitePlayer(this, whiteStandardLegalMoves, blackStandardLegalMoves);
        this.blackPlayer = new BlackPlayer(this, blackStandardLegalMoves, whiteStandardLegalMoves);
        this.currentPlayer = builder.nextMoveMaker.choosePlayer(this.whitePlayer, this.blackPlayer);
    }

    public Tile getTile(final int tileCoordinate) {
        return gameBoard.get(tileCoordinate);
    }

    public Player currentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            final String tileText = this.gameBoard.get(i).toString();
            builder.append(String.format("%3s", tileText));
            if ((i + 1) % BoardUtils.NUM_TILES_PER_ROW == 0) {
                builder.append("\n");
            }
        }
        return builder.toString();
    }

    public Collection<Piece> getBlackPieces() {
        return this.blackPieces;
    }

    public Collection<Piece> getWhitePieces() {
        return this.whitePieces;
    }

    public Player getWhitePlayer() {
        return this.whitePlayer;
    }

    public Player getBlackPlayer() {
        return this.blackPlayer;
    }

    private Collection<Move> calculateLegalMoves(final Collection<Piece> pieces) {
        final List<Move> legalMoves = new ArrayList();
        for (final Piece piece : pieces) {
            legalMoves.addAll(piece.calculateLegalMoves(this));
        }
        return ImmutableList.copyOf(legalMoves);
    }

    private static Collection<Piece> calculateActivePieces(final List<Tile> gameBoard,
            final PieceColor pieceColor) {
        final List<Piece> activePieces = new ArrayList<>();
        for (final Tile tile : gameBoard) {
            if (tile.isTileOccupied()) {
                final Piece piece = tile.getPiece();
                if (piece.getPieceColor() == pieceColor) {
                    activePieces.add(piece);
                }
            }
        }
        return ImmutableList.copyOf(activePieces);
    }

    private static List<Tile> createGameBoard(final Builder builder) {
        final Tile[] tiles = new Tile[BoardUtils.NUM_TILES];
        for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
            tiles[i] = Tile.createTile(i, builder.boardConfig.get(i));
        }
        return ImmutableList.copyOf(tiles);
    }
    
    /**
     * Metodi luo alkutilannetta vastaavan pelitilanteen.
     *
     * @return shakin alkutilanne
     */
    public static Board createStandardBoard() {
        final Builder builder = new Builder();
        // black layout
        builder.setPiece(new Rook(0, PieceColor.BLACK));
        builder.setPiece(new Knight(1, PieceColor.BLACK));
        builder.setPiece(new Bishop(2, PieceColor.BLACK));
        builder.setPiece(new Queen(3, PieceColor.BLACK));
        builder.setPiece(new King(4, PieceColor.BLACK));
        builder.setPiece(new Bishop(5, PieceColor.BLACK));
        builder.setPiece(new Knight(6, PieceColor.BLACK));
        builder.setPiece(new Rook(7, PieceColor.BLACK));
        for (int i = 8; i < 16; i++) {
            builder.setPiece(new Pawn(i, PieceColor.BLACK));
        }
        // white layout
        for (int i = 48; i < 56; i++) {
            builder.setPiece(new Pawn(i, PieceColor.WHITE));
        }
        builder.setPiece(new Rook(56, PieceColor.WHITE));
        builder.setPiece(new Knight(57, PieceColor.WHITE));
        builder.setPiece(new Bishop(58, PieceColor.WHITE));
        builder.setPiece(new Queen(59, PieceColor.WHITE));
        builder.setPiece(new King(60, PieceColor.WHITE));
        builder.setPiece(new Bishop(61, PieceColor.WHITE));
        builder.setPiece(new Knight(62, PieceColor.WHITE));
        builder.setPiece(new Rook(63, PieceColor.WHITE));
        // white starts
        builder.setMoveMaker(PieceColor.WHITE);
        return builder.build();
    }

    /**
     * Metodi palauttaa kaikki mahdolliset pelilaudalla tehtävät siirrot (sekä
     * mustan että valkoisen pelaajan siirrot).
     *
     * @return kokoelma sallittuja siirtoja
     */
    public Iterable<Move> getAllLegalMoves() {
        return Iterables.unmodifiableIterable(Iterables.concat(this.whitePlayer.getLegalMoves(), this.blackPlayer.getLegalMoves()));
    }

    /**
     * Builder-luokka, jonka avulla pelilaudat luodaan. boardCongig-hajautustaussa on
     * avaimena pelilaudan ruudun koordinaattori ja arvona ruudussa oleva nappula.
     * Jos ruudussa ei ole nappulaa arvo on null. Builder sisältää myös tiedon siitä,
     * kenen vuoro on.
     */
    public static class Builder {

        private final Map<Integer, Piece> boardConfig;
        PieceColor nextMoveMaker;

        public Builder() {
            this.boardConfig = new HashMap();
        }
        
        /**
         * Metodi asettaa nappulan oikealla paikkaaleen boardCongi-hajautustauluun.
         * @param piece asetettava nappuli
         * @return Builder-olio palauttaa itsensä päivitetyllä hajautustaululla varustettuna
         */
        public Builder setPiece(final Piece piece) {
            this.boardConfig.put(piece.getPiecePosition(), piece);
            return this;
        }

        /**
         * Metodi määrittää, kene vuoro on seuraavaksi.
         * @param nextMoveMaker seuraavaksi vuorossa oleva pelaaja
         * @return Builder-olio palauttaa itsensä päivitetyllä nextMoveMaker-arvolla varustettuna
         */
        public Builder setMoveMaker(final PieceColor nextMoveMaker) {
            this.nextMoveMaker = nextMoveMaker;
            return this;
        }

        /**
         * Metodi luo Builder-oliota vastaavan pelilaudan.
         * @return pelilauta
         */
        public Board build() {
            return new Board(this);
        }

    }

}
