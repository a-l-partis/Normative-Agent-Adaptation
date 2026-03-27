echo 'This script execute the Adaptation Generator and produces RoboSim files in the scratch folder'
cd scratch
java -jar ../tools/robosim.jar -ros $1 ./