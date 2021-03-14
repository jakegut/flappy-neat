package com.jakegut.flappyneat.neat;

import com.jakegut.flappyneat.game.Bird;
import com.jakegut.flappyneat.game.LevelContext;
import com.jakegut.flappyneat.game.Pipe;
import com.vadeen.neat.genome.Genome;
import com.vadeen.neat.genome.GenomePropagator;
import com.vadeen.neat.gui.Gui;
import com.vadeen.neat.species.Species;

import java.awt.*;
import java.util.LinkedList;
import java.util.List;

public class LevelEvaluator {

    private static final int TICK_TIMEOUT = 10000;

    private final LevelContext levelContext;
    private final List<BirdEvaluator> birdEvaluators;

    public LevelEvaluator(LevelContext ctx, List<Species> species){
        this.levelContext = ctx;
        this.birdEvaluators = createEvaluators(species);
    }

    private List<BirdEvaluator> createEvaluators(List<Species> species){
        List<BirdEvaluator> evaluators = new LinkedList<>();

        for (Species s : species){
            Color speciesColor = Gui.colorOfId(s.getId());

            for(Genome g : s.getGenomes()){
                Bird bird = new Bird(300,200, 50, -8);
                GenomePropagator propogator = new GenomePropagator(g);
                BirdEvaluator birdEvaluator = new BirdEvaluator(levelContext, bird, g, propogator);

                evaluators.add(birdEvaluator);
                levelContext.addBird(bird);
            }
        }
        return evaluators;
    }

    public void evaluateAll() {
        float oldTime = System.currentTimeMillis();
        while(true){
            float currentTime = System.currentTimeMillis();
//            float t = currentTime - oldTime;
            if(!tick(1/60f))
                break;
            oldTime = currentTime;
        }
    }

    public boolean tick(float t) {
        boolean progress = false;
        for(Pipe p : levelContext.getPipes()){
            p.tick();
        }
        for(BirdEvaluator birdEvaluator : birdEvaluators){
            if(birdEvaluator.getBird().dead()){
//                System.out.println("bird dead");
                continue;
            }


            if(birdEvaluator.evaluate(t))
                progress = true;
        }

        return progress;
    }
}
