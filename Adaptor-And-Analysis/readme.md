<h1>SLEEC-ADAPT</h1>
### Instructions to Install the Eclipse-Based Version of SLEEC-ADAPT

### Development platform requirements ###

* Java 21
* Eclipse 2025-09
* Xtext SDK 2.40
* The SLEEC-TK


### Setup ###

* Download eclipse 2025-09 and create a workspace.

* Open eclipse marketplace and install xtext

* Clone the AgentAdaption repository

* Select import, select the plugins and fragments wizard, and then import all components of this repository into the workspace

* Find the pre-existing SLEEC-TK Repository at https://github.com/UoY-RoboStar/SLEEC-TK and clone the branch fix-mvn-build

* Delete from sleec-core/circus.robocalc.sleec.tests/src/circus/robocalc/sleec/tests/ the file CSPGenerationTest.xtend

* Open the file SLEECParsingTest.xtend, and delete all but the first test from the file. Save the file.
  
* Go to the top of the SLEEC-TK directory in terminal and do:
`mvn clean install`

* In the workspace, select import, select the plugins and fragments wizard. Choose the sleec-core directory as the directory for import, and import all components.

### Running SLEEC-ADAPT ###

Find Implementation.java inside agentAdaptionCode/src/agentAdaptionCode. Run Implementation.java to run the SLEEC-ADAPT algorithm. It is pre-set up to run the Chatbot case study with universal sleec rules. The output will be placed in the directory agentAdaptionCode/outputWorkflows. The files for this example, and all case study examples can be found in the directory agentAdaptionCode/inputFiles/caseStudy.

If you wish to change the files used as input, add your files to the inputFiles folder. Next, navigate to the main class of Implement.java and change the first parameter of runAlgorithm to "inputFiles/&lt;Your Workflow file.workflowspec&gt;" and the second parameter to "inputfiles/&lt;Your sleec file.sleec&gt;". If you want to change the name of the output workflow file, change the third variable.

### Running Scalability Analysis and Unit Tests

### Creating Input Files ###

<h1>E-Commerce Chatbot</h1>


