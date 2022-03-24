CS523-GeneticAlgorithms

You will find the final build of our GA in the folder "Genetic Algorithm (Final Build). 

All Matlab code can be found in the folder "Matlab Code for Graphs". To generate plots, you will need to open the files in Matlab.

If you would like to see some of our results while running the GA, you will find those .txt files in the folder titled "Test Results."

To run the GA, you will need to change your directory to "Genetic Algorithm (Final Build)" and javac the package "geneticalgorithm."
Running the program while in the directory "Genetic Algorithm (Final Build)" allows the GA to call on pmars and the benchmark
warriors. Do note that you will need to change your permission to use pmars (using the command 'chmod +x pmars') before running
the program.

When varying initial conditions of the GA (i.e. selection operators, crossover operators, crossover rates, and mutation rates)
you will need to change those values in "Defs.java". You can also turn on or off Elitism and Island GA in "Defs.java".

Once all variables are changed to your specifications, you will need to compile both the "Defs.java" and "ProgramShell.java" files.

You can run the program using the following command-line input "nohup nice -n 10 java geneticalgorithm.ProgramShell > GA_RUN.log 2>&1"
to log the fitness scores of your warriors at each generation and see the Redcode instructions for the best warrior generated during 
the run. This information will be collected in the file GA_RUN.log in the "Genetic Algorithm (Final Build) folder.

Once the program is completed, you will find a .red file that contains the Redcode instructions of the best warrior from your completed
run. This file can also be found in the "Genetic Algorithm (Final Build)" folder.

Minimum Requirements: 

-Population of at least                               
 10 warriors. 
                                                     
-To run the GA with Non-Elitism, 
 you must choose "Random" as the                     
 selection operator.
 
-Pmars and Benchmark warriors must
 be in the same directory as the package
 "geneticalgorithm."
 -------------------------------------------------------------------------------------------------

Recommended:

-Population of 100 warriors.

-100 genes in each warrior's genome.

-20 generations.
