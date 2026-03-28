rm -rf db.json
rm -rf scratch
rm -rf ../hosppatient1_ws

mkdir scratch

source /opt/ros/jazzy/setup.bash

export PYTHONPATH=../venv/lib/python3.12/site-packages/:$PYTHONPATH

cd ../mapek_ws
colcon build
source install/local_setup.bash

ros2 launch infrastructure mapek_launch.py