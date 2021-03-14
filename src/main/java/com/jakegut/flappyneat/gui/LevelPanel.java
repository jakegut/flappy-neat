package com.jakegut.flappyneat.gui;

import com.jakegut.flappyneat.game.LevelContext;
import com.vadeen.neat.gui.visualization.VisualPanel;

import java.awt.*;

public class LevelPanel extends VisualPanel {

    private final LevelContext context;

    public LevelPanel(LevelContext context){
        super();
        this.context = context;
    }

    @Override
    public float getAspectRatio() {
        return 4/3f;
    }


    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D)g;
        paintBackground(g2);

        BirdPainter.paint(g2, context.getBirds(), context.getImage("Bird"));
        PipePainter.paint(g2, context.getPipes(), context.getImage("TopPipe"), context.getImage("BottomPipe"));
    }

    private void paintBackground(Graphics g){
        g.drawImage(context.getImage("Background"), 0, 0, null);
    }
}
