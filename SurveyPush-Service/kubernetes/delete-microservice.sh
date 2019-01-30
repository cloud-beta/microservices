#!/bin/sh
kubectl delete configmap/config-survey-push
kubectl delete cronjob/schedule-surveypush