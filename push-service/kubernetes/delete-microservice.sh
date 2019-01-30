#!/bin/sh
kubectl delete ConfigMap/db-push
kubectl delete secret/mariadb-credential-push
kubectl delete deploy/push-service
kubectl delete svc/push-service