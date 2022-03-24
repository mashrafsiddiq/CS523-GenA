package geneticalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group_T9
 * @descrition This class defines the population to run a GA.
 */
public class Population {

    private List<Warrior> warriorList = new ArrayList<Warrior>();
    private Integer number_of_warrior = 0;

    public Population() {
        List<Warrior> warriorList = new ArrayList<Warrior>();
        Integer numberOfWarriors = Utils.getRandomInteger(
                Defs.NO_OF_WARRIORS_IN_POPULATION_RANGE_START,
                Defs.NO_OF_WARRIORS_IN_POPULATION_RANGE_END
        ) * Defs.WARRIOR_MULTIPLICATION_FACTOR;
        for (int i = 0; i < numberOfWarriors; i++) {
            Warrior currenrtwarrior = new Warrior();
            warriorList.add(currenrtwarrior);
        }
        this.setWarriorList(warriorList);
        this.setNumber_of_warrior(numberOfWarriors);
    }

    /**
     * @return the warriorList
     */
    public List<Warrior> getWarriorList() {
        return warriorList;
    }

    /**
     * @param warriorList the warriorList to set
     */
    public void setWarriorList(List<Warrior> warriorList) {
        this.warriorList = warriorList;
    }

    /**
     * @return the number_of_warrior
     */
    public Integer getNumber_of_warrior() {
        return number_of_warrior;
    }

    /**
     * @param number_of_warrior the number_of_warrior to set
     */
    public void setNumber_of_warrior(Integer number_of_warrior) {
        this.number_of_warrior = number_of_warrior;
    }

}
