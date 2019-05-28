#!/bin/bash

commit=$1
cd /home/ubuntu/labor
sudo $(aws ecr get-login --no-include-email --region us-east-2)

if [ ! "$(sudo docker service ls | grep labor_service)" ]
then
 echo ">>IF >>>"
 sudo docker stack deploy -c docker-service.yml labor_service
else
 echo "ELSE"
 sudo docker pull 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit
 sudo docker service update --image 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit labor_service_labor
 #sudo docker rmi $(sudo docker image ls -aq)
fi

