#!/bin/bash

commit=$1
echo "Here>> in Circle CI",$commit

#sudo docker stop $(sudo docker ps -aq)
#sudo docker rm $(sudo docker ps -aq)
#docker kill $(docker ps -aq)
#sudo docker rmi $(sudo docker image ls -aq)
#sudo $(aws ecr get-login --no-include-email --region us-east-2)
#sudo docker pull 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:latest 
#sudo docker run -it -d -p 443:443 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit
cd /home/ubuntu/labor

#sudo docker stack deploy -c docker-service.yml labor_service
sudo docker pull 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit
sudo docker service update --image 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit labor_service_labor
sudo docker rmi $(sudo docker image ls -aq)
