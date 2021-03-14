package com.jakegut.flappyneat.gui;

import com.jakegut.flappyneat.game.Bird;

import java.awt.*;
import java.util.List;

public class BirdPainter {

    public static void paint(Graphics2D g, List<Bird> birds, Image bird){
        for(Bird b : birds){
            if(!b.dead())
                g.drawImage(bird, (int) b.getX(), (int) b.getY(), bird.getWidth(null), bird.getHeight(null), null);
        }
    }
}
