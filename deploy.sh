#!/bin/bash

commit=$(git rev-parse --short HEAD)
echo $commit
ls -la 
cp target/salido-labor-1.0.0.jar salido-labor.jar
# Login to ECR
$(aws ecr get-login --no-include-email --region eu-east-2)

docker build -t 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:latest -t 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit .
docker push 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:latest
docker push 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit
