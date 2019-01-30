#!/bin/sh
docker build . -t lms8147/restaurant-push-service:0.3
docker push lms8147/restaurant-push-service:0.3