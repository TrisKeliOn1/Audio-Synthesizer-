package com.synth;

import javax.swing.*;

public class SynthesizerRemastered {

    private boolean shouldGenerate;
    private int wavePos;

    private final JFrame frame = new JFrame ("Synthesizer Remastered");
    private final AudioThread thread = new AudioThread(() ->{
        if (!shouldGenerate) {
            return null;
        }
        short[] s = new short[AudioThread.BUFFER_SIZE];
        for (int i = 0; i < AudioThread.BUFFER_SIZE; i++) {
            s[i] = (short) (Short.MAX_VALUE * Math.sin((2 * Math.PI * 440) / AudioInfo.SAMPLE_RATE * wavePos++));
        }
        return s;
    });

    SynthesizerRemastered() {
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        frame.setSize(613, 357);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static class AudioInfo {
        public static final  int SAMPLE_RATE = 44100;
    }

}
