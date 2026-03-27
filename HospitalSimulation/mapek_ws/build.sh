rm -rf db.json
rm -rf scratch
rm -rf ../hosppatient1_ws

mkdir scratch

source /opt/ros/jazzy/setup.sh

export PYTHONPATH=../venv/lib/python3.12/site-packages/:$PYTHONPATH

cd ../mapek_ws
colcon build
source install/setup.sh

ros2 launch infrastructure mapek_launch.py