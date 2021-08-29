/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.lang3.ArrayUtils;
import org.ini4j.Wini;

/**
 *
 * @author willi
 */
public class Configuration extends javax.swing.JDialog {
    
    private Wini ini;
    private final String DEF_FILE_NAME = "config.ini";
    private final String MINES_QTY_CONFIG = "MINE_QTY";
    private final String N_ROWS_CONFIG = "N_ROWS";
    private final String N_COLS_CONFIG = "N_COLS";
    private final String POINTS_COST_CONFIG = "POINTS_COST";
    private final String CELL_SIZE_CONFIG = "CELL_SIZE";
    
    private Prefs[] gameLevels = {Prefs.EASY, Prefs.MODERATE, Prefs.EXPERT};
    private String[] gameLevelsByLocale;
    
    private final Board myBoard;
    private static final ResourceBundle languages = ResourceBundle.getBundle("resources/languages");    
    
    /**
     * Creates new form Configuration
     * @param parent
     * @param modal
     */
    public Configuration(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        myBoard = (Board) parent;
        initComponents();
        try {
            loadPrefs();
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
//        gameLevelsByLocale = Arrays.stream(gameLevels).map(val->val.getString)
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpanGame = new javax.swing.JPanel();
        jlabMinesQuantity = new javax.swing.JLabel();
        jspinMinas = new javax.swing.JSpinner();
        jlabNumberOfRows = new javax.swing.JLabel();
        jspinNumberOfRows = new javax.swing.JSpinner();
        jlabNumberOfCols = new javax.swing.JLabel();
        jspinNumberOfCols = new javax.swing.JSpinner();
        jlabCellSize = new javax.swing.JLabel();
        jspinCellSize = new javax.swing.JSpinner();
        jlabPointsCost = new javax.swing.JLabel();
        jspinPointsCost = new javax.swing.JSpinner();
        jcmbboxGameLevel = new javax.swing.JComboBox<>();
        jlabGameLevel = new javax.swing.JLabel();
        jbutSave = new javax.swing.JButton();
        jbutCancel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle(languages.getString("SETTINGS")); // NOI18N
        setResizable(false);

        jpanGame.setBorder(javax.swing.BorderFactory.createTitledBorder(null, languages.getString("GAME"), javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.TOP)); // NOI18N

        jlabMinesQuantity.setText(languages.getString("MINES_QUANTITY")); // NOI18N

        jspinMinas.setModel(new javax.swing.SpinnerNumberModel(99, 10, 479, 1));

        jlabNumberOfRows.setText(languages.getString("NUMBER_OF_COLS")); // NOI18N

        jspinNumberOfRows.setModel(new javax.swing.SpinnerNumberModel(30, 5, 30, 1));

        jlabNumberOfCols.setText(languages.getString("NUMBER_OF_ROWS")); // NOI18N

        jspinNumberOfCols.setModel(new javax.swing.SpinnerNumberModel(16, 8, 16, 1));

        jlabCellSize.setText(languages.getString("CELL_SIZE")); // NOI18N

        jspinCellSize.setModel(new javax.swing.SpinnerNumberModel(25, 16, 50, 1));

        jlabPointsCost.setText(languages.getString("POINTS_COST")); // NOI18N

        jspinPointsCost.setModel(new javax.swing.SpinnerNumberModel(3, 1, 10, 1));

        jcmbboxGameLevel.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Personalizado", "Fácil", "Moderado", "Expert" }));
        jcmbboxGameLevel.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                ValueChanged(evt);
            }
        });

        jlabGameLevel.setText(languages.getString("GAME_LEVEL")); // NOI18N

        javax.swing.GroupLayout jpanGameLayout = new javax.swing.GroupLayout(jpanGame);
        jpanGame.setLayout(jpanGameLayout);
        jpanGameLayout.setHorizontalGroup(
            jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanGameLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlabMinesQuantity)
                    .addComponent(jlabNumberOfRows)
                    .addComponent(jlabNumberOfCols)
                    .addComponent(jlabCellSize)
                    .addComponent(jlabPointsCost)
                    .addComponent(jlabGameLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 17, Short.MAX_VALUE)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jcmbboxGameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jspinCellSize, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jspinNumberOfCols, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jspinNumberOfRows, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jspinMinas, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jspinPointsCost, javax.swing.GroupLayout.Alignment.TRAILING)))
                .addContainerGap())
        );
        jpanGameLayout.setVerticalGroup(
            jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpanGameLayout.createSequentialGroup()
                .addContainerGap(42, Short.MAX_VALUE)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcmbboxGameLevel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlabGameLevel))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabMinesQuantity)
                    .addComponent(jspinMinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabNumberOfRows)
                    .addComponent(jspinNumberOfRows, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabNumberOfCols)
                    .addComponent(jspinNumberOfCols, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabCellSize)
                    .addComponent(jspinCellSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jpanGameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlabPointsCost)
                    .addComponent(jspinPointsCost, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jbutSave.setText(languages.getString("SAVE_AND_APPLY")); // NOI18N
        jbutSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutSaveActionPerformed(evt);
            }
        });

        jbutCancel.setText(languages.getString("CANCEL")); // NOI18N
        jbutCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutCancelActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jpanGame, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbutCancel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbutSave)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jpanGame, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutCancel)
                    .addComponent(jbutSave))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbutCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutCancelActionPerformed
        setVisible(false);
    }//GEN-LAST:event_jbutCancelActionPerformed

    private void jbutSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutSaveActionPerformed
        try {
            saveAndApplyConfig();
        } catch (IOException ex) {
            Logger.getLogger(Configuration.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(false);
    }//GEN-LAST:event_jbutSaveActionPerformed

    private void ValueChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_ValueChanged
        if (evt.getStateChange() == ItemEvent.SELECTED && evt.getItem().toString() != "") {
            
        }
    }//GEN-LAST:event_ValueChanged

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Configuration.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(() -> {
            Configuration dialog = new Configuration(new javax.swing.JFrame(), true);
            dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                @Override
                public void windowClosing(java.awt.event.WindowEvent e) {
                    System.exit(0);
                }
            });
            dialog.setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jbutCancel;
    private javax.swing.JButton jbutSave;
    private javax.swing.JComboBox<String> jcmbboxGameLevel;
    private javax.swing.JLabel jlabCellSize;
    private javax.swing.JLabel jlabGameLevel;
    private javax.swing.JLabel jlabMinesQuantity;
    private javax.swing.JLabel jlabNumberOfCols;
    private javax.swing.JLabel jlabNumberOfRows;
    private javax.swing.JLabel jlabPointsCost;
    private javax.swing.JPanel jpanGame;
    private javax.swing.JSpinner jspinCellSize;
    private javax.swing.JSpinner jspinMinas;
    private javax.swing.JSpinner jspinNumberOfCols;
    private javax.swing.JSpinner jspinNumberOfRows;
    private javax.swing.JSpinner jspinPointsCost;
    // End of variables declaration//GEN-END:variables

    private void saveAndApplyConfig() throws IOException {
        if (ini instanceof Wini) {
            ini.put("game", MINES_QTY_CONFIG, jspinMinas.getValue());
            ini.put("game", N_ROWS_CONFIG, jspinNumberOfRows.getValue());
            ini.put("game", N_COLS_CONFIG, jspinNumberOfCols.getValue());
            ini.put("game", CELL_SIZE_CONFIG, jspinCellSize.getValue());
            ini.put("game", POINTS_COST_CONFIG, jspinPointsCost.getValue());
            ini.store(new File(DEF_FILE_NAME));
            
            myBoard.setMinesQty(ini.get("game", MINES_QTY_CONFIG, int.class));
            myBoard.setNRows(ini.get("game", N_ROWS_CONFIG, int.class));
            myBoard.setNCols(ini.get("game", N_COLS_CONFIG, int.class));
            myBoard.setCellSize(ini.get("game", CELL_SIZE_CONFIG, int.class));
            myBoard.setPointCost(ini.get("game", POINTS_COST_CONFIG, int.class));
        }
    }
    
    private void loadPrefs() throws IOException {
        File f = new File(DEF_FILE_NAME);
        
        if (!f.exists() && !f.isDirectory()) {
            f.createNewFile();
            ini = new Wini(f);
            startPrefs();
        } else if (f.exists()) 
            ini = new Wini(f);
            
        // MINES_QTY_EXPERT
        jspinMinas.setValue(ini.get("game", MINES_QTY_CONFIG, int.class));
        // N_ROWS_EXPERT
        jspinNumberOfRows.setValue(ini.get("game", N_ROWS_CONFIG, int.class));
        // N_COLS_EXPERT
        jspinNumberOfCols.setValue(ini.get("game", N_COLS_CONFIG, int.class));
        // CELL_SIZE_DEFAULT
        jspinCellSize.setValue(ini.get("game", CELL_SIZE_CONFIG, int.class));
        // POINTS_COST_EXPERT
        jspinPointsCost.setValue(ini.get("game", POINTS_COST_CONFIG, int.class));
    }

    private void startPrefs() throws IOException {
        // Write defaults
        ini.add("game", MINES_QTY_CONFIG, Prefs.MINES_QTY_EXPERT.getVal());
        ini.add("game", N_ROWS_CONFIG, Prefs.N_ROWS_EXPERT.getVal());
        ini.add("game", N_COLS_CONFIG, Prefs.N_COLS_EXPERT.getVal());
        ini.add("game", CELL_SIZE_CONFIG, Prefs.CELL_SIZE_DEFAULT.getVal());
        ini.add("game", POINTS_COST_CONFIG, Prefs.POINTS_COST_EXPERT.getVal());
        ini.store(new File(DEF_FILE_NAME));
    }
    
    public int getPreferenceFromIni(Prefs preference) {
        if (ini instanceof Wini) {
            return ini.get("game", preference.toString(), int.class);
        } else {
            return preference.getVal();
        }
    }
    
    private void setAllPrefsTo(Prefs gameLevel) {
        if ( ArrayUtils.contains(new Prefs[]{Prefs.EASY, Prefs.MODERATE, Prefs.EXPERT}, gameLevel)) {
            // MINES_QTY_EXPERT
            jspinMinas.setValue(Prefs.valueOf("MINES_QTY_" + gameLevel.toString()));
            // N_ROWS_EXPERT
            jspinNumberOfRows.setValue(Prefs.valueOf("N_ROWS_" + gameLevel.toString()));
            // N_COLS_EXPERT
            jspinNumberOfCols.setValue(Prefs.valueOf("N_COLS_" + gameLevel.toString()));
            // CELL_SIZE_DEFAULT
            jspinCellSize.setValue(Prefs.valueOf("CELL_SIZE_" + gameLevel.toString()));
            // POINTS_COST_EXPERT
            jspinPointsCost.setValue(Prefs.valueOf("POINTS_COST_" + gameLevel.toString()));
        }
    }
    
    public static enum Prefs {
        EASY(6),
        MODERATE(66),
        EXPERT(666),
        CELL_SIZE_DEFAULT(25), 
        MINES_QTY_EXPERT(99),
        N_ROWS_EXPERT(30),
        N_COLS_EXPERT(16),
        POINTS_COST_EXPERT(3),
        MINES_QTY_MODERATE(40),
        N_ROWS_MODERATE(16),
        N_COLS_MODERATE(16),
        POINTS_COST_MODERATE(2),
        MINES_QTY_EASY(10),
        N_ROWS_EASY(9),
        N_COLS_EASY(9),
        POINTS_COST_EASY(1);
        
        private final int val;
        
        Prefs (int val) {
            this.val = val;
        }
        
        public int getVal() {
            return val;
        }        
    }
}