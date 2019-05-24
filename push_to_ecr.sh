#!/bin/bash

commit=$(git rev-parse --short HEAD)
echo $commit
ls -la 
cp target/salido-labor-1.0.0.jar salido-labor.jar

# Install the AWS 
curl "https://s3.amazonaws.com/aws-cli/awscli-bundle.zip" -o "awscli-bundle.zip"
unzip awscli-bundle.zip
sudo ./awscli-bundle/install -i /usr/local/aws -b /usr/local/bin/aws

# Configure AWS CLI
aws s3 ls
aws configure set aws_access_key_id $AWS_ACCESS_KEY_ID
aws configure set aws_secret_access_key $AWS_SECRET_ACCESS_KEY
aws configure set default.region $AWS_REGION

# Login to ECR
$(aws ecr get-login --no-include-email --region us-east-2)

docker build -t 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:latest -t 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit .
docker push 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:latest
docker push 873930443481.dkr.ecr.us-east-2.amazonaws.com/labor-repo:$commit
