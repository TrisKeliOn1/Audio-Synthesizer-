package com.synth;

import com.synth.utils.Utils;

import javax.swing.*;
import java.awt.*;
import java.util.function.Function;

public class WaveViewer extends JPanel {

    private Oscillator[] oscillators;

    public WaveViewer(Oscillator[] oscillators) {
        this.oscillators = oscillators;
        setBorder(Utils.WindowDesign.LINE_BORDER);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        final int PAD = 25;
        super.paintComponent(graphics);

        Graphics2D g2d = (Graphics2D) graphics;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int numSamples = Math.max(1, getWidth() - PAD * 2);
        double[] mixedSamples = new double[numSamples];

        // sem normalizar
        for (Oscillator oscillator : oscillators) {
            double[] samples = oscillator.getSampleWaveForm(numSamples);
            for (int i = 0; i < samples.length; i++) {
                mixedSamples[i] += samples[i];
            }
        }

        // Normalização (vistual)
        double max = 0.0;
        for (double v : mixedSamples) {
            max = Math.max(max, Math.abs(v));
        }

        if (max > 0.0) {
            double scale = max > 1.0 ? max : 1.0;

            for (int i = 0; i < mixedSamples.length; i++) {
                mixedSamples[i] /= scale;
            }
        }


        int midY = getHeight() / 2;
        Function<Double, Integer> sampleToY =
                sample -> (int) (midY + sample * (midY - PAD));

        // Eixos
        g2d.drawLine(PAD, midY, getWidth() - PAD, midY);
        g2d.drawLine(PAD, PAD, PAD, getHeight() - PAD);

        // Desenho da onda
        for (int i = 0; i < numSamples - 1; i++) {
            g2d.drawLine(
                    PAD + i,
                    sampleToY.apply(mixedSamples[i]),
                    PAD + i + 1,
                    sampleToY.apply(mixedSamples[i + 1])
            );
        }
    }
}
