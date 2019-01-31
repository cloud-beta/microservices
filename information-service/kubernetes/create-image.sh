#!/bin/sh
docker build . -t cloudbeta/restaurant-information-service:0.1
docker push cloudbeta/restaurant-information-service:0.1