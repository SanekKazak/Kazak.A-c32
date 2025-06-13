package org.alex.structure_patterns.bridge;

public class Laptop implements Computer {
    private String accumulator;
    private VideoComponent component;

    public Laptop(VideoComponent component, String accumulator) {
        this.component = component;
        this.accumulator = accumulator;
    }
    public void playVideo(){
        System.out.println(accumulator + " power and "+ component +" render generate video");
    }
    public VideoComponent getVideoComponent(){
        return component;
    }
}
