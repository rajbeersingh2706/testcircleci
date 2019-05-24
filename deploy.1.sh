#!/bin/bash

HOME_DIR=/home/ubuntu/u01/labor
cd $HOME_DIR/app/

file_ext=`date +'%d-%m-%Y-%H-%M-%S'`
source_file=$HOME_DIR/app/salido-labor.jar
dest_file=$HOME_DIR/backup/salido-labor-$file_ext.jar
cp $source_file $dest_file

sudo docker build -t "labor" .
sudo docker stop $(sudo docker ps -a -q)
sudo docker rm $(sudo docker ps -a -q)
#sudo docker run -it -d -p 443:443 labor 
#sudo pkill -9 java
#cd /home/ubuntu/u01/labor/app
#sudo nohup java -Djava.security.egd=file:/dev/./urandom -jar -Dspring.profiles.active=prod /home/ubuntu/u01/labor/app/salido-labor.jar