#!/bin/sh
docker build . -t cloudbeta/restaurant-book-service:0.1
docker push cloudbeta/restaurant-book-service:0.1