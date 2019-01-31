#!/bin/sh
kubectl replace -f yaml/deploy-book.yaml
kubectl rollout status deploy/book-service