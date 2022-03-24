package geneticalgorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Group_T9
 * @Description: This is the definition class. In this class we set some
 *               variable values and constant values.. We also define the
 *               specific set of instructions and attributes in this class.
 */
public class Defs {

	public static enum SELECTION_TYPE {
		ROULETTE, TOURNAMENT, RANDOM
	}

	public static enum CROSSOVER_TYPE {
		UNIFORM, ONEPOINT
	}

	public static enum RUN_MODE {
		DEBUG, RELEASE
	}

	public static final RUN_MODE runMode = RUN_MODE.RELEASE;

	public static final boolean USE_ELITISM = true;
	public static final boolean USE_ISLAND = false;

	public static final Double PROBABILITY_FOR_CROSSOVER = 0.5;
	public static final Double PROBABILITY_FOR_MUTATION = 0.5;

	public static final Integer ADDRESS_RANGE_START = 0;
	public static final Integer ADDRESS_RANGE_END = 6;

	public static final Integer NO_OF_GENES_IN_WARRIOR_RANGE_START = 100;
	public static final Integer NO_OF_GENES_IN_WARRIOR_RANGE_END = 100;

	// We will eventually multiply these by a factor
	public static final Integer NO_OF_WARRIORS_IN_POPULATION_RANGE_START = 50;
	public static final Integer NO_OF_WARRIORS_IN_POPULATION_RANGE_END = 50;
	public static final Integer WARRIOR_MULTIPLICATION_FACTOR = 2;

	public static final Integer NUMBER_OF_RUNS_IN_PMARS = 100;
	public static final Integer NUMBER_OF_GENERATIONS = 20;

	public static final Integer DEFAULT_MAXLENGTH = 100;
	public static final Integer DEFAULT_CORESIZE = 8000;

	public static final String AUTHOR_NAME = "GROUP_T9";

	public static final Map<Integer, String> instructionSet;
	public static final Map<Integer, Character> addressModifierSet;
	public static final List<String> benchmarkWarriorList = new ArrayList<>();
	public static final String WARRIOR_FILE_NAME = "MY_WARRIOR.RED";
	public static final String CURRENT_WARRIOR_NAME = "CURRENT_WARRIOR_NAME";

	static {
		instructionSet = new HashMap<Integer, String>();
		instructionSet.put(0, "MOV");
		instructionSet.put(1, "DAT");
		instructionSet.put(2, "SPL");
		instructionSet.put(3, "ADD");
		instructionSet.put(4, "SUB");
		instructionSet.put(5, "MUL");
		instructionSet.put(6, "DIV");
		instructionSet.put(7, "MOD");
		instructionSet.put(8, "JMP");
		instructionSet.put(9, "JMZ");
		instructionSet.put(10, "JMN");
		instructionSet.put(11, "DJN");
		instructionSet.put(12, "CMP");
		instructionSet.put(13, "SNE");
		instructionSet.put(14, "SLT");
		instructionSet.put(15, "LDP");
		instructionSet.put(16, "STP");
		instructionSet.put(17, "NOP");
		instructionSet.put(18, "SEQ");

		addressModifierSet = new HashMap<Integer, Character>();
		addressModifierSet.put(0, ' ');
		addressModifierSet.put(1, '@');
		addressModifierSet.put(2, '#');
		addressModifierSet.put(3, '$');
		addressModifierSet.put(4, '<');
		addressModifierSet.put(5, '*');
		addressModifierSet.put(6, '}');
		addressModifierSet.put(7, '{');

		benchmarkWarriorList.add("BLUEFUNK.RED");
		benchmarkWarriorList.add("CANNON.RED");
		benchmarkWarriorList.add("FSTORM.RED");
		benchmarkWarriorList.add("IRONGATE.RED");
		benchmarkWarriorList.add("MARCIA13.RED");
		benchmarkWarriorList.add("NOBODY.RED");
		benchmarkWarriorList.add("PAPERONE.RED");
		benchmarkWarriorList.add("PSWING.RED");
		benchmarkWarriorList.add("RAVE.RED");
		benchmarkWarriorList.add("THERMITE.RED");
		benchmarkWarriorList.add("TIME.RED");
		benchmarkWarriorList.add("TORNADO.RED");
	}
}
