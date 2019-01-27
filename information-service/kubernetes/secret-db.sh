#!/bin/sh
echo -n "root" > ./username
echo -n "It12345!1" > ./password
kubectl create secret generic mariadb-credential-information --from-file=./username --from-file=./password
rm -rf ./username ./password
kubectl get secret/mariadb-credential-information -o yaml