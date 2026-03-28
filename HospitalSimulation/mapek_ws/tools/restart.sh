cd ../$1_ws
echo ${pwd}

source install/local_setup.bash
source ../mapek_ws/install/local_setup.bash
ros2 run $1 wfSTM
