/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Locale;
import java.util.ResourceBundle;
import javax.swing.Timer;

/**
 *
 * @author willi
 */
public class BoardController extends Thread implements ActionListener{

    private final Board board;
    private Timer temporizador;
    // Internationalization
    private static final ResourceBundle languages = ResourceBundle.getBundle("resources/languages", Locale.getDefault());
    
    BoardController (Board myBoard) {
        this.board = myBoard;
    }
    
    @Override
    public void run() {
        this.temporizador = new Timer(500, this);
        this.temporizador.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (board.isGameOn()) {
            if (board.getBoardMap().areAllMinesFlagged()) {
                board.setGameOver(true);
                if (board.getBoardMap().remainingCoveredCells() > 0) {
                    board.getBoardMap().flagRemainingCells();
                    board.getBoardMap().revealAllCells();
                }
                if (board.showConfirmationMessage(languages.getString("CONGRATULATIONS"), null)) {
                    board.novoJogo();
                }
            }
        }        
    }
}
