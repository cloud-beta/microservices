#!/bin/sh
kubectl delete ConfigMap/db-information
kubectl delete secret/mariadb-credential-information
kubectl delete deploy/information-service
kubectl delete svc/information-service