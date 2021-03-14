package com.jakegut.flappyneat.game;

import java.util.List;
import java.util.logging.Level;

public class Bird {

    private float x;
    private float y;
    private float velocity;
    float uv;
    float dv;

    private float g = 0.25f;

    private float fitness;

    boolean dead;

    public Bird(float x, float y, float uv, float dv){
        this.x = x;
        this.y = y;
        this.uv = uv;
        this.dv = dv;

        this.dead = false;
        this.velocity = 0f;
        this.fitness = 0f;
    }

    public void tick(boolean jump, float t, LevelContext ctx){
        if(dead) return;

        fitness += 1;

        if(jump){
            velocity = -uv * 5;
//            System.out.println("Jumping!!!");
            System.out.println("Y: " + y + " | " + velocity);
        }
        else
            velocity -= dv;
        y += velocity / 60;

        deadCheck(ctx);
    }

    private void deadCheck(LevelContext ctx) {
        if(y <= 0 || y >= LevelContext.H){
            dead = true;
            return;
        }

        for(Pipe p : ctx.getPipes()){
            if(p.checkCollision(this, ctx)){
                dead = true;
                return;
            }
        }
    }

    public boolean dead(){
        return this.dead;
    }

    public float getVelocity(){
        return this.velocity;
    }

    public float getX(){
        return this.x;
    }

    public float getY(){
        return this.y;
    }

    public float getFitness() {
        return this.fitness;
    }
}
