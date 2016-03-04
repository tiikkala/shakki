/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javalabra.shakki.engine.board.*;
import javalabra.shakki.engine.move.Move;
import javalabra.shakki.engine.move.MoveFactory;
import javalabra.shakki.engine.move.MoveTransision;
import javalabra.shakki.engine.pieces.Piece;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * Graafinen käyttöliittymä.
 */
public class Table {

    private final JFrame gameFrame;
    private final BoardPanel boardPanel;
    private Board chessBoard;
    private Tile sourceTile;
    private Tile destinationTile;
    private Piece humanMovedPiece;
    private final MessagePanel messagePanel;

    private final Color lightTileColor = Color.CYAN;
    private final Color darkTileColor = Color.LIGHT_GRAY;

    private final static Dimension OUTER_FRAME_DIMENSION = new Dimension(600, 600);
    private final static Dimension BOARD_PANEL_DIMENSION = new Dimension(400, 350);
    private final static Dimension TILE_PANEL_DIMENSION = new Dimension(10, 10);
    private final static String pieceIconPath = "src/main/resources/art/";

    public Table() {
        this.gameFrame = new JFrame("JChess");
        final JMenuBar tableMenuBar = createTableMenubar();
        this.chessBoard = Board.createStandardBoard();
        this.gameFrame.setSize(OUTER_FRAME_DIMENSION);
        this.gameFrame.setLayout(new BorderLayout());
        this.gameFrame.setJMenuBar(tableMenuBar);
        this.boardPanel = new BoardPanel();
        this.messagePanel = new MessagePanel();
        this.gameFrame.add(this.messagePanel, BorderLayout.SOUTH);
        this.gameFrame.add(this.boardPanel, BorderLayout.CENTER);
        this.gameFrame.setVisible(true);
        this.gameFrame.setLocationRelativeTo(null);
    }

    private JMenuBar createTableMenubar() {
        final JMenuBar tableMenuBar = new JMenuBar();
        tableMenuBar.add(createFileMenu());
        return tableMenuBar;
    }

    private JMenu createFileMenu() {
        final JMenu fileMenu = new JMenu("File");
        final JMenuItem newGameMenuItem = new JMenuItem("New Game");
        final JMenuItem exitMenuItem = new JMenuItem("Exit");
// load/save png file-ominaisuus ei ehtinyt vielä tähän versioon, tulossa
// seuraavaan
//        final JMenuItem openPGN = new JMenuItem("Load PGN File");
        newGameMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                messagePanel.clear();
                chessBoard = Board.createStandardBoard();
                boardPanel.drawBoard(chessBoard);
            }
        });
        fileMenu.add(newGameMenuItem);
//        openPGN.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println("Open up the pgn file!");
//            }
//        });
//        fileMenu.add(openPGN);
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        fileMenu.add(exitMenuItem);
        return fileMenu;
    }
    
    /**
     * Pelilauta, koostuu 8x8 ruudukosta.
     */
    private class BoardPanel extends JPanel {

        final List<TilePanel> boardTiles;

        public BoardPanel() {
            super(new GridLayout(8, 8));
            this.boardTiles = new ArrayList<>();
            for (int i = 0; i < BoardUtils.NUM_TILES; i++) {
                final TilePanel tilePanel = new TilePanel(this, i);
                this.boardTiles.add(tilePanel);
                add(tilePanel);
            }
            setPreferredSize(BOARD_PANEL_DIMENSION);
            validate();
        }

        public void drawBoard(final Board board) {
            removeAll();
            for (final TilePanel tilePanel : this.boardTiles) {
                tilePanel.drawTile(board);
                add(tilePanel);
            }
            validate();
            repaint();
        }
    }

    /**
     * TilePanel-oliot edustava shakin ruutuja. Nappuloita liikutetaan klikkaamalla
     * hiirellä ruutuja, joissa ne sijaitsevat.
     */
    private class TilePanel extends JPanel {

        private final int tileCoordinate;

        TilePanel(final BoardPanel boardPanel,
                final int tileCoordinate) {
            super(new GridBagLayout());
            this.tileCoordinate = tileCoordinate;
            setPreferredSize(TILE_PANEL_DIMENSION);
            assignTileColor();
            assignPieceIcon(chessBoard);

            addMouseListener(new MouseListener() {

                @Override
                public void mouseClicked(final MouseEvent e) {
                    if (SwingUtilities.isRightMouseButton(e)) {
                        // klikkaus hiiren oikealla napilla
                        sourceTile = null;
                        destinationTile = null;
                        humanMovedPiece = null;
                    } else if (SwingUtilities.isLeftMouseButton(e)) {
                        // ensimmäinen klikkaus hiiren vasemmalla napilla
                        if (sourceTile == null) {
                            sourceTile = chessBoard.getTile(tileCoordinate);
                            humanMovedPiece = sourceTile.getPiece();
                            if (humanMovedPiece == null) {
                                sourceTile = null;
                            }
                        } else {
                            // toinen klikkaus hiiren vasemmalla napilla
                            destinationTile = chessBoard.getTile(tileCoordinate);
                            final Move move = MoveFactory.createMove(chessBoard, sourceTile.getTileCoordinate(), destinationTile.getTileCoordinate());
                            final MoveTransision transision = chessBoard.currentPlayer().makeMove(move);
                            if (transision.getMoveStatus().isDone()) {
                                chessBoard = transision.getTransisionBoard();
                                SwingUtilities.invokeLater(new Runnable() {
                                    @Override
                                    public void run() {
                                        boardPanel.drawBoard(chessBoard);
                                    }
                                });
                            }
                            sourceTile = null;
                            destinationTile = null;
                            humanMovedPiece = null;
                            // tarkastetaan, onko jompi kumpi voittanut 
                            // tai onko kyseessä tasapeli
                            if (chessBoard.getWhitePlayer().isInCheckMate()) {
                                messagePanel.writeBlackPlayerWins();
                            }
                            if (chessBoard.getBlackPlayer().isInCheckMate()) {
                                messagePanel.writeWhitePlayerWins();
                            }
                            if (chessBoard.getBlackPlayer().isStaleMate()) {
                                messagePanel.writeBlackPlayerStaleMate();
                            }
                            if (chessBoard.getWhitePlayer().isStaleMate()) {
                                messagePanel.writeWhitePlayerStaleMate();
                            }
                        }
                    }
                }

                @Override
                public void mousePressed(MouseEvent e
                ) {
                }

                @Override
                public void mouseReleased(MouseEvent e
                ) {
                }

                @Override
                public void mouseEntered(MouseEvent e
                ) {
                }

                @Override
                public void mouseExited(MouseEvent e
                ) {
                }
            }
            );
            validate();
        }

        /**
         * Metodi hakee ruutua vastaavan nappulan kuvan.
         *
         * @param board saa parametrina pelilaudan
         */
        private void assignPieceIcon(final Board board) {
            this.removeAll();
            if (board.getTile(this.tileCoordinate).isTileOccupied()) {
                try {
                    final BufferedImage image = ImageIO.read(new File(pieceIconPath + board.getTile(this.tileCoordinate).getPiece().getPieceColor().toString().substring(0, 1) + ""
                            + board.getTile(this.tileCoordinate).getPiece().toString() + ".png"));
                    add(new JLabel(new ImageIcon(image)));

                } catch (IOException ex) {
                    Logger.getLogger(Table.class
                            .getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

        /**
         * Metodi värittää shakkilaudan ruudut.
         */
        private void assignTileColor() {
            if (BoardUtils.FIRST_ROW[this.tileCoordinate]
                    || BoardUtils.THIRD_ROW[this.tileCoordinate]
                    || BoardUtils.FIFTH_ROW[this.tileCoordinate]
                    || BoardUtils.SEVENTH_ROW[this.tileCoordinate]) {
                setBackground(this.tileCoordinate % 2 == 0 ? lightTileColor : darkTileColor);
            } else if (BoardUtils.SECOND_ROW[this.tileCoordinate]
                    || BoardUtils.FOURTH_ROW[this.tileCoordinate]
                    || BoardUtils.SIXTH_ROW[this.tileCoordinate]
                    || BoardUtils.EIGHTH_ROW[this.tileCoordinate]) {
                setBackground(this.tileCoordinate % 2 != 0 ? lightTileColor : darkTileColor);
            }
        }

        /**
         * Metodi piirtää ruutuun nappulan, jos siinä on sellainen.
         *
         * @param board saa parametrina Board-olion, josta selviää, missä
         * ruuduissa on nappula
         */
        public void drawTile(final Board board) {
            assignTileColor();
            assignPieceIcon(board);
            validate();
            repaint();
        }
    }
}
