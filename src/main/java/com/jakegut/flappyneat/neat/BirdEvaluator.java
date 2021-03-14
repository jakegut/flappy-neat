package com.jakegut.flappyneat.neat;

import com.jakegut.flappyneat.game.Bird;
import com.jakegut.flappyneat.game.LevelContext;
import com.vadeen.neat.genome.Genome;
import com.vadeen.neat.genome.GenomePropagator;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class BirdEvaluator {

    private final LevelContext levelContext;
    private final Bird bird;
    private final Genome genome;
    private final GenomePropagator genomePropagator;

    public BirdEvaluator(LevelContext levelContext, Bird bird, Genome g, GenomePropagator genomePropagator){
        this.levelContext = levelContext;
        this.bird = bird;
        this.genome = g;
        this.genomePropagator = genomePropagator;
    }

    public Bird getBird(){
        return this.bird;
    }

    public boolean evaluate(float t){
        List<Float> inputs = levelContext.getBirdValues(bird);
        List<Float> outputs = genomePropagator.propagate(inputs);
        System.out.println("---");
        System.out.println(inputs);
        System.out.println(outputs);

        boolean jump = outputs.get(0) > .8f;
        System.out.println("jump " + jump);
        bird.tick(jump, t, levelContext);
        System.out.println(bird.getFitness());
        genome.setFitness(bird.getFitness());

        return !bird.dead();
    }

}
