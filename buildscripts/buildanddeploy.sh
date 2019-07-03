#!/bin/bash

cd ../
mvn clean package
sudo docker build -t cowsay-app .
sudo docker run -p 5000:8080 cowsay-app

