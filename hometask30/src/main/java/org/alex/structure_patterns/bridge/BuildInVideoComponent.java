package org.alex.structure_patterns.bridge;

public class BuildInVideoComponent implements VideoComponent {
    @Override
    public void render() {
        System.out.println("specific amd render");
    }
}
