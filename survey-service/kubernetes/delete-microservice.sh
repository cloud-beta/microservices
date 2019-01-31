#!/bin/sh
kubectl delete ConfigMap/db-book
kubectl delete secret/mariadb-credential-book
kubectl delete deploy/book-service
kubectl delete svc/book-service