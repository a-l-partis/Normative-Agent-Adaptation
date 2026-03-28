cd scratch/code-gen/ROS/
mv -f $1_ws ../../../../

cd ../../../../$1_ws

rm -rf src/$1_interface
rm -rf src/platform

source ../mapek_ws/install/local_setup.bash

# gedit
ls
colcon build