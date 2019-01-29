#!/bin/sh
. secret-db.sh
kubectl create -f ./yaml/configmap-mariadb.yaml
kubectl create -f ./yaml/deploy-information.yaml
kubectl create -f ./yaml/svc-information.yaml