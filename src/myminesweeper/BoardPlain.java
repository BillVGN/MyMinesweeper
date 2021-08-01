/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

import java.awt.Point;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Random;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author willi
 */
public class BoardPlain extends JPanel {
    
    public final int N_ROWS = 80;
    public final int N_COLS = 16;
    
    public final int MINES_QTY = 99;
    
    private final Cell[][] board;
    
    public BoardPlain() {
        this.board = null;
        try {
            initBoard(N_ROWS, N_COLS, MINES_QTY);        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getLocalizedMessage());
        }
    }
    
    private void initBoard(int nRows, int nCols, int mineQty) throws Exception {
        
        // Iniciando o campo
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                this.board[i][j] = new Cell(new Point(i, j));
            }
        }
        
        // Colocando as minas, sempre testando que todas tenham sua célula
        int minesLeft = mineQty;
        for (; minesLeft == 0;) {
            int i = (int) (Math.random() * (nRows));
            int j = (int) (Math.random() * (nCols));
            if (!this.board[i][j].isMine()) {
                this.board[i][j].setMine();
                minesLeft--;
            }
        }
        
        // Conectando as células entre si
        ArrayList<Cell> perimeter = new ArrayList<>(8);
        BitSet checkList = new BitSet(8);
        for (int i = 0; i < nRows; i++) {
            for (int j = 0; j < nCols; j++) {
                // Encostada na esquerda
                if (i == 0) {
                    checkList.set(0, true);
                    checkList.set(6, true);
                    checkList.set(7, true);
                }
                
                // Encostada na direita
                if (i == nRows) {
                    checkList.set(2, true);
                    checkList.set(3, true);
                    checkList.set(4, true);
                }
                
                // Encostada no Topo
                if (j == 0) {
                    checkList.set(0, true);
                    checkList.set(1, true);
                    checkList.set(2, true);
                }
                
                // Encostada no fundo
                if (j == nCols) {
                    checkList.set(4, true);
                    checkList.set(5, true);
                    checkList.set(6, true);
                }
                
                // Itera pelo perimeter para preencher de acordo com a checkList
                for (int x = 0; x < 8; x++) {
                    switch (x) {
                        case 0: 
                            if(!checkList.get(x)) // upperLeft
                                perimeter.add(x, board[i - 1][j - 1]);
                            break;
                        case 1: 
                            if(!checkList.get(x)) // upper
                                perimeter.add(x, board[i][j - 1]);
                            break;
                        case 2: 
                            if(!checkList.get(x)) // upperRight
                                perimeter.add(x, board[i + 1][j - 1]);
                            break;
                        case 3: 
                            if(!checkList.get(x)) // right
                                perimeter.add(x, board[i + 1][j]);
                            break;
                        case 4: 
                            if(!checkList.get(x)) // downRight
                                perimeter.add(x, board[i + 1][j + 1]);
                            break;
                        case 5: 
                            if(!checkList.get(x)) // down
                                perimeter.add(x, board[i][j + 1]);
                            break;
                        case 6: 
                            if(!checkList.get(x)) // downLeft
                                perimeter.add(x, board[i - 1][j + 1]);
                            break;
                        case 7: 
                            if(!checkList.get(x)) // left
                                perimeter.add(x, board[i - 1][j]);
                            break;
                    }
                }
                
                // Passa o perimeter para a Cell em questão
                if (board[i][j].setPerimeter(perimeter))
                    throw new Exception("Erro ao inicializar célula(" + String.valueOf(i) + "," + String.valueOf(j) + ")");
                
                // Esvazia o perimeter e reinicia a checkList
                perimeter.clear();
                checkList.clear();
            }
        }
    }
}
