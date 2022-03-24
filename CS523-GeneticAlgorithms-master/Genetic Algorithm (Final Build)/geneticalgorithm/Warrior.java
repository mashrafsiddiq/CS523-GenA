package geneticalgorithm;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Group_T9
 * @description This class defines a single warrior in a population
 * 
 */
public class Warrior {

    private List<Gene> geneList = new ArrayList<Gene>();
    private Integer numberOfGenes;
    private Integer fitnessScore = 0;
    private Double fitnessRatio = 0.0;

    public Warrior() {
        this.numberOfGenes = Utils.getRandomInteger(Defs.NO_OF_GENES_IN_WARRIOR_RANGE_START, Defs.NO_OF_GENES_IN_WARRIOR_RANGE_END);
        for (int i = 0; i < this.numberOfGenes; i++) {
            this.geneList.add(new Gene());
        }
        this.fitnessScore = 0;
        this.fitnessRatio = 0.0;
    }

    public Warrior(List<Gene> geneList) {
        List<Gene> newGeneList = new ArrayList<Gene>();
        for (Gene gene : geneList) {
            Gene newGene = new Gene();
            newGene.setInstruction(gene.getInstruction());
            newGene.setNumberOfParams(gene.getNumberOfParams());
            newGene.setParam1(gene.getParam1());
            newGene.setParam2(gene.getParam2());
            newGene.setAddressModifier1(gene.getAddressModifier1());
            newGene.setAddressModifier2(gene.getAddressModifier2());
            newGeneList.add(newGene);
        }
        this.geneList = newGeneList;
        this.fitnessScore = 0;
        this.fitnessRatio = 0.0;
        this.numberOfGenes = newGeneList.size();
    }

    /**
     * @return the genelist
     */
    public List<Gene> getGenelist() {
        return geneList;
    }

    /**
     * @param genelist the genelist to set
     */
    public void setGenelist(List<Gene> genelist) {
        this.geneList = genelist;
    }

    /**
     * @return the numberOfGenes
     */
    public Integer getNumberOfGenes() {
        return numberOfGenes;
    }

    /**
     * @param numberOfGenes the numberOfGenes to set
     */
    public void setNumberOfGenes(Integer numberOfGenes) {
        this.numberOfGenes = numberOfGenes;
    }

    /**
     * @return the fitnessScore
     */
    public Integer getFitnessScore() {
        return fitnessScore;
    }

    /**
     * @param fitnessScore the fitnessScore to set
     */
    public void setFitnessScore(Integer fitnessScore) {
        this.fitnessScore = fitnessScore;
    }

    /**
     * @return the fitnessRatio
     */
    public Double getFitnessRatio() {
        return fitnessRatio;
    }

    /**
     * @param fitnessRatio the fitnessRatio to set
     */
    public void setFitnessRatio(Double fitnessRatio) {
        this.fitnessRatio = fitnessRatio;
    }

    public String getWarriorFileString() {
        String warriorFileString = "";
        warriorFileString += "; redcode";
        warriorFileString += "\n; name :  " + Defs.CURRENT_WARRIOR_NAME;
        warriorFileString += "\n; author :  " + Defs.AUTHOR_NAME;
        warriorFileString += "\n; assert    CORESIZE == " + Defs.DEFAULT_CORESIZE + " && MAXLENGTH >= " + Defs.DEFAULT_MAXLENGTH;
        for (Gene gene : this.geneList) {
            warriorFileString += "\n" + gene.convertToString();
        }
        warriorFileString += "\nend ;  execution  ends  here";
        return warriorFileString;
    }

    public String convertToString() {
        String warriorFileString = "";
//        warriorFileString += "\n; author :  " + Defs.AUTHOR_NAME;
//        warriorFileString += "\n; assert    CORESIZE == " + Defs.DEFAULT_CORESIZE + " && MAXLENGTH >= " + Defs.DEFAULT_MAXLENGTH;
        for (Gene gene : this.geneList) {
            warriorFileString += "\n" + gene.convertToString();
        }
//        warriorFileString += "\nend ;  execution  ends  here";
        return warriorFileString;
    }

}
