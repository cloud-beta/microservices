#!/bin/sh
. secret-db.sh
kubectl create -f ./yaml/configmap-mariadb.yaml
kubectl create -f ./yaml/deploy-book.yaml
kubectl create -f ./yaml/svc-book.yaml