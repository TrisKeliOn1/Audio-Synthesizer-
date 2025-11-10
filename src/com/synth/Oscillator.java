package com.synth;

import com.synth.utils.Utils;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.util.Random;

public class Oscillator extends JPanel {

    private static final double FREQUENCY = 440;

    private final Random random = new Random();

    private WaveForm waveForm = WaveForm.Sine;
    private int wavePos;

    public Oscillator() {
        JComboBox<WaveForm> comboBox = new JComboBox<>(new WaveForm[] {WaveForm.Sine, WaveForm.Square, WaveForm.Saw, WaveForm.Triangle, WaveForm.Noise});
        comboBox.setSelectedItem(WaveForm.Sine);
        comboBox.setBounds(10, 10, 75, 25);
        comboBox.addItemListener(l -> {
            if (l.getStateChange() == ItemEvent.SELECTED) {
                waveForm = (WaveForm)l.getItem();
            }
        });
        add(comboBox);
        setSize(279, 100);
        setBorder(Utils.WindowDesign.LINE_BORDER);
        setLayout(null);
    }

    private enum WaveForm {
        Sine, Square, Saw, Triangle, Noise
    }

    public double nextSample() {
        double tDivP = (wavePos++ / (double)SynthesizerRemastered.AudioInfo.SAMPLE_RATE) / ( 1d / FREQUENCY);
        switch (waveForm) {
            case Sine:
                return Math.sin(Utils.Math.frequencyToAngualrFrequency(FREQUENCY) * (wavePos - 1) / SynthesizerRemastered.AudioInfo.SAMPLE_RATE);
            case Square:
                return Math.signum(Math.sin(Utils.Math.frequencyToAngualrFrequency(FREQUENCY) * (wavePos - 1) / SynthesizerRemastered.AudioInfo.SAMPLE_RATE));
            case Saw:
                return 2d * (tDivP - Math.floor(0.5 + tDivP));
            case Triangle:
                return 2d * Math.abs(2d * (tDivP - Math.floor(0.5 + tDivP))) - 1;
            case Noise:
                return random.nextDouble();
            default:
                throw new RuntimeException("Oscillator set to unknow waveform");
        }
    }
}
