#!/bin/bash
cd $PWD/../app
docker build -t cookies-web-app .
docker tag cookies-web-app gcr.io/cookies-web-app/cookies-web-app
docker push gcr.io/cookies-web-app/cookies-web-app
