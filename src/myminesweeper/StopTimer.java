/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package myminesweeper;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;
import javax.swing.Timer;
import org.apache.commons.lang3.time.DurationFormatUtils;
import org.apache.commons.lang3.time.StopWatch;

/**
 *
 * @author willi
 */
public class StopTimer implements ActionListener{

    private final String MENSAGEM = "Tempo Transcorrido: ";
    private final String ZERADO = "0:00";
    
    private final StopWatch temporizador;
    private final Timer disparador;
    private final JLabel visor;
    
    StopTimer(JLabel label) {
        visor = label;
        temporizador = new StopWatch();
        disparador = new Timer(1000, this);
        disparador.start();        
    }

    public void iniciar() {
        if (!temporizador.isStarted())
            temporizador.start();
    }
    
    public void reiniciar() {
        temporizador.reset();
        reiniciarVisor();
    }
    
    private void reiniciarVisor() {
        visor.setText(MENSAGEM + ZERADO);        
    }
    
    public void parar() {
        if (temporizador.isStarted() || temporizador.isSuspended()) {
            temporizador.stop();
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (temporizador.isStarted()) {
            visor.setText(visor.getName() + DurationFormatUtils.formatDuration(temporizador.getTime(), "m:ss", true));
        }        
    }
}
