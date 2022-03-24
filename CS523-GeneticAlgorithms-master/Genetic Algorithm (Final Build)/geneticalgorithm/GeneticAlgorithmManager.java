package geneticalgorithm;

import geneticalgorithm.Defs.SELECTION_TYPE;
import geneticalgorithm.Defs.CROSSOVER_TYPE;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group_T9
 * @Description: This class includes codes for all the operators for GA.
 * 
 */
public class GeneticAlgorithmManager {

    public List<Warrior> crossover(List<Warrior> warriorList, Defs.CROSSOVER_TYPE type) {
        System.out.println("New warrior list size before crossover: " + warriorList.size());
        List<Warrior> newWarriorList = new ArrayList<Warrior>();
        newWarriorList.add(new Warrior(warriorList.get(0).getGenelist()));
        newWarriorList.add(new Warrior(warriorList.get(1).getGenelist()));

        for (int i = 0; i < (warriorList.size() - 2) / 2; i++) {
            int randomParent_1 = Utils.getRandomInteger(2, ((warriorList.size() - 2) / 2) + 1);
            int randomParent_2 = Utils.getRandomInteger(((warriorList.size() - 2) / 2) + 2, warriorList.size() - 1);

            List<Gene> geneList_1 = warriorList.get(randomParent_1).getGenelist();
            List<Gene> geneList_2 = warriorList.get(randomParent_2).getGenelist();
            int geneLength_1 = geneList_1.size();
            int geneLength_2 = geneList_2.size();
            int minGeneLength = (geneLength_1 < geneLength_2) ? geneLength_1 : geneLength_2;

            if (type == Defs.CROSSOVER_TYPE.ONEPOINT) {
                int randomCrossoverPoint = Utils.getRandomInteger(1, minGeneLength - 2);
                List<Gene> newGeneList_1 = new ArrayList<Gene>();
                List<Gene> newGeneList_2 = new ArrayList<Gene>();
                for (int j = 0; j < randomCrossoverPoint; j++) {
                    newGeneList_1.add(new Gene(
                            geneList_1.get(j).getInstruction(),
                            geneList_1.get(j).getNumberOfParams(),
                            geneList_1.get(j).getParam1(),
                            geneList_1.get(j).getParam2(),
                            geneList_1.get(j).getAddressModifier1().charValue(),
                            geneList_1.get(j).getAddressModifier2().charValue()
                    ));
                    newGeneList_2.add(new Gene(
                            geneList_2.get(j).getInstruction(),
                            geneList_2.get(j).getNumberOfParams(),
                            geneList_2.get(j).getParam1(),
                            geneList_2.get(j).getParam2(),
                            geneList_1.get(j).getAddressModifier1().charValue(),
                            geneList_1.get(j).getAddressModifier2().charValue()
                    ));
                }
                for (int j = randomCrossoverPoint; j < geneLength_2; j++) {
                    newGeneList_1.add(new Gene(
                            geneList_2.get(j).getInstruction(),
                            geneList_2.get(j).getNumberOfParams(),
                            geneList_2.get(j).getParam1(),
                            geneList_2.get(j).getParam2(),
                            geneList_1.get(j).getAddressModifier1().charValue(),
                            geneList_1.get(j).getAddressModifier2().charValue()
                    ));
                }
                for (int j = randomCrossoverPoint; j < geneLength_1; j++) {
                    newGeneList_2.add(new Gene(
                            geneList_1.get(j).getInstruction(),
                            geneList_1.get(j).getNumberOfParams(),
                            geneList_1.get(j).getParam1(),
                            geneList_1.get(j).getParam2(),
                            geneList_1.get(j).getAddressModifier1().charValue(),
                            geneList_1.get(j).getAddressModifier2().charValue()
                    ));
                }
                newWarriorList.add(new Warrior(geneList_1));
                newWarriorList.add(new Warrior(geneList_2));

            } else if (type == Defs.CROSSOVER_TYPE.UNIFORM) {

                List<Gene> newGeneList_1 = new ArrayList<Gene>();
                List<Gene> newGeneList_2 = new ArrayList<Gene>();
                int j = 0;
                for (; j < minGeneLength; j++) {
                    Double randomProbOfFlip = Utils.getRandomProbability();
                    if (randomProbOfFlip.doubleValue() < 0.5) {
                        newGeneList_1.add(new Gene(
                                geneList_2.get(j).getInstruction(),
                                geneList_2.get(j).getNumberOfParams(),
                                geneList_2.get(j).getParam1(),
                                geneList_2.get(j).getParam2(),
                                geneList_1.get(j).getAddressModifier1().charValue(),
                                geneList_1.get(j).getAddressModifier2().charValue()
                        ));
                        newGeneList_2.add(new Gene(
                                geneList_1.get(j).getInstruction(),
                                geneList_1.get(j).getNumberOfParams(),
                                geneList_1.get(j).getParam1(),
                                geneList_1.get(j).getParam2(),
                                geneList_1.get(j).getAddressModifier1().charValue(),
                                geneList_1.get(j).getAddressModifier2().charValue()
                        ));
                    } else {
                        newGeneList_1.add(new Gene(
                                geneList_1.get(j).getInstruction(),
                                geneList_1.get(j).getNumberOfParams(),
                                geneList_1.get(j).getParam1(),
                                geneList_1.get(j).getParam2(),
                                geneList_1.get(j).getAddressModifier1().charValue(),
                                geneList_1.get(j).getAddressModifier2().charValue()
                        ));
                        newGeneList_2.add(new Gene(
                                geneList_2.get(j).getInstruction(),
                                geneList_2.get(j).getNumberOfParams(),
                                geneList_2.get(j).getParam1(),
                                geneList_2.get(j).getParam2(),
                                geneList_1.get(j).getAddressModifier1().charValue(),
                                geneList_1.get(j).getAddressModifier2().charValue()
                        ));
                    }
                }
                if (j < geneLength_1) {
                    for (; j < geneLength_1; j++) {
                        newGeneList_1.add(new Gene(
                                geneList_1.get(j).getInstruction(),
                                geneList_1.get(j).getNumberOfParams(),
                                geneList_1.get(j).getParam1(),
                                geneList_1.get(j).getParam2(),
                                geneList_1.get(j).getAddressModifier1().charValue(),
                                geneList_1.get(j).getAddressModifier2().charValue()
                        ));
                    }
                }
                if (j < geneLength_2) {
                    for (; j < geneLength_2; j++) {
                        newGeneList_2.add(new Gene(
                                geneList_2.get(j).getInstruction(),
                                geneList_2.get(j).getNumberOfParams(),
                                geneList_2.get(j).getParam1(),
                                geneList_2.get(j).getParam2(),
                                geneList_2.get(j).getAddressModifier1().charValue(),
                                geneList_2.get(j).getAddressModifier2().charValue()
                        ));
                    }
                }
                newWarriorList.add(new Warrior(geneList_1));
                newWarriorList.add(new Warrior(geneList_2));
            }
        }
        System.out.println("New warrior list size after crossover: " + newWarriorList.size());
        return newWarriorList;
    }

    //If the probability of mutation is greater than or equal to 0.5, a 
    //random gene is chosen from the geneList to be mutated. This new
    //gene will replace the previous version it was mutated from.
    List<Warrior> mutation(List<Warrior> warriorList) {
        for (int i = 2; i < warriorList.size(); i++) {
            double mutation_probability = Utils.getRandomProbability();
            int random_allele = Utils.getRandomInteger(
                    0,
                    warriorList.get(i).getGenelist().size() - 1);
            if (mutation_probability >= Defs.PROBABILITY_FOR_MUTATION) {
                Warrior warrior = warriorList.get(i);
                List<Gene> warrior_geneList = warrior.getGenelist();
                Gene mutant_gene = new Gene();
                warrior_geneList.set(random_allele, mutant_gene);
                warrior.setGenelist(warrior_geneList);
            }
        }
        return warriorList;
    }

    public List<Warrior> selection(List<Warrior> warriorList, SELECTION_TYPE type) {
        System.out.println("New warrior list size before selection: " + warriorList.size());
        int warriorListSize = warriorList.size();
        //warriorList = Utils.sortWarriorsAccordingToScore(warriorList);
        List<Warrior> newWarriorList = new ArrayList<Warrior>();
        if (type == Defs.SELECTION_TYPE.ROULETTE) {
            Double totalScore = 0.1;
            for (int i = 0; i < warriorListSize; i++) {
                totalScore += warriorList.get(i).getFitnessScore();
            }
            for (int i = 0; i < warriorListSize; i++) {
                Double currentRatio = warriorList.get(i).getFitnessScore() / totalScore;
                warriorList.get(i).setFitnessRatio(currentRatio);
                double ceilingRatio = Math.ceil(currentRatio.doubleValue());
                int intRatio = (int) ceilingRatio;
                int numberOfDuplicateWarrior = intRatio * warriorListSize;
                for (int j = 0; j < numberOfDuplicateWarrior; j++) {
                    if (newWarriorList.size() < warriorList.size()) {
                        newWarriorList.add(new Warrior(warriorList.get(i).getGenelist()));
                    }
                }
            }
        } else if (type == Defs.SELECTION_TYPE.TOURNAMENT) {
            newWarriorList.add(new Warrior(warriorList.get(0).getGenelist()));
            newWarriorList.add(new Warrior(warriorList.get(1).getGenelist()));
            Integer randomNumberOfFixedWarrior = Utils.getRandomInteger(2, 4);
            for (int i = 0; i < randomNumberOfFixedWarrior; i++) {
                newWarriorList.add(new Warrior(warriorList.get(i).getGenelist()));
            }
            while (newWarriorList.size() < warriorList.size()) {
                int randomPickedWarrior = Utils.getRandomInteger(0, randomNumberOfFixedWarrior - 1);
                newWarriorList.add(new Warrior(warriorList.get(randomPickedWarrior).getGenelist()));
            }
        } else if (type == Defs.SELECTION_TYPE.RANDOM) {
        	boolean elitism = Defs.USE_ELITISM;
        	if (elitism == true) {
                int i;
                for (i = 0; i < warriorListSize / 2; i++) {
                    newWarriorList.add(new Warrior(warriorList.get(i).getGenelist()));
                }
                for (; i < warriorListSize; i++) {
                    Integer randomNumber = Utils.getRandomInteger(0, (warriorListSize / 2) + 1);
                    newWarriorList.add(new Warrior(warriorList.get(randomNumber).getGenelist()));
                }
            } else {
                for (int i = 0; newWarriorList.size() < warriorList.size(); i++) {
                    int randomInt = Utils.getRandomInteger(0, warriorList.size() - 1);
                    newWarriorList.add(new Warrior(warriorList.get(randomInt).getGenelist()));
                }
            }
        }
        
        
        System.out.println("New warrior list size after selection: " + newWarriorList.size());
        return newWarriorList;
    }

//    public static Population generatePopulation() {
//        Population population = new Population();
//        List<Warrior> warriorList = new ArrayList<Warrior>();
//        Integer numberOfWarriors = Utils.getRandomInteger(Defs.NO_OF_WARRIORS_IN_POPULATION_RANGE_START, Defs.NO_OF_WARRIORS_IN_POPULATION_RANGE_END) * Defs.WARRIOR_MULTIPLICATION_FACTOR;
//        for (int i = 0; i < numberOfWarriors; i++) {
//            Warrior currenrtwarrior = new Warrior();
//            warriorList.add(currenrtwarrior);
//        }
//        population.setWarriorList(warriorList);
//        population.setNumber_of_warrior(numberOfWarriors);
//        return population;
//    }
//    public static void main(String[] args) {
//        Population population = generatePopulation();
//        int i = 1;
//        for (Warrior warrior : population.getWarriorList()) {
//            if (Defs.runMode == Defs.RUN_MODE.DEBUG) System.out.println("Warrior " + i++);
//            if (Defs.runMode == Defs.RUN_MODE.DEBUG) System.out.println(warrior.convertToString());
//        }
//        if (Defs.runMode == Defs.RUN_MODE.DEBUG) System.out.println("Trace before mutation");
//        List<Warrior> warriors = mutation(population.getWarriorList());
//        i = 1;
//        for (Warrior warrior : warriors) {
//            if (Defs.runMode == Defs.RUN_MODE.DEBUG) System.out.println("Warrior " + i++);
//            if (Defs.runMode == Defs.RUN_MODE.DEBUG) System.out.println(warrior.convertToString());
//        }
//    }
}
