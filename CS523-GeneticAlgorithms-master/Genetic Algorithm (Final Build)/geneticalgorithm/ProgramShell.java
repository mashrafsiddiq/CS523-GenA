package geneticalgorithm;

/**
 * 
 * @author Group_T9
 * @description This class run the GA according to the specifications
 * indicated in the Defs.java class.
 */

public class ProgramShell {

	public static boolean island = false;
	public static boolean elitism = false;

	public static void main(String[] args) {
		island = Defs.USE_ISLAND;
		elitism = Defs.USE_ELITISM;
		if (island == false) {
			if (elitism == false) {
				System.out.println("Using Non-Elitism GA");
			} else if (elitism == true) {
				System.out.println("Using Elitism GA");
			}
			System.out.println("Beginning GA");
			GeneticAlgorithm.main();

		} else if (island == true) {
			if (elitism == false) {
				System.out.println("Using Island GA with Non-Elitism");
			} else if (elitism == true) {
				System.out.println("Using Island GA with Elitism");
			}
			System.out.println("Beginning Island GA");
			IslandGA.main();
		}
	}
}
