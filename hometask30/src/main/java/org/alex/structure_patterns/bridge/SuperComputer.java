package org.alex.structure_patterns.bridge;

public class SuperComputer implements Computer {
    private VideoComponent component;
    public SuperComputer(VideoComponent component) {
        this.component = component;
    }

    @Override
    public void playVideo() {
        System.out.println("Playing video with " + component);
    }
    public VideoComponent getVideoComponent(){
        return component;
    }
}
