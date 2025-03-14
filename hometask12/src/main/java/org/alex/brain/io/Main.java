package org.alex.brain.io;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\kazak\\Desktop\\Composition.txt");
        IoImpl impl = new IoImpl();
        String[] str = {"Romeo", "Gulieta"};
        impl.connectParts(impl.readComposition(file),str, "Romeo");
//        impl.connectParts(impl.readComposition(file),str, "Gulieta");
    }
}
