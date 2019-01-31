#!/bin/sh
echo -n "root" > ./username
echo -n "It12345!1" > ./password
kubectl create secret generic mariadb-credential-book --from-file=./username --from-file=./password
rm -rf ./username ./password
kubectl get secret/mariadb-credential-book -o yaml