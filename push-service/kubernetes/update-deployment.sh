#!/bin/sh
kubectl replace -f yaml/deploy-push.yaml
kubectl rollout status deploy/push-service