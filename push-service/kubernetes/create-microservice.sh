#!/bin/sh
. secret-db.sh
kubectl create -f ./yaml/configmap-mariadb.yaml
kubectl create -f ./yaml/deploy-push.yaml
kubectl create -f ./yaml/svc-push.yaml