package com.jakegut.flappyneat.neat;

import com.jakegut.flappyneat.game.LevelContext;
import com.vadeen.neat.species.Species;

import java.util.List;

public class GenomeEvaluator implements com.vadeen.neat.genome.GenomeEvaluator {

    private final LevelContext levelContext;

    public GenomeEvaluator(LevelContext context){
        levelContext = context;
    }

    @Override
    public void evaluateAll(List<Species> list) {
        levelContext.reset();
        LevelEvaluator evaluator = new LevelEvaluator(levelContext, list);
        evaluator.evaluateAll();

    }
}
