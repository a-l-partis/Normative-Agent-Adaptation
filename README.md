# Normative-Agent-Adaptation

[//]: # (<h1> Downloading The Anonymised Repository </h1>)
[//]: # (The anonymised version of this repository may take a while to download. If the download is failing, try a different browser. We have tested it successfully using Chrome and Firefox.)

<h1>Adaptation and RoboSim conversion Executable</h1>

### Requirements ###

* Java 11

### Setup and Running ###

Download the agent-adaption.jar release from this repository. Place it in the same directory as the files you wish to use as input. To run, open the terminal, navigate to the containing directory, then run the command:

`java -jar agent-adaption.jar <Your Workflow>.workflowspec <Your SLEEC file>.sleec "<Your Output File Name>"`

The adapted workflow file will be created in the same directory under the file name &lt;YourOutputFileName&gt;.workflowspec

<h1>Adaptation, Convertor, And Analysis Code</h1>

Instructions to Install the Eclipse-Based Java 21 Version of the Planning Pipeline, Including Unit Tests and Scalability Analysis Code

### Development Platform Requirements ###

* Java 21
* Eclipse 2025-09
* Xtext SDK 2.40
* The SLEEC-TK


### Setup ###

* Download the eclipse modelling framework 2025-09 and create a workspace.

* Open eclipse marketplace and install xtext

* Clone the Normative-Agent-Adaptation repository

* Select import, select the plugins and fragments wizard, and then import all components of the Normative-Agent-Adaptation directory into the workspace

* Find the pre-existing SLEEC-TK Repository at https://github.com/UoY-RoboStar/SLEEC-TK and clone the branch fix-mvn-build:

* Delete from sleec-core/circus.robocalc.sleec.tests/src/circus/robocalc/sleec/tests/ the file CSPGenerationTest.xtend

* Open the file SLEECParsingTest.xtend, and delete all but the first test from the file. Save the file.
  
* Go to the top of the SLEEC-TK directory in terminal and do:
`mvn clean install`

* In the workspace, select import, select the plugins and fragments wizard. Choose the sleec-core directory as the directory for import, and import all components.

### Running The Adapation Pipeline ###

Find Implementation.java inside agentAdaptionCode/src/agentAdaptionCode. Run Implementation.java to run the adaptation algorithm. It is pre-set up to adapt the hospital case study. The output will be placed in the directory agentAdaptionCode/outputWorkflows. The files for this example can be found in the directory agentAdaptionCode/inputFiles/caseStudy.

If you wish to change the files used as input, add your files to the inputFiles folder. Next, navigate to the main class of Implement.java and change the first parameter of runAlgorithm to "inputFiles/&lt;Your Workflow file.workflowspec&gt;" and the second parameter to "inputfiles/&lt;Your sleec file.sleec&gt;". If you want to change the name of the output workflow file, change the third variable.

### Running Scalability Analysis and Unit Tests

AdaptionUnitTest.java in agentAdaptionCode/src/agentAdaptionCode implements the unit tests for SLEEC-ADAPT. The test files are pre-installed in the repository and will be loaded when AdaptionUnitTest is run.

Find the scalability data collector in agentAdaptionCode/src/Scalability.java. Workflow files consisting of up to 5000 tasks are included, with large sleec files included. Should you want to run with larger workflows, find the LargeWorkflowGenerator.py located in this repository under Scalability/InputGenerators. The x variable on line 135 and line 103 is used to iterate over the workflows: change the limits from 5000 to the new limit.

To run, check either ExperimentSLEECRules() or ExperimentDefeaterRules() is called in the main function of the Scalability class, and run Scalability.java. Data will be stored in scalability/csvFiles, as .csv files.

### Creating Input Files ###

To access the workflow validation tools in an Eclipse runtime interface, navigate to AgentAdaption/agent.adaption.xtext.workflow/src/agent/adaption/xtext/workflow and right click on GenerateWorkflow.mwe2. Select run as, and then run configurations. Select launch runtime eclipse, with the execution environment set to JavaSE-21 or equivalent.

Click file, new, and chose the file option. Create a file with a name that ends with .workflowspec. This will enable the workflow grammar checking functionality. You can then create new workflows aided by syntax highlighting and grammar checking.

See the documentation of your chosen SLEEC tool to access the validation functionality.


<h1>E-Commerce Chatbot</h1>

The E-Commerce Chatbot serves as a demonstration platform for the applicability and portability of the SLEEC-ADAPT component. This proof-of-concept conversational assistant enhances customer experience on online shopping platforms by dynamically adapting its workflow and decision logic based on contextual or client-specific SLEEC rules. Built with the [Rasa Open Source](https://rasa.com) framework, it demonstrates how conversational agents can modify their behaviour in real time — as instructed by SLEEC-ADAPT — to meet diverse user requirements and operational contexts.

## 🤖 Rasa Installation Guide (Linux & macOS)

This guide explains how to install [**Rasa Open Source**](https://legacy-docs-oss.rasa.com/docs/rasa/installation/environment-set-up) on **Linux** or **macOS**. It also covers common system dependencies and troubleshooting tips. 

## 📋 Prerequisites

Before you start, make sure your system has:
- **Java 11** (SLEEC-ADAPT executable requirement)
    - Installation steps:
        - ```curl -s "https://get.sdkman.io" | bash```
        - ```source "$HOME/.sdkman/bin/sdkman-init.sh"```
        - ```sdk install java 11.0.20-tem```
- **Python 3.7 - 3.10** (Rasa requirement)
    - This project has been tested and verified with Python 3.8 on Linux and Python 3.9 on macOS
- **pip** (Python package manager)
- optional: **venv** (for creating virtual environments)

Check your versions:
```
python3 --version
pip3 --version
```
## 🐧 Linux Setup

### 1️⃣ Install Python and basic tools

```
sudo apt update
sudo apt install -y python3.X python3.X-pip python3.X-venv python3.X-dev
```

where ```3.X``` refers to the python version, e.g., ```3.8``` or ```3.9```

### 2️⃣ Create and activate a virtual environment

This step is optional but highly recommended. Using a virtual environment helps isolate your project dependencies and prevents conflicts with system-wide Python packages or different Python versions.

```
python3 -m venv ./venv
source ./venv/bin/activate
```

If you have multiple python versions installed, use the one appropriate for the above command, e.g., ```python3.9 -m venv ./venv```

### 3️⃣ Install Rasa

```
pip install -U pip
pip install rasa
```

Verify the installation: 

```
rasa --version
```

You should see output like:

```
Rasa Version      :         3.6.21
Minimum Compatible Version: 3.6.21
Rasa SDK Version  :         3.6.2
Python Version    :         3.8.10
Operating System  :         Linux-5.15.0-126-generic-x86_64-with-glibc2.29
Python Path       :         /.../venv/bin/python3
```

### 4️⃣ Install build dependencies

In case of errors during the Rasa installation, install the required dependencies as prompted.

For example, some Rasa packages (e.g., confluent-kafka) need system libraries: 

```
sudo apt install -y build-essential libffi-dev libssl-dev librdkafka-dev
```

Upgrade pip, setuptools, and wheel (fixes the "invalid command 'bdist_wheel'" error):

```
pip install --upgrade pip setuptools wheel
```

Then reinstall Rasa as instructed above, and verify the installation.

## 🍎 macOS Setup

### 1️⃣ Install Homebrew (if not installed)

Follow the instructions found in this [link](https://docs.brew.sh/Installation).

### 2️⃣ Install Python

```
brew update
brew install python@3.X
```

where ```3.X``` refers to the python version, e.g., ```3.8``` or ```3.9```

### 2️⃣ Create and activate a virtual environment

This step is optional but highly recommended. Using a virtual environment helps isolate your project dependencies and prevents conflicts with system-wide Python packages or different Python versions.

```
python3 -m venv ./venv
source ./venv/bin/activate
```

If you have multiple python versions installed, use the one appropriate for the above command, e.g., ```python3.9 -m venv ./venv```

### 3️⃣ Install Rasa

```
pip install -U pip
pip install rasa
```

Verify the installation: 

```
rasa --version
```

You should see output like:

```
Rasa Version      :         3.6.21
Minimum Compatible Version: 3.6.21
Rasa SDK Version  :         3.6.2
Python Version    :         3.9.22
Operating System  :         macOS-15.5-arm64-arm-64bit
Python Path       :         /.../venv/bin/python3.9
```

### 4️⃣ Install build dependencies

As instructed in the Linux installation guide, if there are errors during the Rasa installation, install the required dependencies as prompted.

For example:

```
brew install python openssl librdkafka
pip3 install --upgrade pip setuptools wheel
```

## 🚀 Running the E-Commerce Chatbot with SLEEC-ADAPT

Once Rasa and all dependencies are installed, you can run the adaptive chatbot and interact with it as different clients.
The setup consists of two main components:
- Chatbot Server — runs the Rasa action server and manages workflow adaptation through SLEEC-ADAPT, and can be found inside the (/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/server/).
- Client Scripts — represent users with their own ```.sleec``` rule files that personalise the chatbot behaviour, and can be found inside the (/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/clients/).

### ⚙️ Environment Configuration

Before running the server or client scripts, make sure your Python virtual environment is correctly set up and activated.

By default, both the server and client scripts are configured to use a specific virtual environment path. If your environment uses a different location or if you’re not using a virtual environment
you’ll need to update or comment out those lines.

Before starting the chatbot, confirm that Rasa is available in your current shell:

```which rasa```

You should see the full path to your rasa binary, for example:

```/home/username/venv/bin/rasa```

### Check your virtual environment path

In the (./CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/server/chatbot_server.py) script, near the top, you will find: 

```RASA_BIN = "PATH TO RASA EXECUTABLE, e.g.: home/~/venv/bin/rasa"```

Update this path to match your environment. For example:

```RASA_BIN = "/home/username/venv/bin/rasa"```

Or, if you’re not using a virtual environment, you can simply comment it out and rely on your system-wide Rasa installation:

```# RASA_BIN = "PATH TO RASA EXECUTABLE, e.g.: home/~/venv/bin/rasa"```

``` RASA_BIN = "rasa"```

### Update the client scripts

Each client script (i.e., (/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/clients/client1/client_chat.sh), (/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/clients/client2/client_chat.sh), and (/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/clients/client3/client_chat.sh)) begins with:

```source "$HOME/virtualenvs/rasa_env/bin/activate"```

If your virtual environment is stored elsewhere, update the path accordingly. If you’re not using a virtual environment, comment this line out.

## 🔧 Start the Chatbot Server

Open a new terminal inside the (/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/server/) and launch the main server:

```python3 chatbot_server.py```

If there are no errors, you should see output similar to:

```
============================================================
🤖  ADAPTIVE CHATBOT SERVER INITIALIZED
============================================================
📁 Project root detected ✅
🚀 Starting Rasa action server in background...
⏳ Waiting for action server on localhost:5055... ✅ Ready.
🔄 Loading workflow
✅ Found common SLEEC rules
🧠 Workflow adapted
📡 Waiting for client conversations...
```

The server:
- Loads the base workflow and common (universal) SLEEC rules
- Generates an adapted ```active.workflowspec``` workflow
- Waits for client connections 

## 💬 Launch a Client Chat Session

Each client has its own folder inside the project (for example:
rasa_decision_support/clients/client1, client2, etc.).

To start chatting as a specific client, open a new terminal at the client's folder or navigate to that folder, e.g.: 
```cd rasa_decision_support/clients/client1```

Once inside the client's folder, run the client's script ```bash client_chat.sh```

You’ll see something like:

```
📥 Connection requested at 14:32:10

👤 Connected 'client1'
ℹ️  No SLEEC rules found for 'client1'.
```

If the client folder contains a ```.sleec``` file the chatbot server will automatically apply those rules:

```
📥 Connection requested at 14:34:25

👤 Connected 'client2'
✅ Found 'client2' SLEEC rules
🧠 Workflow adapted for 'client2'
```

#### Adaptation logic

- Client without rules → Chatbot uses the base workflow
- Client with rules → Chatbot dynamically applies the user’s ```.sleec``` rules to the workflow

**Note that before starting a new client conversation, you will need to terminate the current conversation (i.e., ``` Ctrl + C```)** 

## 🧩 Further Experimentation

By starting the chatbot server and the three client scripts, you can reproduce the baseline scenario illustrated in Figure 5 of the paper.

Beyond recreating the reference setup, users are encouraged to explore new scenarios and test the adaptability of SLEEC-ADAPT. You can add multiple ```.sleec``` rule files inside a client’s folder and observe how the chatbot’s workflow dynamically changes.

Additionally, the [```actions.py```](/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/actions/actions.py) script — located inside the [actions](/CaseStudies/Chatbot/ChatbotImplementation/rasa_decision_support/actions/) folder — defines the main functionality of the chatbot. You can modify existing behaviours (for example, changing product returns to be automatically accepted by editing line 145:
```"canReturn": False → True```) or even implement entirely new conversational actions and logic.
