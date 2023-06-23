#!/bin/bash
set -eo pipefail

cd /tmp/
PLATFORM=linux64 # Change this line if You're using other platform
VERSION=$(curl http://chromedriver.storage.googleapis.com/LATEST_RELEASE)
curl http://chromedriver.storage.googleapis.com/$VERSION/chromedriver_$PLATFORM.zip -LOk
unzip chromedriver_*
#sudo mv chromedriver /usr/bin/chromedriver
chromedriver --version