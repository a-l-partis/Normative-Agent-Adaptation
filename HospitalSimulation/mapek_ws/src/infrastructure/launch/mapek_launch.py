import launch
import launch_ros.actions


def generate_launch_description():
    return launch.LaunchDescription([
        launch_ros.actions.Node(
            package='infrastructure',
            executable='knowledgebase',
            name='knowledgebase'),
        launch_ros.actions.Node(
            package='infrastructure',
            executable='monitor',
            name='monitor'),
        launch_ros.actions.Node(
            package='infrastructure',
            executable='analyser',
            name='analyser'),
        launch_ros.actions.Node(
            package='infrastructure',
            executable='planner',
            name='planner'),
        launch_ros.actions.Node(
            package='infrastructure',
            executable='executor',
            name='executor'),
        # launch_ros.actions.Node(
        #     package='platform',
        #     executable='RP',
        #     name='RP'),
    ])