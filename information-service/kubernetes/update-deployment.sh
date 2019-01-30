#!/bin/sh
kubectl replace -f yaml/deploy-information.yaml
kubectl rollout status deploy/information-service