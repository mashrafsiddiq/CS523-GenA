
package geneticalgorithm;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

/**
 *
 * @author Group_T9
 * @description This class defines some utility functions which are needed to 
 * run the GA.
 */
public class Utils {

    public static Integer getRandomInteger(int startRange, int endRange) {
        return startRange + (int) (Math.random() * ((endRange - startRange) + 1));
    }

    public static Double getRandomProbability() {
        return new Random().nextDouble();
    }

    public static List<Warrior> sortWarriorsAccordingToScore(List<Warrior> warriorList) {
        System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
        Collections.sort(warriorList, new Comparator<Warrior>() {
            @Override
            public int compare(Warrior o1, Warrior o2) {
                return o1.getFitnessScore() > o2.getFitnessScore() ? -1 : 1;
            }
        });
        return warriorList;
    }

    public static void main(String[] args) {
        if (Defs.runMode == Defs.RUN_MODE.DEBUG) System.out.println(getRandomInteger(0, 10));
    }

}
