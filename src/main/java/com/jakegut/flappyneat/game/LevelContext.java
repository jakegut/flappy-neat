package com.jakegut.flappyneat.game;

import java.awt.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class LevelContext {
    public static int W;
    public static int H;

    private final List<Bird> birds = new ArrayList<>();
    private final List<Pipe> pipes = new ArrayList<>();
    private final ImageManager imageManager;

    public LevelContext(int width, int height){
        LevelContext.W = width;
        LevelContext.H = height;
        imageManager = new ImageManager();
        makePipes();
    }

    private void makePipes() {
        for(int i = 0; i < 5; i++){
            pipes.add(new Pipe(LevelContext.W - 100 + (204 * i)));
        }
    }

    public void addBird(Bird bird) {
        this.birds.add(bird);
    }

    public List<Pipe> getPipes() {
        return this.pipes;
    }

    public List<Float> getBirdValues(Bird bird) {
        List<Float> inputs = new LinkedList<>();
        inputs.add(bird.getVelocity());
        inputs.add(bird.getY());

        float minX = LevelContext.W;
        float minY = LevelContext.H / 2f;
        for(Pipe p : pipes){
            float dist = p.getX() - bird.getX();
            if(dist < minX && dist >= -52){
                minX = dist;
                minY = p.getY() + (p.getGap() / 2);
            }
        }

        inputs.add(minY);

        return inputs;
    }

    public void reset() {
        this.birds.clear();
        this.pipes.clear();
        makePipes();
    }

    public Image getImage(String key){
        return imageManager.getImage(key);
    }

    public List<Bird> getBirds() {
        return this.birds;
    }
}
