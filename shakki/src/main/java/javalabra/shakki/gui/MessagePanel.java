/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javalabra.shakki.gui;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextArea;

/**
 *MessagePanel kertoo, jos peli päättyy eli jompi kumpi voittaa pelin tai peli
 *päättyy tasapeliin.
 */
public class MessagePanel extends JPanel {
    
    private final Dimension MESSAGE_PANEL_DIMENSION = new Dimension(600, 50);
    private final JTextArea jTextArea;
    
    public MessagePanel() {
        setPreferredSize(MESSAGE_PANEL_DIMENSION);
        this.jTextArea = new JTextArea();
        add(this.jTextArea);
        validate();
        setVisible(true);
    }
    
    public void clear() {
        jTextArea.setText(null);
    }
    
    public void writeWhitePlayerWins() {
        jTextArea.setText("And the white player wins!");
    }
    
    public void writeBlackPlayerWins() {
        jTextArea.setText("And the black player wins!");
    }
    
    public void writeWhitePlayerStaleMate() {
        jTextArea.setText("It's a draw, the white player cannot move! So how an "
                + "earth did you end up like this?");
    }
    
    public void writeBlackPlayerStaleMate() {
        jTextArea.setText("It's a draw, the balck player cannot move! So how an "
                + "earth did you end up like this?");
    }
}
