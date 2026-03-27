from setuptools import find_packages, setup
import os
from glob import glob

package_name = 'infrastructure'

setup(
    name=package_name,
    version='0.0.0',
    packages=find_packages(exclude=['test']),
    data_files=[
        ('share/ament_index/resource_index/packages',
            ['resource/' + package_name]),
        ('share/' + package_name, ['package.xml']),
        (os.path.join('share', package_name, 'launch'), glob('launch/*'))
    ],
    install_requires=['setuptools'],
    zip_safe=True,
    maintainer='ahm',
    maintainer_email='alvaro.miyazawa@york.ac.uk',
    description='TODO: Package description',
    license='Apache-2.0',
    extras_require={
        'test': [
            'pytest',
        ],
    },
    entry_points={
        'console_scripts': [
            'monitor = infrastructure.monitor:main',
            'analyser = infrastructure.analyser:main',
            'planner = infrastructure.planner:main',
            'executor = infrastructure.executor:main',
            'knowledgebase = infrastructure.knowledgebase:main'  
        ],
    },
)
