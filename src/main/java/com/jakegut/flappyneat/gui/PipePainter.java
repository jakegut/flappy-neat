package com.jakegut.flappyneat.gui;

import com.jakegut.flappyneat.game.Pipe;

import java.awt.*;
import java.util.List;

public class PipePainter {
    public static void paint(Graphics2D g2, List<Pipe> pipes, Image topPipe, Image bottomPipe) {
        for(Pipe p : pipes){
//            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
            g2.drawImage(topPipe, p.getX(), p.getY() - topPipe.getHeight(null), topPipe.getWidth(null), topPipe.getHeight(null), null);
            g2.drawImage(bottomPipe, p.getX(), p.getY() + 200, bottomPipe.getWidth(null), bottomPipe.getHeight(null) , null);
        }
    }
}
