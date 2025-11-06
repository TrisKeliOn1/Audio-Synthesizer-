package com.synth;

import org.lwjgl.openal.AL;
import org.lwjgl.openal.ALC;

import static org.lwjgl.openal.AL10.*;
import static org.lwjgl.openal.ALC10.*;

class AudioThread extends  Thread{

    private final int BUFFER_SIZE = 512;
    private final int BUFFER_COUNT = 8;

    private final int [] buffers = new int[BUFFER_COUNT];
    private final long device = alcOpenDevice(alcGetString(0, ALC_DEVICE_SPECIFIER));
    private final long context = alcCreateContext(device, new int[1]);
    private final int source;

    private int bufferIndex;

    AudioThread() {
        alcMakeContextCurrent(context);
        AL.createCapabilities(ALC.createCapabilities(device));
        source = alGenSources();
        for (int i = 0; i < BUFFER_COUNT; i++) {
            // add buffer samples in the future
        }

        alSourcePlay(source);
        // add catch internal excpetion in the future
        start();
    }

    private void bufferSample(short[] samples){
        int buf = buffers[bufferIndex++];
    }

}
