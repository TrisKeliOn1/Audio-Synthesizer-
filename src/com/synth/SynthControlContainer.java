package com.synth;

import javax.swing.*;
import java.awt.*;

public class SynthControlContainer extends JPanel {

    protected boolean on;
    private SynthesizerRemastered synth;


    public SynthControlContainer(SynthesizerRemastered synth) {
        this.synth = synth;
    }

    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }


}
