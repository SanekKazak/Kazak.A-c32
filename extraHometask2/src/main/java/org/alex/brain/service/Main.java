package org.alex.brain.service;

import org.alex.brain.process.In;
import org.alex.brain.process.Out;
import org.alex.brain.storage.Storage;

public class Main {
    public static void main(String[] args) {
        Storage marker = new Storage();
        Thread in = new Thread(new In(marker));
        Thread out = new Thread(new Out(marker));
        in.start();
        out.start();

    }
}
