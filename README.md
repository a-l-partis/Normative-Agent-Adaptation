<h1>Adaptation and RoboSim Conversion Executable </h1>

### Requirements ###

* Java 11

### Setup and Running ###

The agent-adaption.jar provides the workflow adaptation and robosim model generation functionality. To use, download the release from this repository. Place it in the same directory as the files you wish to use as input. To run, open the terminal, navigate to the containing directory, then run the command:

`java -jar agent-adaption.jar <Your Workflow>.workflowspec <Your SLEEC file>.sleec "<Your Output File Name>"`

The adapted workflow file will be created in the same directory under the file name &lt;YourOutputFileName&gt;.workflowspec

<h1>MAPE-K and the Turtlebot Simulation</h1>

Our reusable instantiation of the MAPE-K architecture is located in the HospitalSimulation folder, alongside the turtlebot simulation of the Hospital Robot example . A video shows deployment of the MAPE-K adaptation process that detects the UserID of the patient from the paper and deploys the MAPE-K loop to produce code that interfaces with platform RP to run the adapted workflow.

Platform Mappings:

AssessRoom – Undock and rotate

DustFurniture - solidly lit green LED1

CleanFloor - Rotate

DisplayCleaningPlan - LED2 green blinking

NotifyPatient - Blinking LED2 red

SetSilentFloorCleaning - LED2 solidly lit green

set floorNeedsCleaning - button 1

set personResting - button 2

The reusable MAPE-K implementation can be found at HospitalSimulation/mapek_ws/src/infrastructure/infrastructure.


### Development Platform Requirements ###

* ROS2 Jazzy
* Gazebo Harmonic
* Turtlebot4 packages
* Python package: empy, catkin_pkg, lark, numpy, tinydb


### Simulation Setup ###

Once the environment is set up with the above requirements, the components can be run via vscode terminals. In order to interface with the turtlebot 4 implementation, you must source your ROS implementation in all terminals that you plan to use:

```
source /opt/ros/jazzy/setup.bash
```
(Your ROS installation my vary)

You must also source the implementation of the platform in all terminals:
```
source install/setup.bash
```

To install gazebo and launch the turtlebot:

```
ros2 launch turtlebot4_gz_bringup turtlebot4_gz.launch.py
```
Once the turtlebot is set up in gazebo, you can launch the MAPE-K loop with 

```
./build.sh
```

And trigger the adaptation, code generation and deployment (to Patient1's rules) like this:

```
./test.sh
```

Once the MAPE-K cycle has run, the simulation of the turtlebot executing the generated code will proceed.


<h1>Adaptor And Analysis Code</h1>

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

The E-Commerce Chatbot serves as a demonstration platform for the applicability and portability of the SLEEC-ADAPT component. This proof-of-concept conversational assistant enhances customer experience on online shopping platforms by dynamically adapting its workflow based on contextual and client-specific profiles. Built with the [Rasa Open Source](https://rasa.com) framework, the chatbot receives an active workflow at runtime from the MAPE-K loop, which generates and updates the workflow to guide client interactions.

## 🎥 Demonstration Video

A demonstration video showcasing the chatbot interaction and the MAPE-K-driven adaptation process is available in the [Chatbot](Chatbot/) folder.

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
pip install rasa rasa-sdk
pip install tinydb
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

### 3️⃣ Create and activate a virtual environment

This step is optional but highly recommended. Using a virtual environment helps isolate your project dependencies and prevents conflicts with system-wide Python packages or different Python versions.

```
python3 -m venv ./venv
source ./venv/bin/activate
```

If you have multiple python versions installed, use the one appropriate for the above command, e.g., ```python3.9 -m venv ./venv```

###  Install Rasa

```
pip install -U pip
pip install rasa rasa-sdk
pip install tinydb
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

## 🚀 Running the E-Commerce Chatbot

Once Rasa and all dependencies are installed, you can run the adaptive chatbot and interact with it as different clients.
The setup consists of three main components:
- Chatbot Server — runs the Rasa action server, handles client connections, and executes the currently active workflow. It can be found in [server](/Chatbot/server/).
- MAPE-K Loop - is responsible for all adaptation. It monitors user profiles, analyses whether adaptation is required, generates updated workflows, and writes them to the active workflow (```active.workflowspec```) used by the chatbot.
- Client Scripts - represent users with different profiles (defined via ```.json``` files) that trigger the MAPE-K loop to adapt the chatbot behaviour. These can be found in [clients](/Chatbot/clients/).

### ⚙️ Environment Configuration

Before running the server or client scripts, make sure your Python virtual environment is correctly set up and activated.

By default, both the server and client scripts are configured to use a specific virtual environment path. If your environment uses a different location or if you’re not using a virtual environment
you’ll need to update or comment out those lines.

Before starting the chatbot, confirm that Rasa is available in your current shell:

```which rasa```

You should see the full path to your rasa binary, for example:

```/home/username/venv/bin/rasa```

### Check your virtual environment path

In the (/Chatbot/server/chatbot_server.py) script, near the top, you will find: 

```RASA_BIN = os.path.expanduser("~/virtualenvs/rasa_env/bin/rasa")```

Update this path to match your environment. For example:

```RASA_BIN = os.path.expanduser("/home/username/venv/bin/rasa")"```

Or, if you’re not using a virtual environment, you can rely on your system-wide Rasa installation.

For example, ``` RASA_BIN = "rasa"```.

Below the ```RASA_BIN``` path you will find the ```PYTHON_BIN``` path:

```PYTHON_BIN = os.path.expanduser("~/virtualenvs/rasa_env/bin/python3")```

Again, update this path to match your environment. For example: 

```PYTHON_BIN = os.path.expanduser("~/home/username/venv/bin/python3")```

Or, if you’re not using a virtual environment, you can rely on your system-wide Python installation.

```PYTHON_BIN = "python3"``` 

### Update the client scripts

Each client script (i.e. /Chatbot/clients/client1/client_chat.sh, /Chatbot/clients/client2/client_chat.sh, and /Chatbot/clients/client3/client_chat.sh) optionally tries to activate a virtual environment using:

    VENV_PATH="$HOME/virtualenvs/rasa_env"

    if [ -f "$VENV_PATH/bin/activate" ]; then
    source "$VENV_PATH/bin/activate"
    else
    echo "⚠️  Virtualenv not found at $VENV_PATH"
    echo "⚠️  Proceeding with system Python/Rasa..."
    fi

If your virtual environment is stored elsewhere, update the ```VENV_PATH``` variable accordingly.

If you are not using a virtual environment, no change is required, as the script will automatically fall back to the system installation of Python/Rasa. In that case, make sure that rasa is available on your PATH.

## 🔧 Start the Chatbot Server

Open a new terminal inside the (/Chatbot/server/) and launch the main server:

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
📡 Waiting for client conversations...
```

The server:
- Loads and executes the current active workflow (```active.workflowspec```)
- Handles client connections and forwards user input to the chatbot
- Relies on the MAPE-K loop to update the workflow at runtime

## 💬 Launch a Client Chat Session

Each client has its own folder inside the project (for example:
/clients/client1, client2, etc.).

To start chatting as a specific client, open a new terminal at the client's folder or navigate to that folder, e.g.: 

```cd /clients/client1```

Once inside the client's folder, run the client's script ```bash client_chat.sh```

On the server window you’ll see something like:

```
📥 Connection requested at 14:32:10
👤 Connected 'client1'
```

Each client has an associated ```.json``` file that defines their profile. In this demo, we consider three different profiles: the default user (```-.json```), an anxious user (```AnxiousUser.json```), and a first-time user (```FirstTimeUser.json```).

For the default user, the base workflow is used. For all other profiles, the MAPE-K loop dynamically generates an adapted workflow based on user-specific rules, which is then executed by the chatbot.

**Note that before starting a new client conversation, you will need to terminate the current conversation (i.e., ``` Ctrl + C```)** 

## 🔄 MAPE-K Adaptation Loop

The adaptation logic is handled by a separate MAPE-K (Monitor–Analyse–Plan–Execute–Knowledge) loop.

The MAPE-K loop:
- Monitors client connections and user context
- Analyses whether adaptation is required based on user-specific profiles
- Generates a new workflow when needed
- Updates the active workflow (```active.workflowspec```) used by the chatbot

If running the MAPE-K loop manually is of interest, this can be done by commenting out the following lines in ```chatbot_server.py```:

    subprocess.Popen(
        [PYTHON_BIN, str(mapek_setup)],
        stdout=subprocess.DEVNULL,
        stderr=subprocess.DEVNULL,
        cwd=mapek_dir,
    )

Then, after starting the server, open a separate terminal window, navigate to the MAPE-K folder, and run:

```python3 MAPE-K_setup.py``` 

If you are using a virtual environment, make sure it is activated before running the command.