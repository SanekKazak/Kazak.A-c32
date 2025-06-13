package org.alex.structure_patterns.bridge;

public class Main {
    public static void main(String[] args) {
        Computer laptop = new Laptop(new BuildInVideoComponent(), "ACS-20W");
    }
}
