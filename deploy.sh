#!/bin/bash

sudo docker stop $(sudo docker ps -aq)
sudo docker rm $(sudo docker ps -aq)
sudo docker rmi $(sudo docker image ls -aq)
sudo docker pull 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:latest 
#sudo docker run -it -d -p 443:443 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit 
