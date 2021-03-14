package com.jakegut.flappyneat.gui;

import com.jakegut.flappyneat.game.Pipe;

import java.awt.*;
import java.util.List;

public class PipePainter {
    public static void paint(Graphics2D g2, List<Pipe> pipes, Image topPipe, Image bottomPipe) {
        g2.setColor(Color.RED);
        for(Pipe p : pipes){
//            System.out.println("(" + p.getX() + ", " + p.getY() + ")");
            g2.drawImage(topPipe, p.getX(), p.getY() - topPipe.getHeight(null), topPipe.getWidth(null), topPipe.getHeight(null), null);
            g2.drawImage(bottomPipe, p.getX(), p.getY() + p.getGap(), bottomPipe.getWidth(null), bottomPipe.getHeight(null) , null);
            g2.drawRect(p.getX() + 26 - 10, p.getY() + 100 - 10, 20, 20);
        }
    }
}
