/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ayudantia.Model.Util;

import Ayudantia.GUI.GUI_Ingreso;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *
 * @author raguileoam
 */
public abstract class Sound {
    public static void play(String sound){
            Clip sonido = null;
            try {
                sonido = AudioSystem.getClip();
                sonido.open(AudioSystem.getAudioInputStream(new File("sound/"+sound+".wav")));
            } catch (LineUnavailableException ex) {
                Logger.getLogger(GUI_Ingreso.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedAudioFileException ex) {
                Logger.getLogger(GUI_Ingreso.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(GUI_Ingreso.class.getName()).log(Level.SEVERE, null, ex);
            }
                      
            sonido.start();
}
}