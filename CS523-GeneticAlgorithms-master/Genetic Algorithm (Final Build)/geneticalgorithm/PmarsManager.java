package geneticalgorithm;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Group_T9
 * @description This class defines the functions which call the pMars
 * to generate the fitness function.
 */
public class PmarsManager {

    String getPmarsCommand() {
        String command = "";
        command += "./pmars";
        command += " -r ";
        command += Defs.NUMBER_OF_RUNS_IN_PMARS.toString();
        for (int i = 0; i < Defs.benchmarkWarriorList.size(); i++) {
            command += " " + Defs.benchmarkWarriorList.get(i);
        }
        command += " " + Defs.WARRIOR_FILE_NAME;
        System.out.println(command);
        return command;
    }

//    void writeWarriorsToFile(List<Warrior> warriorList) {
//        int i = 1;
//        for (Warrior warrior : warriorList) {
//            String warriorString = warrior.getWarriorFileString("warrior_" + Integer.toString(i));
//            String fileName = "warrior_" + Integer.toString(i) + ".red";
//            try (PrintWriter out = new PrintWriter(fileName)) {
//                out.println(warriorString);
//                out.close();
//            } catch (FileNotFoundException ex) {
//                ex.printStackTrace();
//            } finally {
//                i++;
//            }
//        }
//    }
    void writeWarriorToFile(Warrior warrior) {
        String warriorString = warrior.getWarriorFileString();
        try (PrintWriter out = new PrintWriter(Defs.WARRIOR_FILE_NAME)) {
            out.println(warriorString);
            out.close();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    public Population getFitnessScore(Population population) {

        String pMarsCommand = getPmarsCommand();
        String outputString;
        String errorString;
        String resultString = "";
        BufferedReader stdInput = null;
        BufferedReader stdError = null;

        int i = 0;
        for (Warrior warrior : population.getWarriorList()) {
            System.out.print("Running for warrior: " + ++i + "  ");
            writeWarriorToFile(warrior);
            try {
                Process process = Runtime.getRuntime().exec(pMarsCommand);
                stdInput = new BufferedReader(new InputStreamReader(process.getInputStream()));
                stdError = new BufferedReader(new InputStreamReader(process.getErrorStream()));

                if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
                    System.out.println("Here is the standard output of the command:\n");
                }
                while ((outputString = stdInput.readLine()) != null) {
                    resultString += "\n" + outputString;
                    if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
                        System.out.println(outputString);
                    }
                }

                if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
                    System.out.println("Here is the standard error of the command:\n");
                }
                while ((errorString = stdError.readLine()) != null) {
                    if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
                        System.out.println(errorString);
                    }
                }
                process.waitFor();
                warrior.setFitnessScore(parseResult(resultString));
                System.out.println("Score of this warrior: " + warrior.getFitnessScore());
                stdInput.close();
                stdError.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
        population.setWarriorList(Utils.sortWarriorsAccordingToScore(population.getWarriorList()));
        return population;
    }

    int parseResult(String resultString) {

        int result = 0;
        String[] lines = resultString.split("Results:");
        for (String line : lines) {
            if (line.contains("scores") && line.contains(Defs.CURRENT_WARRIOR_NAME)) {
                //System.out.println(line);
                String[] splitLines = line.split("scores ");
                String[] scoreStr = splitLines[1].split("\n");
                result = Integer.parseInt(scoreStr[0]);
            }
        }
        return result;
    }

//    Population parseResult(String resultString, Population population) {
//
//        if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
//            System.out.println("Parsing starts: ");
//        }
//        String[] lines = resultString.split("Results:");
//        int i = 0;
//        List<Integer> scoreList = new ArrayList<Integer>();
//        for (String line : lines) {
//            if (line.contains("scores")) {
//                String[] splitLines = line.split("scores ");
//                if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
//                    System.out.println("Warrior" + i + " scores " + splitLines[1]);
//                }
//                String[] scoreStr = splitLines[1].split("\n");
//                scoreList.add(Integer.parseInt(scoreStr[0]));
//                population.getWarriorList().get(i).setFitnessScore(Integer.parseInt(scoreStr[0]));
//                i++;
//            }
//        }
//        if (Defs.runMode == Defs.RUN_MODE.DEBUG) {
//            System.out.println("");
//        }
//        return population;
//    }
//    public static void main(String[] args) {
//        Population population = new Population();
//        getFitnessScore(population);
//    }
}
