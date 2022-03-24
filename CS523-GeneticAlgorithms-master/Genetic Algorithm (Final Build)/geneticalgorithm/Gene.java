package geneticalgorithm;

/**
 *
 * @author Group_T9
 * @Description: The Gene class represents single statement in a warrior. The
 * Gene class represents single statement in a warrior.
 */
public class Gene {

    private String instruction;
    private Integer numberOfParams;
    private Integer param1;
    private Character addressModifier1;
    private Integer param2;
    private Character addressModifier2;

    public Gene() {
        this.instruction = Defs.instructionSet.get(Utils.getRandomInteger(0, Defs.instructionSet.size() - 1));
        this.numberOfParams = 2; //For now: hardcoded
        param1 = Utils.getRandomInteger(Defs.ADDRESS_RANGE_START, Defs.ADDRESS_RANGE_END);
        param2 = Utils.getRandomInteger(param1 + 1, Defs.ADDRESS_RANGE_END + 1);
        this.addressModifier1 = Defs.addressModifierSet.get(Utils.getRandomInteger(0, Defs.addressModifierSet.size() - 1));
        this.addressModifier2 = Defs.addressModifierSet.get(Utils.getRandomInteger(0, Defs.addressModifierSet.size() - 1));
    }

    public Gene(String instruction, int numberOfParams, int param1, int param2, char am1, char am2) {
        this.instruction = instruction.toString();
        this.numberOfParams = numberOfParams;
        this.param1 = param1;
        this.param2 = param2;
        this.addressModifier1 = am1;
        this.addressModifier2 = am2;
    }

    /**
     * @return the instruction
     */
    public String getInstruction() {
        return instruction;
    }

    /**
     * @param instruction the instruction to set
     */
    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    /**
     * @return the numberOfParams
     */
    public Integer getNumberOfParams() {
        return numberOfParams;
    }

    /**
     * @param numberOfParams the numberOfParams to set
     */
    public void setNumberOfParams(Integer numberOfParams) {
        this.numberOfParams = numberOfParams;
    }

    /**
     * @return the param1
     */
    public Integer getParam1() {
        return param1;
    }

    /**
     * @param param1 the param1 to set
     */
    public void setParam1(Integer param1) {
        this.param1 = param1;
    }

    /**
     * @return the param2
     */
    public Integer getParam2() {
        return param2;
    }

    /**
     * @param param2 the param2 to set
     */
    public void setParam2(Integer param2) {
        this.param2 = param2;
    }

    public String convertToString() {
        String returnStr = this.instruction;
        if (this.numberOfParams > 0) {
            returnStr += " " + this.addressModifier1.charValue() + this.param1.toString();
        }
        if (this.numberOfParams > 1) {
            returnStr += ", " + this.addressModifier2.charValue() + this.param2.toString();
        }
        return returnStr;
    }

    /**
     * @return the addressModifier1
     */
    public Character getAddressModifier1() {
        return addressModifier1;
    }

    /**
     * @param addressModifier1 the addressModifier1 to set
     */
    public void setAddressModifier1(Character addressModifier1) {
        this.addressModifier1 = addressModifier1;
    }

    /**
     * @return the addressModifier2
     */
    public Character getAddressModifier2() {
        return addressModifier2;
    }

    /**
     * @param addressModifier2 the addressModifier2 to set
     */
    public void setAddressModifier2(Character addressModifier2) {
        this.addressModifier2 = addressModifier2;
    }

}
