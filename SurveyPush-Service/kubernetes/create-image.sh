#!/bin/sh
docker build . -t cloudbeta/restaurant-survey-push-service:0.1
docker push cloudbeta/restaurant-survey-push-service:0.1