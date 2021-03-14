package com.jakegut.flappyneat.neat;

import com.jakegut.flappyneat.game.LevelContext;
import com.jakegut.flappyneat.game.Pipe;
import com.vadeen.neat.generation.Generation;
import com.vadeen.neat.gui.visualization.Visualizer;

public class LevelVisualizer implements Visualizer {

    private final LevelContext levelContext;
    private LevelEvaluator evaluator;

    public LevelVisualizer(LevelContext ctx){
        this.levelContext = ctx;
    }

    @Override
    public int getFramesPerSecond() {
        return 60;
    }

    @Override
    public void setup(Generation generation) {
        levelContext.reset();
        evaluator = new LevelEvaluator(levelContext, generation.getSpecies());
    }

    @Override
    public boolean tick() {

        evaluator.tick(1/(float)getFramesPerSecond());
        return true;
    }
}
