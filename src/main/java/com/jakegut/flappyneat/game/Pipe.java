package com.jakegut.flappyneat.game;

import java.awt.*;
import java.awt.geom.Area;
import java.util.Random;

public class Pipe {
    private int x;
    private int y;

    private final int oldX;

    public Pipe(int x){
        reset(x);
        this.oldX = x;
    }

    public void tick(){
        if(x > -52){
            x--;
        } else {
            reset(LevelContext.W + 200);
        }
    }

    public void reset(int x){
        this.x = x;
        y = new Random().nextInt(LevelContext.H / 4 - 25) * 2 + 25;
    }

    public boolean checkCollision(Bird bird, LevelContext ctx){
        Image top = ctx.getImage("TopPipe");
        Image bottom = ctx.getImage("BottomPipe");
        int[] xpoints1 = {x, x, x + top.getWidth(null), x + top.getWidth(null)};
        int[] ypoints1 = {y - top.getHeight(null), y, y, y - top.getHeight(null)};

        int[] xpoints2 = {x, x, x + bottom.getWidth(null), x + bottom.getWidth(null)};
        int[] ypoints2 = {y + 200, y + 200  + bottom.getHeight(null),
                y + 200  + bottom.getHeight(null), y + 200 };


        Polygon p1 = new Polygon(xpoints1, ypoints1, 4);
        Polygon p2 = new Polygon(xpoints2, ypoints2, 4);

        Area a1 = new Area(p1);
        Area a2 = new Area(p2);

        return
            a1.intersects(bird.getX(), bird.getY(), 35, 30) ||
                    a2.intersects(bird.getX(), bird.getY(), 35, 35);

    }

    public int getX(){
        return this.x;
    }

    public int getY() {
        return this.y;
    }
}
