cd scratch/code-gen/ROS/
rm -rf ../../../../$1_ws

mv -f $1_ws ../../../../ -v

cd ../../../../$1_ws

pwd

rm -rf ./src/$1_interface -v
rm -rf ./src/platform -v

source ../mapek_ws/install/local_setup.bash

# gedit
ls
colcon build