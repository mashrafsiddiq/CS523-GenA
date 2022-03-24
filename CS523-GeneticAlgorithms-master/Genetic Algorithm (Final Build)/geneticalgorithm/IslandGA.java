package geneticalgorithm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 
 * @author Group_T9
 * @description This class has the necessary function and codes
 * to run the Island GA.
 *
 */
public class IslandGA {
	
	static void writeWarriorToFile(Warrior warrior) {
		String warriorString = warrior.getWarriorFileString();
		try (PrintWriter out = new PrintWriter("Best_Warrior_T9.red")) {
			out.println(warriorString);
			out.close();
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		}
	}

	public static void main() {
		
		List<Warrior> warriorList1 = new ArrayList<Warrior>();
		List<Warrior> warriorList2 = new ArrayList<Warrior>();
		List<Warrior> warriorList3 = new ArrayList<Warrior>();

		Population population = new Population();
		
		// Island GA Initial
		System.out.println("Start time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		GeneticAlgorithmManager gmManager = new GeneticAlgorithmManager();
		PmarsManager pMarsManager = new PmarsManager();	

		for (int j = 0; j < Defs.NUMBER_OF_GENERATIONS; j++) {
			population = pMarsManager.getFitnessScore(population);
			if (true) {
				System.out.println("Generation: " + (j + 1));
				for (Warrior warrior : population.getWarriorList()) {
					System.out.println(warrior.getFitnessScore());
				}
			}
			population.setWarriorList(gmManager.selection(population.getWarriorList(), Defs.SELECTION_TYPE.RANDOM));
			population.setWarriorList(gmManager.crossover(population.getWarriorList(), Defs.CROSSOVER_TYPE.ONEPOINT));
			population.setWarriorList(gmManager.mutation(population.getWarriorList()));
		}

		System.out.println("Best warrior: ");
		System.out.println(population.getWarriorList().get(0).getWarriorFileString());
		System.out.println("End time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		
		for (int i = 0; i < Defs.NO_OF_WARRIORS_IN_POPULATION_RANGE_END * Defs.WARRIOR_MULTIPLICATION_FACTOR; i++) {
			warriorList1.add(population.getWarriorList().get(0));
			warriorList2.add(population.getWarriorList().get(1));
			warriorList3.add(population.getWarriorList().get(2));
		}
		// Island GA P1
		System.out.println("Start time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		GeneticAlgorithmManager gmManager1 = new GeneticAlgorithmManager();
		PmarsManager pMarsManager1 = new PmarsManager();
		Population population1 = new Population();
		population1.setWarriorList(warriorList1);
		for (int j = 0; j < Defs.NUMBER_OF_GENERATIONS; j++) {
			population1 = pMarsManager1.getFitnessScore(population1);
			if (true) {
				System.out.println("Generation: " + (j + 1));
				for (Warrior warrior : population1.getWarriorList()) {
					System.out.println(warrior.getFitnessScore());
				}
			}
			population1.setWarriorList(gmManager1.selection(population.getWarriorList(), Defs.SELECTION_TYPE.RANDOM));
			population1.setWarriorList(gmManager1.crossover(population.getWarriorList(), Defs.CROSSOVER_TYPE.ONEPOINT));
			population1.setWarriorList(gmManager1.mutation(population.getWarriorList()));
		}
		Warrior warrior1 = population1.getWarriorList().get(0);
		System.out.println("Best warrior: ");
		System.out.println(population1.getWarriorList().get(0).getWarriorFileString());
		System.out.println("End time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));

		// Island GA P2
		System.out.println("Start time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		GeneticAlgorithmManager gmManager2 = new GeneticAlgorithmManager();
		PmarsManager pMarsManager2 = new PmarsManager();
		Population population2 = new Population();
		population2.setWarriorList(warriorList2);
		for (int j = 0; j < Defs.NUMBER_OF_GENERATIONS; j++) {
			population2 = pMarsManager2.getFitnessScore(population2);
			if (true) {
				System.out.println("Generation: " + (j + 1));
				for (Warrior warrior : population2.getWarriorList()) {
					System.out.println(warrior.getFitnessScore());
				}
			}
			population2.setWarriorList(gmManager2.selection(population.getWarriorList(), Defs.SELECTION_TYPE.RANDOM));
			population2.setWarriorList(gmManager2.crossover(population.getWarriorList(), Defs.CROSSOVER_TYPE.ONEPOINT));
			population2.setWarriorList(gmManager2.mutation(population.getWarriorList()));
		}
		Warrior warrior2 = population2.getWarriorList().get(0);
		System.out.println("Best warrior: ");
		System.out.println(population2.getWarriorList().get(0).getWarriorFileString());
		System.out.println("End time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));

		// Island GA P3
		System.out.println("Start time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		GeneticAlgorithmManager gmManager3 = new GeneticAlgorithmManager();
		PmarsManager pMarsManager3 = new PmarsManager();
		Population population3 = new Population();
		population3.setWarriorList(warriorList3);
		for (int j = 0; j < Defs.NUMBER_OF_GENERATIONS; j++) {
			population3 = pMarsManager3.getFitnessScore(population3);
			if (true) {
				System.out.println("Generation: " + (j + 1));
				for (Warrior warrior : population3.getWarriorList()) {
					System.out.println(warrior.getFitnessScore());
				}
			}
			population3.setWarriorList(gmManager3.selection(population.getWarriorList(), Defs.SELECTION_TYPE.RANDOM));
			population3.setWarriorList(gmManager3.crossover(population.getWarriorList(), Defs.CROSSOVER_TYPE.ONEPOINT));
			population3.setWarriorList(gmManager3.mutation(population.getWarriorList()));
		}
		Warrior warrior3 = population3.getWarriorList().get(0);
		System.out.println("Best warrior: ");
		System.out.println(population3.getWarriorList().get(0).getWarriorFileString());
		System.out.println("End time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));

		// Island GA New Population
		System.out.println("Start time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		GeneticAlgorithmManager gmManager4 = new GeneticAlgorithmManager();
		PmarsManager pMarsManager4 = new PmarsManager();
		population.getWarriorList().remove(0);
		population.getWarriorList().remove(1);
		population.getWarriorList().remove(2);
		population.getWarriorList().add(warrior1);
		population.getWarriorList().add(warrior2);
		population.getWarriorList().add(warrior3);
		for (int j = 0; j < Defs.NUMBER_OF_GENERATIONS; j++) {
			population = pMarsManager4.getFitnessScore(population);
			if (true) {
				System.out.println("Generation: " + (j + 1));
				for (Warrior warrior : population.getWarriorList()) {
					System.out.println(warrior.getFitnessScore());
				}
			}
			population.setWarriorList(gmManager4.selection(population.getWarriorList(), Defs.SELECTION_TYPE.RANDOM));
			population.setWarriorList(gmManager4.crossover(population.getWarriorList(), Defs.CROSSOVER_TYPE.ONEPOINT));
			population.setWarriorList(gmManager4.mutation(population.getWarriorList()));
		}
		System.out.println("Best warrior: ");
		System.out.println(population.getWarriorList().get(0).getWarriorFileString());
		writeWarriorToFile(population.getWarriorList().get(0));
		System.out.println("End time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
	}
}
