package com.jakegut.flappyneat;

import com.jakegut.flappyneat.game.LevelContext;
import com.jakegut.flappyneat.gui.LevelPanel;
import com.jakegut.flappyneat.neat.GenomeEvaluator;
import com.jakegut.flappyneat.neat.LevelVisualizer;
import com.vadeen.neat.Neat;
import com.vadeen.neat.genome.GenomeComparator;
import com.vadeen.neat.genome.GenomeMutator;
import com.vadeen.neat.gui.NeatGui;
import com.vadeen.neat.species.SpeciesFactory;

public class Level {
    private final Neat neat;
    private final LevelContext levelContext;

    public static void main(String[] args){
        LevelContext levelContext = new LevelContext(800, 600);

        GenomeEvaluator evaluator = new GenomeEvaluator(levelContext);
        Neat neat = createNeat(evaluator);

        Level level = new Level(neat, levelContext);
        level.run();
    }


    public Level(Neat neat, LevelContext levelContext){
        this.neat = neat;
        this.levelContext = levelContext;
    }

    public void run(){
        LevelPanel lp = new LevelPanel(levelContext);

        LevelVisualizer visualizer = new LevelVisualizer(levelContext);

        NeatGui gui = new NeatGui(neat, visualizer, lp);
        gui.run();
    }

    private static Neat createNeat(GenomeEvaluator evaluator) {
        Neat neat = Neat.create(evaluator, 3, 1);

        neat.getGenerationFactory().setPopulationSize(50);

        // Config mutator
        GenomeMutator mutator = neat.getMutator();
        mutator.setWeightPerturbingFactor(9.0f);
        mutator.setNodeMutationProbability(0.1f);
        mutator.setConnectionMutationProbability(0.95f);
        mutator.setWeightMutationProbability(0.8f);

        // Config comparator
        GenomeComparator comparator = neat.getGenomeComparator();
        comparator.setDisjointFactor(0.1f);
        comparator.setExcessFactor(0.1f);
        comparator.setWeightDiffFactor(0.06f);

        // Config species factory
        SpeciesFactory speciesFactory = neat.getSpeciesFactory();
        speciesFactory.setDistanceThreshold(3);

        return neat;
    }
}
