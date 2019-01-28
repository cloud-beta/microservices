#!/bin/sh
kubectl create -f ./yaml/configmap-survey-push.yaml
kubectl create -f ./yaml/cronjob-surveypush.yaml