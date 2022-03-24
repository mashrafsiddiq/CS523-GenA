package geneticalgorithm;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Group_T9
 * @description This class defines the entry point of the code It calls all
 *              necessary functions to generate best warrior using GA.
 */
public class GeneticAlgorithm {

	/**
	 * @param args
	 *            the command line arguments
	 */

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
		System.out.println("Start time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));
		GeneticAlgorithmManager gmManager = new GeneticAlgorithmManager();
		PmarsManager pMarsManager = new PmarsManager();
		Population population = new Population();
		for (int i = 0; i < Defs.NUMBER_OF_GENERATIONS; i++) {
			population = pMarsManager.getFitnessScore(population);
			if (true) {
				System.out.println("Generation: " + (i + 1));
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
		writeWarriorToFile(population.getWarriorList().get(0));
		System.out.println("End time: " + new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(new Date()));

	}
}
