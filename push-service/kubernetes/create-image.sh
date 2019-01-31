#!/bin/sh
docker build . -t cloudbeta/restaurant-push-service:0.1
docker push cloudbeta/restaurant-push-service:0.1